// Package declaration
package com.octaconta.firstplugin;


// Imports
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class Main extends JavaPlugin
{	
	@Override
	public void onEnable()
	{
		this.getCommand("ui").setExecutor(new CommandUI());
		
		Bukkit.getServer().getPluginManager().registerEvents(new TeleportGui(), this);
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
