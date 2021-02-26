package de.churl.cookbook.domain.model;

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
    @MapsId("recipeID")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @MapsId("ingrID")
    @JoinColumn(name = "ingr_id")
    private Ingredient ingredient;

    private Number amount;
}
