package com.whitesoul.wsgermmessage.scheduler;

import com.germ.germplugin.api.GermPacketAPI;
import com.germ.germplugin.api.HudMessageType;
import com.whitesoul.wsgermmessage.WsGermMessage;
import com.whitesoul.wsgermmessage.util.TimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoSendMessage {
    public static void AutoSendMessages() {
        FileConfiguration config = WsGermMessage.autoMessageConfig;
        for (String key : config.getKeys(false)) {
            if (config.getBoolean(key + ".Enable")) {
                //获取所有在线玩家
                for (Player player : Bukkit.getOnlinePlayers()) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            GermPacketAPI.sendHudMessage(player, HudMessageType.valueOf(config.getString(key + ".Type")), config.getString(key + ".Message").replace("%nowtime%", TimeUtil.nowTime()));
                        }
                    }.runTaskTimerAsynchronously(WsGermMessage.INSTANCE, 0, config.getInt(key + ".Delay") * 20L);
                }

            }
        }
    }
}
