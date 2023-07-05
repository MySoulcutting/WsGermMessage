package com.whitesoul.wsgermmessage;

import com.germ.germplugin.api.yaml.YamlManager;
import com.whitesoul.wsgermmessage.command.ReloadCommand;
import com.whitesoul.wsgermmessage.gui.yaml.HornGuiYaml;
import com.whitesoul.wsgermmessage.gui.yaml.HornHudYaml;
import com.whitesoul.wsgermmessage.listener.GuiButton;
import com.whitesoul.wsgermmessage.listener.PlayerInteract;
import com.whitesoul.wsgermmessage.listener.PluginMessage;
import com.whitesoul.wsgermmessage.scheduler.AutoSendMessage;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class WsGermMessage extends JavaPlugin  {
    public static WsGermMessage INSTANCE;
    public static YamlConfiguration autoMessageConfig;
    @Override
    public void onEnable() {
        INSTANCE = this;
        // BC通信
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this,"BungeeCord", new PluginMessage());
        saveDefaultConfig();
        YamlManager.inst().registerYaml(this, HornGuiYaml.class);
        YamlManager.inst().registerYaml(this, HornHudYaml.class);
        saveResource("AutoMessage.yml",false);
        autoMessageConfig = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "AutoMessage.yml"));
        AutoSendMessage.AutoSendMessages();
        getCommand("wsgermmessage").setExecutor(new ReloadCommand());
        getServer().getPluginManager().registerEvents(new GuiButton(),this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(),this);
    }

    @Override
    public void onDisable() {
        // BC通信卸载
        getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        getServer().getMessenger().unregisterIncomingPluginChannel(this);
    }
}
