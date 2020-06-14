package de.churl.cookbook.domain.service;

import de.churl.cookbook.domain.model.Recipe;
import de.churl.cookbook.domain.utility.PersistanceHelper;
import de.churl.cookbook.persistance.RecipeRepository;
import de.churl.cookbook.persistance.dto.RecipeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersistanceService {

    private final RecipeRepository recipeRepository;

    // ###################################### LOAD

    public List<Recipe> findAllRecipes() {
        return PersistanceHelper.dtosToRecipes(recipeRepository.findAll());
    }

    public Recipe findRecipeById(String id) {
        Optional<RecipeDTO> dto = recipeRepository.findById(Long.valueOf(id));

        return PersistanceHelper.dtoToRecipe(dto.orElseThrow());
    }

    // ###################################### SAVE

    public void saveNewRecipe(String title, String description, String body) {
        recipeRepository.save(new RecipeDTO(null, title, description, body));
    }
}
