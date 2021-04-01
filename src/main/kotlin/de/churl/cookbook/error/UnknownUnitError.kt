package de.churl.cookbook.error

class UnknownUnitError(symbol: String) :
    RuntimeException("There is no Unit with that symbol (symbol=$symbol)") {
}
