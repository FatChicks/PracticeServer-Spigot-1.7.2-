package me.cazza.PracticeServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mobdrops
  implements Listener
{
  public static Main plugin;
  
  public Mobdrops(Main m)
  {
    plugin = m;
  }
  
  @EventHandler
  public void onMobDeath(EntityDeathEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      e.getDrops().clear();
    }
    e.setDroppedExp(0);
    if ((e.getEntity() instanceof Skeleton))
    {
      Skeleton s = (Skeleton)e.getEntity();
      if (s.getCustomName() == null) {
        return;
      }
      if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Infernal Skeleton"))
      {
        Random random = new Random();
        int drop;
        if(Listeners.drops.isEmpty()) {
        	drop = random.nextInt(220) + 1;
        } else {
        	drop = random.nextInt(200) + 1;
        }
        int t5block = random.nextInt(12) + 1;
        int t5dodge = random.nextInt(12) + 1;
        int helm = 0;
        int chest = 0;
        int min = 0;
        int max = 0;
        int regen = random.nextInt(21) + 90;
        String common = "";
        int vit = random.nextInt(161) + 150;
        int rarity = random.nextInt(80) + 1;
        int gems = random.nextInt(2) + 1;
        int stacks = random.nextInt(2) + 1;
        int amt = random.nextInt(17) + 16;
        int lore = random.nextInt(5) + 1;
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
        int vitr = random.nextInt(7) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(16) + 1;
        int vsm = random.nextInt(16) + 1;
        if (gems == 1)
        {
          for (int i = 0; i < stacks; i++)
          {
            ItemStack gem = new ItemStack(Material.EMERALD, 64);
            ItemMeta im = gem.getItemMeta();
            im.setDisplayName(ChatColor.WHITE + "Gem");
            im.setLore(Arrays.asList(new String[] {ChatColor.GRAY + 
              "The currency of Andalucia" }));
            gem.setItemMeta(im);
            e.getDrops().add(gem);
          }
          ItemStack gem = new ItemStack(Material.EMERALD, amt);
          ItemMeta im = gem.getItemMeta();
          im.setDisplayName(ChatColor.WHITE + "Gem");
          im.setLore(Arrays.asList(new String[] {ChatColor.GRAY + 
            "The currency of Andalucia" }));
          gem.setItemMeta(im);
          e.getDrops().add(gem);
        }
        if (rarity <= 22 || (rarity >= 34))
        {
          common = ChatColor.GRAY.toString() + ChatColor.ITALIC.toString() + "Common";
          helm = random.nextInt(300) + 700;
          chest = random.nextInt(1000) + 1500;
          min = random.nextInt(21) + 130;
          max = random.nextInt(199 - min + 1) + min;
        }
        else if ((rarity == 24) || (rarity == 25) || (rarity == 26) || (rarity == 23) || (rarity == 31) || (rarity == 32) || (rarity == 33))
        {
          common = 
            ChatColor.GREEN.toString() + ChatColor.ITALIC + "Uncommon";
          helm = random.nextInt(800) + 1000;
          chest = random.nextInt(1500) + 2500;
          min = random.nextInt(31) + 140;
          max = random.nextInt(280 - min + 10 + 1) + min + 10;
        }
        else if ((rarity == 27) || (rarity == 28) || (rarity == 29))
        {
          common = ChatColor.AQUA.toString() + ChatColor.ITALIC + "Rare";
          helm = random.nextInt(500) + 1800;
          chest = random.nextInt(1500) + 4000;
          min = random.nextInt(11) + 230;
          max = random.nextInt(180) + 240;
        }
        else if ((rarity == 30))
        {
          common = 
            ChatColor.YELLOW.toString() + ChatColor.ITALIC + "Unique";
          helm = random.nextInt(701) + 2300;
          chest = random.nextInt(501) + 5500;
          min = random.nextInt(51) + 230;
          max = random.nextInt(241) + 280;
        }
        if ((drop == 1) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: " + regen + " HP/s");
          hlore.add(ChatColor.RED + "BLOCK: " + t5block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: " + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: " + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: " + regen + " HP/s");
          hlore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Mending Legendary Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + t5block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 2) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: " + regen + " HP/s");
          clore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: " + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 3))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: " + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 4))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: " + regen + " HP/s");
          clore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 5))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          clore.add(ChatColor.RED + "BLOCK: " + t5block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 3) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 3))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 4))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 5))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          llore.add(ChatColor.RED + "BLOCK: " + t5block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 4) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 3))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 4))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 5))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          blore.add(ChatColor.RED + "BLOCK: " + t5block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 5) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 3))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 4))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 5))
        {
          ItemStack H = new ItemStack(Material.GOLD_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Mending Legendary Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + t5block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 6) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 3))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 4))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 5))
        {
          ItemStack C = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta
            .setDisplayName(ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          clore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 7) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 3))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 4))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 5))
        {
          ItemStack L = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 16 - 16%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          llore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 8) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 3))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Mending Legendary Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 4))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Legendary Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "BLOCK: " + t5dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 5))
        {
          ItemStack B = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.YELLOW + 
            "Protective Mending Legendary Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + t5dodge + "%");
          blore.add(ChatColor.RED + "BLOCK: " + t5block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 9) || (drop == 10))
        {
          int pure = random.nextInt(3) + 1;
          int pen = random.nextInt(5) + 1;
          int pureamt = random.nextInt(31) + 25;
          int armorpen = random.nextInt(16) + 1;
          ItemStack GA = new ItemStack(Material.GOLD_AXE);
          ItemMeta gameta = GA.getItemMeta();
          String wname = ChatColor.YELLOW + "Legendary Axe";
          String plus = ChatColor.YELLOW.toString();
          List<String> galore = new ArrayList();
          galore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          if (str == 1) {
            galore.add(ChatColor.RED + "STR: +" + str2);
          }
          if (blindrand <= 4)
          {
            galore.add(ChatColor.RED + "BLIND: " + blind + "%");
            wname = wname + " of Blindness";
          }
          if (pure == 1)
          {
            galore.add(ChatColor.RED + "PURE DMG: +" + pureamt);
            wname = "Pure " + wname;
          }
          if (pen == 1)
          {
            galore.add(ChatColor.RED + "ARMOR PENETRATION: " + 
              armorpen + "%");
            wname = "Penetrating " + wname;
          }
          if (life == 1)
          {
            galore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + 
              "%");
            wname = "Vampyric " + wname;
          }
          if (crit == 1)
          {
            galore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
              "%");
            wname = "Deadly " + wname;
          }
          if (vs == 1)
          {
            galore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
            wname = wname + " of Slaying";
          }
          if (vs == 2)
          {
            galore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
            wname = wname + " of Slaughter";
          }
          if ((elem == 3) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            wname = wname + " of Ice";
          }
          else if ((elem == 3) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            wname = wname + " Ice";
          }
          else if ((elem == 3) && (vs == 1))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            wname = wname + " Ice";
          }
          else if ((elem == 3) && (vs == 2))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            wname = wname + " Ice";
          }
          if ((elem == 2) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            wname = wname + " of Poison";
          }
          else if ((elem == 2) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            wname = wname + " Poison";
          }
          else if ((elem == 2) && (vs == 1))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            wname = wname + " Poison";
          }
          else if ((elem == 2) && (vs == 2))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            wname = wname + " Poison";
          }
          if ((elem == 1) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            wname = wname + " of Fire";
          }
          else if ((elem == 1) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            wname = wname + " Fire";
          }
          else if ((elem == 1) && (vs == 1))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            wname = wname + " Fire";
          }
          else if ((elem == 1) && (vs == 2))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            wname = wname + " Fire";
          }
          gameta.setDisplayName(plus + wname);
          galore.add(common);
          gameta.setLore(galore);
          GA.setItemMeta(gameta);
          e.getDrops().add(GA);
        }
        if ((drop == 11) || (drop == 12))
        {
          ItemStack S = new ItemStack(Material.GOLD_SWORD);
          ItemMeta swordmeta = S.getItemMeta();
          String sname = ChatColor.YELLOW + "Legendary Sword";
          String plus = ChatColor.YELLOW.toString();
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          if (vitr == 1) {
            slore.add(ChatColor.RED + "VIT: +" + vit2);
          }
          if (blindrand <= 4)
          {
            slore.add(ChatColor.RED + "BLIND: " + blind + "%");
            sname = sname + " of Blindness";
          }
          if (life == 1)
          {
            slore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + 
              "%");
            sname = "Vampyric " + sname;
          }
          if (crit == 1)
          {
            slore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
              "%");
            sname = "Deadly " + sname;
          }
          if (vs == 1)
          {
            slore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
            sname = sname + " of Slaying";
          }
          if (vs == 2)
          {
            slore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
            sname = sname + " of Slaughter";
          }
          if ((elem == 3) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " of Ice";
          }
          else if ((elem == 3) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          else if ((elem == 3) && (vs == 1))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          else if ((elem == 3) && (vs == 2))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          if ((elem == 2) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " of Poison";
          }
          else if ((elem == 2) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          else if ((elem == 2) && (vs == 1))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          else if ((elem == 2) && (vs == 2))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          if ((elem == 1) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " of Fire";
          }
          else if ((elem == 1) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          else if ((elem == 1) && (vs == 1))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          else if ((elem == 1) && (vs == 2))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          slore.add(common);
          swordmeta.setDisplayName(plus + sname);
          swordmeta.setLore(slore);
          S.setItemMeta(swordmeta);
          e.getDrops().add(S);
        }
      }
      else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Skeleton Guardian"))
      {
        Random random = new Random();
        int t4block = random.nextInt(6) + 1;
        int t4dodge = random.nextInt(6) + 1;
        int helm = 0;
        int chest = 0;
        int min = 0;
        int max = 0;
        int regen = random.nextInt(6) + 60;
        int vit = random.nextInt(91) + 60;
        String common = "";
        int rarity = random.nextInt(35) + 1;
        int gems = random.nextInt(2) + 1;
        int amt = random.nextInt(33) + 32;
        int lore = random.nextInt(5) + 1;
        int elemamt = random.nextInt(11) + 10;
        int vit2 = random.nextInt(151) + 1;
        int str2 = random.nextInt(151) + 1;
        int dex2 = random.nextInt(151) + 1;
        int pureamt = random.nextInt(11) + 10;
        int lifeamt = random.nextInt(13) + 1;
        int critamt = random.nextInt(6) + 1;
        int blind = random.nextInt(12) + 1;
        int blindrand = random.nextInt(13) + 1;
        int elem = random.nextInt(12) + 1;
        int life = random.nextInt(4) + 1;
        int crit = random.nextInt(4) + 1;
        int dex = random.nextInt(7) + 1;
        int str = random.nextInt(7) + 1;
        int vitr = random.nextInt(7) + 1;
        int pure = random.nextInt(4) + 1;
        int pen = random.nextInt(5) + 1;
        int armorpen = random.nextInt(9) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(20) + 1;
        int vsm = random.nextInt(20) + 1;
        int drop;
        if(Listeners.drops.isEmpty()) {
        	drop = random.nextInt(120) + 1;
        } else {
        	drop = random.nextInt(100) + 1;
        }
        if (gems == 1)
        {
          ItemStack gem = new ItemStack(Material.EMERALD, amt);
          ItemMeta im = gem.getItemMeta();
          im.setDisplayName(ChatColor.WHITE + "Gem");
          im.setLore(Arrays.asList(new String[] {ChatColor.GRAY + 
            "The currency of Andalucia" }));
          gem.setItemMeta(im);
          e.getDrops().add(gem);
        }
        if (rarity <= 28)
        {
          common = ChatColor.GRAY.toString() + ChatColor.ITALIC.toString() + "Common";
          helm = random.nextInt(200) + 300;
          chest = random.nextInt(200) + 600;
          min = random.nextInt(21) + 60;
          max = random.nextInt(99 - min + 1) + min;
        }
        else if ((rarity == 29) || (rarity == 30) || (rarity == 31) || 
          (rarity == 32))
        {
          common = 
            ChatColor.GREEN.toString() + ChatColor.ITALIC + "Uncommon";
          helm = random.nextInt(200) + 500;
          chest = random.nextInt(700) + 800;
          min = random.nextInt(26) + 65;
          max = random.nextInt(21) + 100;
        }
        else if ((rarity == 33) || (rarity == 34))
        {
          common = ChatColor.AQUA.toString() + ChatColor.ITALIC + "Rare";
          helm = random.nextInt(300) + 700;
          chest = random.nextInt(800) + 1500;
          min = random.nextInt(21) + 80;
          max = random.nextInt(79) + 121;
        }
        else if (rarity == 35)
        {
          common = 
            ChatColor.YELLOW.toString() + ChatColor.ITALIC + "Unique";
          helm = random.nextInt(201) + 1000;
          chest = random.nextInt(201) + 2300;
          min = random.nextInt(51) + 100;
          max = random.nextInt(51) + 200;
        }
        if ((drop == 1) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "BLOCK: " + t4dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "BLOCK: " + t4dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 3))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + t4dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 4))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + t4dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 5))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + t4dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 2) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 3))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 4))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 5))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Mending Magic Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + t4dodge + "%");
          clore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 3) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 3))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 4))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 5))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Mending Magic Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + t4dodge + "%");
          llore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 4) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 3))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 4))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 5))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Mending Magic Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          blore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 5) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 3))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Ancient Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 4))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Ancient Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 5))
        {
          ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Mending Ancient Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 6) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 3))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 4))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 5))
        {
          ItemStack C = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta
            .setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Mending Magic Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "DODGE: " + t4dodge + "%");
          clore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 7) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 3))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 4))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 5))
        {
          ItemStack L = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Mending Magic Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 11 - 11%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + t4dodge + "%");
          llore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 8) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 3))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Mending Magic Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 4))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Magic Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 5))
        {
          ItemStack B = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
            "Protective Mending Magic Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 6 - 6%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + t4dodge + "%");
          blore.add(ChatColor.RED + "BLOCK: " + t4block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 9) || (drop == 10))
        {
          ItemStack GA = new ItemStack(Material.DIAMOND_AXE);
          ItemMeta gameta = GA.getItemMeta();
          String wname = ChatColor.LIGHT_PURPLE + "Ancient Axe";
          String plus = ChatColor.LIGHT_PURPLE.toString();
          List<String> galore = new ArrayList();
          galore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          if (str == 1) {
            galore.add(ChatColor.RED + "STR: +" + str2);
          }
          if (pure == 1)
          {
            galore.add(ChatColor.RED + "PURE DMG: +" + pureamt);
            wname = "Pure " + wname;
          }
          if (blindrand <= 4)
          {
            galore.add(ChatColor.RED + "BLIND: " + blind + "%");
            wname = wname + " of Blindness";
          }
          if (pen == 1)
          {
            galore.add(ChatColor.RED + "ARMOR PENETRATION: " + 
              armorpen + "%");
            wname = "Penetrating " + wname;
          }
          if (life == 1)
          {
            galore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + 
              "%");
            wname = "Vampyric " + wname;
          }
          if (crit == 1)
          {
            galore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
              "%");
            wname = "Deadly " + wname;
          }
          if (vs == 1)
          {
            galore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
            wname = wname + " of Slaying";
          }
          if (vs == 2)
          {
            galore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
            wname = wname + " of Slaughter";
          }
          if ((elem == 3) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            wname = wname + " of Ice";
          }
          else if ((elem == 3) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            wname = wname + " Ice";
          }
          else if ((elem == 3) && (vs == 1))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            wname = wname + " Ice";
          }
          else if ((elem == 3) && (vs == 2))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            wname = wname + " Ice";
          }
          if ((elem == 2) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            wname = wname + " of Poison";
          }
          else if ((elem == 2) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            wname = wname + " Poison";
          }
          else if ((elem == 2) && (vs == 1))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            wname = wname + " Poison";
          }
          else if ((elem == 2) && (vs == 2))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            wname = wname + " Poison";
          }
          if ((elem == 1) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            wname = wname + " of Fire";
          }
          else if ((elem == 1) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            wname = wname + " Fire";
          }
          else if ((elem == 1) && (vs == 1))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            wname = wname + " Fire";
          }
          else if ((elem == 1) && (vs == 2))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            wname = wname + " Fire";
          }
          galore.add(common);
          gameta.setDisplayName(plus + wname);
          gameta.setLore(galore);
          GA.setItemMeta(gameta);
          e.getDrops().add(GA);
        }
        if ((drop == 11) || (drop == 12))
        {
          ItemStack S = new ItemStack(Material.DIAMOND_SWORD);
          ItemMeta swordmeta = S.getItemMeta();
          String sname = ChatColor.LIGHT_PURPLE + "Ancient Sword";
          String plus = ChatColor.LIGHT_PURPLE.toString();
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          if (vitr == 1) {
            slore.add(ChatColor.RED + "VIT: +" + vit2);
          }
          if (blindrand <= 4)
          {
            slore.add(ChatColor.RED + "BLIND: " + blind + "%");
            sname = sname + " of Blindness";
          }
          if (life == 1)
          {
            slore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + 
              "%");
            sname = "Vampyric " + sname;
          }
          if (crit == 1)
          {
            slore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
              "%");
            sname = "Deadly " + sname;
          }
          if (vs == 1)
          {
            slore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
            sname = sname + " of Slaying";
          }
          if (vs == 2)
          {
            slore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
            sname = sname + " of Slaughter";
          }
          if ((elem == 3) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " of Ice";
          }
          else if ((elem == 3) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          else if ((elem == 3) && (vs == 1))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          else if ((elem == 3) && (vs == 2))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          if ((elem == 2) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " of Poison";
          }
          else if ((elem == 2) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          else if ((elem == 2) && (vs == 1))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          else if ((elem == 2) && (vs == 2))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          if ((elem == 1) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " of Fire";
          }
          else if ((elem == 1) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          else if ((elem == 1) && (vs == 1))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          else if ((elem == 1) && (vs == 2))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          slore.add(common);
          swordmeta.setLore(slore);
          swordmeta.setDisplayName(plus + sname);
          S.setItemMeta(swordmeta);
          e.getDrops().add(S);
        }
      }
      else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Mountain Bandit"))
      {
        Random random = new Random();
        int drop;
        if(Listeners.drops.isEmpty()) {
        	drop = random.nextInt(65) + 1;
        } else {
        	drop = random.nextInt(50) + 1;
        }
        int block = random.nextInt(7) + 1;
        int dodge = random.nextInt(7) + 1;
        int helm = 0;
        int chest = 0;
        int min = 0;
        int max = 0;
        int regen = random.nextInt(11) + 40;
        int vit = random.nextInt(41) + 20;
        String common = "";
        int rarity = random.nextInt(30) + 1;
        int gems = random.nextInt(2) + 1;
        int amt = random.nextInt(17) + 16;
        int lore = random.nextInt(5) + 1;
        int elemamt = random.nextInt(6) + 5;
        int vit2 = random.nextInt(81) + 1;
        int str2 = random.nextInt(81) + 1;
        int dex2 = random.nextInt(81) + 1;
        int pureamt = random.nextInt(6) + 5;
        int lifeamt = random.nextInt(11) + 1;
        int critamt = random.nextInt(6) + 1;
        int blind = random.nextInt(12) + 1;
        int blindrand = random.nextInt(13) + 1;
        int elem = random.nextInt(12) + 1;
        int life = random.nextInt(4) + 1;
        int crit = random.nextInt(4) + 1;
        int dex = random.nextInt(7) + 1;
        int str = random.nextInt(7) + 1;
        int vitr = random.nextInt(7) + 1;
        int pure = random.nextInt(4) + 1;
        int pen = random.nextInt(5) + 1;
        int armorpen = random.nextInt(9) + 1;
        int vs = random.nextInt(7) + 1;
        int vsp = random.nextInt(11) + 1;
        int vsm = random.nextInt(11) + 1;
        if (gems == 1)
        {
          ItemStack gem = new ItemStack(Material.EMERALD, amt);
          ItemMeta im = gem.getItemMeta();
          im.setDisplayName(ChatColor.WHITE + "Gem");
          im.setLore(Arrays.asList(new String[] {ChatColor.GRAY + 
            "The currency of Andalucia" }));
          gem.setItemMeta(im);
          e.getDrops().add(gem);
        }
        if (rarity <= 23)
        {
          common = ChatColor.GRAY.toString() + ChatColor.ITALIC.toString() + "Common";
          helm = random.nextInt(100) + 100;
          chest = random.nextInt(150) + 200;
          min = random.nextInt(8) + 25;
          max = random.nextInt(49 - min + 1) + min;
        }
        else if ((rarity == 24) || (rarity == 25) || (rarity == 26) || 
          (rarity == 27))
        {
          common = 
            ChatColor.GREEN.toString() + ChatColor.ITALIC + "Uncommon";
          helm = random.nextInt(100) + 200;
          chest = random.nextInt(150) + 350;
          min = random.nextInt(10) + 30;
          max = random.nextInt(31) + 40;
        }
        else if ((rarity == 28) || (rarity == 29))
        {
          common = ChatColor.AQUA.toString() + ChatColor.ITALIC + "Rare";
          helm = random.nextInt(50) + 300;
          chest = random.nextInt(300) + 500;
          min = random.nextInt(11) + 35;
          max = random.nextInt(30) + 71;
        }
        else if (rarity == 30)
        {
          common = ChatColor.YELLOW.toString() + ChatColor.ITALIC + "Unique";
          helm = random.nextInt(81) + 350;
          chest = random.nextInt(51) + 800;
          min = random.nextInt(6) + 45;
          max = random.nextInt(51) + 100;
        }
        if ((drop == 1) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Mending Full Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 2) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Mending Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 8 - 8%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 3))
        {
          ItemStack C = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 8 - 8%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 4))
        {
          ItemStack C = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 5))
        {
          ItemStack C = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Mending Platemail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          clore.add(ChatColor.RED + "BLOCK: " + block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 3) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 3))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 4))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 5))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Mending Platemail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          llore.add(ChatColor.RED + "BLOCK: " + block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 4) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 3))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 4))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 5))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Mending Platemail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          blore.add(ChatColor.RED + "BLOCK: " + block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 5) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 3))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 4))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 5))
        {
          ItemStack H = new ItemStack(Material.IRON_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Full Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(ChatColor.RED + "DODGE: " + dodge + "%");
          hlore.add(ChatColor.RED + "BLOCK: " + block + "%");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 6) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 8 - 8%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(ChatColor.RED + "BLOCK: " + block + "%");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 7) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "BLOCK: " + block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 3))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 4))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "BLOCK: " + block + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 5))
        {
          ItemStack L = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Mending Platemail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 8 - 8%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(ChatColor.RED + "DODGE: " + block + "%");
          llore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 8) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "BLOCK: " + block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 3))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Mending Platemail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 4))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "BLOCK: " + block + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 5))
        {
          ItemStack B = new ItemStack(Material.IRON_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.AQUA + 
            "Protective Mending Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 4 - 4%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(ChatColor.RED + "DODGE: " + block + "%");
          blore.add(ChatColor.RED + "BLOCK: " + dodge + "%");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 9) || (drop == 10))
        {
          ItemStack GA = new ItemStack(Material.IRON_AXE);
          ItemMeta gameta = GA.getItemMeta();
          String gname = ChatColor.AQUA + "War Axe";
          String plus = ChatColor.AQUA.toString();
          List<String> galore = new ArrayList();
          galore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          if (str == 1) {
            galore.add(ChatColor.RED + "STR: +" + str2);
          }
          if (pure == 1)
          {
            galore.add(ChatColor.RED + "PURE DMG: +" + pureamt);
            gname = "Pure " + gname;
          }
          if (blindrand <= 4)
          {
            galore.add(ChatColor.RED + "BLIND: " + blind + "%");
            gname = gname + " of Blindness";
          }
          if (pen == 1)
          {
            galore.add(ChatColor.RED + "ARMOR PENETRATION: " + 
              armorpen + "%");
            gname = "Penetrating " + gname;
          }
          if (life == 1)
          {
            galore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + 
              "%");
            gname = "Vampyric " + gname;
          }
          if (crit == 1)
          {
            galore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
              "%");
            gname = "Deadly " + gname;
          }
          if (vs == 1)
          {
            galore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
            gname = gname + " of Slaying";
          }
          if (vs == 2)
          {
            galore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
            gname = gname + " of Slaughter";
          }
          if ((elem == 3) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            gname = gname + " of Ice";
          }
          else if ((elem == 3) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            gname = gname + " Ice";
          }
          else if ((elem == 3) && (vs == 1))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            gname = gname + " Ice";
          }
          else if ((elem == 3) && (vs == 2))
          {
            galore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            gname = gname + " Ice";
          }
          if ((elem == 2) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            gname = gname + " of Poison";
          }
          else if ((elem == 2) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            gname = gname + " Poison";
          }
          else if ((elem == 2) && (vs == 1))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            gname = gname + " Poison";
          }
          else if ((elem == 2) && (vs == 2))
          {
            galore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            gname = gname + " Poison";
          }
          if ((elem == 1) && (blindrand > 4))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            gname = gname + " of Fire";
          }
          else if ((elem == 1) && (blindrand <= 4))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            gname = gname + " Fire";
          }
          else if ((elem == 1) && (vs == 1))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            gname = gname + " Fire";
          }
          else if ((elem == 1) && (vs == 2))
          {
            galore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            gname = gname + " Fire";
          }
          galore.add(common);
          gameta.setLore(galore);
          gameta.setDisplayName(plus + gname);
          GA.setItemMeta(gameta);
          e.getDrops().add(GA);
        }
        if ((drop == 11) || (drop == 12))
        {
          ItemStack S = new ItemStack(Material.IRON_SWORD);
          ItemMeta swordmeta = S.getItemMeta();
          String sname = ChatColor.AQUA + "Magic Sword";
          String plus = ChatColor.AQUA.toString();
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          if (vitr == 1) {
            slore.add(ChatColor.RED + "VIT: +" + vit2);
          }
          if (blindrand <= 4)
          {
            slore.add(ChatColor.RED + "BLIND: " + blind + "%");
            sname = sname + " of Blindness";
          }
          if (life == 1)
          {
            slore.add(ChatColor.RED + "LIFE STEAL: " + lifeamt + 
              "%");
            sname = "Vampyric " + sname;
          }
          if (crit == 1)
          {
            slore.add(ChatColor.RED + "CRITICAL HIT: " + critamt + 
              "%");
            sname = "Deadly " + sname;
          }
          if (vs == 1)
          {
            slore.add(ChatColor.RED + "vs. PLAYERS: " + vsp + "%");
            sname = sname + " of Slaying";
          }
          if (vs == 2)
          {
            slore.add(ChatColor.RED + "vs. MONSTERS: " + vsm + "%");
            sname = sname + " of Slaughter";
          }
          if ((elem == 3) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " of Ice";
          }
          else if ((elem == 3) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          else if ((elem == 3) && (vs == 1))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          else if ((elem == 3) && (vs == 2))
          {
            slore.add(ChatColor.RED + "ICE DMG: +" + elemamt);
            sname = sname + " Ice";
          }
          if ((elem == 2) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " of Poison";
          }
          else if ((elem == 2) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          else if ((elem == 2) && (vs == 1))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          else if ((elem == 2) && (vs == 2))
          {
            slore.add(ChatColor.RED + "POISON DMG: +" + elemamt);
            sname = sname + " Poison";
          }
          if ((elem == 1) && (blindrand > 4))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " of Fire";
          }
          else if ((elem == 1) && (blindrand <= 4))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          else if ((elem == 1) && (vs == 1))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          else if ((elem == 1) && (vs == 2))
          {
            slore.add(ChatColor.RED + "FIRE DMG: +" + elemamt);
            sname = sname + " Fire";
          }
          slore.add(common);
          swordmeta.setLore(slore);
          swordmeta.setDisplayName(plus + sname);
          S.setItemMeta(swordmeta);
          e.getDrops().add(S);
        }
      }
      else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Old Bandit"))
      {
        Random random = new Random();
        int drop;
        if(Listeners.drops.isEmpty()) {
        	 drop = random.nextInt(40) + 1;
        } else {
        	 drop = random.nextInt(30) + 1;
        }
        int helm = 0;
        int chest = 0;
        int min = 0;
        int max = 0;
        int regen = random.nextInt(11) + 10;
        int vit = random.nextInt(6) + 5;
        String common = "";
        int rarity = random.nextInt(25) + 1;
        int gems = random.nextInt(2) + 1;
        int amt = random.nextInt(7) + 10;
        int lore = random.nextInt(2) + 1;
        if (gems == 1)
        {
          ItemStack gem = new ItemStack(Material.EMERALD, amt);
          ItemMeta im = gem.getItemMeta();
          im.setDisplayName(ChatColor.WHITE + "Gem");
          im.setLore(Arrays.asList(new String[] {ChatColor.GRAY + 
            "The currency of Andalucia" }));
          gem.setItemMeta(im);
          e.getDrops().add(gem);
        }
        if (rarity <= 17)
        {
          common = ChatColor.GRAY.toString() + ChatColor.ITALIC.toString() + "Common";
          helm = random.nextInt(13) + 32;
          chest = random.nextInt(40) + 60;
          min = random.nextInt(6) + 10;
          max = random.nextInt(20 - min + 1) + min;
        }
        else if ((rarity == 18) || (rarity == 19) || (rarity == 21) || (rarity == 22))
        {
          common = ChatColor.GREEN.toString() + ChatColor.ITALIC + "Uncommon";
          helm = random.nextInt(40) + 45;
          chest = random.nextInt(70) + 100;
          min = random.nextInt(6) + 15;
          max = random.nextInt(19) + 21;
        }
        else if ((rarity == 23) || (rarity == 24))
        {
          common = ChatColor.AQUA.toString() + ChatColor.ITALIC + "Rare";
          helm = random.nextInt(35) + 85;
          chest = random.nextInt(100) + 200;
          min = random.nextInt(7) + 24;
          max = random.nextInt(25) + 40;
        }
        else if (rarity == 25)
        {
          common = ChatColor.YELLOW.toString() + ChatColor.ITALIC + "Unique";
          helm = random.nextInt(31) + 120;
          chest = random.nextInt(101) + 300;
          min = random.nextInt(7) + 24;
          max = random.nextInt(6) + 65;
        }
        if ((drop == 1) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.CHAINMAIL_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.GREEN + 
            "Mending Medium Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 2 - 2%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.CHAINMAIL_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.GREEN + 
            "Mending Medium Helmet");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 2 - 2%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 2) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.GREEN + 
            "Mending Chainmail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 5 - 5%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.GREEN + 
            "Mending Chainmail");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 5 - 5%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 3) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.CHAINMAIL_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.GREEN + 
            "Mending Chainmail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 5 - 5%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.CHAINMAIL_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.GREEN + 
            "Mending Chainmail Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 5 - 5%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 4) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.CHAINMAIL_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.GREEN + 
            "Mending Chainmail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 2 - 2%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.CHAINMAIL_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.GREEN + 
            "Mending Chainmail Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 2 - 2%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 5) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.CHAINMAIL_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.GREEN + 
            "Medium Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 2 - 2%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.CHAINMAIL_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.GREEN + 
            "Medium Helmet of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 2 - 2%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 6) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.GREEN + 
            "Chainmail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 5 - 5%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.GREEN + 
            "Chainmail of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 5 - 5%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 7) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.CHAINMAIL_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.GREEN + 
            "Chainmail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 5 - 5%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.CHAINMAIL_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.GREEN + 
            "Chainmail Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 5 - 5%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 8) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.CHAINMAIL_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.GREEN + 
            "Chainmail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 2 - 2%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.CHAINMAIL_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.GREEN + 
            "Chainmail Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 2 - 2%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 9) || (drop == 10))
        {
          ItemStack GA = new ItemStack(Material.STONE_AXE);
          ItemMeta gameta = GA.getItemMeta();
          gameta.setDisplayName(ChatColor.GREEN + "Great Axe");
          List<String> galore = new ArrayList();
          galore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          galore.add(common);
          gameta.setLore(galore);
          GA.setItemMeta(gameta);
          e.getDrops().add(GA);
        }
        if ((drop == 11) || (drop == 12))
        {
          ItemStack S = new ItemStack(Material.STONE_SWORD);
          ItemMeta swordmeta = S.getItemMeta();
          swordmeta.setDisplayName(ChatColor.GREEN + "Broadsword");
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          slore.add(common);
          swordmeta.setLore(slore);
          S.setItemMeta(swordmeta);
          e.getDrops().add(S);
        }
      }
      else if (s.getCustomName().replaceAll("§7", "").replaceAll("§e", "").replaceAll("§c", "").replaceAll("§a", "").contains("Starving Bandit"))
      {
        Random random = new Random();
        int drop;
        if(Listeners.drops.isEmpty()) {
        	drop = random.nextInt(25) + 1;
        } else {
        	drop = random.nextInt(20) + 1;
        }
        int helm = 0;
        int chest = 0;
        int min = 0;
        int max = 0;
        int regen = random.nextInt(11) + 5;
        int vit = random.nextInt(5) + 1;
        String common = "";
        int rarity = random.nextInt(20) + 1;
        int gems = random.nextInt(2) + 1;
        int amt = random.nextInt(5) + 1;
        int lore = random.nextInt(2) + 1;
        if (gems == 1)
        {
          ItemStack gem = new ItemStack(Material.EMERALD, amt);
          ItemMeta im = gem.getItemMeta();
          im.setDisplayName(ChatColor.WHITE + "Gem");
          im.setLore(Arrays.asList(new String[] {ChatColor.GRAY + 
            "The currency of Andalucia" }));
          gem.setItemMeta(im);
          e.getDrops().add(gem);
        }
        if (rarity <= 14)
        {
          common = ChatColor.GRAY.toString() + ChatColor.ITALIC.toString() + "Common";
          helm = random.nextInt(5) + 5;
          chest = random.nextInt(11) + 10;
          min = random.nextInt(4) + 1;
          max = random.nextInt(5 - min + 1) + min;
        }
        else if ((rarity == 15) || (rarity == 16) || 
          (rarity == 17))
        {
          common = ChatColor.GREEN.toString() + ChatColor.ITALIC + "Uncommon";
          helm = random.nextInt(10) + 10;
          chest = random.nextInt(39) + 21;
          min = random.nextInt(2) + 3;
          max = random.nextInt(6 - min + 1) + min;
        }
        else if ((rarity == 18) || (rarity == 19))
        {
          common = ChatColor.AQUA.toString() + ChatColor.ITALIC + "Rare";
          helm = random.nextInt(30) + 20;
          chest = random.nextInt(50) + 50;
          min = random.nextInt(4) + 6;
          max = random.nextInt(12) + 9;
        }
        else if (rarity == 20)
        {
          common = ChatColor.YELLOW.toString() + ChatColor.ITALIC + "Unique";
          helm = random.nextInt(11) + 50;
          chest = random.nextInt(51) + 100;
          min = random.nextInt(2) + 9;
          max = random.nextInt(7) + 24;
        }
        if ((drop == 1) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.LEATHER_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.WHITE + 
            "Mending Leather Coif");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 1 - 1%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 1) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.LEATHER_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.WHITE + 
            "Mending Leather Coif");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 1 - 1%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 2) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.LEATHER_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.WHITE + 
            "Mending Leather Chestplate");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 1 - 1%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 2) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.LEATHER_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.WHITE + 
            "Mending Leather Chestplate");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 1 - 1%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 3) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.LEATHER_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.WHITE + 
            "Mending Leather Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 1 - 1%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 3) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.LEATHER_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.WHITE + 
            "Mending Leather Leggings");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 1 - 1%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 4) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.LEATHER_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.WHITE + 
            "Mending Leather Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 1 - 1%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 4) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.LEATHER_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.WHITE + 
            "Mending Leather Boots");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 1 - 1%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "HP REGEN: +" + regen + " HP/s");
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 5) && (lore == 1))
        {
          ItemStack H = new ItemStack(Material.LEATHER_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.WHITE + 
            "Leather Coif of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "DPS: 1 - 1%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 5) && (lore == 2))
        {
          ItemStack H = new ItemStack(Material.LEATHER_HELMET);
          ItemMeta helmmeta = H.getItemMeta();
          helmmeta.setDisplayName(ChatColor.WHITE + 
            "Leather Coif of Fortitude");
          List<String> hlore = new ArrayList();
          hlore.add(ChatColor.RED + "ARMOR: 1 - 1%");
          hlore.add(ChatColor.RED + "HP: +" + helm);
          hlore.add(ChatColor.RED + "VIT: +" + vit);
          hlore.add(common);
          helmmeta.setLore(hlore);
          H.setItemMeta(helmmeta);
          e.getDrops().add(H);
        }
        if ((drop == 6) && (lore == 1))
        {
          ItemStack C = new ItemStack(Material.LEATHER_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.WHITE + 
            "Leather Chestplate of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "DPS: 1 - 1%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 6) && (lore == 2))
        {
          ItemStack C = new ItemStack(Material.LEATHER_CHESTPLATE);
          ItemMeta chestmeta = C.getItemMeta();
          chestmeta.setDisplayName(ChatColor.WHITE + 
            "Leather Chestplate of Fortitude");
          List<String> clore = new ArrayList();
          clore.add(ChatColor.RED + "ARMOR: 1 - 1%");
          clore.add(ChatColor.RED + "HP: +" + chest);
          clore.add(ChatColor.RED + "VIT: +" + vit);
          clore.add(common);
          chestmeta.setLore(clore);
          C.setItemMeta(chestmeta);
          e.getDrops().add(C);
        }
        if ((drop == 7) && (lore == 1))
        {
          ItemStack L = new ItemStack(Material.LEATHER_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.WHITE + 
            "Leather Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "DPS: 1 - 1%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 7) && (lore == 2))
        {
          ItemStack L = new ItemStack(Material.LEATHER_LEGGINGS);
          ItemMeta legmeta = L.getItemMeta();
          legmeta.setDisplayName(ChatColor.WHITE + 
            "Leather Leggings of Fortitude");
          List<String> llore = new ArrayList();
          llore.add(ChatColor.RED + "ARMOR: 1 - 1%");
          llore.add(ChatColor.RED + "HP: +" + chest);
          llore.add(ChatColor.RED + "VIT: +" + vit);
          llore.add(common);
          legmeta.setLore(llore);
          L.setItemMeta(legmeta);
          e.getDrops().add(L);
        }
        if ((drop == 8) && (lore == 1))
        {
          ItemStack B = new ItemStack(Material.LEATHER_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.WHITE + 
            "Leather Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "DPS: 1 - 1%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 8) && (lore == 2))
        {
          ItemStack B = new ItemStack(Material.LEATHER_BOOTS);
          ItemMeta bootmeta = B.getItemMeta();
          bootmeta.setDisplayName(ChatColor.WHITE + 
            "Leather Boots of Fortitude");
          List<String> blore = new ArrayList();
          blore.add(ChatColor.RED + "ARMOR: 1 - 1%");
          blore.add(ChatColor.RED + "HP: +" + helm);
          blore.add(ChatColor.RED + "VIT: +" + vit);
          blore.add(common);
          bootmeta.setLore(blore);
          B.setItemMeta(bootmeta);
          e.getDrops().add(B);
        }
        if ((drop == 9) || (drop == 10))
        {
          ItemStack GA = new ItemStack(Material.WOOD_AXE);
          ItemMeta gameta = GA.getItemMeta();
          gameta.setDisplayName(ChatColor.WHITE + "Hatchet");
          List<String> galore = new ArrayList();
          galore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          galore.add(common);
          gameta.setLore(galore);
          GA.setItemMeta(gameta);
          e.getDrops().add(GA);
        }
        if ((drop == 11) || (drop == 12))
        {
          ItemStack S = new ItemStack(Material.WOOD_SWORD);
          ItemMeta swordmeta = S.getItemMeta();
          swordmeta.setDisplayName(ChatColor.WHITE + "Shortsword");
          List<String> slore = new ArrayList();
          slore.add(ChatColor.RED + "DMG: " + min + " - " + max);
          slore.add(common);
          swordmeta.setLore(slore);
          S.setItemMeta(swordmeta);
          e.getDrops().add(S);
        }
      }
    }
  }
}
