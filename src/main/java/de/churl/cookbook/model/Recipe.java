package de.churl.cookbook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@NoArgsConstructor
public class Recipe {

    @Id
    @Column(name = "recipe_id")
    private UUID recipeID;

    @Size(max = 127)
    @Column(name = "recipe_title", length = 127)
    private String recipeTitle;

    @Size(max = 255)
    @Column(name = "recipe_descr")
    private String recipeDescr;

    @Size(max = 8191)
    @Column(name = "recipe_body", length = 8191)
    private String recipeBody;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<IngredientUsage> ingredientUsages;
}
