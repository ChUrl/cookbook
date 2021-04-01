package de.churl.cookbook.util

import java.util.*

fun toUUID(ids: Collection<String>): Collection<UUID> {
    return ids.map { UUID.fromString(it) }
}

fun toUUID(id: String): UUID {
    return UUID.fromString(id)
}

fun emptyUUID(): UUID {
    return UUID.fromString("00000000-0000-0000-0000-000000000000")
}

fun UUIDisEmpty(id: UUID): Boolean {
    return id.equals(emptyUUID())
}
