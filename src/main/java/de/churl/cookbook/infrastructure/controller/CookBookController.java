package de.churl.cookbook.infrastructure.controller;

import de.churl.cookbook.domain.model.Ingredient;
import de.churl.cookbook.domain.model.IngredientType;
import de.churl.cookbook.domain.model.Recipe;
import de.churl.cookbook.domain.service.PersistenceService;
import de.churl.cookbook.infrastructure.persistance.IngredientRepository;
import de.churl.cookbook.infrastructure.persistance.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.commonmark.Extension;
import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.ins.InsExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Controller
public class CookBookController {

    private final PersistenceService persistenceService;

    // TODO: Move to service
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @GetMapping("*")
    public String index(Model model) {
        model.addAttribute("recipes", this.recipeRepository.findAll());

        return "index";
    }

    @GetMapping("/new")
    public String newRecipe() {
        return "new";
    }

    // TODO: Im Form müssen die Zutaten ausgewählt werden
    @PostMapping("/new/submit")
    public String newRecipeSubmit(@RequestParam("recipe_title") String title,
                                  @RequestParam("recipe_desc") String description,
                                  @RequestParam("recipe_body") String body) {

        // TODO: Move to service
        final Recipe r = new Recipe();
        r.setRecipeTitle(title);
        r.setRecipeDescr(description);
        r.setRecipeBody(body);
        this.recipeRepository.save(r);
        // TODO: Hier muss die ID geholt werden und auf die Zutatenseite verlinkt werden.

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") String id,
                          Model model) {

        final Optional<Recipe> ropt = this.recipeRepository.findById(Integer.parseInt(id));
        if (ropt.isPresent()) {

            final List<Extension> extensions = Arrays.asList(AutolinkExtension.create(),
                                                             StrikethroughExtension.create(),
                                                             InsExtension.create());

            final Recipe recipe = ropt.get();
            final Parser parser = Parser.builder().extensions(extensions).build();
            final Node node = parser.parse(recipe.getRecipeBody());
            final HtmlRenderer render = HtmlRenderer.builder().extensions(extensions).build();

            model.addAttribute("recipe", recipe);
            model.addAttribute("bodyhtml", render.render(node));
        }

        return "details";
    }

    // TODO: Rezeptkörper, titel, beschreibung bearbeiten
    // @GetMapping("/details/{id}/edit")
    // @PostMapping("/details/{id}/update")

    // TODO: Zutaten hinzufügen, entfernen
    // @GetMapping("/details/{id}/ingredients")
    // @PostMapping("/details/{id}/ingredients/add/{ingredient}")
    // @PostMapping("/details/{id}/ingredients/remove/{ingredient}")

    @GetMapping("/timeline")
    public String timeline() {
        return "timeline";
    }

    @GetMapping("/ingredients")
    public String ingredients(Model model) {
        // TODO: Use service
        model.addAttribute("ingredients", this.ingredientRepository.findAll());

        return "ingredients";
    }

    @GetMapping("/ingredients/new")
    public String newIngredient(Model model) {
        // TODO: Move from enum to db table?
        model.addAttribute("types", Arrays.asList(IngredientType.values()));

        return "ingredients_new";
    }

    @PostMapping("/ingredients/new/submit")
    public String newIngredientSubmit(@RequestParam("ingredient_title") String title,
                                      @RequestParam("ingredient_type") String type) {
        // TODO: Move to service
        final Ingredient ingredient = new Ingredient();
        ingredient.setIngrTitle(title);
        ingredient.setIngrType(IngredientType.valueOf(type));
        this.ingredientRepository.save(ingredient);

        return "redirect:/ingredients";
    }

    // TODO: @PostMapping("/ingredients/remove")

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
