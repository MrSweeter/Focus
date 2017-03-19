package com.mrsweeter.focus.PlayerIG;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import com.mrsweeter.focus.FocusGame;

public class Stuff {
	
	private static List<String> lore = new ArrayList<String>();
	
	public static ItemStack helmet_leather = new ItemStack(Material.LEATHER_HELMET);
	public static ItemStack helmet_golden = new ItemStack(Material.GOLD_HELMET);
	public static ItemStack helmet_chain = new ItemStack(Material.CHAINMAIL_HELMET);
	public static ItemStack helmet_iron = new ItemStack(Material.IRON_HELMET);
	public static ItemStack helmet_diamond = new ItemStack(Material.DIAMOND_HELMET);
	private static ItemMeta helmet_meta = helmet_leather.getItemMeta();
	
	public static ItemStack chestplate_leather = new ItemStack(Material.LEATHER_CHESTPLATE);
	public static ItemStack chestplate_golden = new ItemStack(Material.GOLD_CHESTPLATE);
	public static ItemStack chestplate_chain = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	public static ItemStack chestplate_iron = new ItemStack(Material.IRON_CHESTPLATE);
	public static ItemStack chestplate_diamond = new ItemStack(Material.DIAMOND_CHESTPLATE);
	private static ItemMeta chestplate_meta = chestplate_leather.getItemMeta();
	
	public static ItemStack leggings_leather = new ItemStack(Material.LEATHER_LEGGINGS);
	public static ItemStack leggings_golden = new ItemStack(Material.GOLD_LEGGINGS);
	public static ItemStack leggings_chain = new ItemStack(Material.CHAINMAIL_LEGGINGS);
	public static ItemStack leggings_iron = new ItemStack(Material.IRON_LEGGINGS);
	public static ItemStack leggings_diamond = new ItemStack(Material.DIAMOND_LEGGINGS);
	private static ItemMeta leggings_meta = leggings_leather.getItemMeta();
	
	public static ItemStack boots_leather = new ItemStack(Material.LEATHER_BOOTS);
	public static ItemStack boots_golden = new ItemStack(Material.GOLD_BOOTS);
	public static ItemStack boots_chain = new ItemStack(Material.CHAINMAIL_BOOTS);
	public static ItemStack boots_iron = new ItemStack(Material.IRON_BOOTS);
	public static ItemStack boots_diamond = new ItemStack(Material.DIAMOND_BOOTS);
	private static ItemMeta boots_meta = boots_leather.getItemMeta();
	
	public static ItemStack stick = new ItemStack(Material.STICK);
	public static ItemStack sword_wooden = new ItemStack(Material.WOOD_SWORD);
	public static ItemStack sword_stone = new ItemStack(Material.STONE_SWORD);
	public static ItemStack sword_iron = new ItemStack(Material.IRON_SWORD);
	public static ItemStack sword_diamond = new ItemStack(Material.DIAMOND_SWORD);
	public static ItemStack sword_golden = new ItemStack(Material.GOLD_SWORD);
	private static ItemMeta stick_meta = stick.getItemMeta();
	private static ItemMeta sword_meta = sword_golden.getItemMeta();
	
	public static ItemStack axe_wooden = new ItemStack(Material.WOOD_AXE);
	public static ItemStack axe_stone = new ItemStack(Material.STONE_AXE);
	public static ItemStack axe_iron = new ItemStack(Material.IRON_AXE);
	public static ItemStack axe_diamond = new ItemStack(Material.DIAMOND_AXE);
	public static ItemStack axe_golden = new ItemStack(Material.GOLD_AXE);
	private static ItemMeta axe_1_meta = axe_wooden.getItemMeta();
	private static ItemMeta axe_2_meta = axe_stone.getItemMeta();
	private static ItemMeta axe_3_meta = axe_iron.getItemMeta();
	private static ItemMeta axe_4_meta = axe_diamond.getItemMeta();
	private static ItemMeta axe_5_meta = axe_golden.getItemMeta();
	
	public static ItemStack bow_power1 = new ItemStack(Material.BOW);
	public static ItemStack bow_power2 = new ItemStack(Material.BOW);
	public static ItemStack bow_p3_punch1 = new ItemStack(Material.BOW);
	public static ItemStack bow_p4_punch1 = new ItemStack(Material.BOW);
	public static ItemStack bow_p5_punch2 = new ItemStack(Material.BOW);
	private static ItemMeta bow_1_meta = bow_power1.getItemMeta();
	private static ItemMeta bow_2_meta = bow_power2.getItemMeta();
	private static ItemMeta bow_3_meta = bow_p3_punch1.getItemMeta();
	private static ItemMeta bow_4_meta = bow_p4_punch1.getItemMeta();
	private static ItemMeta bow_5_meta = bow_p5_punch2.getItemMeta();
	
	public static ItemStack arrow = new ItemStack(Material.ARROW, 5);
	public static ItemStack arrow_5 = new ItemStack(Material.ARROW, 10);
	public static ItemStack arrow_10 = new ItemStack(Material.ARROW, 20);
	public static ItemStack arrow_20 = new ItemStack(Material.ARROW, 40);
	public static ItemStack arrow_30 = new ItemStack(Material.ARROW, 64);
	
	public static ItemStack enderpearl_1 = new ItemStack(Material.ENDER_PEARL);
	public static ItemStack enderpearl_2 = new ItemStack(Material.ENDER_PEARL, 2);
	
	public static ItemStack shield_1 = new ItemStack(Material.SHIELD);
	public static ItemStack shield_2 = new ItemStack(Material.SHIELD);
	public static ItemStack shield_3 = new ItemStack(Material.SHIELD);
	private static BlockStateMeta shield_1_meta = (BlockStateMeta) shield_1.getItemMeta();
	private static BlockStateMeta shield_2_meta = (BlockStateMeta) shield_2.getItemMeta();
	private static BlockStateMeta shield_3_meta = (BlockStateMeta) shield_3.getItemMeta();
	private static Banner banner_1 = (Banner) shield_1_meta.getBlockState();
	private static Banner banner_2 = (Banner) shield_2_meta.getBlockState();
	private static Banner banner_3 = (Banner) shield_3_meta.getBlockState();
	
	public static ItemStack smoke_1 = new ItemStack(Material.SNOW_BALL);
	public static ItemStack smoke_2 = new ItemStack(Material.SNOW_BALL);
	public static ItemStack smoke_3 = new ItemStack(Material.SNOW_BALL);
	public static ItemStack smoke_4 = new ItemStack(Material.SNOW_BALL, 2);
	public static ItemMeta smoke_meta = smoke_1.getItemMeta();
	
	public static void createStuff()	{
		
		lore.clear();
		lore.add("");
		lore.add("");
		banner_1.addPattern(new Pattern(DyeColor.RED, PatternType.BASE));
		banner_1.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
		banner_1.update();
		lore.set(0, "Slowness III");
		shield_1_meta.setLore(lore);
		shield_1_meta.setBlockState(banner_1);
		shield_1.setItemMeta(shield_1_meta);
		
		banner_2.addPattern(new Pattern(DyeColor.RED, PatternType.BASE));
		banner_2.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
		banner_2.addPattern(new Pattern(DyeColor.WHITE, PatternType.SKULL));
		banner_2.update();
		lore.set(0, "Slowness II");
		shield_2_meta.setLore(lore);
		shield_2_meta.setBlockState(banner_2);
		shield_2.setItemMeta(shield_2_meta);
		
		banner_3.addPattern(new Pattern(DyeColor.BLACK, PatternType.BASE));
		banner_3.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLE_TOP));
		banner_3.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLE_BOTTOM));
		banner_3.addPattern(new Pattern(DyeColor.BLACK, PatternType.GRADIENT));
		banner_3.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
		banner_3.addPattern(new Pattern(DyeColor.WHITE, PatternType.SKULL));
		banner_3.update();
		lore.set(0, "Slowness I");
		shield_3_meta.setLore(lore);
		shield_3_meta.setBlockState(banner_3);
		shield_3.setItemMeta(shield_3_meta);
		
		smoke_meta.setDisplayName("§lSmoke");
		smoke_1.setItemMeta(smoke_meta);
		smoke_2.setItemMeta(smoke_meta);
		smoke_3.setItemMeta(smoke_meta);
		smoke_4.setItemMeta(smoke_meta);
		
		stick_meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		stick.setItemMeta(stick_meta);
		sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		sword_golden.setItemMeta(sword_meta);
		
		bow_1_meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		bow_power1.setItemMeta(bow_1_meta);
		bow_2_meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
		bow_power2.setItemMeta(bow_2_meta);
		bow_3_meta.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
		bow_3_meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
		bow_p3_punch1.setItemMeta(bow_3_meta);
		bow_4_meta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
		bow_4_meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		bow_p4_punch1.setItemMeta(bow_4_meta);
		bow_5_meta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
		bow_5_meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
		bow_p5_punch2.setItemMeta(bow_5_meta);
		
		lore.clear();
		lore.add("");
		lore.add("");
		axe_1_meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		lore.set(0, "");
		lore.set(1, "Dedication to DarthGege");
		axe_1_meta.setLore(lore);
		axe_wooden.setItemMeta(axe_1_meta);
		axe_2_meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		lore.set(0, "Poison I");
		axe_2_meta.setLore(lore);
		axe_stone.setItemMeta(axe_2_meta);
		axe_3_meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
		axe_3_meta.setLore(lore);
		axe_iron.setItemMeta(axe_3_meta);
		axe_4_meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
		lore.set(0, "Poison II");
		axe_4_meta.setLore(lore);
		axe_diamond.setItemMeta(axe_4_meta);
		axe_5_meta.addEnchant(Enchantment.KNOCKBACK, 3, true);
		axe_5_meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		axe_5_meta.setLore(lore);
		axe_golden.setItemMeta(axe_5_meta);
		
		chestplate_meta.addEnchant(Enchantment.THORNS, 1, true);
		chestplate_leather.setItemMeta(chestplate_meta);
		chestplate_meta = chestplate_golden.getItemMeta();
		chestplate_meta.addEnchant(Enchantment.THORNS, 2, true);
		chestplate_golden.setItemMeta(chestplate_meta);
		chestplate_meta = chestplate_chain.getItemMeta();
		chestplate_meta.addEnchant(Enchantment.THORNS, 3, true);
		chestplate_chain.setItemMeta(chestplate_meta);
		chestplate_meta = chestplate_iron.getItemMeta();
		chestplate_meta.addEnchant(Enchantment.THORNS, 4, true);
		chestplate_iron.setItemMeta(chestplate_meta);
		chestplate_meta = chestplate_diamond.getItemMeta();
		chestplate_meta.addEnchant(Enchantment.THORNS, 5, true);
		chestplate_diamond.setItemMeta(chestplate_meta);
		
		lore.clear();
		lore.add("");
		boots_meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		boots_leather.setItemMeta(boots_meta);
		boots_meta = boots_golden.getItemMeta();
		lore.set(0, "Jump Boost 1");
		boots_meta.setLore(lore);
		boots_meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
		boots_golden.setItemMeta(boots_meta);
		boots_meta = boots_chain.getItemMeta();
		boots_meta.setLore(lore);
		boots_meta.addEnchant(Enchantment.PROTECTION_FALL, 2, true);
		boots_chain.setItemMeta(boots_meta);
		boots_meta = boots_iron.getItemMeta();
		lore.set(0, "Jump Boost 2");
		boots_meta.setLore(lore);
		boots_meta.addEnchant(Enchantment.PROTECTION_FALL, 2, true);
		boots_iron.setItemMeta(boots_meta);
		boots_meta = boots_diamond.getItemMeta();
		boots_meta.setLore(lore);
		boots_meta.addEnchant(Enchantment.PROTECTION_FALL, 3, true);
		boots_diamond.setItemMeta(boots_meta);
		
		lore.clear();
		lore.add("");
		lore.add("§9+20% Max Health");
		helmet_leather.setItemMeta(helmet_meta);
		helmet_meta.setLore(lore);
		helmet_leather.setItemMeta(helmet_meta);
		helmet_meta = helmet_golden.getItemMeta();
		lore.set(1, "§9+40% Max Health");
		helmet_meta.setLore(lore);
		helmet_golden.setItemMeta(helmet_meta);
		helmet_meta = helmet_chain.getItemMeta();
		lore.set(1, "§9+60% Max Health");
		helmet_meta.setLore(lore);
		helmet_chain.setItemMeta(helmet_meta);
		helmet_meta = helmet_iron.getItemMeta();
		lore.set(1, "§9+80% Max Health");
		helmet_meta.setLore(lore);
		helmet_iron.setItemMeta(helmet_meta);
		helmet_meta = helmet_diamond.getItemMeta();
		lore.set(1, "§9+100% Max Health");
		helmet_meta.setLore(lore);
		helmet_diamond.setItemMeta(helmet_meta);
		
		lore.clear();
		lore.add("");
		lore.add("§9+20% Speed");
		leggings_leather.setItemMeta(leggings_meta);
		leggings_meta.setLore(lore);
		leggings_leather.setItemMeta(leggings_meta);
		leggings_meta = leggings_golden.getItemMeta();
		lore.set(1, "§9+40% Speed");
		leggings_meta.setLore(lore);
		leggings_golden.setItemMeta(leggings_meta);
		leggings_meta = leggings_chain.getItemMeta();
		lore.set(1, "§9+60% Speed");
		leggings_meta.setLore(lore);
		leggings_chain.setItemMeta(leggings_meta);
		leggings_meta = leggings_iron.getItemMeta();
		lore.set(1, "§9+80% Speed");
		leggings_meta.setLore(lore);
		leggings_iron.setItemMeta(leggings_meta);
		leggings_meta = leggings_diamond.getItemMeta();
		lore.set(1, "§9+100% Speed");
		leggings_meta.setLore(lore);
		leggings_diamond.setItemMeta(leggings_meta);
	}
	
	public static void loadStuffAllowed(FocusGame fg, Player p)	{
		PlayerIG player = fg.getPlayersInGame().get(p.getName());
		List<String> stuff = fg.getStuffInGame();
		
		if (stuff.contains("helmet"))	{
			if (player.getHelmet().getType() != Material.STAINED_GLASS)	{
				p.getInventory().setHelmet(player.getHelmet());
			}
		}
		if (stuff.contains("chestplate"))	{
			if (player.getChestplate().getType() != Material.STAINED_GLASS)	{
				p.getInventory().setChestplate(player.getChestplate());
			}
		}
		if (stuff.contains("leggings"))	{
			if (player.getLeggings().getType() != Material.STAINED_GLASS)	{
				p.getInventory().setLeggings(player.getLeggings());
			}
		}
		if (stuff.contains("boots"))	{
			if (player.getBoots().getType() != Material.STAINED_GLASS)	{
				p.getInventory().setBoots(player.getBoots());
			}
		}
		if (stuff.contains("sword"))	{
			if (player.getSword().getType() != Material.STAINED_GLASS)	{
				p.getInventory().addItem(player.getSword());
			}
		}
		if (stuff.contains("axe"))	{
			if (player.getAxe().getType() != Material.STAINED_GLASS)	{
				p.getInventory().addItem(player.getAxe());
			}
		}
		if (stuff.contains("bow"))	{
			if (player.getBow().getType() != Material.STAINED_GLASS)	{
				p.getInventory().addItem(player.getBow());
			}
		}
		if (stuff.contains("shield"))	{
			if (player.getShield().getType() != Material.STAINED_GLASS)	{
				p.getInventory().setItemInOffHand(player.getShield());
			}
		}
		if (stuff.contains("enderpearl"))	{
			if (player.getEnderpearl().getType() != Material.STAINED_GLASS)	{
				p.getInventory().addItem(player.getEnderpearl());
			}
		}
		if (stuff.contains("smoke"))	{
			if (player.getSmoke().getType() != Material.STAINED_GLASS)	{
				p.getInventory().addItem(player.getSmoke());
			}
		}
		if (stuff.contains("bow"))	{
			if (player.getBow().getType() != Material.STAINED_GLASS)	{
				p.getInventory().addItem(player.getArrow());
				if (player.getArrow().getAmount() == 64)	{
					p.getInventory().addItem(player.getArrow());
				}
			}
		}
	}
}
