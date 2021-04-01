package de.churl.cookbook.model.amount

class Quantity(
    nom: Int,
    denom: Int
) {
    val nominator: Int
    val denominator: Int

    init {
        val divisor = gcd(nom, denom)
        nominator = nom / divisor
        denominator = denom / divisor
    }

    constructor(nom: Int): this(nom, 1)

    companion object {
        fun fromString(string: String): Quantity {
            val split = string.split("/")
            val nom = split[0].toInt()
            val denom = if (split.size == 2) split[1].toInt() else 1

            return Quantity(nom, denom)
        }
    }

    operator fun times(factor: Int): Quantity {
        return Quantity(
            this.nominator * factor,
            this.denominator
        ).simplify()
    }

    operator fun div(quotient: Int): Quantity {
        return Quantity(
            this.nominator,
            this.denominator * quotient
        ).simplify()
    }

    private fun simplify(): Quantity {
        val divisor = gcd()
        return Quantity(
            nominator / divisor,
        denominator / divisor
        )
    }

    private fun gcd(): Int {
        return gcd(nominator, denominator)
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a;
        return gcd(b,a % b);
    }

    fun singular(): Boolean {
        return nominator == denominator;
    }

    fun print(): String {
        return if (singular()) nominator.toString() else "$nominator/$denominator"
    }
}
