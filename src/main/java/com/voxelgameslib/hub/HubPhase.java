package com.voxelgameslib.hub;

import com.voxelgameslib.voxelgameslib.feature.features.AutoRespawnFeature;
import com.voxelgameslib.voxelgameslib.feature.features.GameModeFeature;
import com.voxelgameslib.voxelgameslib.feature.features.MapFeature;
import com.voxelgameslib.voxelgameslib.feature.features.SpawnFeature;
import com.voxelgameslib.voxelgameslib.phase.AbstractPhase;

import org.bukkit.GameMode;

public class HubPhase extends AbstractPhase {

    @Override
    public void init() {
        setName("HubPhase");
        super.init();
        setAllowJoin(true);
        setAllowSpectate(true);

        MapFeature mapFeature = getGame().createFeature(MapFeature.class, this);
        mapFeature.setShouldUnload(true);
        mapFeature.setType(MapFeature.Type.LOBBY);
        addFeature(mapFeature);

        SpawnFeature spawnFeature = getGame().createFeature(SpawnFeature.class, this);
        spawnFeature.setRespawn(true);
        spawnFeature.setInitialSpawn(true);
        addFeature(spawnFeature);

        GameModeFeature gameModeFeature = getGame().createFeature(GameModeFeature.class, this);
        gameModeFeature.setGameMode(GameMode.ADVENTURE);
        addFeature(gameModeFeature);

        HubFeature hubFeature = getGame().createFeature(HubFeature.class, this);
        addFeature(hubFeature);

        AutoRespawnFeature autoRespawnFeature = getGame().createFeature(AutoRespawnFeature.class, this);
        addFeature(autoRespawnFeature);
    }
}
