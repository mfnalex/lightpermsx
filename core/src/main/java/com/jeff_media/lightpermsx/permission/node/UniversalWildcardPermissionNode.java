package com.jeff_media.lightpermsx.permission.node;

import org.jetbrains.annotations.NotNull;

public class UniversalWildcardPermissionNode extends PermissionNode {

    static UniversalWildcardPermissionNode INSTANCE = new UniversalWildcardPermissionNode();

    private UniversalWildcardPermissionNode() {
        super("*");
    }

    @Override
    public boolean matches(@NotNull String permissionToCheck) {
        return true;
    }

}
