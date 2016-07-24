package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Speedfish
  implements Listener
{
  public Main plugin;
  
  public Speedfish(Main plugin)
  {
    this.plugin = plugin;
  }
  
  public static List<String> tp = new ArrayList();
  
  @EventHandler
  public void onSpeedFish(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      if ((p.getItemInHand().getType() == Material.COOKED_FISH) && 
        (p.getItemInHand().getItemMeta().hasDisplayName()) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Cooked Salmon of Lasting Agility")))
      {
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (
          (e.getClickedBlock().getType() == Material.FURNACE) || 
          (e.getClickedBlock().getType() == Material.BURNING_FURNACE))) {
          return;
        }
        if (p.hasPotionEffect(PotionEffectType.SPEED))
        {
          e.setCancelled(true);
          return;
        }
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 
          600, 1));
        p.playSound(p.getLocation(), Sound.EAT, 1.0F, 1.0F);
        if (p.getItemInHand().getAmount() > 1)
        {
          p.getItemInHand().setAmount(
            p.getItemInHand().getAmount() - 1);
          return;
        }
        e.setCancelled(true);
        p.setItemInHand(null);
        
        return;
      }
      if ((p.getItemInHand().getType() == Material.COOKED_FISH) && 
        (p.getItemInHand().getItemMeta().hasDisplayName()) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Cooked Lobster of Bursting Agility")))
      {
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (
          (e.getClickedBlock().getType() == Material.FURNACE) || 
          (e.getClickedBlock().getType() == Material.BURNING_FURNACE))) {
          return;
        }
        if (p.hasPotionEffect(PotionEffectType.SPEED))
        {
          e.setCancelled(true);
          return;
        }
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 
          300, 2));
        p.playSound(p.getLocation(), Sound.EAT, 1.0F, 1.0F);
        if (p.getItemInHand().getAmount() > 1)
        {
          p.getItemInHand().setAmount(
            p.getItemInHand().getAmount() - 1);
          return;
        }
        e.setCancelled(true);
        p.setItemInHand(null);
        
        return;
      }
      if ((p.getItemInHand().getType() == Material.COOKED_FISH) && 
        (p.getItemInHand().getItemMeta().hasDisplayName()) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Cooked Swordfish of Godlike Speed")))
      {
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (
          (e.getClickedBlock().getType() == Material.FURNACE) || 
          (e.getClickedBlock().getType() == Material.BURNING_FURNACE))) {
          return;
        }
        if (p.hasPotionEffect(PotionEffectType.SPEED))
        {
          e.setCancelled(true);
          return;
        }
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 
          600, 2));
        p.playSound(p.getLocation(), Sound.EAT, 1.0F, 1.0F);
        if (p.getItemInHand().getAmount() > 1)
        {
          p.getItemInHand().setAmount(
            p.getItemInHand().getAmount() - 1);
          return;
        }
        e.setCancelled(true);
        p.setItemInHand(null);
        
        return;
      }
      if ((p.getItemInHand().getType() == Material.RAW_FISH) && 
        (p.getItemInHand().getItemMeta().hasDisplayName()) && 
        (p.getItemInHand().getItemMeta().getDisplayName().contains("Raw")))
      {
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (
          (e.getClickedBlock().getType() == Material.FURNACE) || 
          (e.getClickedBlock().getType() == Material.BURNING_FURNACE))) {
          return;
        }
        p.sendMessage(ChatColor.YELLOW + "To cook, " + 
          ChatColor.UNDERLINE + "RIGHT CLICK" + 
          ChatColor.YELLOW + " any heat source.");
        p.sendMessage(ChatColor.GRAY + "Ex. Fire, Lava, Furnace");
      }
    }
  }
  
  @EventHandler
  public void onFishCook(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
      (e.getClickedBlock().getType() == Material.FURNACE))
    {
      if ((p.getItemInHand().getType() == Material.RAW_FISH) && 
        (p.getItemInHand().getItemMeta().hasDisplayName()) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Raw Salmon of Lasting Agility")))
      {
        e.setCancelled(true);
        p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 0.0F);
        ItemStack F = new ItemStack(Material.COOKED_FISH, p
          .getItemInHand().getAmount());
        ItemMeta fishmeta = F.getItemMeta();
        fishmeta.setDisplayName(ChatColor.AQUA + 
          "Cooked Salmon of Lasting Agility");
        List<String> lore = new ArrayList();
        lore.add(ChatColor.RED + "SPEED (I) BUFF" + ChatColor.GRAY + 
          " (30s)");
        lore.add(ChatColor.RED + "-30% HUNGER" + ChatColor.GRAY + 
          " (instant)");
        lore.add(ChatColor.GRAY + ChatColor.ITALIC.toString() + 
          "A beautiful jumping fish.");
        fishmeta.setLore(lore);
        F.setItemMeta(fishmeta);
        p.setItemInHand(F);
        return;
      }
      if ((p.getItemInHand().getType() == Material.RAW_FISH) && 
        (p.getItemInHand().getItemMeta().hasDisplayName()) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Raw Lobster of Bursting Agility")))
      {
        e.setCancelled(true);
        p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 0.0F);
        ItemStack F = new ItemStack(Material.COOKED_FISH, p
          .getItemInHand().getAmount());
        ItemMeta fishmeta = F.getItemMeta();
        fishmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
          "Cooked Lobster of Bursting Agility");
        List<String> lore = new ArrayList();
        lore.add(ChatColor.RED + "SPEED (II) BUFF" + ChatColor.GRAY + 
          " (15s)");
        lore.add(ChatColor.RED + "-40% HUNGER" + ChatColor.GRAY + 
          " (instant)");
        lore.add(ChatColor.GRAY + ChatColor.ITALIC.toString() + 
          "A large red crustacean.");
        fishmeta.setLore(lore);
        F.setItemMeta(fishmeta);
        p.setItemInHand(F);
        return;
      }
      if ((p.getItemInHand().getType() == Material.RAW_FISH) && 
        (p.getItemInHand().getItemMeta().hasDisplayName()) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Raw Swordfish of Godlike Speed")))
      {
        e.setCancelled(true);
        p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 0.0F);
        ItemStack F = new ItemStack(Material.COOKED_FISH, p
          .getItemInHand().getAmount());
        ItemMeta fishmeta = F.getItemMeta();
        fishmeta.setDisplayName(ChatColor.YELLOW + 
          "Cooked Swordfish of Godlike Speed");
        List<String> lore = new ArrayList();
        lore.add(ChatColor.RED + "SPEED (II) BUFF" + ChatColor.GRAY + 
          " (30s)");
        lore.add(ChatColor.RED + "-50% HUNGER" + ChatColor.GRAY + 
          " (instant)");
        lore.add(ChatColor.GRAY + ChatColor.ITALIC.toString() + 
          "An elongated fish with a long bill.");
        fishmeta.setLore(lore);
        F.setItemMeta(fishmeta);
        p.setItemInHand(F);
      }
    }
  }
}