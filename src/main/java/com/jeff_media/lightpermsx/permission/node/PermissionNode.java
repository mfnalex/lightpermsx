package com.jeff_media.lightpermsx.permission.node;

import lombok.Data;
import org.jetbrains.annotations.NotNull;


@Data
public abstract class PermissionNode {

    @NotNull
    private final String node;

    protected PermissionNode(@NotNull String node) {
        this.node = node;
    }

    public abstract boolean matches(@NotNull String permissionToCheck);
}
