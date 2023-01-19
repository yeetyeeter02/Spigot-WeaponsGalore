package com.github.yeetyeeter02.WeaponsGalore.Mangers.RayCasting;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class FireRayTrace {

    public static Entity getClosestEntity(Player player, int max) {
        List<Entity> possible = player
                .getNearbyEntities(max, max, max)
                .stream()
                .filter(player::hasLineOfSight)
                .collect(Collectors.toList());
        RayTraceManager ray = RayTraceManager.from(player);
        double d = -1;
        Entity closest = null;
        for (Entity ent : possible) {
            double dis = AABBManager.from(ent).collidesD(ray, 0, max);
            if (dis != -1) {
                if (dis < d || d == -1) {
                    d = dis;
                    closest = ent;
                }
            }
        }
        return closest;
    }

    public static Player getClosestPlayer(Player player, int max) {
        List<Player> possible = player
                .getNearbyEntities(max, max, max)
                .stream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> (Player) entity)
                .filter(player::hasLineOfSight)
                .collect(Collectors.toList());
        RayTraceManager ray = RayTraceManager.from(player);
        double d = -1;
        Player closest = null;
        for (Player player1 : possible) {
            double dis = AABBManager.from(player1).collidesD(ray, 0, max);
            if (dis != -1) {
                if (dis < d || d == -1) {
                    d = dis;
                    closest = player1;
                }
            }
        }
        return closest;
    }
}
