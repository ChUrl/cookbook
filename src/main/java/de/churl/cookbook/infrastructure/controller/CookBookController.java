package de.churl.cookbook.infrastructure.controller;

import de.churl.cookbook.domain.service.PersistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class CookBookController {

    private final PersistanceService persistanceService;

    @GetMapping("*")
    public String index(Model model) {
        model.addAttribute("recipes", persistanceService.findAllRecipes());
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

        persistanceService.saveNewRecipe(title, description, body);

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") String id,
                          Model model) {

        model.addAttribute("recipe", persistanceService.findRecipeById(id));

        return "details";
    }

    @GetMapping("/timeline")
    public String timeline() {
        return "timeline";
    }

    @GetMapping("/ingredients")
    public String ingredients() {
        return "ingredients";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
