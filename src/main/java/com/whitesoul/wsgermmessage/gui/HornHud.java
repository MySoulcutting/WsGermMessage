package com.whitesoul.wsgermmessage.gui;

import com.germ.germplugin.api.dynamic.gui.GermGuiLabel;
import com.germ.germplugin.api.dynamic.gui.GermGuiScreen;
import com.whitesoul.wsgermmessage.WsGermMessage;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class HornHud {
    public static GermGuiScreen hud;
    public static void sendBigHornHud(Player player,String message){
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File(WsGermMessage.INSTANCE.getDataFolder(), "ui\\BigHornHud.yml"));
        hud = GermGuiScreen.getGermGuiScreen("BigHornHud", yamlConfiguration);
        GermGuiLabel germGuiLabel = (GermGuiLabel) hud.getGuiPart("text");
        germGuiLabel.setText(WsGermMessage.INSTANCE.getConfig().getString("BigHorn.Message").replace("&","§").replace("%msg%",message).replace("%player%",player.getDisplayName()));
        hud.openHud(player);
    }
    public static void BigHornHudClose(){
        hud.close();
    }
}
