package com.jeff_media.lightpermsx.permission.node;

import lombok.Data;
import org.jetbrains.annotations.NotNull;


@Data
public abstract class PermissionNode implements Comparable<PermissionNode> {

    @NotNull
    private final String node;

    protected PermissionNode(@NotNull String node) {
        this.node = node;
    }

    public abstract boolean matches(@NotNull String permissionToCheck);

    @Override
    public int compareTo(@NotNull PermissionNode o) {
        int myLength = node.length();
        int otherLength = o.node.length();
        return -Integer.compare(myLength, otherLength);
    }
}
