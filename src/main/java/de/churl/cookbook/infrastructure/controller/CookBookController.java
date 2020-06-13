package de.churl.cookbook.infrastructure.controller;

import de.churl.cookbook.domain.model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CookBookController {

    @GetMapping("*")
    public String index(Model model) {
        model.addAttribute("recipes",
                           List.of(new Recipe("Brei", "", ""),
                                   new Recipe("Soße", "", ""),
                                   new Recipe("Kartoffel", "", ""),
                                   new Recipe("Cola", "", ""),
                                   new Recipe("Sauerkraut", "", ""),
                                   new Recipe("Reis", "", ""),
                                   new Recipe("Wasser", "", ""),
                                   new Recipe("Braten", "", ""),
                                   new Recipe("Gnocci", "", ""),
                                   new Recipe("Brokkoli", "", ""),
                                   new Recipe("Vodka", "", "")));
        return "index";
    }

    @GetMapping("/new")
    public String newRecipe() {
        return "new";
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
