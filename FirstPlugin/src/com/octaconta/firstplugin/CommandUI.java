// Package declaration
package com.octaconta.firstplugin;


// Imports
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;

public class CommandUI implements CommandExecutor
{
	
	
	
	
	
	
	// Execute command event
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			TeleportGui tpgui = new TeleportGui();
			
			tpgui.OpenInventory((Player) sender);
		}
		else
		{
			Bukkit.getConsoleSender().sendMessage("ERROR: Command must be executed by a player!");
		}
		
		return false;
	}
	
	
	
	
}
