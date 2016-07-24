 package me.cazza.PracticeServer;
 
 import java.util.Arrays;
 import java.util.Random;
 import org.bukkit.ChatColor;
 import org.bukkit.Material;
 import org.bukkit.World;
 import org.bukkit.block.Block;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.block.BlockBreakEvent;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.potion.PotionEffect;
 import org.bukkit.potion.PotionEffectType;
 import org.bukkit.scheduler.BukkitRunnable;
 
 public class Mining
   implements Listener
 {
   public Main plugin;
   
   public Mining(Main plugin)
   {
     this.plugin = plugin;
   }
   
   @EventHandler
   public void onInteract(PlayerInteractEvent e)
   {
     Player p = e.getPlayer();
     if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
       (p.getItemInHand().getType() == Material.GOLD_PICKAXE)) {
       if (e.getClickedBlock().getType() == Material.IRON_ORE) {
         p.addPotionEffect(new PotionEffect(
           PotionEffectType.SLOW_DIGGING, 40, 0), true);
       } else if (e.getClickedBlock().getType() == Material.DIAMOND_ORE) {
         p.addPotionEffect(new PotionEffect(
           PotionEffectType.SLOW_DIGGING, 80, 2), true);
       } else if (e.getClickedBlock().getType() == Material.GOLD_ORE) {
         p.addPotionEffect(new PotionEffect(
           PotionEffectType.SLOW_DIGGING, 160, 3), true);
       }
     }
   }
   
   @EventHandler
   public void onBreak(final BlockBreakEvent e)
   {
     Player p = e.getPlayer();
     if (p.getItemInHand().getType() != Material.GOLD_PICKAXE) {
       return;
     }
     if (e.getBlock().getType() == Material.IRON_ORE)
     {
       e.setCancelled(true);
       Random random = new Random();
       int amt = random.nextInt(9) + 8;
       ItemStack gem = new ItemStack(Material.EMERALD, amt);
       ItemMeta im = gem.getItemMeta();
       im.setDisplayName(ChatColor.WHITE.toString() + "Gem");
       im.setLore(Arrays.asList(new String[] {ChatColor.GRAY.toString() + 
         "The currency of Andalucia" }));
       gem.setItemMeta(im);
       p.getWorld().dropItemNaturally(e.getBlock().getLocation(), gem);
       p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
         "          Found " + amt + " GEM(s)");
       int treasure = random.nextInt(75) + 1;
       if (treasure == 1)
       {
         p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
           "          Found 1x " + ChatColor.LIGHT_PURPLE + 
           "Orb of Alteration" + ChatColor.YELLOW.toString() + 
           ChatColor.BOLD + " embedded in the ore");
         ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
         ItemMeta orbmeta = orb.getItemMeta();
         orbmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
           "Orb of Alteration");
         orbmeta.setLore(Arrays.asList(new String[] {ChatColor.GRAY.toString() + 
           "Randomizes stats of selected equipment." }));
         orb.setItemMeta(orbmeta);
         p.getWorld().dropItemNaturally(e.getBlock().getLocation(), orb);
       }
       else if (treasure == 2)
       {
         p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
           "          Found 1x " + ChatColor.WHITE.toString() + 
           ChatColor.BOLD + "Scroll:" + ChatColor.AQUA + 
           " Enchant Iron Armor" + ChatColor.YELLOW.toString() + 
           ChatColor.BOLD + " embedded in the ore");
         ItemStack scroll = new ItemStack(Material.EMPTY_MAP);
         ItemMeta scrollmeta = scroll.getItemMeta();
         scrollmeta.setDisplayName(ChatColor.WHITE.toString() + ChatColor.BOLD + 
           "Scroll:" + ChatColor.AQUA + " Enchant Iron Armor");
         scrollmeta
           .setLore(
           Arrays.asList(new String[] {
           ChatColor.RED + "+5% HP", 
           ChatColor.RED + "+5% HP REGEN", 
           ChatColor.GRAY.toString() + "   - OR -", 
           ChatColor.RED + "+5% VIT", 
           ChatColor.GRAY.toString() + 
           
           ChatColor.ITALIC + 
           "Armor will VANISH if enchant above +3 FAILS." }));
         scroll.setItemMeta(scrollmeta);
         p.getWorld().dropItemNaturally(e.getBlock().getLocation(), 
           scroll);
       }
       else if (treasure == 3)
       {
         p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
           "          Found 1x " + ChatColor.WHITE.toString() + 
           ChatColor.BOLD + "Scroll:" + ChatColor.AQUA + 
           " Enchant Iron Weapon" + ChatColor.YELLOW.toString() + 
           ChatColor.BOLD + " embedded in the ore");
         ItemStack scroll = new ItemStack(Material.EMPTY_MAP);
         ItemMeta scrollmeta = scroll.getItemMeta();
         scrollmeta.setDisplayName(ChatColor.WHITE.toString() + ChatColor.BOLD + 
           "Scroll:" + ChatColor.AQUA + " Enchant Iron Weapon");
         scrollmeta
           .setLore(
           Arrays.asList(new String[] {
           ChatColor.RED + "+5% DMG", 
           ChatColor.GRAY.toString() + 
           
           ChatColor.ITALIC + 
           "Weapon will VANISH if enchant above +3 FAILS." }));
         scroll.setItemMeta(scrollmeta);
         p.getWorld().dropItemNaturally(e.getBlock().getLocation(), 
           scroll);
       }
       e.getBlock().setType(Material.STONE);
       new BukkitRunnable()
       {
         public void run()
         {
           e.getBlock().setType(Material.IRON_ORE);
         }
       }.runTaskLater(this.plugin, 1200L);
       p.getItemInHand().setDurability((short)0);
       p.updateInventory();
     }
     else if (e.getBlock().getType() == Material.DIAMOND_ORE)
     {
       e.setCancelled(true);
       Random random = new Random();
       int amt = random.nextInt(17) + 16;
       ItemStack gem = new ItemStack(Material.EMERALD, amt);
       ItemMeta im = gem.getItemMeta();
       im.setDisplayName(ChatColor.WHITE.toString() + "Gem");
       im.setLore(Arrays.asList(new String[] {ChatColor.GRAY.toString() + 
         "The currency of Andalucia" }));
       gem.setItemMeta(im);
       p.getWorld().dropItemNaturally(e.getBlock().getLocation(), gem);
       int treasure = random.nextInt(75) + 1;
       if (treasure == 1)
       {
         p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
           "          Found 1x " + ChatColor.LIGHT_PURPLE + 
           "Orb of Alteration" + ChatColor.YELLOW.toString() + 
           ChatColor.BOLD + " embedded in the ore");
         ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
         ItemMeta orbmeta = orb.getItemMeta();
         orbmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
           "Orb of Alteration");
         orbmeta.setLore(Arrays.asList(new String[] {ChatColor.GRAY.toString() + 
           "Randomizes stats of selected equipment." }));
         orb.setItemMeta(orbmeta);
         p.getWorld().dropItemNaturally(e.getBlock().getLocation(), orb);
       }
       else if (treasure == 2)
       {
         p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
           "          Found 1x " + ChatColor.WHITE.toString() + 
           ChatColor.BOLD + "Scroll:" + ChatColor.LIGHT_PURPLE + 
           " Enchant Diamond Armor" + ChatColor.YELLOW.toString() + 
           ChatColor.BOLD + " embedded in the ore");
         ItemStack scroll = new ItemStack(Material.EMPTY_MAP);
         ItemMeta scrollmeta = scroll.getItemMeta();
         scrollmeta.setDisplayName(ChatColor.WHITE.toString() + ChatColor.BOLD + 
           "Scroll:" + ChatColor.LIGHT_PURPLE + 
           " Enchant Diamond Armor");
         scrollmeta
           .setLore(
           Arrays.asList(new String[] {
           ChatColor.RED + "+5% HP", 
           ChatColor.RED + "+5% HP REGEN", 
           ChatColor.GRAY.toString() + "   - OR -", 
           ChatColor.RED + "+5% VIT", 
           ChatColor.GRAY.toString() + 
           
           ChatColor.ITALIC + 
           "Armor will VANISH if enchant above +3 FAILS." }));
         scroll.setItemMeta(scrollmeta);
         p.getWorld().dropItemNaturally(e.getBlock().getLocation(), 
           scroll);
       }
       else if (treasure == 3)
       {
         p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
           "          Found 1x " + ChatColor.WHITE.toString() + 
           ChatColor.BOLD + "Scroll:" + ChatColor.LIGHT_PURPLE + 
           " Enchant Diamond Weapon" + ChatColor.YELLOW.toString() + 
           ChatColor.BOLD + " embedded in the ore");
         ItemStack scroll = new ItemStack(Material.EMPTY_MAP);
         ItemMeta scrollmeta = scroll.getItemMeta();
         scrollmeta.setDisplayName(ChatColor.WHITE.toString() + ChatColor.BOLD + 
           "Scroll:" + ChatColor.LIGHT_PURPLE + 
           " Enchant Diamond Weapon");
         scrollmeta
           .setLore(
           Arrays.asList(new String[] {
           ChatColor.RED + "+5% DMG", 
           ChatColor.GRAY.toString() + 
           
           ChatColor.ITALIC + 
           "Weapon will VANISH if enchant above +3 FAILS." }));
         scroll.setItemMeta(scrollmeta);
         p.getWorld().dropItemNaturally(e.getBlock().getLocation(), 
           scroll);
       }
       p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
         "          Found " + amt + " GEM(s)");
       e.getBlock().setType(Material.STONE);
       new BukkitRunnable()
       {
         public void run()
         {
           e.getBlock().setType(Material.DIAMOND_ORE);
         }
       }.runTaskLater(this.plugin, 2400L);
       p.getItemInHand().setDurability((short)0);
       p.updateInventory();
     }
     else if (e.getBlock().getType() == Material.GOLD_ORE)
     {
       e.setCancelled(true);
       Random random = new Random();
       int fail = random.nextInt(4) + 1;
       if (fail == 1)
       {
         p.sendMessage(ChatColor.GRAY.toString() + ChatColor.ITALIC + 
           "You failed to find any gems.");
       }
       else
       {
         int amt = random.nextInt(17) + 32;
         ItemStack gem = new ItemStack(Material.EMERALD, amt);
         ItemMeta im = gem.getItemMeta();
         im.setDisplayName(ChatColor.WHITE.toString() + "Gem");
         im.setLore(Arrays.asList(new String[] {ChatColor.GRAY.toString() + 
           "The currency of Andalucia" }));
         gem.setItemMeta(im);
         p.getWorld().dropItemNaturally(e.getBlock().getLocation(), gem);
         p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
           "          Found " + amt + " GEM(s)");
         int treasure = random.nextInt(75) + 1;
         if (treasure == 1)
         {
           p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
             "          Found 1x " + ChatColor.LIGHT_PURPLE + 
             "Orb of Alteration" + ChatColor.YELLOW.toString() + 
             ChatColor.BOLD + " embedded in the ore");
           ItemStack orb = new ItemStack(Material.MAGMA_CREAM);
           ItemMeta orbmeta = orb.getItemMeta();
           orbmeta.setDisplayName(ChatColor.LIGHT_PURPLE + 
             "Orb of Alteration");
           orbmeta.setLore(Arrays.asList(new String[] {ChatColor.GRAY.toString() + 
             "Randomizes stats of selected equipment." }));
           orb.setItemMeta(orbmeta);
           p.getWorld().dropItemNaturally(e.getBlock().getLocation(), 
             orb);
         }
         else if (treasure == 2)
         {
           p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
             "          Found 1x " + ChatColor.WHITE.toString() + 
             ChatColor.BOLD + "Scroll:" + ChatColor.YELLOW.toString() + 
             " Enchant Gold Armor" + ChatColor.YELLOW.toString() + 
             ChatColor.BOLD + " embedded in the ore");
           ItemStack scroll = new ItemStack(Material.EMPTY_MAP);
           ItemMeta scrollmeta = scroll.getItemMeta();
           scrollmeta.setDisplayName(ChatColor.WHITE.toString() + 
             ChatColor.BOLD + "Scroll:" + ChatColor.YELLOW.toString() + 
             " Enchant Gold Armor");
           scrollmeta
             .setLore(
             Arrays.asList(new String[] {
             ChatColor.RED + "+5% HP", 
             ChatColor.RED + "+5% HP REGEN", 
             ChatColor.GRAY.toString() + "   - OR -", 
             ChatColor.RED + "+5% VIT", 
             ChatColor.GRAY.toString() + 
             
             ChatColor.ITALIC + 
             "Armor will VANISH if enchant above +3 FAILS." }));
           scroll.setItemMeta(scrollmeta);
           p.getWorld().dropItemNaturally(e.getBlock().getLocation(), 
             scroll);
         }
         else if (treasure == 3)
         {
           p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + 
             "          Found 1x " + ChatColor.WHITE.toString() + 
             ChatColor.BOLD + "Scroll:" + ChatColor.YELLOW.toString() + 
             " Enchant Gold Weapon" + ChatColor.YELLOW.toString() + 
             ChatColor.BOLD + " embedded in the ore");
           ItemStack scroll = new ItemStack(Material.EMPTY_MAP);
           ItemMeta scrollmeta = scroll.getItemMeta();
           scrollmeta.setDisplayName(ChatColor.WHITE.toString() + ChatColor.BOLD + 
             "Scroll:" + ChatColor.YELLOW.toString() + 
             " Enchant Gold Weapon");
           scrollmeta
             .setLore(
             Arrays.asList(new String[] {
             ChatColor.RED + "+5% DMG", 
             ChatColor.GRAY.toString() + ChatColor.ITALIC + 
             "Weapon will VANISH if enchant above +3 FAILS." }));
           scroll.setItemMeta(scrollmeta);
           p.getWorld().dropItemNaturally(e.getBlock().getLocation(), 
             scroll);
         }
       }
       e.getBlock().setType(Material.STONE);
       new BukkitRunnable()
       {
         public void run()
         {
           e.getBlock().setType(Material.GOLD_ORE);
         }
       }.runTaskLater(this.plugin, 6000L);
       p.getItemInHand().setDurability((short)0);
       p.updateInventory();
     }
   }
 }