package de.churl.cookbook.controller

import de.churl.cookbook.model.IngredientType
import de.churl.cookbook.model.transfer.IngredientDTO
import de.churl.cookbook.model.transfer.RecipeDTO
import de.churl.cookbook.service.PersistenceService
import de.churl.cookbook.util.renderMarkdown
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
class CookbookController(
    private val persistenceService: PersistenceService
) {
    @GetMapping("*")
    fun index(): String {
        return "redirect:/recipes"
    }

    @GetMapping("/recipes")
    fun allRecipes(model: Model): String {
        model["recipes"] = persistenceService.findAllRecipes()

        return "all_recipe_list"
    }

    @GetMapping("/recipes/details/{id}")
    fun recipeDetails(
        @PathVariable("id") id: String,
        model: Model
    ): String {
        val recipe = persistenceService.findRecipeById(id)

        model["recipe"] = recipe
        model["ingredients"] = persistenceService.findAllIngredientsById(recipe.ingrs)
        model["bodyhtml"] = renderMarkdown(recipe.body)

        return "recipe_detail_view"
    }

    @GetMapping("/ingredients")
    fun allIngredients(model: Model): String {
        model["ingrs"] = persistenceService.findAllIngredients()

        return "all_ingr_list"
    }

    @GetMapping("/ingredients/details/{id}")
    fun ingredientDetails(
        @PathVariable("id") id: String,
        model: Model
    ): String {
        model["ingr"] = persistenceService.findIngrById(id)

        return "ingr_detail_view"
    }

    @GetMapping("/ingredients/new")
    fun newIngredientForm(model: Model): String {
        model["ingrTypes"] = IngredientType.values().map { it.toString() }.toList()
        model["dto"] = IngredientDTO()

        return "new_ingr_form"
    }

    @PostMapping("/ingredients/new/submit")
    fun newIngredientSubmit(ingr: IngredientDTO): String {
        val id = persistenceService.saveNewIngredient(ingr)

        return "redirect:/ingredients/details/$id"
    }
}
