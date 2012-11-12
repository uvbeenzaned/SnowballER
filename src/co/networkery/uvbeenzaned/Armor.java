package co.networkery.uvbeenzaned;

import java.awt.Color;

import net.minecraft.server.NBTTagCompound;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
 
/**
 * Class, that allows setting and getting color of the leather armor.
 */
public class Armor {
 
    /**
     * Sets the color.
     *
     * @param item item to color
     * @param color color
     * @return colored item
     * @throws Exception thrown,  when item is not applicable
     */
    public static ItemStack setColor(ItemStack item, int color) throws Exception {
        if (!isApplicable(item))
            throw new Exception("Item is not applicable!");
        CraftItemStack craftStack = null;
        net.minecraft.server.ItemStack itemStack = null;
        if (item instanceof CraftItemStack) {
            craftStack = (CraftItemStack) item;
            itemStack = craftStack.getHandle();
        }
        else if (item instanceof ItemStack) {
            craftStack = new CraftItemStack(item);
            itemStack = craftStack.getHandle();
        }
        NBTTagCompound tag = itemStack.tag;
        if (tag == null) {
            tag = new NBTTagCompound();
            tag.setCompound("display", new NBTTagCompound());
            itemStack.tag = tag;
        }
 
        tag = itemStack.tag.getCompound("display");
        tag.setInt("color", color);
        itemStack.tag.setCompound("display", tag);
        return craftStack;
    }
 
    /**
     * Checks if item is applicable.
     *
     * @param item the item to check
     * @return true, if is applicable
     */
    private static boolean isApplicable(ItemStack item) {
        switch (item.getType()) {
            case LEATHER_BOOTS:
            case LEATHER_CHESTPLATE:
            case LEATHER_HELMET:
            case LEATHER_LEGGINGS:
                return true;
            default:
                return false;
        }
    }
 
    /**
     * Sets the color.
     *
     * @param item item to color
     * @param color color
     * @return colored item
     * @throws Exception thrown,  when item is not applicable
     */
    public static ItemStack setColor(ItemStack item, Color color) throws Exception {
        if (!isApplicable(item))
            throw new Exception("Item is not applicable!");
        CraftItemStack craftStack = null;
        net.minecraft.server.ItemStack itemStack = null;
        if (item instanceof CraftItemStack) {
            craftStack = (CraftItemStack) item;
            itemStack = craftStack.getHandle();
        }
        else if (item instanceof ItemStack) {
            craftStack = new CraftItemStack(item);
            itemStack = craftStack.getHandle();
        }
        NBTTagCompound tag = itemStack.tag;
        if (tag == null) {
            tag = new NBTTagCompound();
            tag.setCompound("display", new NBTTagCompound());
            itemStack.tag = tag;
        }
 
        tag = itemStack.tag.getCompound("display");
        tag.setInt("color", color.getRGB());
        itemStack.tag.setCompound("display", tag);
        return craftStack;
    }
 
    /**
     * Sets the color.
     *
     * @param item item to color
     * @param color color
     * @return colored item
     * @throws Exception thrown,  when item is not applicable
     */
    public static ItemStack setColor(ItemStack item, ArmorColor color) throws Exception {
        if (!isApplicable(item))
            throw new Exception("Item is not applicable!");
        CraftItemStack craftStack = null;
        net.minecraft.server.ItemStack itemStack = null;
        if (item instanceof CraftItemStack) {
            craftStack = (CraftItemStack) item;
            itemStack = craftStack.getHandle();
        }
        else if (item instanceof ItemStack) {
            craftStack = new CraftItemStack(item);
            itemStack = craftStack.getHandle();
        }
        NBTTagCompound tag = itemStack.tag;
        if (tag == null) {
            tag = new NBTTagCompound();
            tag.setCompound("display", new NBTTagCompound());
            itemStack.tag = tag;
        }
 
        tag = itemStack.tag.getCompound("display");
        tag.setInt("color", color.getColor());
        itemStack.tag.setCompound("display", tag);
        return craftStack;
    }
 
    /**
     * Sets the color.
     *
     * @param item item to color
     * @param colorStr color
     * @return colored item
     * @throws Exception thrown,  when item is not applicable
     */
    public static ItemStack setColor(ItemStack item, String colorStr)throws Exception{
        if (!isApplicable(item))
            throw new Exception("Item is not applicable!");
        int color = Integer.decode(colorStr);
        CraftItemStack craftStack = null;
        net.minecraft.server.ItemStack itemStack = null;
        if (item instanceof CraftItemStack) {
            craftStack = (CraftItemStack) item;
            itemStack = craftStack.getHandle();
        }
        else if (item instanceof ItemStack) {
            craftStack = new CraftItemStack(item);
            itemStack = craftStack.getHandle();
        }
        NBTTagCompound tag = itemStack.tag;
        if (tag == null) {
            tag = new NBTTagCompound();
            tag.setCompound("display", new NBTTagCompound());
            itemStack.tag = tag;
        }
 
        tag = itemStack.tag.getCompound("display");
        tag.setInt("color", color);
        itemStack.tag.setCompound("display", tag);
        return craftStack;
    }
 
    /**
     * Sets the color.
     *
     * @param item item to color
     * @param colorR amount of red
     * @param colorG amount of green
     * @param colorB amount of blue
     * @return colored item
     * @throws Exception thrown,  when item is not applicable
     */
    public static ItemStack setColor(ItemStack item, int colorR, int colorG, int colorB)throws Exception{
        if (!isApplicable(item))
            throw new Exception("Item is not applicable!");
        int color = Integer.decode(ColorConverter.toHex(colorR, colorG, colorB));
        CraftItemStack craftStack = null;
        net.minecraft.server.ItemStack itemStack = null;
        if (item instanceof CraftItemStack) {
            craftStack = (CraftItemStack) item;
            itemStack = craftStack.getHandle();
        }
        else if (item instanceof ItemStack) {
            craftStack = new CraftItemStack(item);
            itemStack = craftStack.getHandle();
        }
        NBTTagCompound tag = itemStack.tag;
        if (tag == null) {
            tag = new NBTTagCompound();
            tag.setCompound("display", new NBTTagCompound());
            itemStack.tag = tag;
        }
 
        tag = itemStack.tag.getCompound("display");
        tag.setInt("color", color);
        itemStack.tag.setCompound("display", tag);
        return craftStack;
    }
 
    /**
     * Gets the color.
     *
     * @param item colored item
     * @return color
     * @throws Exception thrown,  when item is not applicable
     */
    public static int getColor(ItemStack item) throws Exception {
        if (!isApplicable(item))
            throw new Exception("Item is not applicable!");
        CraftItemStack craftStack = null;
        net.minecraft.server.ItemStack itemStack = null;
        if (item instanceof CraftItemStack) {
            craftStack = (CraftItemStack) item;
            itemStack = craftStack.getHandle();
        }
        else if (item instanceof ItemStack) {
            craftStack = new CraftItemStack(item);
            itemStack = craftStack.getHandle();
        }
        NBTTagCompound tag = itemStack.tag;
        if (tag == null) {
            tag = new NBTTagCompound();
            tag.setCompound("display", new NBTTagCompound());
            itemStack.tag = tag;
            return -1;
        }
 
        tag = itemStack.tag.getCompound("display");
        return tag.getInt("color");
    }
}