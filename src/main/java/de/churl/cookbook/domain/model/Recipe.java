package de.churl.cookbook.domain.model;

import lombok.Value;

@Value
public class Recipe {

    Long id;

    String title;
    String description;
    String body;
}
