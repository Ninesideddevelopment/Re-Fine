package com.ninesidedyt.re_fine.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.Camera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ReFineClient implements ClientModInitializer {
    public static final String MOD_ID = "re-fine";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        ModulesManager modulesmanager = new ModulesManager();
        modulesmanager.create_modules_folder();
        modulesmanager.scan_modules();

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            LOGGER.info("Client Join");
        });
    }
}
