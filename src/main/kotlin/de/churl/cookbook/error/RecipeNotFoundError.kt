package de.churl.cookbook.error

import java.util.*

class RecipeNotFoundError(id: UUID) :
    RuntimeException("A Recipe with this ID doesn't exist (id=$id)") {
}
