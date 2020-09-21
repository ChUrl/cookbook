package de.churl.cookbook.persistance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("INGREDIENT")
public class IngredientDTO {

    @Id
    Long id;

    String title;
    int type;
}
