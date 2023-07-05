package com.whitesoul.wsgermmessage.util;

import com.germ.germplugin.api.GermPacketAPI;
import com.whitesoul.wsgermmessage.WsGermMessage;
import com.whitesoul.wsgermmessage.gui.HornHud;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HornHudUtil {
   public static void send(Player player) {
        (new HornHud()).openHud(player);
        int time = WsGermMessage.INSTANCE.getConfig().getInt("BigHorn.ShowTime") * 1000;
        List<String> dos = new ArrayList<>();
        dos.add("delay<->"+time);
        dos.add("closeChild<->BigHornHud");
        GermPacketAPI.sendHudDos(player,dos);
    }
}
