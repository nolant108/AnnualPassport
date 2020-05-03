package com.magicaldreams.Magicband;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import net.minecraft.server.v1_14_R1.ItemStack;

public class OpenBand implements Listener{
	
	private Main main;
	
	public OpenBand(Main main) {
		// TODO Auto-generated constructor stub
		
		this.main = main;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		
	if(e.getCurrentItem().getType() == Material.FIREWORK_STAR) {
		
		
		
		main.applyMagicBandUI((Player) e);
		((Player) e).playSound(((OfflinePlayer) e).getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5.0F, 1.0F);
	}
	}


	

}
