package com.jeff_media.lightpermsx.group;

import com.jeff_media.lightpermsx.permission.IPermissible;
import com.jeff_media.lightpermsx.permission.node.AbstractPermissible;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(callSuper = true)
@ToString
public class Group extends AbstractPermissible implements IPermissible, Comparable<Group> {

    @NotNull
    private final String name;
    private int priority = 0;

    /**
     * Creates a new group with the given name and priority.
     * @param name name of the group
     * @param priority priority of the group
     */
    public Group(@NotNull String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    /**
     * Creates a new group with the given name and default priority (0).
     * @param name name of the group
     */
    public Group(@NotNull String name) {
        this(name, 0);
    }

    /**
     * Gets the name of this group.
     *
     * @return name
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Returns the priority of this group. Higher priority groups override lower priority groups.
     *
     * @return priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Compare this group to another group by priority.
     * @param o the group to be compared.
     * @return 0 if the groups have the same priority, a negative number if this group has a lower priority, or a positive number if this group has a higher priority.
     */
    @Override
    public int compareTo(@NotNull Group o) {
        return Integer.compare(priority, o.priority);
    }
}