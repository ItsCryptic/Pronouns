package me.kevind;

import org.bukkit.plugin.java.JavaPlugin;

public class Pronouns extends JavaPlugin {
    private static Pronouns instance;
    public static Pronouns getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
    }
    public void onDisable() {

    }
}
