package org.cptgummiball.compressedBlocks.recipes;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class RecipeManager {

    private JavaPlugin plugin;

    public RecipeManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerRecipesFromConfig() {
        FileConfiguration config = plugin.getConfig();
        List<String> blockNames = config.getStringList("compressed_blocks");

        for (String blockName : blockNames) {
            try {
                Material material = Material.valueOf(blockName.toUpperCase());
                registerCompressedBlockRecipe(material);
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("Ungültiges Material in der config.yml: " + blockName);
            }
        }
    }

    private void registerCompressedBlockRecipe(Material material) {
        new CompressedBlockRecipe(plugin, material).register();
    }

}

