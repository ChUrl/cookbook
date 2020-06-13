package de.churl.cookbook.domain.model;

import lombok.Value;

@Value
public class Recipe {

    String title;
    String description;
    String body;
}
