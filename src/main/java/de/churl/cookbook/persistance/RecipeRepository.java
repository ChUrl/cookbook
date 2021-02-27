package de.churl.cookbook.persistance;

import de.churl.cookbook.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, UUID> {

    @Override
    @NonNull
    Collection<Recipe> findAll();

    @Override
    @NonNull
    Collection<Recipe> findAllById(@NonNull Iterable<UUID> ids);

}
