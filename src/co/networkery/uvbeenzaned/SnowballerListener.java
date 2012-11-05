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
 
 public class SnowballerListener implements Listener
 {
	 public String pg = ChatColor.AQUA + "[Snowballer] " +  ChatColor.RESET;
	 public boolean gameon = false;
	 public boolean timergame = false;
	 public Location lobbyspawnlocation = null;
	 //public List<Player> teamcyan = new ArrayList<Player>();
	 //public List<Player> teamlime = new ArrayList<Player>();
	 public HashMap<String, Integer> teamcyan = new HashMap<String, Integer>();
	 public HashMap<String, Integer> teamlime = new HashMap<String, Integer>();
	 public List<String> teamcyaninarena = new ArrayList<String>();
	 public List<String> teamlimeinarena = new ArrayList<String>();
	 //public HashMap<String, Integer> teamcyaninarena = new HashMap<String, Integer>();
	 //public HashMap<String, Integer> teamlimeinarena = new HashMap<String, Integer>();
	 public HashMap<String, Location> teamcyanarenasides = new HashMap<String, Location>();
	 public HashMap<String, Location> teamlimearenasides = new HashMap<String, Location>();
	 public int timerdelay = 0;
	 public Timer t = new Timer();
	 
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
				}
				if(teamlime.containsKey(pll))
				{
					teamlime.remove(pll);
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
				}
				if(teamlime.containsKey(pll))
				{
					teamlime.remove(pll);
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
				}
				if(teamlime.containsKey(pld))
				{
					teamlime.remove(pld);
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
				}
				if(teamlime.containsKey(pld))
				{
					teamlime.remove(pld);
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
					 if(teamcyaninarena.contains(plhit) || teamlimeinarena.contains(plhit))
					 {
						 if(teamcyaninarena.contains(plenemy) || teamlimeinarena.contains(plenemy))
						 {
							 if(!teamcyaninarena.contains(plhit) || !teamcyaninarena.contains(plenemy))
							 {
								 if(!teamlimeinarena.contains(plhit) || !teamlimeinarena.contains(plenemy))
								 {
									 plhit.getWorld().playSound(plhit.getLocation(), Sound.NOTE_PIANO, 10, 1);
									 plhit.getWorld().playSound(plhit.getLocation(), Sound.NOTE_PIANO, 10, 2);
									 plhit.getWorld().playSound(plhit.getLocation(), Sound.NOTE_PIANO, 10, 3);
									 plhit.getWorld().playSound(plhit.getLocation(), Sound.NOTE_PIANO, 10, 4);
									 plhit.getWorld().playEffect(plhit.getLocation(), Effect.ENDER_SIGNAL, 0);
									 if(teamcyaninarena.contains(plhit))
									 {
										 teamcyaninarena.remove(plhit);
									 }
									 if(teamlimeinarena.contains(plhit))
									 {
										 teamlimeinarena.remove(plhit);
									 }
									 plhit.teleport(lobbyspawnlocation);
									 cyanMsg(pg + ChatColor.RED + plhit.getName() + ChatColor.BLUE + " was hit by " + ChatColor.GREEN + plenemy.getName() + ".");
									 limeMsg(pg + ChatColor.RED + plhit.getName() + ChatColor.BLUE + " was hit by " + ChatColor.GREEN + plenemy.getName() + ".");
									 //Bukkit.broadcastMessage("Team cyan players left: " + Integer.toString(teamcyaninarena.size()) + " players.");
									 //Bukkit.broadcastMessage("Team lime players left: " + Integer.toString(teamlimeinarena.size()) + " players.");
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
		int mapnum = r.nextInt(teamcyanarenasides.keySet().size());
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
					Bukkit.getPlayer(pl.getKey()).teleport(teamlimearenasides.get(entry.getValue()));
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