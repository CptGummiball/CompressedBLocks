package org.cptgummiball.compressedBlocks;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.cptgummiball.compressedBlocks.listeners.LoadListener;
import org.cptgummiball.compressedBlocks.recipes.RecipeManager;

public class Main extends JavaPlugin {

    private static Main instance;
    private RecipeManager recipeManager;
    public static final NamespacedKey COMPRESSED_LEVEL_KEY = new NamespacedKey("compressedblocks", "compressed_level");

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        // Initialize recipe manager
        recipeManager = new RecipeManager(this);
        recipeManager.registerRecipesFromConfig();

        // Register listeners
        new LoadListener(this);

        getLogger().info("CompressedBlocks is running!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CompressedBlocks was disabled!");
    }

    public static Main getInstance() {
        return instance;
    }

    public RecipeManager getRecipeManager() {
        return recipeManager;
    }
}

