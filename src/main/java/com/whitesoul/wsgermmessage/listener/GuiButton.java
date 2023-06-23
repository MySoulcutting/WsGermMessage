package com.whitesoul.wsgermmessage.listener;

import com.germ.germplugin.api.dynamic.gui.GermGuiButton;
import com.germ.germplugin.api.dynamic.gui.GermGuiInput;
import com.germ.germplugin.api.event.gui.GermGuiButtonEvent;
import com.whitesoul.wsgermmessage.WsGermMessage;
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
            if (event.getPlayer().getInventory().getItemInMainHand() != null){
                event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - WsGermMessage.INSTANCE.getConfig().getInt("BigHorn.Consume"));
                for (Player p : player.getServer().getOnlinePlayers()) {
                    HornHud.sendBigHornHud(p, input.getInput());
                }
                event.getGermGuiScreen().close();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        HornHud.BigHornHudClose();
                        cancel();
                    }
                }.runTaskLaterAsynchronously(com.whitesoul.wsgermmessage.WsGermMessage.INSTANCE, WsGermMessage.INSTANCE.getConfig().getInt("BigHorn.ShowTime") * 20L);
            }
        }
    }
}
