package com.mrsweeter.focus.Events;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.DisplaySlot;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.Menus.LoadMenuSetting;
import com.mrsweeter.focus.Menus.Settings;
import com.mrsweeter.focus.PlayerIG.Teams;

public class ClickSettings {
	
	public static void settingGame(InventoryClickEvent event, Focus pl)	{
		
		FocusGame fg = pl.getFg();
		String nameItem = event.getCurrentItem().getItemMeta().getDisplayName();
		ItemStack item = event.getCurrentItem();
		ItemMeta itemMeta = event.getCurrentItem().getItemMeta();
		
		switch (nameItem)	{
		case "§6§lDeathmatch":
			fg.setGamemode("Roundup");
			fg.setVictories("Victories");
			fg.setLimitVictories(3);
			itemMeta.setDisplayName("§6§lRoundup");
			break;
		case "§6§lRoundup":
			fg.setGamemode("Deathmatch");
			fg.setVictories("Kills");
			fg.setLimitVictories(10);
			itemMeta.setDisplayName("§6§lDeathmatch");
			break;
		case "§6§lRandom":
			fg.getMapsInGame().clear();
			fg.addMapsInGame("tree");
			fg.setMaps("notRandom");
			itemMeta.setDisplayName("§6§lTree");
			break;
		case "§6§lTree":
			fg.getMapsInGame().clear();
			fg.addMapsInGame("ruins");
			itemMeta.setDisplayName("§6§lRuins");
			break;
		case "§6§lRuins":
			fg.getMapsInGame().clear();
			fg.addMapsInGame("islet");
			itemMeta.setDisplayName("§6§lIslet");
			break;
		case "§6§lIslet":
			fg.getMapsInGame().clear();
			fg.addMapsInGame("rupture");
			itemMeta.setDisplayName("§6§lRupture");
			break;
		case "§6§lRupture":
			fg.getMapsInGame().clear();
			fg.addMapsInGame("tunnels");
			itemMeta.setDisplayName("§6§lTunnels");
			break;
		case "§6§lTunnels":
			fg.getMapsInGame().clear();
			fg.addMapsInGame("temple");
			itemMeta.setDisplayName("§6§lTemple");
			break;
		case "§6§lTemple":
			fg.getMapsInGame().clear();
			fg.addMapsInGame("ice");
			itemMeta.setDisplayName("§6§lIce");
			break;
		case "§6§lIce":
			fg.getMapsInGame().clear();
			fg.addMapsInGame("vulcano");
			itemMeta.setDisplayName("§6§lVulcano");
			break;
		case "§6§lVulcano":
			fg.getMapsInGame().clear();
			fg.fillMap();
			fg.setMaps("random");
			itemMeta.setDisplayName("§6§lRandom");
			break;
		case "§a§lnext":
			LoadMenuSetting.loadGamemodeOptions(fg);
			event.getWhoClicked().openInventory(fg.getGamemodeSetting());
			break;
		}
		
		item.setItemMeta(itemMeta);
		event.setCancelled(true);
		
	}
	
	public static void settingGamemode(InventoryClickEvent event, Focus pl)	{
		
		FocusGame fg = pl.getFg();
		String nameItem = event.getCurrentItem().getItemMeta().getDisplayName();
		ItemStack item = event.getCurrentItem();
		ItemMeta itemMeta = event.getCurrentItem().getItemMeta();
		
		switch (nameItem)	{
		case "§6§lKills":
			fg.setVictories("Rounds");
			fg.setLimitVictories(5);
			itemMeta.setDisplayName("§6§lRounds");
			Settings.nbreWin_meta.setDisplayName("§6§lNumber of round: §c§l" + fg.getLimitVictories());
			Settings.nbreWin.setItemMeta(Settings.nbreWin_meta);
			event.getInventory().setItem(23, Settings.nbreWin);
			break;
		case "§6§lRounds":
			fg.setVictories("Kills");
			fg.setLimitVictories(5);
			itemMeta.setDisplayName("§6§lKills");
			Settings.nbreWin_meta.setDisplayName("§6§lNumber of kill: §c§l" + fg.getLimitVictories());
			Settings.nbreWin.setItemMeta(Settings.nbreWin_meta);
			event.getInventory().setItem(23, Settings.nbreWin);
			break;
		case "§6§lVictories":
			break;
		case "§6§lNumber of round to win: §c§l3":
			fg.setLimitVictories(5);
			itemMeta.setDisplayName("§6§lNumber of round to win: §c§l5");
			break;
		case "§6§lNumber of round to win: §c§l5":
			fg.setLimitVictories(7);
			itemMeta.setDisplayName("§6§lNumber of round to win: §c§l7");
			break;
		case "§6§lNumber of round to win: §c§l7":
			fg.setLimitVictories(9);
			itemMeta.setDisplayName("§6§lNumber of round to win: §c§l9");
			break;
		case "§6§lNumber of round to win: §c§l9":
			fg.setLimitVictories(3);
			itemMeta.setDisplayName("§6§lNumber of round to win: §c§l3");
			break;
		case "§6§lNumber of kill: §c§l5":
			fg.setLimitVictories(10);
			itemMeta.setDisplayName("§6§lNumber of kill: §c§l10");
			break;
		case "§6§lNumber of kill: §c§l10":
			fg.setLimitVictories(15);
			itemMeta.setDisplayName("§6§lNumber of kill: §c§l15");
			break;
		case "§6§lNumber of kill: §c§l15":
			fg.setLimitVictories(20);
			itemMeta.setDisplayName("§6§lNumber of kill: §c§l20");
			break;
		case "§6§lNumber of kill: §c§l20":
			fg.setLimitVictories(5);
			itemMeta.setDisplayName("§6§lNumber of kill: §c§l5");
			break;
		case "§6§lNumber of round: §c§l5":
			fg.setLimitVictories(10);
			itemMeta.setDisplayName("§6§lNumber of round: §c§l10");
			break;
		case "§6§lNumber of round: §c§l10":
			fg.setLimitVictories(15);
			itemMeta.setDisplayName("§6§lNumber of round: §c§l15");
			break;
		case "§6§lNumber of round: §c§l15":
			fg.setLimitVictories(20);
			itemMeta.setDisplayName("§6§lNumber of round: §c§l20");
			break;
		case "§6§lNumber of round: §c§l20":
			fg.setLimitVictories(25);
			itemMeta.setDisplayName("§6§lNumber of round: §c§l25");
			break;
		case "§6§lNumber of round: §c§l25":
			fg.setLimitVictories(30);
			itemMeta.setDisplayName("§6§lNumber of round: §c§l30");
			break;
		case "§6§lNumber of round: §c§l30":
			fg.setLimitVictories(5);
			itemMeta.setDisplayName("§6§lNumber of round: §c§l5");
			break;
		case "§c§lLaunch game":
			if (fg.getPlayersInGame().size() >= 2 && fg.isGameState(GameState.LOBBY))	{
				pl.getFg().setInConfig(false);
				event.getWhoClicked().sendMessage("§aConfiguration save");
				fg.tellSettings(event.getWhoClicked());
				event.getWhoClicked().sendMessage("§cVerify your configuration above");
				fg.launchGame();
			} else	{
				event.getWhoClicked().sendMessage("§cNot enough player or game already launch");
			}
			break;
		case "§a§lback":
			LoadMenuSetting.loadGamemode(fg);
			event.getWhoClicked().openInventory(fg.getInventorySetting());
			break;
		case "§a§lnext":
			LoadMenuSetting.loadOptions(fg);
			event.getWhoClicked().openInventory(fg.getOptionsSetting());
			break;
		}
		
		item.setItemMeta(itemMeta);
		event.setCancelled(true);
		
	}
	
	public static void settingOptions(InventoryClickEvent event, Focus pl)	{
		
		FocusGame fg = pl.getFg();
		String nameItem = event.getCurrentItem().getItemMeta().getDisplayName();
		ItemStack item = event.getCurrentItem();
		ItemMeta itemMeta = event.getCurrentItem().getItemMeta();
		
		switch (nameItem)	{
		case "§6§lRandom map choice":
			if (pl.getFg().getMapsInGame().size() > 1 || fg.getMaps().equals("random"))	{
				LoadMenuSetting.loadMaps(fg);
				event.getWhoClicked().openInventory(fg.getMapsSetting());
			} else {
				event.getWhoClicked().sendMessage("§cMaps configuration is not allowed when you define a map (first menu)");
			}
			break;
		case "§6§lDisable items":
			LoadMenuSetting.loadStuff(fg);
			event.getWhoClicked().openInventory(fg.getStuffSetting());
			break;
		case "§6§lScoring configuration":
			LoadMenuSetting.loadPoints(fg);
			event.getWhoClicked().openInventory(fg.getPointsSetting());
			break;
		case "§6§lDisplay remaining hp: §a§lenable":
			fg.setDisplayHP(false);
			itemMeta.setDisplayName("§6§lDisplay remaining hp: §c§ldisable");
			Teams.life.setDisplaySlot(null);
			break;
		case "§6§lDisplay remaining hp: §c§ldisable":
			fg.setDisplayHP(true);
			Teams.life.setDisplaySlot(DisplaySlot.BELOW_NAME);
			for (Player player : Bukkit.getOnlinePlayers())	{
				player.setScoreboard(Teams.scoreLife);
			}
			itemMeta.setDisplayName("§6§lDisplay remaining hp: §a§lenable");
			break;
		case "§a§lback":
			LoadMenuSetting.loadGamemodeOptions(fg);
			event.getWhoClicked().openInventory(fg.getGamemodeSetting());
			break;
		}
			
		item.setItemMeta(itemMeta);	
		event.setCancelled(true);
		
	}
	public static void settingMaps(InventoryClickEvent event, Focus pl)	{
		
		FocusGame fg = pl.getFg();
		String nameItem = event.getCurrentItem().getItemMeta().getDisplayName().substring(4);
		ItemStack item = event.getCurrentItem();
		ItemMeta itemMeta = event.getCurrentItem().getItemMeta();
		
		switch (nameItem)	{
		case "Tree":
			if (item.getType() == Material.MAP)	{
				fg.removeMapsInGame("tree");
				item.setType(Material.EMPTY_MAP);
				Settings.treeMap.setType(Material.EMPTY_MAP);
			} else {
				fg.addMapsInGame("tree");
				item.setType(Material.MAP);
				Settings.treeMap.setType(Material.MAP);
			}
			break;
		case "Ruins":
			if (item.getType() == Material.MAP)	{
				fg.removeMapsInGame("ruins");
				item.setType(Material.EMPTY_MAP);
				Settings.ruinsMap.setType(Material.EMPTY_MAP);
			} else {
				fg.addMapsInGame("ruins");
				item.setType(Material.MAP);
				Settings.ruinsMap.setType(Material.MAP);
			}
			break;
		case "Islet":
			if (item.getType() == Material.MAP)	{
				fg.removeMapsInGame("islet");
				item.setType(Material.EMPTY_MAP);
				Settings.isletMap.setType(Material.EMPTY_MAP);
			} else {
				fg.addMapsInGame("islet");
				item.setType(Material.MAP);
				Settings.isletMap.setType(Material.MAP);
			}
			break;
		case "Rupture":
			if (item.getType() == Material.MAP)	{
				fg.removeMapsInGame("rupture");
				item.setType(Material.EMPTY_MAP);
				Settings.ruptureMap.setType(Material.EMPTY_MAP);
			} else {
				fg.addMapsInGame("rupture");
				item.setType(Material.MAP);
				Settings.ruptureMap.setType(Material.MAP);
			}
			break;
		case "Tunnels":
			if (item.getType() == Material.MAP)	{
				fg.removeMapsInGame("tunnels");
				item.setType(Material.EMPTY_MAP);
				Settings.tunnelsMap.setType(Material.EMPTY_MAP);
			} else {
				fg.addMapsInGame("tunnels");
				item.setType(Material.MAP);
				Settings.tunnelsMap.setType(Material.MAP);
			}
			break;
		case "Temple":
			if (item.getType() == Material.MAP)	{
				fg.removeMapsInGame("temple");
				item.setType(Material.EMPTY_MAP);
				Settings.templeMap.setType(Material.EMPTY_MAP);
			} else {
				fg.addMapsInGame("temple");
				item.setType(Material.MAP);
				Settings.templeMap.setType(Material.MAP);
			}
			break;
		case "Ice":
			if (item.getType() == Material.MAP)	{
				fg.removeMapsInGame("ice");
				item.setType(Material.EMPTY_MAP);
				Settings.iceMap.setType(Material.EMPTY_MAP);
			} else {
				fg.addMapsInGame("ice");
				item.setType(Material.MAP);
				Settings.iceMap.setType(Material.MAP);
			}
			break;
		case "Vulcano":
			if (item.getType() == Material.MAP)	{
				fg.removeMapsInGame("vulcano");
				item.setType(Material.EMPTY_MAP);
				Settings.vulcanoMap.setType(Material.EMPTY_MAP);
			} else {
				fg.addMapsInGame("vulcano");
				item.setType(Material.MAP);
				Settings.vulcanoMap.setType(Material.MAP);
			}
			break;
		case "back":
			LoadMenuSetting.loadOptions(fg);
			event.getWhoClicked().openInventory(fg.getOptionsSetting());
			break;
		}
		
		item.setItemMeta(itemMeta);	
		event.setCancelled(true);
		
	}
	public static void settingPoints(InventoryClickEvent event, Focus pl)	{
		
		FocusGame fg = pl.getFg();
		String nameItem = event.getCurrentItem().getItemMeta().getDisplayName();
		ItemStack item = event.getCurrentItem();
		ItemMeta itemMeta = event.getCurrentItem().getItemMeta();
		
		switch (nameItem)	{
		case "§6§lPoints at the beginning:§c§l 0":
			fg.setStartingPoint(7);
			itemMeta.setDisplayName("§6§lPoints at the beginning:§c§l 7");
			break;
		case "§6§lPoints at the beginning:§c§l 7":
			fg.setStartingPoint(20);
			itemMeta.setDisplayName("§6§lPoints at the beginning:§c§l 20");
			break;
		case "§6§lPoints at the beginning:§c§l 20":
			fg.setStartingPoint(50);
			itemMeta.setDisplayName("§6§lPoints at the beginning:§c§l 50");
			break;
		case "§6§lPoints at the beginning:§c§l 50":
			fg.setStartingPoint(0);
			itemMeta.setDisplayName("§6§lPoints at the beginning:§c§l 0");
			break;
		case "§6§lPoints per round win:§c§l 0":
			fg.setRoundPoint(5);
			itemMeta.setDisplayName("§6§lPoints per round win:§c§l 5");
			break;
		case "§6§lPoints per round win:§c§l 5":
			fg.setRoundPoint(10);
			itemMeta.setDisplayName("§6§lPoints per round win:§c§l 10");
			break;
		case "§6§lPoints per round win:§c§l 10":
			fg.setRoundPoint(15);
			itemMeta.setDisplayName("§6§lPoints per round win:§c§l 15");
			break;
		case "§6§lPoints per round win:§c§l 15":
			fg.setRoundPoint(0);
			itemMeta.setDisplayName("§6§lPoints per round win:§c§l 0");
			break;
		case "§6§lPoints per kill:§c§l 0":
			fg.setKillPoint(1);
			itemMeta.setDisplayName("§6§lPoints per kill:§c§l 1");
			break;
		case "§6§lPoints per kill:§c§l 1":
			fg.setKillPoint(2);
			itemMeta.setDisplayName("§6§lPoints per kill:§c§l 2");
			break;
		case "§6§lPoints per kill:§c§l 2":
			fg.setKillPoint(4);
			itemMeta.setDisplayName("§6§lPoints per kill:§c§l 4");
			break;
		case "§6§lPoints per kill:§c§l 4":
			fg.setKillPoint(6);
			itemMeta.setDisplayName("§6§lPoints per kill:§c§l 6");
			break;
		case "§6§lPoints per kill:§c§l 6":
			fg.setKillPoint(0);
			itemMeta.setDisplayName("§6§lPoints per kill:§c§l 0");
			break;
		case "§3§lreset":
			fg.setKillPoint(2);
			fg.setStartingPoint(7);
			fg.setRoundPoint(5);
			LoadMenuSetting.loadPoints(fg);
			event.getWhoClicked().openInventory(fg.getPointsSetting());
			break;
		case "§a§lback":
			LoadMenuSetting.loadOptions(fg);
			event.getWhoClicked().openInventory(fg.getOptionsSetting());
			break;
		}
			
		item.setItemMeta(itemMeta);	
		event.setCancelled(true);
		
	}
	public static void settingStuffs(InventoryClickEvent event, Focus pl)	{
		
		FocusGame fg = pl.getFg();
		String nameItem = event.getCurrentItem().getItemMeta().getDisplayName().substring(4).toLowerCase();
		ItemStack item = event.getCurrentItem();
		ItemMeta itemMeta = event.getCurrentItem().getItemMeta();
		LeatherArmorMeta armor;
		BlockStateMeta shield;
		Banner banner;
		
		switch (nameItem)	{
		case "helmet":
			armor = (LeatherArmorMeta) event.getCurrentItem().getItemMeta();
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				armor.setColor(Color.RED);
				Settings.helmet_meta.setColor(Color.RED);
			} else {
				fg.addStuffInGame(nameItem);
				armor.setColor(Color.LIME);
				Settings.helmet_meta.setColor(Color.LIME);
			}
			Settings.helmet_meta = armor;
			item.setItemMeta(armor);
			break;
		case "chestplate":
			armor = (LeatherArmorMeta) event.getCurrentItem().getItemMeta();
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				armor.setColor(Color.RED);
				Settings.helmet_meta.setColor(Color.RED);
			} else {
				fg.addStuffInGame(nameItem);
				armor.setColor(Color.LIME);
				Settings.chestplate_meta.setColor(Color.LIME);
			}
			Settings.chestplate_meta = armor;
			item.setItemMeta(armor);
			break;
		case "leggings":
			armor = (LeatherArmorMeta) event.getCurrentItem().getItemMeta();
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				armor.setColor(Color.RED);
				Settings.helmet_meta.setColor(Color.RED);
			} else {
				fg.addStuffInGame(nameItem);
				armor.setColor(Color.LIME);
				Settings.leggings_meta.setColor(Color.LIME);
			}
			Settings.leggings_meta = armor;
			item.setItemMeta(armor);
			break;
		case "boots":
			armor = (LeatherArmorMeta) event.getCurrentItem().getItemMeta();
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				armor.setColor(Color.RED);
				Settings.helmet_meta.setColor(Color.RED);
			} else {
				fg.addStuffInGame(nameItem);
				armor.setColor(Color.LIME);
				Settings.boots_meta.setColor(Color.LIME);
			}
			Settings.boots_meta = armor;
			item.setItemMeta(armor);
			break;
		case "sword":
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				item.setType(Material.BARRIER);
				Settings.sword.setType(Material.BARRIER);
			} else {
				fg.addStuffInGame(nameItem);
				item.setType(Material.DIAMOND_SWORD);
				Settings.sword.setType(Material.DIAMOND_SWORD);
			}
			break;
		case "axe":
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				item.setType(Material.BARRIER);
				Settings.axe.setType(Material.BARRIER);
			} else {
				fg.addStuffInGame(nameItem);
				item.setType(Material.DIAMOND_AXE);
				Settings.axe.setType(Material.DIAMOND_AXE);
			}
			break;
		case "shield":
			shield = (BlockStateMeta) itemMeta;
			banner = (Banner) shield.getBlockState();
			
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				banner.setBaseColor(DyeColor.RED);
			} else {
				fg.addStuffInGame(nameItem);
				banner.setBaseColor(DyeColor.GREEN);
			}
			banner.update();
			shield.setBlockState(banner);
			Settings.shield_meta = shield;
			item.setItemMeta(shield);
			break;
		case "enderpearl":
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				item.setType(Material.BARRIER);
				Settings.enderpearl.setType(Material.BARRIER);
			} else {
				fg.addStuffInGame(nameItem);
				item.setType(Material.ENDER_PEARL);
				Settings.enderpearl.setType(Material.ENDER_PEARL);
			}
			break;
		case "bow":
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				item.setType(Material.BARRIER);
				Settings.bow.setType(Material.BARRIER);
			} else {
				fg.addStuffInGame(nameItem);
				item.setType(Material.BOW);
				Settings.bow.setType(Material.BOW);
			}
			break;
		case "smoke":
			if (fg.getStuffInGame().contains(nameItem))	{
				fg.removeStuffInGame(nameItem);
				item.setType(Material.BARRIER);
				Settings.smoke.setType(Material.BARRIER);
			} else {
				fg.addStuffInGame(nameItem);
				item.setType(Material.SNOW_BALL);
				Settings.smoke.setType(Material.SNOW_BALL);
			}
			break;
		case "back":
			LoadMenuSetting.loadOptions(fg);
			event.getWhoClicked().openInventory(fg.getOptionsSetting());
			break;
		}
		
		event.setCancelled(true);
		
	}

}
