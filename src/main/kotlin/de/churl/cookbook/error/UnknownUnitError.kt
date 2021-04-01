package de.churl.cookbook.error

class UnknownUnitException(symbol: String) :
    RuntimeException("There is no Unit with that symbol (symbol=$symbol)") {
}
