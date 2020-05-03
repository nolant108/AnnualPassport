package com.magicaldreams.Magicband;

import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class OpenBand implements Listener{
	
	private Main main;
	
	public OpenBand(Main main) {
		// TODO Auto-generated constructor stub
		
		this.main = main;
	}
	
	
	
	
	@EventHandler
	public void PlayerMB(PlayerInteractEvent e){
		
		Player player = e.getPlayer();
		
	
		
		System.out.println("Opened");

		
		main.applyMagicBandUI((Player) player);
	
	
	}



}
