package de.churl.cookbook.model

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class IngrUsageKey(
    @Column(name = "recipe_id")
    var recipeID: UUID,

    @Column(name = "ingr_id")
    var ingrID: UUID
) : Serializable
