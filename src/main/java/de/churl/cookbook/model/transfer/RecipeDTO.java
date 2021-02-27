package de.churl.cookbook.model.transfer;

import lombok.Value;
import java.util.Map;

@Value
public class RecipeDTO {

    String title;
    String descr;
    String body;
    Map<IngredientDTO, Integer> ingredients;

    String external; // TODO: Don't use the id for this
}