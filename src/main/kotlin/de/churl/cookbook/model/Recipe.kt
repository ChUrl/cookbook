package de.churl.cookbook.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "recipes")
data class Recipe (
        @field: Id @field: Column(name = "recipe_id") var recipeID : UUID,
        @field: Size(max = 127) @field: Column(name = "recipe_title", length = 127) var recipeTitle : String,
        @field: Size(max = 255) @field: Column(name = "recipe_descr", length = 255) var recipeDescr : String,
        @field: Size(max = 8191) @field: Column(name = "recipe_body", length = 8191) var recipeBody : String,
        @field: OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true) var ingrUsages : Collection<IngredientUsage>
        )
