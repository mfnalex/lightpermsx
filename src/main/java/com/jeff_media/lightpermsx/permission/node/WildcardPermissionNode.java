package com.jeff_media.lightpermsx.permission.node;

import org.jetbrains.annotations.NotNull;

public class WildcardPermissionNode extends PermissionNode {

    private final String wildcardPrefix;

    protected WildcardPermissionNode(@NotNull String node) {
        super(node);
        wildcardPrefix = node.substring(0, node.length() - 1);
    }

    @Override
    public boolean matches(@NotNull String permissionToCheck) {
        return permissionToCheck.startsWith(wildcardPrefix);
    }
}
