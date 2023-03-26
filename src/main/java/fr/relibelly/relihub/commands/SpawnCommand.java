package fr.relibelly.relihub.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.teleport(new Location(Bukkit.getWorld("world"), 0.0D, 65.0D, 0.0D, 0.0F, 0.0F)); //Coordonnées du spawn
            player.sendMessage("§c§lReliHub §7§l• §eVous avez été téléporté au spawn.");
        } else {
            sender.sendMessage("§cCette commande ne peut être exécutée que par un joueur, et non par la console...");
        }
        return true;
    }
}
