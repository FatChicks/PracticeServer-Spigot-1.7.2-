package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class Enchants
  implements Listener
{
  public static int getValueFromLore(ItemStack item, String value)
  {
    int returnVal = 0;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if ((lore != null) && (((String)lore.get(1)).contains(value)))
      {
        String vals = ((String)lore.get(1)).split(": +")[1];
        vals = ChatColor.stripColor(vals);
        returnVal = Integer.parseInt(vals.trim());
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  public static int getEngFromLore(ItemStack item, String value)
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
            String vals = ((String)lore.get(i)).split(": ")[1];
            vals = ChatColor.stripColor(vals);
            vals = vals.replace("%", "").trim().toString();
            returnVal = Integer.parseInt(vals.trim());
          }
        }
      }
    }
    catch (Exception localException) {}
    return returnVal;
  }
  
  public static int getMinValueFromLore(ItemStack item, String value)
  {
    int returnVal = 1;
    ItemMeta meta = item.getItemMeta();
    try
    {
      List<?> lore = meta.getLore();
      if ((lore != null) && (((String)lore.get(0)).contains(value)))
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
      if ((lore != null) && (((String)lore.get(0)).contains(value)))
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
  @EventHandler
  public void onHorseClick(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getHolder() != p) {
      return;
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.IRON_BARDING))
    {
      if ((e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Iron Horse Armor")) && 
        (e.getCurrentItem() != null) && 
        (e.getCurrentItem().getType() == Material.SADDLE) && 
        (e.getCurrentItem().getItemMeta().getLore() != null) && 
        (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Old Horse Mount")))
      {
        e.setCancelled(true);
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Old Horse Mount"))
        {
          List<String> lore = new ArrayList();
          
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          
          lore.add("§cSpeed: 140%");
          lore.add("§cJump: 105%");
          lore.add("§7§oA fast, strong iron horse mount.");
          lore.add("§7Permanent Untradeable");
          
          ItemStack clean = new ItemStack(Material.SADDLE);
          ItemMeta cleanMeta = clean.getItemMeta();
          cleanMeta.setDisplayName("§bTraveler's Horse Mount");
          cleanMeta.setLore(lore);
          clean.setItemMeta(cleanMeta);
          
          e.setCurrentItem(clean);
        }
      }
    }
    else if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.DIAMOND_BARDING))
    {
      if ((e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Diamond Horse Armor")) && 
        (e.getCurrentItem() != null) && 
        (e.getCurrentItem().getType() == Material.SADDLE) && 
        (e.getCurrentItem().getItemMeta().getLore() != null) && 
        (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Traveler's Horse Mount")))
      {
        e.setCancelled(true);
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Traveler's Horse Mount"))
        {
          List<String> lore = new ArrayList();
          
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          
          lore.add("§cSpeed: 160%");
          lore.add("§cJump: 110%");
          lore.add("§7§oA shimmering, bright diamond horse mount.");
          lore.add("§7Permanent Untradeable");
          
          ItemStack clean = new ItemStack(Material.SADDLE);
          ItemMeta cleanMeta = clean.getItemMeta();
          cleanMeta.setDisplayName("§dKnight's Horse Mount");
          cleanMeta.setLore(lore);
          clean.setItemMeta(cleanMeta);
          
          e.setCurrentItem(clean);
        }
      }
    }
    else if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.GOLD_BARDING) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Gold Horse Armor")) && 
      (e.getCurrentItem() != null) && 
      (e.getCurrentItem().getType() == Material.SADDLE) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Knight's Horse Mount")))
    {
      e.setCancelled(true);
      if (e.getCursor().getAmount() > 1) {
        e.getCursor().setAmount(e.getCursor().getAmount() - 1);
      } else if (e.getCursor().getAmount() == 1) {
        e.setCursor(null);
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Knight's Horse Mount"))
      {
        List<String> lore = new ArrayList();
        
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        
        lore.add("§cSpeed: 200%");
        lore.add("§cJump: 120%");
        lore.add("§7§oA glowing, godlike golden horse mount.");
        lore.add("§7Permanent Untradeable");
        
        ItemStack clean = new ItemStack(Material.SADDLE);
        ItemMeta cleanMeta = clean.getItemMeta();
        cleanMeta.setDisplayName("§eWar Stallion Mount");
        cleanMeta.setLore(lore);
        clean.setItemMeta(cleanMeta);
        
        e.setCurrentItem(clean);
      }
    }
  }
  @EventHandler
  public void onInvClick(InventoryClickEvent e)
    throws Exception
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getHolder() != p) {
      return;
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.YELLOW + " Enchant Gold Armor")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.GOLD_HELMET) || 
      (e.getCurrentItem().getType() == Material.GOLD_CHESTPLATE) || 
      (e.getCurrentItem().getType() == Material.GOLD_LEGGINGS) || 
      (e.getCurrentItem().getType() == Material.GOLD_BOOTS)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforehp = getValueFromLore(e.getCurrentItem(), "HP");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2 ; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.LIGHT_PURPLE + " Enchant Diamond Armor")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.DIAMOND_HELMET) || 
      (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) || 
      (e.getCurrentItem().getType() == Material.DIAMOND_LEGGINGS) || 
      (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforehp = getValueFromLore(e.getCurrentItem(), "HP");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.AQUA + " Enchant Iron Armor")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.IRON_HELMET) || 
      (e.getCurrentItem().getType() == Material.IRON_CHESTPLATE) || 
      (e.getCurrentItem().getType() == Material.IRON_LEGGINGS) || 
      (e.getCurrentItem().getType() == Material.IRON_BOOTS)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforehp = getValueFromLore(e.getCurrentItem(), "HP");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.YELLOW + " Enchant Gold Weapon")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.GOLD_SWORD) || 
      (e.getCurrentItem().getType() == Material.GOLD_AXE)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforemin = getMinValueFromLore(e.getCurrentItem(), 
        "DMG");
      double beforemax = getMaxValueFromLore(e.getCurrentItem(), 
        "DMG");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin);
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.LIGHT_PURPLE + " Enchant Diamond Weapon")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.DIAMOND_SWORD) || 
      (e.getCurrentItem().getType() == Material.DIAMOND_AXE)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforemin = getMinValueFromLore(e.getCurrentItem(), 
        "DMG");
      double beforemax = getMaxValueFromLore(e.getCurrentItem(), 
        "DMG");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin);
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.AQUA + " Enchant Iron Weapon")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.IRON_SWORD) || 
      (e.getCurrentItem().getType() == Material.IRON_AXE)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforemin = getMinValueFromLore(e.getCurrentItem(), 
        "DMG");
      double beforemax = getMaxValueFromLore(e.getCurrentItem(), 
        "DMG");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin);
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.GREEN + " Enchant Chainmail Armor")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.CHAINMAIL_HELMET) || 
      (e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE) || 
      (e.getCurrentItem().getType() == Material.CHAINMAIL_LEGGINGS) || 
      (e.getCurrentItem().getType() == Material.CHAINMAIL_BOOTS)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforehp = getValueFromLore(e.getCurrentItem(), "HP");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added);
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.GREEN + " Enchant Stone Weapon")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.STONE_SWORD) || 
      (e.getCurrentItem().getType() == Material.STONE_AXE)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforemin = getMinValueFromLore(e.getCurrentItem(), 
        "DMG");
      double beforemax = getMaxValueFromLore(e.getCurrentItem(), 
        "DMG");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.WHITE + " Enchant Leather Armor")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.LEATHER_HELMET) || 
      (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) || 
      (e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS) || 
      (e.getCurrentItem().getType() == Material.LEATHER_BOOTS)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforehp = getValueFromLore(e.getCurrentItem(), "HP");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double added = beforehp * 0.05D;
        int newhp = (int)(beforehp + added) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add((String)curlore.get(0));
        hlore.add(ChatColor.RED + "HP: +" + newhp);
        for (int i = 2; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          double added = beforehp * 0.05D;
          int newhp = (int)(beforehp + added);
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add(ChatColor.RED + "HP: +" + newhp);
          for (int i = 2; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.EMPTY_MAP) && 
      (e.getCursor().getItemMeta().getDisplayName() != null) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.WHITE + ChatColor.BOLD.toString() + "Scroll:" + ChatColor.WHITE + " Enchant Wooden Weapon")) && 
      (e.getCurrentItem() != null) && 
      ((e.getCurrentItem().getType() == Material.WOOD_SWORD) || 
      (e.getCurrentItem().getType() == Material.WOOD_AXE)) && 
      (e.getCurrentItem().getItemMeta().getLore() != null) && 
      (e.getCurrentItem().getItemMeta().hasDisplayName()))
    {
      List<?> curlore = e.getCurrentItem().getItemMeta().getLore();
      String name = e.getCurrentItem().getItemMeta().getDisplayName();
      String cleanname = name.substring(7, name.length());
      double beforemin = getMinValueFromLore(e.getCurrentItem(), 
        "DMG");
      double beforemax = getMaxValueFromLore(e.getCurrentItem(), 
        "DMG");
      if (!name.startsWith(ChatColor.RED + "[+"))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+1] " + name);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+1] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+2] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+2] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Firework fw = (Firework)p.getWorld().spawn(
          p.getLocation(), Firework.class);
        FireworkMeta data = fw.getFireworkMeta();
        data.addEffects(new FireworkEffect[] {
          FireworkEffect.builder().withColor(Color.YELLOW)
          .with(FireworkEffect.Type.BALL).build() });
        data.setPower(0);
        fw.setFireworkMeta(data);
        e.setCancelled(true);
        double addedmin = beforemin * 0.05D;
        int min = (int)(beforemin + addedmin) + 1;
        double addedmax = beforemax * 0.05D;
        int max = (int)(beforemax + addedmax) + 1;
        ItemStack H = new ItemStack(e.getCurrentItem().getType());
        ItemMeta helmmeta = H.getItemMeta();
        helmmeta.setDisplayName(ChatColor.RED + "[+3] " + cleanname);
        List<String> hlore = new ArrayList();
        hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
        for (int i = 1; i < curlore.size(); i++) {
          hlore.add((String)curlore.get(i));
        }
        helmmeta.setLore(hlore);
        H.setItemMeta(helmmeta);
        e.setCurrentItem(H);
      }
      else if (name.startsWith(ChatColor.RED + "[+3] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 25)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+4] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+4] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+5] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+5] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 50)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+6] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+6] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+7] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+7] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 75)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+8] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+8] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 80)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+9] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+9] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 85)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+10] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+10] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 90)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+11] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
      else if (name.startsWith(ChatColor.RED + "[+11] "))
      {
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        Random random = new Random();
        int drop = random.nextInt(100) + 1;
        e.setCancelled(true);
        if (drop <= 95)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
          e.setCurrentItem(null);
        }
        else
        {
          Firework fw = (Firework)p.getWorld().spawn(
            p.getLocation(), Firework.class);
          FireworkMeta data = fw.getFireworkMeta();
          data.addEffects(new FireworkEffect[] {
            FireworkEffect.builder().withColor(Color.YELLOW)
            .with(FireworkEffect.Type.BALL).build() });
          data.setPower(0);
          fw.setFireworkMeta(data);
          e.setCancelled(true);
          double addedmin = beforemin * 0.05D;
          int min = (int)(beforemin + addedmin) + 1;
          double addedmax = beforemax * 0.05D;
          int max = (int)(beforemax + addedmax) + 1;
          ItemStack H = new ItemStack(e.getCurrentItem()
            .getType());
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.RED + "[+12] " + 
            cleanname);
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          for (int i = 1; i < curlore.size(); i++) {
            hlore.add((String)curlore.get(i));
          }
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          H.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
          e.setCurrentItem(H);
        }
      }
    }
  }
}
