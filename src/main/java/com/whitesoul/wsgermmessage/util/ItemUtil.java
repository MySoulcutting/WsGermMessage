package com.whitesoul.wsgermmessage.util;

import org.bukkit.entity.Player;

public class ItemUtil {
    public static void checkItemName(Player player){
        // 判断主手物品是否为指定物品
        // 判断副手物品是否为指定物品
        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§a§l大喇叭")){
            // 执行指令
            player.performCommand("wsgermmessage:bigHornGui");
        }
    }
}
