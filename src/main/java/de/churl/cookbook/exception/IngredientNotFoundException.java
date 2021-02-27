package de.churl.cookbook.exception;

import java.util.UUID;

public class IngredientNotFoundException extends RuntimeException {

    public IngredientNotFoundException(UUID ingrID) {
        this(ingrID.toString());
    }

    public IngredientNotFoundException(String ingrID) {
        super("An ingredient with this ID does not exist (id=" + ingrID + ")");
    }
}
