package com.whitesoul.wsgermmessage;

public class Config {
    public static void getKeys() {
        for (String s : WsGermMessage.INSTANCE.getConfig().getKeys(false)) {
            System.out.println(s);
        }
    }
    public static Boolean MessageEnable = WsGermMessage.INSTANCE.getConfig().getBoolean("MessageEnable");
}
