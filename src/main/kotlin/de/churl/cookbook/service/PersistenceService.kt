package de.churl.cookbook.service

import de.churl.cookbook.error.IngredientNotFoundException
import de.churl.cookbook.error.RecipeNotFoundException
import de.churl.cookbook.model.*
import de.churl.cookbook.model.transfer.IngredientDTO
import de.churl.cookbook.model.transfer.RecipeDTO
import de.churl.cookbook.persistence.IngredientRepository
import de.churl.cookbook.persistence.RecipeRepository
import de.churl.cookbook.util.ingrToDTO
import de.churl.cookbook.util.recipeToDTO
import de.churl.cookbook.util.toUUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashSet

@Service
class PersistenceService(
    val ingrRepository: IngredientRepository,
    val recipeRepository: RecipeRepository
) {
    // FIND RECIPES ################################################################################

    fun findAllRecipes(): Map<UUID, RecipeDTO> {
        return recipeRepository.findAll().associateBy({ it.recipeID }, { recipeToDTO(it) })
    }

    fun findRecipeById(id: String): RecipeDTO {
        return findRecipeById(toUUID(id))
    }

    fun findRecipeById(id: UUID): RecipeDTO {
        return recipeToDTO(recipeRepository.findByIdOrNull(id) ?: throw RecipeNotFoundException(id))
    }

    // SAVE RECIPES ################################################################################

    fun saveNewRecipe(recipe: RecipeDTO): UUID {
        return saveNewRecipe(
            recipe.title,
            recipe.descr,
            recipe.body,
            toUUID(recipe.ingrs)
        )
    }

    fun saveNewRecipe(title: String, descr: String, body: String, ingrs: Collection<UUID>): UUID {
        val recipe = Recipe(
            title,
            descr,
            body
        )

        for (id: UUID in ingrs) {
            val ingr = ingrRepository.findByIdOrNull(id) ?: throw IngredientNotFoundException(id)
            val ingrUsageKey = IngrUsageKey(recipe.recipeID, ingr.ingrID)
            val ingrUsage = IngrUsage(ingrUsageKey, recipe, ingr, 1)

            recipe.ingrUsages.add(ingrUsage)
        }

        return recipeRepository.save(recipe).recipeID
    }

    // FIND INGRS ##################################################################################

    fun findAllIngredients(): Map<UUID, IngredientDTO> {
        return ingrRepository.findAll().associateBy({ it.ingrID }, { ingrToDTO(it) })
    }

    fun findAllIngredientsById(ids: Collection<String>): Collection<IngredientDTO> {
        return ingrToDTO(ingrRepository.findAllById(toUUID(ids)))
    }

    fun findIngrById(id: String): IngredientDTO {
        return findIngrById(toUUID(id))
    }

    fun findIngrById(id: UUID): IngredientDTO {
        return ingrToDTO(ingrRepository.findByIdOrNull(id) ?: throw IngredientNotFoundException(id))
    }

    // SAVE INGRS ##################################################################################

    fun saveNewIngredient(ingr: IngredientDTO): UUID {
        return saveNewIngredient(ingr.title, ingr.type)
    }

    fun saveNewIngredient(title: String, type: String): UUID {
        val ingr = Ingredient(
            title,
            IngredientType.valueOf(type)
        )

        return ingrRepository.save(ingr).ingrID
    }
}
