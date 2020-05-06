package com.magicaldreams.annualpassport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

        public final Logger logger = this.getLogger();

        private Connection connection;
        public String RideName, RideDescription, RideLocation, RideStatus;
        private String host, psswrd;


        @Override
        public void onEnable() {

            System.out.println("AnnualPassport Enabled");


            Bukkit.getPluginManager().registerEvents(new OpenBand(this), this);

            host = "MDDev";
            psswrd = "Abc123no";

            try {
                openConnection();

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "SQL Connected!!");
                System.out.println("SQL Connected!");
            }catch(SQLException x){
                x.printStackTrace();
                System.out.println("!!SQL NOT-CONNECTED!!   ERROR!!");
            }

        }

        private void openConnection() throws SQLException{
            if(connection != null && !connection.isClosed()) {
                connection = DriverManager.getConnection("mongodb+srv://" + this.host + ":" + this.psswrd + "@magicaldreams-jum0e.mongodb.net/test?retryWrites=true&w=majority");
            }
        }

        public static void applyMagicBandUI(Player player) {
            //Beginning
            Inventory MagicbandGUI = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Annual Passport");

            ItemStack report = new ItemStack(Material.BARRIER);
            ItemMeta reportMeta = report.getItemMeta();
            reportMeta.setDisplayName(ChatColor.RED + "Report/Issue");
            report.setItemMeta(reportMeta);

            ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwner(player.getName());
            skullMeta.setDisplayName(ChatColor.YELLOW + player.getName());
            skull.setItemMeta(skullMeta);

            ItemStack parks = new ItemStack(Material.NETHER_STAR);
            ItemMeta parksMeta = parks.getItemMeta();
            parksMeta.setDisplayName(ChatColor.YELLOW + "Parks");
            parks.setItemMeta(parksMeta);

            ItemStack attractions = new ItemStack(Material.MINECART);
            ItemMeta attractionsmeta = attractions.getItemMeta();
            attractionsmeta.setDisplayName(ChatColor.YELLOW + "Attractions");
            attractions.setItemMeta(attractionsmeta);

            ItemStack Entertianment = new ItemStack((Material.LEGACY_FIREWORK));
            ItemMeta EntertianmentMeta = Entertianment.getItemMeta();
            EntertianmentMeta.setDisplayName(ChatColor.YELLOW + "Entertainment");
            Entertianment.setItemMeta(EntertianmentMeta);

            ItemStack Dining = new ItemStack((Material.POTATO));
            ItemMeta DiningMeta = Dining.getItemMeta();
            DiningMeta.setDisplayName(ChatColor.YELLOW + "Dining");
            Dining.setItemMeta(DiningMeta);

            ItemStack Shops = new ItemStack((Material.IRON_CHESTPLATE));
            ItemMeta ShopsMeta = Shops.getItemMeta();
            ShopsMeta.setDisplayName(ChatColor.YELLOW + "Shops");
            Shops.setItemMeta(ShopsMeta);

            ItemStack Shows = new ItemStack((Material.CLOCK));
            ItemMeta ShowsMeta = Shows.getItemMeta();
            ShowsMeta.setDisplayName(ChatColor.YELLOW + "Shops");
            Shows.setItemMeta(ShowsMeta);

            MagicbandGUI.setItem(4, skull);
            MagicbandGUI.setItem(9, report);
            MagicbandGUI.setItem(11, Dining);
            MagicbandGUI.setItem(12, Entertianment);
            MagicbandGUI.setItem(13, parks);
            MagicbandGUI.setItem(14, attractions);
            MagicbandGUI.setItem(15, Shops);
            MagicbandGUI.setItem(17, Shows);

            player.openInventory(MagicbandGUI);
        }


        public void applyParksUI(Player player) {

            //	ResultSet result = DriverManager.executeQuery("SELECT * FROM PlayerData WHERE BALANCE = 0;");		
            //	List<String> bankruptPlayers = new ArrayList<String>();
            //while (result.next()) {
            //    String name = result.getString("PLAYERNAME");
            //    bankruptPlayers.add(name);
            //	}
            List<String> parksLore = new ArrayList<>();
            //	parksLore.add(ChatColor.GRAY + "Ride is: " + );


            Inventory ParksGUI = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Parks");

            ItemStack back = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta backMeta = back.getItemMeta();
            backMeta.setDisplayName(ChatColor.GREEN + "<-- Back");
            back.setItemMeta(backMeta);

            ItemStack parks = new ItemStack(Material.NETHER_STAR);
            ItemMeta parksMeta = parks.getItemMeta();
            parksMeta.setDisplayName(ChatColor.YELLOW + "Parks");
            parks.setItemMeta(parksMeta);

            ItemStack fish = new ItemStack(Material.TROPICAL_FISH);
            ItemMeta fishMeta = fish.getItemMeta();
            fishMeta.setDisplayName(ChatColor.YELLOW + "Join SWSA");
            fish.setItemMeta(fishMeta);

            ItemStack key = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta keyMeta = key.getItemMeta();
            keyMeta.setDisplayName(ChatColor.AQUA + "Join DLR");
            key.setItemMeta(keyMeta);

            ItemStack DAXE = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta DAXEMeta = DAXE.getItemMeta();
            DAXEMeta.setDisplayName(ChatColor.AQUA + "Join Creative");
            DAXE.setItemMeta(DAXEMeta);

            ItemStack Mickey = new ItemStack(Material.POTATO);
            ItemMeta MickeyMeta = Mickey.getItemMeta();
            MickeyMeta.setDisplayName(ChatColor.GOLD + "Join TDL");
            Mickey.setItemMeta(MickeyMeta);

            ItemStack BOOK = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta BOOKMeta = BOOK.getItemMeta();
            BOOKMeta.setDisplayName(ChatColor.BOLD + "Join HUB");
            BOOK.setItemMeta(BOOKMeta);

            ItemStack GAXE = new ItemStack(Material.GOLDEN_PICKAXE);
            ItemMeta GAXEMeta = GAXE.getItemMeta();
            GAXEMeta.setDisplayName(ChatColor.GOLD + "Join Custom");
            GAXE.setItemMeta(GAXEMeta);


            ParksGUI.setItem(4, parks);
            ParksGUI.setItem(12, fish);
            ParksGUI.setItem(13, key);
            ParksGUI.setItem(14, DAXE);
            ParksGUI.setItem(21, Mickey);
            ParksGUI.setItem(22, BOOK);
            ParksGUI.setItem(23, GAXE);
            ParksGUI.setItem(18, back);

            player.openInventory(ParksGUI);


        }


        @Override
        public void onDisable() {

            System.out.println("AnnualPassport Disabled");

        }
        
    }
