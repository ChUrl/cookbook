package de.churl.cookbook.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "recipes")
data class Recipe(
    @Id
    @Column(name = "recipe_id")
    var recipeID: UUID,

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
    var ingrUsages: MutableCollection<IngrUsage>
)
