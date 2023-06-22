package com.whitesoul.wsgermmessage;

import com.whitesoul.wsgermmessage.command.OpenGuiCommand;
import com.whitesoul.wsgermmessage.listener.GuiButton;
import com.whitesoul.wsgermmessage.listener.PlayerItem;
import com.whitesoul.wsgermmessage.scheduler.AutoSendMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class WsGermMessage extends JavaPlugin {
    public static WsGermMessage INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        saveResource("ui\\BigHornHud.yml",false);
        saveResource("ui\\BigHornGui.yml",false);
        AutoSendMessage.AutoSendCenterMessage();
        getCommand("hudtest").setExecutor(new OpenGuiCommand());
        getServer().getPluginManager().registerEvents(new PlayerItem(),this);
        getServer().getPluginManager().registerEvents(new GuiButton(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
