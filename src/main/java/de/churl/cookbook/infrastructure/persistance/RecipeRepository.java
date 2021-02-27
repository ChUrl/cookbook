package de.churl.cookbook.infrastructure.persistance;

import de.churl.cookbook.domain.model.IngredientUsage;
import de.churl.cookbook.domain.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RecipeRepository extends CrudRepository<Recipe, UUID> {}
