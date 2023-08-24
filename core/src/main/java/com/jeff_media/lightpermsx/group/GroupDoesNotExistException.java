package com.jeff_media.lightpermsx.group;

import lombok.Getter;

public class GroupDoesNotExistException extends IllegalArgumentException {

        @Getter private final String groupName;

        public GroupDoesNotExistException(String groupName) {
            super("Group " + groupName + " does not exist.");
            this.groupName = groupName;
        }
}
