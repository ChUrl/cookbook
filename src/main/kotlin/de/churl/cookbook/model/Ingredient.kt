package de.churl.cookbook.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "ingredients")
data class Ingredient (
        @field: Id @field: Column(name = "ingr_id") var ingrID: UUID,
        @field: Size(max = 63) @field: Column(name = "ingr_title", length = 63) var ingrTitle : String,
        @field: Column(name = "ingr_type") var ingrType: IngredientType,
        @field: OneToMany(mappedBy = "ingr") var ingrUsages: Collection<IngredientUsage>
        )
