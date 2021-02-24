package de.churl.cookbook.domain.utility;

import de.churl.cookbook.domain.model.Recipe;
import de.churl.cookbook.domain.model.ingredients.Ingredient;
import de.churl.cookbook.domain.model.ingredients.IngredientType;
import de.churl.cookbook.persistence.dto.IngredientDTO;
import de.churl.cookbook.persistence.dto.IngredientRef;
import de.churl.cookbook.persistence.dto.RecipeDTO;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PersistenceHelper {

    // Recipes

    public RecipeDTO recipeToDTO(Recipe recipe) {
        return new RecipeDTO(null, recipe.getTitle(), recipe.getDescription(), recipe.getBody(),
                             recipe.getIngredients().stream()
                                   .map(ingredient -> new IngredientRef(ingredient.getId()))
                                   .collect(Collectors.toSet()));
    }

    public List<RecipeDTO> recipesToDTOs(List<Recipe> recipes) {
        return recipes.stream()
                      .map(PersistenceHelper::recipeToDTO)
                      .collect(Collectors.toUnmodifiableList());
    }

    public Recipe dtoToRecipe(RecipeDTO dto) {
        return new Recipe(dto.getId(), dto.getTitle(), dto.getDescription(), dto.getBody(), new HashSet<>());
    }

    public List<Recipe> dtosToRecipes(List<RecipeDTO> dtos, Iterable<IngredientDTO> ingredientDTOs) {
        // TODO
        return null;
    }

    // Ingredients

    public IngredientDTO ingredientToDTO(Ingredient ingredient) {
        return new IngredientDTO(null, ingredient.getTitle(), ingredient.getType().toString());
    }

    public List<IngredientDTO> ingredientsToDTOs(List<Ingredient> ingredients) {
        return ingredients.stream()
                          .map(PersistenceHelper::ingredientToDTO)
                          .collect(Collectors.toUnmodifiableList());
    }

    public Ingredient dtoToIngredient(IngredientDTO dto) {
        return new Ingredient(dto.getId(), dto.getTitle(), IngredientType.valueOf(dto.getType()));
    }

    public List<Ingredient> dtosToIngredients(List<IngredientDTO> dtos) {
        return dtos.stream()
                   .map(PersistenceHelper::dtoToIngredient)
                   .collect(Collectors.toUnmodifiableList());
    }
}
