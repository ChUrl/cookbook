package de.churl.cookbook.persistence;

import de.churl.cookbook.persistence.dto.IngredientDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientRepository extends CrudRepository<IngredientDTO, Long> {

    @Override
    List<IngredientDTO> findAll();

    @Query("SELECT * FROM ingredient WHERE title = :name")
    List<IngredientDTO> findByName(@Param("name") String name);
}
