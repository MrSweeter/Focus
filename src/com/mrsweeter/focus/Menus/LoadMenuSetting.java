package com.mrsweeter.focus.Menus;

import org.bukkit.inventory.Inventory;

import com.mrsweeter.focus.FocusGame;

public class LoadMenuSetting {
	
	public static void loadGamemode(FocusGame fg)	{
	}
	
	public static void loadGamemodeOptions(FocusGame fg)	{
		
		int nbreToWin = fg.getLimitVictories();
		String type = fg.getVictories();
		
		Inventory inv = fg.getGamemodeSetting();
		if (fg.getGamemode().equals("Deathmatch"))	{
			Settings.victoriesType_meta.setDisplayName("§6§l" + type);
		} else if (fg.getGamemode().equals("Roundup"))	{
			Settings.victoriesType_meta.setDisplayName("§6§l" + type);
			Settings.nbreWin_meta.setDisplayName("§6§lNumber of round to win: §c§l" + nbreToWin);
		}
		if (fg.getVictories().equals("Kills"))	{
			Settings.nbreWin_meta.setDisplayName("§6§lNumber of kill: §c§l" + nbreToWin);
		} else if (fg.getVictories().equals("Rounds"))	{
			Settings.nbreWin_meta.setDisplayName("§6§lNumber of round: §c§l" + nbreToWin);
		}
		Settings.actuGamemodeOptions();
		inv.setItem(21, Settings.victoriesType);
		inv.setItem(23, Settings.nbreWin);
		inv.setItem(37, Settings.back);
		inv.setItem(40, Settings.launch);
		inv.setItem(43, Settings.options);
	}
	public static void loadOptions(FocusGame fg)	{
		
		Inventory inv = fg.getOptionsSetting();
		
		if (fg.getDisplayHP())	{
			Settings.disableHp_meta.setDisplayName("§6§lDisplay remaining hp: §a§lenable");
			Settings.disableHp.setItemMeta(Settings.disableHp_meta);
		} else {
			Settings.disableHp_meta.setDisplayName("§6§lDisplay remaining hp: §c§ldisable");
			Settings.disableHp.setItemMeta(Settings.disableHp_meta);
		}
		
		inv.setItem(21, Settings.mapChoice);
		inv.setItem(22, Settings.disableItem);
		inv.setItem(30, Settings.scoring);
		inv.setItem(32, Settings.disableHp);
		inv.setItem(37, Settings.back);
	}
	public static void loadMaps(FocusGame fg)	{
		
		Inventory inv = fg.getMapsSetting();
		
		inv.setItem(20, Settings.treeMap);
		inv.setItem(21, Settings.ruinsMap);
		inv.setItem(22, Settings.isletMap);
		inv.setItem(23, Settings.ruptureMap);
		inv.setItem(24, Settings.tunnelsMap);
		inv.setItem(30, Settings.templeMap);
		inv.setItem(31, Settings.iceMap);
		inv.setItem(32, Settings.vulcanoMap);
		inv.setItem(37, Settings.back);
		
	}
	public static void loadStuff(FocusGame fg)	{
		
		Inventory inv = fg.getStuffSetting();
		
		Settings.helmet.setItemMeta(Settings.helmet_meta);
		Settings.chestplate.setItemMeta(Settings.chestplate_meta);
		Settings.leggings.setItemMeta(Settings.leggings_meta);
		Settings.boots.setItemMeta(Settings.boots_meta);
		Settings.shield.setItemMeta(Settings.shield_meta);
		
		inv.setItem(13, Settings.helmet);
		inv.setItem(22, Settings.chestplate);
		inv.setItem(31, Settings.leggings);
		inv.setItem(40, Settings.boots);
		inv.setItem(21, Settings.sword);
		inv.setItem(30, Settings.axe);
		inv.setItem(39, Settings.shield);		
		inv.setItem(14, Settings.enderpearl);		
		inv.setItem(23, Settings.bow);		
		inv.setItem(41, Settings.smoke);
		inv.setItem(37, Settings.back);
		
	}
	public static void loadPoints(FocusGame fg)	{
		
		Inventory inv = fg.getPointsSetting();
		
		Settings.pointBeginning_meta.setDisplayName("§6§lPoints at the beginning:§c§l " + fg.getStartingPoint());
		Settings.pointWinRound_meta.setDisplayName("§6§lPoints per round win:§c§l " + fg.getRoundPoint());
		Settings.pointKill_meta.setDisplayName("§6§lPoints per kill:§c§l " + fg.getKillPoint());
		
		Settings.pointBeginning.setItemMeta(Settings.pointBeginning_meta);
		Settings.pointWinRound.setItemMeta(Settings.pointWinRound_meta);
		Settings.pointKill.setItemMeta(Settings.pointKill_meta);
		
		inv.setItem(21, Settings.pointBeginning);		
		inv.setItem(23, Settings.pointWinRound);		
		inv.setItem(31, Settings.pointKill);
		inv.setItem(37, Settings.back);
		inv.setItem(43, Settings.reset);
		
	}

}
