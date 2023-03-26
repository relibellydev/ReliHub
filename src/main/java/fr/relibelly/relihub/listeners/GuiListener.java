package fr.relibelly.relihub.listeners;

import fr.relibelly.relihub.gui.MainGui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiListener  implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() != null && e.getItem().getItemMeta() != null && e.getItem().getItemMeta().getDisplayName() != null) {
            Player player = e.getPlayer();
            String displayName = e.getItem().getItemMeta().getDisplayName();
            if (displayName.equals("§e§lMenu Principal §7(Clique Droit)")) {
                (new MainGui(player)).mainGui();
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (e.getCurrentItem() == null && e.getAction() != null) {
            return;
        }

        e.setCancelled(true);

        if (e.getInventory().getName().equals("§e§lMenu Principal")) {
            Player player = (Player) e.getWhoClicked();
            ItemStack clickedItem = e.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                ItemMeta clickedItemMeta = clickedItem.getItemMeta();

                if (clickedItemMeta.hasDisplayName()) {
                    String displayName = clickedItemMeta.getDisplayName();

                    if (displayName.equals("§c§lFermer")) {
                        player.closeInventory();
                    } else if (displayName.equals("§c§lJeu#1")) {
                        player.sendMessage("§cJeu#1");
                        player.closeInventory();
                    } else if (displayName.equals("§c§lJeu#2")) {
                        player.sendMessage("§cJeu#2");
                        player.closeInventory();
                    } else if (displayName.equals("§c§lJeu#3")) {
                        player.sendMessage("§cJeu#3");
                        player.closeInventory();
                    }
                }
            }
        }
    }


}