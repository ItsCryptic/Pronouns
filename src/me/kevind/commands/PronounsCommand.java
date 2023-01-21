package me.kevind.commands;

import me.kevind.Pronouns;
import me.kevind.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PronounsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                MessageUtils.sendMessage(player, "&cPlease ");
            }
            if (args[0].equalsIgnoreCase("set")) {
                if (args[1] != null) {
                    File file = new File(Pronouns.getInstance().getDataFolder(), "pronouns.yml");
                    String search = args[1].toString();
                    try(Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(search)) {
                                Pronouns.getInstance().getLogger().info("Found " + search);
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return false;
    }
}
