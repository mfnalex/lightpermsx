package com.jeff_media.lightpermsx.entity;

import org.bukkit.World;

import java.util.UUID;

public interface XPlayer {
    UUID getUniqueId();
    String getName();
    XWorld getWorld();
}
