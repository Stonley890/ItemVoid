package io.github.stonley890.itemvoid.commands;

import io.github.stonley890.itemvoid.ItemVoid;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CmdItemBlacklist implements CommandExecutor {

    static ItemVoid plugin = ItemVoid.getPlugin();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (ItemVoid.badItems != null) {
                ItemVoid.inv.setContents(ItemVoid.badItems);
            }


            player.openInventory(ItemVoid.inv);
        }

        return true;
    }

    public static void saveItems() {
        ItemVoid.badItems = ItemVoid.inv.getContents();
        plugin.getConfig().set("itemBlacklist", ItemVoid.badItems);
        plugin.saveConfig();
    }
}