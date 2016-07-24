package me.matt11matthew.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.matt11matthew.Utils;

public class CommandSayall implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(p.isOp()) {
			String msg = "";
		    String[] arrayOfString; int j = (arrayOfString = args).length; for (int i = 0; i < j; i++) { String s = arrayOfString[i];
		      msg = msg + s + " ";
		    }
		    msg = ChatColor.stripColor(msg);
			String final_msg = Utils.colorCodes("&b&l>>> &b" + msg + "-" + p.getName());
			Bukkit.getServer().broadcastMessage(final_msg);
			return true;
		}
		return true;
		
	}
}