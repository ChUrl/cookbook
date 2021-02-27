package de.churl.cookbook.persistance;

import de.churl.cookbook.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RecipeRepository extends CrudRepository<Recipe, UUID> {}
