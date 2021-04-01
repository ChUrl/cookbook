package de.churl.cookbook.error

import java.util.*

class IllegalControllerStateError(msg: String) :
    RuntimeException(msg) {
}
