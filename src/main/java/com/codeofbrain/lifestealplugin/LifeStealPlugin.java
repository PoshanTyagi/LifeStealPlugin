package com.codeofbrain.lifestealplugin;

import com.codeofbrain.lifestealplugin.items.CustomItems;
import com.codeofbrain.lifestealplugin.listeners.PlayerDeathEventListener;
import com.codeofbrain.lifestealplugin.listeners.PlayerInteractEventListener;
import com.codeofbrain.lifestealplugin.listeners.PlayerJoinEventListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class LifeStealPlugin extends JavaPlugin {
    private static LifeStealPlugin instance;
    public static Logger LOGGER;
    private static FileConfiguration config;

    @Override
    public void onEnable() {
        instance = this;

        LOGGER = getLogger();

        saveConfig();
        config = getConfig();

        CustomItems.init();

        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), this);
    }

    public static LifeStealPlugin getInstance() {
        return instance;
    }

    public static FileConfiguration getPluginConfig() {
        return config;
    }
}
