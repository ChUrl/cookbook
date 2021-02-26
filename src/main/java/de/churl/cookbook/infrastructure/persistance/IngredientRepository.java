package de.churl.cookbook.infrastructure.persistance;

import de.churl.cookbook.domain.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
