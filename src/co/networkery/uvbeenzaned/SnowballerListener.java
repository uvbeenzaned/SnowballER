package co.networkery.uvbeenzaned;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.Map.Entry;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
 public class SnowballerListener implements Listener
 {
	 public static String pg = ChatColor.AQUA + "[Snowballer] " +  ChatColor.RESET;
	 public configOps cO;
	 public static boolean gameon = false;
	 public static boolean timergame = false;
	 public static Location lobbyspawnlocation = null;
	 public static HashMap<String, Integer> teamcyan = new HashMap<String, Integer>();
	 public static HashMap<String, Integer> teamlime = new HashMap<String, Integer>();
	 public static List<String> teamcyaninarena = new ArrayList<String>();
	 public static List<String> teamlimeinarena = new ArrayList<String>();
	 public static HashMap<String, Location> teamcyanarenasides = new HashMap<String, Location>();
	 public static HashMap<String, Location> teamlimearenasides = new HashMap<String, Location>();
	 public static int timerdelay = 0;
	 public static Timer t = new Timer();
	 
	 public SnowballerListener(JavaPlugin jp)
	 {
		 cO = new configOps(jp);
	 }
	 
	 @EventHandler
	 public void playerLeave(PlayerQuitEvent event)
	 {
		 String pll = event.getPlayer().getName();
		 if(gameon)
		 {
				if(teamcyaninarena.contains(pll))
				{
					Bukkit.getServer().getPlayer(pll).teleport(lobbyspawnlocation);
					teamcyaninarena.remove(pll);
				}
				if(teamlimeinarena.contains(pll))
				{
					Bukkit.getServer().getPlayer(pll).teleport(lobbyspawnlocation);
					teamlimeinarena.remove(pll);
				}
				checkTeamsInArena();
				if(teamcyan.containsKey(pll))
				{
					teamcyan.remove(pll);
					sendAllTeamsMsg(pg + pll + " has left team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
					sendAllTeamsMsg(pg + "There are now " + teamlime.size() + " players on team " + ChatColor.AQUA + "CYAN.");
				}
				if(teamlime.containsKey(pll))
				{
					teamlime.remove(pll);
					sendAllTeamsMsg(pg + pll + " has left team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
					sendAllTeamsMsg(pg + "There are now " + teamlime.size() + " players on team " + ChatColor.GREEN + "LIME.");
				}
		 }
		 else
		 {
				if(teamcyaninarena.contains(pll))
				{
					Bukkit.getServer().getPlayer(pll).teleport(lobbyspawnlocation);
					teamcyaninarena.remove(pll);
				}
				if(teamlimeinarena.contains(pll))
				{
					Bukkit.getServer().getPlayer(pll).teleport(lobbyspawnlocation);
					teamlimeinarena.remove(pll);
				}
				if(teamcyan.containsKey(pll))
				{
					teamcyan.remove(pll);
					sendAllTeamsMsg(pg + pll + " has left team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
					sendAllTeamsMsg(pg + "There are now " + teamlime.size() + " players on team " + ChatColor.AQUA + "CYAN.");
				}
				if(teamlime.containsKey(pll))
				{
					teamlime.remove(pll);
					sendAllTeamsMsg(pg + pll + " has left team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
					sendAllTeamsMsg(pg + "There are now " + teamlime.size() + " players on team " + ChatColor.GREEN + "LIME.");
				}
		 }
	 }
	 
	 @EventHandler
	 public void playerDeath(PlayerDeathEvent event)
	 {
		 String pld = event.getEntity().getName();
		 if(gameon)
		 {
			    if(teamcyaninarena.contains(pld))
			    {
			    	Bukkit.getServer().getPlayer(pld).teleport(lobbyspawnlocation);
			    	teamcyaninarena.remove(pld);
				}
				if(teamlimeinarena.contains(pld))
				{
					Bukkit.getServer().getPlayer(pld).teleport(lobbyspawnlocation);
					teamlimeinarena.remove(pld);
				}
				checkTeamsInArena();
			    if(teamcyan.containsKey(pld))
			    {
			    	teamcyan.remove(pld);
					sendAllTeamsMsg(pg + pld + " has left team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
					sendAllTeamsMsg(pg + "There are now " + teamlime.size() + " players on team " + ChatColor.AQUA + "CYAN.");
				}
				if(teamlime.containsKey(pld))
				{
					teamlime.remove(pld);
					sendAllTeamsMsg(pg + pld + " has left team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
					sendAllTeamsMsg(pg + "There are now " + teamlime.size() + " players on team " + ChatColor.GREEN + "LIME.");
				}
		 }
		 else
		 {
			    if(teamcyaninarena.contains(pld))
			    {
			    	Bukkit.getServer().getPlayer(pld).teleport(lobbyspawnlocation);
			    	teamcyaninarena.remove(pld);
				}
				if(teamlimeinarena.contains(pld))
				{
					Bukkit.getServer().getPlayer(pld).teleport(lobbyspawnlocation);
					teamlimeinarena.remove(pld);
				}
			    if(teamcyan.containsKey(pld))
			    {
			    	teamcyan.remove(pld);
					sendAllTeamsMsg(pg + pld + " has left team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
					sendAllTeamsMsg(pg + "There are now " + teamcyan.size() + " players on team " + ChatColor.AQUA + "CYAN.");
				}
				if(teamlime.containsKey(pld))
				{
					teamlime.remove(pld);
					sendAllTeamsMsg(pg + pld + " has left team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
					sendAllTeamsMsg(pg + "There are now " + teamlime.size() + " players on team " + ChatColor.GREEN + "LIME.");
				}
		 }
	 }
	 
	 @EventHandler
	 public void entityDamage(EntityDamageByEntityEvent event)
	 {
		 if(gameon)
		 {
			 if ((event.getEntity() instanceof Player && event.getDamager() instanceof Snowball))
			 {
				 Player plhit = (Player)event.getEntity();
				 Snowball sb = (Snowball)event.getDamager();
				 Player plenemy = (Player)sb.getShooter();
				 if(plhit != plenemy)
				 {
					 if(teamcyaninarena.contains(plhit.getName()) || teamlimeinarena.contains(plhit.getName()))
					 {
						 if(teamcyaninarena.contains(plenemy.getName()) || teamlimeinarena.contains(plenemy.getName()))
						 {
							 if(!teamcyaninarena.contains(plhit.getName()) || !teamcyaninarena.contains(plenemy.getName()))
							 {
								 if(!teamlimeinarena.contains(plhit.getName()) || !teamlimeinarena.contains(plenemy.getName()))
								 {
									 plhit.getWorld().playSound(plhit.getLocation(), Sound.NOTE_PIANO, 10, 1);
									 plhit.getWorld().playSound(plhit.getLocation(), Sound.NOTE_PIANO, 10, 2);
									 plhit.getWorld().playSound(plhit.getLocation(), Sound.NOTE_PIANO, 10, 3);
									 plhit.getWorld().playSound(plhit.getLocation(), Sound.NOTE_PIANO, 10, 4);
									 plhit.getWorld().playEffect(plhit.getLocation(), Effect.ENDER_SIGNAL, 0);
									 if(teamcyaninarena.contains(plhit.getName()))
									 {
										 teamcyaninarena.remove(plhit.getName());
									 }
									 if(teamlimeinarena.contains(plhit.getName()))
									 {
										 teamlimeinarena.remove(plhit.getName());
									 }
									 plhit.teleport(lobbyspawnlocation);
									 for(Entry<String, Integer> entry : teamcyan.entrySet())
									 {
										 if(entry.getKey() == plenemy.getName())
										 {
											 entry.setValue(entry.getValue() + 1);
											 plenemy.sendMessage(pg + "+1 point!  Your score is now " + teamcyan.get(plenemy.getName()) + ".");
											 configOps.saveScores();
										 }
										 if(entry.getKey() == plhit.getName())
										 {
											 if(entry.getValue() != 0)
											 {
												 entry.setValue(entry.getValue() - 1);
												 plhit.sendMessage(pg + "-1 point!  Your score is now " + teamcyan.get(plhit.getName()) + ".");
												 configOps.saveScores();
											 }
										 }
									 }
									 for(Entry<String, Integer> entry : teamlime.entrySet())
									 {
										 if(entry.getKey() == plenemy.getName())
										 {
											 entry.setValue(entry.getValue() + 1);
											 plenemy.sendMessage(pg + "+1 point!  Your score is now " + teamlime.get(plenemy.getName()) + ".");
											 configOps.saveScores();
										 }
										 if(entry.getKey() == plhit.getName())
										 {
											 if(entry.getValue() != 0)
											 {
												 entry.setValue(entry.getValue() - 1);
												 plhit.sendMessage(pg + "-1 point!  Your score is now " + teamlime.get(plhit.getName()) + ".");
												 configOps.saveScores();
											 }
										 }
									 }
									 sendAllTeamsMsg(pg + "There are now " + teamcyaninarena.size() + " players on team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET + " left in the arena!");
									 sendAllTeamsMsg(pg + "There are now " + teamlimeinarena.size() + " players on team " + ChatColor.GREEN + "LIME." + ChatColor.RESET + " left in the arena!");
									 sendAllTeamsMsg(pg + ChatColor.RED + plhit.getName() + ChatColor.BLUE + " was hit by " + ChatColor.GREEN + plenemy.getName() + ".");
									 checkTeamsInArena();
									 event.setCancelled(true);
								 }
							 }
						 }
					 }
				 }
			 }
		 }
	 }
	 
	 public TimerTask startIndependentTimerRound()
	 {
		randomMap();
		gameon = true;
		timergame = true;
		return null;
	 }
	 
	 public Random r = new Random();
	 
	 public void randomMap()
	 {
		r.setSeed(System.currentTimeMillis());
		int mapnum = r.nextInt(teamcyanarenasides.entrySet().size());
		int i = 0;
		for(Entry<String, Location> entry : teamcyanarenasides.entrySet())
		{
			if(mapnum == i)
			{
				for(Entry<String, Integer> pl : teamcyan.entrySet())
				{
					teamcyaninarena.add(pl.getKey());
					Bukkit.getServer().getPlayer(pl.getKey()).teleport(entry.getValue());
				}
				for(Entry<String, Integer> pl : teamlime.entrySet())
				{
					teamlimeinarena.add(pl.getKey());
					Bukkit.getServer().getPlayer(pl.getKey()).teleport(teamlimearenasides.get(entry.getKey()));
				}
			}
			i++;
		}
	 }
	 
	 public void checkTeamsInArena()
	 {
		 if(teamcyaninarena.size() == 0)
		 {
			 for(String pl : teamlimeinarena)
			 {
				 Bukkit.getServer().getPlayer(pl).teleport(lobbyspawnlocation);
			 }
			 for(String pl : teamcyaninarena)
			 {
				 Bukkit.getServer().getPlayer(pl).teleport(lobbyspawnlocation);
			 }
			 limeMsg(pg + "Team" + ChatColor.GREEN + " LIME " + ChatColor.RESET + "wins!");
			 cyanMsg(pg + "Team" + ChatColor.GREEN + " LIME " + ChatColor.RESET + "wins!");
			 teamcyaninarena.clear();
			 teamlimeinarena.clear();
			 gameon = false;
		 }
		 else
		 {
			 if(teamlimeinarena.size() == 0)
			 {
				 for(String pl : teamcyaninarena)
				 {
					 Bukkit.getServer().getPlayer(pl).teleport(lobbyspawnlocation);
				 }
				 for(String pl : teamlimeinarena)
				 {
					 Bukkit.getServer().getPlayer(pl).teleport(lobbyspawnlocation);
				 }
				 cyanMsg(pg + "Team" + ChatColor.AQUA + " CYAN " + ChatColor.RESET + "wins!");
				 limeMsg(pg + "Team" + ChatColor.AQUA + " CYAN " + ChatColor.RESET + "wins!");
				 teamcyaninarena.clear();
				 teamlimeinarena.clear();
				 gameon = false;
			 }
			 if(timergame == true)
			 {
				 t.schedule(startIndependentTimerRound(), timerdelay);
				 sendAllTeamsMsg("Next game starts in " + Integer.toString(timerdelay / 1000) + " seconds.");
			 }
		 }
	 }
	 
	 public void sendAllTeamsMsg(String msg)
	 {
		 for(Entry<String, Integer> pl : teamlime.entrySet())
		 {
			 Bukkit.getServer().getPlayer(pl.getKey()).sendMessage(msg);
		 }
		 for(Entry<String, Integer> pl : teamcyan.entrySet())
		 {
			 Bukkit.getServer().getPlayer(pl.getKey()).sendMessage(msg);
		 } 
	 }
	 
	 public void cyanMsg(String msg)
	 {
		 for(Entry<String, Integer> pl : teamcyan.entrySet())
		 {
			 Bukkit.getServer().getPlayer(pl.getKey()).sendMessage(msg);
		 }
	 }
	 
	 public void limeMsg(String msg)
	 {
		 for(Entry<String, Integer> pl : teamlime.entrySet())
		 {
			 Bukkit.getServer().getPlayer(pl.getKey()).sendMessage(msg);
		 }
	 }
 }