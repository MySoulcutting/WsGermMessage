package com.whitesoul.wsgermmessage.listener;

import com.germ.germplugin.api.GermPacketAPI;
import com.germ.germplugin.api.HudMessageType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerItem implements Listener {
    @EventHandler
    public void PlayerDropItem(PlayerDropItemEvent event){
        GermPacketAPI.sendHudMessage(event.getPlayer(), HudMessageType.LEFT1,"§a- §e"+event.getItemDrop().getItemStack().getAmount() + "x §b"+event.getItemDrop().getItemStack().getItemMeta().getDisplayName());
    }
    @EventHandler
    public void PlayerPickupItem(EntityPickupItemEvent event){
        Player player = (Player) event.getEntity();
        GermPacketAPI.sendHudMessage(player, HudMessageType.LEFT1,"§c+ §e"+event.getItem().getItemStack().getAmount() + "x §b"+event.getItem().getItemStack().getItemMeta().getDisplayName());
    }
}
