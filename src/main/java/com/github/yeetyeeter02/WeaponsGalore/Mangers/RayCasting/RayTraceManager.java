package com.github.yeetyeeter02.WeaponsGalore.Mangers.RayCasting;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


public class RayTraceManager {

        private final Vector origin;
        private final Vector direction;

        // Create a ray at the origin pointing in a direction.
        public RayTraceManager(Vector origin, Vector direction) {
                this.origin = origin;
                this.direction = direction;
        }

        // Create a ray based on where the player is looking.
        // Origin: Player Eye Location
        // Direction: Player-looking direction
        public static RayTraceManager from(Player player) {
                return new RayTraceManager(player.getEyeLocation().toVector(), player.getLocation().getDirection());
        }

        // (Used for rotating vectors) Creates a vector in the horizontal plane (y=0) perpendicular to a vector.
        public static Vector right(Vector vector) {
                Vector n = vector.clone();
                n = n.setY(0).normalize();
                double x = n.getX();
                n.setX(n.getZ());
                n.setZ(-x);
                return n;
        }

        // Returns a normalized version of this Ray with the Y component set to 0
        public RayTraceManager level() {
                return new RayTraceManager(origin, direction.setY(0).normalize());
        }

        public Vector getOrigin() {
                return origin;
        }

        public Vector getDirection() {
                return direction;
        }

        public double origin(int i) {
                switch (i) {
                        case 0:
                                return origin.getX();
                        case 1:
                                return origin.getY();
                        case 2:
                                return origin.getZ();
                        default:
                                return 0;
                }
        }

        public double direction(int i) {
                switch (i) {
                        case 0:
                                return direction.getX();
                        case 1:
                                return direction.getY();
                        case 2:
                                return direction.getZ();
                        default:
                                return 0;
                }
        }

        // Get a point x distance away from this ray.
        // Can be used to get a point 2 blocks in front of a player's face.
        public Vector getPoint(double distance) {
                return direction.clone().normalize().multiply(distance).add(origin);
        }

        // Same as above, but no need to construct object.
        public static Location getPoint(Player player, double distance) {
                Vector point = RayTraceManager.from(player).getPoint(distance);
                return new Location(player.getWorld(), point.getX(), point.getY(), point.getZ());
        }
}