package co.networkery.uvbeenzaned;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;

public class Round {
	public static String pg = ChatColor.GOLD + "[" + ChatColor.AQUA + "Snowballer" + ChatColor.GOLD + "] " + ChatColor.RESET;

	public static ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			if(SnowballerListener.timergame == true && SnowballerListener.gameon == false)
			{
				for(int p = 0; p < SnowballerListener.teamcyan.size(); p++)
				{
					if(Bukkit.getPlayer(SnowballerListener.teamcyan.toArray()[p].toString()).getWorld().getName() != LTSTL.str2loc(SnowballerListener.config.getConfig().getString("lobbyspawnlocation")).getWorld().getName())	
					{
						Team.Leave(SnowballerListener.teamcyan.toArray()[p].toString(), true);
					}
				}
				for(int p = 0; p < SnowballerListener.teamlime.size(); p++)
				{
					if(Bukkit.getPlayer(SnowballerListener.teamlime.toArray()[p].toString()).getWorld().getName() != LTSTL.str2loc(SnowballerListener.config.getConfig().getString("lobbyspawnlocation")).getWorld().getName())	
					{
						Team.Leave(SnowballerListener.teamlime.toArray()[p].toString(), true);
					}
				}
				if(!SnowballerListener.teamcyan.isEmpty() && !SnowballerListener.teamlime.isEmpty())
				{
					Chat.sendAllTeamsMsg(pg + "Starting next round....");
					randomMap();
					SnowballerListener.gameon = true;
				}
				else
				{
					if(SnowballerListener.teamlime.isEmpty())
					{
						Chat.cyanMsg(pg + "There are no players on team " + ChatColor.GREEN + "LIME " + ChatColor.RESET + "to play with.");
						Chat.cyanMsg(pg + "Stopping game and waiting for another player to join....");
						timer.stop();
						SnowballerListener.gameon = false;
						SnowballerListener.timergame = false;
					}
					if(SnowballerListener.teamcyan.isEmpty())
					{
						Chat.limeMsg(pg + "There are no players on team " + ChatColor.AQUA + "CYAN " + ChatColor.RESET + "to play with.");
						Chat.limeMsg(pg + "Stopping game and waiting for another player to join....");
						timer.stop();
						SnowballerListener.gameon = false;
						SnowballerListener.timergame = false;
					}
				}
			}
		}
	};

	public static Timer timer;

	public static void startIndependentTimerRound()
	{
		if(SnowballerListener.timergame == true && SnowballerListener.gameon == false)
		{
			if(!SnowballerListener.teamcyan.isEmpty() && !SnowballerListener.teamlime.isEmpty())
			{
				timer = new Timer(SnowballerListener.config.getConfig().getInt("timerdelay"), taskPerformer);
				timer.setRepeats(false);
				timer.start();
				Chat.sendAllTeamsMsg(pg + "Next round starts in " + Integer.toString(SnowballerListener.config.getConfig().getInt("timerdelay") / 1000) + " seconds!");
			}
			else
			{
				if(SnowballerListener.teamlime.isEmpty())
				{
					Chat.cyanMsg(pg + "There are no players on team " + ChatColor.GREEN + "LIME " + ChatColor.RESET + "to play with.");
					Chat.cyanMsg(pg + "Waiting for another player to join....");
				}
				if(SnowballerListener.teamcyan.isEmpty())
				{
					Chat.limeMsg(pg + "There are no players on team " + ChatColor.AQUA + "CYAN " + ChatColor.RESET + "to play with.");
					Chat.limeMsg(pg + "Waiting for another player to join....");
				}
			}
		}
	}

	public static Random r = new Random();
	public static int l = 0;

	public static void randomMap()
	{
		SnowballerListener.hitcnts.clear();
		r.setSeed(System.currentTimeMillis());
		int mapnum = r.nextInt(SnowballerListener.config.getConfig().getConfigurationSection("teamcyanarenasides").getKeys(false).size());
		while(mapnum == l)
		{
			mapnum = r.nextInt(SnowballerListener.config.getConfig().getConfigurationSection("teamcyanarenasides").getKeys(false).size());
		}
		int i = 0;
		for(String key : SnowballerListener.config.getConfig().getConfigurationSection("teamcyanarenasides").getKeys(false))
		{
			if(mapnum == i)
			{
				l = mapnum;
				for(String pl : SnowballerListener.teamcyan)
				{
					Bukkit.getPlayer(pl).setRemoveWhenFarAway(false);
				}
				for(String pl : SnowballerListener.teamlime)
				{
					Bukkit.getPlayer(pl).setRemoveWhenFarAway(false);
				}
				for(String pl : SnowballerListener.teamcyan)
				{
					Bukkit.getPlayer(pl).getInventory().clear();
					SnowballerListener.giveSnowballs(Bukkit.getPlayer(pl));
					SnowballerListener.teamcyaninarena.add(pl);
					Bukkit.getPlayer(pl).teleport(LTSTL.str2loc(SnowballerListener.config.getConfig().getString("teamcyanarenasides." + key)));
					Bukkit.getPlayer(pl).setGameMode(GameMode.SURVIVAL);
				}
				for(String pl : SnowballerListener.teamlime)
				{
					Bukkit.getPlayer(pl).getInventory().clear();
					SnowballerListener.giveSnowballs(Bukkit.getPlayer(pl));
					SnowballerListener.teamlimeinarena.add(pl);
					Bukkit.getPlayer(pl).teleport(LTSTL.str2loc(SnowballerListener.config.getConfig().getString("teamlimearenasides." + key)));
					Bukkit.getPlayer(pl).setGameMode(GameMode.SURVIVAL);
				}
				Utils.checkPlayerStuck(300);
				Chat.sendAllTeamsMsg(pg + "Arena: " + ChatColor.GOLD + key);
			}
			i++;
		}
	}
}
