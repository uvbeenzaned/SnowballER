package co.networkery.uvbeenzaned;
 
import org.bukkit.Bukkit;
import org.bukkit.Location;

 
public final class LTSTL {
	
	public static Location str2loc(String str){
        String str2loc[]=str.split("\\:");
        Location loc = new Location(Bukkit.getServer().getWorld(str2loc[0]),0,0,0);
        loc.setX(Double.parseDouble(str2loc[1]));
        loc.setY(Double.parseDouble(str2loc[2]));
        loc.setZ(Double.parseDouble(str2loc[3]));
        return loc;
    }
 
    public static String loc2str(Location loc){
        return loc.getWorld().getName()+":"+loc.getBlockX()+":"+loc.getBlockY()+":"+loc.getBlockZ();
    }
}