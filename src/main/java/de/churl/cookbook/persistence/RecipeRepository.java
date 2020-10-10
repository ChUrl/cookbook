package de.churl.cookbook.persistence;

import de.churl.cookbook.persistence.dto.RecipeDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeDTO, Long> {

    @Override
    List<RecipeDTO> findAll();

    @Query("SELECT * FROM recipe WHERE title = :name")
    List<RecipeDTO> findByName(@Param("name") String name);
}
