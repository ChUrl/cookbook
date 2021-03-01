package de.churl.cookbook.util

import de.churl.cookbook.model.Ingredient
import de.churl.cookbook.model.Recipe
import de.churl.cookbook.model.transfer.IngredientDTO
import de.churl.cookbook.model.transfer.RecipeDTO

fun recipeToDTO(recipes: Collection<Recipe>) : Collection<RecipeDTO> {
    return recipes.map(::recipeToDTO)
}

fun recipeToDTO(recipe: Recipe): RecipeDTO {
    return RecipeDTO(
        recipe.recipeTitle,
        recipe.recipeDescr,
        recipe.recipeBody,
        recipe.ingrUsages.associateBy({ ingrToDTO(it.ingr) }, { it.amount }).toMap(),
        recipe.recipeID.toString()
    )
}

fun ingrToDTO(ingrs: Collection<Ingredient>): Collection<IngredientDTO> {
    return ingrs.map(::ingrToDTO)
}

fun ingrToDTO(ingr: Ingredient): IngredientDTO {
    return IngredientDTO(
        ingr.ingrTitle,
        ingr.ingrType,
        ingr.ingrID.toString()
    )
}
