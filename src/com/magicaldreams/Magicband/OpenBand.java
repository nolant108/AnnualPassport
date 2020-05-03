package com.magicaldreams.Magicband;

import java.util.ArrayList;

import org.bukkit.ChatColor;
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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;


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
		
		
	
        ((Player) player).playSound(((OfflinePlayer) player).getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 2.0F, 1.0F);
		
		main.applyMagicBandUI((Player) player);
		
		
		
		
		
	
	}


	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
        Player player = (Player) e.getWhoClicked();
		
		
		if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "MagicBand")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
                
                case LEGACY_SKULL_ITEM:
                    player.closeInventory();

                	
                    break;
                default:
                    return;
	
                }
            }
	 }

		
	}



}
