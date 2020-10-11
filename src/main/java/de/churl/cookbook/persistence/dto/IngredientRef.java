package de.churl.cookbook.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("RECIPE_INGREDIENT")
public class IngredientRef {

    Long ingredient;
}
