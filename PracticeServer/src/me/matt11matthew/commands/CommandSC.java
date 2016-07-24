package me.matt11matthew.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import me.matt11matthew.Utils;

public class CommandSC implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Essentials essentials = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");
	    User user = essentials.getUser(p);
	    String rank = user.getGroup();
	    if(!(rank.equalsIgnoreCase("gm") || (rank.equalsIgnoreCase("pmod") || (p.hasPermission("staff.chat")) || (rank.equalsIgnoreCase("dev") || (p.isOp())))))return true;
		if(args.length == 0) {
			if(Utils.staffchat.contains(p)) {
				Utils.staffchat.remove(p);
				return true;
			} else {
				Utils.staffchat.add(p);
				return true;
			}
		} else {
			String msg = "";
		    String[] arrayOfString; int j = (arrayOfString = args).length; for (int i = 0; i < j; i++) { String s = arrayOfString[i];
		      msg = msg + s + " ";
		   

		    }
		    String final_msg = Utils.colorCodes("&6<&lSC&6> " + p.getDisplayName() + "&f: " + msg);
	    	sendSC(final_msg);
	    	return true;
		}
	}
	
	public void sendSC(String msg) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			Essentials essentials = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");
		    User user = essentials.getUser(p);
		    String rank = user.getGroup();
			if((rank.equalsIgnoreCase("gm") || (rank.equalsIgnoreCase("pmod") || (p.hasPermission("staff.chat")) || (rank.equalsIgnoreCase("dev") || (p.isOp()))))) {
				
				p.sendMessage(msg);
			}
		}
	}
}


