package com.voxelgameslib.hub;

import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.game.AbstractGame;
import com.voxelgameslib.voxelgameslib.game.GameDefinition;
import com.voxelgameslib.voxelgameslib.game.GameInfo;

@GameInfo(name = "Hub", author = "MiniDigger", version = "v1.0", description = "Hub Description")
public class HubGame extends AbstractGame {

    public HubGame() {
        super(HubPlugin.GAMEMODE);
    }

    @Override
    public void initGameFromModule() {
        setMinPlayers(0);
        setMaxPlayers(Integer.MAX_VALUE);

        activePhase = createPhase(HubPhase.class);

        loadMap("Hub");
    }

    @Override
    public void initGameFromDefinition(@Nonnull GameDefinition gameDefinition) {
        super.initGameFromDefinition(gameDefinition);

        loadMap("Hub");
    }

    @Override
    public void endPhase() {
        // NOP
    }
}
