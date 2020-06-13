package de.churl.cookbook.persistance;

import de.churl.cookbook.persistance.dto.RecipeDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeDTO, Long> {

    @Override
    List<RecipeDTO> findAll();
}
