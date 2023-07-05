package com.whitesoul.wsgermmessage.gui;

import com.germ.germplugin.api.dynamic.gui.GermGuiLabel;
import com.germ.germplugin.api.dynamic.gui.GermGuiScreen;
import com.whitesoul.wsgermmessage.WsGermMessage;
import com.whitesoul.wsgermmessage.gui.yaml.HornHudYaml;

public class HornHud extends GermGuiScreen{
    public static String name;
    public static String message;
    private GermGuiLabel germGuiLabel;

    public HornHud() {
        super("BigHornHud", false);
        this.loadSrc(HornHudYaml.inst().getConfigurationSection("BigHornHud"));
        this.init();
    }
    private void init(){
        germGuiLabel = (GermGuiLabel) getGuiPart("text");
        germGuiLabel.setText(WsGermMessage.INSTANCE.getConfig().getString("BigHorn.Message").replace("&","§").replace("%msg%",message).replace("%player%",name));
    }
}
