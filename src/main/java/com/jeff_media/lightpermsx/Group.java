package com.jeff_media.lightpermsx;

import com.jeff_media.lightpermsx.permission.node.PermissionNode;

import java.util.*;

public class Group {

    private Map<PermissionNode, PermissionValue> assignedPermissions = new HashMap<>();
    private int priority = 0;

    public void addPermission(PermissionNode node, PermissionValue value) {
        assignedPermissions.put(node, value);
    }

}
