package de.churl.cookbook.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "ingredients")
data class Ingredient(
    @Size(max = 63)
    @Column(name = "ingr_title", length = 63)
    var ingrTitle: String,

    @Column(name = "ingr_type")
    var ingrType: IngredientType,

    @OneToMany(mappedBy = "ingr")
    var ingrUsages: MutableCollection<IngrUsage> = mutableSetOf()
) {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(name = "ingr_id")
    var ingrID: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")
}
