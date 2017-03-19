package com.mrsweeter.focus.Menus;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChooseColor {
	
	private static final ItemStack DARK_RED = new ItemStack(Material.REDSTONE_BLOCK);
	private static final ItemStack RED = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
	private static final ItemStack GOLD = new ItemStack(Material.GOLD_BLOCK);
	private static final ItemStack YELLOW = new ItemStack(Material.WOOL, 1, (short) 4);
	private static final ItemStack DARK_GREEN = new ItemStack(Material.WOOL, 1, (short) 13);
	private static final ItemStack GREEN = new ItemStack(Material.WOOL, 1, (short) 5);
	private static final ItemStack AQUA = new ItemStack(Material.DIAMOND_BLOCK);
	private static final ItemStack DARK_AQUA = new ItemStack(Material.WOOL, 1, (short) 9);
	private static final ItemStack DARK_BLUE = new ItemStack(Material.WOOL, 1, (short) 11);
	private static final ItemStack BLUE = new ItemStack(Material.WOOL, 1, (short) 3);
	private static final ItemStack LIGHT_PURPLE = new ItemStack(Material.WOOL, 1, (short) 2);
	private static final ItemStack DARK_PURPLE = new ItemStack(Material.WOOL, 1, (short) 10);
	private static final ItemStack WHITE = new ItemStack(Material.IRON_BLOCK);
	private static final ItemStack GRAY = new ItemStack(Material.WOOL, 1, (short) 8);
	private static final ItemStack DARK_GRAY = new ItemStack(Material.STAINED_CLAY, 1, (short) 9);
	private static final ItemStack BLACK = new ItemStack(Material.COAL_BLOCK);
	
	private static final ItemMeta DARK_RED_META = DARK_RED.getItemMeta();
	private static final ItemMeta RED_META = RED.getItemMeta();
	private static final ItemMeta GOLD_META = GOLD.getItemMeta();
	private static final ItemMeta YELLOW_META = YELLOW.getItemMeta();
	private static final ItemMeta DARK_GREEN_META = DARK_GREEN.getItemMeta();
	private static final ItemMeta GREEN_META = GREEN.getItemMeta();
	private static final ItemMeta AQUA_META = AQUA.getItemMeta();
	private static final ItemMeta DARK_AQUA_META = DARK_AQUA.getItemMeta();
	private static final ItemMeta DARK_BLUE_META = DARK_BLUE.getItemMeta();
	private static final ItemMeta BLUE_META = BLUE.getItemMeta();
	private static final ItemMeta LIGHT_PURPLE_META = LIGHT_PURPLE.getItemMeta();
	private static final ItemMeta DARK_PURPLE_META = DARK_PURPLE.getItemMeta();
	private static final ItemMeta WHITE_META = WHITE.getItemMeta();
	private static final ItemMeta GRAY_META = GRAY.getItemMeta();
	private static final ItemMeta DARK_GRAY_META = DARK_GRAY.getItemMeta();
	private static final ItemMeta BLACK_META = BLACK.getItemMeta();
	
	public static Inventory fillColor(Inventory menu)	{
		
		DARK_RED_META.setDisplayName("§4§lDark red");
		DARK_RED.setItemMeta(DARK_RED_META);
		menu.addItem(DARK_RED);
		
		RED_META.setDisplayName("§c§lRed");
		RED.setItemMeta(RED_META);
		menu.addItem(RED);
		
		GOLD_META.setDisplayName("§6§lGold");
		GOLD.setItemMeta(GOLD_META);
		menu.addItem(GOLD);
		
		YELLOW_META.setDisplayName("§e§lYellow");
		YELLOW.setItemMeta(YELLOW_META);
		menu.addItem(YELLOW);
		
		DARK_GREEN_META.setDisplayName("§2§lDark green");
		DARK_GREEN.setItemMeta(DARK_GREEN_META);
		menu.addItem(DARK_GREEN);
		
		GREEN_META.setDisplayName("§a§lGreen");
		GREEN.setItemMeta(GREEN_META);
		menu.addItem(GREEN);
		
		AQUA_META.setDisplayName("§b§lAqua");
		AQUA.setItemMeta(AQUA_META);
		menu.addItem(AQUA);
		
		DARK_AQUA_META.setDisplayName("§3§lDark aqua");
		DARK_AQUA.setItemMeta(DARK_AQUA_META);
		menu.addItem(DARK_AQUA);
		
		DARK_BLUE_META.setDisplayName("§1§lDark blue");
		DARK_BLUE.setItemMeta(DARK_BLUE_META);
		menu.addItem(DARK_BLUE);
		
		BLUE_META.setDisplayName("§9§lBlue");
		BLUE.setItemMeta(BLUE_META);
		menu.addItem(BLUE);
		
		LIGHT_PURPLE_META.setDisplayName("§d§lLight purple");
		LIGHT_PURPLE.setItemMeta(LIGHT_PURPLE_META);
		menu.addItem(LIGHT_PURPLE);
		
		DARK_PURPLE_META.setDisplayName("§5§lDark purple");
		DARK_PURPLE.setItemMeta(DARK_PURPLE_META);
		menu.addItem(DARK_PURPLE);
		
		WHITE_META.setDisplayName("§f§lWhite");
		WHITE.setItemMeta(WHITE_META);
		menu.addItem(WHITE);
		
		GRAY_META.setDisplayName("§7§lGray");
		GRAY.setItemMeta(GRAY_META);
		menu.addItem(GRAY);
		
		DARK_GRAY_META.setDisplayName("§8§lDark gray");
		DARK_GRAY.setItemMeta(DARK_GRAY_META);
		menu.addItem(DARK_GRAY);
		
		BLACK_META.setDisplayName("§0§lBlack");
		BLACK.setItemMeta(BLACK_META);
		menu.addItem(BLACK);
		
		return menu;
		
	}

}
