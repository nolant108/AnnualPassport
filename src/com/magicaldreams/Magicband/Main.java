package com.magicaldreams.Magicband;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;





public class Main extends JavaPlugin{
	public final Logger logger = this.getLogger();
	

	
	@Override
	public void onEnable() {
		
		System.out.println("MagicBand Enabled");
		
		
		Bukkit.getPluginManager().registerEvents(new OpenBand(this), this);
				
	}
	
	public void applyMagicBandUI(Player player) {
        //Beginning
        Inventory MagicbandGUI = Bukkit.createInventory(null, 27, ChatColor.BLUE + "MagicBand");
	
        
        
        
        player.openInventory(MagicbandGUI);
	}
	

	

	
	@Override
	public void onDisable() {
		
		System.out.println("MagicBand Disabled");
		
	}

}
