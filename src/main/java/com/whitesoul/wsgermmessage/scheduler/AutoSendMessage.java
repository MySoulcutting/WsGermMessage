package com.whitesoul.wsgermmessage.scheduler;

import com.germ.germplugin.api.GermPacketAPI;
import com.germ.germplugin.api.HudMessageType;
import com.whitesoul.wsgermmessage.WsGermMessage;
import com.whitesoul.wsgermmessage.util.TimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoSendMessage {
    public static void AutoSendCenterMessage() {
        //获取所有在线玩家
        for (Player player : Bukkit.getOnlinePlayers()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    GermPacketAPI.sendHudMessage(player, HudMessageType.CENTER1, "%player_name%欢迎使用自动公告 当前时间:" + TimeUtil.nowTime());
                }

            }.runTaskTimerAsynchronously(WsGermMessage.INSTANCE, 0, 5*20L);
        }
    }
}
