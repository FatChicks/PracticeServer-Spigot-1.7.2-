package me.cazza.PracticeServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class HPBAR implements Listener {
	private Scoreboard s; {
    this.s = Bukkit.getScoreboardManager().getMainScoreboard();
    registerHealthBar();

  }
  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e)
  {
    this.s.getTeam("blue").addPlayer(e.getPlayer());
  }
 
  public void registerHealthBar()
  {
    if (this.s.getObjective("health") != null) {
      this.s.getObjective("health").unregister();
    }
    Objective o = this.s.registerNewObjective("health", "health");
    o.setDisplayName(ChatColor.RED + "❤");
    o.setDisplaySlot(DisplaySlot.BELOW_NAME);
  }
}