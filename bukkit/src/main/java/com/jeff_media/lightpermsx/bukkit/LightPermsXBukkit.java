package com.jeff_media.lightpermsx.bukkit;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public class LightPermsXBukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        World world = new WorldCreator("subdir/myworld").createWorld();
    }
}
