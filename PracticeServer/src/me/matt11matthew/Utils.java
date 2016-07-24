package me.matt11matthew;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

public class Utils implements Listener {
	
	public static List<Player> staffchat = new ArrayList<Player>();
	
	public static String colorCodes(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		Essentials essentials = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");
	    User user = essentials.getUser(p);
	    String rank = user.getGroup();
		if((rank.equalsIgnoreCase("gm") || (rank.equalsIgnoreCase("pmod") || (rank.equalsIgnoreCase("dev") || (p.hasPermission("staff.chat")) || (p.isOp()))))) {
			if(staffchat.contains(p)) {

				p.performCommand("sc " + e.getMessage());
				e.setCancelled(true);
				return;
			}
			
			
		}
	}

}
