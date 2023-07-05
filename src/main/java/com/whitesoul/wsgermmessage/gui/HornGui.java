package com.whitesoul.wsgermmessage.gui;

import com.germ.germplugin.api.dynamic.gui.GermGuiScreen;
import com.whitesoul.wsgermmessage.gui.yaml.HornGuiYaml;

public class HornGui extends GermGuiScreen{

    public HornGui() {
        super("BigHornGui", false);
        this.loadSrc(HornGuiYaml.inst().getConfigurationSection("BigHornGui"));
        this.init();
    }
    private void init(){
    }
}
