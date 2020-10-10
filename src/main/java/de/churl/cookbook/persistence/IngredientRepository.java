package de.churl.cookbook.persistence;

import de.churl.cookbook.persistence.dto.IngredientDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<IngredientDTO, Long> {

    @Override
    List<IngredientDTO> findAll();
}
