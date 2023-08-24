package com.jeff_media.lightpermsx.group;

import com.jeff_media.lightpermsx.group.Group;
import com.jeff_media.lightpermsx.permission.PermissionState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGroup {

    @Test
    public void testGroupBasics() {
        Group group = new Group("a");
        Assertions.assertSame(PermissionState.UNSET, group.getState("chestsort.use"));
        group.setPermission("chestsort.use", PermissionState.GIVEN);
        Assertions.assertSame(PermissionState.GIVEN, group.getState("chestsort.use"));
        group.setPermission("chestsort.use", PermissionState.NEGATED);
        Assertions.assertSame(PermissionState.NEGATED, group.getState("chestsort.use"));
    }

    @Test
    public void testGroupOrderItself1() {
        Group group = new Group("a");
        group.setPermission("chestsort.*", PermissionState.GIVEN);
        group.setPermission("chestsort.use.inventory", PermissionState.NEGATED);
        Assertions.assertSame(PermissionState.GIVEN, group.getState("chestsort.use"));
        Assertions.assertSame(PermissionState.NEGATED, group.getState("chestsort.use.inventory"));
    }

    @Test
    public void testGroupOrderItself2() {
        Group group = new Group("a");
        group.setPermission("chestsort.*", PermissionState.GIVEN);
        group.setPermission("chestsort.use", PermissionState.NEGATED);
        group.setPermission("chestsort.use.test.*", PermissionState.NEGATED);
        group.setPermission("chestsort.use.test.somethingelse.*", PermissionState.GIVEN);

        Assertions.assertSame(PermissionState.GIVEN, group.getState("chestsort.something"));
        Assertions.assertSame(PermissionState.NEGATED, group.getState("chestsort.use"));
        Assertions.assertSame(PermissionState.GIVEN, group.getState("chestsort.use.inventory"));
        Assertions.assertSame(PermissionState.GIVEN, group.getState("chestsort.use.test"));
        Assertions.assertSame(PermissionState.NEGATED, group.getState("chestsort.use.test.something"));
        Assertions.assertSame(PermissionState.NEGATED, group.getState("chestsort.use.test.somethingelse"));
        Assertions.assertSame(PermissionState.GIVEN, group.getState("chestsort.use.test.somethingelse.subthing"));
    }

    @Test
    public void testAllExceptOne() {
        Group group = new Group("a");
        group.setPermission("*", PermissionState.GIVEN);
        group.setPermission("chestsort.use", PermissionState.NEGATED);
        Assertions.assertSame(PermissionState.GIVEN, group.getState("chestsort.something"));
        Assertions.assertSame(PermissionState.NEGATED, group.getState("chestsort.use"));
    }
}
