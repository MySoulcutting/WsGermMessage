package com.whitesoul.wsgermmessage.listener;

import com.whitesoul.wsgermmessage.gui.HornHud;
import com.whitesoul.wsgermmessage.util.HornHudUtil;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class PluginMessage implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        //判断是不是BC频道
        if (!channel.equals("BungeeCord")) return;
        //创建字节组输出流
        ByteArrayInputStream inputStream = new ByteArrayInputStream(message);
        DataInputStream in = new DataInputStream(inputStream);
        try {
            //读取消息  第一个子频道
            String subChannel = in.readUTF();
            //判断是不是相应的子频道
            if (!subChannel.equals("WsGermMessage")) return;
            //读 数据发送字节组的长度
            short messageLength = in.readShort();
            //new一个字节组
            byte[] messageBytes = new byte[messageLength];
            //读取全部数据到字节组中
            in.readFully(messageBytes);
            //创建字节组读取流
            DataInputStream msgin = new DataInputStream(new ByteArrayInputStream(messageBytes));
            //开始读数据  顺序读
            String name = msgin.readUTF();
            String input = msgin.readUTF();
            //大喇叭发送
            HornHud.name = name;
            HornHud.message = input;
            HornHudUtil.send(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
