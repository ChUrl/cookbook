package de.churl.cookbook.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("RECIPE")
public class RecipeDTO {

    @Id
    Long id;

    String title;
    String description;
    String body;
}
