package com.jeff_media.lightpermsx.entity;


import com.jeff_media.lightpermsx.group.Group;
import com.jeff_media.lightpermsx.permission.Permissible;
import com.jeff_media.lightpermsx.permission.PermissionAssignmentList;
import com.jeff_media.lightpermsx.util.SortedUniqueList;

import java.util.UUID;

public abstract class XPlayer implements Permissible {

    private final SortedUniqueList<Group> groups = new SortedUniqueList<>();
    private final PermissionAssignmentList permissions = new PermissionAssignmentList();

    public abstract UUID getUniqueId();
    public abstract String getName();
    public abstract XWorld getWorld();
    public abstract XGameMode getGameMode();
}
