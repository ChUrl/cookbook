package de.churl.cookbook.util

import java.util.*

fun toUUID(ids: Collection<String>): Collection<UUID> {
    return ids.map { UUID.fromString(it) }
}

fun toUUID(id: String): UUID {
    return UUID.fromString(id)
}
