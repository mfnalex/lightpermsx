package com.jeff_media.lightpermsx;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Thoughts:
 * chestsort.use:
 *   chestsort.use -> true
 *   chestsort.use.inventory -> false
 *   chestsort.use2 -> false
 * chestsort.*:
 *   chestsort.use -> true
 *   chestsort -> false
 *   chestsort. -> false
 *   chestsort.use.inventory -> true
 */
@EqualsAndHashCode
@Getter
@ToString
public abstract class PermissionNode {

    @NotNull
    private final String node;

    protected PermissionNode(@NotNull String node) {
        this.node = node;
    }

    public abstract boolean matches(@NotNull String permissionToCheck);
}
