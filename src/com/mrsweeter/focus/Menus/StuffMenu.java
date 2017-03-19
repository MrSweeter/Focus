package com.mrsweeter.focus.Menus;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import com.mrsweeter.focus.FocusGame;

public class StuffMenu {
	
	public static ItemStack helmet_leather = new ItemStack(Material.LEATHER_HELMET);
	public static ItemStack helmet_golden = new ItemStack(Material.GOLD_HELMET);
	public static ItemStack helmet_chain = new ItemStack(Material.CHAINMAIL_HELMET);
	public static ItemStack helmet_iron = new ItemStack(Material.IRON_HELMET);
	public static ItemStack helmet_diamond = new ItemStack(Material.DIAMOND_HELMET);
	
	public static ItemMeta helmet_leather_meta = helmet_leather.getItemMeta();
	public static ItemMeta helmet_golden_meta = helmet_golden.getItemMeta();
	public static ItemMeta helmet_chain_meta = helmet_chain.getItemMeta();
	public static ItemMeta helmet_iron_meta = helmet_iron.getItemMeta();
	public static ItemMeta helmet_diamond_meta = helmet_diamond.getItemMeta();
	//public static List<String> helmet_lores = Arrays.asList("§fadd 2 heart", "§fadd 4 heart", "§fadd 6 heart", "§fadd 8 heart", "§fadd 10 heart");
	
	public static ItemStack chestplate_leather = new ItemStack(Material.LEATHER_CHESTPLATE);
	public static ItemStack chestplate_golden = new ItemStack(Material.GOLD_CHESTPLATE);
	public static ItemStack chestplate_chain = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	public static ItemStack chestplate_iron = new ItemStack(Material.IRON_CHESTPLATE);
	public static ItemStack chestplate_diamond = new ItemStack(Material.DIAMOND_CHESTPLATE);
	public static ItemMeta chestplate_leather_meta = chestplate_leather.getItemMeta();
	public static ItemMeta chestplate_golden_meta = chestplate_golden.getItemMeta();
	public static ItemMeta chestplate_chain_meta = chestplate_chain.getItemMeta();
	public static ItemMeta chestplate_iron_meta = chestplate_iron.getItemMeta();
	public static ItemMeta chestplate_diamond_meta = chestplate_diamond.getItemMeta();
	
	public static ItemStack leggings_leather = new ItemStack(Material.LEATHER_LEGGINGS);
	public static ItemStack leggings_golden = new ItemStack(Material.GOLD_LEGGINGS);
	public static ItemStack leggings_chain = new ItemStack(Material.CHAINMAIL_LEGGINGS);
	public static ItemStack leggings_iron = new ItemStack(Material.IRON_LEGGINGS);
	public static ItemStack leggings_diamond = new ItemStack(Material.DIAMOND_LEGGINGS);
	public static ItemMeta leggings_leather_meta = leggings_leather.getItemMeta();
	public static ItemMeta leggings_golden_meta = leggings_golden.getItemMeta();
	public static ItemMeta leggings_chain_meta = leggings_chain.getItemMeta();
	public static ItemMeta leggings_iron_meta = leggings_iron.getItemMeta();
	public static ItemMeta leggings_diamond_meta = leggings_diamond.getItemMeta();
		
	public static ItemStack boots_leather = new ItemStack(Material.LEATHER_BOOTS);
	public static ItemStack boots_golden = new ItemStack(Material.GOLD_BOOTS);
	public static ItemStack boots_chain = new ItemStack(Material.CHAINMAIL_BOOTS);
	public static ItemStack boots_iron = new ItemStack(Material.IRON_BOOTS);
	public static ItemStack boots_diamond = new ItemStack(Material.DIAMOND_BOOTS);
	public static ItemMeta boots_leather_meta = boots_leather.getItemMeta();
	public static ItemMeta boots_golden_meta = boots_golden.getItemMeta();
	public static ItemMeta boots_chain_meta = boots_chain.getItemMeta();
	public static ItemMeta boots_iron_meta = boots_iron.getItemMeta();
	public static ItemMeta boots_diamond_meta = boots_diamond.getItemMeta();
		
	public static ItemStack sword_wooden = new ItemStack(Material.WOOD_SWORD);
	public static ItemStack sword_stone = new ItemStack(Material.STONE_SWORD);
	public static ItemStack sword_iron = new ItemStack(Material.IRON_SWORD);
	public static ItemStack sword_diamond = new ItemStack(Material.DIAMOND_SWORD);
	public static ItemStack sword_golden = new ItemStack(Material.GOLD_SWORD);
	public static ItemMeta sword_wooden_meta = sword_wooden.getItemMeta();
	public static ItemMeta sword_stone_meta = sword_stone.getItemMeta();
	public static ItemMeta sword_iron_meta = sword_iron.getItemMeta();
	public static ItemMeta sword_diamond_meta = sword_diamond.getItemMeta();
	public static ItemMeta sword_golden_meta = sword_golden.getItemMeta();
		
	public static ItemStack axe_wooden = new ItemStack(Material.WOOD_AXE);
	public static ItemStack axe_stone = new ItemStack(Material.STONE_AXE);
	public static ItemStack axe_iron = new ItemStack(Material.IRON_AXE);
	public static ItemStack axe_diamond = new ItemStack(Material.DIAMOND_AXE);
	public static ItemStack axe_golden = new ItemStack(Material.GOLD_AXE);
	public static ItemMeta axe_wooden_meta = axe_wooden.getItemMeta();
	public static ItemMeta axe_stone_meta = axe_stone.getItemMeta();
	public static ItemMeta axe_iron_meta = axe_iron.getItemMeta();
	public static ItemMeta axe_diamond_meta = axe_diamond.getItemMeta();
	public static ItemMeta axe_golden_meta = axe_golden.getItemMeta();

	public static ItemStack bow_power1 = new ItemStack(Material.BOW);
	public static ItemStack bow_power2 = new ItemStack(Material.BOW);
	public static ItemStack bow_p3_punch1 = new ItemStack(Material.BOW);
	public static ItemStack bow_p4_punch1 = new ItemStack(Material.BOW);
	public static ItemStack bow_p5_punch2 = new ItemStack(Material.BOW);
	public static ItemMeta bow_power1_meta = bow_power1.getItemMeta();
	public static ItemMeta bow_power2_meta = bow_power2.getItemMeta();
	public static ItemMeta bow_p3_punch1_meta = bow_p3_punch1.getItemMeta();
	public static ItemMeta bow_p4_punch1_meta = bow_p4_punch1.getItemMeta();
	public static ItemMeta bow_p5_punch2_meta = bow_p5_punch2.getItemMeta();
	
	public static ItemStack arrow = new ItemStack(Material.ARROW, 5);
	public static ItemStack arrow_5 = new ItemStack(Material.ARROW, 10);
	public static ItemStack arrow_10 = new ItemStack(Material.ARROW, 20);
	public static ItemStack arrow_20 = new ItemStack(Material.ARROW, 40);
	public static ItemStack arrow_30 = new ItemStack(Material.ARROW, 64);
	public static ItemMeta arrow_meta = arrow.getItemMeta();
	public static ItemMeta arrow_5_meta = arrow_5.getItemMeta();
	public static ItemMeta arrow_10_meta = arrow_10.getItemMeta();
	public static ItemMeta arrow_20_meta = arrow_20.getItemMeta();
	public static ItemMeta arrow_30_meta = arrow_30.getItemMeta();
	
	public static ItemStack enderpearl_1 = new ItemStack(Material.ENDER_PEARL);
	public static ItemStack enderpearl_2 = new ItemStack(Material.ENDER_PEARL, 2);
	public static ItemMeta enderpearl_1_meta = enderpearl_1.getItemMeta();
	public static ItemMeta enderpearl_2_meta = enderpearl_2.getItemMeta();
	
	public static ItemStack shield_1 = new ItemStack(Material.SHIELD);
	public static ItemStack shield_2 = new ItemStack(Material.SHIELD);
	public static ItemStack shield_3 = new ItemStack(Material.SHIELD);
	public static BlockStateMeta shield_1_meta = (BlockStateMeta) shield_1.getItemMeta();
	public static BlockStateMeta shield_2_meta = (BlockStateMeta) shield_2.getItemMeta();
	public static BlockStateMeta shield_3_meta = (BlockStateMeta) shield_3.getItemMeta();
	private static Banner banner_1 = (Banner) shield_1_meta.getBlockState();
	private static Banner banner_2 = (Banner) shield_2_meta.getBlockState();
	private static Banner banner_3 = (Banner) shield_3_meta.getBlockState();

	public static ItemStack smoke_1 = new ItemStack(Material.SNOW_BALL);
	public static ItemStack smoke_2 = new ItemStack(Material.SNOW_BALL);
	public static ItemStack smoke_3 = new ItemStack(Material.SNOW_BALL);
	public static ItemStack smoke_4 = new ItemStack(Material.SNOW_BALL, 2);
	public static ItemMeta smoke_1_meta = smoke_1.getItemMeta();
	public static ItemMeta smoke_2_meta = smoke_2.getItemMeta();
	public static ItemMeta smoke_3_meta = smoke_3.getItemMeta();
	public static ItemMeta smoke_4_meta = smoke_4.getItemMeta();
	
	public static ItemStack noMore = new ItemStack(Material.BARRIER);
	public static ItemMeta noMore_meta = noMore.getItemMeta();
	public static ItemStack pointItem = new ItemStack(Material.GOLD_INGOT);
	public static ItemMeta pointItem_meta = pointItem.getItemMeta();
	public static ItemStack ready = new ItemStack(Material.BARRIER);
	public static ItemMeta ready_meta = pointItem.getItemMeta();
	
	public static void createStuff(FocusGame fg)	{
		
		noMore_meta.setDisplayName("§c§lNo more");
		noMore.setItemMeta(noMore_meta);
		ready_meta.setDisplayName("§6§lReady ?");
		ready.setItemMeta(ready_meta);
		pointItem_meta.setDisplayName("§a§lYou have " + fg.getStartingPoint() + " points to spend");
		pointItem_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		pointItem_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		pointItem.setItemMeta(pointItem_meta);
		
		helmet_leather_meta.setDisplayName("§c§lHelmet of Health I§6§l - 2 points");
		helmet_leather.setItemMeta(helmet_leather_meta);
		helmet_golden_meta.setDisplayName("§c§lHelmet of Health II§6§l - 4 points");
		helmet_golden.setItemMeta(helmet_golden_meta);
		helmet_chain_meta.setDisplayName("§c§lHelmet of Health III§6§l - 7 points");
		helmet_chain.setItemMeta(helmet_chain_meta);
		helmet_iron_meta.setDisplayName("§c§lHelmet of Health IV§6§l - 10 points");
		helmet_iron.setItemMeta(helmet_iron_meta);
		helmet_diamond_meta.setDisplayName("§c§lHelmet of Health V§6§l - 15 points");
		helmet_diamond.setItemMeta(helmet_diamond_meta);
		
		chestplate_leather_meta.setDisplayName("§c§lSpiked Chestplate I§6§l - 3 points");
		chestplate_leather.setItemMeta(chestplate_leather_meta);
		chestplate_golden_meta.setDisplayName("§c§lSpiked Chestplate II§6§l - 5 points");
		chestplate_golden.setItemMeta(chestplate_golden_meta);
		chestplate_chain_meta.setDisplayName("§c§lSpiked Chestplate III§6§l - 8 points");
		chestplate_chain.setItemMeta(chestplate_chain_meta);
		chestplate_iron_meta.setDisplayName("§c§lSpiked Chestplate IV§6§l - 12 points");
		chestplate_iron.setItemMeta(chestplate_iron_meta);
		chestplate_diamond_meta.setDisplayName("§c§lSpiked Chestplate V§6§l - 18 points");
		chestplate_diamond.setItemMeta(chestplate_diamond_meta);
		
		leggings_leather_meta.setDisplayName("§c§lLeggings of speed I§6§l - 3 points");
		leggings_leather.setItemMeta(leggings_leather_meta);
		leggings_golden_meta.setDisplayName("§c§lLeggings of speed II§6§l - 5 points");
		leggings_golden.setItemMeta(leggings_golden_meta);
		leggings_chain_meta.setDisplayName("§c§lLeggings of speed III§6§l - 8 points");
		leggings_chain.setItemMeta(leggings_chain_meta);
		leggings_iron_meta.setDisplayName("§c§lLeggings of speed IV§6§l - 12 points");
		leggings_iron.setItemMeta(leggings_iron_meta);
		leggings_diamond_meta.setDisplayName("§c§lLeggings of speed V§6§l - 18 points");
		leggings_diamond.setItemMeta(leggings_diamond_meta);
		
		boots_leather_meta.setDisplayName("§c§lNinja boots I§6§l - 2 points");
		boots_leather.setItemMeta(boots_leather_meta);
		boots_golden_meta.setDisplayName("§c§lNinja boots II§6§l - 4 points");
		boots_golden.setItemMeta(boots_golden_meta);
		boots_chain_meta.setDisplayName("§c§lNinja boots III§6§l - 7 points");
		boots_chain.setItemMeta(boots_chain_meta);
		boots_iron_meta.setDisplayName("§c§lNinja boots IV§6§l - 10 points");
		boots_iron.setItemMeta(boots_iron_meta);
		boots_diamond_meta.setDisplayName("§c§lNinja boots V§6§l - 15 points");
		boots_diamond.setItemMeta(boots_diamond_meta);
		
		sword_wooden_meta.setDisplayName("§c§lSword I§6§l - 4 points");
		sword_wooden.setItemMeta(sword_wooden_meta);
		sword_stone_meta.setDisplayName("§c§lSword II§6§l - 6 points");
		sword_stone.setItemMeta(sword_stone_meta);
		sword_iron_meta.setDisplayName("§c§lSword III§6§l - 10 points");
		sword_iron.setItemMeta(sword_iron_meta);
		sword_diamond_meta.setDisplayName("§c§lSword IV§6§l - 15 points");
		sword_diamond.setItemMeta(sword_diamond_meta);
		sword_golden_meta.setDisplayName("§c§lSword V§6§l - 20 points");
		sword_golden.setItemMeta(sword_golden_meta);
		
		axe_wooden_meta.setDisplayName("§c§lPoison Axe I§6§l - 6 points");
		axe_wooden.setItemMeta(axe_wooden_meta);
		axe_stone_meta.setDisplayName("§c§lPoison Axe II§6§l - 10 points");
		axe_stone.setItemMeta(axe_stone_meta);
		axe_iron_meta.setDisplayName("§c§lPoison Axe III§6§l - 15 points");
		axe_iron.setItemMeta(axe_iron_meta);
		axe_diamond_meta.setDisplayName("§c§lPoison Axe IV§6§l - 20 points");
		axe_diamond.setItemMeta(axe_diamond_meta);
		axe_golden_meta.setDisplayName("§c§lPoison Axe V§6§l - 25 points");
		axe_golden.setItemMeta(axe_golden_meta);
		
		bow_power1_meta.setDisplayName("§c§lBow and 5 arrows§6§l - 5 points");
		bow_power1.setItemMeta(bow_power1_meta);
		bow_power2_meta.setDisplayName("§c§lBow II§6§l - 8 points");
		bow_power2.setItemMeta(bow_power2_meta);
		bow_p3_punch1_meta.setDisplayName("§c§lBow III§6§l - 10 points");
		bow_p3_punch1.setItemMeta(bow_p3_punch1_meta);
		bow_p4_punch1_meta.setDisplayName("§c§lBow IV§6§l - 15 points");
		bow_p4_punch1.setItemMeta(bow_p4_punch1_meta);
		bow_p5_punch2_meta.setDisplayName("§c§lBow V§6§l - 20 points");
		bow_p5_punch2.setItemMeta(bow_p5_punch2_meta);
		
		arrow_meta.setDisplayName("§c§l5 arrows§6§l - 0 points");
		arrow.setItemMeta(arrow_meta);
		arrow_5_meta.setDisplayName("§c§l10 arrows§6§l - 5 points");
		arrow_5.setItemMeta(arrow_5_meta);
		arrow_10_meta.setDisplayName("§c§l20 arrows§6§l - 10 points");
		arrow_10.setItemMeta(arrow_10_meta);
		arrow_20_meta.setDisplayName("§c§l40 arrows§6§l - 20 points");
		arrow_20.setItemMeta(arrow_20_meta);
		arrow_30_meta.setDisplayName("§c§lTons of arrows§6§l - 30 points");
		arrow_30.setItemMeta(arrow_30_meta);
		
		enderpearl_1_meta.setDisplayName("§c§lEnderpearl§6§l - 8 points");
		enderpearl_1.setItemMeta(enderpearl_1_meta);
		enderpearl_2_meta.setDisplayName("§c§l2 enderpearls§6§l - 16 points");
		enderpearl_2.setItemMeta(enderpearl_2_meta);
		
		banner_1.addPattern(new Pattern(DyeColor.RED, PatternType.BASE));
		banner_1.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
		banner_1.update();
		shield_1_meta.setBlockState(banner_1);
		shield_1_meta.setDisplayName("§c§lShield I§6§l - 3 points");
		shield_1.setItemMeta(shield_1_meta);
		
		banner_2.addPattern(new Pattern(DyeColor.RED, PatternType.BASE));
		banner_2.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
		banner_2.addPattern(new Pattern(DyeColor.WHITE, PatternType.SKULL));
		banner_2.update();
		shield_2_meta.setBlockState(banner_2);
		shield_2_meta.setDisplayName("§c§lShield II§6§l - 6 points");
		shield_2.setItemMeta(shield_2_meta);
		
		banner_3.addPattern(new Pattern(DyeColor.BLACK, PatternType.BASE));
		banner_3.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLE_TOP));
		banner_3.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLE_BOTTOM));
		banner_3.addPattern(new Pattern(DyeColor.BLACK, PatternType.GRADIENT));
		banner_3.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
		banner_3.addPattern(new Pattern(DyeColor.WHITE, PatternType.SKULL));
		banner_3.update();
		shield_3_meta.setBlockState(banner_3);
		shield_3_meta.setDisplayName("§c§lShield III§6§l - 9 points");
		shield_3.setItemMeta(shield_3_meta);
		
		smoke_1_meta.setDisplayName("§c§lSmoke I§6§l - 6 points");
		smoke_1.setItemMeta(smoke_1_meta);
		smoke_2_meta.setDisplayName("§c§lSmoke II§6§l - 3 points");
		smoke_2.setItemMeta(smoke_2_meta);
		smoke_3_meta.setDisplayName("§c§lSmoke III§6§l - 3 points");
		smoke_3.setItemMeta(smoke_3_meta);
		smoke_4_meta.setDisplayName("§c§l2 smokes§6§l - 6 points");
		smoke_4.setItemMeta(smoke_4_meta);
	}
}
