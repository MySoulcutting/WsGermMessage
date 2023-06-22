package com.whitesoul.wsgermmessage.command;

import com.whitesoul.wsgermmessage.WsGermMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (player.isOp()){
            player.sendMessage("§a重载成功");
            WsGermMessage.INSTANCE.reloadConfig();
        }
        return false;
    }
}
