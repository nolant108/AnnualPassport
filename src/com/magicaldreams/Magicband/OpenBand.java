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
	public void MBonClick(InventoryClickEvent e) throws IOException, URISyntaxException {
		
        Player player = (Player) e.getWhoClicked();
		
		
		if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "MagicBand")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
                
                case LEGACY_SKULL_ITEM:
                    player.closeInventory();

                	
                	break;
                case BARRIER:
                	player.sendMessage(ChatColor.YELLOW + "Click this link to Report/Issue: https://docs.google.com/forms/d/e/1FAIpQLSf-7fXP9KbaQ6FcpzPaqBA7eeqtBIr1mc0cfxFtQmHMBNp_dg/viewform");
                	System.out.println("-------------------- " + player.getName() + " has to report something --------------------");
                	player.sendMessage(ChatColor.RED + "The staff has been notified of your issue!");
                    player.closeInventory();

                	break;
                case NETHER_STAR:
                    main.applyParksUI((Player) player);
                	
                    break;
                default:
                    return;
	
                }
            }       

	 }

		
	}
	
	@EventHandler
	public void ParksonClick(InventoryClickEvent e) {
		
Player player = (Player) e.getWhoClicked();
		
		
		if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Parks")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
                case GREEN_STAINED_GLASS_PANE:
                    main.applyMagicBandUI((Player) player);
                    
                	break;
                case TROPICAL_FISH:
                	player.performCommand("join swsa");
                	player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: SWSA");
                	
                	break;
                case DIAMOND_HOE:
                	player.performCommand("join dlr");
                	player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: DLR");
                	
                	break;
                case DIAMOND_PICKAXE:
                	player.performCommand("join creative");
                	player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: Creative");

                	break;
                case POTATO:
                	player.performCommand("join tdr");
                	player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: TDR");

                	break;
                case ENCHANTED_BOOK:
                	player.performCommand("join hub");
                	player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: HUB");

                	break;
                case GOLDEN_PICKAXE:
                	player.performCommand("join custom");
                	player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: Custom");

                break;
            default:
                return;
                }
            }
            player.closeInventory();
            
                }
		
	}



}
