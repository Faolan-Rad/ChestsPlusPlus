package com.jamesdpeters.minecraft.chests.menus;

import com.jamesdpeters.minecraft.chests.ChestsPlusPlus;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.entity.Player;
import java.util.function.BiFunction;
import java.util.List;
import net.wesjd.anvilgui.AnvilGUI.ResponseAction;

public class TextInputUI {

    public static void getInput(Player player, String title, BiFunction<Player, String, List<ResponseAction>> responseBiFunction) {
        new AnvilGUI.Builder()
                .onComplete(responseBiFunction)
                .text("Enter Name")
                .title(title)
                .plugin(ChestsPlusPlus.PLUGIN)
                .open(player);
    }

}
