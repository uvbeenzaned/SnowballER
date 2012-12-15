package co.networkery.uvbeenzaned;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Rank {

	public static void giveRank(Player pl)
	{
		int score = SnowballerListener.scores.getConfig().getInt(pl.getName());
		 String rank = "";
		 if(score <= -1)
		 {
			 rank = "Loser";
		 }
		 if(score >= 0 && score < 100)
		 {
			 rank = "Newbie";
		 }
		 if(score >= 100 && score < 300)
		 {
			 rank = "Beginner";
		 }
		 if(score >= 300 && score < 700)
		 {
			 rank = "Amature";
		 }
		 if(score >= 700 && score < 2000)
		 {
			 rank = "Intermediate";
		 }
		 if(score >= 2000 && score < 5000)
		 {
			 rank = "Master";
		 }
		 if(score >= 5000 && score < 10000)
		 {
			 rank = "Boss";
		 }
		 if(score >= 10000 && score < 20000)
		 {
			 rank = "Butch";
		 }
		 if(score >= 20000 && score < 50000)
		 {
			 rank = "Rex";
		 }
		 if(score >= 50000 && score < 100000)
		 {
			 rank = "Killer";
		 }
		 if(score >= 100000 && score < 500000)
		 {
			 rank = "Alpha";
		 }
		 if(score >= 500000 && score < 1000000)
		 {
			 rank = "Hunter";
		 }
		 if(score >= 1000000 && score < 5000000)
		 {
			rank = "Double"; 
		 }
		 if(score >= 5000000 && score < 10000000)
		 {
			 rank = "Winner";
		 }
		 if(score >= 10000000 && score < 100000000)
		 {
			 rank = "Ultimate";
		 }
		 if(score >= 100000000)
		 {
			 rank = "Chosen";
		 }
		switch(rank)
		{
			case "Loser":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.PINK));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Newbie":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.BROWN));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Beginner":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.RED));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Amature":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.MAGENTA));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Intermediate":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.PURPLE));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Master":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.BLUE));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Boss":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.LIGHT_BLUE));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Butch":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.CYAN));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Rex":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.GREEN));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Killer":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.LIME));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Alpha":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.YELLOW));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Hunter":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.ORANGE));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Double":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.BLACK));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Winner":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.GRAY));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Ultimate":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.SILVER));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
			case "Chosen":
			try {
				pl.getInventory().setChestplate(Armor.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), ArmorColor.WHITE));
			} catch (Exception e) {
				e.printStackTrace();
			}
				break;
		}
	}
	public static String getRankName(Player pl)
	{
		int score = SnowballerListener.scores.getConfig().getInt(pl.getName());
		 String rank = "";
		 if(score <= -1)
		 {
			 rank = "Loser";
		 }
		 if(score >= 0 && score < 100)
		 {
			 rank = "{R1}Newbie";
		 }
		 if(score >= 100 && score < 300)
		 {
			 rank = "{R2}Beginner";
		 }
		 if(score >= 300 && score < 700)
		 {
			 rank = "{R3}Amature";
		 }
		 if(score >= 700 && score < 2000)
		 {
			 rank = "{R4}Intermediate";
		 }
		 if(score >= 2000 && score < 5000)
		 {
			 rank = "{R5}Master";
		 }
		 if(score >= 5000 && score < 10000)
		 {
			 rank = "{R6}Boss";
		 }
		 if(score >= 10000 && score < 20000)
		 {
			 rank = "{R7}Butch";
		 }
		 if(score >= 20000 && score < 50000)
		 {
			 rank = "{R8}Rex";
		 }
		 if(score >= 50000 && score < 100000)
		 {
			 rank = "{R9}Killer";
		 }
		 if(score >= 100000 && score < 500000)
		 {
			 rank = "{R10}Alpha";
		 }
		 if(score >= 500000 && score < 1000000)
		 {
			 rank = "{R11}Hunter";
		 }
		 if(score >= 1000000 && score < 5000000)
		 {
			rank = "{R12}Double"; 
		 }
		 if(score >= 5000000 && score < 10000000)
		 {
			 rank = "{R13}Winner";
		 }
		 if(score >= 10000000 && score < 100000000)
		 {
			 rank = "{R14}Ultimate";
		 }
		 if(score >= 100000000)
		 {
			 rank = "{R15}Chosen";
		 }
		return rank;
	}
}
