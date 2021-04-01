package de.churl.cookbook.model.amount

data class Amount(
    val quantity: Quantity,
    val unit: QuantityUnit
) {
    companion object {
        fun fromString(string: String): Amount {
            val split = string.split(" ") // TODO: fishy
            return Amount(
                Quantity.fromString(split[0]),
                QuantityUnit.fromString(split[1])
            )
        }
    }

    fun print(): String {
        return quantity.print() + if (quantity.singular()) unit.nameSingular else unit.namePlural
    }
}
