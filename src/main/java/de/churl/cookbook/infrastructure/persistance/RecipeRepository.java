package de.churl.cookbook.infrastructure.persistance;

import de.churl.cookbook.domain.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
