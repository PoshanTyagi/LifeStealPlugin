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
        Player killer = event.getEntity().getKiller();

        if (player == null) return;

        if (killer == null) {
            double health = LifeStealPlugin.getPluginConfig().getDouble("config.remove_health_on_natural_death");
            PlayerUtils.removeHeart(player, health);
        } else {
            double health = LifeStealPlugin.getPluginConfig().getDouble("config.remove_health_when_killed");
            PlayerUtils.removeHeart(player, health);
            health = LifeStealPlugin.getPluginConfig().getDouble("config.add_health_to_killer");
            PlayerUtils.addHeart(killer, health);
        }
    }
}
