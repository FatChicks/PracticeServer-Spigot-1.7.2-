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

public class Orbs3
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
      (e.getCurrentItem() != null)) {
      if ((e.getCurrentItem().getType() == Material.IRON_HELMET) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(8) + 1;
        int dodge = random.nextInt(8) + 1;
        int reflect = random.nextInt(5) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(16) + 40;
        int thorns = random.nextInt(12) + 1;
        int vit = random.nextInt(41) + 20;
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
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Protective Mending Magic Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Agile Magic Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Magic Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Reflective Mending Magic Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Protective Mending Agile Magic Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Mending Magic Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Agile Magic Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Reflective Mending Agile Magic Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Magic Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Magic Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Agile Magic Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Magic Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Agile Magic Full Helmet of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Protective Magic Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Agile Magic Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Magic Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Reflective Magic Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Agile Magic Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Magic Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Agile Magic Full Helmet of Spikes of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Agile Magic Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Magic Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Magic Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Agile Magic Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Magic Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Agile Magic Full Helmet of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
      else if ((e.getCurrentItem().getType() == Material.IRON_CHESTPLATE) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(8) + 1;
        int thorns = random.nextInt(12) + 1;
        int dodge = random.nextInt(8) + 1;
        int rand = random.nextInt(13) + 1;
        int reflect = random.nextInt(5) + 1;
        int regen = random.nextInt(16) + 40;
        int vit = random.nextInt(41) + 20;
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
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Protective Mending Magic Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Agile Magic Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Magic Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Reflective Mending Magic Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Protective Mending Agile Magic Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Mending Magic Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Agile Magic Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Reflective Mending Agile Magic Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Magic Platemail");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Magic Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Agile Magic Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Magic Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Agile Magic Platemail of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Protective Magic Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Agile Magic Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Magic Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Reflective Magic Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Agile Magic Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Magic Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Agile Magic Platemail of Spikes of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Agile Magic Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Magic Platemail of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Magic Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Agile Magic Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Magic Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
          ItemStack H = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Agile Magic Platemail of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
      else if ((e.getCurrentItem().getType() == Material.IRON_LEGGINGS) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(8) + 1;
        int dodge = random.nextInt(8) + 1;
        int rand = random.nextInt(13) + 1;
        int reflect = random.nextInt(5) + 1;
        int thorns = random.nextInt(12) + 1;
        int regen = random.nextInt(16) + 40;
        int vit = random.nextInt(41) + 20;
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
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Protective Mending Magic Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Agile Magic Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Magic Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Reflective Mending Magic Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Mending Agile Magic Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Mending Magic Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Mending Agile Magic Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Agile Magic Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Magic Platemail Leggings");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Magic Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Agile Magic Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Magic Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Agile Magic Platemail Leggings of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Magic Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Agile Magic Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Magic Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Magic Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Agile Magic Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Magic Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Agile Magic Platemail Leggings of Spikes of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Agile Magic Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Magic Platemail Leggings of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Magic Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Agile Magic Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Magic Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
          ItemStack H = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Agile Magic Platemail Leggings of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
      else if ((e.getCurrentItem().getType() == Material.IRON_BOOTS) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(8) + 1;
        int reflect = random.nextInt(5) + 1;
        int dodge = random.nextInt(8) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(16) + 40;
        int vit = random.nextInt(41) + 20;
        int thorns = random.nextInt(12) + 1;
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
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Protective Mending Magic Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Agile Magic Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Mending Magic Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Reflective Mending Magic Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Mending Agile Magic Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Mending Magic Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Mending Agile Magic Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Agile Magic Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Magic Platemail Boots");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Magic Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 1) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Mending Agile Magic Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Magic Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Mending Agile Magic Platemail Boots of Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          
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
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Magic Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Agile Magic Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.AQUA + 
            "Magic Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Magic Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Agile Magic Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 6))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Magic Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 7))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Agile Magic Platemail Boots of Spikes of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 8))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Agile Magic Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 9))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Magic Platemail Boots of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 10))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Magic Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
          hlore.add(ChatColor.RED + "REFLECT: " + reflect + "%");
          hlore.add(ChatColor.RED + "THORNS: " + thorns + "%");
          hlore.add((String)curlore.get(curlore.size() - 1));
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.setCurrentItem(H);
        }
        else if ((wepdrop == 2) && (rand == 11))
        {
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Reflective Agile Magic Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Magic Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
          ItemStack H = new ItemStack(Material.IRON_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.AQUA + 
            "Protective Reflective Agile Magic Platemail Boots of Fortitude Spikes");
          List<String> hlore = new ArrayList();
          hlore.add((String)curlore.get(0));
          hlore.add((String)curlore.get(1));
          hlore.add((String)curlore.get(2));
          if (this.luck == 1) {
            hlore.add(ChatColor.RED + "VIT: +" + vit);
          }
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
    }
  }
}