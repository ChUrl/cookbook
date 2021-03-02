package de.churl.cookbook.persistence

import de.churl.cookbook.model.Ingredient
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IngredientRepository : CrudRepository<Ingredient, UUID> {

    override fun findAll() : Collection<Ingredient>
    override fun findAllById(ids: Iterable<UUID>) : Collection<Ingredient>
}
