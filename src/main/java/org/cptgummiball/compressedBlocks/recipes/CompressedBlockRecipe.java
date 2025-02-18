package org.cptgummiball.compressedBlocks.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class CompressedBlockRecipe {

    private JavaPlugin plugin;
    private String blockName;
    private Material baseMaterial;

    public CompressedBlockRecipe(JavaPlugin plugin, Material material) {
        this.plugin = plugin;
        this.baseMaterial = material;
        this.blockName = material.toString();
    }

    public void register() {
        for (int i = 1; i <= 4; i++) {
            registerCompressionRecipe(i);
            registerDecompressionRecipe(i);
        }
    }

    private void registerCompressionRecipe(int level) {
        ItemStack compressedBlock = createCompressedBlock(level).toItemStack();
        NamespacedKey key = new NamespacedKey(plugin, blockName.toLowerCase() + "_compressed_" + level);

        ShapedRecipe recipe = new ShapedRecipe(key, compressedBlock);
        recipe.shape("XXX", "XXX", "XXX");

        if (level == 1) {
            recipe.setIngredient('X', baseMaterial);
        } else {
            recipe.setIngredient('X', createCompressedBlock(level - 1));
        }

        Bukkit.addRecipe(recipe);
    }


    private void registerDecompressionRecipe(int level) {
        ItemStack decompressedBlock = (level == 1) ? new ItemStack(baseMaterial, 9) : createCompressedBlock(level - 1, 9);
        NamespacedKey key = new NamespacedKey(plugin, blockName.toLowerCase() + "_decompressed_" + level);

        ShapedRecipe recipe = new ShapedRecipe(key, decompressedBlock);
        recipe.shape("X");
        recipe.setIngredient('X', createCompressedBlock(level));

        Bukkit.addRecipe(recipe);
    }

    private MaterialData createCompressedBlock(int level) {
        return createCompressedBlock(level, 1).getData();
    }

    private ItemStack createCompressedBlock(int level, int amount) {
        ItemStack item = new ItemStack(baseMaterial, amount);
        ItemMeta meta = item.getItemMeta();

        String displayName = getCompressedBlockDisplayName(level);
        meta.setDisplayName(displayName);

        // Set Lore-Text
        String loreText = "Contains " + (int) Math.pow(9, level) + " blocks of " + blockName.replace("_", " ") + ".";
        meta.setLore(java.util.Collections.singletonList(loreText));

        // Saving the compression level to the PersistentDataContainer of the item
        PersistentDataContainer data = meta.getPersistentDataContainer();
        data.set(new NamespacedKey(plugin, "compressed_level"), PersistentDataType.INTEGER, level);

        item.setItemMeta(meta);
        return item;
    }

    private String getCompressedBlockDisplayName(int level) {
        String blockDisplayName = blockName.replace("_", " ").toLowerCase();
        switch (level) {
            case 1:
                return "Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 2:
                return "Double Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 3:
                return "Triple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 4:
                return "Quadruple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 5:
                return "Quintuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 6:
                return "Hexa Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 7:
                return "Septuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 8:
                return "Octuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 9:
                return "Nonuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 10:
                return "Decuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 11:
                return "Undecuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 12:
                return "Duodecuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 13:
                return "Tridecuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 14:
                return "Tetradecuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 15:
                return "Pentadecuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            case 16:
                return "Hexadecuple Compressed " + capitalizeFirstLetter(blockDisplayName);
            default:
                return capitalizeFirstLetter(blockDisplayName);
        }
    }

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

