package com.jeff_media.lightpermsx.permission.node;

import com.jeff_media.lightpermsx.group.Group;
import com.jeff_media.lightpermsx.permission.IPermissible;
import com.jeff_media.lightpermsx.permission.PermissionAssignmentList;
import com.jeff_media.lightpermsx.permission.PermissionState;
import com.jeff_media.lightpermsx.util.SortedUniqueList;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@EqualsAndHashCode
@ToString
public abstract class AbstractPermissible implements IPermissible {

    private final SortedUniqueList<Group> parents = new SortedUniqueList<>();
    //private final TreeSet<Group> parents = new TreeSet<>();
    private final PermissionAssignmentList assignments = new PermissionAssignmentList();


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
     *
     * @return list of parents
     */
    public Collection<Group> getDeclaredParents() {
        return Collections.unmodifiableCollection(parents);
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
}
