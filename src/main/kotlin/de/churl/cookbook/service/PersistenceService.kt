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
    fun findAllRecipes(): Collection<RecipeDTO> {
        return recipeToDTO(recipeRepository.findAll())
    }

    fun findRecipeById(id: String): RecipeDTO {
        return findRecipeById(toUUID(id))
    }

    fun findRecipeById(id: UUID): RecipeDTO {
        return recipeToDTO(recipeRepository.findByIdOrNull(id) ?: throw RecipeNotFoundException(id))
    }

    fun saveNewRecipe(title: String, descr: String, body: String, ingrs: Collection<UUID>): UUID {
        val recipe = Recipe(
            UUID.randomUUID(),
            title,
            descr,
            body,
            HashSet()
        )

        for (id: UUID in ingrs) {
            val ingr = ingrRepository.findByIdOrNull(id) ?: throw IngredientNotFoundException(id)
            val ingrUsageKey = IngrUsageKey(recipe.recipeID, ingr.ingrID)
            val ingrUsage = IngrUsage(ingrUsageKey, recipe, ingr, 1)

            recipe.ingrUsages.add(ingrUsage)
        }

        return recipeRepository.save(recipe).recipeID
    }

    fun findAllIngredients(): Collection<IngredientDTO> {
        return ingrToDTO(ingrRepository.findAll())
    }

    fun findIngrById(id: String): IngredientDTO {
        return findIngrById(toUUID(id))
    }

    fun findIngrById(id: UUID): IngredientDTO {
        return ingrToDTO(ingrRepository.findByIdOrNull(id) ?: throw IngredientNotFoundException(id))
    }

    fun saveNewIngredient(title: String, type: String): UUID {
        val ingr = Ingredient(
            UUID.randomUUID(),
            title,
            IngredientType.valueOf(type),
            HashSet()
        )

        return ingrRepository.save(ingr).ingrID
    }
}
