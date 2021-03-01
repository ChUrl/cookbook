package de.churl.cookbook.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "ingredients")
data class Ingredient(
    @Id
    @Column(name = "ingr_id")
    var ingrID: UUID,

    @Size(max = 63)
    @Column(name = "ingr_title", length = 63)
    var ingrTitle: String,

    @Column(name = "ingr_type")
    var ingrType: IngredientType,

    @OneToMany(mappedBy = "ingr")
    var ingrUsages: MutableCollection<IngrUsage>
)
