package de.churl.cookbook.persistance;

import de.churl.cookbook.persistance.dto.RecipeDTO;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Long, RecipeDTO> {
}
