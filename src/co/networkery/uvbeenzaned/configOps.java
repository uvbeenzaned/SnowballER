package co.networkery.uvbeenzaned;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class configOps{

	public static ConfigAccessor cA;
	
	public configOps(JavaPlugin jp)
	{
		cA = new ConfigAccessor(jp, "config.yml");
	}
	
	public static void load()
	{
		cA.saveDefaultConfig();
		if(cA.getConfig().getInt("timerdelay") != 0)
		{
			SnowballerListener.timerdelay = cA.getConfig().getInt("timerdelay");
		}
		else
		{
			SnowballerListener.timerdelay = 30000;
		}
		if(cA.getConfig().getString("lobbyspawnlocation") != null && cA.getConfig().getString("lobbyspawnlocation") != "")
		{
			SnowballerListener.lobbyspawnlocation = LTSTL.str2loc(cA.getConfig().getString("lobbyspawnlocation"));
		}
		if(cA.getConfig().getConfigurationSection("teamcyanarenasides").getKeys(false) != null)
		{
			for(String key : cA.getConfig().getConfigurationSection("teamcyanarenasides").getKeys(false))
			{
				if(cA.getConfig().getString("teamcyanarenasides." + key) != null)
				{
					SnowballerListener.teamcyanarenasides.put(key, LTSTL.str2loc(cA.getConfig().getString("teamcyanarenasides." + key)));
				}
			}
		}
		if(cA.getConfig().getConfigurationSection("teamlimearenasides").getKeys(false) != null)
		{
			for(String key : cA.getConfig().getConfigurationSection("teamlimearenasides").getKeys(false))
			{
				if(cA.getConfig().getString("teamlimearenasides." + key) != null)
				{
					SnowballerListener.teamlimearenasides.put(key, LTSTL.str2loc(cA.getConfig().getString("teamlimearenasides." + key)));
				}
			}
		}
		//shows system time in ms for an example of what the seed for the random engine will look like
		//log.info("Current system time in ms: " + Long.toString(System.currentTimeMillis()));
	}
	
	public static void save()
	{
		//save timer delay in ms for continuus no admin games
		  if(SnowballerListener.timerdelay != 0)
		  {
			  cA.getConfig().set("timerdelay", SnowballerListener.timerdelay);
		  }
		  //save lobby spawn location
		  if(SnowballerListener.lobbyspawnlocation != null)
		  {
			  cA.getConfig().set("lobbyspawnlocation", LTSTL.loc2str(SnowballerListener.lobbyspawnlocation));
		  }
		  //save team sides in serializable location format
		  for(Entry<String, Location> entry : SnowballerListener.teamcyanarenasides.entrySet())
		  {
			  cA.getConfig().set("teamcyanarenasides." + entry.getKey(), LTSTL.loc2str(entry.getValue()));
		  }
		  for(Entry<String, Location> entry : SnowballerListener.teamlimearenasides.entrySet())
		  {
			  cA.getConfig().set("teamlimearenasides." + entry.getKey(), LTSTL.loc2str(entry.getValue()));
		  }
		  //temporary collective scores list
		  HashMap<String, Integer> tmpscores = new HashMap<String, Integer>();
		  //save team scores
		  for(Entry<String, Integer> entry : SnowballerListener.teamcyan.entrySet())
		  {
			  tmpscores.put(entry.getKey(), entry.getValue());
		  }
		  for(Entry<String, Integer> entry : SnowballerListener.teamlime.entrySet())
		  {
			  tmpscores.put(entry.getKey(), entry.getValue());
		  }
		  for(Entry<String, Integer> entry : tmpscores.entrySet())
		  {
			  cA.getConfig().set("scores." + entry.getKey(), Integer.toString(entry.getValue()));
		  }
		  //save all config to file
		  cA.saveConfig();
	}
	
	public static void saveScores()
	{
		  //temporary collective scores list
		  HashMap<String, Integer> tmpscores = new HashMap<String, Integer>();
		  //save team scores
		  for(Entry<String, Integer> entry : SnowballerListener.teamcyan.entrySet())
		  {
			  tmpscores.put(entry.getKey(), entry.getValue());
		  }
		  for(Entry<String, Integer> entry : SnowballerListener.teamlime.entrySet())
		  {
			  tmpscores.put(entry.getKey(), entry.getValue());
		  }
		  for(Entry<String, Integer> entry : tmpscores.entrySet())
		  {
			  cA.getConfig().set("scores." + entry.getKey(), Integer.toString(entry.getValue()));
		  }
		  cA.saveConfig();
	}
}
