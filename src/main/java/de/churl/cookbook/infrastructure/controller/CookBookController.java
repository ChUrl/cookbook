package de.churl.cookbook.infrastructure.controller;

import de.churl.cookbook.model.IngredientType;
import de.churl.cookbook.model.transfer.RecipeDTO;
import de.churl.cookbook.service.PersistenceService;
import de.churl.cookbook.utility.IdUtil;
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
import java.util.Set;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Controller
public class CookBookController {

    private final PersistenceService persistenceService;

    @GetMapping("*")
    public String index(Model model) {
        model.addAttribute("recipeDTOs", this.persistenceService.findAllRecipes());

        return "all_recipe_list";
    }

    @GetMapping("/new")
    public String newRecipe(Model model) {
        model.addAttribute("ingrDTOs", this.persistenceService.findAllIngredients());

        return "new_recipe_form";
    }

    @PostMapping("/new/submit")
    public String newRecipeSubmit(@RequestParam("recipe_title") String recipeTitle,
                                  @RequestParam("recipe_descr") String recipeDescr,
                                  @RequestParam("recipe_body") String recipeBody,
                                  @RequestParam("recipe_ingrs") Set<String> recipeIngrs) {

        final UUID recipeID = this.persistenceService.saveNewRecipe(recipeTitle,
                                                                    recipeDescr,
                                                                    recipeBody,
                                                                    IdUtil.toUUID(recipeIngrs));

        return "redirect:/details/" + recipeID;
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") String recipeID,
                          Model model) {

        final RecipeDTO recipeDTO = this.persistenceService.findRecipeById(recipeID);

        // Commonmark Markdown Parser
        final List<Extension> extensions = Arrays.asList(AutolinkExtension.create(),
                                                         StrikethroughExtension.create(),
                                                         InsExtension.create());
        final Parser parser = Parser.builder().extensions(extensions).build();
        final Node node = parser.parse(recipeDTO.getBody());
        final HtmlRenderer render = HtmlRenderer.builder().extensions(extensions).build();

        model.addAttribute("recipeDTO", recipeDTO);
        model.addAttribute("bodyhtml", render.render(node));

        return "recipe_detail_view";
    }

    // TODO: Rezeptkörper, titel, beschreibung bearbeiten
    // @GetMapping("/details/{id}/edit")
    // @PostMapping("/details/{id}/update")

    // TODO: Zutaten hinzufügen, entfernen
    // @GetMapping("/details/{id}/ingrDTOs")
    // @PostMapping("/details/{id}/ingrDTOs/add/{ingredient}")
    // @PostMapping("/details/{id}/ingrDTOs/remove/{ingredient}")

    @GetMapping("/timeline")
    public String timeline() {
        return "timeline";
    }

    @GetMapping("/ingredients")
    public String ingredients(Model model) {
        // TODO: Use service
        model.addAttribute("ingrDTOs", this.persistenceService.findAllIngredients());

        return "all_ingr_list";
    }

    @GetMapping("/ingredients/new")
    public String newIngredient(Model model) {
        // TODO: Move from enum to db table?
        model.addAttribute("ingrTypes", Arrays.asList(IngredientType.values()));

        return "new_ingr_form";
    }

    @PostMapping("/ingredients/new/submit")
    public String newIngredientSubmit(@RequestParam("ingredient_title") String title,
                                      @RequestParam("ingredient_type") String type) {

        final UUID ingrID = this.persistenceService.saveNewIngredient(title, type);

        return "redirect:/ingredients/details/" + ingrID;
    }

    // TODO: @PostMapping("/ingrDTOs/remove")
    // TODO: @GetMapping("/ingrDTOs/details/{id}")

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
