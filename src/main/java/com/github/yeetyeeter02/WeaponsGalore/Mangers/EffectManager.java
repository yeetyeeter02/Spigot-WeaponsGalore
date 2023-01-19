package com.github.yeetyeeter02.WeaponsGalore.Mangers;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class EffectManager {
    public static void ParticlesAB(Location point1, Location point2, double space, Particle part) {
        World world = point1.getWorld();
        if((point2.getWorld().equals(world))){

        }
        double distance = point1.distance(point2);
        Vector p1 = point1.toVector();
        Vector p2 = point2.toVector();
        Vector vector = p2.clone().subtract(p1).normalize().multiply(space);
        double length = 0;
        for (; length < distance; p1.add(vector)) {
            world.spawnParticle(part, p1.getX(), p1.getY(), p1.getZ(), 1);
            length += space;
        }
    }
}
