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
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class Orbs
  implements Listener
{
  Random random = new Random();
  int luck = this.random.nextInt(3) + 1;
  
  @EventHandler
  public void onInvClick(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getHolder() != p) {
      return;
    }
    if ((e.getCursor() != null) && 
      (e.getCursor().getType() == Material.MAGMA_CREAM) && 
      (e.getCursor().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Orb of Alteration")) && 
      (e.getCurrentItem() != null))
    {
      if ((e.getCurrentItem().getType() == Material.GOLD_AXE) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        List<String> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        String plus = ChatColor.YELLOW.toString();
        String name = "Legendary Axe";
        if (e.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+")) {
          plus = 
          
            e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 7) + plus;
        }
        Random random = new Random();
        int elemamt = random.nextInt(31) + 25;
        int blind = random.nextInt(12) + 1;
        int pureamt = random.nextInt(31) + 25;
        int lifeamt = random.nextInt(20) + 1;
        int critamt = random.nextInt(11) + 1;
        int vit2 = random.nextInt(316) + 1;
        int str2 = random.nextInt(316) + 1;
        int dex2 = random.nextInt(316) + 1;
        int blindrand = random.nextInt(13) + 1;
        int elem = random.nextInt(13) + 1;
        int life = random.nextInt(3) + 1;
        int crit = random.nextInt(3) + 1;
        int pure = random.nextInt(3) + 1;
        int dex = random.nextInt(7) + 1;
        int str = random.nextInt(7) + 1;
        int vit = random.nextInt(7) + 1;
        int pen = random.nextInt(5) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(20) + 1;
        int vsm = random.nextInt(20) + 1;
        int armorpen = random.nextInt(16) + 1;
        List<String> lore = new ArrayList();
        lore.add((String)curlore.get(0));
        if (str == 1) {
          lore.add(ChatColor.RED + "STR: +" + str2);
        }
        if (blindrand <= 4)
        {
          lore.add(ChatColor.RED + "BLIND: " + blind + "%");
          name = name + " of Blindness";
        }
        if (pure == 1)
        {
          lore.add(ChatColor.RED + "PURE DMG: +" + pureamt);
          name = "Pure " + name;
        }
        if (pen == 1)
        {
          lore.add(ChatColor.RED + "ARMOR PENETRATION: " + 
            armorpen + "%");
          name = "Penetrating " + name;
        }
        if (life == 1)
        {
          lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
          name = "Vampyric " + name;
        }
        if (crit == 1)
        {
          lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
            "%");
          name = "Deadly " + name;
        }
        if (vs == 1)
        {
          lore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
          name = name + " of Slaying";
        }
        if (vs == 2)
        {
          lore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
          name = name + " of Slaughter";
        }
        if ((elem == 3) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " of Ice";
        }
        else if ((elem == 3) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 1))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 2))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        if ((elem == 2) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " of Poison";
        }
        else if ((elem == 2) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 1))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 2))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        if ((elem == 1) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " of Fire";
        }
        else if ((elem == 1) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 1))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 2))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        lore.add((String)curlore.get(curlore.size() - 1));
        
        ItemStack is = new ItemStack(Material.GOLD_AXE);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(plus + name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        e.setCurrentItem(is);
        if (lore.size() <= curlore.size())
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      else if ((e.getCurrentItem().getType() == Material.GOLD_HELMET) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int thorns = random.nextInt(12) + 1;
        int wepdrop = random.nextInt(2) + 1;
        int reflect = random.nextInt(5) + 1;
        int block = random.nextInt(12) + 1;
        int dodge = random.nextInt(12) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(21) + 90;
        int vit = random.nextInt(161) + 150;
        String plus = "";
        String fulname = e.getCurrentItem().getItemMeta()
          .getDisplayName();
        if (fulname.startsWith(ChatColor.RED + "[+")) {
          plus = fulname.substring(0, 7);
        }
        List<String> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        if ((wepdrop == 1) && (rand == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Protective Mending Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Mending Agile Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Mending Legendary Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Reflective Mending Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Agile Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Legendary Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Mending Agile Legendary Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Agile Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Legendary Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Agile Legendary Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 12))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Legendary Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 13))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Agile Legendary Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        if ((wepdrop == 2) && (rand == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Agile Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Legendary Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Agile Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Legendary Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Agile Legendary Full Helmet of Spikes of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Agile Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Legendary Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Agile Legendary Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 12))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Legendary Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 13))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Agile Legendary Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        if (wepdrop == 1)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      else if ((e.getCurrentItem().getType() == Material.GOLD_CHESTPLATE) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int thorns = random.nextInt(12) + 1;
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(12) + 1;
        int dodge = random.nextInt(12) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(21) + 90;
        int vit = random.nextInt(161) + 150;
        int reflect = random.nextInt(5) + 1;
        String plus = "";
        String fulname = e.getCurrentItem().getItemMeta()
          .getDisplayName();
        if (fulname.startsWith(ChatColor.RED + "[+")) {
          plus = fulname.substring(0, 7);
        }
        List<String> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        if ((wepdrop == 1) && (rand == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Mending Agile Legendary Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Mending Legendary Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Reflective Mending Legendary Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Agile Legendary Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Mending Agile Legendary Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Agile Legendary Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Legendary Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Legendary Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Agile Legendary Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 12))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Legendary Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 13))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Agile Legendary Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        if ((wepdrop == 2) && (rand == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Protective Legendary Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Agile Legendary Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Legendary Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Reflective Legendary Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Agile Legendary Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Legendary Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Agile Legendary Platemail of Spikes of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Agile Legendary Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Legendary Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Legendary Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Agile Legendary Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 12))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Legendary Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 13))
        {
          ItemStack H = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Agile Legendary Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        if (wepdrop == 1)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      else if ((e.getCurrentItem().getType() == Material.GOLD_LEGGINGS) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int thorns = random.nextInt(12) + 1;
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(12) + 1;
        int dodge = random.nextInt(12) + 1;
        int reflect = random.nextInt(5) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(21) + 90;
        int vit = random.nextInt(161) + 150;
        String plus = "";
        String fulname = e.getCurrentItem().getItemMeta()
          .getDisplayName();
        if (fulname.startsWith(ChatColor.RED + "[+")) {
          plus = fulname.substring(0, 7);
        }
        List<String> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        if ((wepdrop == 1) && (rand == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Mending Agile Legendary Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Mending Legendary Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Legendary Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Agile Legendary Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Mending Agile Legendary Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Agile Legendary Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Legendary Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Legendary Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Agile Legendary Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 12))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Legendary Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 13))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Agile Legendary Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        if ((wepdrop == 2) && (rand == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Legendary Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Agile Legendary Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Legendary Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Legendary Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Agile Legendary Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Legendary Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Agile Legendary Platemail Leggings of Spikes of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Agile Legendary Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Legendary Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Legendary Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Agile Legendary Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 12))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Legendary Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 13))
        {
          ItemStack H = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Agile Legendary Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        if (wepdrop == 1)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      else if ((e.getCurrentItem().getType() == Material.GOLD_BOOTS) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int thorns = random.nextInt(12) + 1;
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(12) + 1;
        int dodge = random.nextInt(12) + 1;
        int reflect = random.nextInt(5) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(21) + 90;
        int vit = random.nextInt(161) + 150;
        String plus = "";
        String fulname = e.getCurrentItem().getItemMeta()
          .getDisplayName();
        if (fulname.startsWith(ChatColor.RED + "[+")) {
          plus = fulname.substring(0, 7);
        }
        List<String> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        if ((wepdrop == 1) && (rand == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Mending Agile Legendary Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.YELLOW + 
            "Mending Legendary Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Legendary Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Agile Legendary Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Mending Agile Legendary Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Agile Legendary Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Legendary Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Legendary Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Mending Agile Legendary Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 12))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Legendary Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 13))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Mending Agile Legendary Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        if ((wepdrop == 2) && (rand == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Legendary Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Agile Legendary Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Legendary Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Legendary Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Agile Legendary Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Legendary Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Agile Legendary Platemail Boots of Spikes of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Agile Legendary Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Legendary Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Legendary Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Reflective Agile Legendary Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 12))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Legendary Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 13))
        {
          ItemStack H = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.YELLOW + 
            "Protective Reflective Agile Legendary Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        if (wepdrop == 1)
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      else if ((e.getCurrentItem().getType() == Material.GOLD_SWORD) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        List<String> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        String plus = ChatColor.YELLOW.toString();
        String name = "Legendary Sword";
        if (e.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+")) {
          plus = 
          
            e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 7) + plus;
        }
        Random random = new Random();
        int elemamt = random.nextInt(31) + 25;
        int vit2 = random.nextInt(316) + 1;
        int str2 = random.nextInt(316) + 1;
        int dex2 = random.nextInt(316) + 1;
        int blind = random.nextInt(12) + 1;
        int blindrand = random.nextInt(13) + 1;
        int lifeamt = random.nextInt(20) + 1;
        int critamt = random.nextInt(9) + 1;
        int elem = random.nextInt(13) + 1;
        int life = random.nextInt(3) + 1;
        int crit = random.nextInt(3) + 1;
        int dex = random.nextInt(7) + 1;
        int str = random.nextInt(7) + 1;
        int vit = random.nextInt(7) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(20) + 1;
        int vsm = random.nextInt(20) + 1;
        int accuracy = random.nextInt(33) + 1;
        int acc = random.nextInt(5) + 1;
        List<String> lore = new ArrayList();
        lore.add((String)curlore.get(0));
        if (vit == 1) {
          lore.add(ChatColor.RED + "VIT: +" + vit2);
        }
        if (blindrand <= 4)
        {
          lore.add(ChatColor.RED + "BLIND: " + blind + "%");
          name = name + " of Blindness";
        }
        if (acc == 1)
        {
          lore.add(ChatColor.RED + "ACCURACY: " + 
            accuracy + "%");
          name = "Accurate " + name;
        }
        if (life == 1)
        {
          lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
          name = "Vampyric " + name;
        }
        if (crit == 1)
        {
          lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
            "%");
          name = "Deadly " + name;
        }
        if (vs == 1)
        {
          lore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
          name = name + " of Slaying";
        }
        if (vs == 2)
        {
          lore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
          name = name + " of Slaughter";
        }
        if ((elem == 3) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " of Ice";
        }
        else if ((elem == 3) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 1))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 2))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        if ((elem == 2) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " of Poison";
        }
        else if ((elem == 2) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 1))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 2))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        if ((elem == 1) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " of Fire";
        }
        else if ((elem == 1) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 1))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 2))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        lore.add((String)curlore.get(curlore.size() - 1));
        ItemStack is = new ItemStack(Material.GOLD_SWORD);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(plus + name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        e.setCurrentItem(is);
        if (lore.size() <= curlore.size())
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      else if ((e.getCurrentItem().getType() == Material.DIAMOND_AXE) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        List<String> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        String plus = ChatColor.LIGHT_PURPLE.toString();
        String name = "Ancient Axe";
        if (e.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+")) {
          plus = 
          
            e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 7) + plus;
        }
        Random random = new Random();
        int elemamt = random.nextInt(11) + 10;
        int vit2 = random.nextInt(151) + 1;
        int str2 = random.nextInt(151) + 1;
        int dex2 = random.nextInt(151) + 1;
        int pureamt = random.nextInt(11) + 10;
        int lifeamt = random.nextInt(20) + 1;
        int critamt = random.nextInt(11) + 1;
        int blind = random.nextInt(12) + 1;
        int blindrand = random.nextInt(13) + 1;
        int elem = random.nextInt(12) + 1;
        int life = random.nextInt(4) + 1;
        int crit = random.nextInt(4) + 1;
        int dex = random.nextInt(7) + 1;
        int str = random.nextInt(7) + 1;
        int vit = random.nextInt(7) + 1;
        int pure = random.nextInt(4) + 1;
        int pen = random.nextInt(5) + 1;
        int armorpen = random.nextInt(9) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(20) + 1;
        int vsm = random.nextInt(20) + 1;
        List<String> lore = new ArrayList();
        lore.add((String)curlore.get(0));
        if (vit == 1) {
          lore.add(ChatColor.RED + "VIT: +" + vit2);
        }
        if (str == 1) {
          lore.add(ChatColor.RED + "STR: +" + str2);
        }
        if (dex == 1) {
          lore.add(ChatColor.RED + "DEX: +" + dex2);
        }
        if (pure == 1)
        {
          lore.add(ChatColor.RED + "PURE DMG: +" + pureamt);
          name = "Pure " + name;
        }
        if (blindrand <= 4)
        {
          lore.add(ChatColor.RED + "BLIND: " + blind + "%");
          name = name + " of Blindness";
        }
        if (pen == 1)
        {
          lore.add(ChatColor.RED + "ARMOR PENETRATION: " + 
            armorpen + "%");
          name = "Penetrating " + name;
        }
        if (life == 1)
        {
          lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
          name = "Vampyric " + name;
        }
        if (crit == 1)
        {
          lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
            "%");
          name = "Deadly " + name;
        }
        if (vs == 1)
        {
          lore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
          name = name + " of Slaying";
        }
        if (vs == 2)
        {
          lore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
          name = name + " of Slaughter";
        }
        if ((elem == 3) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " of Ice";
        }
        else if ((elem == 3) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 1))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 2))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        if ((elem == 2) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " of Poison";
        }
        else if ((elem == 2) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 1))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 2))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        if ((elem == 1) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " of Fire";
        }
        else if ((elem == 1) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 1))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 2))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        lore.add((String)curlore.get(curlore.size() - 1));
        
        ItemStack is = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(plus + name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        e.setCurrentItem(is);
        if (lore.size() <= curlore.size())
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      else if ((e.getCurrentItem().getType() == Material.DIAMOND_SWORD) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        List<?> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        String plus = ChatColor.LIGHT_PURPLE.toString();
        String name = "Ancient Sword";
        if (e.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+")) {
          plus = 
          
            e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 7) + plus;
        }
        Random random = new Random();
        int elemamt = random.nextInt(11) + 10;
        int vit2 = random.nextInt(151) + 1;
        int str2 = random.nextInt(151) + 1;
        int dex2 = random.nextInt(151) + 1;
        int lifeamt = random.nextInt(20) + 1;
        int critamt = random.nextInt(9) + 1;
        int blind = random.nextInt(12) + 1;
        int blindrand = random.nextInt(13) + 1;
        int elem = random.nextInt(12) + 1;
        int life = random.nextInt(4) + 1;
        int crit = random.nextInt(4) + 1;
        int dex = random.nextInt(7) + 1;
        int str = random.nextInt(7) + 1;
        int vit = random.nextInt(7) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(20) + 1;
        int vsm = random.nextInt(20) + 1;
        List<String> lore = new ArrayList();
        lore.add((String)curlore.get(0));
        if (vit == 1) {
          lore.add(ChatColor.RED + "VIT: +" + vit2);
        }
        if (str == 1) {
          lore.add(ChatColor.RED + "STR: +" + str2);
        }
        if (dex == 1) {
          lore.add(ChatColor.RED + "DEX: +" + dex2);
        }
        if (blindrand <= 4)
        {
          lore.add(ChatColor.RED + "BLIND: " + blind + "%");
          name = name + " of Blindness";
        }
        if (life == 1)
        {
          lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
          name = "Vampyric " + name;
        }
        if (crit == 1)
        {
          lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
            "%");
          name = "Deadly " + name;
        }
        if (vs == 1)
        {
          lore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
          name = name + " of Slaying";
        }
        if (vs == 2)
        {
          lore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
          name = name + " of Slaughter";
        }
        if ((elem == 3) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " of Ice";
        }
        else if ((elem == 3) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 1))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 2))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        if ((elem == 2) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " of Poison";
        }
        else if ((elem == 2) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 1))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 2))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        if ((elem == 1) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " of Fire";
        }
        else if ((elem == 1) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 1))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 2))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        lore.add((String)curlore.get(curlore.size() - 1));
        ItemStack is = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(plus + name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        e.setCurrentItem(is);
        if (lore.size() <= curlore.size())
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      if ((e.getCurrentItem().getType() == Material.IRON_AXE) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        List<?> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        String plus = ChatColor.AQUA.toString();
        String name = "War Axe";
        if (e.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+")) {
          plus = 
          
            e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 7) + plus;
        }
        Random random = new Random();
        int elemamt = random.nextInt(6) + 5;
        int vit2 = random.nextInt(81) + 1;
        int str2 = random.nextInt(81) + 1;
        int dex2 = random.nextInt(81) + 1;
        int pureamt = random.nextInt(6) + 5;
        int lifeamt = random.nextInt(20) + 1;
        int critamt = random.nextInt(11) + 1;
        int blind = random.nextInt(12) + 1;
        int blindrand = random.nextInt(13) + 1;
        int elem = random.nextInt(12) + 1;
        int life = random.nextInt(4) + 1;
        int crit = random.nextInt(4) + 1;
        int dex = random.nextInt(7) + 1;
        int str = random.nextInt(7) + 1;
        int vit = random.nextInt(7) + 1;
        int pure = random.nextInt(4) + 1;
        int pen = random.nextInt(5) + 1;
        int armorpen = random.nextInt(9) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(20) + 1;
        int vsm = random.nextInt(20) + 1;
        List<String> lore = new ArrayList();
        lore.add((String)curlore.get(0));
        if (vit == 1) {
          lore.add(ChatColor.RED + "VIT: +" + vit2);
        }
        if (str == 1) {
          lore.add(ChatColor.RED + "STR: +" + str2);
        }
        if (dex == 1) {
          lore.add(ChatColor.RED + "DEX: +" + dex2);
        }
        if (pure == 1)
        {
          lore.add(ChatColor.RED + "PURE DMG: +" + pureamt);
          name = "Pure " + name;
        }
        if (blindrand <= 4)
        {
          lore.add(ChatColor.RED + "BLIND: " + blind + "%");
          name = name + " of Blindness";
        }
        if (pen == 1)
        {
          lore.add(ChatColor.RED + "ARMOR PENETRATION: " + 
            armorpen + "%");
          name = "Penetrating " + name;
        }
        if (life == 1)
        {
          lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
          name = "Vampyric " + name;
        }
        if (crit == 1)
        {
          lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
            "%");
          name = "Deadly " + name;
        }
        if (vs == 1)
        {
          lore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
          name = name + " of Slaying";
        }
        if (vs == 2)
        {
          lore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
          name = name + " of Slaughter";
        }
        if ((elem == 3) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " of Ice";
        }
        else if ((elem == 3) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 1))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 2))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        if ((elem == 2) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " of Poison";
        }
        else if ((elem == 2) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 1))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 2))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        if ((elem == 1) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " of Fire";
        }
        else if ((elem == 1) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 1))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 2))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        lore.add((String)curlore.get(curlore.size() - 1));
        
        ItemStack is = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(plus + name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        e.setCurrentItem(is);
        if (lore.size() <= curlore.size())
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
      else if ((e.getCurrentItem().getType() == Material.IRON_SWORD) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        List<?> curlore = e.getCurrentItem().getItemMeta()
          .getLore();
        if (e.getCursor().getAmount() > 1) {
          e.getCursor().setAmount(e.getCursor().getAmount() - 1);
        } else if (e.getCursor().getAmount() == 1) {
          e.setCursor(null);
        }
        String plus = ChatColor.AQUA.toString();
        String name = "Magic Sword";
        if (e.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[+")) {
          plus = 
          
            e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 7) + plus;
        }
        Random random = new Random();
        int elemamt = random.nextInt(6) + 5;
        int vit2 = random.nextInt(81) + 1;
        int str2 = random.nextInt(81) + 1;
        int dex2 = random.nextInt(81) + 1;
        int lifeamt = random.nextInt(20) + 1;
        int critamt = random.nextInt(9) + 1;
        int blind = random.nextInt(12) + 1;
        int blindrand = random.nextInt(13) + 1;
        int elem = random.nextInt(12) + 1;
        int life = random.nextInt(4) + 1;
        int crit = random.nextInt(4) + 1;
        int dex = random.nextInt(7) + 1;
        int str = random.nextInt(7) + 1;
        int vit = random.nextInt(7) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(20) + 1;
        int vsm = random.nextInt(20) + 1;
        List<String> lore = new ArrayList();
        lore.add((String)curlore.get(0));
        if (vit == 1) {
          lore.add(ChatColor.RED + "VIT: +" + vit2);
        }
        if (str == 1) {
          lore.add(ChatColor.RED + "STR: +" + str2);
        }
        if (dex == 1) {
          lore.add(ChatColor.RED + "DEX: +" + dex2);
        }
        if (blindrand <= 4)
        {
          lore.add(ChatColor.RED + "BLIND: " + blind + "%");
          name = name + " of Blindness";
        }
        if (life == 1)
        {
          lore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + "%");
          name = "Vampyric " + name;
        }
        if (crit == 1)
        {
          lore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
            "%");
          name = "Deadly " + name;
        }
        if (vs == 1)
        {
          lore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
          name = name + " of Slaying";
        }
        if (vs == 2)
        {
          lore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
          name = name + " of Slaughter";
        }
        if ((elem == 3) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " of Ice";
        }
        else if ((elem == 3) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 1))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        else if ((elem == 3) && (vs == 2))
        {
          lore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
          name = name + " Ice";
        }
        if ((elem == 2) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " of Poison";
        }
        else if ((elem == 2) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 1))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        else if ((elem == 2) && (vs == 2))
        {
          lore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
          name = name + " Poison";
        }
        if ((elem == 1) && (blindrand > 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " of Fire";
        }
        else if ((elem == 1) && (blindrand <= 4))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 1))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        else if ((elem == 1) && (vs == 2))
        {
          lore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
          name = name + " Fire";
        }
        lore.add((String)curlore.get(curlore.size() - 1));
        ItemStack is = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(plus + name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        e.setCurrentItem(is);
        if (lore.size() <= curlore.size())
        {
          p.getWorld().playEffect(p.getLocation(), 
            Effect.EXTINGUISH, 0);
          ParticleEffect.LAVA.display(p.getEyeLocation(), 0.0F, 
            0.0F, 0.0F, 5.0F, 10);
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
        }
      }
    }
  }
}