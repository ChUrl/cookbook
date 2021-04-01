package de.churl.cookbook.controller

import de.churl.cookbook.error.IngredientNotFoundError
import de.churl.cookbook.model.transfer.IngredientDTO
import de.churl.cookbook.model.transfer.RecipeDTO
import de.churl.cookbook.service.PersistenceService
import de.churl.cookbook.util.toUUID
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.annotation.SessionScope
import java.util.*

@SessionScope
@Controller
@RequestMapping("/recipes/new")
class NewRecipeController(
    private val persistenceService: PersistenceService
) {
    // This is held so ingredients can be added faster
    // (Every ingredient is added separately)
    private var currentRecipe: RecipeDTO = RecipeDTO()
    private var currentIngredients: Map<UUID, IngredientDTO> =
        persistenceService.findAllIngredients()

    @GetMapping("/new")
    fun newNewRecipeForm(): String {
        currentRecipe = RecipeDTO()
        currentIngredients = persistenceService.findAllIngredients()

        return "redirect:/recipes/new"
    }

    @GetMapping()
    fun newRecipeForm(model: Model): String {
        model["ingrDTOs"] = currentIngredients
        model["dto"] = currentRecipe
        model["ingrs"] = currentRecipe.ingrs.associateBy(
            { it },
            { currentIngredients[toUUID(it)]?.title ?: throw IngredientNotFoundError(toUUID(it)) }
        )

        return "new_recipe_form"
    }

    @PostMapping("/ingrs/add")
    fun newRecipeIngrsAdd(@RequestParam("ingr") ingr: String): String {
        if (ingr != "DEFAULT") currentRecipe = currentRecipe.withIngr(ingr)

        return "redirect:/recipes/new"
    }

    @PostMapping("/ingrs/remove/{id}")
    fun newRecipeIngrsRemove(@PathVariable("id") ingr: String): String {
        if (ingr in currentRecipe.ingrs) currentRecipe = currentRecipe.withoutIngr(ingr)

        return "redirect:/recipes/new"
    }

    @PostMapping("/submit")
    fun newRecipeSubmit(
        @RequestParam("title") title: String,
        @RequestParam("descr") descr: String,
        @RequestParam("body") body: String,
    ): String {
        // TODO: validation

        val id = persistenceService.saveNewRecipe(
            currentRecipe.withTitle(title).withDescr(descr).withBody(body)
        )

        currentRecipe = RecipeDTO()

        return "redirect:/recipes/details/$id"
    }
}
