package co.networkery.uvbeenzaned;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {

	public static String pg = ChatColor.GOLD + "[" + ChatColor.AQUA + "Snowballer" + ChatColor.GOLD + "] " + ChatColor.RESET;

	public static void sendAllTeamsMsg(String msg)
	{
		if(SnowballerListener.teamlime != null)
		{
			for(String pl : SnowballerListener.teamlime)
			{
				if(pl != null)
				{
					Bukkit.getPlayer(pl).sendMessage(msg);
				}
			}
		}
		if(SnowballerListener.teamcyan != null)
		{
			for(String pl : SnowballerListener.teamcyan)
			{
				if(pl != null)
				{
					Bukkit.getPlayer(pl).sendMessage(msg);
				}
			} 
		}
	}

	public static void cyanMsg(String msg)
	{
		if(SnowballerListener.teamcyan != null)
		{
			for(String pl : SnowballerListener.teamcyan)
			{
				if(pl != null)
				{
					Bukkit.getPlayer(pl).sendMessage(msg);
				}
			} 
		}
	}

	public static void limeMsg(String msg)
	{
		if(SnowballerListener.teamlime != null)
		{
			for(String pl : SnowballerListener.teamlime)
			{
				if(pl != null)
				{
					Bukkit.getPlayer(pl).sendMessage(msg);
				}
			}
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
			for(String pl : SnowballerListener.teamcyaninarena)
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
			for(String pl : SnowballerListener.teamlimeinarena)
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
	
	public static List<String> getTopScores()
	{
		Map<String, Integer> l = new HashMap<String, Integer>();
		MapValueSorter mvs = new MapValueSorter(l);
		TreeMap<String, Integer> sortedl = new TreeMap<String, Integer>(mvs);
		List<String> formatedl = new ArrayList<String>();
		for(String p : SnowballerListener.scores.getConfig().getKeys(false))
		{
			l.put(p, SnowballerListener.scores.getConfig().getInt(p));
		}
		sortedl.putAll(l);
		for(Entry<String, Integer> e : sortedl.entrySet())
		{
			formatedl.add(ChatColor.GOLD + "[" + ChatColor.BLUE + Rank.getRankName(e.getKey().toString()) + ChatColor.GOLD + "] " + ChatColor.RESET + Utils.getNamewColor(e.getKey().toString()) + 
					ChatColor.DARK_PURPLE + " <" + ChatColor.GOLD + "-" + ChatColor.DARK_PURPLE + "> " + 
					ChatColor.GOLD + e.getValue().toString());
		}
		return formatedl;
	}
}
