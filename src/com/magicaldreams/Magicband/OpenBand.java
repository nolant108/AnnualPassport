package com.magicaldreams.Magicband;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class OpenBand implements Listener{
	
	private Main main;
	
	public OpenBand(Main main) {
		// TODO Auto-generated constructor stub
		
		this.main = main;
	}
	
	
	ItemStack JoinMB;
    ItemMeta JoinMBMeta;
	@EventHandler
	public void MBJoin(PlayerJoinEvent e){
		
		Player player = e.getPlayer();
		
		JoinMB = new ItemStack(Material.FIREWORK_STAR);

		JoinMBMeta = JoinMB.getItemMeta();
		JoinMBMeta.setDisplayName(ChatColor.BLUE + "MagicBand");
		
		player.getInventory().setItem(0, JoinMB);
		
	}
	
	
	
	
	@EventHandler
	public void PlayerMB(PlayerInteractEvent e){
		
		Player player = e.getPlayer();
		
	
		
		
		main.applyMagicBandUI((Player) player);
	
	
	}



}
