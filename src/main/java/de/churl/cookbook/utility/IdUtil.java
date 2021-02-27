package de.churl.cookbook.utility;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public final class IdUtil {

    private IdUtil() {}

    public static Collection<UUID> toUUID(Collection<String> ids) {
        return ids.stream()
                  .map(UUID::fromString)
                  .collect(Collectors.toUnmodifiableSet());
    }

    public static UUID toUUID(String id) {
        return UUID.fromString(id);
    }

    public static Collection<String> toString(Collection<UUID> ids) {
        return ids.stream()
                  .map(UUID::toString)
                  .collect(Collectors.toUnmodifiableSet());
    }

    public static String toString(UUID id) {
        return id.toString();
    }
}
