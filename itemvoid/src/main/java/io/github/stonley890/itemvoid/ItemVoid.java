package io.github.stonley890.itemvoid;

import io.github.stonley890.itemvoid.commands.*;
import io.github.stonley890.itemvoid.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;

/*
 * The main ticking thread.
 */

public class ItemVoid extends JavaPlugin {

    public static ItemVoid plugin;
    public static Inventory inv = Bukkit.createInventory(null, 27, "Blacklisted Items");
    public static ItemStack[] badItems;

    @Override
    public void onEnable() {

        // Initialize variables
        plugin = this;

        // Register listener
        getServer().getPluginManager().registerEvents(new ListenInventoryClose(), this);

        // Initialize command executor
        Objects.requireNonNull(getCommand("itemblacklist")).setExecutor(new CmdItemBlacklist());

        // Start message
        getLogger().log(Level.INFO, "ItemVoid: A Bukkit plugin that removes blacklisted items from players.");

        // Restore item blacklist
        if (plugin.getConfig().get("itemBlacklist") != null ) {
            ArrayList<ItemStack> itemList = (ArrayList<ItemStack>) plugin.getConfig().get("itemBlacklist");
            if (itemList != null) {
                badItems = itemList.toArray(new ItemStack[0]);
            }

        }
    }

    public static ItemVoid getPlugin() {
        return plugin;
    }

}