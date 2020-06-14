package de.churl.cookbook.domain.utility;

import de.churl.cookbook.domain.model.Recipe;
import de.churl.cookbook.persistance.dto.RecipeDTO;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PersistanceHelper {

    public RecipeDTO recipeToDTO(Recipe recipe) {
        return new RecipeDTO(null, recipe.getTitle(), recipe.getDescription(), recipe.getBody());
    }

    public List<RecipeDTO> recipesToDTOs(List<Recipe> recipes) {
        return recipes.stream()
                      .map(PersistanceHelper::recipeToDTO)
                      .collect(Collectors.toUnmodifiableList());
    }

    public Recipe dtoToRecipe(RecipeDTO dto) {
        return new Recipe(dto.getId(), dto.getTitle(), dto.getDescription(), dto.getBody());
    }

    public List<Recipe> dtosToRecipes(Collection<RecipeDTO> dtos) {
        return dtos.stream()
                   .map(PersistanceHelper::dtoToRecipe)
                   .collect(Collectors.toUnmodifiableList());
    }
}
