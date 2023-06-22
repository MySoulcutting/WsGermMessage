package com.whitesoul.wsgermmessage.gui;

import com.germ.germplugin.api.dynamic.gui.GermGuiScreen;
import com.whitesoul.wsgermmessage.WsGermMessage;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class HornGui {
    public static GermGuiScreen gui;
    public static void BigHornGui(Player player){
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File(WsGermMessage.INSTANCE.getDataFolder(), "ui\\BigHornGui.yml"));
        gui = GermGuiScreen.getGermGuiScreen("BigHornGui",yamlConfiguration);
        gui.openGui(player);
    }
    public static void BigHornGuiClose(){
        gui.close();
    }
}
