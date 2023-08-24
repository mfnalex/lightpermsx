import com.jeff_media.lightpermsx.group.Group;
import com.jeff_media.lightpermsx.permission.PermissionState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestGroupOrder {

    @Test
    public void testGroupOrder() {
        Group defaultGroup = new Group("default");
        Group playerGroup = new Group("player",10);
        Group modGroup = new Group("mod",50);
        Group adminGroup = new Group("admin",100);

        adminGroup.addParent(modGroup);
        modGroup.addParent(playerGroup);
        playerGroup.addParent(defaultGroup);

        List<Group> adminAllParents = adminGroup.getAllParents();
        Assertions.assertEquals(3, adminAllParents.size());
        Assertions.assertEquals(defaultGroup, adminAllParents.get(2));
        Assertions.assertEquals(playerGroup, adminAllParents.get(1));
        Assertions.assertEquals(modGroup, adminAllParents.get(0));
        Assertions.assertSame(defaultGroup, adminAllParents.get(2));
        Assertions.assertNotEquals(playerGroup, adminAllParents.get(2));
    }

    @Test
    public void testPerms() {
        Group defaultGroup = new Group("default");
        Group playerGroup = new Group("player",10);
        Group adminGroup = new Group("admin",100);

        defaultGroup.setPermission("build", PermissionState.NEGATED);
        playerGroup.setPermission("build", PermissionState.GIVEN);
        adminGroup.setPermission("admin", PermissionState.GIVEN);

        playerGroup.addParent(defaultGroup);
        adminGroup.addParent(playerGroup);

        Assertions.assertSame(PermissionState.GIVEN, adminGroup.getState("build"));
        Assertions.assertSame(PermissionState.GIVEN, adminGroup.getState("admin"));
        Assertions.assertSame(PermissionState.GIVEN, playerGroup.getState("build"));
        Assertions.assertSame(PermissionState.UNSET, playerGroup.getState("admin"));
        Assertions.assertSame(PermissionState.NEGATED, defaultGroup.getState("build"));
        Assertions.assertSame(PermissionState.UNSET, defaultGroup.getState("admin"));
    }

}
