package de.churl.cookbook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class IngredientUsageKey implements Serializable {

    @Column(name = "recipe_id")
    private UUID recipeID;

    @Column(name = "ingr_id")
    private UUID ingrID;

    @SuppressWarnings("NonFinalFieldReferenceInEquals")
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final IngredientUsageKey that = (IngredientUsageKey) o;
        return this.recipeID.equals(that.recipeID) && this.ingrID.equals(that.ingrID);
    }

    @SuppressWarnings("NonFinalFieldReferencedInHashCode")
    @Override
    public int hashCode() {
        return Objects.hash(this.recipeID, this.ingrID);
    }
}
