package me.kevind.utils;

import me.kevind.Pronouns;

public class ConfigUtils {
    public static String getString(String s) {
        return Pronouns.getInstance().getConfig().getString(s);
    }
}
