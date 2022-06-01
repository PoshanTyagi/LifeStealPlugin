package com.codeofbrain.lifestealplugin.items;

import com.codeofbrain.lifestealplugin.LifeStealPlugin;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public abstract class AbstractCustomItem {
    public ItemStack init() {
        ItemStack item = initItem();

        ShapedRecipe recipe = itemRecipe(item);

        if(recipe != null)
            LifeStealPlugin.getInstance().getServer().addRecipe(recipe);

        return item;
    }

    protected abstract ItemStack initItem();

    protected abstract ShapedRecipe itemRecipe(ItemStack item);
}
