package com.jeff_media.lightpermsx.permission;

import com.jeff_media.lightpermsx.permission.node.PermissionNode;
import com.jeff_media.lightpermsx.permission.node.PermissionNodeFactory;

public interface Permissible {

    PermissionState getState(String permission);

    default boolean hasPermission(String permission) {
        return getState(permission) == PermissionState.GIVEN;
    }

    void setPermission(PermissionNode permission, PermissionState value);

    default void setPermission(String permission, PermissionState value) {
        setPermission(PermissionNodeFactory.create(permission), value);
    }

}
