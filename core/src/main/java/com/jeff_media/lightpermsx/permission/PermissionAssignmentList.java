package com.jeff_media.lightpermsx.permission;

import com.jeff_media.lightpermsx.permission.node.PermissionNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PermissionAssignmentList implements IPermissible {

    private static final Comparator<Map.Entry<PermissionNode, PermissionState>> PERMISSION_ENTRY_COMPARATOR = Map.Entry.comparingByKey();

    private final HashMap<PermissionNode, PermissionState> assignedPermissions = new HashMap<>();

    @Override
    public PermissionState getState(String permission) {
        return assignedPermissions.entrySet()
                .stream()
                .filter(entry -> entry.getKey().matches(permission))
                .min(PERMISSION_ENTRY_COMPARATOR)
                .map(Map.Entry::getValue)
                .orElse(PermissionState.UNSET);
    }

    @Override
    public void setPermission(PermissionNode permission, PermissionState value) {
        if (value == PermissionState.UNSET) {
            assignedPermissions.remove(permission);
        } else {
            assignedPermissions.put(permission, value);
        }

    }
}
