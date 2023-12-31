package io.github.stonley890.itemvoid.commands;

import io.github.stonley890.itemvoid.ItemVoid;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CmdItemBlacklist implements CommandExecutor {

    public static Inventory inv = Bukkit.createInventory(null, 27, "Blacklisted Items");
    public static ItemStack[] badItems;
    static ItemVoid plugin = ItemVoid.getPlugin();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (badItems != null) {
                inv.setContents(CmdItemBlacklist.badItems);
            }


            player.openInventory(inv);
        }

        return true;
    }

    public static void saveItems() {
        badItems = inv.getContents();
        plugin.getConfig().set("itemBlacklist", badItems);
        plugin.saveConfig();
    }
}
