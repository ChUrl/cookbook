package de.churl.cookbook.persistance;

import de.churl.cookbook.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, UUID> {

    @Override
    @NonNull
    Collection<Ingredient> findAll();

    @Override
    @NonNull
    Collection<Ingredient> findAllById(@NonNull Iterable<UUID> ids);
}
