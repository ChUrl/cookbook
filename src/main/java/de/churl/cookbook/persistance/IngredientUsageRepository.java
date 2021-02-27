package de.churl.cookbook.persistance;

import de.churl.cookbook.model.IngredientUsage;
import de.churl.cookbook.model.IngredientUsageKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientUsageRepository extends CrudRepository<IngredientUsage, IngredientUsageKey> {
}
