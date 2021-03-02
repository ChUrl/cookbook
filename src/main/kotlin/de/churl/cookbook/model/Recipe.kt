package de.churl.cookbook.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "recipes")
data class Recipe(
    @Size(max = 127)
    @Column(name = "recipe_title", length = 127)
    var recipeTitle: String,

    @Size(max = 255)
    @Column(name = "recipe_descr", length = 255)
    var recipeDescr: String,

    @Size(max = 8191)
    @Column(name = "recipe_body", length = 8191)
    var recipeBody: String,

    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true)
    var ingrUsages: MutableCollection<IngrUsage> = mutableSetOf()
) {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(name = "recipe_id")
    var recipeID: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")
}
