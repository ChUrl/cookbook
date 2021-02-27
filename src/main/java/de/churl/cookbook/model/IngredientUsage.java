package de.churl.cookbook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

// Der m:n Join-Table für Ingredient und Recipe.
@Entity
@Table(name = "ingredient_usages")
@Getter
@Setter
@NoArgsConstructor
public class IngredientUsage {

    @EmbeddedId
    private IngredientUsageKey ingredientUsageKey;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("recipeID") // Mapping for the embedded primary key
    @JoinColumn(name = "recipe_id") // Column where to join/"plug in"
    private Recipe recipe;

    @ManyToOne
    @MapsId("ingrID")
    @JoinColumn(name = "ingr_id")
    private Ingredient ingr;

    private Integer amount;
}
