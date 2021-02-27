package de.churl.cookbook.utility;

import de.churl.cookbook.model.Ingredient;
import de.churl.cookbook.model.IngredientUsage;
import de.churl.cookbook.model.Recipe;
import de.churl.cookbook.model.transfer.IngredientDTO;
import de.churl.cookbook.model.transfer.RecipeDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public final class TransferUtil {

    private TransferUtil() {}

    // To DTO ##########################################################################################################

    public static Collection<RecipeDTO> recipeToDTO(Collection<Recipe> recipes) {
        return recipes.stream()
                      .map(TransferUtil::recipeToDTO)
                      .collect(Collectors.toUnmodifiableSet());
    }

    public static RecipeDTO recipeToDTO(Recipe recipe) {
        return new RecipeDTO(recipe.getRecipeTitle(),
                             recipe.getRecipeDescr(),
                             recipe.getRecipeBody(),
                             recipe.getIngrUsages().stream()
                                   .collect(Collectors.toUnmodifiableMap(usage -> ingrToDTO(usage.getIngr()),
                                                                         IngredientUsage::getAmount)),
                             recipe.getRecipeID().toString());
    }

    public static Collection<IngredientDTO> ingrToDTO(Collection<Ingredient> ingredients) {
        return ingredients.stream()
                          .map(TransferUtil::ingrToDTO)
                          .collect(Collectors.toUnmodifiableSet());
    }

    public static IngredientDTO ingrToDTO(Ingredient ingredient) {
        return new IngredientDTO(ingredient.getIngrTitle(),
                                 ingredient.getIngrType(),
                                 ingredient.getIngrID().toString());
    }
}