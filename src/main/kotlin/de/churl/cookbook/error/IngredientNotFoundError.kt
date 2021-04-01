package de.churl.cookbook.error

import java.util.*

class IngredientNotFoundException(id: UUID) :
    RuntimeException("An Ingredient with this ID doesn't exist (id=$id)") {
}
