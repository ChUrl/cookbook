package de.churl.cookbook.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("RECIPE_POSITION")
public class RecipePositionDTO {

    @Id
    Long id;

    Long recipeId;
    Long ingredientId;
}
