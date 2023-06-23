package com.whitesoul.wsgermmessage;

import com.whitesoul.wsgermmessage.command.ReloadCommand;
import com.whitesoul.wsgermmessage.listener.GuiButton;
import com.whitesoul.wsgermmessage.listener.PlayerInteract;
import com.whitesoul.wsgermmessage.listener.PlayerItem;
import com.whitesoul.wsgermmessage.scheduler.AutoSendMessage;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class WsGermMessage extends JavaPlugin {
    public static WsGermMessage INSTANCE;
    public static YamlConfiguration autoMessageConfig;
    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        saveResource("ui\\BigHornHud.yml",false);
        saveResource("ui\\BigHornGui.yml",false);
        saveResource("AutoMessage.yml",false);
        autoMessageConfig = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "AutoMessage.yml"));
        AutoSendMessage.AutoSendMessages();
        getCommand("wsgermmessage").setExecutor(new ReloadCommand());
        getServer().getPluginManager().registerEvents(new PlayerItem(),this);
        getServer().getPluginManager().registerEvents(new GuiButton(),this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
