package com.github.yeetyeeter02.WeaponsGalore.Mangers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack glock;

    public static void init() {
        createGlock();
    }

    private static void createGlock() {
        ItemStack item = new ItemStack(Material.WOODEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Glock");
        List<String> lore = new ArrayList<>();
        lore.add("A Powerful Weapon Of The Past...");
        meta.setLore(lore);
        item.setItemMeta(meta);
        glock = item;
    }
}
