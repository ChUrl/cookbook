package de.churl.cookbook.domain.service;

import de.churl.cookbook.domain.model.Recipe;
import de.churl.cookbook.domain.model.ingredients.Ingredient;
import de.churl.cookbook.domain.utility.PersistenceHelper;
import de.churl.cookbook.persistence.IngredientRepository;
import de.churl.cookbook.persistence.RecipeRepository;
import de.churl.cookbook.persistence.dto.IngredientDTO;
import de.churl.cookbook.persistence.dto.RecipeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersistenceService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    // ###################################### LOAD

    public List<Recipe> findAllRecipes() {
        return PersistenceHelper.dtosToRecipes(recipeRepository.findAll());
    }

    public Recipe findRecipeById(String id) {
        Optional<RecipeDTO> dto = recipeRepository.findById(Long.valueOf(id));

        return PersistenceHelper.dtoToRecipe(dto.orElseThrow());
    }

    public List<Ingredient> findAllIngredients() {
        return PersistenceHelper.dtosToIngredients(ingredientRepository.findAll());
    }

    // ###################################### SAVE

    public void saveNewRecipe(String title, String description, String body) {
        recipeRepository.save(new RecipeDTO(null, title, description, body));
    }

    public void saveNewIngredient(String title, String type) {
        ingredientRepository.save(new IngredientDTO(null, title, type));
    }
}
