package com.jeff_media.lightpermsx.bukkit.adapter;

import com.jeff_media.lightpermsx.entity.XEnvironment;
import com.jeff_media.lightpermsx.entity.XWorld;
import org.bukkit.World;

import java.lang.ref.WeakReference;
import java.util.Objects;

public class BukkitWorld implements XWorld {

    private final WeakReference<World> world;


    public BukkitWorld(World world) {
        this.world = new WeakReference<>(world);
    }

    private World getWorld() {
        return Objects.requireNonNull(world.get(), "World has been unloaded");
    }

    @Override
    public String getName() {
        return getWorld().getName();
    }

    @Override
    public XEnvironment getDimension() {
        return BukkitAdapter.adapt(getWorld().getEnvironment());
    }
}
