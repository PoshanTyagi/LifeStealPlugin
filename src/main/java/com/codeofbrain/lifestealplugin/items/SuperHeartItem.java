package com.codeofbrain.lifestealplugin.items;

import com.codeofbrain.lifestealplugin.LifeStealPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class SuperHeartItem extends AbstractCustomItem {
    @Override
    protected ItemStack initItem() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();

        String displayName = LifeStealPlugin
                .getPluginConfig()
                .getString("heart.name");

        meta.setDisplayName(displayName);

        meta.setLore(LifeStealPlugin.getPluginConfig().getStringList("heart.lore"));

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        return item;
    }

    @Override
    protected ShapedRecipe itemRecipe(ItemStack item) {
        FileConfiguration config = LifeStealPlugin.getPluginConfig();

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("super_heart"), item);

        List<String> recipeShape = config.getStringList("heart.recipe.shape");

        recipe.shape(recipeShape.get(0), recipeShape.get(1), recipeShape.get(2));

        Map<String, Object> recipeIngredients = config.getConfigurationSection("heart.recipe.ingredients").getValues(true);

        recipeIngredients.forEach((k, v) -> {
            if (v instanceof String) {
                recipe.setIngredient(k.charAt(0), Material.valueOf(v.toString()));
            }
        });

        return recipe;
    }
}
