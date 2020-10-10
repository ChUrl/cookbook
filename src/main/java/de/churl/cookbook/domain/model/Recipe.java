package de.churl.cookbook.domain.model;

import de.churl.cookbook.domain.model.ingredients.Ingredient;
import lombok.Value;

import java.util.List;

@Value
public class Recipe {

    Long id;

    String title;
    String description;
    String body;

    List<Ingredient> ingredients;
}
