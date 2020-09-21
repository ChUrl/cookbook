package de.churl.cookbook.persistance;

import de.churl.cookbook.persistance.dto.IngredientDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<IngredientDTO, Long> {

    @Override
    List<IngredientDTO> findAll();
}
