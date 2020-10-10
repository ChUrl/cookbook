package de.churl.cookbook.domain.model.ingredients;

import lombok.Value;

@Value
public class Ingredient {

    Long id;

    String title;
    IngredientType type;
}
