package co.networkery.uvbeenzaned;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.Color;

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
				pl.getInventory().setChestplate(colorArmor(255, 0, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Newbie":
			try {
				pl.getInventory().setChestplate(colorArmor(255, 74 ,0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Beginner":
			try {
				pl.getInventory().setChestplate(colorArmor(255, 119, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Amature":
			try {
				pl.getInventory().setChestplate(colorArmor(255, 195, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Intermediate":
			try {
				pl.getInventory().setChestplate(colorArmor(255, 255, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Master":
			try {
				pl.getInventory().setChestplate(colorArmor(204, 255, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Boss":
			try {
				pl.getInventory().setChestplate(colorArmor(0, 255, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Butch":
			try {
				pl.getInventory().setChestplate(colorArmor(0, 255, 255));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Rex":
			try {
				pl.getInventory().setChestplate(colorArmor(0, 0, 255));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Killer":
			try {
				pl.getInventory().setChestplate(colorArmor(89, 0, 255));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Alpha":
			try {
				pl.getInventory().setChestplate(colorArmor(255, 0, 255));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Hunter":
			try {
				pl.getInventory().setChestplate(colorArmor(255, 0, 78));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Double":
			try {
				pl.getInventory().setChestplate(colorArmor(0, 0, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Winner":
			try {
				pl.getInventory().setChestplate(colorArmor(96, 96, 96));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Ultimate":
			try {
				pl.getInventory().setChestplate(colorArmor(160, 160, 160));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Chosen":
			try {
				pl.getInventory().setChestplate(colorArmor(255, 255, 255));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
	public static String getRankName(String pl)
	{
		int score = SnowballerListener.scores.getConfig().getInt(pl);
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

	private static ItemStack colorArmor(int r, int g, int b)
	{
		ItemStack cp = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta m = (LeatherArmorMeta)cp.getItemMeta();
		m.setColor(Color.fromRGB(r, g, b));
		cp.setItemMeta(m);
		return cp;
	}
}
