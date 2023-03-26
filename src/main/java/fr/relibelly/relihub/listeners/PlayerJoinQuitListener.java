package fr.relibelly.relihub.listeners;

import fr.relibelly.relihub.ReliHub;
import fr.relibelly.relihub.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.getEquipment().setArmorContents(null);
        player.getEquipment().clear();
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20.0);
        player.setFoodLevel(20);
        player.teleport(new Location(Bukkit.getWorld("world"), 0.0D, 65.0D, 0.0D, 0.0F, 0.0F)); //Coordonnées du spawn
        player.getInventory().setItem(4, (new ItemBuilder(Material.COMPASS)).setDisplayName("§e§lMenu Principal §7(Clique Droit)").build(Boolean.valueOf(false)));
        player.sendMessage("§c§lRELIHUB");
        player.sendMessage("§1");
        player.sendMessage("§6§lSITEWEB: §ehttps://serveur.fr/");
        player.sendMessage("§9§lDISCORD: §ehttps://discord.gg/serveur/");
        e.setJoinMessage(null);
        ReliHub.getInstance().getScoreboardManager().onLogin(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(null);
        ReliHub.getInstance().getScoreboardManager().onLogout(player);
    }
}
