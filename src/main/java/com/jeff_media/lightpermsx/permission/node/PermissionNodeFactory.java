package com.jeff_media.lightpermsx.permission.node;

public class PermissionNodeFactory {
    public static PermissionNode create(String node) {
        if (node.equals("*")) {
            return UniversalWildcardPermissionNode.INSTANCE;
        } else if (node.endsWith(".*")) {
            return new WildcardPermissionNode(node);
        } else {
            return new LiteralPermissionNode(node);
        }
    }
}
