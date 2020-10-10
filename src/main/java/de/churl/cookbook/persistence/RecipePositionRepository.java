package de.churl.cookbook.persistence;

import de.churl.cookbook.persistence.dto.RecipePositionDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipePositionRepository extends CrudRepository<RecipePositionDTO, Long> {

    @Query("SELECT * FROM recipe_position WHERE recipe_id = :recipe")
    List<RecipePositionDTO> findAllByRecipe(@Param("recipe") Long recipeId);

    @Query("SELECT recipe_id FROM recipe_position WHERE ingredient_id = :ingredient")
    List<Long> FindAllByIngredient(@Param("ingredient") Long ingredientId);
}
