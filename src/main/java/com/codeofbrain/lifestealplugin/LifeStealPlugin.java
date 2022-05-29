package com.codeofbrain.lifestealplugin;

import com.codeofbrain.lifestealplugin.listeners.PlayerDeathEventListener;
import com.codeofbrain.lifestealplugin.listeners.PlayerInteractEventListener;
import com.codeofbrain.lifestealplugin.listeners.PlayerJoinEventListener;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class LifeStealPlugin extends JavaPlugin {
    public static LifeStealPlugin instance;
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), this);

        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Super Heart");
        List<String> lore = new ArrayList<>();
        lore.add("Right click to add Heart");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("super_heart"), item);
        recipe.shape("# #",
                     " * ",
                     " # ");
        recipe.setIngredient('#', Material.DIAMOND_BLOCK);
        recipe.setIngredient('*', Material.NETHER_STAR);
        getServer().addRecipe(recipe);
    }

    public static LifeStealPlugin getInstance() {
        return instance;
    }
}
