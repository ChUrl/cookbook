package de.churl.cookbook.model.transfer

import de.churl.cookbook.model.IngredientType

data class IngredientDTO(
    val title: String,
    val type: IngredientType,
    val external: String
)
