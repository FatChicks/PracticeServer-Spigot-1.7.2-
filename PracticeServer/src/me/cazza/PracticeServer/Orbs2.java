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

public class Orbs2
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
      if ((e.getCurrentItem().getType() == Material.DIAMOND_HELMET) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(12) + 1;
        int dodge = random.nextInt(12) + 1;
        int reflect = random.nextInt(5) + 1;
        int thorns = random.nextInt(12) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(16) + 60;
        int vit = random.nextInt(91) + 60;
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Full Helmet");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Agile Ancient Full Helmet");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Full Helmet of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Ancient Full Helmet");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Mending Agile Ancient Full Helmet");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Full Helmet of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Agile Ancient Full Helmet of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Agile Ancient Full Helmet");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Ancient Full Helmet");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Ancient Full Helmet of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Agile Ancient Full Helmet of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Ancient Full Helmet of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Agile Ancient Full Helmet of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Full Helmet of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Agile Ancient Full Helmet of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Ancient Full Helmet of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Reflective Ancient Full Helmet of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Agile Ancient Full Helmet of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Full Helmet of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Agile Ancient Full Helmet of Spikes of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Agile Ancient Full Helmet of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Ancient Full Helmet of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Ancient Full Helmet of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Agile Ancient Full Helmet of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Ancient Full Helmet of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Agile Ancient Full Helmet of Fortitude Spikes");
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
      else if ((e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(12) + 1;
        int reflect = random.nextInt(5) + 1;
        int dodge = random.nextInt(12) + 1;
        int rand = random.nextInt(13) + 1;
        int thorns = random.nextInt(12) + 1;
        int regen = random.nextInt(16) + 60;
        int vit = random.nextInt(91) + 60;
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Platemail");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Agile Ancient Platemail");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Platemail of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Ancient Platemail");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Protective Mending Agile Ancient Platemail");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Platemail of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Agile Ancient Platemail of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Agile Ancient Platemail");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Ancient Platemail");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Ancient Platemail of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Agile Ancient Platemail of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Ancient Platemail of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Agile Ancient Platemail of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Platemail of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Agile Ancient Platemail of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Ancient Platemail of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Reflective Ancient Platemail of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Agile Ancient Platemail of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Platemail of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Agile Ancient Platemail of Spikes of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Agile Ancient Platemail of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Ancient Platemail of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Ancient Platemail of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Agile Ancient Platemail of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Ancient Platemail of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Agile Ancient Platemail of Fortitude Spikes");
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
      else if ((e.getCurrentItem().getType() == Material.DIAMOND_LEGGINGS) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int wepdrop = random.nextInt(2) + 1;
        int thorns = random.nextInt(12) + 1;
        int block = random.nextInt(12) + 1;
        int dodge = random.nextInt(12) + 1;
        int reflect = random.nextInt(5) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(16) + 60;
        int vit = random.nextInt(91) + 60;
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Platemail Leggings");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Agile Ancient Platemail Leggings");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Platemail Leggings of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Ancient Platemail Leggings");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Mending Agile Ancient Platemail Leggings");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Platemail Leggings of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Mending Agile Ancient Platemail Leggings of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Agile Ancient Platemail Leggings");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Ancient Platemail Leggings");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Ancient Platemail Leggings of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Agile Ancient Platemail Leggings of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Ancient Platemail Leggings of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Agile Ancient Platemail Leggings of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Platemail Leggings of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Agile Ancient Platemail Leggings of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Ancient Platemail Leggings of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Ancient Platemail Leggings of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Agile Ancient Platemail Leggings of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Platemail Leggings of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Agile Ancient Platemail Leggings of Spikes of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Agile Ancient Platemail Leggings of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Ancient Platemail Leggings of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Ancient Platemail Leggings of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Agile Ancient Platemail Leggings of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Ancient Platemail Leggings of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Agile Ancient Platemail Leggings of Fortitude Spikes");
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
      else if ((e.getCurrentItem().getType() == Material.DIAMOND_BOOTS) && 
        (e.getCurrentItem().getItemMeta().getLore() != null))
      {
        e.setCancelled(true);
        Random random = new Random();
        int wepdrop = random.nextInt(2) + 1;
        int block = random.nextInt(12) + 1;
        int reflect = random.nextInt(5) + 1;
        int thorns = random.nextInt(12) + 1;
        int dodge = random.nextInt(12) + 1;
        int rand = random.nextInt(13) + 1;
        int regen = random.nextInt(16) + 60;
        int vit = random.nextInt(91) + 60;
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Platemail Boots");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Agile Ancient Platemail Boots");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Platemail Boots of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Ancient Platemail Boots");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Mending Agile Ancient Platemail Boots");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Platemail Boots of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Mending Agile Ancient Platemail Boots of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Agile Ancient Platemail Boots");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Ancient Platemail Boots");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Ancient Platemail Boots of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Mending Agile Ancient Platemail Boots of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Ancient Platemail Boots of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Mending Agile Ancient Platemail Boots of Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Platemail Boots of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Agile Ancient Platemail Boots of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + ChatColor.LIGHT_PURPLE + 
            "Ancient Platemail Boots of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Ancient Platemail Boots of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Agile Ancient Platemail Boots of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Platemail Boots of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Agile Ancient Platemail Boots of Spikes of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Agile Ancient Platemail Boots of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Ancient Platemail Boots of Fortitude");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Ancient Platemail Boots of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Reflective Agile Ancient Platemail Boots of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Ancient Platemail Boots of Fortitude Spikes");
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
          ItemStack H = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(plus + 
            ChatColor.LIGHT_PURPLE + 
            "Protective Reflective Agile Ancient Platemail Boots of Fortitude Spikes");
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