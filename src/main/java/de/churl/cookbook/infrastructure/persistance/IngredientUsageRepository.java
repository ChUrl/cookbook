package de.churl.cookbook.infrastructure.persistance;

import de.churl.cookbook.domain.model.IngredientUsage;
import de.churl.cookbook.domain.model.IngredientUsageKey;
import org.springframework.data.repository.CrudRepository;

public interface IngredientUsageRepository extends CrudRepository<IngredientUsage, IngredientUsageKey> {
}
