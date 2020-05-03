package com.magicaldreams.Magicband;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		System.out.println("MagicBand Enabled");
		
        Bukkit.getPluginManager().registerEvents(new OpenBand(this), this);

		
		
	}
	
	public void applyMagicBandUI(Player player) {
        //Beginning
        Inventory MagicbandGUI = Bukkit.createInventory(null, 9, ChatColor.BLUE + "MagicBand");
	
        
        ItemStack LEATHER_HELMET = new ItemStack(Material.LEATHER_HELMET, 1);

        
        MagicbandGUI.setItem(0, LEATHER_HELMET);
        
        
        player.openInventory(MagicbandGUI);
	}
	
	
	
	
	@Override
	public void onDisable() {
		
		System.out.println("MagicBand Disabled");
		
	}

}
