package com.mrsweeter.focus.Menus;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Settings {
	
	public static ItemStack gameMode = new ItemStack(Material.ENCHANTMENT_TABLE);
	public static ItemMeta gameMode_meta = gameMode.getItemMeta();
	
	public static ItemStack maps = new ItemStack(Material.MAP);
	public static ItemStack victoriesType = new ItemStack(Material.ENDER_PORTAL_FRAME);
	public static ItemStack nbreWin = new ItemStack(Material.EMERALD);
	public static ItemStack back = new ItemStack(Material.SPECTRAL_ARROW);
	public static ItemStack next = new ItemStack(Material.SPECTRAL_ARROW);
	public static ItemMeta  maps_meta =  maps.getItemMeta();
	public static ItemMeta  victoriesType_meta =  victoriesType.getItemMeta();
	public static ItemMeta  nbreWin_meta =  nbreWin.getItemMeta();
	public static ItemMeta  back_meta =  back.getItemMeta();
	public static ItemMeta  next_meta =  next.getItemMeta();

	public static ItemStack launch = new ItemStack(Material.BEACON);
	public static ItemStack options = new ItemStack(Material.BOOKSHELF);
	public static ItemStack mapChoice = new ItemStack(Material.MAP);
	public static ItemStack disableItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
	public static ItemStack scoring = new ItemStack(Material.DIAMOND);
	public static ItemMeta  launch_meta =  launch.getItemMeta();
	public static ItemMeta  options_meta =  options.getItemMeta();
	public static ItemMeta  mapChoice_meta =  mapChoice.getItemMeta();
	public static ItemMeta  disableItem_meta =  disableItem.getItemMeta();
	public static ItemMeta  scoring_meta =  scoring.getItemMeta();

	public static ItemStack disableHp = new ItemStack(Material.GOLDEN_APPLE);
	public static ItemStack pointBeginning = new ItemStack(Material.GOLD_INGOT);
	public static ItemStack pointKill = new ItemStack(Material.SKULL_ITEM);
	public static ItemStack pointWinRound = new ItemStack(Material.IRON_INGOT);
	public static ItemStack reset = new ItemStack(Material.WEB);
	public static ItemMeta  disableHp_meta =  disableHp.getItemMeta();
	public static ItemMeta  pointBeginning_meta =  pointBeginning.getItemMeta();
	public static ItemMeta  pointKill_meta =  pointKill.getItemMeta();
	public static ItemMeta  pointWinRound_meta =  pointWinRound.getItemMeta();
	public static ItemMeta  reset_meta =  reset.getItemMeta();

	public static ItemStack treeMap = new ItemStack(Material.MAP);
	public static ItemStack ruinsMap = new ItemStack(Material.MAP);
	public static ItemStack isletMap = new ItemStack(Material.MAP);
	public static ItemStack ruptureMap = new ItemStack(Material.MAP);
	public static ItemStack tunnelsMap = new ItemStack(Material.MAP);
	public static ItemMeta  treeMap_meta =  treeMap.getItemMeta();
	public static ItemMeta  ruinsMap_meta =  ruinsMap.getItemMeta();
	public static ItemMeta  isletMap_meta =  isletMap.getItemMeta();
	public static ItemMeta  ruptureMap_meta =  ruptureMap.getItemMeta();
	public static ItemMeta  tunnelsMap_meta =  tunnelsMap.getItemMeta();

	public static ItemStack templeMap = new ItemStack(Material.MAP);
	public static ItemStack iceMap = new ItemStack(Material.MAP);
	public static ItemStack vulcanoMap = new ItemStack(Material.MAP);
	public static ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
	public static ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
	public static ItemMeta  templeMap_meta =  templeMap.getItemMeta();
	public static ItemMeta  iceMap_meta =  iceMap.getItemMeta();
	public static ItemMeta  vulcanoMap_meta =  vulcanoMap.getItemMeta();
	public static LeatherArmorMeta  helmet_meta = (LeatherArmorMeta) helmet.getItemMeta();
	public static LeatherArmorMeta  chestplate_meta = (LeatherArmorMeta) chestplate.getItemMeta();

	public static ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
	public static ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
	public static ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
	public static ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
	public static ItemStack shield = new ItemStack(Material.SHIELD);
	public static LeatherArmorMeta  leggings_meta = (LeatherArmorMeta) leggings.getItemMeta();
	public static LeatherArmorMeta  boots_meta = (LeatherArmorMeta) boots.getItemMeta();
	public static ItemMeta  sword_meta =  sword.getItemMeta();
	public static ItemMeta  axe_meta =  axe.getItemMeta();
	public static ItemMeta  shield_meta =  shield.getItemMeta();

	public static ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
	public static ItemStack bow = new ItemStack(Material.BOW);
	public static ItemStack smoke = new ItemStack(Material.SNOW_BALL);
	public static ItemMeta  enderpearl_meta =  enderpearl.getItemMeta();
	public static ItemMeta  bow_meta =  bow.getItemMeta();
	public static ItemMeta  smoke_meta =  smoke.getItemMeta();
	
	public static Inventory fillSettings(Inventory inv) {
		
		inv.setItem(21, gameMode);
		inv.setItem(23, maps);
		inv.setItem(43, next);
		
		return inv;
	}
	
	public static void actuGamemodeOptions() {
		victoriesType.setItemMeta(victoriesType_meta);
		nbreWin.setItemMeta(nbreWin_meta);
	}

	public static void createDefaultSettings() {
		gameMode_meta.setDisplayName("§6§lDeathmatch");
		gameMode.setItemMeta(gameMode_meta);
		maps_meta.setDisplayName("§6§lRandom");
		maps.setItemMeta(maps_meta);
		next_meta.setDisplayName("§a§lnext");
		next.setItemMeta(next_meta);
		
		victoriesType_meta.setDisplayName("§6§lKill");
		victoriesType.setItemMeta(victoriesType_meta);
		nbreWin_meta.setDisplayName("§6§lNumber of kill: §c§l10");
		nbreWin.setItemMeta(nbreWin_meta);
		options_meta.setDisplayName("§a§lnext");
		options.setItemMeta(options_meta);
		back_meta.setDisplayName("§a§lback");
		back.setItemMeta(back_meta);
		launch_meta.setDisplayName("§c§lLaunch game");
		launch.setItemMeta(launch_meta);
		
		mapChoice_meta.setDisplayName("§6§lRandom map choice");
		mapChoice.setItemMeta(mapChoice_meta);
		disableItem_meta.setDisplayName("§6§lDisable items");
		disableItem.setItemMeta(disableItem_meta);
		disableHp_meta.setDisplayName("§6§lDisplay remaining hp: §c§ldisable");
		disableHp.setItemMeta(disableHp_meta);
		scoring_meta.setDisplayName("§6§lScoring configuration");
		scoring.setItemMeta(scoring_meta);
		
		pointBeginning_meta.setDisplayName("§6§lPoint at the beginning:§c§l 7");
		pointBeginning.setItemMeta(pointBeginning_meta);
		pointWinRound_meta.setDisplayName("§6§lPoint when you win a round:§c§l 5");
		pointWinRound.setItemMeta(pointWinRound_meta);
		pointKill_meta.setDisplayName("§6§lPoint for one kill:§c§l 2");
		pointKill.setItemMeta(pointKill_meta);
		reset_meta.setDisplayName("§3§lreset");
		reset.setItemMeta(reset_meta);
		
		treeMap_meta.setDisplayName("§6§lTree");
		treeMap.setItemMeta(treeMap_meta);
		ruinsMap_meta.setDisplayName("§6§lRuins");
		ruinsMap.setItemMeta(ruinsMap_meta);
		isletMap_meta.setDisplayName("§6§lIslet");
		isletMap.setItemMeta(isletMap_meta);
		ruptureMap_meta.setDisplayName("§6§lRupture");
		ruptureMap.setItemMeta(ruptureMap_meta);
		tunnelsMap_meta.setDisplayName("§6§lTunnels");
		tunnelsMap.setItemMeta(tunnelsMap_meta);
		templeMap_meta.setDisplayName("§6§lTemple");
		templeMap.setItemMeta(templeMap_meta);
		iceMap_meta.setDisplayName("§6§lIce");
		iceMap.setItemMeta(iceMap_meta);
		vulcanoMap_meta.setDisplayName("§6§lVulcano");
		vulcanoMap.setItemMeta(vulcanoMap_meta);
		
		helmet_meta.setDisplayName("§6§lHelmet");
		helmet_meta.setColor(Color.LIME);
		helmet.setItemMeta(helmet_meta);
		chestplate_meta.setDisplayName("§6§lChestplate");
		chestplate_meta.setColor(Color.LIME);
		chestplate.setItemMeta(chestplate_meta);
		leggings_meta.setDisplayName("§6§lLeggings");
		leggings_meta.setColor(Color.LIME);
		leggings.setItemMeta(leggings_meta);
		boots_meta.setDisplayName("§6§lBoots");
		boots_meta.setColor(Color.LIME);
		boots.setItemMeta(boots_meta);
		
		BlockStateMeta shield2 = (BlockStateMeta) shield_meta;
		Banner banner = (Banner) shield2.getBlockState();
		banner.setBaseColor(DyeColor.GREEN);
		banner.update();
		shield2.setBlockState(banner);
		shield_meta = shield2;
		
		sword_meta.setDisplayName("§6§lSword");
		sword.setItemMeta(sword_meta);
		axe_meta.setDisplayName("§6§lAxe");
		axe.setItemMeta(axe_meta);
		shield_meta.setDisplayName("§6§lShield");
		shield.setItemMeta(shield_meta);
		enderpearl_meta.setDisplayName("§6§lEnderpearl");
		enderpearl.setItemMeta(enderpearl_meta);
		bow_meta.setDisplayName("§6§lBow");
		bow.setItemMeta(bow_meta);
		smoke_meta.setDisplayName("§6§lSmoke");
		smoke.setItemMeta(smoke_meta);
	}
}
