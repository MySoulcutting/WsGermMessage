package com.whitesoul.wsgermmessage.util;

import com.whitesoul.wsgermmessage.WsGermMessage;
import org.bukkit.Bukkit;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PluginSendMessage {
    public static void send(String name,String input) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeUTF("Forward");
        out.writeUTF("ALL");
        out.writeUTF("WsGermMessage");
        ByteArrayOutputStream msgbytes = new ByteArrayOutputStream();
        DataOutputStream msgout = new DataOutputStream(msgbytes);
        try {
            msgout.writeUTF(name);
            msgout.writeUTF(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.writeShort(msgbytes.toByteArray().length);
        out.write(msgbytes.toByteArray());
        Bukkit.getServer().sendPluginMessage(WsGermMessage.INSTANCE, "BungeeCord", outputStream.toByteArray());
    }

}
