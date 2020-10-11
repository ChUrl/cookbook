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

    // TODO: Einen cache einführen, wo Zutaten und Rezepte drinliegen.
    // Dieser wird beim Starten der Anwendung aus den Datenbanken befüllt,
    // während die Anwendung läuft, wird gleichzeitig in den Cache und die Datenbank geschrieben.
    public List<Recipe> findAllRecipes() {
        // TODO: Many to Many wird noch nicht aufgelöst, für jedes Rezept müssen noch die
        // TODO: IngredientRefs zu Ingredients aufgelöst werden.
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

    // Dem Rezept fehlen hiernach noch die Zutaten
    public void saveNewRecipe(String title, String description, String body) {
        //TODO: null bei ingredients sollte keine änderungen an der Tabelle Ingredients vornehmen
        recipeRepository.save(new RecipeDTO(null, title, description, body, null));
    }

    public void saveNewIngredient(String title, String type) {
        ingredientRepository.save(new IngredientDTO(null, title, type));
    }

    public void addIngredientToRecipe(String recipeId, String ingredientId) {

    }

    // ####################################### DELETE

    // TODO: General deletion of things
    public void deleteRecipe(String recipeId) {

    }

    public void deleteIngredient(String title) {

    }

    public void removeIngredientFromRecipe(String recipeId, String ingredientTitle) {

    }
}
