package com.magicaldreams.Magicband;



import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
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
		JoinMBMeta.setDisplayName(ChatColor.BLUE + player.getName() + "'s MagicBand");
		
		JoinMB.setItemMeta(JoinMBMeta);
		
		player.getInventory().setItem(0, JoinMB);
		
	}
	
	
	
	
	@EventHandler
	public void PlayerMB(PlayerInteractEvent e){
		
		Player player = e.getPlayer();
		
		
	
        ((Player) player).playSound(((OfflinePlayer) player).getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 2.0F, 1.0F);
		
		main.applyMagicBandUI((Player) player);
		
		
		
		
		
	
	}


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e) throws IOException, URISyntaxException {
		
        Player player = (Player) e.getWhoClicked();
		
		
		if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "MagicBand")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
                
                case LEGACY_SKULL_ITEM:
                	
                	
                	break;
                case BARRIER:
                	player.sendMessage(ChatColor.YELLOW + "Click this link to Report/Issue: https://docs.google.com/forms/d/e/1FAIpQLSf-7fXP9KbaQ6FcpzPaqBA7eeqtBIr1mc0cfxFtQmHMBNp_dg/viewform");
                	System.out.println("-------------------- " + player.getName() + " has to report something --------------------");
                	
                    break;
                default:
                    return;
	
                }
            }       
            player.closeInventory();

	 }

		
	}



}
