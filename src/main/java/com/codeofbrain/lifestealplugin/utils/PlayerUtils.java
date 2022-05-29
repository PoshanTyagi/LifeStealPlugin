package com.codeofbrain.lifestealplugin.utils;

import com.codeofbrain.lifestealplugin.LifeStealPlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Objects;

public final class PlayerUtils {
    public static void addHeart(Player player) {
        if(player == null)
            return;

        if(!player.hasMetadata("maxHealth")) {
            player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), 20.0));
        }

        double maxHealth = player.getMetadata("maxHealth").get(0).asDouble();
        maxHealth += 2.0;
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(maxHealth);
        player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), maxHealth));
    }

    public static void removeHeart(Player player) {
        if(player == null)
            return;

        if(!player.hasMetadata("maxHealth")) {
            player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), 20.0));
        }

        double maxHealth = player.getMetadata("maxHealth").get(0).asDouble();
        maxHealth -= 2.0;
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(maxHealth);
        player.setMetadata("maxHealth", new FixedMetadataValue(LifeStealPlugin.getInstance(), maxHealth));
    }
}
