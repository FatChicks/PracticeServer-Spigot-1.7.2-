package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Hearthstones implements Listener {
	public static Main plugin;
	public static List<String> cooldown = new ArrayList<String>(); 
	public static List<String> AvalonHearth = new ArrayList<String>(); 
	public static List<String> SpawnHearth = new ArrayList<String>(); 
	public static List<String> TripoliHearth = new ArrayList<String>(); 
	public static List<String> CaveHearth = new ArrayList<String>(); 
	public static List<String> cool = new ArrayList<String>(); 
	public static List<String> cool2 = new ArrayList<String>(); 

	
	// Coded by Redgodzilla - I'm a fat twat
	@EventHandler
	public void onRightClCool(PlayerInteractEvent e) {
		if(e.getPlayer().getItemInHand().equals(Material.FIREBALL)) {
			e.setCancelled(true);
		}
		
	}
	@EventHandler
	public void onRightClickCool(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(Hearthstones.cool.contains(p.getName())) {
			if(p.getItemInHand().getType() == Material.FIREBALL){
			p.sendMessage(ChatColor.RED + "You're on a 1 minute cooldown, please wait this time to teleport again.");
			}
		}
	}
	@EventHandler
	public void onJoinFirst(PlayerJoinEvent e) {
		if(!e.getPlayer().hasPlayedBefore()) {
            ItemStack Hearth = new ItemStack(Material.FIREBALL);
            ItemMeta Hearthmeta = Hearth.getItemMeta();
            Hearthmeta.setDisplayName(ChatColor.GREEN +
              "Hearthstone: Spawn");
            Hearthmeta.setLore(Arrays.asList(new String[] {
              ChatColor.RED + "Location: Dead Peaks Bank",
              ChatColor.GRAY + ChatColor.ITALIC.toString() +
              "Teleports to the location above",
              ChatColor.GRAY + "Permanent Untradeable" }));
            Hearth.setItemMeta(Hearthmeta);
            e.getPlayer().getInventory().addItem(new ItemStack[] { Hearth });
			
		}
	}
  
  
	@EventHandler
	public void onRespawnHearth(PlayerRespawnEvent e) {
		String pn = e.getPlayer().getName();
		Player p = e.getPlayer();
		if(SpawnHearth.contains(pn)) {
            ItemStack Hearth = new ItemStack(Material.FIREBALL);
            ItemMeta Hearthmeta = Hearth.getItemMeta();
            Hearthmeta.setDisplayName(ChatColor.GREEN +
              "Hearthstone: Spawn");
            Hearthmeta.setLore(Arrays.asList(new String[] {
              ChatColor.RED + "Location: Dead Peaks Bank",
              ChatColor.GRAY + ChatColor.ITALIC.toString() +
              "Teleports to the location above",
              ChatColor.GRAY + "Permanent Untradeable" }));
            Hearth.setItemMeta(Hearthmeta);
            p.getInventory().addItem(new ItemStack[] { Hearth });
		}else if(AvalonHearth.contains(pn)) {
            ItemStack Hearth2 = new ItemStack(Material.FIREBALL);
            ItemMeta Hearthmeta2 = Hearth2.getItemMeta();
            Hearthmeta2.setDisplayName(ChatColor.GREEN +
		              "Hearthstone: Avalon");
		            Hearthmeta2.setLore(Arrays.asList(new String[] {
		              ChatColor.RED + "Location: Avalon Bank",
		              ChatColor.GRAY + ChatColor.ITALIC.toString() +
		              "Teleports to the location above",
		              ChatColor.GRAY + "Permanent Untradeable" }));
		            Hearth2.setItemMeta(Hearthmeta2);
		            p.getInventory().addItem(new ItemStack[] { Hearth2 });
		}else if(TripoliHearth.contains(pn)) {
            ItemStack Hearth3 = new ItemStack(
		              Material.FIREBALL);
		            ItemMeta Hearthmeta3 = Hearth3.getItemMeta();
		            Hearthmeta3.setDisplayName(ChatColor.GREEN +
				              "Hearthstone: Tripoli");
				            Hearthmeta3.setLore(Arrays.asList(new String[] {
				              ChatColor.RED + "Location: Tripoli Bank",
				              ChatColor.GRAY + ChatColor.ITALIC.toString() +
				              "Teleports to the location above",
				              ChatColor.GRAY + "Permanent Untradeable" }));
		            Hearth3.setItemMeta(Hearthmeta3);
		            p.getInventory().addItem(new ItemStack[] { Hearth3 });
		}else if(CaveHearth.contains(pn)) {
	          ItemStack Hearth4 = new ItemStack(Material.FIREBALL);
	          ItemMeta Hearthmeta4 = Hearth4.getItemMeta();
	            Hearthmeta4.setDisplayName(ChatColor.GREEN +
			              "Hearthstone: Cave");
			            Hearthmeta4.setLore(Arrays.asList(new String[] {
			              ChatColor.RED + "Location: Cave Bank",
			              ChatColor.GRAY + ChatColor.ITALIC.toString() +
			              "Teleports to the location above",
			              ChatColor.GRAY + "Permanent Untradeable" }));
	          Hearth4.setItemMeta(Hearthmeta4);
	          p.getInventory().addItem(new ItemStack[] { Hearth4 });
			
		}
	}
	@EventHandler 
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		 Inventory i = p.getInventory();
		 for(ItemStack inven : i.getContents()) {
		 if (inven.getType().equals(Material.FIREBALL) && inven.hasItemMeta() && inven.getItemMeta().getDisplayName().contains("Hearthstone: Spawn"))  {
			 SpawnHearth.add(p.getName());
		 }else if(inven.getItemMeta().getLore().contains("Location: Avalon Bank")) {
			 AvalonHearth.add(p.getName());
		 }else if(inven.getItemMeta().getLore().contains("Location: Cave Bank")) {
			 CaveHearth.add(p.getName());
		 }else if(inven.getItemMeta().getLore().contains("Location: Tripoli Bank")) {
			 TripoliHearth.add(p.getName());
			 
			 
			 
		 }
			
		}
		
	}
		
    @EventHandler
    public void onHorse(PlayerInteractEntityEvent e)
    {
      if ((e.getRightClicked() instanceof HumanEntity))
      {
        HumanEntity p = (HumanEntity)e.getRightClicked();
        if (p.getName().equals("Inn Keeper"))
        {
          e.getPlayer().sendMessage(
            ChatColor.GRAY +
            "Hearthstone Vendor: " +
            ChatColor.WHITE +
            "I sell hearthstones!");
          Inventory inv = Bukkit.getServer().createInventory(null, 9,
            "Hearthstone Vendor");
          ItemStack Hearth = new ItemStack(Material.FIREBALL);
          ItemMeta Hearthmeta = Hearth.getItemMeta();
          Hearthmeta.setDisplayName(ChatColor.GREEN + "Hearthstone: Spawn");
          Hearthmeta.setLore(
            Arrays.asList(new String[] {
            ChatColor.RED + "Location: Dead Peaks Bank",
            ChatColor.GRAY + ChatColor.ITALIC.toString() +
            "Teleports to the location above",
            ChatColor.GRAY + "Permanent Untradeable",
            ChatColor.GREEN + "Price: " + ChatColor.WHITE +
            "1000g" }));
          Hearth.setItemMeta(Hearthmeta);
          inv.addItem(new ItemStack[] { Hearth });
         
          ItemStack Hearth2 = new ItemStack(Material.FIREBALL);
          ItemMeta Hearthmeta2 = Hearth2.getItemMeta();
          Hearthmeta2.setDisplayName(ChatColor.AQUA + "Hearthstone: Avalon");
          Hearthmeta2
            .setLore(
            Arrays.asList(new String[] {
            ChatColor.RED + "Location: Avalon Bank",
            ChatColor.GRAY + ChatColor.ITALIC.toString() +
            "Teleports to the location above",
            ChatColor.GRAY + ChatColor.BOLD.toString() +
            "Permanent Untradeable",
            ChatColor.GREEN + "Price: " +
            ChatColor.WHITE + "3000g" }));
          Hearth2.setItemMeta(Hearthmeta2);
          inv.addItem(new ItemStack[] { Hearth2 });
         
          ItemStack Hearth3 = new ItemStack(Material.FIREBALL);
          ItemMeta Hearthmeta3 = Hearth3.getItemMeta();
          Hearthmeta3.setDisplayName(ChatColor.LIGHT_PURPLE +
            "Hearthstone: Tripoli");
          Hearthmeta3.setLore(Arrays.asList(new String[] {
            ChatColor.RED + "Location: Tripoli Bank",
            ChatColor.GRAY + "Teleports to the location above",
            ChatColor.GRAY + ChatColor.ITALIC.toString() +
            "Permanent Untradeable",
            ChatColor.GREEN + "Price: " + ChatColor.WHITE +
            "2500g" }));
          Hearth3.setItemMeta(Hearthmeta3);
          inv.addItem(new ItemStack[] { Hearth3 });
         
          ItemStack Hearth4 = new ItemStack(Material.FIREBALL);
          ItemMeta Hearthmeta4 = Hearth4.getItemMeta();
          Hearthmeta4.setDisplayName(ChatColor.YELLOW +
            "Hearthstone: Cave");
          Hearthmeta4
            .setLore(
            Arrays.asList(new String[] {
                    ChatColor.RED + "Location: Cave Bank",
                    ChatColor.GRAY + "Teleports to the location above",
                    ChatColor.GRAY + ChatColor.ITALIC.toString() +
                    "Permanent Untradeable",
                    ChatColor.GREEN + "Price: " + ChatColor.WHITE +
                    "1500g" }));
          Hearth4.setItemMeta(Hearthmeta4);
          inv.addItem(new ItemStack[] { Hearth4 });
         
          e.getPlayer().openInventory(inv);
          e.getPlayer().playSound(p.getLocation(), Sound.WOOD_CLICK,
            1.0F, 1.0F);
        }
      }
    }
   
    @EventHandler
    public void onHearthstoneClick(InventoryClickEvent e) {
      Player p = (Player)e.getWhoClicked();
      if (e.getInventory().getTitle().equals("Hearthstone Vendor"))
      {
        e.setCancelled(true);
        if ((e.getCurrentItem().getType() == Material.FIREBALL) &&
          (e.getCurrentItem().getItemMeta().hasLore()))
        {
          if (e.getCurrentItem().getItemMeta().getLore().contains(ChatColor.GREEN + "Price: " + ChatColor.WHITE + "1000g"))
          {
            if (Main.econ.getBalance(p.getName()) >= 1000.0D)
            {
              p.getInventory().remove(Material.FIREBALL);
              ItemStack Hearth = new ItemStack(Material.FIREBALL);
              ItemMeta Hearthmeta = Hearth.getItemMeta();
              Hearthmeta.setDisplayName(ChatColor.GREEN +
                "Hearthstone: Spawn");
              Hearthmeta.setLore(Arrays.asList(new String[] {
                ChatColor.RED + "Location: Dead Peaks Bank",
                ChatColor.GRAY + ChatColor.ITALIC.toString() +
                "Teleports to the location above",
                ChatColor.GRAY + "Permanent Untradeable" }));
              Hearth.setItemMeta(Hearthmeta);
             
              Main.econ.withdrawPlayer(p.getName(), 1000.0D);
              p.sendMessage(ChatColor.RED + "-1000" + ChatColor.BOLD.toString() +
                "G");
              p.getInventory().addItem(new ItemStack[] { Hearth });
              return;
            }
            p.sendMessage(ChatColor.RED +
              "You don't have enough GEM(s) for 1x of this.plugin item.");
            p.sendMessage(ChatColor.RED + "COST: 1000");
            p.closeInventory();
          }
        }
     
      if ((e.getCurrentItem().getType() == Material.FIREBALL) &&
              (e.getCurrentItem().getItemMeta().hasLore()))
            {
              if (e.getCurrentItem().getItemMeta().getLore().contains(ChatColor.GREEN + "Price: " + ChatColor.WHITE + "3000g"))
              {
                if (Main.econ.getBalance(p.getName()) >= 3000.0D)
                {
                  p.getInventory().remove(Material.FIREBALL);
                  ItemStack Hearth = new ItemStack(Material.FIREBALL);
                  ItemMeta Hearthmeta = Hearth.getItemMeta();
                  Hearthmeta.setDisplayName(ChatColor.GREEN +
                    "Hearthstone: Avalon");
                  Hearthmeta.setLore(Arrays.asList(new String[] {
                    ChatColor.RED + "Location: Avalon Bank",
                    ChatColor.GRAY + ChatColor.ITALIC.toString() +
                    "Teleports to the location above",
                    ChatColor.GRAY + "Permanent Untradeable" }));
                  Hearth.setItemMeta(Hearthmeta);
                 
                  Main.econ.withdrawPlayer(p.getName(), 3000.0D);
                  p.sendMessage(ChatColor.RED + "-3000" + ChatColor.BOLD.toString() +
                    "G");
                  p.getInventory().addItem(new ItemStack[] { Hearth });
                  return;
                }
                p.sendMessage(ChatColor.RED +
                  "You don't have enough GEM(s) for 1x of this.plugin item.");
                p.sendMessage(ChatColor.RED + "COST: 3000");
                p.closeInventory();
              }
            }
      }
        if ((e.getCurrentItem().getType() == Material.FIREBALL) &&
                  (e.getCurrentItem().getItemMeta().hasLore()))
                {
                  if (e.getCurrentItem().getItemMeta().getLore().contains(ChatColor.GREEN + "Price: " + ChatColor.WHITE + "2500g"))
                  {
                    if (Main.econ.getBalance(p.getName()) >= 2500.0D)
                    {
                      p.getInventory().remove(Material.FIREBALL);;
                      ItemStack Hearth = new ItemStack(Material.FIREBALL);
                      ItemMeta Hearthmeta = Hearth.getItemMeta();
                      Hearthmeta.setDisplayName(ChatColor.GREEN +
                        "Hearthstone: Tripoli");
                      Hearthmeta.setLore(Arrays.asList(new String[] {
                        ChatColor.RED + "Location: Tripoli Bank",
                        ChatColor.GRAY + ChatColor.ITALIC.toString() +
                        "Teleports to the location above",
                        ChatColor.GRAY + "Permanent Untradeable" }));
                      Hearth.setItemMeta(Hearthmeta);
                     
                      Main.econ.withdrawPlayer(p.getName(), 2500.0D);
                      p.sendMessage(ChatColor.RED + "-2500" + ChatColor.BOLD.toString() +
                        "G");
                      p.getInventory().addItem(new ItemStack[] { Hearth });
                      return;
                    }
                    p.sendMessage(ChatColor.RED +
                      "You don't have enough GEM(s) for 1x of this.plugin item.");
                    p.sendMessage(ChatColor.RED + "COST: 2500");
                    p.closeInventory();
                  }
                }
        if ((e.getCurrentItem().getType() == Material.FIREBALL) &&
                  (e.getCurrentItem().getItemMeta().hasLore()))
                {
                  if (e.getCurrentItem().getItemMeta().getLore().contains(ChatColor.GREEN + "Price: " + ChatColor.WHITE + "1500g"))
                  {
                    if (Main.econ.getBalance(p.getName()) >= 1500.0D)
                    {
                      p.getInventory().remove(Material.FIREBALL);
                      ItemStack Hearth = new ItemStack(Material.FIREBALL);
                      ItemMeta Hearthmeta = Hearth.getItemMeta();
                      Hearthmeta.setDisplayName(ChatColor.GREEN +
                        "Hearthstone: Cave");
                      Hearthmeta.setLore(Arrays.asList(new String[] {
                        ChatColor.RED + "Location: Cave Bank",
                        ChatColor.GRAY + ChatColor.ITALIC.toString() +
                        "Teleports to the location above",
                        ChatColor.GRAY + "Permanent Untradeable" }));
                      Hearth.setItemMeta(Hearthmeta);
                     
                      Main.econ.withdrawPlayer(p.getName(), 1500.0D);
                      p.sendMessage(ChatColor.RED + "-1500" + ChatColor.BOLD.toString() +
                        "G");
                      p.getInventory().addItem(new ItemStack[] { Hearth });
                      return;
                    }
                    p.sendMessage(ChatColor.RED +
                      "You don't have enough GEM(s) for 1x of this.plugin item.");
                    p.sendMessage(ChatColor.RED + "COST: 1500");
                    p.closeInventory();
          return;
        }
     
    }
    }
}