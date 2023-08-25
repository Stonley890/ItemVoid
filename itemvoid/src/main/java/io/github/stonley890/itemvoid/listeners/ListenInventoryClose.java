package io.github.stonley890.itemvoid.listeners;

import io.github.stonley890.itemvoid.commands.CmdItemBlacklist;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class ListenInventoryClose implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (!player.hasPermission("itemvoid.bypass")) {

            for (ItemStack item : CmdItemBlacklist.badItems) {
                if (item != null) {
                    for (ItemStack content : player.getInventory().getContents()) {
                        if (content.isSimilar(item)) {

                            player.getInventory().remove(item);
                        }
                    }
                }
            }
        }

        if (event.getInventory().equals(CmdItemBlacklist.inv)) {
            CmdItemBlacklist.saveItems();
        }
    }
}
