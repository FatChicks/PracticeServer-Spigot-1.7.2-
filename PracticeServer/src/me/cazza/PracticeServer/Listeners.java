package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Horse;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.mewin.WGRegionEvents.events.RegionLeaveEvent;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;

import net.milkbowl.vault.economy.Economy;

public class Listeners
  implements Listener
{
  WorldGuardPlugin wg = (WorldGuardPlugin)Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
  public static Main plugin;
  public int regen = 1;
  private HashMap<String, Location> Loc = new HashMap<String, Location>();
  List<String> energy = new ArrayList<String>();
  List<String> combat = new ArrayList<String>();
  List<LivingEntity> nodamage = new ArrayList<LivingEntity>();
  List<String> incombat = new ArrayList<String>();
  List<String> cooldown = new ArrayList<String>();
  public static HashMap<Player, Monster> combatmob = new HashMap<Player, Monster>();
  public static List<String> drops = new ArrayList<String>();
  private List<Material> armorMaterials = new ArrayList<Material>(
		  
  Arrays.asList(new Material[] {Material.LEATHER_BOOTS, Material.LEATHER_LEGGINGS, Material.LEATHER_CHESTPLATE, Material.LEATHER_HELMET, Material.IRON_BOOTS, Material.IRON_CHESTPLATE, Material.IRON_HELMET, Material.IRON_LEGGINGS, Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_LEGGINGS, Material.GOLD_BOOTS, Material.GOLD_CHESTPLATE, Material.GOLD_HELMET, Material.GOLD_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_HELMET, Material.DIAMOND_LEGGINGS }));
  
  public Listeners(Main m)
  {
    plugin = m;
  }
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerInteract(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    Action action = event.getAction();
    if (((action.equals(Action.RIGHT_CLICK_BLOCK)) || 
      (action.equals(Action.RIGHT_CLICK_AIR))) && 
      (this.armorMaterials.contains(player.getItemInHand().getType())))
    {
      event.setCancelled(true);
      player.updateInventory();
    }
  }
  public static Economy econ = null;

@EventHandler
  public void onHungerLoss(FoodLevelChangeEvent e)
  {
    e.setCancelled(true);
  }
  @EventHandler
  public void onGlobalBuff(PlayerInteractEvent e)
  {
    Action a = e.getAction();
    final Player p = e.getPlayer();
    if (((a.equals(Action.RIGHT_CLICK_AIR)) || 
      (a.equals(Action.RIGHT_CLICK_BLOCK))) && 
      (p.getItemInHand().getType() == Material.DIAMOND) && 
      (p.getItemInHand().hasItemMeta()) && 
      (p.getItemInHand().getItemMeta().getDisplayName().contains("Global Loot Buff"))) {
      if (drops.isEmpty())
      {
        drops.add(p.getName());
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer()
          .broadcastMessage(
          "§6§l>> §7" + 
          p.getName() + 
          " §6has just activated a §6§n+20% Global Drop Rates§6 for 30 minutes by using 'Global Loot Buff' from our store!");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        int item = p.getItemInHand().getAmount();
        if (p.getItemInHand().getAmount() == 1) {
          p.setItemInHand(null);
        } else {
          p.getItemInHand().setAmount(item - 1);
        }
        new BukkitRunnable()
        {
          public void run()
          {
            Bukkit.getServer().broadcastMessage("");
            Bukkit.getServer().broadcastMessage("");
            Bukkit.broadcastMessage("§6§l>> §7" + 
              p.getName() + 
              "§7's §6§nGlobal Loot Buff§6 has expired.");
            Bukkit.getServer().broadcastMessage("");
            Bukkit.getServer().broadcastMessage("");
            drops.remove(p.getName());
            Player[] arrayOfPlayer;
            int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
            for (int i = 0; i < j; i++)
            {
              Player all = arrayOfPlayer[i];
              all.playSound(all.getLocation(), 
                Sound.ZOMBIE_INFECT, 10.0F, -10.0F);
            }
          }
        }.runTaskLater(this.plugin, 36000L);
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player all = arrayOfPlayer[i];
          all.playSound(all.getLocation(), Sound.LEVEL_UP, 10.0F, 
            1.0F);
        }
      }
      else
      {
        p.sendMessage("§6A §6§nGlobal Loot Buff§6 is already active at this time.");
      }
    }
  }
  @EventHandler
  public void onJoinBuff(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    Listeners.this.hpCheck(p);
    if (drops.isEmpty()) {
      return;
    }
    p.sendMessage("");
    p.sendMessage("§6A §6§nGlobal Loot Buff§6 is active at this time.");
    p.sendMessage("");
  }
  @EventHandler
  public void onJoin21(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    p.getInventory().setHeldItemSlot(0);
    if ((p.getInventory().getItem(0) != null) && 
    		(p.getInventory().contains(Material.FIREBALL))) {
    }else{
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
    }
  }
  @EventHandler
  public void onJoin2(PlayerJoinEvent e) {
	Player p = e.getPlayer();
	p.setHealthScale(20.0D);
	p.setHealthScaled(true);
	Random random = new Random();
	int min = random.nextInt(2) + 2;
	int max = random.nextInt(2) + 4;
  }
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
	Player p = e.getPlayer();
	p.setHealthScale(20.0D);
	p.setHealthScaled(true);
	Random random = new Random();
	int min = random.nextInt(2) + 2;
	int max = random.nextInt(2) + 4;
    p.getInventory().setHeldItemSlot(0);
    if ((p.getInventory().getItem(0) != null) && 
    		(p.getInventory().contains(Material.WOOD_AXE)) || (p.getInventory().contains(Material.WOOD_SWORD)) ||
    		(p.getInventory().contains(Material.STONE_AXE)) || (p.getInventory().contains(Material.STONE_SWORD)) ||
    		(p.getInventory().contains(Material.IRON_AXE)) || (p.getInventory().contains(Material.IRON_SWORD)) || 
    		(p.getInventory().contains(Material.DIAMOND_AXE)) || (p.getInventory().contains(Material.DIAMOND_SWORD)) ||
    		(p.getInventory().contains(Material.GOLD_AXE)) || (p.getInventory().contains(Material.GOLD_SWORD))){
    }else{
        ItemStack Train = new ItemStack(Material.WOOD_AXE);
        ItemMeta Trainmeta = Train.getItemMeta();
        Trainmeta.setDisplayName(ChatColor.GRAY +
          "Training Hatchet");
        Trainmeta.setLore(Arrays.asList(new String[] {
          ChatColor.RED + "DMG: 4 - 7",
          ChatColor.GRAY + ChatColor.ITALIC.toString(),
          ChatColor.GRAY + "Untradeable" }));
        Train.setItemMeta(Trainmeta);
        p.getInventory().addItem(new ItemStack[] { Train });
    }
  }
    
  @EventHandler
  public void onLeave(PlayerKickEvent e)
  {
    e.setLeaveMessage(null);
  }
  
  @EventHandler
  public void onPlayerLeave(PlayerQuitEvent e)
  {
    e.setQuitMessage(null);
  }
  
  @EventHandler
  public void onRespawn(PlayerRespawnEvent e)
  {
    Player p = e.getPlayer();
    for (int i = 0; i < Main.tagged.size(); i++) {
      Main.tagged.remove(p);
    }
    for (int i = 0; i < this.combat.size(); i++) {
      this.combat.remove(p);
    }
  }
  @EventHandler
  public void onAttackFromChao(EntityDamageByEntityEvent e) {
	  Player p = (Player) e.getEntity();
	  Player pd = (Player)e.getDamager();
	  ApplicableRegionSet set = this.wg.getRegionManager(
	    p.getWorld()).getApplicableRegions(p.getLocation());
	  ApplicableRegionSet setd = this.wg.getRegionManager(
			    p.getWorld()).getApplicableRegions(p.getLocation());
	  if (!set.allows(DefaultFlag.PVP)) {
		  if (setd.allows(DefaultFlag.PVP)) {
			  e.setDamage(0.0);
			  e.setCancelled(true);
			  pd.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You may not damage someone in a safezone!");
		  }
	  }
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerBlock(EntityDamageByEntityEvent e)
  {
    Random random = new Random();
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof Player)))
    {
      double block = 0.0D;
      Player d = (Player)e.getDamager();
      Player p = (Player)e.getEntity();
      PlayerInventory i = p.getInventory();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int addblock = getLifestealFromLore(i.getHelmet(), "BLOCK");
        block += addblock;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int addblock = getLifestealFromLore(i.getChestplate(), "BLOCK");
        block += addblock;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int addblock = getLifestealFromLore(i.getLeggings(), "BLOCK");
        block += addblock;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int addblock = getLifestealFromLore(i.getBoots(), "BLOCK");
        block += addblock;
      }
      if (block > 0.0D)
      {
        int blockint = random.nextInt(101) + 1;
        if (block >= blockint)
        {
          e.setDamage(0.0D);
          e.setCancelled(true);
          d.sendMessage("                        §c§l*OPPONENT BLOCKED* (" + 
            p.getName() + 
            "§c§l)");
          p.sendMessage("                        §2§l*BLOCK* (" + 
            d.getName() + "§2§l)");
          p.playSound(p.getLocation(), Sound.ZOMBIE_METAL, 1.0F, 1.0F);
        }
      }
      else
      {
        e.setDamage(e.getDamage());
      }
    }
    else if (((e.getDamager() instanceof LivingEntity)) && 
      ((e.getEntity() instanceof Player)))
    {
      double block = 0.0D;
      LivingEntity d = (LivingEntity)e.getDamager();
      Player p = (Player)e.getEntity();
      PlayerInventory i = p.getInventory();
      String name = "";
      if (Healthbar.named.contains(d)) {
        name = (String)Healthbar.name.get(d);
      } else {
        name = d.getCustomName();
      }
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int addblock = getLifestealFromLore(i.getHelmet(), "BLOCK");
        block += addblock;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int addblock = getLifestealFromLore(i.getChestplate(), "BLOCK");
        block += addblock;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int addblock = getLifestealFromLore(i.getLeggings(), "BLOCK");
        block += addblock;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int addblock = getLifestealFromLore(i.getBoots(), "BLOCK");
        block += addblock;
      }
      if (block > 0.0D)
      {
        int blockint = random.nextInt(101) + 1;
        if (block >= blockint)
        {
          e.setDamage(0.0D);
          Damageable dp = p;
          if ((p.getNoDamageTicks() <= p.getMaximumNoDamageTicks() / 2) && 
            (dp.getHealth() > 0.0D))
          {
            p.sendMessage("                        §2§l*BLOCK* (" + 
              name + "§2§l)");
            p.playSound(p.getLocation(), Sound.ZOMBIE_METAL, 1.0F, 
              1.0F);
          }
        }
      }
      else
      {
        e.setDamage(e.getDamage());
      }
    }
  }

  @EventHandler
  public void onDismount(VehicleExitEvent e)
  {
    if ((e.getVehicle() instanceof Horse)) {
      e.getVehicle().remove();
    }
  }
  @EventHandler
  public void onHorseInvClick(InventoryClickEvent e)
  {
    if ((e.getInventory() instanceof HorseInventory)) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onHorseDie(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Horse)) {
      e.setDamage(0.0D);
    }
    e.setCancelled(true);
  }
  @EventHandler(priority=EventPriority.LOWEST)
  public void onHorseDamage(EntityDamageByEntityEvent e)
  {
    if ((e.getEntity() instanceof Horse))
    {
      ApplicableRegionSet set = this.wg.getRegionManager(
        e.getEntity().getWorld()).getApplicableRegions(
        e.getEntity().getLocation());
      if (!set.allows(DefaultFlag.PVP)) {
        return;
      }
      e.setDamage(0.0D);
      e.setCancelled(true);
      if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
        e.getEntity().remove();
      }
    }
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if (p.isInsideVehicle())
      {
        ApplicableRegionSet set = this.wg
          .getRegionManager(p.getWorld()).getApplicableRegions(
          p.getLocation());
        if (!set.allows(DefaultFlag.PVP)) {
          return;
        }
        e.setDamage(0.0D);
        e.setCancelled(true);
        if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
          p.leaveVehicle();
        }
      }
    }
    if (((e.getEntity() instanceof LivingEntity)) && ((e.getDamager() instanceof Player)))
    {
      Player p = (Player)e.getDamager();
      if (p.isInsideVehicle())
      {
        ApplicableRegionSet set = this.wg
          .getRegionManager(p.getWorld()).getApplicableRegions(
          p.getLocation());
        if (!set.allows(DefaultFlag.PVP)) {
          return;
        }
        e.setDamage(0.0D);
        e.setCancelled(true);
        if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
          p.leaveVehicle();
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
      Player p = (Player)e.getDamager();
      if (Main.mount.contains(p.getName()))
      {
        Main.mount.remove(p.getName());
        p.sendMessage("§cMount Summon - §c§lCANCELLED");
      }
    }
  }
  @EventHandler
  public void onMountDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if (Main.mount.contains(p.getName()))
      {
        Main.mount.remove(p.getName());
        p.sendMessage("§cMount Summon - §c§lCANCELLED");
      }
    }
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerReflect(EntityDamageByEntityEvent e) 
  {
    Random random = new Random();
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof Player)))
    {
      double reflect = 0.0D;
      double dmg = e.getDamage();
      Player d = (Player)e.getDamager();
      Player p = (Player)e.getEntity();
      PlayerInventory i = p.getInventory();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int addreflect = getLifestealFromLore(i.getHelmet(), "REFLECT");
        reflect += addreflect;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int addreflect = getLifestealFromLore(i.getChestplate(), 
          "REFLECT");
        reflect += addreflect;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int addreflect = getLifestealFromLore(i.getLeggings(), 
          "REFLECT");
        reflect += addreflect;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int addreflect = getLifestealFromLore(i.getBoots(), "REFLECT");
        reflect += addreflect;
      }
      if (reflect > 0.0D)
      {
        int reflectint = random.nextInt(101) + 1;
        if (reflect >= reflectint)
        {
          d.damage((int)dmg);
          e.setDamage(0.0D);
          e.setCancelled(true);
          d.sendMessage("                        §c§l*OPPONENT REFLECT* (" + 
            p.getName() + 
            "§c§l)");
          p.sendMessage("                        §6§l*REFLECT* (" + 
            d.getName() + "§6§l)");
        }
      }
      else
      {
        e.setDamage(e.getDamage());
      }
    }
    else if (((e.getDamager() instanceof LivingEntity)) && 
      ((e.getEntity() instanceof Player)))
    {
      double reflect = 0.0D;
      double dmg = e.getDamage();
      LivingEntity d = (LivingEntity)e.getDamager();
      Player p = (Player)e.getEntity();
      PlayerInventory i = p.getInventory();
      String name = "";
      if (Healthbar.named.contains(d)) {
        name = (String)Healthbar.name.get(d);
      } else {
        name = d.getCustomName();
      }
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int addreflect = getLifestealFromLore(i.getHelmet(), "REFLECT");
        reflect += addreflect;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int addreflect = getLifestealFromLore(i.getChestplate(), 
          "REFLECT");
        reflect += addreflect;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int addreflect = getLifestealFromLore(i.getLeggings(), 
          "REFLECT");
        reflect += addreflect;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int addreflect = getLifestealFromLore(i.getBoots(), "REFLECT");
        reflect += addreflect;
      }
      if (reflect > 0.0D)
      {
        int reflectint = random.nextInt(101) + 1;
        if (reflect >= reflectint)
        {
          d.damage((int)dmg);
          e.setDamage(0.0D);
          Damageable dp = p;
          if ((p.getNoDamageTicks() <= p.getMaximumNoDamageTicks() / 2) && 
            (dp.getHealth() > 0.0D)) {
            p.sendMessage("                        §6§l*REFLECT* (" + 
              name + "§6§l)");
          }
        }
      }
      else
      {
        e.setDamage(e.getDamage());
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onPlayerEnergyRegen(PlayerInteractEvent e)
  {
    if (e.getAction() == Action.LEFT_CLICK_AIR)
    {
      Player p = e.getPlayer();
      PlayerInventory i = p.getInventory();
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int addregen = getLifestealFromLore(i.getHelmet(), "ENERGY REGEN");
        this.regen += addregen;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int addregen = getLifestealFromLore(i.getChestplate(), 
          "ENERGY REGEN");
        this.regen += addregen;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int addregen = getLifestealFromLore(i.getLeggings(), 
          "ENERGY REGEN");
        this.regen += addregen;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int addregen = getLifestealFromLore(i.getBoots(), "ENERGY REGEN");
        this.regen += addregen;
      }
      this.regen = ((int)(this.regen * 0.5D));
    }
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onThornsDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Entity)) && 
      ((e.getEntity() instanceof Player)))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      Player p = (Player)e.getEntity();
      Entity li = e.getDamager();
      PlayerInventory i = p.getInventory();
      double dmg = e.getDamage();
      double thorns = 0.0D;
      Damageable dp = p;
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int addthorns = getLifestealFromLore(i.getHelmet(), "THORNS");
        thorns += addthorns;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int addthorns = getLifestealFromLore(i.getChestplate(), 
          "THORNS");
        thorns += addthorns;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int addthorns = getLifestealFromLore(i.getLeggings(), "THORNS");
        thorns += addthorns;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int addthorns = getLifestealFromLore(i.getBoots(), "THORNS");
        thorns += addthorns;
      }
      if (thorns > 0.0D) {
        if ((p.getNoDamageTicks() <= p.getMaximumNoDamageTicks() / 2) && 
          (dp.getHealth() > 0.0D))
        {
          p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, 
            18);
          double divide = thorns / 100.0D;
          double pre = dmg * divide;
          ((Damageable)li).damage(pre);
        }
        else
        {
          e.setDamage(dmg);
        }
      }
    }
    else if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof Player)))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      Player p = (Player)e.getEntity();
      Player li = (Player)e.getDamager();
      PlayerInventory i = p.getInventory();
      double dmg = e.getDamage();
      double thorns = 0.0D;
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int addthorns = getLifestealFromLore(i.getHelmet(), "THORNS");
        thorns += addthorns;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int addthorns = getLifestealFromLore(i.getChestplate(), 
          "THORNS");
        thorns += addthorns;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int addthorns = getLifestealFromLore(i.getLeggings(), "THORNS");
        thorns += addthorns;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int addthorns = getLifestealFromLore(i.getBoots(), "THORNS");
        thorns += addthorns;
      }
      if (thorns > 0.0D)
      {
        p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, 18);
        double divide = thorns / 100.0D;
        double pre = dmg * divide;
        li.damage(pre + 1.0D);
      }
      else
      {
        e.setDamage(dmg);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onPlayerDodge(EntityDamageByEntityEvent e)
  {
    Random random = new Random();
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof Player)))
    {
      double dodge = 0.0D;
      Player d = (Player)e.getDamager();
      Player p = (Player)e.getEntity();
      PlayerInventory i = p.getInventory();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int adddodge = getLifestealFromLore(i.getHelmet(), "DODGE");
        dodge += adddodge;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int adddodge = getLifestealFromLore(i.getChestplate(), "DODGE");
        dodge += adddodge;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int adddodge = getLifestealFromLore(i.getLeggings(), "DODGE");
        dodge += adddodge;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int adddodge = getLifestealFromLore(i.getBoots(), "DODGE");
        dodge += adddodge;
      }
      if (dodge > 0.0D)
      {
        int dodgeint = random.nextInt(101) + 1;
        if (dodge >= dodgeint)
        {
          e.setDamage(0.0D);
          e.setCancelled(true);
          d.sendMessage("                        §c§l*OPPONENT DODGED* (" + 
            p.getName() + "§c§l)");
          p.sendMessage("                        §a§l*DODGE* (" + 
            d.getName() + "§a§l)");
          p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 1.0F, 
            1.0F);
        }
      }
      else
      {
        e.setDamage(e.getDamage());
      }
    }
    else if (((e.getDamager() instanceof LivingEntity)) && 
      ((e.getEntity() instanceof Player)))
    {
      double dodge = 0.0D;
      LivingEntity d = (LivingEntity)e.getDamager();
      Player p = (Player)e.getEntity();
      PlayerInventory i = p.getInventory();
      String name = "";
      Damageable dp = p;
      if (Healthbar.named.contains(d)) {
        name = (String)Healthbar.name.get(d);
      } else {
        name = d.getCustomName();
      }
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int adddodge = getLifestealFromLore(i.getHelmet(), "DODGE");
        dodge += adddodge;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int adddodge = getLifestealFromLore(i.getChestplate(), "DODGE");
        dodge += adddodge;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int adddodge = getLifestealFromLore(i.getLeggings(), "DODGE");
        dodge += adddodge;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int adddodge = getLifestealFromLore(i.getBoots(), "DODGE");
        dodge += adddodge;
      }
      if (dodge > 0.0D)
      {
        int dodgeint = random.nextInt(101) + 1;
        if (dodgeint <= dodge)
        {
          e.setDamage(0.0D);
          if ((p.getNoDamageTicks() <= p.getMaximumNoDamageTicks() / 2) && 
            (dp.getHealth() > 0.0D))
          {
            p.sendMessage("                        §a§l*DODGE* (" + 
              name + "§a§l)");
            p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 1.0F, 
              1.0F);
          }
        }
      }
      else
      {
        e.setDamage(e.getDamage());
      }
    }
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onEnergyUseDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      final Player p = (Player)e.getDamager();
      this.energy.add(p.getName());
      new BukkitRunnable()
      {
        public void run()
        {
          Listeners.this.energy.remove(p.getName());
        }
      }.runTaskLater(this.plugin, 10L);
      if (this.energy.contains(p.getName()))
      {
        if (p.getExp() >= -0.5D)
        {
          int amt = 0;
          if (p.getItemInHand().getType() == Material.GOLD_AXE)
          {
            this.regen /= 2;
            amt = 11 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.DIAMOND_AXE)
          {
            this.regen /= 2;
            amt = 11 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.IRON_AXE)
          {
            this.regen /= 2;
            amt = 10 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.STONE_AXE)
          {
            this.regen /= 2;
            amt = 10 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.WOOD_AXE)
          {
            this.regen /= 2;
            amt = 10 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.GOLD_SWORD)
          {
            this.regen = ((int)(this.regen * 0.1D) + this.regen / 2);
            amt = 10 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.DIAMOND_SWORD)
          {
            this.regen = ((int)(this.regen * 0.1D) + this.regen / 2);
            amt = 10 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.IRON_SWORD)
          {
            this.regen = ((int)(this.regen * 0.1D) + this.regen / 2);
            amt = 10 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.STONE_SWORD)
          {
            this.regen = ((int)(this.regen * 0.1D) + this.regen / 2);
            amt = 10 - this.regen;
          }
          else if (p.getItemInHand().getType() == Material.WOOD_SWORD)
          {
            this.regen = ((int)(this.regen * 0.1D) + this.regen / 2);
            amt = 10 - this.regen;
          }
          else
          {
            amt = 10;
          }
          p.setExp((float)(p.getExp() - amt * 0.01D));
          p.setLevel(p.getLevel() - amt + 1);
        }
        if (p.getExp() <= 0.0F)
        {
          p.setExp(-0.5F);
          p.setLevel(-50);
          p.addPotionEffect(new PotionEffect(
            PotionEffectType.SLOW_DIGGING, 25, 5), true);
        }
      }
    }
  } 

  @EventHandler
  public void onBankCancelDamager(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      Player p = (Player)e.getDamager();
      if (Main.bank.contains(p.getName()))
      {
        Main.bank.remove(p.getName());
        p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + 
        
          "Bank Open - CANCELLED");
      }
    }
  }
  
  @EventHandler
  public void onBankCancelDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if (Main.bank.contains(p.getName()))
      {
        Main.bank.remove(p.getName());
        p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + 
        
          "Bank Open - CANCELLED");
      }
    }
  }
  
  @EventHandler
  public void onBankCancelMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (Main.bank.contains(p.getName()))
    {
      int fromX = (int)e.getFrom().getX();
      int fromY = (int)e.getFrom().getY();
      int fromZ = (int)e.getFrom().getZ();
      int toX = (int)e.getTo().getX();
      int toY = (int)e.getTo().getY();
      int toZ = (int)e.getTo().getZ();
      if ((fromX != toX) || (fromZ != toZ) || 
        (fromY != toY))
      {
        Main.bank.remove(p.getName());
        p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + 
        
          "Bank Open - CANCELLED");
      }
    }
  }
  @EventHandler
  public void onLogoutDamager(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      Player p = (Player)e.getDamager();
      if (Main.logout.contains(p.getName()))
      {
        Main.logout.remove(p.getName());
        p.sendMessage("§c§lLogout §c- §c§lCANCELLED");
      }
    }
  }
  
  @EventHandler
  public void onLogoutDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if (Main.logout.contains(p.getName()))
      {
        Main.logout.remove(p.getName());
        p.sendMessage("§c§lLogout §c- §c§lCANCELLED");
      }
    }
  }
  
  @EventHandler
  public void onLogoutMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    int fromX = (int)e.getFrom().getX();
    int fromY = (int)e.getFrom().getY();
    int fromZ = (int)e.getFrom().getZ();
    int toX = (int)e.getTo().getX();
    int toY = (int)e.getTo().getY();
    int toZ = (int)e.getTo().getZ();
    if (((fromX != toX) || (fromZ != toZ) || (fromY != toY)) && 
      (Main.logout.contains(p.getName())))
    {
      Main.logout.remove(p.getName());
      p.sendMessage("§c§lLogout §c- §c§lCANCELLED");
    }
  }
  
  @EventHandler
  public void onSuicide(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    if (Main.suicide.contains(p.getName()))
    {
      e.setCancelled(true);
      if (e.getMessage().equalsIgnoreCase("y"))
      {
        for (int i = 0; i < Main.tagged.size(); i++) {
          Main.tagged.remove(p);
        }
        for (int i = 0; i < this.combat.size(); i++) {
          this.combat.remove(p);
        }
        p.setHealth(0.0D);
        Bukkit.getServer().broadcastMessage(
          p.getDisplayName() + ChatColor.WHITE.toString() + 
          " ended their own life.");
        for (int i = 0; i < Main.suicide.size(); i++) {
          Main.suicide.remove(p.getName());
        }
      }
      else
      {
        p.sendMessage(ChatColor.YELLOW + "/suicide - " + 
          ChatColor.BOLD + 
          "CANCELLED");
        for (int i = 0; i < Main.suicide.size(); i++) {
          Main.suicide.remove(p.getName());
        }
      }
    }
  }
  
  @EventHandler
  public void onFireTrail(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (Main.toggletrail.contains(p.getName()))
    {
      if ((p.hasPermission("ps.subtrail")) && 
        (!p.hasPermission("ps.subplustrail")) && 
        (!p.hasPermission("ps.subplusplustrail"))) {
        ParticleEffect.HAPPY_VILLAGER.display(
          p.getLocation(), 0.25F, 
          0.125F, 0.25F, 0.0F, 1);
      }
      if ((p.hasPermission("ps.subplustrail")) && 
        (!p.hasPermission("ps.subplusplustrail"))) {
        ParticleEffect.FLAME.display(p.getLocation(), 
          0.25F, 0.125F, 
          0.25F, 0.0F, 1);
      }
      if (p.hasPermission("ps.subplusplustrail")) {
        ParticleEffect.WITCH_MAGIC.display(
          p.getLocation(), 0.0F, 0.0F, 
          0.0F, 5.0F, 5);
      }
    }
  }
  
  @EventHandler
  public void onCombatTag(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof Player)))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      final Player p = (Player)e.getDamager();
      this.combat.add(p.getName());
      new BukkitRunnable()
      {
        public void run()
        {
          Listeners.this.combat.remove(p.getName());
        }
      }.runTaskLater(this.plugin, 200L);
    }
  }
  @EventHandler
  public void onEquip(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getSlotType().equals(InventoryType.SlotType.ARMOR)) {
      p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.25F);
    }
  }
  @EventHandler
  public void onEnter(RegionLeaveEvent e)
  {
    if ((e.getRegion().getFlag(DefaultFlag.PVP) != null) && 
      (((StateFlag.State)e.getRegion().getFlag(DefaultFlag.PVP)).equals(StateFlag.State.ALLOW)) && 
      (this.combat.contains(e.getPlayer().getName())))
    {
      Player p = e.getPlayer();
      Location Location = (Location)this.Loc.get(p.getName());
      if (p.getLocation().distance(Location) >= 1.0D) {
        p.teleport(Location);
      }
      e.getPlayer().sendMessage(
        ChatColor.RED + "You " + ChatColor.UNDERLINE + "cannot" + 
        ChatColor.RED + 
        " leave a chaotic zone while in combat.");
    }
  }
  
  @EventHandler
  public void onChaoticEnter(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (this.combat.contains(p.getName()))
    {
      int fromX = (int)e.getFrom().getX();
      int fromY = (int)e.getFrom().getY();
      int fromZ = (int)e.getFrom().getZ();
      int toX = (int)e.getTo().getX();
      int toY = (int)e.getTo().getY();
      int toZ = (int)e.getTo().getZ();
      
      ApplicableRegionSet set = this.wg.getRegionManager(
        e.getTo().getWorld()).getApplicableRegions(e.getTo());
      if (!set.allows(DefaultFlag.PVP))
      {
        Location from = e.getFrom();
        Location to = e.getTo();
        if ((from.getBlockX() != to.getBlockX()) || 
          (from.getBlockZ() != to.getBlockZ()) || 
          (from.getBlockY() != to.getBlockY()))
        {
          e.setTo(from);
          e.getPlayer().sendMessage(
            ChatColor.RED + "You " + ChatColor.UNDERLINE + 
            "cannot" + ChatColor.RED + 
            " leave a chaotic zone while in combat.");
        }
      }
    }
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onNoDamager(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof LivingEntity)) && 
      ((e.getDamager() instanceof LivingEntity)))
    {
      LivingEntity p = (LivingEntity)e.getDamager();
      ApplicableRegionSet set = this.wg.getRegionManager(
        p.getWorld()).getApplicableRegions(p.getLocation());
      if (!set.allows(DefaultFlag.PVP))
      {
        e.setDamage(0.0D);
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onNoDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof LivingEntity))
    {
      LivingEntity p = (LivingEntity)e.getEntity();
      ApplicableRegionSet set = null;
      try
      {
        set = 
          plugin.wg.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
      }
      catch (Exception localException) {}
      if (set == null) {
        return;
      }
      if (!set.allows(DefaultFlag.PVP))
      {
        e.setDamage(0.0D);
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void onCombatEnter(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (this.combat.contains(p.getName()))
    {
      int fromX = (int)e.getFrom().getX();
      int fromY = (int)e.getFrom().getY();
      int fromZ = (int)e.getFrom().getZ();
      int toX = (int)e.getTo().getX();
      int toY = (int)e.getTo().getY();
      int toZ = (int)e.getTo().getZ();
      if (((fromX != toX) || (fromZ != toZ) || (fromY != toY)) && 
        (plugin.wg != null) && 
        (plugin.wg.getRegionManager(p.getWorld()) != null) && 
        (plugin.wg.getRegionManager(p.getWorld())
        .getApplicableRegions(p.getLocation()) != null))
      {
        ApplicableRegionSet set = plugin.wg
          .getRegionManager(
          e.getTo().getWorld())
          .getApplicableRegions(
          e.getTo());
        if (!set.allows(DefaultFlag.PVP))
        {
          Vector unitVector = p.getLocation()
            .toVector()
            .subtract(e.getTo().toVector())
            .normalize();
          p.setVelocity(unitVector.multiply(0.5D).setY(
            0));
        }
      }
    }
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onNoAutoclick(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof LivingEntity)) && 
      ((e.getDamager() instanceof Player)))
    {
      final LivingEntity p = (LivingEntity)e.getEntity();
      if (this.nodamage.contains(p)) {
        e.setDamage(0.0D);
      }
      e.setCancelled(true);
      this.nodamage.add(p);
      new BukkitRunnable()
      {
        public void run()
        {
          Listeners.this.nodamage.remove(p);
        }
      }.runTaskLater(plugin, 2L);
    }
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onNoEnergyDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof LivingEntity)) && 
      ((e.getDamager() instanceof Player)))
    {
      Player d = (Player)e.getDamager();
      if (d.getExp() <= 0.0F)
      {
        e.setDamage(0.0D);
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onNoDamager(EntityDamageEvent e)
  {
    if (e.getEntity().hasMetadata("NPC"))
    {
      e.setDamage(0.0D);
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onLoginShiny(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    PlayerInventory pi = p.getInventory();
    for (int i = 0; i < pi.getSize(); i++) {
      if ((pi.getItem(i) != null) && 
        (pi.getItem(i).getItemMeta().hasDisplayName()) && 
        (!pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+4] ")) && 
        (!pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+5] ")) && 
        (!pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+6] ")) &&
        (!pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+7] ")) &&
        (!pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+8] ")) && 
        (!pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+9] ")) && 
        (!pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+10] ")) && 
        (!pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+11] "))) {
        pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+12] ");
      }
    }
    if ((pi.getHelmet() != null) && 
      (pi.getHelmet().getItemMeta().hasDisplayName()) && 
      (!pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+4] ")) && 
      (!pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+5] ")) && 
      (!pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+6] ")) && 
      (!pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+7] ")) && 
      (!pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+8] ")) && 
      (!pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+9] ")) && 
      (!pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+10] ")) && 
      (!pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+11] "))) {
      pi.getHelmet().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+12] ");
    }
    if ((pi.getChestplate() != null) && 
      (pi.getChestplate().getItemMeta().hasDisplayName()) && 
      (!pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+4] ")) && 
      (!pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+5] ")) && 
      (!pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+6] ")) && 
      (!pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+7] ")) && 
      (!pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+8] ")) && 
      (!pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+9] ")) && 
      (!pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+10] ")) && 
      (!pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+11] "))) {
      pi.getChestplate().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+12] ");
    }
    if ((pi.getLeggings() != null) && 
       (pi.getLeggings().getItemMeta().hasDisplayName()) && 
       (!pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+4] ")) && 
       (!pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+5] ")) && 
       (!pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+6] ")) && 
       (!pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+7] ")) && 
       (!pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+8] ")) && 
       (!pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+9] ")) && 
       (!pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+10] ")) && 
       (!pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+11] "))) {
       pi.getLeggings().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+12] ");
    }
    if ((pi.getBoots() != null) && 
       (pi.getBoots().getItemMeta().hasDisplayName()) && 
       (!pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+4] ")) && 
       (!pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+5] ")) && 
       (!pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+6] ")) && 
       (!pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+7] ")) && 
       (!pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+8] ")) && 
       (!pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+9] ")) && 
       (!pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+10] ")) && 
       (!pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+11] "))) {
    	pi.getBoots().getItemMeta().getDisplayName().startsWith(ChatColor.RED.toString() + "[+12] ");
    }
  }
  
  @EventHandler
  public void onOpenShinyShiny(InventoryOpenEvent e)
  {
    Inventory pi = e.getInventory();
    if (e.getInventory().getName().equals("Bank Chest (1/1)")) {
      for (int i = 0; i < pi.getSize(); i++) {
        if ((pi.getItem(i) != null) && 
          (pi.getItem(i).getItemMeta().hasDisplayName()) && (
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+4] ")) || 
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+5] ")) || 
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+6] ")) || 
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+7] ")) || 
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+8] ")) || 
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+9] ")) || 
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+10] ")) || 
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+11] ")) || 
          (pi.getItem(i).getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+12] ")))) {
          pi.getItem(i).addUnsafeEnchantment(
            Enchantment.SILK_TOUCH, 32);
        }
      }
    }
  }  
  @EventHandler
  public void onMapOpen(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (p.getItemInHand().getType() == Material.EMPTY_MAP))
    {
      e.setCancelled(true);
      p.updateInventory();
    }
  }
  @EventHandler
  public void onPtime(PlayerJoinEvent e)
  {
    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), 
      "ptime day " + e.getPlayer().getName());
  }
  @EventHandler
  public void onGemPickup(PlayerPickupItemEvent e)
  {
    Player p = e.getPlayer();
    if(!Main.togglebankgem.contains(e.getPlayer().getName())) {
    if ((e.getItem().getItemStack().getType() == Material.EMERALD) && 
      (e.getItem().getItemStack().getItemMeta().hasLore()))
    {
      p.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + 
        "            +" + ChatColor.GREEN + 
        e.getItem().getItemStack().getAmount() + ChatColor.GREEN + 
        ChatColor.BOLD.toString() + "G");
      p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
    }
    }
  }
  
  @EventHandler
  public void onDamagePercent(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      Damageable p = (Damageable)e.getEntity();
      if ((e.getCause().equals(EntityDamageEvent.DamageCause.POISON)) || 
      
        (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)) || 
        
        (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) || 
        
        (e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)))
      {
        if (p.getMaxHealth() / 80.0D < 1.0D) {
          e.setDamage(1.0D);
        } else {
          e.setDamage(p.getMaxHealth() / 80.0D);
        }
      }
      else if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
        if (e.getDamage() * p.getMaxHealth() / 80.0D >= p.getHealth()) {
          e.setDamage(p.getHealth() - 1.0D);
        } else if (e.getDamage() * p.getMaxHealth() / 80.0D < 1.0D) {
          e.setDamage(1.0D);
        } else {
          e.setDamage(e.getDamage() * p.getMaxHealth() / 
            80.0D);
        }
      }
    }
  }
  @EventHandler
  public void onEntityDamageTick(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof LivingEntity)) && 
      ((e.getDamager() instanceof LivingEntity)) && 
      (!(e.getDamager() instanceof Player)))
    {
      final LivingEntity p = (LivingEntity)e.getEntity();
      final LivingEntity d = (LivingEntity)e.getDamager();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if (p.getNoDamageTicks() < p.getMaximumNoDamageTicks() / 2)
      {
        Random random = new Random();
        final int kb = random.nextInt(2) + 1;
        new BukkitRunnable()
        {
          public void run()
          {
            if (kb == 1) {
              p.setVelocity(new Vector(
                d.getLocation()
                .getDirection().getX() * 0.25D, 
                0.175D, 
                d.getLocation()
                .getDirection().getZ() * 0.25D));
            } else {
              p.setVelocity(new Vector(
                d.getLocation()
                .getDirection()
                .getX() * 0.2D, 
                0.0D, 
                d
                .getLocation()
                .getDirection().getZ() * 0.2D));
            }
          }
        }.runTaskLater(plugin, 1L);
      }
    }
  }
  
  @EventHandler
  public void onArrowKnock(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof LivingEntity)) && 
      ((e.getDamager() instanceof Arrow)) && 
      (!(e.getDamager() instanceof Player)))
    {
      LivingEntity p = (LivingEntity)e.getEntity();
      Arrow d = (Arrow)e.getDamager();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      d.remove();
      if (p.getNoDamageTicks() < p.getMaximumNoDamageTicks() / 2)
      {
        Random random = new Random();
        int kb = random.nextInt(2) + 1;
        if (kb == 1) {
          p.setVelocity(new Vector(d.getLocation()
            .getDirection()
            .getX() * 0.25D, 0.175D, d
            .getLocation()
            .getDirection().getZ() * 0.25D));
        } else {
          p.setVelocity(new Vector(d.getLocation()
            .getDirection()
            .getX() * 0.2D, 0.0D, d.getLocation()
            .getDirection().getZ() * 0.2D));
        }
      }
    }
  }
  
  @EventHandler
  public void onEntityDamageKnock(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof LivingEntity)) && 
      ((e.getDamager() instanceof Player)))
    {
      final Player d = (Player)e.getDamager();
      final LivingEntity p = (LivingEntity)e.getEntity();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      p.setNoDamageTicks(0);
      Random random = new Random();
      final int kb = random.nextInt(2) + 1;
      new BukkitRunnable()
      {
        public void run()
        {
          if (kb == 1) {
            p.setVelocity(new Vector(d.getLocation()
              .getDirection()
              .getX() * 0.25D, 0.175D, d
              .getLocation()
              .getDirection().getZ() * 0.25D));
          } else {
            p.setVelocity(new Vector(d.getLocation()
              .getDirection()
              .getX() * 0.2D, 0.0D, d
              .getLocation()
              .getDirection().getZ() * 0.2D));
          }
        }
      }.runTaskLater(plugin, 1L);
    }
  }
  
  public static int getMinValueFromLore(ItemStack item, String value)
  {
    int returnVal = 1;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if ((lore != null) && 
        (((String)lore.get(0)).contains(value)))
      {
        String vals = ((String)lore.get(0)).split(": ")[1];
        vals = ChatColor.stripColor(vals);
        vals = vals.split(" - ")[0];
        returnVal = Integer.parseInt(vals.trim());
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  public static int getMaxValueFromLore(ItemStack item, String value)
  {
    int returnVal = 1;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if ((lore != null) && 
        (((String)lore.get(0)).contains(value)))
      {
        String vals = ((String)lore.get(0)).split(": ")[1];
        vals = ChatColor.stripColor(vals);
        vals = vals.split(" - ")[1];
        returnVal = Integer.parseInt(vals.trim());
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onPlayerDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      Player p = (Player)e.getDamager();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((p.getItemInHand() != null) && 
        (p.getItemInHand().getType() != Material.AIR) && 
        (p.getItemInHand().getItemMeta().hasLore()))
      {
        int damageMin = getMinValueFromLore(
          p.getItemInHand(), "DMG");
        int damageMax = getMaxValueFromLore(
          p.getItemInHand(), "DMG");
        Random random = new Random();
        double dmg = random.nextInt(damageMax - damageMin + 
          1) + 
          
          damageMin;
        e.setDamage(dmg);
      }
    }
  }
  
  public static int getLifestealFromLore(ItemStack item, String value)
  {
    int returnVal = 0;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if (lore != null) {
        for (int i = 0; i < lore.size(); i++) {
          if (((String)lore.get(i)).contains(value))
          {
            String vals = ((String)lore.get(i))
              .split(": ")[1];
            vals = ChatColor.stripColor(vals);
            vals = vals.replace("%", "").trim()
              .toString();
            returnVal = Integer.parseInt(vals.trim());
          }
        }
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  public static int getElemFromLore(ItemStack item, String value)
  {
    int returnVal = 0;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if (lore != null) {
        for (int i = 0; i < lore.size(); i++) {
          if (((String)lore.get(i)).contains(value))
          {
            String vals = ((String)lore.get(i))
              .split(": +")[1];
            vals = ChatColor.stripColor(vals);
            returnVal = Integer.parseInt(vals.trim());
          }
        }
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  @EventHandler
  public void onWeaponStats(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      double dmg = e.getDamage();
      Player p = (Player)e.getDamager();
      Damageable dp = (Damageable)e.getDamager();
      LivingEntity li = (LivingEntity)e.getEntity();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((p.getItemInHand() != null) && 
        (p.getItemInHand().getType() != Material.AIR) && 
        (p.getItemInHand().getItemMeta().hasLore()))
      {
        List<?> lore = p.getItemInHand().getItemMeta().getLore();
        for (int i = 0; i < lore.size(); i++)
        {
          if (((String)lore.get(i)).contains("ICE DMG"))
          {
            li.getWorld().playEffect(li.getEyeLocation(), 
              Effect.POTION_BREAK, 8194);
            li.addPotionEffect(new PotionEffect(
              PotionEffectType.SLOW, 20, 0));
            double eldmg = getElemFromLore(p.getItemInHand(), 
              "ICE DMG");
            dmg += eldmg;
          }
          if (((String)lore.get(i)).contains("POISON DMG"))
          {
            li.getWorld().playEffect(li.getEyeLocation(), 
              Effect.POTION_BREAK, 8196);
            li.addPotionEffect(new PotionEffect(
              PotionEffectType.POISON, 20, 1));
            double eldmg = getElemFromLore(p.getItemInHand(), 
              "POISON DMG");
            dmg += eldmg;
          }
          if (((String)lore.get(i)).contains("FIRE DMG"))
          {
            li.setFireTicks(20);
            double eldmg = getElemFromLore(p.getItemInHand(), 
              "FIRE DMG");
            dmg += eldmg;
          }
          if (((String)lore.get(i)).contains("PURE DMG"))
          {
            double eldmg = getElemFromLore(p.getItemInHand(), 
              "PURE DMG");
            dmg += eldmg;
          }
          if (((String)lore.get(i)).contains("CRITICAL HIT"))
          {
            int crit = getLifestealFromLore(p.getItemInHand(), 
              "CRITICAL HIT");
            Random random = new Random();
            int drop = random.nextInt(101) + 1;
            if (drop <= crit) {
              dmg *= 2.0D;
            }
          }
          if ((((String)lore.get(i)).contains("STR")) && (
            (p.getItemInHand().getType() == Material.WOOD_AXE) || 
            (p.getItemInHand().getType() == Material.STONE_AXE) || 
            (p.getItemInHand().getType() == Material.IRON_AXE) || 
            (p.getItemInHand().getType() == Material.DIAMOND_AXE) || 
            (p.getItemInHand().getType() == Material.GOLD_AXE)))
          {
            int str = getElemFromLore(p.getItemInHand(), "STR");
            double divide = str / 1000.0D;
            double clean = divide * dmg;
            dmg += clean;
          }
          if ((((String)lore.get(i)).contains("VIT")) && (
            (p.getItemInHand().getType() == Material.WOOD_SWORD) || 
            (p.getItemInHand().getType() == Material.STONE_SWORD) || 
            (p.getItemInHand().getType() == Material.IRON_SWORD) || 
            (p.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
            (p.getItemInHand().getType() == Material.GOLD_SWORD)))
          {
            int vitw = getElemFromLore(p.getItemInHand(), "VIT");
            double divide = vitw / 1000.0D;
            double clean = divide * dmg;
            dmg += clean;
          }
          if ((((String)lore.get(i)).contains("vs. MONSTERS")) && 
            ((e.getEntity() instanceof Entity)))
          {
            int vsm = getLifestealFromLore(p.getItemInHand(), 
              "vs. MONSTERS");
            double divide = vsm / 100.0D;
            double clean = divide * dmg;
            dmg += clean;
          }
          if ((((String)lore.get(i)).contains("vs. PLAYERS")) && 
            ((e.getEntity() instanceof Player)))
          {
            int vsm = getLifestealFromLore(p.getItemInHand(), 
              "vs. PLAYERS");
            double divide = vsm / 100.0D;
            double clean = divide * dmg;
            dmg += clean;
          }
          if (((String)lore.get(i)).contains("ARMOR PENETRATION"))
          {
            int pen = getLifestealFromLore(p.getItemInHand(), 
              "ARMOR PENETRATION");
            double divide = pen / 100.0D;
            double clean = divide * dmg;
            dmg += clean;
          }
          if (((String)lore.get(i)).contains("ACCURACY"))
          {
            int acc = getLifestealFromLore(p.getItemInHand(), 
              "ACCURACY");
            double divide = acc / 100.0D;
            double clean = divide * dmg;
            dmg += clean;
          }
          if (((String)lore.get(i)).contains("BLIND"))
          {
            int blind = getLifestealFromLore(p.getItemInHand(), 
              "BLIND");
            Random random = new Random();
            int drop = random.nextInt(101) + 1;
            if (drop <= blind) {
              li.addPotionEffect(new PotionEffect(
                PotionEffectType.BLINDNESS, 40, 1));
            }
          }
          if (((String)lore.get(i)).contains("LIFE STEAL"))
          {
            li.getWorld().playEffect(li.getEyeLocation(), 
              Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
            double base = getLifestealFromLore(p.getItemInHand(), 
              "LIFE STEAL");
            double pcnt = base / 100.0D;
            int life = 0;
            if ((int)(pcnt * dmg) > 0) {
              life = (int)(pcnt * dmg);
            } else {
              life = 1;
            }
            p.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + 
              "            +" + ChatColor.GREEN + life + 
              ChatColor.GREEN + ChatColor.BOLD.toString() + " HP " + 
              ChatColor.GRAY + "[" + (int)dp.getHealth() + 
              "/" + (int)dp.getMaxHealth() + "HP]");
            if (dp.getHealth() < dp.getMaxHealth() - life) {
              p.setHealth(dp.getHealth() + life);
            } else if (dp.getHealth() >= dp.getMaxHealth() - life) {
              p.setHealth(dp.getMaxHealth());
            }
          }
        }
      }
      e.setDamage(dmg);
    }
  }
  @EventHandler(priority=EventPriority.LOWEST)
  public void onPlayerDeath(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 1.0F, 
      1.0F);
    e.setDroppedExp(0);
    e.setDeathMessage(null);
    for (int i = 0; i < Main.tagged.size(); i++) {
      Main.tagged.remove(p);
    }
    for (int i = 0; i < this.combat.size(); i++) {
      this.combat.remove(p);
    }
  }
  @EventHandler(priority=EventPriority.HIGH)
  public void onDeathMessageElem(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      Damageable dp = p;
      if ((e.getDamage() >= dp.getHealth()) && 
        (p.getNoDamageTicks() <= p.getMaximumNoDamageTicks() / 2) && 
        (dp.getHealth() > 0.0D) && (
        (e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)) || 
        
        (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) || 
        
        (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)))) {
        Bukkit.getServer().broadcastMessage(
          p.getDisplayName() + ChatColor.WHITE.toString() + 
          " burned to death");
      }
    }
  }
  @EventHandler
  public void onWeaponSwitch(PlayerItemHeldEvent e)
  {
    Player p = e.getPlayer();
    ItemStack newItem = p.getInventory().getItem(e.getNewSlot());
    if ((newItem != null) && (
      (newItem.getType().name().contains("SWORD")) || 
      (newItem.getType().name().contains("AXE")))) {
      p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.25F);
    }
  }
  @EventHandler(priority=EventPriority.HIGH)
  public void onDeathMessage(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof LivingEntity)))
    {
      Player p = (Player)e.getEntity();
      Damageable dp = p;
      if ((e.getDamage() >= dp.getHealth()) && 
        (p.getNoDamageTicks() <= p.getMaximumNoDamageTicks() / 2) && 
        (dp.getHealth() > 0.0D)) {
        if ((e.getDamager() instanceof Player))
        {
          Player d = (Player)e.getDamager();
          if ((d.getItemInHand() != null) && 
            (d.getItemInHand().getType() != Material.AIR)) {
            Bukkit.getServer().broadcastMessage(
              ChatColor.RESET + 
              p.getDisplayName() + 
              ChatColor.GRAY + 
              " was killed by " + 
              ChatColor.RESET + 
              d.getDisplayName() + 
              ChatColor.GRAY + 
              " with a(n) " + 
              d.getItemInHand().getItemMeta()
              .getDisplayName());
          } else {
            Bukkit.getServer().broadcastMessage(
              ChatColor.RESET + p.getDisplayName() + 
              ChatColor.GRAY + " was killed by " + 
              ChatColor.RESET + d.getDisplayName() + 
              ChatColor.GRAY + " with a(n) Air");
          }
        }
        else if ((e.getDamager() instanceof LivingEntity))
        {
          LivingEntity l = (LivingEntity)e.getDamager();
          String name = "";
          if (Healthbar.named.contains(l)) {
            name = (String)Healthbar.name.get(l);
          } else {
            name = l.getCustomName();
          }
          if (l.getCustomName() != null) {
            Bukkit.getServer().broadcastMessage(
              ChatColor.WHITE + p.getDisplayName() + 
              ChatColor.GRAY + 
              " was killed by a(n) " + name);
          }
        }
        else if ((e.getDamager() instanceof Arrow))
        {
          Arrow a = (Arrow)e.getDamager();
          LivingEntity l = a.getShooter();
          String name = "";
          if (Healthbar.named.contains(l)) {
            name = (String)Healthbar.name.get(l);
          } else {
            name = l.getCustomName();
          }
          if (l.getCustomName() != null) {
            Bukkit.getServer().broadcastMessage(
              ChatColor.WHITE + p.getDisplayName() + 
              ChatColor.GRAY + 
              " was killed by a(n) " + name);
          }
        }
      }
    }
  }
  @EventHandler
  public void onDamageSound(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      Player d = (Player)e.getDamager();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      d.playSound(d.getLocation(), Sound.HURT_FLESH, 1.0F, 
        1.0F);
    }
  }
  
  @EventHandler
  public void onArmorDura(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      final PlayerInventory i = p.getInventory();
      if (i.getHelmet() != null) {
        i.getHelmet().setDurability((short)0);
      }
      if (i.getChestplate() != null) {
        i.getChestplate().setDurability((short)0);
      }
      if (i.getLeggings() != null) {
        i.getLeggings().setDurability((short)0);
      }
      if (i.getBoots() != null) {
        i.getBoots().setDurability((short)0);
      }
      new BukkitRunnable()
      {
        public void run()
        {
          if (i.getHelmet() != null) {
            i.getHelmet().setDurability((short)0);
          }
          if (i.getChestplate() != null) {
            i.getChestplate().setDurability((short)0);
          }
          if (i.getLeggings() != null) {
            i.getLeggings().setDurability((short)0);
          }
          if (i.getBoots() != null) {
            i.getBoots().setDurability((short)0);
          }
        }
      }.runTaskLater(plugin, 1L);
    }
  }
  
  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      Player p = (Player)e.getDamager();
      if ((p.getItemInHand().getType() == Material.WOOD_SWORD) || 
      
        (p.getItemInHand().getType() == Material.WOOD_AXE) || 
        
        (p.getItemInHand().getType() == Material.STONE_SWORD) || 
        
        (p.getItemInHand().getType() == Material.STONE_AXE) || 
        
        (p.getItemInHand().getType() == Material.IRON_SWORD) || 
        
        (p.getItemInHand().getType() == Material.IRON_AXE) || 
        
        (p.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
        
        (p.getItemInHand().getType() == Material.DIAMOND_AXE) || 
        
        (p.getItemInHand().getType() == Material.GOLD_SWORD) || 
        
        (p.getItemInHand().getType() == Material.GOLD_AXE) || 
        
        (p.getItemInHand().getType() == Material.GOLD_PICKAXE))
      {
        p.getInventory().getItemInHand().setDurability((short)0);
        p.updateInventory();
      }
    }
  }
  
  public static int getValueFromLore(ItemStack item, String value)
  {
    int returnVal = 0;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if ((lore != null) && 
        (((String)lore.get(1)).contains(value)))
      {
        String vals = ((String)lore.get(1))
          .split(": +")[1];
        vals = ChatColor.stripColor(vals);
        returnVal = Integer.parseInt(vals.trim());
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  public static int getVitFromLore(ItemStack item, String value)
  {
    int returnVal = 0;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if ((lore != null) && 
        (((String)lore.get(2)).contains(value)))
      {
        String vals = ((String)lore.get(2))
          .split(": +")[1];
        vals = ChatColor.stripColor(vals);
        returnVal = Integer.parseInt(vals.trim());
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  public void hpCheck(Player p)
  {
    PlayerInventory i = p.getInventory();
    double a = 50.0D;
    double vital = 0.0D;
    if ((i.getHelmet() != null) && 
      (i.getHelmet().getItemMeta().hasLore()))
    {
      double health = getValueFromLore(i.getHelmet(), "HP");
      int vit = getVitFromLore(i.getHelmet(), "VIT");
      a += health;
      vital += vit;
    }
    if ((i.getChestplate() != null) && 
      (i.getChestplate().getItemMeta().hasLore()))
    {
      double health = getValueFromLore(i.getChestplate(), 
        "HP");
      int vit = getVitFromLore(i.getChestplate(), "VIT");
      a += health;
      vital += vit;
    }
    if ((i.getLeggings() != null) && 
      (i.getLeggings().getItemMeta().hasLore()))
    {
      double health = getValueFromLore(i.getLeggings(), 
        "HP");
      int vit = getVitFromLore(i.getLeggings(), "VIT");
      a += health;
      vital += vit;
    }
    if ((i.getBoots() != null) && 
      (i.getBoots().getItemMeta().hasLore()))
    {
      double health = getValueFromLore(i.getBoots(), "HP");
      int vit = getVitFromLore(i.getBoots(), "VIT");
      a += health;
      vital += vit;
    }
    if (vital > 0.0D)
    {
      double divide = vital / 2000.0D;
      double pre = a * divide;
      int cleaned = (int)(a + pre);
      Damageable dp = p;
      if (dp.getHealth() > cleaned) {
        p.setHealth(cleaned);
      }
      p.setMaxHealth(cleaned);
    }
    else
    {
      p.setMaxHealth(a);
    }
    p.setHealthScale(20.0D);
    p.setHealthScaled(true);
  }
  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent e)
  {
    final Player p = (Player)e.getWhoClicked();
    new BukkitRunnable()
    {
      public void run()
      {
        Listeners.this.hpCheck(p);
      }
    }.runTaskLater(plugin, 1L);
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onVitSword(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      Player p = (Player)e.getDamager();
      PlayerInventory i = p.getInventory();
      if ((p.getItemInHand() != null) && 
        (p.getItemInHand().getType().name().contains("SWORD")) && 
        (p.getItemInHand().getItemMeta().hasLore()))
      {
        double dmg = e.getDamage();
        double vital = 0.0D;
        if ((i.getHelmet() != null) && 
          (i.getHelmet().getItemMeta().hasLore()))
        {
          int vit = getVitFromLore(i.getHelmet(), 
            "VIT");
          vital += vit;
        }
        if ((i.getChestplate() != null) && 
          (i.getChestplate().getItemMeta().hasLore()))
        {
          int vit = getVitFromLore(i.getChestplate(), 
            "VIT");
          vital += vit;
        }
        if ((i.getLeggings() != null) && 
          (i.getLeggings().getItemMeta().hasLore()))
        {
          int vit = getVitFromLore(i.getLeggings(), 
            "VIT");
          vital += vit;
        }
        if ((i.getBoots() != null) && 
          (i.getBoots().getItemMeta().hasLore()))
        {
          int vit = getVitFromLore(i.getBoots(), "VIT");
          vital += vit;
        }
        if (vital > 0.0D)
        {
          double divide = vital / 7500.0D;
          double pre = dmg * divide;
          int cleaned = (int)(dmg + pre);
          e.setDamage(cleaned);
        }
        else
        {
          e.setDamage(dmg);
        }
      }
    }
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onDpsDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      Player p = (Player)e.getDamager();
      PlayerInventory i = p.getInventory();
      if ((p.getItemInHand() != null) && 
        (p.getItemInHand().getType() != Material.AIR) && 
        (p.getItemInHand().getItemMeta().hasLore()))
      {
        double dmg = e.getDamage();
        double dps = 0.0D;
        if ((i.getHelmet() != null) && 
          (i.getHelmet().getItemMeta().hasLore()))
        {
          int adddps = getMinValueFromLore(i.getHelmet(), "DPS");
          dps += adddps;
        }
        if ((i.getChestplate() != null) && 
          (i.getChestplate().getItemMeta().hasLore()))
        {
          int adddps = getMinValueFromLore(i.getChestplate(), "DPS");
          dps += adddps;
        }
        if ((i.getLeggings() != null) && 
          (i.getLeggings().getItemMeta().hasLore()))
        {
          int adddps = getMinValueFromLore(i.getLeggings(), "DPS");
          dps += adddps;
        }
        if ((i.getBoots() != null) && 
          (i.getBoots().getItemMeta().hasLore()))
        {
          int adddps = getMinValueFromLore(i.getBoots(), "DPS");
          dps += adddps;
        }
        if (dps > 0.0D)
        {
          double divide = dps / 100.0D;
          double pre = dmg * divide;
          int cleaned = (int)(dmg + pre);
          e.setDamage(cleaned);
        }
        else
        {
          e.setDamage(dmg);
        }
      }
    }
  }
  
  public static int getArmor(Player p) {
      PlayerInventory i = p.getInventory();
      double dps = 0.0D;
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int adddps = getMinValueFromLore(i.getHelmet(), "ARMOR");
        dps += adddps;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int adddps = getMinValueFromLore(i.getChestplate(), "ARMOR");
        dps += adddps;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int adddps = getMinValueFromLore(i.getLeggings(), "ARMOR");
        dps += adddps;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int adddps = getMinValueFromLore(i.getBoots(), "ARMOR");
        dps += adddps;
      }
      if (dps > 0.0D)
      {
        return (int) dps;
     
     }
	return 0;
  }
  
  public static int getDMGWithArmor(Player p, double dmg) {
	  int dps = getArmor(p);
	  if(dps > 0.0D) {
		  double divide = dps / 100.0D;
	        double pre = dmg * divide;
	        int cleaned = (int)(dmg - pre) + 1;
	        return cleaned;
	  }
	  return dps;
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onArmorDamage(EntityDamageByEntityEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      Player p = (Player)e.getEntity();
      PlayerInventory i = p.getInventory();
      double dmg = e.getDamage();
      double dps = 0.0D;
      if ((i.getHelmet() != null) && 
        (i.getHelmet().getItemMeta().hasLore()))
      {
        int adddps = getMinValueFromLore(i.getHelmet(), "ARMOR");
        dps += adddps;
      }
      if ((i.getChestplate() != null) && 
        (i.getChestplate().getItemMeta().hasLore()))
      {
        int adddps = getMinValueFromLore(i.getChestplate(), "ARMOR");
        dps += adddps;
      }
      if ((i.getLeggings() != null) && 
        (i.getLeggings().getItemMeta().hasLore()))
      {
        int adddps = getMinValueFromLore(i.getLeggings(), "ARMOR");
        dps += adddps;
      }
      if ((i.getBoots() != null) && 
        (i.getBoots().getItemMeta().hasLore()))
      {
        int adddps = getMinValueFromLore(i.getBoots(), "ARMOR");
        dps += adddps;
      }
      if (dps > 0.0D)
      {
        double divide = dps / 100.0D;
        double pre = dmg * divide;
        int cleaned = (int)(dmg - pre) + 1;
        e.setDamage(cleaned);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onQuitLog(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (Main.tagged.contains(p.getName()))
    {
      Bukkit.getServer().broadcastMessage(
        ChatColor.WHITE + p.getName() + ChatColor.GRAY + 
        " logged out while in combat (Take a screenshot of this to get them temp banned)");
    }
  }
  @EventHandler(priority=EventPriority.LOWEST)
  public void onChaoLog(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (Respawn.chaotic.contains(p.getName()))
    {
      p.setHealth(0.0D);
      Bukkit.getServer().broadcastMessage(
        ChatColor.WHITE + p.getName() + ChatColor.GRAY + 
        " logged out while chaotic, therefore they have been killed.");
    }
  }
  @EventHandler
  public void onTag(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      final Player p = (Player)e.getEntity();
      Main.tagged.add(p.getName());
      new BukkitRunnable()
      {
        public void run()
        {
          Main.tagged.remove(p.getName());
        }
      }.runTaskLater(plugin, 200L);
    }
  }
  @EventHandler
  public void onMoveScaled(PlayerMoveEvent e) {
	  Player p = e.getPlayer();
	  p.setHealthScaled(true);
	  
		  
	  }
  @EventHandler
  public void onJoin1(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    p.setHealthScale(20.0D);
    p.setHealthScaled(true);
      p.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + 
        "                                Patch 1.2 Beta");
      p.sendMessage(ChatColor.GRAY + "" +ChatColor.ITALIC + 
        "                          		http://buy.drmmo.xyz/");
      p.sendMessage(ChatColor.GRAY + 
        "Want Gems, Orbs, Enchants? Maybe just a cool rank? Link Above!");
      e.setJoinMessage(null);
  }
  
  @EventHandler
  public void onHitTag(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && 
      ((e.getEntity() instanceof LivingEntity)))
    {
      if (e.getDamage() <= 0.0D) {
        return;
      }
      final Player p = (Player)e.getDamager();
      Main.tagged.add(p.getName());
      new BukkitRunnable()
      {
        public void run()
        {
          Main.tagged.remove(p.getName());
        }
      }.runTaskLater(plugin, 200L);
    }
  }
  
  @EventHandler(priority=EventPriority.LOWEST)
  public void onKickLog(PlayerKickEvent e)
  {
    Player p = e.getPlayer();
    if (e.getReason().equals("Illegal characters in chat")) {
      e.setCancelled(true);
    } else {
      for (int i = 0; i < Main.tagged.size(); i++) {
        Main.tagged.remove(p.getName());
      }
    }
  }
  
  @EventHandler
  public void onHealthRegen(EntityRegainHealthEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onBypassArmor(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof LivingEntity))
    {
      LivingEntity li = (LivingEntity)e.getEntity();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      double dmg = e.getDamage();
      e.setDamage(0.0D);
      li.damage(dmg);
    }
  }
  
  public void Kit(Player p)
  {
    PlayerInventory i = p.getInventory();
    Random random = new Random();
    int min = random.nextInt(2) + 2;
    int max = random.nextInt(2) + 4;
    int wep = random.nextInt(2) + 1;
    if (wep == 1)
    {
      ItemStack S = new ItemStack(Material.WOOD_SWORD);
      ItemMeta smeta = S.getItemMeta();
      smeta.setDisplayName(ChatColor.WHITE.toString() + 
        "Training Sword");
      List<String> slore = new ArrayList<String>();
      slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + 
        max);
      slore.add(ChatColor.GRAY.toString() + "Untradeable");
      smeta.setLore(slore);
      S.setItemMeta(smeta);
      i.addItem(new ItemStack[] { S });
    }
    if (wep == 2)
    {
      ItemStack S = new ItemStack(Material.WOOD_AXE);
      ItemMeta smeta = S.getItemMeta();
      smeta.setDisplayName(ChatColor.WHITE.toString() + 
        "Training Hatchet");
      List<String> slore = new ArrayList<String>();
      slore.add(ChatColor.RED.toString() + "DMG: " + min + " - " + 
        max);
      slore.add(ChatColor.GRAY.toString() + "Untradeable");
      smeta.setLore(slore);
      S.setItemMeta(smeta);
      i.addItem(new ItemStack[] { S });
    }
    p.setMaxHealth(50.0D);
    p.setHealth(50.0D);
    p.setHealthScale(20.0D);
    p.setHealthScaled(true);
  }

}