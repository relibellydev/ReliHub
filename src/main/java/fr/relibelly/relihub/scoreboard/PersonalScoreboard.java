package fr.relibelly.relihub.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;

    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "Scoreboard");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){}

    public void setLines(String ip){
        objectiveSign.setDisplayName("§c§lRELIHUB");

        objectiveSign.setLine(0, "§1");
        objectiveSign.setLine(1, "§e§lPROFIL:");
        objectiveSign.setLine(2, "§fPseudo: §c" + player.getName());
        objectiveSign.setLine(3, "§2");
        objectiveSign.setLine(4, "§e§lSERVEUR:");
        objectiveSign.setLine(5, "§fJoueurs: §c" + Bukkit.getOnlinePlayers().size());
        objectiveSign.setLine(6, "§3");
        objectiveSign.setLine(7, ip);

        objectiveSign.updateLines();
    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}
