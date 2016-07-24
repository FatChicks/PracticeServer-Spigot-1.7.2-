package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;

import ca.wacos.nametagedit.NametagAPI;

public class Respawn
  implements Listener
{
  public Main plugin;
  public final HashMap<String, ItemStack[]> inv = new HashMap();
  public static List<String> neutral = new ArrayList();
  public static List<String> chaotic = new ArrayList();
  public static List<String> t1h = new ArrayList();
  public static List<String> t2h = new ArrayList();
  public static List<String> t3h = new ArrayList();
  public static List<String> t4h = new ArrayList();
  
  public Respawn(Main plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onChaoticSpawn(PlayerRespawnEvent e)
  {
    final Player p = e.getPlayer();
    if (chaotic.contains(p.getName()))
    {
      p.sendMessage(ChatColor.RED.toString() + "You " + ChatColor.UNDERLINE + 
        "cannot" + ChatColor.RED.toString() + " enter " + ChatColor.BOLD + 
        "NON-PVP" + ChatColor.RED.toString() + 
        " zones with a chaotic alignment.");
      new BukkitRunnable()
      {
        public void run()
        {
          Bukkit.getServer().dispatchCommand(
            Bukkit.getConsoleSender(), 
            "warp chaospawn " + p.getName());
        }
      }.runTaskLater(this.plugin, 1L);
    }
  }
  
  @EventHandler
  public void onEnter(RegionEnterEvent e)
  {
    if ((((StateFlag.State)e.getRegion().getFlag(DefaultFlag.PVP)).equals(StateFlag.State.DENY)) && 
      (chaotic.contains(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getPlayer().sendMessage(
        ChatColor.RED.toString() + "You " + ChatColor.UNDERLINE + "cannot" + 
        ChatColor.RED.toString() + " enter " + ChatColor.BOLD + 
        "NON-PVP" + ChatColor.RED.toString() + 
        " zones with a chaotic alignment.");
    }
  }
  
  @EventHandler
  public void onChaoticEnter(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (chaotic.contains(p.getName()))
    {
      int fromX = (int)e.getFrom().getX();
      int fromY = (int)e.getFrom().getY();
      int fromZ = (int)e.getFrom().getZ();
      int toX = (int)e.getTo().getX();
      int toY = (int)e.getTo().getY();
      int toZ = (int)e.getTo().getZ();
      if (((fromX != toX) || (fromZ != toZ) || (fromY != toY)) && 
        (this.plugin.wg != null) && 
        (this.plugin.wg.getRegionManager(p.getWorld()) != null) && 
        (this.plugin.wg.getRegionManager(p.getWorld())
        .getApplicableRegions(p.getLocation()) != null))
      {
        ApplicableRegionSet set = this.plugin.wg.getRegionManager(
          e.getTo().getWorld()).getApplicableRegions(
          e.getTo());
        if (!set.allows(DefaultFlag.PVP))
        {
          Vector unitVector = p.getLocation().toVector()
            .subtract(e.getTo().toVector()).normalize();
          p.setVelocity(unitVector.multiply(0.5D).setY(0));
        }
      }
    }
  }
  
  @EventHandler
  public void onEnterMessage(RegionEnterEvent e)
  {
    Player p = e.getPlayer();
    if (e.getRegion().getFlag(DefaultFlag.PVP) == StateFlag.State.DENY)
    {
      p.sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD + 
        "          *** SAFE ZONE (DMG-OFF) ***");
      p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 0.5F, -10.0F);
    }
  }
  
  @EventHandler
  public void onLeaveMessage(RegionLeaveEvent e)
  {
    Player p = e.getPlayer();
    if (e.getRegion().getFlag(DefaultFlag.PVP) == StateFlag.State.DENY)
    {
      p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + 
        "          *** CHAOTIC ZONE (PVP-ON) ***");
      p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 0.5F, -10.0F);
    }
  }
  @EventHandler
  public void SaddleDeath(PlayerDeathEvent e){
	  Player p = e.getEntity();
	  for(ItemStack item: e.getDrops()){
	  if(chaotic.contains(p.getName())) {
		  if(p.getInventory().contains(Material.SADDLE)) {
			  e.getDrops().remove(Material.SADDLE);
			  if(item.getItemMeta().getDisplayName().contains("Old Horse Mount")) {
				  t1h.add(p.getName());
			  }else if(item.getItemMeta().getDisplayName().contains("§bTraveler's Horse Mount")) {
				  t2h.add(p.getName());
			  }else if(item.getItemMeta().getDisplayName().contains("§dKnight's Horse Mount")) {
				  t3h.add(p.getName());
			  }else if(item.getItemMeta().getDisplayName().contains("§eWar Stallion Mount")) {
				  t4h.add(p.getName());
			  }
		  }
	  }
	  }
  }
  @EventHandler
  public void onSaddlePickup(PlayerPickupItemEvent e) {
	  if (e.getItem().getItemStack().getType() == Material.SADDLE) {
      if (e.isCancelled()) {
          return;
      }
     
      e.setCancelled(true);
	  }
  }

  @EventHandler
  public void onSaddleRespawn(PlayerRespawnEvent e) {
	  Player p = e.getPlayer();
	  if(t1h.contains(p.getName())) {
		  ItemStack saddle = new ItemStack(Material.SADDLE);
	        ItemMeta saddlemeta = saddle.getItemMeta();
	        saddlemeta.setDisplayName(ChatColor.GREEN + "Old Horse Mount");
	        saddlemeta.setLore(
	          Arrays.asList(new String[] {
	          ChatColor.RED + "Speed: 120%",
	          ChatColor.GRAY + ChatColor.ITALIC.toString() +
	          "An old brown starter horse.",
	          ChatColor.GRAY + "Permanent Untradeable"}));
	        saddle.setItemMeta(saddlemeta);
	        p.getInventory().addItem(new ItemStack[] { saddle });
	        t1h.remove(p.getName());
	  }else if(t2h.contains(p.getName())) {
		  ItemStack saddle3 = new ItemStack(Material.SADDLE);
	       ItemMeta saddlemeta3 = saddle3.getItemMeta();
	      saddlemeta3.setDisplayName("§bTraveler's Horse Mount");
	      saddlemeta3.setLore(
		          Arrays.asList(new String[] {
		    	          ChatColor.RED + "Speed: 140%", 
		    	          ChatColor.RED + "Speed: 105%",
		    	          ChatColor.GRAY + ChatColor.ITALIC.toString() +
		    	          "An old brown starter horse.",
		    	          ChatColor.GRAY + "Permanent Untradeable"}));
	      saddle3.setItemMeta(saddlemeta3);
	      p.getInventory().addItem(new ItemStack[] { saddle3 });
	        t2h.remove(p.getName());
		  
	  }else if(t3h.contains(p.getName())) {
		  ItemStack saddle4 = new ItemStack(Material.SADDLE);
	       ItemMeta saddlemeta4 = saddle4.getItemMeta();
	      saddlemeta4.setDisplayName("§dKnight's Horse Mount");
	      saddlemeta4.setLore(
		          Arrays.asList(new String[] {
		    	          ChatColor.RED + "Speed: 160%", 
		    	          ChatColor.RED + "Speed: 110%",
		    	          ChatColor.GRAY + ChatColor.ITALIC.toString() +
		    	          "An old brown starter horse.",
		    	          ChatColor.GRAY + "Permanent Untradeable"}));
	      saddle4.setItemMeta(saddlemeta4);
	      p.getInventory().addItem(new ItemStack[] { saddle4 });
	       t3h.remove(p.getName());
	  }else if(t4h.contains(p.getName())) {
		  ItemStack saddle5 = new ItemStack(Material.SADDLE);
	       ItemMeta saddlemeta5 = saddle5.getItemMeta();
	      saddlemeta5.setDisplayName("§eWar Stallion Mount");
	      saddlemeta5.setLore(
		          Arrays.asList(new String[] {
		    	          ChatColor.RED + "Speed: 180%", 
		    	          ChatColor.RED + "Speed: 115%",
		    	          ChatColor.GRAY + ChatColor.ITALIC.toString() +
		    	          "An old brown starter horse.",
		    	          ChatColor.GRAY + "Permanent Untradeable"}));
	      saddle5.setItemMeta(saddlemeta5);
	      p.getInventory().addItem(new ItemStack[] { saddle5 });
	        t4h.remove(p.getName());
	  }
  }
			  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    if (chaotic.contains(p.getName())) {
      NametagAPI.setNametagHard(p.getName(), ChatColor.RED.toString(), 
        null);
    } else if ((neutral.contains(p.getName())) && 
      (!chaotic.contains(p.getName()))) {
      NametagAPI.setNametagHard(p.getName(), ChatColor.YELLOW.toString(), 
        null);
    } else {
      NametagAPI.updateNametagHard(p.getName(), null, null);
    }
  }
  
  @EventHandler
  public void onNeutral(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof Player)))
    {
      final Player d = (Player)e.getDamager();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((neutral.contains(d.getName())) && 
        (!chaotic.contains(d.getName())))
      {
        neutral.add(d.getName());
        new BukkitRunnable()
        {
          public void run()
          {
            Respawn.neutral.remove(d.getName());
            if ((!Respawn.neutral.contains(d.getName())) && 
              (!Respawn.chaotic.contains(d.getName())) && 
              (d.isOnline()))
            {
              d.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
              d.sendMessage("§7While lawful, you will not lose any equiped armor on death.");
              d.sendMessage("§7Any players who kill you while you're lawfully aligned will");
              d.sendMessage("§7become chaotic.");
              d.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
              NametagAPI.updateNametagHard(d.getName(), null, 
                null);
            }
          }
        }.runTaskLater(this.plugin, 1200L);
      }
      else if ((!neutral.contains(d.getName())) && 
        (!chaotic.contains(d.getName())))
      {
        d.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
        d.sendMessage("§7While neutral, players who kill you will not become chaotic. You");
        d.sendMessage("§7have a 50% chance of dropping your weapon, and a 25%");
        d.sendMessage("§7chance of dropping each piece of equiped armor on death.");
        d.sendMessage("§7Neutral alignment will expire 1 minute after last hit on player.");
        d.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
        neutral.add(d.getName());
        NametagAPI.updateNametagHard(d.getName(), 
          ChatColor.YELLOW.toString(), null);
        new BukkitRunnable()
        {
          public void run()
          {
            Respawn.neutral.remove(d.getName());
            if ((!Respawn.neutral.contains(d.getName())) && 
              (!Respawn.chaotic.contains(d.getName())) && 
              (d.isOnline()))
            {
              d.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
              d.sendMessage("§7While lawful, you will not lose any equiped armor on death.");
              d.sendMessage("§7Any players who kill you while you're lawfully aligned will");
              d.sendMessage("§7become chaotic.");
              d.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
              NametagAPI.updateNametagHard(d.getName(), null, 
                null);
            }
          }
        }.runTaskLater(this.plugin, 1200L);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onChaotic(EntityDamageByEntityEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Damageable p = (Damageable)e.getEntity();
      Player b = (Player)e.getEntity();
      if ((e.getDamager() instanceof Player))
      {
        final Player d = (Player)e.getDamager();
        if ((e.getDamage() >= p.getHealth()) && 
          (b.getNoDamageTicks() <= b.getMaximumNoDamageTicks() / 2) && 
          (!neutral.contains(b.getName())) && 
          (!chaotic.contains(b.getName()))) {
          if (chaotic.contains(d.getName()))
          {
            chaotic.add(d.getName());
            d.sendMessage("§cLAWFUL player slain, §cChaotic timer reset to 5 minutes");
            new BukkitRunnable()
            {
              public void run()
              {
                Respawn.chaotic.remove(d.getName());
                Respawn.neutral.add(d.getName());
                if ((!Respawn.chaotic.contains(d.getName())) && 
                  (d.isOnline()))
                {
                  d.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
                  d.sendMessage("§7While neutral, players who kill you will not become chaotic. You");
                  d.sendMessage("§7have a 50% chance of dropping your weapon, and a 25%");
                  d.sendMessage("§7chance of dropping each piece of equipped armor on death.");
                  d.sendMessage("§7Neutral alignment will expire 1 minute after last hit on player.");
                  d.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
                  NametagAPI.updateNametagHard(d.getName(), 
                    ChatColor.YELLOW.toString(), null);
                }
              }
            }.runTaskLater(this.plugin, 6000L);
            new BukkitRunnable()
            {
              public void run()
              {
                Respawn.neutral.remove(d.getName());
                if ((!Respawn.chaotic.contains(d.getName())) && 
                  (!Respawn.neutral.contains(d.getName())) && (d.isOnline()))
                {
                  d.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                  d.sendMessage("§7While lawful, you will not lose any equipped armor on death.");
                  d.sendMessage("§7Any players who kill you while you're lawfully aligned will");
                  d.sendMessage("§7become chaotic.");
                  d.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                  NametagAPI.updateNametagHard(d.getName(), 
                    null, null);
                }
              }
            }.runTaskLater(this.plugin, 8000L);
          }
          else if (!chaotic.contains(d.getName()))
          {
            NametagAPI.updateNametagHard(d.getName(), 
              ChatColor.RED.toString().toString(), null);
            d.sendMessage("          §c* YOU ARE NOW §lCHAOTIC §cALIGNMENT *");
            d.sendMessage("§7If you are killed while chaotic, you will lose everything");
            d.sendMessage("§7in your inventory. Chaotic alignment will expire 5 minutes after");
            d.sendMessage("§7your last player kill.");
            d.sendMessage("          §c* YOU ARE NOW §lCHAOTIC §cALIGNMENT *");
            d.sendMessage("§cLAWFUL player slain, §l+300s §cadded to Chaotic timer");
            chaotic.add(d.getName());
            new BukkitRunnable()
            {
              public void run()
              {
                Respawn.chaotic.remove(d.getName());
                Respawn.neutral.add(d.getName());
                if ((!Respawn.chaotic.contains(d.getName())) && 
                  (d.isOnline()))
                {
                  d.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
                  d.sendMessage("§7While neutral, players who kill you will not become chaotic. You");
                  d.sendMessage("§7have a 50% chance of dropping your weapon, and a 25%");
                  d.sendMessage("§7chance of dropping each piece of equipped armor on death.");
                  d.sendMessage("§7Neutral alignment will expire 1 minute after last hit on player.");
                  d.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
                  NametagAPI.updateNametagHard(d.getName(), 
                    ChatColor.YELLOW.toString(), null);
                }
              }
            }.runTaskLater(this.plugin, 6000L);
            new BukkitRunnable()
            {
              public void run()
              {
                Respawn.neutral.remove(d.getName());
                if ((!Respawn.chaotic.contains(d.getName())) && 
                  (!Respawn.neutral.contains(d.getName())) && (d.isOnline()))
                {
                  d.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                  d.sendMessage("§7While lawful, you will not lose any equipped armor on death.");
                  d.sendMessage("§7Any players who kill you while you're lawfully aligned will");
                  d.sendMessage("§7become chaotic.");
                  d.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
                  NametagAPI.updateNametagHard(d.getName(), 
                    null, null);
                }
              }
            }.runTaskLater(this.plugin, 8000L);
          }
        }
      }
    }
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onDeath(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    Random random = new Random();
    
    int wepdrop = random.nextInt(2) + 1;
    int armor = random.nextInt(4) + 1;
    int piece = random.nextInt(4) + 1;
    
    int min = random.nextInt(2) + 2;
    int max = random.nextInt(2) + 4;
    List<ItemStack> newInventory = new ArrayList();
    if ((!neutral.contains(p.getName())) && 
      (!chaotic.contains(p.getName())))
    {
      if (p.getInventory().getBoots() != null) {
        newInventory.add(p.getInventory().getBoots());
      }
      if (p.getInventory().getLeggings() != null) {
        newInventory.add(p.getInventory().getLeggings());
      }
      if (p.getInventory().getChestplate() != null) {
        newInventory.add(p.getInventory().getChestplate());
      }
      if (p.getInventory().getHelmet() != null) {
        newInventory.add(p.getInventory().getHelmet());
      }
      if (p.getInventory().getItem(0) != null)
      {
        newInventory.add(p.getInventory().getItem(0));
      }
      else
      {
        int wep = random.nextInt(2) + 1;
        if (wep == 1)
        {
          ItemStack S = new ItemStack(Material.WOOD_SWORD);
          ItemMeta smeta = S.getItemMeta();
          smeta.setDisplayName(ChatColor.WHITE + "Training Sword");
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + max);
          slore.add(ChatColor.GRAY.toString() + "Untradeable");
          smeta.setLore(slore);
          S.setItemMeta(smeta);
          newInventory.add(S);
        }
        if (wep == 2)
        {
          ItemStack S = new ItemStack(Material.WOOD_AXE);
          ItemMeta smeta = S.getItemMeta();
          smeta.setDisplayName(ChatColor.WHITE + "Training Hatchet");
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + max);
          slore.add(ChatColor.GRAY.toString() + "Untradeable");
          smeta.setLore(slore);
          S.setItemMeta(smeta);
          newInventory.add(S);
        }
      }
      if (p.getInventory().contains(Material.GOLD_PICKAXE)) {
        for (int i = 1; i < p.getInventory().getSize(); i++) {
          if ((p.getInventory().getItem(i) != null) && 
            (p.getInventory().getItem(i).getType() == Material.GOLD_PICKAXE)) {
            newInventory.add(p.getInventory().getItem(i));
          }
        }
      }
      if (p.getInventory().contains(Material.FIREWORK_CHARGE)) {
          for (int i = 1; i < p.getInventory().getSize(); i++) {
            if ((p.getInventory().getItem(i) != null) && 
              (p.getInventory().getItem(i).getType() == Material.FIREWORK_CHARGE)) {
              newInventory.add(p.getInventory().getItem(i));
            }
          }
      }
  
      if (p.getInventory().contains(Material.SADDLE)) {
          for (int i = 1; i < p.getInventory().getSize(); i++) {
            if ((p.getInventory().getItem(i) != null) && 
              (p.getInventory().getItem(i).getType() == Material.SADDLE)) {
              newInventory.add(p.getInventory().getItem(i));
            }
          }
        }
    }
    else if ((neutral.contains(p.getName())) && 
      (!chaotic.contains(p.getName())))
    {
      if (armor == 1)
      {
        if ((piece != 1) && (p.getInventory().getBoots() != null)) {
          newInventory.add(p.getInventory().getBoots());
        }
        if ((piece != 2) && (p.getInventory().getLeggings() != null)) {
          newInventory.add(p.getInventory().getLeggings());
        }
        if ((piece != 3) && (p.getInventory().getChestplate() != null)) {
          newInventory.add(p.getInventory().getChestplate());
        }
        if ((piece != 4) && (p.getInventory().getHelmet() != null)) {
          newInventory.add(p.getInventory().getHelmet());
        }
      }
      else
      {
        if (p.getInventory().getBoots() != null) {
          newInventory.add(p.getInventory().getBoots());
        }
        if (p.getInventory().getLeggings() != null) {
          newInventory.add(p.getInventory().getLeggings());
        }
        if (p.getInventory().getChestplate() != null) {
          newInventory.add(p.getInventory().getChestplate());
        }
        if (p.getInventory().getHelmet() != null) {
          newInventory.add(p.getInventory().getHelmet());
        }
      }
      int wep = random.nextInt(2) + 1;
      if (wepdrop == 1)
      {
        if (p.getInventory().getItem(0) != null)
        {
          newInventory.add(p.getInventory().getItem(0));
        }
        else
        {
          if (wep == 1)
          {
            ItemStack S = new ItemStack(Material.WOOD_SWORD);
            ItemMeta smeta = S.getItemMeta();
            smeta.setDisplayName(ChatColor.WHITE + "Training Sword");
            List<String> slore = new ArrayList();
            slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + max);
            slore.add(ChatColor.GRAY.toString() + "Untradeable");
            smeta.setLore(slore);
            S.setItemMeta(smeta);
            newInventory.add(S);
          }
          if (wep == 2)
          {
            ItemStack S = new ItemStack(Material.WOOD_AXE);
            ItemMeta smeta = S.getItemMeta();
            smeta.setDisplayName(ChatColor.WHITE + 
              "Training Hatchet");
            List<String> slore = new ArrayList();
            slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + max);
            slore.add(ChatColor.GRAY.toString() + "Untradeable");
            smeta.setLore(slore);
            S.setItemMeta(smeta);
            newInventory.add(S);
          }
        }
      }
      else
      {
        if (wep == 1)
        {
          ItemStack S = new ItemStack(Material.WOOD_SWORD);
          ItemMeta smeta = S.getItemMeta();
          smeta.setDisplayName(ChatColor.WHITE + "Training Sword");
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + max);
          slore.add(ChatColor.GRAY.toString() + "Untradeable");
          smeta.setLore(slore);
          S.setItemMeta(smeta);
          newInventory.add(S);
        }
        if (wep == 2)
        {
          ItemStack S = new ItemStack(Material.WOOD_AXE);
          ItemMeta smeta = S.getItemMeta();
          smeta.setDisplayName(ChatColor.WHITE + "Training Hatchet");
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + max);
          slore.add(ChatColor.GRAY.toString() + "Untradeable");
          smeta.setLore(slore);
          S.setItemMeta(smeta);
          newInventory.add(S);
        }
      }
      if (p.getInventory().contains(Material.GOLD_PICKAXE)) {
        for (int i = 1; i < p.getInventory().getSize(); i++) {
          if ((p.getInventory().getItem(i) != null) && 
            (p.getInventory().getItem(i).getType() == Material.GOLD_PICKAXE)) {
            newInventory.add(p.getInventory().getItem(i));
          }
        }
      }
      if (p.getInventory().contains(Material.FIREWORK_CHARGE)) {
          for (int i = 1; i < p.getInventory().getSize(); i++) {
            if ((p.getInventory().getItem(i) != null) && 
              (p.getInventory().getItem(i).getType() == Material.FIREWORK_CHARGE)) {
              newInventory.add(p.getInventory().getItem(i));
            }
          }
      }
      if (p.getInventory().contains(Material.SADDLE)) {
          for (int i = 1; i < p.getInventory().getSize(); i++) {
            if ((p.getInventory().getItem(i) != null) && 
              (p.getInventory().getItem(i).getType() == Material.SADDLE)) {
              newInventory.add(p.getInventory().getItem(i));
            }
          }
        }
    }
    else if (chaotic.contains(p.getName()))
    {
      int wep = random.nextInt(2) + 1;
      if (wep == 1)
      {
        ItemStack S = new ItemStack(Material.WOOD_SWORD);
        ItemMeta smeta = S.getItemMeta();
        smeta.setDisplayName(ChatColor.WHITE + "Training Sword");
        List<String> slore = new ArrayList();
        slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + max);
        slore.add(ChatColor.GRAY.toString() + "Untradeable");
        smeta.setLore(slore);
        S.setItemMeta(smeta);
        newInventory.add(S);
      }
      if (wep == 2)
      {
        ItemStack S = new ItemStack(Material.WOOD_AXE);
        ItemMeta smeta = S.getItemMeta();
        smeta.setDisplayName(ChatColor.WHITE + "Training Hatchet");
        List<String> slore = new ArrayList();
        slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + max);
        slore.add(ChatColor.GRAY.toString() + "Untradeable");
        smeta.setLore(slore);
        S.setItemMeta(smeta);
        newInventory.add(S);
      }
    }
    ItemStack[] newStack = 
      (ItemStack[])newInventory.toArray(new ItemStack[newInventory.size()]);
    this.inv.put(p.getName(), newStack);
    e.getDrops().removeAll(newInventory);
  }
  
  @EventHandler
  public void onRespawn(PlayerRespawnEvent e)
  {
    ItemStack[] newInventory = (ItemStack[])this.inv.get(e.getPlayer()
      .getName());
    if (this.inv.containsKey(e.getPlayer().getName()))
    {
      e.getPlayer().getInventory().addItem(newInventory);
      e.getPlayer().setMaxHealth(50.0D);
      e.getPlayer().setHealth(50.0D);
    }
    this.inv.remove(e.getPlayer());
  }
}