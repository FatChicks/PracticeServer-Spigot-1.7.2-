 package me.cazza.PracticeServer;
 
 import java.util.List;
 import org.bukkit.ChatColor;
 import org.bukkit.Material;
 import org.bukkit.Sound;
 import org.bukkit.entity.Item;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.inventory.InventoryClickEvent;
 import org.bukkit.event.player.PlayerDropItemEvent;
 import org.bukkit.event.player.PlayerPickupItemEvent;
 import org.bukkit.inventory.Inventory;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 
 public class Untradeable
   implements Listener
 {
   public static Main plugin;
   
   public Untradeable(Main m)
   {
     plugin = m;
   }
   
   @EventHandler
   public void onDropItem(PlayerDropItemEvent e)
   {
     if ((e.getItemDrop().getItemStack().getItemMeta().hasLore()) && (e.getItemDrop().getItemStack().getItemMeta().getLore().contains(ChatColor.GRAY + "Untradeable")))
     {
       e.getItemDrop().remove();
       e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIZZ, 1.0F, 0.0F);
       e.getPlayer().sendMessage(ChatColor.GRAY + "This item was" + ChatColor.GRAY + ChatColor.ITALIC + " untradeable" + ChatColor.GRAY + ", so it has " + ChatColor.GRAY + ChatColor.UNDERLINE + "vanished.");
     }
   }
   
   @EventHandler
   public void onPickup(PlayerPickupItemEvent e)
   {
     if ((e.getItem().getItemStack().getItemMeta().hasLore()) && (
       (e.getItem().getItemStack().getItemMeta().getLore().contains(ChatColor.GRAY + "Untradeable")) || 
       
       (e.getItem().getItemStack().getItemMeta().getLore().contains(ChatColor.GRAY + "Permanent Untradeable")))) {
       e.setCancelled(true);
     }
   }
   @EventHandler
   public void onDropItemSaddle(PlayerDropItemEvent e)
   {
     if ((e.getItemDrop().getItemStack().getItemMeta().getLore().contains(ChatColor.GRAY + "Permanent Untradeable")) || 
       (e.getItemDrop().getItemStack().getType() == Material.SADDLE)) {
       e.setCancelled(true);
     }
   }
   @EventHandler
   public void onClick(InventoryClickEvent e)
   {
     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getType() != Material.AIR) && (e.getCurrentItem().getItemMeta().hasLore()) && (e.getCurrentItem().getItemMeta().getLore().contains(ChatColor.GRAY + "Untradeable")) && 
       (e.getInventory().getHolder() != e.getWhoClicked()))
     {
       Player p = (Player)e.getWhoClicked();
       e.setCancelled(true);
       p.sendMessage(ChatColor.RED + "You " + ChatColor.RED + ChatColor.UNDERLINE + "cannot" + ChatColor.RED + " bank this item, as it is part of your spawn kit.");
     }
   }
 }