package com.voxelgameslib.hub;

import com.google.inject.Singleton;

import com.voxelgameslib.voxelgameslib.game.GameHandler;
import com.voxelgameslib.voxelgameslib.game.GameMode;
import com.voxelgameslib.voxelgameslib.lang.LangHandler;
import com.voxelgameslib.voxelgameslib.module.Module;
import com.voxelgameslib.voxelgameslib.module.ModuleHandler;
import com.voxelgameslib.voxelgameslib.module.ModuleInfo;

import java.io.File;
import javax.inject.Inject;

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
