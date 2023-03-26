package fr.relibelly.relihub.managers;

import fr.relibelly.relihub.listeners.PlayerJoinQuitListener;
import fr.relibelly.relihub.listeners.PlayerListener;
import fr.relibelly.relihub.listeners.GuiListener;
import fr.relibelly.relihub.listeners.OtherListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    public Plugin plugin;
    public PluginManager pluginManager;

    public ListenersManager(Plugin plugin) {
        this.plugin = plugin;
        this.pluginManager = Bukkit.getServer().getPluginManager();
    }

    public void registerListeners() {
        this.pluginManager.registerEvents(new PlayerJoinQuitListener(), this.plugin);
        this.pluginManager.registerEvents(new PlayerListener(), this.plugin);
        this.pluginManager.registerEvents(new GuiListener(), this.plugin);
        this.pluginManager.registerEvents(new OtherListener(), this.plugin);

    }

}
