package co.networkery.uvbeenzaned;

import org.bukkit.Bukkit;

public class Chat {
	
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
}
