package com.magicaldreams.Magicband;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_14_R1.Item;





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
	        
        
        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner(player.getName());
        skullMeta.setDisplayName(ChatColor.YELLOW + player.getName() + "'s MagicBand");
        skull.setItemMeta(skullMeta);
        
        
        MagicbandGUI.setItem(4, skull);

        
        
        player.openInventory(MagicbandGUI);
	}
	

	

	
	@Override
	public void onDisable() {
		
		System.out.println("MagicBand Disabled");
		
	}

}
