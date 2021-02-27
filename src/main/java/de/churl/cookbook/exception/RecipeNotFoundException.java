package de.churl.cookbook.exception;

import java.util.UUID;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(UUID recipeID) {
        this(recipeID.toString());
    }

    public RecipeNotFoundException(String recipeID) {
        super("A recipeDTO with this ID does not exist (id=" + recipeID + ")");
    }
}
