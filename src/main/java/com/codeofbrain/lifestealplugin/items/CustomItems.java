package com.codeofbrain.lifestealplugin.items;

import org.bukkit.inventory.ItemStack;

public class CustomItems {
    public static ItemStack SUPER_HEART;

    public static void init() {
        SUPER_HEART = new SuperHeartItem().init();
    }
}
