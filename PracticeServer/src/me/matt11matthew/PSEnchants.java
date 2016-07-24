package me.matt11matthew;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import me.cazza.PracticeServer.Listeners;
import me.cazza.PracticeServer.ParticleEffect;


public class PSEnchants implements Listener {
	
	public static ItemStack addProtection(ItemStack is) {
	    if (!is.hasItemMeta()) return is;
	    if (!is.getItemMeta().hasLore()) { return is;
	    }
	    ItemMeta im = is.getItemMeta();
	    List<String> lore = im.getLore();
	    lore.add(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "PROTECTED");
	    im.setLore(lore);
	    is.setItemMeta(im);
	    
	    return is;
  }
  
  public ItemStack enchantWeapon(ItemStack wep, int enchant_level) {
	    String old_name = wep.getItemMeta().getDisplayName();
	    if (old_name.contains("]"))
	    {
	      old_name = old_name.substring(old_name.indexOf("]") + 1, old_name.length());
	    }
	    
	    if (old_name.startsWith(" ")) {
	      old_name = old_name.substring(1, old_name.length());
	    }
	    
	    String new_name = ChatColor.RED + "[+" + enchant_level + "]" + " " + ChatColor.RESET + old_name;
	    double o_min_dmg = Listeners.getMinValueFromLore(wep, "DMG");
	    double o_max_dmg = Listeners.getMaxValueFromLore(wep, "DMG");
	    
	    double min_dmg = o_min_dmg + o_min_dmg * 0.05D;
	    double max_dmg = o_max_dmg + o_max_dmg * 0.05D;
	    
	    if (min_dmg - o_min_dmg < 1.0D) {
	      min_dmg += 1.0D;
	    }
	    
	    if (max_dmg - o_min_dmg < 1.0D) {
	      max_dmg += 1.0D;
	    }
	    
	    ItemMeta im = wep.getItemMeta();
	    
	    List<String> new_lore = new ArrayList();
	    
	    for (String s : im.getLore()) {
	      new_lore.add(s);
	    }
	    
	    new_lore.set(0, ChatColor.RED.toString() + "DMG: " + (int)min_dmg + " - " + (int)max_dmg);
	    
	    im.setDisplayName(new_name);
	    im.setLore(new_lore);
	    wep.setItemMeta(im);
	    
	    if (enchant_level >= 4)
	    {
	      addGlow(wep);
	    }
	    
	    return wep;
	  }
	  
	  public ItemStack enchantArmor(ItemStack arm, int enchant_level) {
	    String old_name = arm.getItemMeta().getDisplayName();
	    if (old_name.contains("]"))
	    {
	      old_name = old_name.substring(old_name.indexOf("]") + 1, old_name.length());
	    }
	    
	    if (old_name.startsWith(" ")) {
	      old_name = old_name.substring(1, old_name.length());
	    }
	    
	    String new_name = ChatColor.RED + "[+" + enchant_level + "]" + " " + ChatColor.RESET + old_name;
	    double o_hp_gain = Listeners.getValueFromLore(arm, "HP");
	    double hp_gain = o_hp_gain + o_hp_gain * 0.05D;
	    
	    if (hp_gain - o_hp_gain < 1.0D) {
	      hp_gain += 1.0D;
	    }
	    
	    ItemMeta im = arm.getItemMeta();
	    
	    List<String> new_lore = new ArrayList();
	    
	    for (String s : im.getLore()) {
	      new_lore.add(s);
	    }
	    
	    new_lore.set(1, ChatColor.RED.toString() + "HP: +" + (int)hp_gain);
	    
	    String regen_string = (String)new_lore.get(2);
	    if (regen_string.contains("HP REGEN")) {
	      double o_hp_regen = Double.parseDouble(regen_string.substring(regen_string.indexOf("+") + 1, regen_string.lastIndexOf(" ")));
	      double hp_regen = o_hp_regen + o_hp_regen * 0.05D;
	      if (hp_regen - o_hp_regen < 1.0D) {
	        hp_regen += 1.0D;
	      }
	      regen_string = regen_string.replace("+" + (int)o_hp_regen + " HP/s", "+" + (int)hp_regen + " HP/s");
	      new_lore.set(2, regen_string);
	    }
	    
	    im.setDisplayName(new_name);
	    im.setLore(new_lore);
	    arm.setItemMeta(im);
	    
	    if (enchant_level >= 4)
	    {
	      addGlow(arm);
	    }
	    
	    return arm;
	  }

	public static void addGlow(ItemStack arm) {
		arm.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 30);;
		
	}
	
	 @EventHandler
	  public void onScrollUse(InventoryClickEvent e)
	  {
	    if (e.getCursor() == null) return;
	    if (e.getCurrentItem() == null) return;
	    ItemStack cursor = e.getCursor();
	    ItemStack in_slot = e.getCurrentItem();
	    boolean win = true;
	    
	    if (!e.getInventory().getName().equalsIgnoreCase("container.crafting")) return;
	    if (e.getInventory().getViewers().size() > 1) return;
	    if (e.getSlotType() == org.bukkit.event.inventory.InventoryType.SlotType.ARMOR) { return;
	    }
	    Player p = (Player)e.getWhoClicked();
	    
	    if ((isWhiteScroll(cursor))  && ((isArmor(in_slot)) || (!(isWeapon(in_slot)))))
	    {

	      int cursor_tier = getItemTier(cursor);
	      int in_slot_tier = getItemTier(in_slot);
	      
	      if (cursor_tier != in_slot_tier) { return;
	      }
	      if (hasProtection(in_slot)) {
	        p.sendMessage(ChatColor.RED + "This item already has 'protected' enchantment status.");
	        e.setCancelled(true);
	        p.updateInventory();
	        return;
	      }
	      
	      if (cursor.getAmount() == 1) {
	        e.setCancelled(true);
	        e.setCursor(new ItemStack(Material.AIR));
	      } else if (cursor.getAmount() > 1) {
	        e.setCancelled(true);
	        cursor.setAmount(cursor.getAmount() - 1);
	        e.setCursor(cursor);
	      }
	      
	      e.setCurrentItem(addProtection(in_slot));
	      p.sendMessage(ChatColor.GREEN + "Your " + in_slot.getItemMeta().getDisplayName() + ChatColor.GREEN + " is now protected -- even if an enchant scroll fails, it will " + ChatColor.UNDERLINE + "NOT" + ChatColor.GREEN + " be destroyed up to +8 status.");
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	      
	      Firework fw = (Firework)p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
	      FireworkMeta fwm = fw.getFireworkMeta();
	      FireworkEffect effect = FireworkEffect.builder().flicker(false).withColor(Color.GREEN).withFade(Color.GREEN).with(FireworkEffect.Type.STAR).trail(true).build();
	      fwm.addEffect(effect);
	      fwm.setPower(0);
	      fw.setFireworkMeta(fwm);
	    }
	    
	    if ((isEnchantScroll(cursor)) && ((isArmor(in_slot)) || (!(isWeapon(in_slot)))))
	    {
	      if (!isCorrectScroll(cursor, in_slot)) { return;
	      }
	      boolean white_scroll = hasProtection(in_slot);
	      
	      int old_enchant = getEnchantCount(in_slot);
	      
	      if (old_enchant >= 12) {
	        p.sendMessage(ChatColor.RED + "This item is already enchanted +12, cannot apply more stats.");
	        e.setCancelled(true);
	        p.updateInventory();
	        return;
	      }
	      
	      if (cursor.getAmount() == 1) {
	        e.setCancelled(true);
	        e.setCursor(new ItemStack(Material.AIR));
	      } else if (cursor.getAmount() > 1) {
	        e.setCancelled(true);
	        cursor.setAmount(cursor.getAmount() - 1);
	        e.setCursor(cursor);
	      }
	      
	      if (old_enchant >= 3) {
	        int win_chance = new Random().nextInt(100);
	        int fail_percent = 0;
	        if (old_enchant == 3) {
	          fail_percent = 30;
	        }
	        if (old_enchant == 4) {
	          fail_percent = 40;
	        }
	        if (old_enchant == 5) {
	          fail_percent = 50;
	        }
	        if (old_enchant == 6) {
	          fail_percent = 65;
	        }
	        if (old_enchant == 7) {
	          fail_percent = 75;
	        }
	        if (old_enchant == 8) {
	          fail_percent = 80;
	        }
	        if (old_enchant == 9) {
	          fail_percent = 85;
	        }
	        if (old_enchant == 10) {
	          fail_percent = 90;
	        }
	        if (old_enchant == 11) {
	          fail_percent = 95;
	        }
	        
	        if (win_chance < fail_percent) {
	          win = false;
	        }
	        else if (win_chance >= fail_percent) {
	          win = true;
	        }
	      }
	      
	      if (win) {
	    	 if(isWeapon(in_slot)){
	          e.setCurrentItem(enchantWeapon(in_slot, old_enchant + 1));
	    	 }
	        if (isArmor(in_slot))
	        {

	          e.setCurrentItem(enchantArmor(in_slot, old_enchant + 1));
	        }
	        
	        p.updateInventory();
	        p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.25F);
	        
	        Firework fw = (Firework)p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
	        FireworkMeta fwm = fw.getFireworkMeta();
	        FireworkEffect effect = FireworkEffect.builder().flicker(false).withColor(Color.YELLOW).withFade(Color.YELLOW).with(FireworkEffect.Type.BURST).trail(true).build();
	        fwm.addEffect(effect);
	        fwm.setPower(0);
	        fw.setFireworkMeta(fwm);

	      }
	      else if (!win)
	      {
	        if ((!white_scroll) || (old_enchant >= 8)) {
	          e.setCurrentItem(new ItemStack(Material.AIR));
	        } else if ((white_scroll) && (old_enchant < 8)) {
	          p.sendMessage(ChatColor.RED + "Your enchantment scroll " + ChatColor.UNDERLINE + "FAILED" + ChatColor.RED + " but since you had white scroll protection, your item did not vanish.");
	        }
	        p.updateInventory();
	        p.getWorld().playSound(p.getLocation(), Sound.FIZZ, 2.0F, 1.25F);
	        try
	        {
	        	ParticleEffect.LAVA.display(p.getLocation().add(0.0D, 2.5D, 0.0D), new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat(), 1.0F, 75);
	        } catch (Exception e1) {
	          e1.printStackTrace();
	        }
	      }
	      







	      if (white_scroll) {
	        e.setCurrentItem(removeProtection(e.getCurrentItem()));
	        p.updateInventory();
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onPlayerInteract(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    if ((e.hasItem()) && (e.getItem().getType() == Material.EMPTY_MAP)) {
	      e.setCancelled(true);
	      e.setUseItemInHand(Event.Result.DENY);
	      e.setUseInteractedBlock(Event.Result.DENY);
	      p.sendMessage(ChatColor.RED + "To use a " + ChatColor.BOLD + "SCROLL" + ChatColor.RED + ", simply drag it ontop of the piece of equipment you wish to apply it to in your inventory.");
	      p.updateInventory();
	    }
	  }

	  public boolean isWhiteScroll(ItemStack is) {
		    if (is.getType() != Material.EMPTY_MAP) return false;
		    if (!is.hasItemMeta()) return false;
		    if (!is.getItemMeta().hasDisplayName()) return false;
		    if (!ChatColor.stripColor(is.getItemMeta().getDisplayName().toLowerCase()).contains("white scroll: protect")) return false;
		    return true;
		  }
		  
		  public boolean isCorrectScroll(ItemStack scroll, ItemStack in_slot)
		  {
		    String in_raw_name = in_slot.getType().name().toLowerCase();
		    String scroll_type = scroll.getItemMeta().getDisplayName().toLowerCase();
		    if ((scroll_type.contains("weapon")) && 
		      (!in_raw_name.contains("axe")) && (!in_raw_name.contains("sword")) && (!in_raw_name.contains("bow")) && (!in_raw_name.contains("spade")) && (!in_raw_name.contains("hoe"))) { return false;
		    }
		    if ((scroll_type.contains("armor")) && 
		      (!in_raw_name.contains("boot")) && (!in_raw_name.contains("helmet")) && (!in_raw_name.contains("leg")) && (!in_raw_name.contains("chest"))) { return false;
		    }
		    

		    int item_tier = getItemTier(in_slot);
		    int scroll_tier = getItemTier(scroll);
		    
		    if (item_tier != scroll_tier) { return false;
		    }
		    return true;
		  }
		  
		  public static boolean hasProtection(ItemStack is) {
		    if (!is.hasItemMeta()) return false;
		    if (!is.getItemMeta().hasLore()) { return false;
		    }
		    for (String s : is.getItemMeta().getLore()) {
		      if (s.equalsIgnoreCase(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "PROTECTED")) { return true;
		      }
		    }
		    return false;
		  }
		  
		  public static ItemStack removeProtection(ItemStack is) {
		    if (!is.hasItemMeta()) return is;
		    if (!is.getItemMeta().hasLore()) { return is;
		    }
		    ItemMeta im = is.getItemMeta();
		    List<String> lore = im.getLore();
		    lore.remove(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "PROTECTED");
		    im.setLore(lore);
		    is.setItemMeta(im);
		    
		    return is;
		  }

		  public boolean isEnchantScroll(ItemStack is) {
			    if (is.getType() != Material.EMPTY_MAP) return false;
			    if (!is.hasItemMeta()) return false;
			    if (!is.getItemMeta().hasDisplayName()) return false;
			    if (!ChatColor.stripColor(is.getItemMeta().getDisplayName().toLowerCase()).contains("scroll: enchant")) return false;
			    return true;
		  }
		  
		  public static int getItemTier(org.bukkit.inventory.ItemStack i)
		  {
		    try
		    {
		      String name = i.getItemMeta().getDisplayName();
		      if (name.contains(ChatColor.GREEN.toString())) {
		        return 2;
		      }
		      if (name.contains(ChatColor.AQUA.toString())) {
		        return 3;
		      }
		      if (name.contains(ChatColor.LIGHT_PURPLE.toString())) {
		        return 4;
		      }
		      if (name.contains(ChatColor.YELLOW.toString())) {
		        return 5;
		      }
		      if (name.contains(ChatColor.WHITE.toString())) {
		        return 1;
		      }
		      
		      return 1;
		    }
		    catch (NullPointerException npe) {}
		    return 0;
		  }
		  
		  public static int getEnchantCount(ItemStack is) {
				try {
					if(!(is.hasItemMeta())) { return 0; }
					if(!(is.getItemMeta().hasDisplayName())) { return 0; }
					String name = ChatColor.stripColor(is.getItemMeta().getDisplayName());
			          if(name.startsWith("[")) {
			                int enchant_count = Integer.parseInt(name.substring(name.indexOf("+") + 1, name.lastIndexOf("]")));
			                return enchant_count;
			          }
				} catch(Exception e) {
					return 0;
				}
				return 0; // No (+#), must be unenchanted.
			}
		  
		  public static boolean isArmor(org.bukkit.inventory.ItemStack i) {
			  String m = i.getType().toString();
				if(m.contains("HELMET"))return true;
				if(m.contains("CHESTPLATE"))return true;
				if(m.contains("LEGGINGS"))return true;
				if(m.contains("BOOTS"))return true;
				return false;
			}
		  
		  public static boolean isWeapon(org.bukkit.inventory.ItemStack i) {
			  String m = i.getType().toString();
				if(m.contains("SWORD"))return true;
				if(m.contains("AXE"))return true;
				return false;
			}


}