package de.churl.cookbook.model.transfer;

import de.churl.cookbook.model.IngredientType;
import lombok.Value;

@Value
public class IngredientDTO {

    String title;
    IngredientType type;

    String external; // TODO: Don't use the id for this
}
