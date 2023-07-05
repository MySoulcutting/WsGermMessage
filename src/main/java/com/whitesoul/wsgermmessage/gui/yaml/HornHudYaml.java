package com.whitesoul.wsgermmessage.gui.yaml;

import com.germ.germplugin.api.yaml.YamlAutowire;
import com.germ.germplugin.api.yaml.YamlRoot;
@YamlAutowire(name = "BigHornHud" , path = "gui")
public class HornHudYaml extends YamlRoot {
    public static YamlRoot INSTANCE;
    public static YamlRoot inst(){
        return INSTANCE;
    }
}
