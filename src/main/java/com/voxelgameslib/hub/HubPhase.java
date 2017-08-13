package com.voxelgameslib.hub;

import com.voxelgameslib.voxelgameslib.feature.features.AutoRespawnFeature;
import com.voxelgameslib.voxelgameslib.feature.features.ClearInventoryFeature;
import com.voxelgameslib.voxelgameslib.feature.features.DoubleJumpFeature;
import com.voxelgameslib.voxelgameslib.feature.features.GameModeFeature;
import com.voxelgameslib.voxelgameslib.feature.features.HealFeature;
import com.voxelgameslib.voxelgameslib.feature.features.JumpPadFeature;
import com.voxelgameslib.voxelgameslib.feature.features.MapFeature;
import com.voxelgameslib.voxelgameslib.feature.features.MobFeature;
import com.voxelgameslib.voxelgameslib.feature.features.NoBlockBreakFeature;
import com.voxelgameslib.voxelgameslib.feature.features.NoBlockPlaceFeature;
import com.voxelgameslib.voxelgameslib.feature.features.NoDamageFeature;
import com.voxelgameslib.voxelgameslib.feature.features.NoHungerLossFeature;
import com.voxelgameslib.voxelgameslib.feature.features.SpawnFeature;
import com.voxelgameslib.voxelgameslib.feature.features.TimeFeature;
import com.voxelgameslib.voxelgameslib.phase.AbstractPhase;

import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;

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

        LadderKingFeature ladderKingFeature = getGame().createFeature(LadderKingFeature.class, this);
        addFeature(ladderKingFeature);

        NoDamageFeature noDamageFeature = getGame().createFeature(NoDamageFeature.class, this);
        addFeature(noDamageFeature);

        NoBlockBreakFeature noBlockBreakFeature = getGame().createFeature(NoBlockBreakFeature.class, this);
        addFeature(noBlockBreakFeature);

        NoBlockPlaceFeature noBlockPlaceFeature = getGame().createFeature(NoBlockPlaceFeature.class, this);
        addFeature(noBlockPlaceFeature);

        NoHungerLossFeature noHungerLossFeature = getGame().createFeature(NoHungerLossFeature.class, this);
        addFeature(noHungerLossFeature);

        HealFeature healFeature = getGame().createFeature(HealFeature.class, this);
        addFeature(healFeature);

        DoubleJumpFeature doubleJumpFeature = getGame().createFeature(DoubleJumpFeature.class, this);
        addFeature(doubleJumpFeature);

        JumpPadFeature jumpPadFeature = getGame().createFeature(JumpPadFeature.class, this);
        addFeature(jumpPadFeature);

        TimeFeature timeFeature = getGame().createFeature(TimeFeature.class, this);
        addFeature(timeFeature);

        MobFeature mobFeature = getGame().createFeature(MobFeature.class, this);
        mobFeature.addWhitelist(EntityType.SHEEP, EntityType.COW, EntityType.CHICKEN);
        addFeature(mobFeature);

        ClearInventoryFeature clearInventoryFeature = getGame().createFeature(ClearInventoryFeature.class, this);
        addFeature(clearInventoryFeature);
    }
}
