package com.whitesoul.wsgermmessage.command;

import com.whitesoul.wsgermmessage.WsGermMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length == 1 && strings[0].equals("reload")) {
            if (player.isOp()) {
                player.sendMessage("§a重载成功");
                WsGermMessage.INSTANCE.reloadConfig();
                File file = new File(WsGermMessage.INSTANCE.getDataFolder(), "AutoMessage.yml");
                YamlConfiguration.loadConfiguration(file);
            }
        }
        return false;
    }
}
