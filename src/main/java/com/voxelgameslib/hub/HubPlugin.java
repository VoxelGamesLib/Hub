package com.voxelgameslib.hub;

import com.google.inject.Singleton;

import java.io.File;
import javax.inject.Inject;

import com.voxelgameslib.voxelgameslib.api.game.GameHandler;
import com.voxelgameslib.voxelgameslib.api.game.GameMode;
import com.voxelgameslib.voxelgameslib.api.module.Module;
import com.voxelgameslib.voxelgameslib.api.module.ModuleHandler;
import com.voxelgameslib.voxelgameslib.api.module.ModuleInfo;
import com.voxelgameslib.voxelgameslib.internal.lang.LangHandler;

import org.bukkit.plugin.java.JavaPlugin;

@Singleton
@ModuleInfo(name = "Hub", authors = "MiniDigger", version = "1.0.0")
public class HubPlugin extends JavaPlugin implements Module {

    public static final GameMode GAMEMODE = new GameMode("Hub", HubGame.class);

    @Inject
    private GameHandler gameHandler;
    @Inject
    private LangHandler langHandler;

    @Override
    public void onLoad() {
        ModuleHandler.offerModule(this); // always do this first!
    }

    @Override
    public void enable() {
        gameHandler.registerGameMode(GAMEMODE);
        langHandler.registerExternalLangProvider(HubLangKey.DUMMY, new File(getDataFolder(), "lang"));
    }

    @Override
    public void disable() {

    }
}
