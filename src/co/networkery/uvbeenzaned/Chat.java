package co.networkery.uvbeenzaned;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {
	
	public static String pg = ChatColor.GOLD + "[" + ChatColor.AQUA + "Snowballer" + ChatColor.GOLD + "] " + ChatColor.RESET;
	
	 public static void sendAllTeamsMsg(String msg)
	 {
		 for(String pl : SnowballerListener.teamlime)
		 {
			 Bukkit.getPlayer(pl).sendMessage(msg);
		 }
		 for(String pl : SnowballerListener.teamcyan)
		 {
			 Bukkit.getPlayer(pl).sendMessage(msg);
		 } 
	 }
	 
	 public static void cyanMsg(String msg)
	 {
		 for(String pl : SnowballerListener.teamcyan)
		 {
			 Bukkit.getPlayer(pl).sendMessage(msg);
		 }
	 }
	 
	 public static void limeMsg(String msg)
	 {
		 for(String pl : SnowballerListener.teamlime)
		 {
			 Bukkit.getPlayer(pl).sendMessage(msg);
		 }
	 }
	 
	 public static boolean getTeamStats(String player)
	 {
		 Player p = Bukkit.getPlayer(player);
		 
		if(SnowballerListener.teamcyan.size() > 0)
		{
			p.sendMessage(pg + ChatColor.AQUA + "CYAN" + ChatColor.RESET + " players" + ": " + String.valueOf(SnowballerListener.teamcyan.size()));
			if(SnowballerListener.gameon == true)
			{
				p.sendMessage(pg + ChatColor.AQUA + "CYAN" + ChatColor.RESET + " left in arena: " + String.valueOf(SnowballerListener.teamcyaninarena.size()));
			}
			for(String pl : SnowballerListener.teamcyan)
			{
				if(SnowballerListener.hitcnts.containsKey(pl))
				{
					p.sendMessage( "    " + ChatColor.GOLD + "[" + ChatColor.RESET + ChatColor.BOLD + ChatColor.BLUE + Rank.getRankName(pl) + ChatColor.GOLD + "(" + String.valueOf(SnowballerListener.scores.getConfig().get(pl)) + ")]" + ChatColor.AQUA + pl + ChatColor.RED + " (" + SnowballerListener.hitcnts.get(pl).toString() + " hits)");
				}
				else
				{
					p.sendMessage( "    " + ChatColor.GOLD + "[" + ChatColor.RESET + ChatColor.BOLD + ChatColor.BLUE + Rank.getRankName(pl) + ChatColor.RESET + ChatColor.GOLD + "(" + String.valueOf(SnowballerListener.scores.getConfig().get(pl)) + ")]" + ChatColor.AQUA + pl);
				}
			}
		}
		else
		{
			p.sendMessage(pg + ChatColor.AQUA + "CYAN" + ChatColor.RESET + " players" + ": 0");
		}
		if(SnowballerListener.teamlime.size() > 0)
		{
			p.sendMessage(pg + ChatColor.GREEN + "LIME" + ChatColor.RESET + " players" + ": " + String.valueOf(SnowballerListener.teamlime.size()));
			if(SnowballerListener.gameon == true)
			{
				p.sendMessage(pg + ChatColor.GREEN + "LIME" + ChatColor.RESET + " left in arena: " + String.valueOf(SnowballerListener.teamlimeinarena.size()));
			}
			for(String pl : SnowballerListener.teamlime)
			{
				if(SnowballerListener.hitcnts.containsKey(pl))
				{
					p.sendMessage( "    " + ChatColor.GOLD + "[" + ChatColor.RESET + ChatColor.BOLD + ChatColor.BLUE + Rank.getRankName(pl) + ChatColor.GOLD + "(" + String.valueOf(SnowballerListener.scores.getConfig().get(pl)) + ")]" + ChatColor.GREEN + pl + ChatColor.RED + " (" + SnowballerListener.hitcnts.get(pl).toString() + " hits)");
				}
				else
				{
					p.sendMessage( "    " + ChatColor.GOLD + "[" + ChatColor.RESET + ChatColor.BOLD + ChatColor.BLUE + Rank.getRankName(pl) + ChatColor.GOLD + "(" + String.valueOf(SnowballerListener.scores.getConfig().get(pl)) + ")]" + ChatColor.GREEN + pl);
				}
			}
		}
		else
		{
			p.sendMessage(pg + ChatColor.GREEN + "LIME" + ChatColor.RESET + " players" + ": 0");
		}
		return true;
	 }
}
