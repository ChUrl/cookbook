package de.churl.cookbook.model

import javax.persistence.*

@Entity
@Table(name = "ingredient_usages")
data class IngrUsage(
    @EmbeddedId
    var ingrUsageKey: IngrUsageKey,

    @ManyToOne(cascade = [CascadeType.ALL])
    @MapsId("recipeID")
    @JoinColumn(name = "recipe_id")
    var recipe: Recipe,

    @ManyToOne
    @MapsId("ingrID")
    @JoinColumn(name = "ingr_id")
    var ingr: Ingredient,

    var amount: Int
)
