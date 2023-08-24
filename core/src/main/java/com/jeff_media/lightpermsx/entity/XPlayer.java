package com.jeff_media.lightpermsx.entity;


import com.jeff_media.lightpermsx.group.Group;
import com.jeff_media.lightpermsx.permission.IPermissible;
import com.jeff_media.lightpermsx.permission.PermissionAssignmentList;
import com.jeff_media.lightpermsx.permission.node.AbstractPermissible;
import com.jeff_media.lightpermsx.util.SortedUniqueList;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public abstract class XPlayer extends AbstractPermissible implements IPermissible {

    @Nullable public abstract UUID getUniqueId();
    @Nullable public abstract String getName();
    @Nullable public abstract XWorld getWorld();
    @Nullable public abstract XGameMode getGameMode();

}
