package co.networkery.uvbeenzaned;

import java.util.Map.Entry;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;

public class Snowballer extends JavaPlugin
{
	public final SnowballerListener sbr = new SnowballerListener();
	Logger log;
	public String pg = ChatColor.AQUA + "[Snowballer] " +  ChatColor.RESET;

	public void onEnable()
	{
		this.log = getLogger();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.sbr, this);
		saveDefaultConfig();
		if(getConfig().getInt("timerdelay") != 0)
		{
			sbr.timerdelay = getConfig().getInt("timerdelay");
			log.info("Timer delay set to " + Integer.toString(sbr.timerdelay) + " milliseconds.");
		}
		else
		{
			sbr.timerdelay = 30000;
			log.info("Defaulted timer delay to " + Integer.toString(sbr.timerdelay) + " milliseconds.");
		}
		if(getConfig().getString("lobbyspawnlocation") != null && getConfig().getString("lobbyspawnlocation") != "")
		{
			sbr.lobbyspawnlocation = LTSTL.str2loc(getConfig().getString("lobbyspawnlocation"));
			log.info("Found lobby spawn location at: " + getConfig().getString("lobbyspawnlocation"));
		}
		if(getConfig().getConfigurationSection("teamcyanarenasides").getKeys(false) != null)
		{
			for(String key : getConfig().getConfigurationSection("teamcyanarenasides").getKeys(false))
			{
				if(getConfig().getString("teamcyanarenasides." + key) != null)
				{
					sbr.teamcyanarenasides.put(key, LTSTL.str2loc(getConfig().getString("teamcyanarenasides." + key)));
					log.info("Found cyan arena side " + "\"" + key + "\"" + " at " + getConfig().getString("teamcyanarenasides." + key));
				}
			}
		}
		if(getConfig().getConfigurationSection("teamlimearenasides").getKeys(false) != null)
		{
			for(String key : getConfig().getConfigurationSection("teamlimearenasides").getKeys(false))
			{
				if(getConfig().getString("teamlimearenasides." + key) != null)
				{
					sbr.teamlimearenasides.put(key, LTSTL.str2loc(getConfig().getString("teamlimearenasides." + key)));
					log.info("Found lime arena side " + "\"" + key + "\"" + " at " + getConfig().getString("teamlimearenasides." + key));
				}
			}
		}
	}

  public void onDisable()
  {
	  if(sbr.timerdelay != 0)
	  {
		  getConfig().set("timerdelay", sbr.timerdelay);
		  log.info("Saved timer delay.");
	  }
	  if(sbr.lobbyspawnlocation != null)
	  {
		  getConfig().set("lobbyspawnlocation", LTSTL.loc2str(sbr.lobbyspawnlocation));
		  log.info("Saved lobby spawn location.");
	  }
	  for(Entry<String, Location> entry : sbr.teamcyanarenasides.entrySet())
	  {
		  getConfig().set("teamcyanarenasides." + entry.getKey(), LTSTL.loc2str(entry.getValue()));
		  log.info("Saved cyan arena side " + "\"" + entry.getKey() + "\"" + " at " + LTSTL.loc2str(entry.getValue()));
	  }
	  for(Entry<String, Location> entry : sbr.teamlimearenasides.entrySet())
	  {
		  getConfig().set("teamlimearenasides." + entry.getKey(), LTSTL.loc2str(entry.getValue()));
		  log.info("Saved lime arena side " + "\"" + entry.getKey() + "\"" + " at " + LTSTL.loc2str(entry.getValue()));
	  }
	  for(Entry<String, Integer> entry : sbr.teamcyan.entrySet())
	  {
		  getConfig().set("cyanscores." + entry.getKey(), Integer.toString(entry.getValue()));
		  log.info("Saved cyan scores " + "\"" + entry.getKey() + "\"" + " at " + Integer.toString(entry.getValue()));
	  }
	  for(Entry<String, Integer> entry : sbr.teamlime.entrySet())
	  {
		  getConfig().set("limescores." + entry.getKey(), Integer.toString(entry.getValue()));
		  log.info("Saved lime scores " + "\"" + entry.getKey() + "\"" + " at " + Integer.toString(entry.getValue()));
	  }
	  saveConfig();
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	  if(sender instanceof Player)
	  {
		  Player plcmd = (Player)sender;
		  if(args.length > 0)
		  {
			  switch(args[0])
			  {
			  	case "setspawn":
			  		if(plcmd.isOp())
			  		{
				  		sbr.lobbyspawnlocation = plcmd.getLocation();
				  		plcmd.sendMessage(pg + "The new spawn location is now at: " + sbr.lobbyspawnlocation.toString() + ".");
				  		return true;
			  		}
			  		plcmd.sendMessage(pg + "You have to be an op to run this command!");
			  		return true;
			  	case "setarenaside":
			  		if(plcmd.isOp())
			  		{
			  			if(args.length > 1)
			  			{
			  				if(args[1].equalsIgnoreCase("cyan"))
			  				{
			  					if(args[2] != null)
			  					{
				  					sbr.teamcyanarenasides.put(args[2], plcmd.getLocation());
				  					plcmd.sendMessage(pg + "Added the arena: " + args[2] + " and location " + sbr.teamcyanarenasides.get(args[2]).toString() + ".");
				  					return true;
			  					}
			  					plcmd.sendMessage(pg + "You have to have a name for the arena!");
			  					return true;
			  				}
			  				if(args[1].equalsIgnoreCase("lime"))
			  				{
			  					if(args[2] != null)
			  					{
				  					sbr.teamlimearenasides.put(args[2], plcmd.getLocation());
				  					plcmd.sendMessage(pg + "Added the arena: " + args[2] + " and location " + sbr.teamlimearenasides.get(args[2]).toString() + ".");
				  					return true;
			  					}
			  				}
		  					plcmd.sendMessage(pg + "You have to have a name for the arena!");
		  					return true;
			  			}
			  		}
			  		plcmd.sendMessage(pg + "You have to be an op to run this command!");
			  		return true;
			  	case "start":
			  		if(plcmd.isOp())
			  		{
			  			if(sbr.gameon == false)
			  			{
				  			sbr.gameon = true;
				  			sbr.randomMap();
				  			plcmd.sendMessage(pg + "You've started a Snowballer game.");
				  			return true;
				  		}
			  			else
			  			{
			  				plcmd.sendMessage(pg + "There is already a Snowballer game in progess.");
			  				return true;
			  			}
			  		}
			  		plcmd.sendMessage(pg + "You have to be an op to run this command!");
			  		return true;
			  	case "start-timer":
			  		if(plcmd.isOp())
			  		{
			  			if(sbr.gameon == false && sbr.timergame == false)
			  			{
				  			sbr.t.schedule(sbr.startIndependentTimerRound(), sbr.timerdelay);
				  			plcmd.sendMessage(pg + "You've scheduled a Snowballer game for " + Integer.toString(sbr.timerdelay / 1000) + " seconds from now.");
				  			sbr.sendAllTeamsMsg("Next game starts in " + Integer.toString(sbr.timerdelay / 1000) + " seconds.");
				  			return true;
				  		}
			  			else
			  			{
			  				plcmd.sendMessage(pg + "There is already a Snowballer game in progess.");
			  				return true;
			  			}
			  		}
			  		plcmd.sendMessage(pg + "You have to be an op to run this command!");
			  		return true;
			  	case "stop":
			  		if(plcmd.isOp())
			  		{
		  				if(sbr.timergame == true)
		  				{
		  					sbr.timergame = false;
		  					plcmd.sendMessage(pg + "Stopped game timer.");
		  				}
			  			if(sbr.gameon == true)
			  			{
				  			sbr.gameon = false;
							for (int i = 0; i < sbr.teamcyaninarena.size(); i++)
							{
								Player pl = getServer().getPlayer(sbr.teamcyaninarena.get(i));
				  				pl.teleport(sbr.lobbyspawnlocation);
				  				pl.sendMessage(pg + "An admin has ended the current snowballer game!");
				  				sbr.teamcyaninarena.remove(pl);
							}
							for (int i = 0; i < sbr.teamlimeinarena.size(); i++)
							{
								Player pl = getServer().getPlayer(sbr.teamlimeinarena.get(i));
				  				pl.teleport(sbr.lobbyspawnlocation);
				  				pl.sendMessage(pg + "An admin has ended the current snowballer game!");
				  				sbr.teamlimeinarena.remove(pl);
							}
				  			sbr.teamcyaninarena.clear();
				  			sbr.teamlimeinarena.clear();
				  			plcmd.sendMessage(pg + "You've ended the current Snowballer game.");
				  			return true;
			  			}
			  			else
			  			{
			  				plcmd.sendMessage(pg + "There is no game in progress right now.");
			  				return true;
			  			}
			  		}
			  		plcmd.sendMessage(pg + "You have to be an op to run this command!");
			  		return true;
			  	case "join":
			  		if(args.length > 1)
			  		{
			  			if(sbr.teamcyan.containsKey(plcmd))
			  			{
			  				plcmd.sendMessage(pg + "You are already on team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
			  				return true;
			  			}
			  			if(sbr.teamlime.containsKey(plcmd))
			  			{
			  				plcmd.sendMessage(pg + "You are already on team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
			  				return true;
			  			}
			  			if(args[1].equalsIgnoreCase("cyan"))
			  			{
					  		if(!sbr.teamcyan.containsKey(plcmd.getName()))
					  		{
								if(getConfig().getInt("cyanscores." + plcmd.getName()) != 0)
								{
									sbr.teamcyan.put(plcmd.getName(), getConfig().getInt("cyanscores." + plcmd.getName()));
								}
								else
								{
									sbr.teamcyan.put(plcmd.getName(), 0);
								}
					  			plcmd.teleport(sbr.lobbyspawnlocation);
					  			sbr.sendAllTeamsMsg(pg + plcmd.getName() +" has joined team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
					  			sbr.sendAllTeamsMsg(pg + "There are now " + sbr.teamcyan.size() + " players on team " + ChatColor.AQUA + "CYAN.");
					  			sbr.sendAllTeamsMsg(pg + "There are now " + sbr.teamlime.size() + " players on team " + ChatColor.GREEN + "LIME.");
					  			return true;
					  		}
				  			plcmd.sendMessage(pg + "You are already on team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
				  			return true;

			  			}
			  			if(args[1].equalsIgnoreCase("lime"))
			  			{
					  		if(!sbr.teamlime.containsKey(plcmd.getName()))
					  		{
								if(getConfig().getInt("limescores." + plcmd.getName()) != 0)
								{
									sbr.teamlime.put(plcmd.getName(), getConfig().getInt("limescores." + plcmd.getName()));
								}
								else
								{
									sbr.teamlime.put(plcmd.getName(), 0);
								}
					  			plcmd.teleport(sbr.lobbyspawnlocation);
					  			sbr.sendAllTeamsMsg(pg + plcmd.getName() +" has joined team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
					  			sbr.sendAllTeamsMsg(pg + "There are now " + sbr.teamlime.size() + " players on team " + ChatColor.GREEN + "LIME.");
					  			sbr.sendAllTeamsMsg(pg + "There are now " + sbr.teamcyan.size() + " players on team " + ChatColor.AQUA + "CYAN.");
					  			return true;
					  		}
				  			plcmd.sendMessage(pg + "You are already on team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
				  			return true;
			  			}
			  			return false;
			  		}
			  		return false;
			  	case "leave":
			  		if(sbr.teamcyan.containsKey(plcmd.getName()))
			  		{
			  			if(sbr.teamcyaninarena.contains(plcmd.getName()))
			  			{
			  				sbr.teamcyaninarena.remove(plcmd.getName());
			  				plcmd.teleport(sbr.lobbyspawnlocation);
			  			}
			  			sbr.teamcyan.remove(plcmd.getName());
			  			plcmd.sendMessage(pg + "You've left team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
			  			sbr.sendAllTeamsMsg(pg + plcmd.getName() + " has left team " + ChatColor.AQUA + "CYAN" + ChatColor.RESET +"!");
			  			sbr.sendAllTeamsMsg(pg + "There are now " + sbr.teamcyan.size() + " players on team " + ChatColor.AQUA + "CYAN.");
			  			return true;
			  		}
			  		if(sbr.teamlime.containsKey(plcmd.getName()))
			  		{
			  			if(sbr.teamlimeinarena.contains(plcmd.getName()))
			  			{
			  				sbr.teamlimeinarena.remove(plcmd.getName());
			  				plcmd.teleport(sbr.lobbyspawnlocation);
			  			}
			  			sbr.teamlime.remove(plcmd.getName());
			  			plcmd.sendMessage(pg + "You've left team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
			  			sbr.sendAllTeamsMsg(pg + plcmd.getName() + " has left team " + ChatColor.GREEN + "LIME" + ChatColor.RESET +"!");
			  			sbr.sendAllTeamsMsg(pg + "There are now " + sbr.teamlime.size() + " players on team " + ChatColor.GREEN + "LIME.");
			  			return true;
			  		}
		  			plcmd.sendMessage(pg + "You are not on a team!");
		  			return true;
			  	case "score":
			  		if(sbr.teamcyan.containsKey(plcmd.getName()))
			  		{
			  			plcmd.sendMessage(pg + "Your score is " + sbr.teamcyan.get(plcmd.getName()) + ".");
			  		}
			  		else
			  		{
				  		if(sbr.teamlime.containsKey(plcmd.getName()))
				  		{
				  			plcmd.sendMessage(pg + "Your score is " + sbr.teamlime.get(plcmd.getName()) + ".");
				  		}
			  		}
			  		plcmd.sendMessage(pg + "You do not have a score yet.");
			  		return true;
			  }
		  }
	  }
	  return false;
  }
}