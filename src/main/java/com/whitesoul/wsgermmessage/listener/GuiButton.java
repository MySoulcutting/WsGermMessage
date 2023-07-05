package com.whitesoul.wsgermmessage.listener;

import com.germ.germplugin.api.dynamic.gui.GermGuiButton;
import com.germ.germplugin.api.dynamic.gui.GermGuiInput;
import com.germ.germplugin.api.event.gui.GermGuiButtonEvent;
import com.whitesoul.wsgermmessage.WsGermMessage;
import com.whitesoul.wsgermmessage.gui.HornHud;
import com.whitesoul.wsgermmessage.util.HornHudUtil;
import com.whitesoul.wsgermmessage.util.PluginSendMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;

public class GuiButton implements Listener {
    @EventHandler
    public void GermGuiButtonEvent(GermGuiButtonEvent event) throws IOException {
        Player player = event.getPlayer();
        if (event.getGermGuiScreen().getGuiName().equals("BigHornGui") && event.getGermGuiButton().getIndexName().equals("SendButton")
                && event.getEventType() == GermGuiButton.EventType.LEFT_CLICK) {
            GermGuiInput input = (GermGuiInput) event.getGermGuiScreen().getGuiPart("HornInput");
            if (event.getPlayer().getInventory().getItemInMainHand() != null){
                event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - WsGermMessage.INSTANCE.getConfig().getInt("BigHorn.Consume"));
                event.getGermGuiScreen().close();
                for (Player p : player.getServer().getOnlinePlayers()) {
                    HornHud.name = player.getDisplayName();
                    HornHud.message = input.getInput();
                    HornHudUtil.send(p);
                }
                PluginSendMessage.send(player.getDisplayName(),input.getInput());
            }
        }
    }
}
