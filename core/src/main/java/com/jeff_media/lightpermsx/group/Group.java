package com.jeff_media.lightpermsx.group;

import com.jeff_media.lightpermsx.permission.Permissible;
import com.jeff_media.lightpermsx.permission.PermissionAssignmentList;
import com.jeff_media.lightpermsx.permission.PermissionState;
import com.jeff_media.lightpermsx.permission.node.PermissionNode;
import com.jeff_media.lightpermsx.util.SortedUniqueList;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@EqualsAndHashCode
@ToString
public class Group implements Permissible, Comparable<Group> {

    private final SortedUniqueList<Group> parents = new SortedUniqueList<>();
    private final PermissionAssignmentList assignments = new PermissionAssignmentList();
    @NotNull private final String name;
    private int priority = 0;

    public Group(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public Group(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the priority of this group. Higher priority groups override lower priority groups.
     * @return priority
     */
    public int getPriority() {
        return priority;
    }

    public void setPermission(PermissionNode node, PermissionState value) {
        assignments.setPermission(node, value);
    }

    @Override
    public PermissionState getState(String permission) {
        PermissionState state = assignments.getState(permission);
        if(state != PermissionState.UNSET) {
            return state;
        }

        List<Group> allParents = getAllParents();
        for(int i = 0; state == PermissionState.UNSET && i < allParents.size(); i++) {
            state = allParents.get(i).getState(permission);
        }
        return state;
    }

    public void addParent(Group parent) {
        parents.add(parent);
    }

    /**
     * Returns an unmodifiable list of parents directly inherited by this group, sorted by priority (highest first)
     * @return list of parents
     */
    public List<Group> getDeclaredParents() {
        return Collections.unmodifiableList(parents);
    }

    /**
     * Returns an unmodifiable list of all parents inherited by this group, sorted by priority (highest first)
     * @return list of parents
     */
    public List<Group> getAllParents() {
        List<Group> allParents = new SortedUniqueList<>();
        for (Group parent : parents) {
            allParents.add(parent);
            allParents.addAll(parent.getAllParents());
        }
        return Collections.unmodifiableList(allParents);
    }

    public boolean removeParent(Group parent) {
        return parents.remove(parent);
    }

    @Override
    public int compareTo(@NotNull Group o) {
        return Integer.compare(priority, o.priority);
    }
}
