package com.ninesidedyt.re_fine.client;

import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModulesManager {
    public static final File MODULES_FOLDER = new File(FabricLoader.getInstance().getGameDir().toFile(), "refine_modules");

    public ModulesManager() {
        // constructor — can be empty
        if (!MODULES_FOLDER.exists()) {
            create_modules_folder();
        }
    }

    public void create_modules_folder() {
        boolean created = MODULES_FOLDER.mkdirs();
        if (created) {
            System.out.println("[Refine] Created refine_modules folder.");
        } else {
            System.err.println("[Refine] Failed to create refine_modules folder!");
        }
    }

    public void download_modules() {

    }

    public void scan_modules() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(MODULES_FOLDER.toPath(), "*.jar")) {
            for (Path jarPath : stream) {
                System.out.println(jarPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load_modules() {

    }
}
