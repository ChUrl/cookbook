package de.churl.cookbook.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {

    @Id
    @Column(name = "ingr_id")
    private UUID ingrID;

    @Size(max = 63)
    @Column(name = "ingr_title", length = 63)
    private String ingrTitle;

    @Column(name = "ingr_type")
    private IngredientType ingrType;

    @OneToMany(mappedBy = "ingredient")
    Set<IngredientUsage> ingredientUsages;
}
