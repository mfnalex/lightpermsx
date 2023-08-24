package com.jeff_media.lightpermsx.group;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupManager {

    private final Map<String, Group> groups = new HashMap<>();

    @Nullable
    public Group getGroup(@NotNull String name) {
        return groups.get(name);
    }

    /**
     * Adds a group to the group manager. If a group with the same name already exists, a GroupAlreadyExistsException is thrown.
     *
     * @param group group to add
     * @throws GroupAlreadyExistsException if a group with the same name already exists
     */
    public void addGroup(@NotNull Group group) throws GroupAlreadyExistsException {
        Group existingGroup = groups.get(group.getName());
        if (existingGroup != null) {
            throw new GroupAlreadyExistsException(group, existingGroup);
        }
        groups.put(group.getName(), group);
    }

    /**
     * Removes a group from the group manager. If the group does not exist, a GroupDoesNotExistException is thrown.
     * @param groupName name of the group to remove
     * @return list of groups that were affected by the removal of this group (because they had this group as a parent)
     * @throws GroupDoesNotExistException if the group does not exist
     */
    public List<Group> removeGroup(@NotNull String groupName) throws GroupDoesNotExistException {
        Group toRemove = groups.get(groupName);

        if (toRemove == null) {
            throw new GroupDoesNotExistException(groupName);
        }

        List<Group> affectedGroups = new ArrayList<>();

        for (Group each : groups.values()) {
            boolean removed = each.removeParent(toRemove);
            if (removed) {
                affectedGroups.add(each);
            }
        }

        groups.remove(toRemove.getName());
        return affectedGroups;
    }

}
