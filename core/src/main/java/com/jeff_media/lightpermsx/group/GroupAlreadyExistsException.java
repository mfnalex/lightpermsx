package com.jeff_media.lightpermsx.group;

import lombok.Getter;

@Getter
public class GroupAlreadyExistsException extends IllegalArgumentException {

    private final Group newGroup;
    private final Group existingGroup;

    public GroupAlreadyExistsException(Group newGroup, Group existingGroup) {
        super("Group " + newGroup.getName() + " already exists.");
        this.newGroup = newGroup;
        this.existingGroup = existingGroup;
    }
}
