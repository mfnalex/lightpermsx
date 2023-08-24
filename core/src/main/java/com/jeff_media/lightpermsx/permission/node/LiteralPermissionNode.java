package com.jeff_media.lightpermsx.permission.node;

import org.jetbrains.annotations.NotNull;

public class LiteralPermissionNode extends PermissionNode {

    protected LiteralPermissionNode(@NotNull String node) {
        super(node);
    }

    @Override
    public boolean matches(@NotNull String permissionToCheck) {
        return getNode().equals(permissionToCheck);
    }
}
