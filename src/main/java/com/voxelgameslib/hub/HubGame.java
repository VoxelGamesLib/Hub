package com.voxelgameslib.hub;

import com.voxelgameslib.voxelgameslib.game.AbstractGame;
import com.voxelgameslib.voxelgameslib.game.GameDefinition;
import com.voxelgameslib.voxelgameslib.game.GameInfo;

import javax.annotation.Nonnull;

@GameInfo(name = "Hub", author = "MiniDigger", version = "v1.0", description = "Hub Description")
public class HubGame extends AbstractGame {

    public HubGame() {
        super(HubPlugin.GAMEMODE);
    }

    @Override
    public void initGameFromModule() {
        setMinPlayers(Integer.MAX_VALUE);
        setMaxPlayers(Integer.MAX_VALUE);

        activePhase = createPhase(HubPhase.class);

        loadMap("Hub");
    }

    @Override
    public void initGameFromDefinition(@Nonnull GameDefinition gameDefinition) {
        super.initGameFromDefinition(gameDefinition);

        loadMap("Hub");
    }
}
