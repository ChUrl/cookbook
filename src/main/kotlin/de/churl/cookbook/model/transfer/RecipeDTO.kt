package de.churl.cookbook.model.transfer

data class RecipeDTO(
    val title: String = "",
    val descr: String = "",
    val body: String = "",
    val ingrs: Collection<String> = emptySet()
) {
    fun withTitle(title: String): RecipeDTO {
        return RecipeDTO(title, descr, body, ingrs)
    }

    fun withDescr(descr: String): RecipeDTO {
        return RecipeDTO(title, descr, body, ingrs)
    }

    fun withBody(body: String): RecipeDTO {
        return RecipeDTO(title, descr, body, ingrs)
    }

    fun withIngr(ingr: String): RecipeDTO {
        return RecipeDTO(title, descr, body, (ingrs + ingr).distinct().toSet())
    }

    fun withoutIngr(ingr: String): RecipeDTO {
        return RecipeDTO(title, descr, body, (ingrs - ingr).distinct().toSet())
    }
}
