package com.codeofbrain.lifestealplugin.listeners;

import com.codeofbrain.lifestealplugin.utils.PlayerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class PlayerInteractEventListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_AIR) {
            if(event.getItem() != null) {
                if(Objects.requireNonNull(event.getItem().getItemMeta()).getDisplayName().equals("Super Heart")) {
                    PlayerUtils.addHeart(event.getPlayer());
                    event.getPlayer().getInventory().remove(event.getItem());
                }
            }
        }
    }
}
