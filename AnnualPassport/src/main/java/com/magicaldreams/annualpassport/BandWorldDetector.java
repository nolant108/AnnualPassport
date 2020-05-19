package com.magicaldreams.annualpassport;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class BandWorldDetector implements Listener{

	private Main main;
	public BandWorldDetector(Main main) {
		// TODO Auto-generated constructor stub
		this.main = main;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void AttractionsDLR(Player player) {
		if(player.getWorld().getWorldFolder().getName().equals("world")) {
			player.sendMessage("World");
		}
		
		if(player.getWorld().getWorldFolder().getName().equals("world_nether")) {
			player.sendMessage("World Nether");
		}
		
	}

}
