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
            Bukkit.getPluginManager().registerEvents(new BandWorldDetector(this), this);


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

        @SuppressWarnings("deprecation")
		public static void applyMagicBandUI(Player player) {
            //Beginning
            Inventory MagicbandGUI = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Annual Passport");
            
            List<String> playerLore = new ArrayList<>();
            playerLore.add(ChatColor.RED + "Audio, Time, Report");
            playerLore.add(ChatColor.GRAY + "Player Vis., Resource Pack, Scoreboard Toggle");


            ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwner(player.getName());
            skullMeta.setDisplayName(ChatColor.YELLOW + player.getName() + "'s Settings");
            skull.setItemMeta(skullMeta);
            skullMeta.setLore(playerLore);

            ItemStack parks = new ItemStack(Material.NETHER_STAR);
            ItemMeta parksMeta = parks.getItemMeta();
            parksMeta.setDisplayName(ChatColor.YELLOW + "Parks");
            parks.setItemMeta(parksMeta);

            ItemStack attractions = new ItemStack(Material.MINECART);
            ItemMeta attractionsmeta = attractions.getItemMeta();
            attractionsmeta.setDisplayName(ChatColor.YELLOW + "Attractions");
            attractions.setItemMeta(attractionsmeta);

            ItemStack Entertianment = new ItemStack((Material.FIREWORK_ROCKET));
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
            
            
            ItemStack BSG = new ItemStack((Material.BLUE_STAINED_GLASS_PANE));
            ItemMeta BSGMeta = BSG.getItemMeta();
            BSGMeta.setDisplayName(" ");
            BSG.setItemMeta(BSGMeta);
            
            ItemStack GSG = new ItemStack((Material.GREEN_STAINED_GLASS_PANE));
            ItemMeta GSGMeta = GSG.getItemMeta();
            GSGMeta.setDisplayName(" ");
            GSG.setItemMeta(GSGMeta);
            
            
            MagicbandGUI.setItem(0, BSG);
            MagicbandGUI.setItem(1, BSG);
            MagicbandGUI.setItem(2, BSG);
            MagicbandGUI.setItem(3, BSG);
            MagicbandGUI.setItem(4, skull);
            MagicbandGUI.setItem(5, BSG);
            MagicbandGUI.setItem(6, BSG);
            MagicbandGUI.setItem(7, BSG);
            MagicbandGUI.setItem(8, BSG);
            MagicbandGUI.setItem(9, GSG);
            MagicbandGUI.setItem(10, GSG);
            MagicbandGUI.setItem(11, Dining);
            MagicbandGUI.setItem(12, Entertianment);
            MagicbandGUI.setItem(13, parks);
            MagicbandGUI.setItem(14, attractions);
            MagicbandGUI.setItem(15, Shops);
            MagicbandGUI.setItem(16, GSG);
            MagicbandGUI.setItem(17, GSG);
            MagicbandGUI.setItem(18, BSG);
            MagicbandGUI.setItem(19, BSG);
            MagicbandGUI.setItem(20, BSG);
            MagicbandGUI.setItem(21, BSG);
      //UNDOWN(HIDDEN MICKIE)      
            MagicbandGUI.setItem(23, BSG);
            MagicbandGUI.setItem(24, BSG);
            MagicbandGUI.setItem(25, BSG);
            MagicbandGUI.setItem(26, BSG);



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

            ItemStack back = new ItemStack(Material.PAPER);
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
            MickeyMeta.setDisplayName(ChatColor.GOLD + "Join TDR");
            Mickey.setItemMeta(MickeyMeta);

            ItemStack BOOK = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta BOOKMeta = BOOK.getItemMeta();
            BOOKMeta.setDisplayName(ChatColor.BOLD + "Join HUB");
            BOOK.setItemMeta(BOOKMeta);

            ItemStack GAXE = new ItemStack(Material.GOLDEN_PICKAXE);
            ItemMeta GAXEMeta = GAXE.getItemMeta();
            GAXEMeta.setDisplayName(ChatColor.GOLD + "Join Custom");
            GAXE.setItemMeta(GAXEMeta);
            
            ItemStack BSG = new ItemStack((Material.BLUE_STAINED_GLASS_PANE));
            ItemMeta BSGMeta = BSG.getItemMeta();
            BSGMeta.setDisplayName(" ");
            BSG.setItemMeta(BSGMeta);
            
            ItemStack GSG = new ItemStack((Material.GREEN_STAINED_GLASS_PANE));
            ItemMeta GSGMeta = GSG.getItemMeta();
            GSGMeta.setDisplayName(" ");
            GSG.setItemMeta(GSGMeta);


            ParksGUI.setItem( 0,BSG);
            ParksGUI.setItem( 1,BSG);
            ParksGUI.setItem( 2,BSG);
            ParksGUI.setItem(3 ,BSG);
            ParksGUI.setItem(4 ,key);
            ParksGUI.setItem(5 ,BSG);
            ParksGUI.setItem( 6,BSG);
            ParksGUI.setItem( 7,BSG);
            ParksGUI.setItem( 8,BSG);
            ParksGUI.setItem(9 ,parks);
            ParksGUI.setItem(10 ,GSG);
            ParksGUI.setItem( 11,GSG);
            ParksGUI.setItem(12 , GAXE);
            ParksGUI.setItem( 13, BOOK);
            ParksGUI.setItem( 14, DAXE);
            ParksGUI.setItem( 15,GSG);
            ParksGUI.setItem( 16,GSG);
            ParksGUI.setItem( 17, back);
            ParksGUI.setItem( 18,BSG);
            ParksGUI.setItem( 19,BSG);
            ParksGUI.setItem( 20,BSG);
            ParksGUI.setItem( 21,BSG);
            ParksGUI.setItem( 22,Mickey);
            ParksGUI.setItem( 23,BSG);
            ParksGUI.setItem( 24,BSG);
            ParksGUI.setItem( 25,BSG);
            ParksGUI.setItem( 26,BSG);


            player.openInventory(ParksGUI);


        }
        
        public void applyShowTimesUI(Player player) {
        	
            List<String> STM = new ArrayList<>();
            STM.add(ChatColor.GREEN + "9:00am-11:00am");

            List<String> STA = new ArrayList<>();
            STA.add(ChatColor.GREEN + "12:00pm-5:00pm");

            List<String> STE = new ArrayList<>();
            STE.add(ChatColor.GREEN + "6:00pm-11:00pm");


        	
            Inventory ShowTimesGUI = Bukkit.createInventory(null, 54, ChatColor.BLUE + "Show Times");
            
            ItemStack back = new ItemStack(Material.PAPER);
            ItemMeta backMeta = back.getItemMeta();
            backMeta.setDisplayName(ChatColor.GREEN + "<-- Back");
            back.setItemMeta(backMeta);
            
            ItemStack Entertianment = new ItemStack((Material.FIREWORK_ROCKET));
            ItemMeta EntertianmentMeta = Entertianment.getItemMeta();
            EntertianmentMeta.setDisplayName(ChatColor.YELLOW + "Entertainment");
            Entertianment.setItemMeta(EntertianmentMeta);
            
            ItemStack ShowsM = new ItemStack((Material.CLOCK));
            ItemMeta ShowsMMeta = ShowsM.getItemMeta();
            ShowsMMeta.setDisplayName(ChatColor.GREEN + "9:00am-11:00am");
            ShowsM.setItemMeta(ShowsMMeta);
            ShowsMMeta.setLore(STM);
            
            ItemStack ShowsA = new ItemStack((Material.CLOCK));
            ItemMeta ShowsAMeta = ShowsA.getItemMeta();
            ShowsAMeta.setDisplayName(ChatColor.GREEN + "12:00pm-5:00pm");
            ShowsA.setItemMeta(ShowsAMeta);
            ShowsAMeta.setLore(STA);
            
            ItemStack ShowsE = new ItemStack((Material.CLOCK));
            ItemMeta ShowsEMeta = ShowsE.getItemMeta();
            ShowsEMeta.setDisplayName(ChatColor.GREEN + "6:00pm-11:00pm");
            ShowsE.setItemMeta(ShowsEMeta);
            ShowsEMeta.setLore(STE);
            
            
            
            ItemStack ShowM1 = new ItemStack((Material.LIGHT_BLUE_DYE));
            ItemMeta ShowM1Meta = ShowM1.getItemMeta();
            ShowM1Meta.setDisplayName(ChatColor.YELLOW + "Show M 1");
            ShowM1.setItemMeta(ShowM1Meta);
            
            ItemStack ShowM2 = new ItemStack((Material.LIGHT_BLUE_DYE));
            ItemMeta ShowM2Meta = ShowM2.getItemMeta();
            ShowM2Meta.setDisplayName(ChatColor.YELLOW + "Show M 2");
            ShowM2.setItemMeta(ShowM2Meta);

            ItemStack ShowM3 = new ItemStack((Material.LIGHT_BLUE_DYE));
            ItemMeta ShowM3Meta = ShowM1.getItemMeta();
            ShowM3Meta.setDisplayName(ChatColor.YELLOW + "Show M 3");
            ShowM3.setItemMeta(ShowM3Meta);
            
            ItemStack ShowM4 = new ItemStack((Material.LIGHT_BLUE_DYE));
            ItemMeta ShowM4Meta = ShowM4.getItemMeta();
            ShowM4Meta.setDisplayName(ChatColor.YELLOW + "Show M 4");
            ShowM4.setItemMeta(ShowM4Meta);
            

            
            
            ItemStack ShowA1 = new ItemStack((Material.MAGENTA_DYE));
            ItemMeta ShowA1Meta = ShowA1.getItemMeta();
            ShowA1Meta.setDisplayName(ChatColor.YELLOW + "Show A 1");
            ShowA1.setItemMeta(ShowA1Meta);
            
            ItemStack ShowA2 = new ItemStack((Material.MAGENTA_DYE));
            ItemMeta ShowA2Meta = ShowA2.getItemMeta();
            ShowA2Meta.setDisplayName(ChatColor.YELLOW + "Show A 2");
            ShowA2.setItemMeta(ShowA2Meta);
            
            ItemStack ShowA3 = new ItemStack((Material.MAGENTA_DYE));
            ItemMeta ShowA3Meta = ShowA3.getItemMeta();
            ShowA3Meta.setDisplayName(ChatColor.YELLOW + "Show A 3");
            ShowA3.setItemMeta(ShowA3Meta);
            
            ItemStack ShowA4 = new ItemStack((Material.MAGENTA_DYE));
            ItemMeta ShowA4Meta = ShowA4.getItemMeta();
            ShowA4Meta.setDisplayName(ChatColor.YELLOW + "Show A 4");
            ShowA4.setItemMeta(ShowA4Meta);
            
            
            
            
            
            ItemStack ShowE1 = new ItemStack((Material.ORANGE_DYE));
            ItemMeta ShowE1Meta = ShowE1.getItemMeta();
            ShowE1Meta.setDisplayName(ChatColor.YELLOW + "Show E 1");
            ShowE1.setItemMeta(ShowE1Meta);
            
            ItemStack ShowE2 = new ItemStack((Material.ORANGE_DYE));
            ItemMeta ShowE2Meta = ShowE2.getItemMeta();
            ShowE2Meta.setDisplayName(ChatColor.YELLOW + "Show E 2");
            ShowE2.setItemMeta(ShowE2Meta);
            
            ItemStack ShowE3 = new ItemStack((Material.ORANGE_DYE));
            ItemMeta ShowE3Meta = ShowE3.getItemMeta();
            ShowE3Meta.setDisplayName(ChatColor.YELLOW + "Show E 3");
            ShowE3.setItemMeta(ShowE3Meta);
            
            ItemStack ShowE4 = new ItemStack((Material.ORANGE_DYE));
            ItemMeta ShowE4Meta = ShowE4.getItemMeta();
            ShowE4Meta.setDisplayName(ChatColor.YELLOW + "Show E 4");
            ShowE4.setItemMeta(ShowE4Meta);

            
            
            
            ItemStack BSG = new ItemStack((Material.BLUE_STAINED_GLASS_PANE));
            ItemMeta BSGMeta = BSG.getItemMeta();
            BSGMeta.setDisplayName(" ");
            BSG.setItemMeta(BSGMeta);
            
            ItemStack GSG = new ItemStack((Material.GREEN_STAINED_GLASS_PANE));
            ItemMeta GSGMeta = GSG.getItemMeta();
            GSGMeta.setDisplayName(" ");
            GSG.setItemMeta(GSGMeta);
            
            ShowTimesGUI.setItem(0, BSG);
            ShowTimesGUI.setItem(1, BSG);
            ShowTimesGUI.setItem(2, BSG);
            ShowTimesGUI.setItem(3, BSG);
            ShowTimesGUI.setItem(4, Entertianment);
            ShowTimesGUI.setItem(5, BSG);
            ShowTimesGUI.setItem(6, BSG);
            ShowTimesGUI.setItem(7, BSG);
            ShowTimesGUI.setItem(8, back);
            ShowTimesGUI.setItem(9, ShowsM);
            ShowTimesGUI.setItem(10, ShowM1);
           // ShowTimesGUI.setItem(11, );
            ShowTimesGUI.setItem(12, ShowM2);
          //  ShowTimesGUI.setItem(13, );
            ShowTimesGUI.setItem(14, ShowM3);
          //  ShowTimesGUI.setItem(15, );
            ShowTimesGUI.setItem(16, ShowM4);
          //  ShowTimesGUI.setItem(17, );
            ShowTimesGUI.setItem(18, GSG);
            ShowTimesGUI.setItem(19, GSG);
            ShowTimesGUI.setItem(20, GSG);
            ShowTimesGUI.setItem(21, GSG);
            ShowTimesGUI.setItem(22, GSG);
            ShowTimesGUI.setItem(23, GSG);
            ShowTimesGUI.setItem(24, GSG);
            ShowTimesGUI.setItem(25, GSG);
            ShowTimesGUI.setItem(26, GSG);
            ShowTimesGUI.setItem(27, ShowsA);
            ShowTimesGUI.setItem(28, ShowA1);
          //  ShowTimesGUI.setItem(29, );
            ShowTimesGUI.setItem(30, ShowA2);
           // ShowTimesGUI.setItem(31, );
            ShowTimesGUI.setItem(32, ShowA3);
         //   ShowTimesGUI.setItem(33, );
            ShowTimesGUI.setItem(34, ShowA4);
         //   ShowTimesGUI.setItem(35, );
            ShowTimesGUI.setItem(36, BSG);
            ShowTimesGUI.setItem(37, BSG);
            ShowTimesGUI.setItem(38, BSG);
            ShowTimesGUI.setItem(39, BSG);
            ShowTimesGUI.setItem(40, BSG);
            ShowTimesGUI.setItem(41, BSG);
            ShowTimesGUI.setItem(42, BSG);
            ShowTimesGUI.setItem(43, BSG);
            ShowTimesGUI.setItem(44, BSG);
            ShowTimesGUI.setItem(45, ShowsE);
            ShowTimesGUI.setItem(46, ShowE1);
         //   ShowTimesGUI.setItem(47, );
            ShowTimesGUI.setItem(48, ShowE2);
         //   ShowTimesGUI.setItem(49, );
            ShowTimesGUI.setItem(50, ShowE3);
          //  ShowTimesGUI.setItem(51, );
            ShowTimesGUI.setItem(52, ShowE4);
         //   ShowTimesGUI.setItem(53, );
            
            
            player.openInventory(ShowTimesGUI);
        	
            
            
        }
        
        
        public void applyPlayerUI(Player player) {
        	
            Inventory PlayerGUI = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Player Settings");

            ItemStack BSG = new ItemStack((Material.BLUE_STAINED_GLASS_PANE));
            ItemMeta BSGMeta = BSG.getItemMeta();
            BSGMeta.setDisplayName(" ");
            BSG.setItemMeta(BSGMeta);
            
            ItemStack GSG = new ItemStack((Material.GREEN_STAINED_GLASS_PANE));
            ItemMeta GSGMeta = GSG.getItemMeta();
            GSGMeta.setDisplayName(" ");
            GSG.setItemMeta(GSGMeta);
            
            ItemStack audioS = new ItemStack(Material.JUKEBOX);
            ItemMeta audioSMeta = audioS.getItemMeta();
            audioSMeta.setDisplayName(ChatColor.GOLD + "Connect To Audio Server");
            audioS.setItemMeta(audioSMeta);
            
            ItemStack report = new ItemStack(Material.BOOK);
            ItemMeta reportMeta = report.getItemMeta();
            reportMeta.setDisplayName(ChatColor.GOLD + "Report / Issue");
            report.setItemMeta(reportMeta);
            
            ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwner(player.getName());
            skullMeta.setDisplayName(ChatColor.YELLOW + player.getName() + "'s Settings");
            skull.setItemMeta(skullMeta);
            
            ItemStack back = new ItemStack(Material.PAPER);
            ItemMeta backMeta = back.getItemMeta();
            backMeta.setDisplayName(ChatColor.GREEN + "<-- Back");
            back.setItemMeta(backMeta);
            
            PlayerGUI.setItem(0, BSG);
            PlayerGUI.setItem(1, BSG);
            PlayerGUI.setItem(2, BSG);
            PlayerGUI.setItem(3, BSG);
            PlayerGUI.setItem(4, skull);
            PlayerGUI.setItem(5, BSG);
            PlayerGUI.setItem(6, BSG);
            PlayerGUI.setItem(7, BSG);
            PlayerGUI.setItem(8, BSG);
            PlayerGUI.setItem(9, GSG);
            PlayerGUI.setItem(10, GSG);
            //
            //
            PlayerGUI.setItem(13, report);
            //
            //
            PlayerGUI.setItem(16, GSG);
            PlayerGUI.setItem(17, back);
            PlayerGUI.setItem(18, BSG);
            PlayerGUI.setItem(19, BSG);
            PlayerGUI.setItem(20, BSG);
            PlayerGUI.setItem(21, BSG);
            PlayerGUI.setItem(22, audioS);
            PlayerGUI.setItem(23, BSG);
            PlayerGUI.setItem(24, BSG);
            PlayerGUI.setItem(25, BSG);
            PlayerGUI.setItem(26, BSG);

            player.openInventory(PlayerGUI);
            
        }


        @Override
        public void onDisable() {

            System.out.println("AnnualPassport Disabled");

        }
        
    }
