package com.jeff_media.lightpermsx.bukkit;

import com.jeff_media.lightpermsx.entity.XPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BukkitXPlayer implements XPlayer {

    private final Player player;

    public BukkitXPlayer(Player player) {
        this.player = player;
    }

    @Override
    public UUID getUniqueId() {
        return player.getUniqueId();
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public String getWorldName() {
        return player.getWorld().getName();
    }
}
