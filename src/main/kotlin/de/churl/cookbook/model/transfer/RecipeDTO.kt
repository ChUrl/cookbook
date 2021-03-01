package de.churl.cookbook.model.transfer

data class RecipeDTO(
    val title: String,
    val descr: String,
    val body: String,
    val ingrs: Map<IngredientDTO, Int>,
    val external: String
)
