package com.whitesoul.wsgermmessage.command;

import com.germ.germplugin.api.GermPacketAPI;
import com.germ.germplugin.api.HudMessageType;
import com.whitesoul.wsgermmessage.gui.HornGui;
import com.whitesoul.wsgermmessage.util.TimeUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenGuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            GermPacketAPI.sendHudMessage(player, HudMessageType.ANCHOR,"anchor1<->%player_name%欢迎使用自动公告 当前时间:" + TimeUtil.nowTime());
            //初始化大喇叭GUI
            HornGui.BigHornGui(player);
        } else {
            commandSender.sendMessage("§c该指令只能由玩家执行");
        }
            return false;
    }
}
