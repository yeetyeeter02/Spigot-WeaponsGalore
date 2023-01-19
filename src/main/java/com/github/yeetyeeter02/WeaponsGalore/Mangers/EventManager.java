package com.github.yeetyeeter02.WeaponsGalore.Mangers;

import com.github.yeetyeeter02.WeaponsGalore.Mangers.RayCasting.FireRayTrace;
import com.github.yeetyeeter02.WeaponsGalore.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventManager implements Listener {

    Main plugin;

    public EventManager(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onEvent(PlayerInteractEvent e) {
        if (e.getAction().isRightClick()) {
            if (e.getItem() != null) {
                Player player = e.getPlayer();
                if (e.getItem().getItemMeta().equals(ItemManager.glock.getItemMeta())) {
                    if (player.getGameMode().equals(GameMode.CREATIVE)
                            || player.getInventory().containsAtLeast(new ItemStack(Material.IRON_NUGGET), 1)) {

                        Entity ent = FireRayTrace.getClosestEntity(player, 25);
                        if (ent == null
                                || ent.getType().equals(EntityType.DROPPED_ITEM)
                                || ent.getType().equals(EntityType.EXPERIENCE_ORB)
                                || ent.getType().equals(EntityType.THROWN_EXP_BOTTLE)
                                || ent.getType().equals(EntityType.AREA_EFFECT_CLOUD)) {
                            return;
                        }
                        LivingEntity target = (LivingEntity) ent;

                        EffectManager.ParticlesAB(ent.getOrigin(), target.getLocation(), 1, Particle.CRIT);
                        target.damage(5);

                        if (!player.getGameMode().equals(GameMode.CREATIVE)) {
                            player.getInventory().removeItem(new ItemStack(Material.IRON_NUGGET));
                        }
                    }
                }
            }
        }
    }
}