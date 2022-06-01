package com.codeofbrain.lifestealplugin.listeners;

import com.codeofbrain.lifestealplugin.LifeStealPlugin;
import com.codeofbrain.lifestealplugin.items.CustomItems;
import com.codeofbrain.lifestealplugin.utils.PlayerUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEventListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack superHeart = event.getItem();
            if (superHeart != null) {
                if (superHeart.equals(CustomItems.SUPER_HEART)) {
                    Player player = event.getPlayer();
                    double health = LifeStealPlugin.getPluginConfig().getDouble("config.add_health_using_super_heart");
                    boolean isAdded = PlayerUtils.addHeart(player, health);
                    if (isAdded) {
                        if(superHeart.getAmount() > 1) {
                            superHeart.setAmount(superHeart.getAmount() - 1);
                        } else {
                            player.getInventory().removeItem(superHeart);
                        }
                    }
                }
            }
        }
    }
}
