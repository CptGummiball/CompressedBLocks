package org.cptgummiball.compressedBlocks.listeners;

import org.bukkit.plugin.java.JavaPlugin;

public class LoadListener {

    public LoadListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CraftingListener(), plugin);
    }
}
