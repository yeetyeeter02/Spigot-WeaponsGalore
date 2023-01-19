package com.github.yeetyeeter02.WeaponsGalore;

import com.github.yeetyeeter02.WeaponsGalore.Mangers.CommandManager;
import com.github.yeetyeeter02.WeaponsGalore.Mangers.EventManager;
import com.github.yeetyeeter02.WeaponsGalore.Mangers.ItemManager;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    public static Logger log = Logger.getLogger("TestPlugin");
    public static void sendLogs(String string) {
        log.info(string);
    }
    private static CommandManager cmdMGR = new CommandManager();
    @Override
    public void onEnable() {
        // Plugin startup logic
        sendLogs("Test Plugin Is Loaded!");



        ItemManager.init();
        getCommand("wggui").setExecutor(cmdMGR);
        this.getServer().getPluginManager().registerEvents(new EventManager(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
