package com.jeff_media.lightpermsx.bukkit.adapter;

import com.jeff_media.lightpermsx.entity.XEnvironment;
import com.jeff_media.lightpermsx.entity.XGameMode;
import com.jeff_media.lightpermsx.entity.XPlayer;
import com.jeff_media.lightpermsx.entity.XWorld;
import lombok.experimental.UtilityClass;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;

@UtilityClass
public class BukkitAdapter {

    XPlayer adapt(Player player) {
        return new BukkitOnlinePlayer(player);
    }

    XWorld adapt(World world) {
        return new BukkitWorld(world);
    }

    XGameMode adapt(GameMode gameMode) {
        switch (gameMode) {
            case SURVIVAL:
                return XGameMode.SURVIVAL;
            case CREATIVE:
                return XGameMode.CREATIVE;
            case ADVENTURE:
                return XGameMode.ADVENTURE;
            case SPECTATOR:
                return XGameMode.SPECTATOR;
            default:
                return XGameMode.UNKNOWN;
        }
    }

    XEnvironment adapt(World.Environment environment) {
        switch (environment) {
            case NORMAL:
                return XEnvironment.NORMAL;
            case NETHER:
                return XEnvironment.NETHER;
            case THE_END:
                return XEnvironment.THE_END;
            default:
                return XEnvironment.UNKNOWN;
        }
    }

}
