package de.churl.cookbook.error

import java.util.*

class RecipeNotFoundException(id: UUID) :
    RuntimeException("A Recipe with this ID doesn't exist (id=$id)") {
}
