package de.churl.cookbook.controller

import de.churl.cookbook.model.IngredientType
import de.churl.cookbook.service.PersistenceService
import de.churl.cookbook.util.toUUID
import org.commonmark.ext.autolink.AutolinkExtension
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension
import org.commonmark.ext.ins.InsExtension
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

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

        return "new_recipe_form"
    }

    @PostMapping("/new/submit")
    fun newRecipeSubmit(
        @RequestParam("recipe_title") recipeTitle: String,
        @RequestParam("recipe_descr") recipeDescr: String,
        @RequestParam("recipe_body") recipeBody: String,
        @RequestParam("recipe_ingrs") recipeIngrs: Collection<String>
    ): String {
        val recipeID = persistenceService.saveNewRecipe(
            recipeTitle,
            recipeDescr,
            recipeBody,
            toUUID(recipeIngrs)
        )

        return "redirect:/details/$recipeID"
    }

    @GetMapping("/details/{id}")
    fun recipeDetails(
        @PathVariable("id") recipeID: String,
        model: Model
    ): String {
        val recipeDTO = persistenceService.findRecipeById(recipeID)

        val extensions = listOf(
            AutolinkExtension.create(),
            StrikethroughExtension.create(),
            InsExtension.create()
        )
        val parser = Parser.builder().extensions(extensions).build()
        val node = parser.parse(recipeDTO.body)
        val render = HtmlRenderer.builder().extensions(extensions).build()

        model["recipeDTO"] = recipeDTO
        model["bodyhtml"] = render.render(node)

        return "recipe_detail_view"
    }

    @GetMapping("/ingredients")
    fun allIngredients(model: Model): String {
        model["ingrDTOs"] = persistenceService.findAllIngredients()

        return "all_ingr_list"
    }

    @GetMapping("/ingredients/new")
    fun newIngredientForm(model: Model): String {
        model["ingrTypes"] = listOf(IngredientType.values())

        return "new_ingr_form"
    }

    @PostMapping("/ingredients/new/submit")
    fun newIngredientSubmit(
        @RequestParam("ingr_title") title: String,
        @RequestParam("ingr_type") type: String
    ): String {
        val ingrID = persistenceService.saveNewIngredient(title, type)

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
