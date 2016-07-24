package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Mobs
  implements Listener
{
  public Main plugin;
  ArrayList<Skeleton> tagged = new ArrayList();
  ArrayList<Skeleton> cantshoot = new ArrayList();
  
  public Mobs(Main plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onTag(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Skeleton)) && 
      ((e.getDamager() instanceof Player)))
    {
      final Skeleton s = (Skeleton)e.getEntity();
      this.tagged.add(s);
      new BukkitRunnable()
      {
        public void run()
        {
          Mobs.this.tagged.remove(s);
          if (!Mobs.this.tagged.contains(s)) {
            s.remove();
          }
        }
      }.runTaskLater(this.plugin, 1200L);
    }
  }
  
  @EventHandler
  public void onArcherTag(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Skeleton)) && 
      ((e.getDamager() instanceof Player)))
    {
      final Skeleton s = (Skeleton)e.getEntity();
      this.cantshoot.add(s);
      new BukkitRunnable()
      {
        public void run()
        {
          Mobs.this.cantshoot.remove(s);
        }
      }.runTaskLater(this.plugin, 20L);
    }
  }
  
  @EventHandler
  public void onLaunch(ProjectileLaunchEvent e)
  {
    if ((e.getEntity() instanceof Arrow))
    {
      Arrow a = (Arrow)e.getEntity();
      if ((a.getShooter() instanceof Skeleton))
      {
        Skeleton s = (Skeleton)a.getShooter();
        if (this.cantshoot.contains(s)) {
          e.setCancelled(true);
        }
      }
    }
  }
  
  @EventHandler
  public void onSkeletonSpawn(CreatureSpawnEvent e)
  {
    if ((e.getEntity() instanceof Skeleton))
    {
      final Skeleton s = (Skeleton)e.getEntity();
      if ((s.getCustomName() != null) && (s.getCustomName().equals("T5")))
      {
        Random random = new Random();
        double health = random.nextInt(4001) + 8000;
        int held = random.nextInt(6) + 1;
        s.getEquipment().setHelmet(null);
        s.getEquipment().setChestplate(null);
        s.getEquipment().setLeggings(null);
        s.getEquipment().setBoots(null);
        if ((held == 1) || (held == 2)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.GOLD_SWORD));
        }
        if ((held == 3) || (held == 4)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.GOLD_AXE));
        }
        if (held == 5) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.GOLD_SPADE));
        }
        if (held == 6) {
          s.getEquipment().setItemInHand(new ItemStack(Material.BOW));
        }
        s.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET));
        s.getEquipment().setChestplate(
          new ItemStack(Material.GOLD_CHESTPLATE));
        s.getEquipment().setLeggings(
          new ItemStack(Material.GOLD_LEGGINGS));
        s.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS));
        s.getEquipment().setItemInHandDropChance(0.0F);
        s.getEquipment().setHelmetDropChance(0.0F);
        s.getEquipment().setChestplateDropChance(0.0F);
        s.getEquipment().setLeggingsDropChance(0.0F);
        s.getEquipment().setBootsDropChance(0.0F);
        s.setCanPickupItems(false);
        s.setCustomName(ChatColor.YELLOW + "Infernal Skeleton");
        s.setMetadata("Name", new MyMetadata(this.plugin, "Infernal Skeleton"));
        s.setCustomNameVisible(true);
        s.setMaxHealth(health);
        s.setHealth(health);
        s.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 
          Integer.MAX_VALUE, 0));
        s.addPotionEffect(new PotionEffect(
          PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Mobs.this.tagged.contains(s)) {
              s.remove();
            }
          }
        }.runTaskLater(this.plugin, 1200L);
      }
      else if ((s.getCustomName() != null) && 
        (s.getCustomName().equals("T4")))
      {
        Random random = new Random();
        double health = random.nextInt(2501) + 2500;
        int held = random.nextInt(6) + 1;
        s.getEquipment().setHelmet(null);
        s.getEquipment().setChestplate(null);
        s.getEquipment().setLeggings(null);
        s.getEquipment().setBoots(null);
        if ((held == 1) || (held == 2)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.DIAMOND_SWORD));
        }
        if ((held == 3) || (held == 4)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.DIAMOND_AXE));
        }
        if (held == 5) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.DIAMOND_SPADE));
        }
        if (held == 6) {
          s.getEquipment().setItemInHand(new ItemStack(Material.BOW));
        }
        s.getEquipment().setHelmet(
          new ItemStack(Material.DIAMOND_HELMET));
        s.getEquipment().setChestplate(
          new ItemStack(Material.DIAMOND_CHESTPLATE));
        s.getEquipment().setLeggings(
          new ItemStack(Material.DIAMOND_LEGGINGS));
        s.getEquipment()
          .setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        s.getEquipment().setItemInHandDropChance(0.0F);
        s.getEquipment().setHelmetDropChance(0.0F);
        s.getEquipment().setChestplateDropChance(0.0F);
        s.getEquipment().setLeggingsDropChance(0.0F);
        s.getEquipment().setBootsDropChance(0.0F);
        s.setCanPickupItems(false);
        s.setCustomName(ChatColor.LIGHT_PURPLE + "Skeleton Guardian");
        s.setMetadata("Name", new MyMetadata(this.plugin, "Skeleton Guardian"));
        s.setCustomNameVisible(true);
        s.setMaxHealth(health);
        s.setHealth(health);
        s.addPotionEffect(new PotionEffect(
          PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Mobs.this.tagged.contains(s)) {
              s.remove();
            }
          }
        }.runTaskLater(this.plugin, 1200L);
      }
      else if ((s.getCustomName() != null) && 
        (s.getCustomName().equals("T3")))
      {
        Random random = new Random();
        double health = random.nextInt(1101) + 400;
        int held = random.nextInt(6) + 1;
        s.getEquipment().setHelmet(null);
        s.getEquipment().setChestplate(null);
        s.getEquipment().setLeggings(null);
        s.getEquipment().setBoots(null);
        if ((held == 1) || (held == 2)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.IRON_SWORD));
        }
        if ((held == 3) || (held == 4)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.IRON_AXE));
        }
        if (held == 5) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.IRON_SPADE));
        }
        if (held == 6) {
          s.getEquipment().setItemInHand(new ItemStack(Material.BOW));
        }
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, 
          (short)3);
        SkullMeta sm = (SkullMeta)skull.getItemMeta();
        sm.setOwner("Lord_Kashi");
        skull.setItemMeta(sm);
        s.getEquipment().setHelmet(skull);
        s.getEquipment().setChestplate(
          new ItemStack(Material.IRON_CHESTPLATE));
        s.getEquipment().setLeggings(
          new ItemStack(Material.IRON_LEGGINGS));
        s.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
        s.getEquipment().setItemInHandDropChance(0.0F);
        s.getEquipment().setHelmetDropChance(0.0F);
        s.getEquipment().setChestplateDropChance(0.0F);
        s.getEquipment().setLeggingsDropChance(0.0F);
        s.getEquipment().setBootsDropChance(0.0F);
        s.setCanPickupItems(false);
        s.setCustomName(ChatColor.AQUA + "Mountain Bandit");
        s.setMetadata("Name", new MyMetadata(this.plugin, "Mountain Bandit"));
        s.setCustomNameVisible(true);
        s.setMaxHealth(health);
        s.setHealth(health);
        s.addPotionEffect(new PotionEffect(
          PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Mobs.this.tagged.contains(s)) {
              s.remove();
            }
          }
        }.runTaskLater(this.plugin, 1200L);
      }
      else if ((s.getCustomName() != null) && 
        (s.getCustomName().equals("T2")))
      {
        Random random = new Random();
        double health = random.nextInt(51) + 50;
        int held = random.nextInt(3) + 1;
        int chest = random.nextInt(2) + 1;
        int pant = random.nextInt(2) + 1;
        int boots = random.nextInt(2) + 1;
        s.getEquipment().setHelmet(null);
        s.getEquipment().setChestplate(null);
        s.getEquipment().setLeggings(null);
        s.getEquipment().setBoots(null);
        if ((held == 1) || (held == 2)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.STONE_SWORD));
        }
        if ((held == 3) || (held == 4)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.STONE_AXE));
        }
        if (held == 5) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.STONE_SPADE));
        }
        if (held == 6) {
          s.getEquipment().setItemInHand(new ItemStack(Material.BOW));
        }
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, 
          (short)3);
        SkullMeta sm = (SkullMeta)skull.getItemMeta();
        sm.setOwner("Lord_Kashi");
        skull.setItemMeta(sm);
        s.getEquipment().setHelmet(skull);
        if (chest == 1) {
          s.getEquipment().setChestplate(
            new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        }
        if (pant == 1) {
          s.getEquipment().setLeggings(
            new ItemStack(Material.CHAINMAIL_LEGGINGS));
        }
        if (boots == 1) {
          s.getEquipment().setBoots(
            new ItemStack(Material.CHAINMAIL_BOOTS));
        }
        if ((chest == 2) && (pant == 2) && (boots == 2)) {
          s.getEquipment().setBoots(
            new ItemStack(Material.CHAINMAIL_BOOTS));
        }
        s.getEquipment().setItemInHandDropChance(0.0F);
        s.getEquipment().setHelmetDropChance(0.0F);
        s.getEquipment().setChestplateDropChance(0.0F);
        s.getEquipment().setLeggingsDropChance(0.0F);
        s.getEquipment().setBootsDropChance(0.0F);
        s.setCanPickupItems(false);
        s.setCustomName(ChatColor.GREEN + "Old Bandit");
        s.setMetadata("Name", new MyMetadata(this.plugin, "Old Bandit"));
        s.setCustomNameVisible(true);
        s.setMaxHealth(health);
        s.setHealth(health);
        s.addPotionEffect(new PotionEffect(
          PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Mobs.this.tagged.contains(s)) {
              s.remove();
            }
          }
        }.runTaskLater(this.plugin, 1200L);
      }
      
      else if ((s.getCustomName() != null) && 
        (s.getCustomName().equals("T1")))
      {
        Random random = new Random();
        double health = random.nextInt(36) + 5;
        int held = random.nextInt(6) + 1;
        int chest = random.nextInt(2) + 1;
        int pant = random.nextInt(2) + 1;
        int boots = random.nextInt(2) + 1;
        s.getEquipment().setHelmet(null);
        s.getEquipment().setChestplate(null);
        s.getEquipment().setLeggings(null);
        s.getEquipment().setBoots(null);
        if ((held == 1) || (held == 2)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.WOOD_SWORD));
        }
        if ((held == 3) || (held == 4)) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.WOOD_AXE));
        }
        if (held == 5) {
          s.getEquipment().setItemInHand(
            new ItemStack(Material.WOOD_SPADE));
        }
        if (held == 6) {
          s.getEquipment().setItemInHand(new ItemStack(Material.BOW));
        }
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, 
          (short)3);
        SkullMeta sm = (SkullMeta)skull.getItemMeta();
        sm.setOwner("Lord_Kashi");
        skull.setItemMeta(sm);
        s.getEquipment().setHelmet(skull);
        if (chest == 1) {
          s.getEquipment().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
        }
        if (pant == 1) {
          s.getEquipment().setLeggings(
            new ItemStack(Material.LEATHER_LEGGINGS));
        }
        if (boots == 1) {
          s.getEquipment().setBoots(
            new ItemStack(Material.LEATHER_BOOTS));
        }
        if ((chest == 2) && (pant == 2) && (boots == 2)) {
          s.getEquipment().setBoots(
            new ItemStack(Material.LEATHER_BOOTS));
        }
        s.getEquipment().setItemInHandDropChance(0.0F);
        s.getEquipment().setHelmetDropChance(0.0F);
        s.getEquipment().setChestplateDropChance(0.0F);
        s.getEquipment().setLeggingsDropChance(0.0F);
        s.getEquipment().setBootsDropChance(0.0F);
        s.setCanPickupItems(false);
        s.setCustomName(ChatColor.WHITE + "Starving Bandit");
        s.setMetadata("Name", new MyMetadata(this.plugin, "Starving Bandit"));
        s.setCustomNameVisible(true);
        s.setMaxHealth(health);
        s.setHealth(health);
        s.addPotionEffect(new PotionEffect(
          PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Mobs.this.tagged.contains(s)) {
              s.remove();
            }
          }
        }.runTaskLater(this.plugin, 1200L);
      }
    }
  }
  
  @EventHandler
  public void onMobHit(EntityDamageByEntityEvent e)
  {
    if (e.getDamage() <= 0.0D) {
      return;
    }
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Skeleton)))
    {
      Skeleton s = (Skeleton)e.getDamager();
      Random random = new Random();
      if (s.getCustomName() != null) {
        if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Infernal Skeleton"))
        {
          double dmg = random.nextInt(111) + 140;
          e.setDamage(dmg);
        }
        else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Skeleton Guardian"))
        {
          double dmg = random.nextInt(66) + 75;
          e.setDamage(dmg);
        }
        else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Mountain Bandit"))
        {
          double dmg = random.nextInt(16) + 25;
          e.setDamage(dmg);
        }
        else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Old Bandit"))
        {
          double dmg = random.nextInt(11) + 5;
          e.setDamage(dmg);
        }
        else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Starving Bandit"))
        {
          double dmg = random.nextInt(5) + 1;
          e.setDamage(dmg);
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Arrow)))
    {
      Arrow a = (Arrow)e.getDamager();
      if ((a.getShooter() instanceof Skeleton))
      {
        Skeleton s = (Skeleton)a.getShooter();
        Random random = new Random();
        if (s.getCustomName() != null) {
          if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Infernal Skeleton")) {
            double dmg = random.nextInt(101) + 400;
            e.setDamage(dmg);
          }
          
          
          else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Skeleton Guardian")) {
              double dmg = random.nextInt(111) + 140;
              e.setDamage(dmg);
          }
          else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Mountain Bandit"))
          {
            double dmg = random.nextInt(16) + 25;
            e.setDamage(dmg);
          }
          else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Old Bandit"))
          {
            double dmg = random.nextInt(11) + 5;
            e.setDamage(dmg);
          }
          else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Starving Bandit"))
          {
            double dmg = random.nextInt(5) + 1;
            e.setDamage(dmg);
          }
        }
      }
    }
  }
  
  @EventHandler
  public void onWither(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Skeleton)) && 
      ((e.getEntity() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      for (PotionEffect effect : p.getActivePotionEffects()) {
        if (effect.getType().equals(PotionEffectType.WITHER)) {
          p.removePotionEffect(effect.getType());
        }
      }
      new BukkitRunnable()
      {
        public void run()
        {
          for (PotionEffect effect : p.getActivePotionEffects()) {
            if (effect.getType().equals(PotionEffectType.WITHER)) {
              p.removePotionEffect(effect.getType());
            }
          }
        }
      }.runTaskLater(this.plugin, 1L);
    }
  }
  @EventHandler
  public void onBlayshanSpawn(CreatureSpawnEvent e)
  {
    if ((e.getEntity() instanceof Skeleton))
    {
      final Skeleton s = (Skeleton)e.getEntity();
      if ((s.getCustomName() != null) && (s.getCustomName().equals("Blayshan")))
      {
        Random random = new Random();
        double health = random.nextInt(5001) + 8000;
        int held = random.nextInt(6) + 1;
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack pants = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        
        chest.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
        boots.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
        pants.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
        helmet.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
        s.getEquipment().setHelmet(null);
        s.getEquipment().setChestplate(null);
        s.getEquipment().setLeggings(null);
        s.getEquipment().setBoots(null);
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        
        axe.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
        
        if ((held == 1) || (held == 2)) {
          s.getEquipment().setItemInHand(
            new ItemStack(axe));
        }
        if ((held == 3) || (held == 4)) {
          s.getEquipment().setItemInHand(
            new ItemStack(axe));
        }
        if (held == 5) {
          s.getEquipment().setItemInHand(
            new ItemStack(axe));
        }
        if (held == 6) {
          s.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_AXE));
        }
        s.getEquipment().setHelmet(new ItemStack(helmet));
        s.getEquipment().setChestplate(
          new ItemStack(chest));
        s.getEquipment().setLeggings(
          new ItemStack(pants));
        s.getEquipment().setBoots(new ItemStack(boots));
        s.getEquipment().setItemInHandDropChance(0.0F);
        s.getEquipment().setHelmetDropChance(0.0F);
        s.getEquipment().setChestplateDropChance(0.0F);
        s.getEquipment().setLeggingsDropChance(0.0F);
        s.getEquipment().setBootsDropChance(0.0F);
        s.setCanPickupItems(false);
        s.setCustomName(ChatColor.LIGHT_PURPLE + "Blayshan the Naga");
        s.setMetadata("Name", new MyMetadata(this.plugin, "Blayshan the Naga"));
        s.setCustomNameVisible(true);
        s.setMaxHealth(health);
        s.setHealth(health);
        s.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 
          Integer.MAX_VALUE, 1));
        s.addPotionEffect(new PotionEffect(
          PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
        new BukkitRunnable()
        {
          public void run()
          {
            if (!Mobs.this.tagged.contains(s)) {
              s.remove();
            }
          }
        }.runTaskLater(this.plugin, 1200L);
      }
    }
  }
  @EventHandler
  public void onSlimeSplit(SlimeSplitEvent e)
  {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onBlockChange(EntityChangeBlockEvent e)
  {
    if (((e.getEntity() instanceof Silverfish)) || 
      ((e.getEntity() instanceof Enderman))) {
      e.setCancelled(true);
    }
  }
}