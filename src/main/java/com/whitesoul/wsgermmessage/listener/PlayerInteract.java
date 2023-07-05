package com.whitesoul.wsgermmessage.listener;

import com.whitesoul.wsgermmessage.WsGermMessage;
import com.whitesoul.wsgermmessage.gui.HornGui;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerInteract implements Listener {
    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event) {
        if (!event.getPlayer().hasPermission(WsGermMessage.INSTANCE.getConfig().getString("BigHorn.Permission"))) return;
        if (!event.getHand().equals(EquipmentSlot.HAND)) return;
        if (event.getItem() == null) return;
        if (event.getItem().getItemMeta() == null) return;
        if (event.getItem().getItemMeta().getDisplayName() == null) return;
        if (event.getItem().getItemMeta().getDisplayName().equals(WsGermMessage.INSTANCE.getConfig().getString("BigHorn.Name").replace("&","§")) && event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            (new HornGui()).openGui(event.getPlayer());
        }
    }
}
