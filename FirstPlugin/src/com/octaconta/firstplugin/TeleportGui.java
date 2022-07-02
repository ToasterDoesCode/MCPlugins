// Package declaration
package com.octaconta.firstplugin;

import java.util.ArrayList;

// Imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class TeleportGui implements Listener {
	
	private Inventory gui;
	
	// List of inventory UI items
	final ItemStack spawnItem = new ItemStack(Material.RED_DYE);
	final ItemStack filler = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
	
	
	
	public TeleportGui()
	{
		
		
		this.gui = Bukkit.createInventory(null, 9, "Menu");
		
		// Configure UI items
		// spawnItem
		final ItemMeta spawnItemMeta = spawnItem.getItemMeta();
				
		spawnItemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Teleport to 0, 0");
		
		spawnItem.setItemMeta(spawnItemMeta);
				
		// filler
		final ItemMeta fillerMeta = filler.getItemMeta();
				
		fillerMeta.setDisplayName(" ");
		
		filler.setItemMeta(fillerMeta);
		
		
		// Set up inventory
		gui.setItem(0, filler);
		gui.setItem(1, filler);
		gui.setItem(2, filler);
		
		gui.setItem(4, spawnItem);
		
		gui.setItem(6, filler);
		gui.setItem(7, filler);
		gui.setItem(8, filler);
		
		

	}
	
	public void OpenInventory(Player player)
	{
		// Open the inventory
		player.openInventory(gui);
	}
	
	// Run code once item clicked
	@EventHandler
	public void onInventoryClick(final InventoryClickEvent e)
	{
		ItemStack clicked = e.getCurrentItem();
		
		if (clicked == null || clicked.getType().isAir())
		{
			return;
		}
		
		Player clicker = (Player) e.getWhoClicked();
		
		if (clicked.equals(spawnItem))
		{
			// Get the player's world
			World world = clicker.getWorld();
			
			// Teleport the player to 0, 0
			Location location = new Location(world, 0, 63, 0);
			clicker.teleport(location);
			
			
			
			
			
			
		}
	}
	
	// Cancel dragging the item
	@EventHandler
	public void onInventoryClick(final InventoryDragEvent e)
	{
		if (e.getInventory().equals(gui)) {
	          e.setCancelled(true);
	    }
	}
}
