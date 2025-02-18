package org.cptgummiball.compressedBlocks.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.NamespacedKey;
import org.cptgummiball.compressedBlocks.Main;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack itemInHand = event.getItemInHand();

        // Access to the item's PersistentDataContainer
        PersistentDataContainer data = itemInHand.getItemMeta().getPersistentDataContainer();

        // Check if the item has a "compressed_level" tag
        if (data.has(new NamespacedKey(JavaPlugin.getPlugin(Main.class), "compressed_level"), PersistentDataType.INTEGER)) {
            // If there is a "compressed_level" we know it is a compressed block
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage("§cYou cannot place a compressed block");
        }
    }
}