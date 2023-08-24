package com.jeff_media.lightpermsx.entity;

import com.jeff_media.lightpermsx.group.Group;
import com.jeff_media.lightpermsx.permission.PermissionState;
import com.jeff_media.lightpermsx.permission.PermissionValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPlayer {

    @Test
    public void testPlayer() {
        XPlayer mfnalex = MockPlayer.mfnalex();
        Assertions.assertFalse(mfnalex.hasPermission("chestsort.use"));
        mfnalex.setPermission("chestsort.use", true);
        Assertions.assertTrue(mfnalex.hasPermission("chestsort.use"));
    }

    @Test
    public void testPlayerInGroup() {
        XPlayer mfnalex = MockPlayer.mfnalex();
        Group group = new Group("test");
        group.setPermission("chestsort.use", true);
        Assertions.assertFalse(mfnalex.hasPermission("chestsort.use"));
        Assertions.assertSame(PermissionState.UNSET, mfnalex.getState("chestsort.use"));
        mfnalex.addParent(group);
        Assertions.assertTrue(mfnalex.hasPermission("chestsort.use"));
        Assertions.assertSame(PermissionState.GIVEN, mfnalex.getState("chestsort.use"));
        mfnalex.setPermission("chestsort.use", false);
        Assertions.assertFalse(mfnalex.hasPermission("chestsort.use"));
        Assertions.assertSame(PermissionState.NEGATED, mfnalex.getState("chestsort.use"));
    }
}
