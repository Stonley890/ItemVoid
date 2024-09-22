package io.github.stonley890.itemvoid.listeners;

import io.github.stonley890.itemvoid.ItemVoid;
import io.github.stonley890.itemvoid.commands.CmdItemBlacklist;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ListenInventoryClose implements Listener {

    @EventHandler
    public void onInventoryClose(@NotNull InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (!player.hasPermission("itemvoid.bypass")) {

            for (ItemStack item : ItemVoid.badItems) {
                if (item != null) {
                    for (ItemStack content : player.getInventory().getContents()) {
                        if (content != null && content.isSimilar(item)) {
                            player.getInventory().remove(content);
                        }
                    }
                    if (player.getInventory().getItemInOffHand().isSimilar(item)) player.getInventory().setItem(EquipmentSlot.OFF_HAND, null);
                    ItemStack helmet = player.getInventory().getHelmet();
                    if (helmet != null && helmet.isSimilar(item)) player.getInventory().setItem(EquipmentSlot.HEAD, null);
                    ItemStack chest = player.getInventory().getChestplate();
                    if (chest != null && chest.isSimilar(item)) player.getInventory().setItem(EquipmentSlot.CHEST, null);
                    ItemStack legs = player.getInventory().getLeggings();
                    if (legs != null && legs.isSimilar(item)) player.getInventory().setItem(EquipmentSlot.LEGS, null);
                    ItemStack feet = player.getInventory().getBoots();
                    if (feet != null && feet.isSimilar(item)) player.getInventory().setItem(EquipmentSlot.FEET, null);
                }
            }
        }

        if (event.getInventory().equals(ItemVoid.inv)) {
            CmdItemBlacklist.saveItems();
        }
    }
}