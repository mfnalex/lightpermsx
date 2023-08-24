package com.jeff_media.lightpermsx.permission.node;

import com.jeff_media.lightpermsx.permission.node.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class TestPermissionNode {

    PermissionNode chestsort_use_inventory = PermissionNodeFactory.create("chestsort.use.inventory");
    PermissionNode chestsort_use = PermissionNodeFactory.create("chestsort.use");
    PermissionNode chestsort_use$ = PermissionNodeFactory.create("chestsort.use*");
    PermissionNode chestsort_use_$ = PermissionNodeFactory.create("chestsort.use.*");
    PermissionNode chestsort = PermissionNodeFactory.create("chestsort");
    PermissionNode chestsort_$ = PermissionNodeFactory.create("chestsort.*");
    PermissionNode chestsort$ = PermissionNodeFactory.create("chestsort*");
    PermissionNode $ = PermissionNodeFactory.create("*");

    @Test
    public void testClazzes() {
        Assertions.assertSame(UniversalWildcardPermissionNode.class, $.getClass());
        Assertions.assertSame(WildcardPermissionNode.class, chestsort_$.getClass());
        Assertions.assertSame(LiteralPermissionNode.class, chestsort$.getClass());
    }

    @Test
    public void testPermissionNode() {

        Assertions.assertTrue(chestsort_use_inventory.matches("chestsort.use.inventory"));
        Assertions.assertFalse(chestsort_use_inventory.matches("chestsort.use"));
        Assertions.assertFalse(chestsort_use_inventory.matches("chestsort"));

        Assertions.assertFalse(chestsort_use.matches("chestsort.use.inventory"));
        Assertions.assertTrue(chestsort_use.matches("chestsort.use"));
        Assertions.assertFalse(chestsort_use.matches("chestsort"));

        Assertions.assertFalse(chestsort_use$.matches("chestsort.use.inventory"));
        Assertions.assertFalse(chestsort_use$.matches("chestsort.use"));
        Assertions.assertTrue(chestsort_use$.matches("chestsort.use*"));
        Assertions.assertFalse(chestsort_use$.matches("chestsort"));

        Assertions.assertTrue(chestsort_use_$.matches("chestsort.use.inventory.asd"));
        Assertions.assertTrue(chestsort_use_$.matches("chestsort.use.inventory"));
        Assertions.assertTrue(chestsort_use_$.matches("chestsort.use."));
        Assertions.assertFalse(chestsort_use_$.matches("chestsort.use"));

        Assertions.assertTrue(chestsort.matches("chestsort"));
        Assertions.assertFalse(chestsort.matches("chestsort.use"));
        Assertions.assertFalse(chestsort.matches("chestsort.use.inventory"));

        Assertions.assertFalse(chestsort_$.matches("chestsort"));
        Assertions.assertTrue(chestsort_$.matches("chestsort.use"));
        Assertions.assertTrue(chestsort_$.matches("chestsort.use.inventory"));

        Assertions.assertFalse(chestsort$.matches("chestsort"));
        Assertions.assertFalse(chestsort$.matches("chestsort.use"));
        Assertions.assertTrue(chestsort$.matches("chestsort*"));

        Assertions.assertTrue($.matches("chestsort"));
        Assertions.assertTrue($.matches("chestsort.use"));
        Assertions.assertTrue($.matches("chestsort.use.inventory"));
    }

    @Test
    public void testHashCode() {
        Set<PermissionNode> set = new HashSet<>();

        set.add(chestsort_use_inventory);
        set.add(PermissionNodeFactory.create(chestsort_use_inventory.getNode()));
        Assertions.assertEquals(1, set.size());

        set.add(chestsort_use);
        set.add(PermissionNodeFactory.create(chestsort_use.getNode()));
        Assertions.assertEquals(2, set.size());

        set.add(chestsort_use$);
        set.add(PermissionNodeFactory.create(chestsort_use$.getNode()));
        Assertions.assertEquals(3, set.size());

        set.add($);
        set.add(PermissionNodeFactory.create($.getNode()));
        Assertions.assertEquals(4, set.size());
    }
}
