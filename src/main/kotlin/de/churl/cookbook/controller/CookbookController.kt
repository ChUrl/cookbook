package de.churl.cookbook.controller

import de.churl.cookbook.model.IngredientType
import de.churl.cookbook.model.transfer.IngredientDTO
import de.churl.cookbook.model.transfer.RecipeDTO
import de.churl.cookbook.service.PersistenceService
import de.churl.cookbook.util.renderMarkdown
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class CookbookController(
    val persistenceService: PersistenceService
) {
    @GetMapping("*")
    fun index(model: Model): String {
        model["recipeDTOs"] = persistenceService.findAllRecipes()

        return "all_recipe_list"
    }

    @GetMapping("/new")
    fun newRecipeForm(model: Model): String {
        model["ingrDTOs"] = persistenceService.findAllIngredients()
        model["dto"] = RecipeDTO("", "", "", emptySet())

        return "new_recipe_form"
    }

    @PostMapping("/new/submit")
    fun newRecipeSubmit(recipe: RecipeDTO): String {
        val recipeID = persistenceService.saveNewRecipe(recipe)

        return "redirect:/details/$recipeID"
    }

    @GetMapping("/details/{id}")
    fun recipeDetails(
        @PathVariable("id") recipeID: String,
        model: Model
    ): String {
        val recipeDTO = persistenceService.findRecipeById(recipeID)

        model["recipeDTO"] = recipeDTO
        model["ingredients"] = persistenceService.findAllIngredientsById(recipeDTO.ingrs)
        model["bodyhtml"] = renderMarkdown(recipeDTO.body)

        return "recipe_detail_view"
    }

    @GetMapping("/ingredients")
    fun allIngredients(model: Model): String {
        model["ingrDTOs"] = persistenceService.findAllIngredients()

        return "all_ingr_list"
    }

    @GetMapping("/ingredients/new")
    fun newIngredientForm(model: Model): String {
        model["ingrTypes"] = IngredientType.values().map { it.toString() }.toList()
        model["dto"] = IngredientDTO("", "")

        return "new_ingr_form"
    }

    @PostMapping("/ingredients/new/submit")
    fun newIngredientSubmit(ingr: IngredientDTO): String {
        val ingrID = persistenceService.saveNewIngredient(ingr)

        return "redirect:/ingredients/details/$ingrID"
    }

    @GetMapping("/ingredients/details/{id}")
    fun ingredientDetails(
        @PathVariable("id") ingrID: String,
        model: Model
    ): String {
        return "ingr_detail_view"
    }
}
