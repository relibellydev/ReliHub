package fr.relibelly.relihub.gui;

import fr.relibelly.relihub.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;


public class MainGui {

    private Player player;

    public MainGui(Player player) {
        this.player = player;
    }
    public void mainGui() {
        Inventory gui = Bukkit.createInventory((InventoryHolder) null, 54, "§e§lMenu Principal");
        gui.setItem(49, new ItemBuilder(Material.BARRIER).setDisplayName("§c§lFermer").build(false));
        gui.setItem(20, new ItemBuilder(Material.BARRIER).setDisplayName("§c§lJeu#1").build(false));
        gui.setItem(22, new ItemBuilder(Material.BARRIER).setDisplayName("§c§lJeu#2").build(false));
        gui.setItem(24, new ItemBuilder(Material.BARRIER).setDisplayName("§c§lJeu#3").build(false));
        this.player.openInventory(gui);
    }

}
