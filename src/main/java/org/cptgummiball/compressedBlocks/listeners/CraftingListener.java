package org.cptgummiball.compressedBlocks.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.NamespacedKey;
import org.cptgummiball.compressedBlocks.Main;

public class CraftingListener implements Listener {

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack craftedItem = event.getRecipe().getResult();

        // Access to the item's PersistentDataContainer
        PersistentDataContainer data = craftedItem.getItemMeta().getPersistentDataContainer();

        // Check if the item has a "compressed_level" tag
        if (data.has(new NamespacedKey(JavaPlugin.getPlugin(Main.class), "compressed_level"), PersistentDataType.INTEGER)) {
            // If there is a "compressed_level" we know it is a compressed block

            if (!player.hasPermission("compressedblocks.craft")) {
                event.setCancelled(true); // Cancel the crafting
                player.sendMessage("§cYou don't have permission to craft compressed blocks!");
            }
        }
    }
}