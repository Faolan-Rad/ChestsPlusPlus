package com.jamesdpeters.minecraft.chests.api;

import com.jamesdpeters.minecraft.chests.ChestOpener;
import com.jamesdpeters.minecraft.chests.ChestsPlusPlus;
import com.jamesdpeters.minecraft.chests.CraftingProvider;
import com.jamesdpeters.minecraft.chests.EntityEventListener;
import com.jamesdpeters.minecraft.chests.MaterialChecker;
import com.jamesdpeters.minecraft.chests.NMSProvider;
import org.bukkit.Bukkit;
import org.bukkit.entity.ItemFrame;

public class NMSProviderDefault implements NMSProvider {

    //Latest version at time of build is 1.19
    NMSProvider defaultProvider;

    public NMSProviderDefault() {
        String NAME = Bukkit.getServer().getClass().getPackage().getName();
        String VERSION = NAME.substring(NAME.lastIndexOf('.') + 1);
        switch (VERSION) {
            case "v1_17_R1" -> defaultProvider = new com.jamesdpeters.minecraft.chests.v1_17_R1.NMSProviderImpl();
            case "v1_18_R1" -> defaultProvider = new com.jamesdpeters.minecraft.chests.v1_18_R1.NMSProviderImpl();
            case "v1_18_R2" -> defaultProvider = new com.jamesdpeters.minecraft.chests.v1_18_R2.NMSProviderImpl();
            case "v1_19_R1" -> defaultProvider = new com.jamesdpeters.minecraft.chests.v1_19_R1.NMSProviderImpl();
			case "v1_19_R3" -> defaultProvider = new com.jamesdpeters.minecraft.chests.v1_19_R3.NMSProviderImpl();
			default -> {
                ChestsPlusPlus.PLUGIN.getLogger().severe("§c=======================================================");
                ChestsPlusPlus.PLUGIN.getLogger().severe("§cThis version is not supported. Please update your server or the plugin!");
                ChestsPlusPlus.PLUGIN.getLogger().severe("§c=======================================================");
                defaultProvider = new com.jamesdpeters.minecraft.chests.v1_17_R1.NMSProviderImpl();
            }
        }
    }

    @Override
    public ChestOpener getChestOpener() {
        //1.16 ChestOpener contains lidded API!
        return defaultProvider.getChestOpener();
    }

    @Override
    public MaterialChecker getMaterialChecker() {
        //Return the current latest MaterialChecker when an newer server implementation is found.
        return defaultProvider.getMaterialChecker();
    }

    @Override
    public CraftingProvider getCraftingProvider() {
        return defaultProvider.getCraftingProvider();
    }

    @Override
    public EntityEventListener getEntityEventListener() {
        return defaultProvider.getEntityEventListener();
    }

    @Override
    public void setItemFrameVisible(ItemFrame itemFrame, boolean visible) {
        //Not supported in Bukkit api 1.14.
        defaultProvider.setItemFrameVisible(itemFrame, visible);
    }
}
