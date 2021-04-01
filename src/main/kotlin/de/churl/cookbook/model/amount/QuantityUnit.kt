package de.churl.cookbook.model.amount

import de.churl.cookbook.error.UnknownUnitException

data class QuantityUnit(
    val nameSingular: String,
    val namePlural: String,
    val symbol: String,
) {
    companion object {
        val symbolSet = setOf("l", "g", "El", "Pr", "T", "Ms")

        fun fromString(string: String): QuantityUnit {
            return when (string) {
                "l" -> unitLitre()
                "g" -> unitGram()
                "EL" -> unitSpoon()
                "Pr" -> unitPraise()
                "T" -> unitCup()
                "Ms" -> unitKnife()
                else -> throw UnknownUnitException(string)
            }
        }

        fun unitLitre(): QuantityUnit {
            return QuantityUnit("Liter", "Liter", "l")
        }

        fun unitGram(): QuantityUnit {
            return QuantityUnit("Gramm", "Gramm", "g")
        }

        fun unitSpoon(): QuantityUnit {
            return QuantityUnit("Esslöffel", "Esslöffel", "El")
        }

        fun unitPraise(): QuantityUnit {
            return QuantityUnit("Priese", "Priesen", "Pr")
        }

        fun unitCup(): QuantityUnit {
            return QuantityUnit("Tasse", "Tassen", "T")
        }

        fun unitKnife(): QuantityUnit {
            return QuantityUnit("Messerspitze", "Messerspitzen", "Ms")
        }
    }
}
