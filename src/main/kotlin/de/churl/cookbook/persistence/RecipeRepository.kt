package de.churl.cookbook.persistence

import de.churl.cookbook.model.Recipe
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RecipeRepository : CrudRepository<Recipe, UUID> {

    override fun findAll() : Collection<Recipe>
    override fun findAllById(ids: Iterable<UUID>) : Collection<Recipe>
}
