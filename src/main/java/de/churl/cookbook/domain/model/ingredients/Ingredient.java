package de.churl.cookbook.domain.model.ingredients;

import lombok.Value;

@Value
public class Ingredient {

    String title;
    IngredientType type;
}
