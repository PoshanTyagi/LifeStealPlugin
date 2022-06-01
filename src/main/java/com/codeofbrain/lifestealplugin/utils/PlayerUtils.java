package com.codeofbrain.lifestealplugin.utils;

import com.codeofbrain.lifestealplugin.LifeStealPlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Objects;

public final class PlayerUtils {
    public static boolean addHeart(Player player, double health) {
        if(player == null)
            return false;

        boolean returnValue = true;

        double DEFAULT_HEALTH = LifeStealPlugin.getPluginConfig().getDouble("config.default_health");
        double MAX_HEALTH = LifeStealPlugin.getPluginConfig().getDouble("config.max_health");

        if(!player.hasMetadata("maxHealth")) {
            player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), DEFAULT_HEALTH));
        }

        double maxHealth = player.getMetadata("maxHealth").get(0).asDouble();
        maxHealth += health;

        if(maxHealth > MAX_HEALTH) {
            maxHealth = MAX_HEALTH;
            returnValue = false;
        }

        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(maxHealth);
        player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), maxHealth));

        return returnValue;
    }

    public static boolean removeHeart(Player player, double health) {
        if(player == null)
            return false;

        boolean returnValue = true;

        double DEFAULT_HEALTH = LifeStealPlugin.getPluginConfig().getDouble("config.default_health");

        if(!player.hasMetadata("maxHealth")) {
            player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), DEFAULT_HEALTH));
        }

        double maxHealth = player.getMetadata("maxHealth").get(0).asDouble();
        maxHealth -= health;

        if(maxHealth < 0) {
            maxHealth = 0;
            returnValue = false;
        }

        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(maxHealth);
        player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), maxHealth));

        return returnValue;
    }
}
