package com.jeff_media.lightpermsx.permission;

import com.jeff_media.lightpermsx.permission.node.PermissionNode;
import com.jeff_media.lightpermsx.permission.node.PermissionNodeFactory;

public interface IPermissible {

    PermissionState getState(String permission);

    default boolean hasPermission(String permission) {
        return getState(permission) == PermissionState.GIVEN;
    }

    void setPermission(PermissionNode permission, PermissionState value);

    default void setPermission(String permission, PermissionState value) {
        setPermission(PermissionNodeFactory.create(permission), value);
    }

    default void setPermission(String permission, boolean value) {
        setPermission(PermissionNodeFactory.create(permission), value ? PermissionState.GIVEN : PermissionState.NEGATED);
    }

}
