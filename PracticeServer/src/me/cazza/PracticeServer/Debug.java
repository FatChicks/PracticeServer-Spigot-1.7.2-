package me.cazza.PracticeServer;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.MetadataValue;

public class Debug
  implements Listener
{
  public static Main plugin;
  
  public Debug(Main m)
  {
    plugin = m;
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onDebug(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && 
      ((e.getDamager() instanceof Player)))
    {
      Player p = (Player)e.getEntity();
      Player d = (Player)e.getDamager();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if (Main.debug.contains(d.getName())) {
          return;
      }
      int dmg = (int)e.getDamage();
      d.sendMessage(ChatColor.RED + "            " + dmg + 
        ChatColor.RED + 
        ChatColor.BOLD + " DMG " + ChatColor.RED + "-> " + 
        
        p.getName());
    }
    else if (((e.getEntity() instanceof LivingEntity)) && 
      ((e.getDamager() instanceof Player)))
    {
      LivingEntity p = (LivingEntity)e.getEntity();
      Damageable dp = p;
      Player d = (Player)e.getDamager();
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if (Main.debug.contains(d.getName())) {
          return;
      }
      int dmg = (int)e.getDamage();
      int health = 0;
      if (dp.getHealth() - dmg > 0.0D) {
        health = (int)(dp.getHealth() - dmg);
      }
      p.setCustomNameVisible(true);
      if (!p.isDead()) {
        try
        {
          p.setCustomName(plugin.getNameHealth(dp.getHealth(), 
            dp.getMaxHealth(), 
            (String)((MetadataValue)p.getMetadata("Name").get(0)).value()));
        }
        catch (Exception localException) {}
      }
      if (Main.debug.contains(d.getName())) {
          return;
      }
      d.sendMessage(ChatColor.RED + "            " + dmg + 
        ChatColor.RED + 
        ChatColor.BOLD + " DMG " + ChatColor.RED + "-> " + 
       
        ChatColor.RESET + p.getCustomName() + " [" + 
        health + 
        "HP]");
    }
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onDamageBug(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      Damageable dp = p;
      if (e.getDamage() <= 0.0D) {
        return;
      }
      if ((p.getNoDamageTicks() <= p.getMaximumNoDamageTicks() / 2) && 
        (dp.getHealth() > 0.0D))
      {
        int dmg = (int)e.getDamage();
        if (dmg <= 0) {
          return;
        }
        int health = 0;
        if (dp.getHealth() - dmg > 0.0D) {
          health = (int)(dp.getHealth() - dmg);
        }
        if (Main.debug.contains(p.getName())) {
            return;
        }
        int armor = Listeners.getArmor(p);
        int dmgless = Listeners.getDMGWithArmor(p, dmg);
        p.sendMessage(ChatColor.RED + "            -" + dmg + 
          ChatColor.RED + ChatColor.BOLD + "HP " + 
          ChatColor.GRAY + "[-" + armor + "%A -> -" + dmgless + "" + ChatColor.BOLD + 
          "DMG" + ChatColor.GRAY + "] " + ChatColor.GREEN + 
          "[" + 
          health + ChatColor.BOLD + "HP" + 
          ChatColor.GREEN + 
          "]");
      }
    }
  }
}