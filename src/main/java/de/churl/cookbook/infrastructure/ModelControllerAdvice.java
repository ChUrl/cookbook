package de.churl.cookbook.infrastructure;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ModelControllerAdvice {

    // Before each RequestMapping
    @ModelAttribute
    public void modelAttributes(Model model) {

    }
}
