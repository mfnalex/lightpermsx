package com.jeff_media.lightpermsx.bukkit.adapter;

import com.jeff_media.lightpermsx.entity.XGameMode;
import com.jeff_media.lightpermsx.entity.XPlayer;
import com.jeff_media.lightpermsx.entity.XWorld;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BukkitOnlinePlayer extends XPlayer {

    private final Player player;

    public BukkitOnlinePlayer(Player player) {
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
    public XWorld getWorld() {
        return BukkitAdapter.adapt(player.getWorld());
    }

    @Override
    public XGameMode getGameMode() {
        return BukkitAdapter.adapt(player.getGameMode());
    }
}
