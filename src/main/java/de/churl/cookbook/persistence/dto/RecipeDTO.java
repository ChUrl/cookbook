package de.churl.cookbook.persistence.dto;

import de.churl.cookbook.domain.model.ingredients.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@AllArgsConstructor
@Data
@Table("RECIPE")
public class RecipeDTO {

    @Id
    Long id;

    String title;
    String description;
    String body;

    @MappedCollection
    Set<IngredientRef> ingredients;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(new IngredientRef(ingredient.getId()));
    }


}
