package me.kevind;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Pronouns extends JavaPlugin {
    private static Pronouns instance;
    public static Pronouns getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        PluginManager manager = getServer().getPluginManager();
        if (!(manager.isPluginEnabled("KevinUtils"))) {
            getLogger().warning("Please install KevinUtils to use this plugin!");
            manager.disablePlugin(this);
        }else {
            getLogger().info("Using KevinUtils");
        }
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    public void onDisable() {

    }
}
