package com.whitesoul.wsgermmessage.listener;

import com.germ.germplugin.api.dynamic.gui.GermGuiButton;
import com.germ.germplugin.api.dynamic.gui.GermGuiInput;
import com.germ.germplugin.api.event.gui.GermGuiButtonEvent;
import com.whitesoul.wsgermmessage.gui.HornHud;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class GuiButton implements Listener {
    @EventHandler
    public void GermGuiButtonEvent(GermGuiButtonEvent event) {
        Player player = event.getPlayer();
        if (event.getGermGuiScreen().getGuiName().equals("BigHornGui") && event.getGermGuiButton().getIndexName().equals("SendButton")
        && event.getEventType() == GermGuiButton.EventType.LEFT_CLICK) {
            GermGuiInput input = (GermGuiInput) event.getGermGuiScreen().getGuiPart("HornInput");
            player.sendMessage(input.getInput());
            for (Player p : player.getServer().getOnlinePlayers()) {
            HornHud.BigHornHud(p, input.getInput());
        }
            event.getGermGuiScreen().close();
            new BukkitRunnable() {
                @Override
                public void run() {
                    HornHud.BigHornHudClose();
                    cancel();
                }
            }.runTaskLaterAsynchronously(com.whitesoul.wsgermmessage.WsGermMessage.INSTANCE, 5 * 20L);
        }
    }
}
