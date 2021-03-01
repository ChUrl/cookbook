package de.churl.cookbook.service;

import de.churl.cookbook.exception.IngredientNotFoundException;
import de.churl.cookbook.exception.RecipeNotFoundException;
import de.churl.cookbook.model.Ingredient;
import de.churl.cookbook.model.IngredientType;
import de.churl.cookbook.model.IngredientUsage;
import de.churl.cookbook.model.IngredientUsageKey;
import de.churl.cookbook.model.Recipe;
import de.churl.cookbook.model.transfer.IngredientDTO;
import de.churl.cookbook.model.transfer.RecipeDTO;
import de.churl.cookbook.persistance.IngredientRepository;
import de.churl.cookbook.persistance.RecipeRepository;
import de.churl.cookbook.utility.IdUtil;
import de.churl.cookbook.utility.TransferUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersistenceService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    // Recipe ##########################################################################################################

    public Iterable<RecipeDTO> findAllRecipes() {
        return TransferUtil.recipeToDTO(this.recipeRepository.findAll());
    }

    public RecipeDTO findRecipeById(String id) {
        return this.findRecipeById(IdUtil.toUUID(id));
    }

    public RecipeDTO findRecipeById(UUID id) {
        return TransferUtil.recipeToDTO(this.recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(id)));
    }

    /**
     * Saves a new recipeDTO in the database.
     * The new entity is constructed with a random UUID.
     *
     * @param title The recipeDTO title
     * @param descr The recipeDTO description
     * @param body The recipeDTO body
     * @param ingrs The needed ingrDTOs (List of IDs)
     * @return The id of the saved entity
     */
    public UUID saveNewRecipe(String title, String descr, String body, Collection<UUID> ingrs) {
        final Recipe recipe = new Recipe();
        recipe.setRecipeID(UUID.randomUUID());
        recipe.setRecipeTitle(title);
        recipe.setRecipeDescr(descr);
        recipe.setRecipeBody(body);
        recipe.setIngrUsages(new HashSet<>());

        for (UUID ingr : ingrs) {
            final Optional<Ingredient> ingropt = this.ingredientRepository.findById(ingr);
            final Ingredient ingredient = ingropt.orElseThrow(() -> new IngredientNotFoundException(ingr));
            final IngredientUsage usage = new IngredientUsage();
            final IngredientUsageKey key = new IngredientUsageKey();

            key.setRecipeID(recipe.getRecipeID());
            key.setIngrID(ingr);

            usage.setIngredientUsageKey(key);
            usage.setRecipe(recipe);
            usage.setIngr(ingredient);
            usage.setAmount(1); // TODO: Ingredient Amount
            recipe.getIngrUsages().add(usage);
        }

        return this.recipeRepository.save(recipe).getRecipeID();
    }

    // Ingredient ######################################################################################################

    public Collection<IngredientDTO> findAllIngredients() {
        return TransferUtil.ingrToDTO(this.ingredientRepository.findAll());
    }

    public IngredientDTO findIngredientById(String id) {
        return this.findIngredientById(IdUtil.toUUID(id));
    }

    public IngredientDTO findIngredientById(UUID id) {
        return TransferUtil.ingrToDTO(this.ingredientRepository.findById(id).orElseThrow(() -> new IngredientNotFoundException(id)));
    }

    /**
     * Saves a new ingredient in the database.
     * The new entity is constructed with a random UUID.
     * The IngredientUsages-Set is initialized empty.
     *
     * @param title The ingredient title
     * @param type The ingredient type
     * @return The id of the saved entity
     */
    public UUID saveNewIngredient(String title, String type) {
        final Ingredient ingr = new Ingredient();
        ingr.setIngrID(UUID.randomUUID());
        ingr.setIngrTitle(title);
        ingr.setIngrType(IngredientType.valueOf(type));
        ingr.setIngrUsages(Collections.emptySet());

        return this.ingredientRepository.save(ingr).getIngrID();
    }
}
