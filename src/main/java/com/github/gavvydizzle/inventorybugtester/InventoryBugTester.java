package com.github.gavvydizzle.inventorybugtester;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class InventoryBugTester extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() != null && e.getSlot() <= 8) {
            e.getWhoClicked().openInventory(Bukkit.createInventory(null, 27,  String.valueOf(UUID.randomUUID())));
        }
    }

    @EventHandler
    private void onInventoryClose(InventoryCloseEvent e) {
        getLogger().info("Inventory Closed");
    }
}
