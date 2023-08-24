package com.jeff_media.lightpermsx.permission;

import com.jeff_media.lightpermsx.permission.node.PermissionNode;
import lombok.Data;

@Data
public class PermissionValue {

    private final PermissionNode node;
    private PermissionState state = PermissionState.UNSET;
    
}
