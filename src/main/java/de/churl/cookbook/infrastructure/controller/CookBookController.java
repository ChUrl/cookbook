package de.churl.cookbook.infrastructure.controller;

import de.churl.cookbook.domain.model.Recipe;
import de.churl.cookbook.domain.model.ingredients.IngredientType;
import de.churl.cookbook.domain.service.PersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.asciidoctor.Asciidoctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;

@Log4j2
@RequiredArgsConstructor
@Controller
public class CookBookController {

    private final PersistenceService persistenceService;

    @GetMapping("*")
    public String index(Model model) {
        model.addAttribute("recipes", persistenceService.findAllRecipes());
        return "index";
    }

    @GetMapping("/new")
    public String newRecipe() {
        return "new";
    }

    @PostMapping("/new/submit")
    public String newRecipeSubmit(@RequestParam("recipe_title") String title,
                                  @RequestParam("recipe_desc") String description,
                                  @RequestParam("recipe_body") String body) {

        persistenceService.saveNewRecipe(title, description, body);

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") String id,
                          Model model) {

        Recipe recipe = persistenceService.findRecipeById(id);
        Asciidoctor doc = Asciidoctor.Factory.create();

        String html = doc.convert(recipe.getBody(), new HashMap<>());

        doc.close();

        model.addAttribute("recipe", recipe);
        model.addAttribute("bodyhtml", html);

        return "details";
    }

    @GetMapping("/timeline")
    public String timeline() {
        return "timeline";
    }

    @GetMapping("/ingredients")
    public String ingredients(Model model) {
        model.addAttribute("ingredients", persistenceService.findAllIngredients());

        return "ingredients";
    }

    @GetMapping("/ingredients/new")
    public String newIngredient(Model model) {
        model.addAttribute("types", Arrays.asList(IngredientType.values()));

        return "ingredients_new";
    }

    @PostMapping("/ingredients/new/submit")
    public String newIngredientSubmit(@RequestParam("ingredient_title") String title,
                                      @RequestParam("ingredient_type") String type) {
        persistenceService.saveNewIngredient(title, type);

        return "redirect:/ingredients";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
