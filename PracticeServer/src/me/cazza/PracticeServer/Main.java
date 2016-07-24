package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import ca.wacos.nametagedit.NametagAPI;
import me.confuser.barapi.BarAPI;
import me.matt11matthew.PSEnchants;
import me.matt11matthew.Utils;
import me.matt11matthew.commands.CommandSC;
import me.matt11matthew.commands.CommandSayall;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main
  extends JavaPlugin
  implements Listener
{
  WorldGuardPlugin wg = (WorldGuardPlugin)Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
  public static List<String> togglepvp = new ArrayList<String>(); 
  public static List<String> cooldown = new ArrayList<String>(); 
  public static List<String> suicide = new ArrayList<String>();
  public static List<String> toggletrail = new ArrayList<String>();
  public static List<String> tagged = new ArrayList<String>();
  public static List<String> bank = new ArrayList<String>();
  public static List<String> logout = new ArrayList<String>();
  public static List<String> debug = new ArrayList<String>();
  public static List<String> mount = new ArrayList<String>();
  public static List<String> togglechaos = new ArrayList<String>();
  public static List<String> togglebankgem = new ArrayList<String>();
  public static List<String> MSF = new ArrayList<String>(); // Mount Spam Fix
  public static Main plugin;
  int timesRan = 4;
  public static Economy econ = null;
  private static final Logger log = Logger.getLogger("Minecraft");
  public static Permission perms = null;
  public static Chat chat = null;
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	Player play = (Player)sender;
	String pn = play.getName();
    if ((sender instanceof Player))
    {
      final Player p = (Player)sender;
      if (cmd.getName().equalsIgnoreCase("setalignment") && (p.hasPermission("ps.setalignment"))) {
          if ((args.length < 2) || (args.length > 2)) {
              p.sendMessage(ChatColor.RED + "Incorrect Syntax: " + ChatColor.GRAY + "/setalignment <player> <alignment>");
          }
          if ((args.length == 2))
          {
              if(args[1].equalsIgnoreCase("lawful")){
                  Respawn.neutral.remove(args[0]);
                  Respawn.chaotic.remove(args[0]);
                  NametagAPI.updateNametagHard(args[0], null, null);
                  Player target = Bukkit.getPlayer(args[0]);
                  p.sendMessage(ChatColor.GREEN + "You have set " + args[0] + "'s alignment to lawful!");
                  target.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                  target.sendMessage("§7While lawful, you will not lose any equiped armor on death.");
                  target.sendMessage("§7Any players who kill you while you're lawfully aligned will");
                  target.sendMessage("§7become chaotic.");
                  target.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
              }
              if(args[1].equalsIgnoreCase("neutral")){
                  Respawn.chaotic.remove(args[0]);
                  Respawn.neutral.add(args[0]);
                    NametagAPI.updateNametagHard(args[0],
                      ChatColor.YELLOW.toString(), null);
                    Player target = Bukkit.getPlayer(args[0]);
                    p.sendMessage(ChatColor.GREEN + "You have set " + args[0] + "'s alignment to neutral!");
                    target.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
                    target.sendMessage("§7While neutral, players who kill you will not become chaotic. You");
                    target.sendMessage("§7have a 50% chance of dropping your weapon, and a 25%");
                    target.sendMessage("§7chance of dropping each piece of equiped armor on death.");
                    target.sendMessage("§7Neutral alignment will expire 1 minute after last hit on player.");
                    target.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
                    new BukkitRunnable()
                    {
                      public void run()
                      {
                        Respawn.neutral.remove(target.getName());
                        if ((!Respawn.neutral.contains(target.getName())) &&
                          (!Respawn.chaotic.contains(target.getName())) &&
                          (target.isOnline()))
                        {
                            target.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                            target.sendMessage("§7While lawful, you will not lose any equiped armor on death.");
                            target.sendMessage("§7Any players who kill you while you're lawfully aligned will");
                            target.sendMessage("§7become chaotic.");
                            target.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                          NametagAPI.updateNametagHard(target.getName(), null,
                            null);
                        }
                      }
                    }.runTaskLater(this, 1200L);
              }
              if(args[1].equalsIgnoreCase("chaotic")){
                  Respawn.chaotic.add(args[0]);
                  NametagAPI.updateNametagHard(args[0],
                          ChatColor.RED.toString().toString(), null);
                  Player target = Bukkit.getPlayer(args[0]);
                  p.sendMessage(ChatColor.GREEN + "You have set " + args[0] + "'s alignment to chaotic!");
                  target.sendMessage("          §c* YOU ARE NOW §lCHAOTIC §cALIGNMENT *");
                  target.sendMessage("§7If you are killed while chaotic, you will lose everything");
                  target.sendMessage("§7in your inventory. Chaotic alignment will expire 5 minutes after");
                  target.sendMessage("§7your last player kill.");
                  target.sendMessage("          §c* YOU ARE NOW §lCHAOTIC §cALIGNMENT *");
                  target.sendMessage("§cYou have been set to the chaotic aligment by an admin!");
                  new BukkitRunnable()
                    {
                      public void run()
                      {
                        Respawn.chaotic.remove(target.getName());
                        Respawn.neutral.add(target.getName());
                        if ((!Respawn.chaotic.contains(target.getName())) &&
                          (target.isOnline()))
                        {
                            target.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
                            target.sendMessage("§7While neutral, players who kill you will not become chaotic. You");
                            target.sendMessage("§7have a 50% chance of dropping your weapon, and a 25%");
                            target.sendMessage("§7chance of dropping each piece of equipped armor on death.");
                            target.sendMessage("§7Neutral alignment will expire 1 minute after last hit on player.");
                            target.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
                          NametagAPI.updateNametagHard(target.getName(),
                            ChatColor.YELLOW.toString(), null);
                        }
                      }
                    }.runTaskLater(this, 6000L);
                    new BukkitRunnable()
                    {
                      public void run()
                      {
                        Respawn.neutral.remove(target.getName());
                        if ((!Respawn.chaotic.contains(target.getName())) &&
                          (!Respawn.neutral.contains(target.getName())) && (target.isOnline()))
                        {
                            target.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                            target.sendMessage("§7While lawful, you will not lose any equipped armor on death.");
                            target.sendMessage("§7Any players who kill you while you're lawfully aligned will");
                            target.sendMessage("§7become chaotic.");
                            target.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                          NametagAPI.updateNametagHard(target.getName(),
                            null, null);
                        }
                      }
                    }.runTaskLater(this, 8000L);
              }
          }
      }
      if ((cmd.getName().equalsIgnoreCase("subitems") && sender instanceof Player) && 
      (p.hasPermission("ps.subitems"))) {
    	  Player player = (Player) sender;
    	  Player pinv = Bukkit.getServer().getPlayer(args[0]);
    	  int length = args.length;
    	  
    	  if (length == 1){
    		  boolean playerFound = false;
    		  for (Player playerBank : Bukkit.getServer().getOnlinePlayers()) {
    			  if(playerBank.getName().equalsIgnoreCase(args[0])) {
    		            ItemStack orb = new ItemStack(Material.MAGMA_CREAM, 20);
    		            ItemMeta orbmeta = orb.getItemMeta();
    		            orbmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
    		              "Orb of Alteration");
    		            orbmeta.setLore(Arrays.asList(new String[] {ChatColor.GRAY + 
    		              "Randomizes stats of selected equipment." }));
    		            orb.setItemMeta(orbmeta);
    		            pinv.getInventory().addItem(new ItemStack(orb));
    		            ItemStack scroll = new ItemStack(Material.EMPTY_MAP, 15);
    		            ItemMeta scrollmeta = scroll.getItemMeta();
    		              scrollmeta.setDisplayName(ChatColor.WHITE + "" +
    		                ChatColor.BOLD + "Scroll:" + ChatColor.YELLOW + 
    		                " Enchant Gold Armor");
    		            scrollmeta.setLore(
    		              Arrays.asList(new String[] {
    		              ChatColor.RED + "+5% HP", 
    		              ChatColor.RED + "+5% HP REGEN", 
    		              ChatColor.GRAY + "   - OR -", 
    		              ChatColor.RED + "+5% VIT", 
    		              ChatColor.GRAY + "" + ChatColor.ITALIC + 
    		              "Armor will VANISH if enchant above +3 FAILS." }));
    		            scroll.setItemMeta(scrollmeta);
    		            pinv.getInventory().addItem(new ItemStack[] { scroll });
    		            ItemStack scroll1 = new ItemStack(Material.EMPTY_MAP, 15);
    		            ItemMeta scrollmeta1 = scroll1.getItemMeta();
    		              scrollmeta1.setDisplayName(ChatColor.WHITE + "" +
    		                ChatColor.BOLD + "Scroll:" + ChatColor.YELLOW + 
    		                " Enchant Gold Weapon");
    		            scrollmeta1.setLore(
    		              Arrays.asList(new String[] {
    		              ChatColor.RED + "+5% DMG", 
    		              ChatColor.GRAY + "" + ChatColor.ITALIC + 
    		              "Weapon will VANISH if enchant above +3 FAILS." }));
    		            scroll1.setItemMeta(scrollmeta1);
    		            pinv.getInventory().addItem(new ItemStack[] { scroll1 });
    		            econ.bankDeposit(args[0], 20000);
    			  }
    			  
    		  }
    	  }
    	  
    		  
    	  return true;
      }
      
      if (cmd.getName().equalsIgnoreCase("togglepvp")) {
        if (togglepvp.contains(p.getName()))
        {
          togglepvp.remove(p.getName());
          p.sendMessage(ChatColor.GREEN + "Outgoing PVP Damage - " + 
            ChatColor.BOLD.toString() + "ENABLED");
          p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 10.0F);
        }
        else
        {
          togglepvp.add(p.getName());
          p.sendMessage(ChatColor.RED + "Outgoing PVP Damage - " + 
            ChatColor.BOLD.toString() + "DISABLED");
          p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, -10.0F);
        }
      }
      if (cmd.getName().equalsIgnoreCase("sync"))
      {
        p.updateInventory();
        p.saveData();
        p.sendMessage(ChatColor.GREEN.toString() + "Synced player data!");
      }
      if (cmd.getName().equalsIgnoreCase("togglebankgems")) {
    	  if(p.hasPermission("red.togglegembank")) {
    		  if (togglebankgem.contains(p.getName()))
    		  {
    			  togglebankgem.remove(p.getName());
    			  p.sendMessage(ChatColor.RED + "GEMS NOW BEING PUT IN BANK - " + ChatColor.BOLD.toString() + "DISABLE");
    			  p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 10.0F);
    		  }
    		  else
    		  {
    			  togglebankgem.add(p.getName());
    			  p.sendMessage(ChatColor.GREEN + "GEMS NOW BEING PUT IN BANK - " + ChatColor.BOLD.toString() + "ENABLED");
    			  p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, -10.0F);
    		  }
    	  }
        }
      if ((cmd.getName().equalsIgnoreCase("lootbuff")) && 
    	        (p.hasPermission("item.lootbuff")))
    	      {
    	        if (args.length == 0)
    	        {
    	          ItemStack buff = new ItemStack(Material.DIAMOND);
    	          ItemMeta buffMeta = buff.getItemMeta();
    	          buffMeta.setDisplayName(ChatColor.GOLD + 
    	            "Global Loot Buff");
    	          buffMeta.setLore(
    	            Arrays.asList(new String[] {
    	            ChatColor.GRAY + 
    	            "§6Duration: §730 Minutes", 
    	            "§6Uses: §71", 
    	            "§7§oIncreases all loot drop chances for everyone", 
    	            "§7Permanent Untradeable" }));
    	          buff.setItemMeta(buffMeta);
    	          
    	          p.getInventory().addItem(new ItemStack[] { buff });
    	          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
    	          return true;
    	        }
    	        if ((args.length == 1) && 
    	          (p.getServer().getPlayer(args[0]) != null))
    	        {
    	          Player tp = p.getServer().getPlayer(args[0]);
    	          
    	          ItemStack buff = new ItemStack(Material.DIAMOND);
    	          ItemMeta buffMeta = buff.getItemMeta();
    	          buffMeta.setDisplayName(ChatColor.GOLD + 
    	            "Global Loot Buff");
    	          buffMeta.setLore(
    	            Arrays.asList(new String[] {
    	            ChatColor.GRAY + 
    	            "§6Duration: §730 Minutes", 
    	            "§6Uses: §71", 
    	            "§7§oIncreases all loot drop chances for everyone", 
    	            "§7§oby 20% across §7§o§nALL SHARDS.", 
    	            "§7Permanent Untradeable" }));
    	          buff.setItemMeta(buffMeta);
    	          
    	          tp.getInventory().addItem(new ItemStack[] { buff });
    	          tp.playSound(tp.getLocation(), Sound.LEVEL_UP, 
    	            1.0F, 1.0F);
    	        }
    	      }
      if ((cmd.getName().equalsIgnoreCase("banksee") && sender instanceof Player) && 
      (p.hasPermission("ps.banksee"))) {
    	  Player player = (Player) sender;
    	  Player pinv = Bukkit.getServer().getPlayer(args[0]);
    	  int length = args.length;
    	  
    	  if (length == 1){
    		  boolean playerFound = false;
    		  for (Player playerBank : Bukkit.getServer().getOnlinePlayers()) {
    			  if(playerBank.getName().equalsIgnoreCase(args[0])) {
    				  p.openInventory(pinv.getEnderChest());
    			  }
    		  }
    		  if (playerFound == false) {
    			  player.sendMessage(ChatColor.RED + args[0] + "'s bank was not found!");
    		  }
    	  } else player.sendMessage(ChatColor.RED + "Incorrect! " + ChatColor.GRAY + "Use: /banksee <player>");
    	  
    		  
    	  return true;
      }
      if (cmd.getName().equalsIgnoreCase("toggledebug")) {
        if (debug.contains(p.getName()))
        {
          debug.remove(p.getName());
          p.sendMessage(ChatColor.GREEN + "Debug Messages - " + 
            ChatColor.BOLD.toString() + "ENABLED");
          p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 10.0F);
        }
        else
        {
          debug.add(p.getName());
          p.sendMessage(ChatColor.RED + "Debug Messages - " + 
            ChatColor.BOLD.toString() + "DISABLED");
          p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, -10.0F);
        }
      }
      if (cmd.getName().equalsIgnoreCase("togglechaos")) {
        if (togglechaos.contains(p.getName()))
        {
          togglechaos.remove(p.getName());
          p.sendMessage(ChatColor.RED + "Anti-Chaotic - " + 
            ChatColor.BOLD.toString() + "DISABLED");
          p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, -10.0F);
        }
        else
        {
          togglechaos.add(p.getName());
          p.sendMessage(ChatColor.GREEN + "Anti-Chaotic - " + 
            ChatColor.BOLD.toString() + "ENABLED");
          p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 10.0F);
        }

      }
      if ((cmd.getName().equalsIgnoreCase("bank")) && 
        (p.hasPermission("ps.bank")) && 
        (!bank.contains(p.getName())))
      {
    	if(Respawn.chaotic.contains(pn)) {
    		p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You're chaotic therfor you may not open your bank!");
    	}
    	if(!Respawn.chaotic.contains(pn)) {
        bank.add(p.getName());
        p.sendMessage(ChatColor.RED + "Your bank will be " + 
          ChatColor.BOLD.toString() + "OPENED" + ChatColor.RED + 
          " shortly.");
        p.sendMessage(ChatColor.RED + "Bank opening in ... " + 
          ChatColor.BOLD.toString() + "5s");
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.bank.contains(p.getName())) {
              return;
            }
            p.sendMessage(ChatColor.RED + "Bank opening in ... " + 
              ChatColor.BOLD.toString() + "4s");
          }
        }.runTaskLater(this, 20L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.bank.contains(p.getName())) {
              return;
            }
            p.sendMessage(ChatColor.RED + "Bank opening in ... " + 
              ChatColor.BOLD.toString() + "3s");
          }
        }.runTaskLater(this, 40L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.bank.contains(p.getName())) {
              return;
            }
            p.sendMessage(ChatColor.RED + "Bank opening in ... " + 
              ChatColor.BOLD.toString() + "2s");
          }
        }.runTaskLater(this, 60L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.bank.contains(p.getName())) {
              return;
            }
            p.sendMessage(ChatColor.RED + "Bank opening in ... " + 
              ChatColor.BOLD.toString() + "1s");
          }
        }.runTaskLater(this, 80L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (Main.bank.contains(p.getName()))
            {
              Main.bank.remove(p.getName());
              p.openInventory(p.getEnderChest());
              p.playSound(p.getLocation(), Sound.CHEST_OPEN, 
                1.0F, 1.0F);
            }
          }
        }.runTaskLater(this, 100L);
      }
      if ((cmd.getName().equalsIgnoreCase("logout")) && 
        (!logout.contains(p.getName())))
      {
        logout.add(p.getName());
        p.sendMessage("§cYou will be §c§lLOGGED OUT §cof the game world shortly.");
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l9s");
          }
        }.runTaskLater(this, 20L);
      }
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l8s");
          }
        }.runTaskLater(this, 40L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l7s");
          }
        }.runTaskLater(this, 60L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l6s");
          }
        }.runTaskLater(this, 80L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l5s");
          }
        }.runTaskLater(this, 100L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l4s");
          }
        }.runTaskLater(this, 120L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l3s");
          }
        }.runTaskLater(this, 140L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l2s");
          }
        }.runTaskLater(this, 160L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              return;
            }
            p.sendMessage("§cLogging out in ... §c§l1s");
          }
        }.runTaskLater(this, 180L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (Main.logout.contains(p.getName()))
            {
              Main.logout.remove(p.getName());
              p.kickPlayer("§aYou have safely logged out.");
            }
          }
        }.runTaskLater(this, 200L);
      }
      if ((cmd.getName().equalsIgnoreCase("toggletrail")) && 
        (p.hasPermission("ps.toggletrail"))) {
        if (toggletrail.contains(p.getName()))
        {
          toggletrail.remove(p.getName());
          p.sendMessage(ChatColor.RED.toString() + "Particle Trail - " + 
            ChatColor.BOLD + "DISABLED");
        }
        else
        {
          toggletrail.add(p.getName());
          p.sendMessage(ChatColor.GREEN.toString() + "Particle Trail - " + 
            ChatColor.BOLD + "ENABLED");
        }
      }
      if (cmd.getName().equalsIgnoreCase("suicide"))
      {
        suicide.add(p.getName());
        p.sendMessage(ChatColor.RED.toString() + 
        
          ChatColor.BOLD + 
          "Warning: " + 
          ChatColor.GRAY + 
          "This command will KILL you, you will LOOSE every thing you are carrying. It you are sure, type '" + 
          ChatColor.GREEN.toString() + "Y" + ChatColor.GRAY + 
          "', if not, type '" + ChatColor.RED.toString() + "cancel'.");
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("roll")) {
        if ((args.length < 1) || (args.length > 1))
        {
          p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + 
            "Incorrect Syntax." + ChatColor.GRAY + 
            " /roll <1 - 10000>");
        }
        else if (args.length == 1)
        {
          int max = 0;
          try
          {
            max = Integer.parseInt(args[0]);
          }
          catch (NumberFormatException e)
          {
            p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + 
              "Non-Numeric Max Number. /roll <1 - 10000>");
            return true;
          }
          if ((max < 1) || (max > 10000))
          {
            p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + 
              "Incorrect Syntax." + ChatColor.GRAY + 
              " /roll <1 - 10000>");
          }
          else
          {
            Random random = new Random();
            int roll = random.nextInt(max + 1);
            Bukkit.broadcastMessage(ChatColor.GRAY + p.getName() + 
              " has rolled a " + ChatColor.GRAY + 
              ChatColor.BOLD + ChatColor.UNDERLINE + roll + 
              ChatColor.GRAY + " out of " + ChatColor.GRAY + 
              ChatColor.BOLD + ChatColor.UNDERLINE + max + 
              ".");
          }
        }
      }
    }
	return false;
  }
  @EventHandler(priority=EventPriority.LOWEST)
  public void onNoDamageToggle(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Player)))
    {
      Player p = (Player)e.getDamager();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if (togglepvp.contains(p.getName()))
      {
        e.setDamage(0.0D);
        e.setCancelled(true);
        p.sendMessage(ChatColor.RED.toString() + 
          "You " + 
          ChatColor.UNDERLINE + 
          "cannot" + 
          ChatColor.RED.toString() + 
          " deal damage to other players while you have /togglepvp on.");
      }
    }
  }
  
  public static int getHpgenFromLore(ItemStack item, String value)
  {
    int returnVal = 0;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if ((lore != null) && (((String)lore.get(2)).contains(value)))
      {
        String vals = ((String)lore.get(2)).split(": +")[1];
        vals = ChatColor.stripColor(vals);
        vals = vals.replace(" HP/s", "").trim().toString();
        returnVal = Integer.parseInt(vals.trim());
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  private boolean setupEconomy()
  {
    if (getServer().getPluginManager().getPlugin("Vault") == null) {
      return false;
    }
    RegisteredServiceProvider<Economy> rsp = getServer()
      .getServicesManager().getRegistration(Economy.class);
    if (rsp == null) {
      return false;
    }
    this.econ = ((Economy)rsp.getProvider());
    return this.econ != null;
  }
  
  public void barHealth(Player player)
  {
	Damageable dp = player;
    BarAPI.setMessage(player, "§d§lHP §d" + (int)dp.getHealth() + " §d§l/§d " + (int)dp.getMaxHealth());
    BarAPI.setHealth(player, (float) ((float)dp.getHealth() / dp.getMaxHealth() * 100.0D));
  }
  
  public String getNameHealth(double Health, double MaxHealth, String Name)
  {
    Name = Name.replaceAll("§0", "");
    Name = Name.replaceAll("§1", "");
    Name = Name.replaceAll("§2", "");
    Name = Name.replaceAll("§3", "");
    Name = Name.replaceAll("§4", "");
    Name = Name.replaceAll("§5", "");
    Name = Name.replaceAll("§6", "");
    Name = Name.replaceAll("§7", "");
    Name = Name.replaceAll("§8", "");
    Name = Name.replaceAll("§9", "");
    Name = Name.replaceAll("§a", "");
    Name = Name.replaceAll("§b", "");
    Name = Name.replaceAll("§c", "");
    Name = Name.replaceAll("§d", "");
    Name = Name.replaceAll("§e", "");
    Name = Name.replaceAll("§f", "");
    Name = Name.replaceAll("§l", "");
    Name = Name.replaceAll("§k", "");
    Name = Name.replaceAll("§o", "");
    Name = Name.replaceAll("§m", "");
    Name = Name.replaceAll("§n", "");
    double percent = Health / MaxHealth;
    double length = Name.length();
    double scolor = length * percent;
    int color = (int)Math.ceil(scolor);
    String n = Name;
    if (color < length / 3.0D)
    {
      String g = n.substring(color);
      String h = n.substring(0, color);
      n = "§c" + h + "§7" + g;
    }
    else if (color < length / 1.5D)
    {
      String g = n.substring(color);
      String h = n.substring(0, color);
      n = "§e" + h + "§7" + g;
    }
    else
    {
      String g = n.substring(color);
      String h = n.substring(0, color);
      n = "§a" + h + "§7" + g;
    }
    return n;
  }
  
  public void onEnable()
  {
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Listeners(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Mining(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Mobs(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Mobdrops(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Debug(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Antibuild(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new NPC(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Respawn(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Untradeable(this), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Speedfish(this), this);
    Bukkit.getServer().getPluginManager()
    .registerEvents(new Orbs3(), this);
    Bukkit.getServer().getPluginManager()
    .registerEvents(new Orbs2(), this);
    Bukkit.getServer().getPluginManager()
      .registerEvents(new Orbs(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Enchants(), this);
    Bukkit.getServer().getPluginManager()
    .registerEvents(new HPBAR(), this);
    Bukkit.getServer().getPluginManager()
    .registerEvents(new Hearthstones(), this);
    Bukkit.getPluginManager().registerEvents(new Utils(), this);
  //  Bukkit.getPluginManager().registerEvents(new PSEnchants(), this);
    getCommand("sc").setExecutor(new CommandSC());
    getCommand("sayall").setExecutor(new CommandSayall());
    if (!setupEconomy())
    {
      log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", new Object[] { getDescription().getName() }));
      getServer().getPluginManager().disablePlugin(this);
      return;
    }
    setupPermissions();
    setupChat();
    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
      public void run()
      {
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player p = arrayOfPlayer[i];
          
          Main.this.barHealth(p);
          if (p.getExp() < 1.0F) {
            p.setExp((float)(p.getExp() + 0.02D));
          }
          if (p.getLevel() + 2 > 100) {
            p.setLevel(100);
          } else {
            p.setLevel(p.getLevel() + 2);
          }
        }
      }
    }, 1L, 1L);
    
    
    Bukkit.getServer().getScheduler()
      .scheduleSyncRepeatingTask(this, new Runnable()
      {
        public void run()
        {
          Player[] arrayOfPlayer;
          int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
          for (int i = 0; i < j; i++)
          {
            Player p = arrayOfPlayer[i];
            if ((!Main.tagged.contains(p.getName())) && 
              (!p.isDead()))
            {
              PlayerInventory i1 = p.getInventory();
              double amt = 5.0D;
              if ((i1.getHelmet() != null) && 
                (i1.getHelmet().getItemMeta().hasLore()))
              {
                double added = Main.getHpgenFromLore(
                  i1.getHelmet(), "HP REGEN");
                amt += added;
              }
              if ((i1.getChestplate() != null) && 
                (i1.getChestplate().getItemMeta().hasLore()))
              {
                double added = Main.getHpgenFromLore(
                  i1.getChestplate(), "HP REGEN");
                amt += added;
              }
              if ((i1.getLeggings() != null) && 
                (i1.getLeggings().getItemMeta().hasLore()))
              {
                double added = Main.getHpgenFromLore(
                  i1.getLeggings(), "HP REGEN");
                amt += added;
              }
              if ((i1.getBoots() != null) && 
                (i1.getBoots().getItemMeta().hasLore()))
              {
                double added = Main.getHpgenFromLore(
                  i1.getBoots(), "HP REGEN");
                amt += added;
              }
              Damageable dp = p;
              if (dp.getHealth() + amt > dp.getMaxHealth()) {
                p.setHealth(dp.getMaxHealth());
              } else {
                p.setHealth(dp.getHealth() + amt);
              }
            }
          }
        }
      }, 1L, 20L);
  }
  @EventHandler(priority=EventPriority.HIGH)
  public void onMount(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (p.getItemInHand().getItemMeta().getDisplayName().contains("Old Horse Mount"))
    {
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
                (p.getItemInHand() != null) && 
                (p.getItemInHand().getType() == Material.SADDLE) && 
                (!p.isInsideVehicle()) && 
                (!mount.contains(p.getName()) && (!MSF.contains(p.getName()))))
      {
          mount.add(p.getName());
          p.sendMessage("§f§lSUMMONING " + 
            p.getInventory().getItemInHand().getItemMeta()
            .getDisplayName() + "§f ... 5§f§ls");
          ParticleEffect.SPELL.display(p.getLocation(), 0.25F, 0.2F, 
            0.25F, 0.05F, 50);
          new BukkitRunnable()
          {
            public void run()
            {
              if (!Main.mount.contains(p.getName()) && (!MSF.contains(p.getName()))) {
                return;
              }
              p.sendMessage("§f§lSUMMONING §f... §f4§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 
                0.25F, 0.5F, 0.25F, 0.05F, 50);
            }
          }.runTaskLater(this, 20L);
          new BukkitRunnable()
          {
            public void run()
            {
              if (!Main.mount.contains(p.getName()) && (!MSF.contains(p.getName()))) {
                return;
              }
              p.sendMessage("§f§lSUMMONING §f... §f3§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 
                0.25F, 0.5F, 0.25F, 0.05F, 50);
            }
          }.runTaskLater(this, 40L);
          new BukkitRunnable()
          {
            public void run()
            {
              if (!Main.mount.contains(p.getName())&& (!MSF.contains(p.getName()))) {
                return;
              }
              p.sendMessage("§f§lSUMMONING §f... §f2§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 
                0.25F, 0.5F, 0.25F, 0.05F, 50);
            }
          }.runTaskLater(this, 60L);
          new BukkitRunnable()
          {
            public void run()
            {
              if (!Main.mount.contains(p.getName())&& (!MSF.contains(p.getName()))) {
                return;
              }
              p.sendMessage("§f§lSUMMONING §f... §f1§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 
                0.25F, 0.5F, 0.25F, 0.05F, 50);
            }
          }.runTaskLater(this, 80L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (Main.mount.contains(p.getName()))
            {
              Main.mount.remove(p.getName());
              if (!p.isInsideVehicle())
              {
                Horse h = (Horse)p.getWorld().spawnEntity(
                  p.getLocation(), EntityType.HORSE);
                h.setTamed(true);
                h.setColor(Horse.Color.BROWN);
                h.setMaxHealth(20.0D);
                h.setHealth(20.0D);
                h.setJumpStrength(1.01D);
                h.addPotionEffect(new PotionEffect(
                  PotionEffectType.SPEED, Integer.MAX_VALUE, 
                  0));
                h.getInventory().setSaddle(
                  new ItemStack(Material.SADDLE));
                h.setPassenger(p);
            }
            }
          }
        }.runTaskLater(this, 100L);
      }
    }
    else if (p.getItemInHand().getItemMeta().getDisplayName().contains("Traveler's"))
    {
      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
        (p.getItemInHand() != null) && 
        (p.getItemInHand().getType() == Material.SADDLE) && 
        (!p.isInsideVehicle()) && 
        (!mount.contains(p.getName()) && (!MSF.contains(p.getName()))))
      {
        mount.add(p.getName());
        mount.add(p.getName());
        p.sendMessage("§f§lSUMMONING " + 
                p.getInventory().getItemInHand().getItemMeta()
                .getDisplayName() + "§f ... 5§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 0.25F, 0.2F, 
                0.25F, 0.05F, 50);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName()) && (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f4§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 20L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName()) && (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f3§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 40L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName())&& (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f2§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 60L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName())&& (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f1§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 80L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (Main.mount.contains(p.getName()))
            {
              Main.mount.remove(p.getName());
              if (!p.isInsideVehicle())
              {
                Horse h = (Horse)p.getWorld().spawnEntity(
                  p.getLocation(), EntityType.HORSE);
                ItemStack iron = new ItemStack(
                  Material.IRON_BARDING);
                h.setTamed(true);
                h.setColor(Horse.Color.BROWN);
                h.setMaxHealth(20.0D);
                h.setHealth(20.0D);
                h.setJumpStrength(1.00D);
                h.addPotionEffect(new PotionEffect(
                  PotionEffectType.SPEED, Integer.MAX_VALUE, 
                  0));
                h.getInventory().setSaddle(
                  new ItemStack(Material.SADDLE));
                h.getInventory().setArmor(iron);
                h.setPassenger(p);
              }
          }
          }
        }.runTaskLater(this, 100L);
      }
    }
    else if (p.getItemInHand().getItemMeta().getDisplayName().contains("Knight's Horse Mount"))
    {
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
                (p.getItemInHand() != null) && 
                (p.getItemInHand().getType() == Material.SADDLE) && 
                (!p.isInsideVehicle()) && 
                (!mount.contains(p.getName()) && (!MSF.contains(p.getName()))))
      {
        mount.add(p.getName());
        mount.add(p.getName());
        p.sendMessage("§f§lSUMMONING " + 
                p.getInventory().getItemInHand().getItemMeta()
                .getDisplayName() + "§f ... 5§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 0.25F, 0.2F, 
                0.25F, 0.05F, 50);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName()) && (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f4§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 20L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName()) && (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f3§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 40L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName())&& (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f2§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 60L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName())&& (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f1§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 80L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (Main.mount.contains(p.getName()))
            {
              Main.mount.remove(p.getName());
              if (!p.isInsideVehicle())
              {
                Horse h = (Horse)p.getWorld().spawnEntity(
                  p.getLocation(), EntityType.HORSE);
                ItemStack diamond = new ItemStack(
                  Material.DIAMOND_BARDING);
                h.setTamed(true);
                h.setColor(Horse.Color.BROWN);
                h.setMaxHealth(20.0D);
                h.setHealth(20.0D);
                h.setJumpStrength(1.015D);
                h.addPotionEffect(new PotionEffect(
                  PotionEffectType.SPEED, Integer.MAX_VALUE, 
                  1));
                h.getInventory().setSaddle(
                  new ItemStack(Material.SADDLE));
                h.getInventory().setArmor(diamond);
                h.setPassenger(p);
              }
            }
          }
        }.runTaskLater(this, 100L);
      }
    }
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
            (p.getItemInHand() != null) && 
            (p.getItemInHand().getType() == Material.SADDLE) && 
            (!p.isInsideVehicle()) && 
            (!mount.contains(p.getName()) && (!MSF.contains(p.getName()))))
    {
        mount.add(p.getName());
        p.sendMessage("§f§lSUMMONING " + 
                p.getInventory().getItemInHand().getItemMeta()
                .getDisplayName() + "§f ... 5§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 0.25F, 0.2F, 
                0.25F, 0.05F, 50);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName()) && (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f4§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 20L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName()) && (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f3§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 40L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName())&& (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f2§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 60L);
              new BukkitRunnable()
              {
                public void run()
                {
                  if (!Main.mount.contains(p.getName())&& (!MSF.contains(p.getName()))) {
                    return;
                  }
                  p.sendMessage("§f§lSUMMONING §f... §f1§f§ls");
                  ParticleEffect.SPELL.display(p.getLocation(), 
                    0.25F, 0.5F, 0.25F, 0.05F, 50);
                }
              }.runTaskLater(this, 80L);
      new BukkitRunnable()
      {
        public void run()
        {
          if (Main.mount.contains(p.getName()))
          {
            Main.mount.remove(p.getName());
            if (!p.isInsideVehicle())
            {
              Horse h = (Horse)p.getWorld().spawnEntity(
                p.getLocation(), EntityType.HORSE);
              ItemStack gold = new ItemStack(
                Material.GOLD_BARDING);
              h.setTamed(true);
              h.setColor(Horse.Color.BROWN);
              h.setMaxHealth(20.0D);
              h.setHealth(20.0D);
              h.addPotionEffect(new PotionEffect(
                PotionEffectType.SPEED, Integer.MAX_VALUE, 
                2));
              h.setJumpStrength(1.025D);
              h.getInventory().setSaddle(
                new ItemStack(Material.SADDLE));
              h.getInventory().setArmor(gold);
              h.setPassenger(p);
            	}
            }
        }
      }.runTaskLater(this, 100L);
    }
  }
  @EventHandler(priority=EventPriority.LOWEST)
  public void onNoDamageToggleChaos(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Player)))
    {
      Player p = (Player)e.getDamager();
      Player pp = (Player)e.getEntity();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((togglechaos.contains(p.getName())) && 
        (!Respawn.neutral.contains(pp.getName())) && 
        (!Respawn.chaotic.contains(pp.getName())))
      {
        e.setDamage(0.0D);
        e.setCancelled(true);
        p.sendMessage(ChatColor.RED + "You " + ChatColor.UNDERLINE + 
          "cannot" + ChatColor.RED + 
          " attack the lawful player (" + ChatColor.GREEN + pp.getName() + ChatColor.RED + 
          ") with /togglechaos enabled.");
      }
    }
  }
  @EventHandler(priority=EventPriority.HIGH)
  public void oncooldown(PlayerInteractEvent e) {
  final Player pe = e.getPlayer();
  Location spawn = new Location(pe.getWorld(), 603, 35, -281);
  Location avalon = new Location(pe.getWorld(), 637, 96, 261);
  Location tripoli = new Location(pe.getWorld(), 811, 9, -85);
  Location cave = new Location(pe.getWorld(), 508, 5, 45);
  {
	 final Player p = e.getPlayer();
    if (p.getItemInHand().getItemMeta().getDisplayName().contains("Hearthstone: Spawn"))
    	
    {
	      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
			        (p.getItemInHand() != null) && 
			        (p.getItemInHand().getType() == Material.FIREBALL) && 
			        (!p.isInsideVehicle()) && 
			        (!Hearthstones.cooldown.contains(p.getName()) && (!Hearthstones.cool.contains(p.getName()))))
      {
    	  Hearthstones.cooldown.add(p.getName());
          p.sendMessage("§f§lTELEPORTING " + 
            p.getInventory().getItemInHand().getItemMeta()
            .getDisplayName() + "§f ... 5§f§ls");
          ParticleEffect.SPELL.display(p.getLocation(), 0.25F, 0.2F, 
            0.25F, 0.05F, 50);
          new BukkitRunnable()
          {
            public void run()
            {
              if (!Hearthstones.cooldown.contains(p.getName())) {
                return;
              }
              p.sendMessage("§f§lTELEPORTING §f... §f4§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 
                0.25F, 0.5F, 0.25F, 0.05F, 50);
            }
          }.runTaskLater(this, 20L);
          new BukkitRunnable()
          {
            public void run()
            {
              if (!Hearthstones.cooldown.contains(p.getName())) {
                return;
              }
              p.sendMessage("§f§lTELEPORTING §f... §f3§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 
                0.25F, 0.5F, 0.25F, 0.05F, 50);
            }
          }.runTaskLater(this, 40L);
          new BukkitRunnable()
          {
            public void run()
            {
              if (!Hearthstones.cooldown.contains(p.getName())) {
                return;
              }
              p.sendMessage("§f§lTELEPORTING §f... §f2§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 
                0.25F, 0.5F, 0.25F, 0.05F, 50);
            }
          }.runTaskLater(this, 60L);
          new BukkitRunnable()
          {
            public void run()
            {
              if (!Hearthstones.cooldown.contains(p.getName())) {
                return;
              }
              p.sendMessage("§f§lTELEPORTING §f... §f1§f§ls");
              ParticleEffect.SPELL.display(p.getLocation(), 
                0.25F, 0.5F, 0.25F, 0.05F, 50);
              Hearthstones.cooldown.remove(p.getName());
            }
          }.runTaskLater(this, 80L);
        new BukkitRunnable()
        {
          public void run()
          {
        	  if(!Hearthstones.cool.contains(p.getName())) {
            	  p.teleport(spawn);
        	  }
            }
        }.runTaskLater(this, 100L);
      }
    }
    else if (p.getItemInHand().getItemMeta().getDisplayName().contains("Hearthstone: Avalon"))
    {
	      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
			        (p.getItemInHand() != null) && 
			        (p.getItemInHand().getType() == Material.FIREBALL) && 
			        (!p.isInsideVehicle()) && 
			        (!Hearthstones.cooldown.contains(p.getName()) && (!Hearthstones.cool.contains(p.getName()))))
      {
	    Hearthstones.cooldown.add(p.getName());
        Hearthstones.cooldown.add(p.getName());
        p.sendMessage("§f§lTELEPORTING " + 
          p.getInventory().getItemInHand().getItemMeta()
          .getDisplayName() + "§f ... 5§f§ls");
        ParticleEffect.SPELL.display(p.getLocation(), 0.25F, 0.2F, 
          0.25F, 0.05F, 50);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Hearthstones.cooldown.contains(p.getName())) {
              return;
            }
            p.sendMessage("§f§lTELEPORTING §f... §f4§f§ls");
            ParticleEffect.SPELL.display(p.getLocation(), 
              0.25F, 0.5F, 0.25F, 0.05F, 50);
          }
        }.runTaskLater(this, 20L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Hearthstones.cooldown.contains(p.getName())) {
              return;
            }
            p.sendMessage("§f§lTELEPORTING §f... §f3§f§ls");
            ParticleEffect.SPELL.display(p.getLocation(), 
              0.25F, 0.5F, 0.25F, 0.05F, 50);
          }
        }.runTaskLater(this, 40L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Hearthstones.cooldown.contains(p.getName())) {
              return;
            }
            p.sendMessage("§f§lTELEPORTING §f... §f2§f§ls");
            ParticleEffect.SPELL.display(p.getLocation(), 
              0.25F, 0.5F, 0.25F, 0.05F, 50);
          }
        }.runTaskLater(this, 60L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Hearthstones.cooldown.contains(p.getName())) {
              return;
            }
            p.sendMessage("§f§lTELEPORTING §f... §f1§f§ls");
            ParticleEffect.SPELL.display(p.getLocation(), 
              0.25F, 0.5F, 0.25F, 0.05F, 50);
            Hearthstones.cooldown.remove(p.getName());
          }
        }.runTaskLater(this, 80L);
        new BukkitRunnable()
        {
          public void run()
          {
        	  if(!Hearthstones.cool.contains(p.getName())) {
            	  p.teleport(avalon);
        	  }
          }
          
          }.runTaskLater(this, 100L);
        }
      }
    else if (p.getItemInHand().getItemMeta().getDisplayName().contains("Hearthstone: Tripoli"))
    {
	      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
			        (p.getItemInHand() != null) && 
			        (p.getItemInHand().getType() == Material.FIREBALL) && 
			        (!p.isInsideVehicle()) && 
			        (!Hearthstones.cooldown.contains(p.getName()) && (!Hearthstones.cool.contains(p.getName()))))
      {
    	  Hearthstones.cooldown.add(p.getName());
        Hearthstones.cooldown.add(p.getName());
        p.sendMessage("§f§lTELEPORTING " + 
          p.getInventory().getItemInHand().getItemMeta()
          .getDisplayName() + "§f ... 5§f§ls");
        ParticleEffect.SPELL.display(p.getLocation(), 0.25F, 0.2F, 
          0.25F, 0.05F, 50);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Hearthstones.cooldown.contains(p.getName())) {
              return;
            }
            p.sendMessage("§f§lTELEPORTING §f... §f4§f§ls");
            ParticleEffect.SPELL.display(p.getLocation(), 
              0.25F, 0.5F, 0.25F, 0.05F, 50);
          }
        }.runTaskLater(this, 20L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Hearthstones.cooldown.contains(p.getName())) {
              return;
            }
            p.sendMessage("§f§lTELEPORTING §f... §f3§f§ls");
            ParticleEffect.SPELL.display(p.getLocation(), 
              0.25F, 0.5F, 0.25F, 0.05F, 50);
          }
        }.runTaskLater(this, 40L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Hearthstones.cooldown.contains(p.getName())) {
              return;
            }
            p.sendMessage("§f§lTELEPORTING §f... §f2§f§ls");
            ParticleEffect.SPELL.display(p.getLocation(), 
              0.25F, 0.5F, 0.25F, 0.05F, 50);
          }
        }.runTaskLater(this, 60L);
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Hearthstones.cooldown.contains(p.getName())) {
              return;
            }
            p.sendMessage("§f§lTELEPORTING §f... §f1§f§ls");
            ParticleEffect.SPELL.display(p.getLocation(), 
              0.25F, 0.5F, 0.25F, 0.05F, 50);
            	Hearthstones.cooldown.remove(p.getName());
             
          }
        }.runTaskLater(this, 80L);
        new BukkitRunnable()
        {
          public void run()
          {
        	  if(!Hearthstones.cool.contains(p.getName())) {
            	  p.teleport(tripoli);
        	  }
          }
        
        }.runTaskLater(this, 100L);
      }
    }
    else if (p.getItemInHand().getItemMeta().getDisplayName().contains("Hearthstone: Cave"))
    {
	      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
			        (p.getItemInHand() != null) && 
			        (p.getItemInHand().getType() == Material.FIREBALL) && 
			        (!p.isInsideVehicle()) && 
			        (!Hearthstones.cooldown.contains(p.getName()) && (!Hearthstones.cool.contains(p.getName()))))
	      {
	    	  Hearthstones.cooldown.add(p.getName());
	        Hearthstones.cooldown.add(p.getName());
	        p.sendMessage("§f§lTELEPORTING " + 
	          p.getInventory().getItemInHand().getItemMeta()
	          .getDisplayName() + "§f ... 5§f§ls");
	        ParticleEffect.SPELL.display(p.getLocation(), 0.25F, 0.2F, 
	          0.25F, 0.05F, 50);
	        new BukkitRunnable()
	        {
	          public void run()
	          {
	            if (!Hearthstones.cooldown.contains(p.getName())) {
	              return;
	            }
	            p.sendMessage("§f§lTELEPORTING §f... §f4§f§ls");
	            ParticleEffect.SPELL.display(p.getLocation(), 
	              0.25F, 0.5F, 0.25F, 0.05F, 50);
	          }
	        }.runTaskLater(this, 20L);
	        new BukkitRunnable()
	        {
	          public void run()
	          {
	            if (!Hearthstones.cooldown.contains(p.getName())) {
	              return;
	            }
	            p.sendMessage("§f§lTELEPORTING §f... §f3§f§ls");
	            ParticleEffect.SPELL.display(p.getLocation(), 
	              0.25F, 0.5F, 0.25F, 0.05F, 50);
	          }
	        }.runTaskLater(this, 40L);
	        new BukkitRunnable()
	        {
	          public void run()
	          {
	            if (!Hearthstones.cooldown.contains(p.getName())) {
	              return;
	            }
	            p.sendMessage("§f§lTELEPORTING §f... §f2§f§ls");
	            ParticleEffect.SPELL.display(p.getLocation(), 
	              0.25F, 0.5F, 0.25F, 0.05F, 50);
	          }
	        }.runTaskLater(this, 60L);
	        new BukkitRunnable()
	        {
	          public void run()
	          {
	            if (!Hearthstones.cooldown.contains(p.getName())) {
	              return;
	            }
	            p.sendMessage("§f§lTELEPORTING §f... §f1§f§ls");
	            ParticleEffect.SPELL.display(p.getLocation(), 
	              0.25F, 0.5F, 0.25F, 0.05F, 50);
	            Hearthstones.cooldown.remove(p.getName());
	          }
	        }.runTaskLater(this, 80L);
	        new BukkitRunnable()
	        {
	          public void run()
	          {
	        	  if(!Hearthstones.cool.contains(p.getName())) {
	            	  p.teleport(cave);
	            }
	          }
	        }.runTaskLater(this, 100L);
	      }
	      }
    }
    }
  @EventHandler
  public void onMountDamager(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      Player p1 = (Player)e.getDamager();
      if (Hearthstones.cooldown.contains(p1.getName()))
      {
        Hearthstones.cooldown.remove(p1.getName());
        Hearthstones.cool.add(p1.getName());
        p1.sendMessage("§cTELEPORTING - §c§lCANCELLED");
        p1.sendMessage(ChatColor.GRAY + "Teleporting Failed - You must now wait a 1 minute timer before teleporting again.");
        new BukkitRunnable()
	        {
	          public void run()
	          {
	        	  Hearthstones.cool.remove(p1.getName());
	        	  p1.sendMessage(ChatColor.GRAY + "You may now teleport again!");
	          }
	        }.runTaskLater(this, 600L);
      }
    }
  }
  @EventHandler
  public void onMountDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p1 = (Player)e.getEntity();
      if (Hearthstones.cooldown.contains(p1.getName()))
      {
        Hearthstones.cooldown.remove(p1.getName());
        Hearthstones.cool.add(p1.getName());
        p1.sendMessage("§cTELEPORTING - §c§lCANCELLED");
        p1.sendMessage(ChatColor.GRAY + "Teleporting Failed - You must now wait a 1 minute timer before teleporting again.");
        new BukkitRunnable()
	        {
	          public void run()
	          {
	        	  Hearthstones.cool.remove(p1.getName());
	        	  p1.sendMessage(ChatColor.GRAY + "You may now teleport again!");
	          }
	        }.runTaskLater(this, 600L);
      }
    }
  }
  @EventHandler
  public void onMountMove(PlayerMoveEvent e) {
    Player p1 = e.getPlayer();
    int fromX = (int)e.getFrom().getX();
    int fromY = (int)e.getFrom().getY();
    int fromZ = (int)e.getFrom().getZ();
    int toX = (int)e.getTo().getX();
    int toY = (int)e.getTo().getY();
    int toZ = (int)e.getTo().getZ();
    if (((fromX != toX) || (fromZ != toZ) || (fromY != toY)) && 
      (Hearthstones.cooldown.contains(p1.getName())))
    {
      Hearthstones.cooldown.remove(p1.getName());
      Hearthstones.cool.add(p1.getName());
      p1.sendMessage("§cTELEPORTING - §c§lCANCELLED");
      p1.sendMessage(ChatColor.GRAY + "Teleporting Failed - You must now wait a 1 minute timer before teleporting again.");
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	          public void run()
	          {
	        	  Hearthstones.cool.remove(p1.getName());
	        	  p1.sendMessage(ChatColor.GRAY + "You may now teleport again!");
	          }
	        }, 600L);
    }
  }
  @EventHandler
  public void onMounMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    int fromX = (int)e.getFrom().getX();
    int fromY = (int)e.getFrom().getY();
    int fromZ = (int)e.getFrom().getZ();
    int toX = (int)e.getTo().getX();
    int toY = (int)e.getTo().getY();
    int toZ = (int)e.getTo().getZ();
    if (((fromX != toX) || (fromZ != toZ) || (fromY != toY)) && 
      (Main.mount.contains(p.getName())))
    {
      Main.mount.remove(p.getName());
      p.sendMessage("§cMount Summon - §c§lCANCELLED");
      MSF.add(p.getName());
  	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					@Override
					public void run() {
						MSF.remove(p.getName());
						
					}
          		
          	}, 25);
    }
  }
  @EventHandler
  public void onGEMBANKPICKUP(PlayerPickupItemEvent e)
  {
    Player p = e.getPlayer();
    int amount = e.getItem().getItemStack().getAmount();
    if(Main.togglebankgem.contains(p.getName())) {
{
        if (e.getItem().getItemStack().getType() == Material.EMERALD) {
                	e.setCancelled(true);
                    	p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "+" + amount + " Gems added to your bank account");
                    	econ.depositPlayer(p.getName(), amount);
                    	e.getItem().remove();    
                    	p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
                    	e.setCancelled(true);
                    	cooldown.add(p.getName());
        }
    	}
    }
  }

  private boolean setupChat()
  {
    RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
    chat = (Chat)rsp.getProvider();
    return chat != null;
  }
  
  private boolean setupPermissions()
  {
    RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
    perms = (Permission)rsp.getProvider();
    return perms != null;
  }
}