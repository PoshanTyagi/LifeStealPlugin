package com.codeofbrain.lifestealplugin.listeners;

import com.codeofbrain.lifestealplugin.LifeStealPlugin;
import com.codeofbrain.lifestealplugin.utils.PlayerUtils;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Objects;

public class PlayerDeathEventListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        if(player != null) {
            PlayerUtils.removeHeart(player);
        }
    }
}
