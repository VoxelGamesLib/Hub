package com.voxelgameslib.hub;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.voxelgameslib.voxelgameslib.api.event.GameEvent;
import com.voxelgameslib.voxelgameslib.api.exception.UserException;
import com.voxelgameslib.voxelgameslib.api.feature.AbstractFeature;
import com.voxelgameslib.voxelgameslib.components.user.User;
import com.voxelgameslib.voxelgameslib.components.user.UserHandler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class LadderKingFeature extends AbstractFeature {

    @Inject
    private UserHandler userHandler;
    @Inject
    private HubPlugin hubPlugin;

    private User king;
    private Map<UUID, BukkitTask> tasks = new HashMap<>();

    @Override
    public void init() {

    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public void tick() {

    }

    @GameEvent
    public void onPlayerMove(@Nonnull final PlayerMoveEvent e, @Nonnull User user) {
        if (e.getTo().getBlock() != null && e.getTo().getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            if (king == null || !e.getPlayer().getUniqueId().equals(king.getUuid())) {
                if (king == null) {
                    getPhase().getGame().broadcastMessage(HubLangKey.LADDERKING_NEW, user.getRawDisplayName());
                    king = user;
                } else {
                    getPhase().getGame().broadcastMessage(HubLangKey.LADDERKING_NEW_OTHER, king.getRawDisplayName(), user.getRawDisplayName());
                    king = user;
                }

                startTask();
            }
        }
    }

    public void startTask() {
        for (final BukkitTask r : tasks.values()) {
            r.cancel();
        }
        tasks.clear();

        tasks.put(king.getUuid(), Bukkit.getScheduler().runTaskLater(hubPlugin, new BukkitRunnable() {

            @Override
            public void run() {
                if (king == null) {
                    return;
                }
                if (king.getPlayer().getLocation().getBlock() == null ||
                        king.getPlayer().getLocation().getBlock().getType() != Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
                    getPhase().getGame().broadcastMessage(HubLangKey.LADDERKING_LEFT_THRONE, king.getRawDisplayName());
                    king = null;
                } else {
                    enable();
                }
            }
        }, 5 * 20));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPvP(@Nonnull final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player && king != null) {
            User damager = userHandler.getUser((e.getDamager()).getUniqueId()).orElseThrow(() ->
                    new UserException("Unknown user " + e.getDamager().getUniqueId()));
            User damaged = userHandler.getUser((e.getEntity()).getUniqueId()).orElseThrow(() ->
                    new UserException("Unknown user " + e.getDamager().getUniqueId()));

            if (getPhase().getGame().isParticipating(damaged.getUuid()) && getPhase().getGame().isParticipating(damager.getUuid())) {
                if (damager.getUuid().equals(king.getUuid())) {
                    e.setDamage(1.0);
                    e.setCancelled(false);
                } else if (damaged.getUuid().equals(king.getUuid())) {
                    e.setDamage(1.0);
                    e.setCancelled(false);
                }
            }
        }
    }
}
