package de.churl.cookbook.persistance.dto;

import lombok.Data;

@Data
public class RecipeDTO {

    Long id;
    String title;
    String description;
    String body;
}
