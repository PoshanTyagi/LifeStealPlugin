package com.codeofbrain.lifestealplugin.listeners;

import com.codeofbrain.lifestealplugin.LifeStealPlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Objects;

public class PlayerJoinEventListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasMetadata("maxHealth")) {
            double DEFAULT_HEALTH = LifeStealPlugin.getPluginConfig().getDouble("config.default_health");
            player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), DEFAULT_HEALTH));
        }
        double maxHealth = player.getMetadata("maxHealth").get(0).asDouble();
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(maxHealth);
    }
}
