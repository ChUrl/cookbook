package de.churl.cookbook.model

import javax.persistence.*

@Entity
@Table(name ="ingredient_usages")
data class IngredientUsage (
        @field: EmbeddedId var ingredientUsageKey : IngredientUsageKey,
        @field: ManyToOne(cascade = [CascadeType.ALL]) @field: MapsId("recipeID") @field: JoinColumn(name = "recipe_id") var recipe : Recipe,
        @field: ManyToOne @field: MapsId("ingrID") @field: JoinColumn(name = "ingr_id") var ingr : Ingredient,
        var amount : Int
        )
