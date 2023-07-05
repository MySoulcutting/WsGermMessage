package com.whitesoul.wsgermmessage.gui.yaml;

import com.germ.germplugin.api.yaml.YamlAutowire;
import com.germ.germplugin.api.yaml.YamlRoot;
@YamlAutowire(name = "BigHornGui" , path = "gui")
public class HornGuiYaml extends YamlRoot {
    public static YamlRoot INSTANCE;
    public static YamlRoot inst(){
        return INSTANCE;
    }
}
