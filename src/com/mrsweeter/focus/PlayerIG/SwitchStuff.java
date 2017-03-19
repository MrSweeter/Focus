package com.mrsweeter.focus.PlayerIG;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.Inventory;

import com.mrsweeter.focus.Menus.StuffMenu;

public class SwitchStuff	{

	public static void switchHelmet(PlayerIG player, int point)	{
		
		Inventory inv = player.getStuffInventory();
		Attribute a = Attribute.GENERIC_MAX_HEALTH;
		AttributeInstance ai = player.getPlayerMC().getAttribute(a);
		for (AttributeModifier am : ai.getModifiers())	{ai.removeModifier(am);}
		
		switch (player.getHelmet().getType())	{
		case STAINED_GLASS:
			ai.addModifier(new AttributeModifier("health", 0.2, Operation.ADD_SCALAR));
			player.setHelmet(Stuff.helmet_leather);
			inv.setItem(13, StuffMenu.helmet_golden);
			break;
		case LEATHER_HELMET:
			ai.addModifier(new AttributeModifier("health", 0.4, Operation.ADD_SCALAR));
			player.setHelmet(Stuff.helmet_golden);
			inv.setItem(13, StuffMenu.helmet_chain);
			break;
		case GOLD_HELMET:
			ai.addModifier(new AttributeModifier("health", 0.6, Operation.ADD_SCALAR));
			player.setHelmet(Stuff.helmet_chain);
			inv.setItem(13, StuffMenu.helmet_iron);
			break;
		case CHAINMAIL_HELMET:
			ai.addModifier(new AttributeModifier("health", 0.8, Operation.ADD_SCALAR));
			player.setHelmet(Stuff.helmet_iron);
			inv.setItem(13, StuffMenu.helmet_diamond);
			break;
		case IRON_HELMET:
			ai.addModifier(new AttributeModifier("health", 1.0, Operation.ADD_SCALAR));
			player.setHelmet(Stuff.helmet_diamond);
			inv.setItem(13, StuffMenu.noMore);
			break;
		default:
			player.setHelmet(player.getHelmet());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
	}
	
	public static void switchChestPlate(PlayerIG player, int point)	{
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getChestplate().getType())	{
		case STAINED_GLASS:
			player.setChestplate(Stuff.chestplate_leather);
			inv.setItem(22, StuffMenu.chestplate_golden);
			break;
		case LEATHER_CHESTPLATE:
			player.setChestplate(Stuff.chestplate_golden);
			inv.setItem(22, StuffMenu.chestplate_chain);
			break;
		case GOLD_CHESTPLATE:
			player.setChestplate(Stuff.chestplate_chain);
			inv.setItem(22, StuffMenu.chestplate_iron);
			break;
		case CHAINMAIL_CHESTPLATE:
			player.setChestplate(Stuff.chestplate_iron);
			inv.setItem(22, StuffMenu.chestplate_diamond);
			break;
		case IRON_CHESTPLATE:
			player.setChestplate(Stuff.chestplate_diamond);
			inv.setItem(22, StuffMenu.noMore);
			break;
		default:
			player.setChestplate(player.getChestplate());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
	}
	
	public static void switchLeggings(PlayerIG player, int point)	{
		
		Inventory inv = player.getStuffInventory();
		Attribute a = Attribute.GENERIC_MOVEMENT_SPEED;
		AttributeInstance ai = player.getPlayerMC().getAttribute(a);
		for (AttributeModifier am : ai.getModifiers())	{ai.removeModifier(am);}
		
		switch (player.getLeggings().getType())	{
		case STAINED_GLASS:
			ai.addModifier(new AttributeModifier("speed", 0.15, Operation.ADD_SCALAR));
			player.setLeggings(Stuff.leggings_leather);
			inv.setItem(31, StuffMenu.leggings_golden);
			break;
		case LEATHER_LEGGINGS:
			ai.addModifier(new AttributeModifier("speed", 0.3, Operation.ADD_SCALAR));
			player.setLeggings(Stuff.leggings_golden);
			inv.setItem(31, StuffMenu.leggings_chain);
			break;
		case GOLD_LEGGINGS:
			ai.addModifier(new AttributeModifier("speed", 0.45, Operation.ADD_SCALAR));
			player.setLeggings(Stuff.leggings_chain);
			inv.setItem(31, StuffMenu.leggings_iron);
			break;
		case CHAINMAIL_LEGGINGS:
			ai.addModifier(new AttributeModifier("speed", 0.6, Operation.ADD_SCALAR));
			player.setLeggings(Stuff.leggings_iron);
			inv.setItem(31, StuffMenu.leggings_diamond);
			break;
		case IRON_LEGGINGS:
			ai.addModifier(new AttributeModifier("speed", 0.75, Operation.ADD_SCALAR));
			player.setLeggings(Stuff.leggings_diamond);
			inv.setItem(31, StuffMenu.noMore);
			break;
		default:
			player.setLeggings(player.getLeggings());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
	}
	
	public static void switchBoots(PlayerIG player, int point)	{
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getBoots().getType())	{
		case STAINED_GLASS:
			player.setBoots(Stuff.boots_leather);
			inv.setItem(40, StuffMenu.boots_golden);
			break;
		case LEATHER_BOOTS:
			player.setBoots(Stuff.boots_golden);
			inv.setItem(40, StuffMenu.boots_chain);
			break;
		case GOLD_BOOTS:
			player.setBoots(Stuff.boots_chain);
			inv.setItem(40, StuffMenu.boots_iron);
			break;
		case CHAINMAIL_BOOTS:
			player.setBoots(Stuff.boots_iron);
			inv.setItem(40, StuffMenu.boots_diamond);
			break;
		case IRON_BOOTS:
			player.setBoots(Stuff.boots_diamond);
			inv.setItem(40, StuffMenu.noMore);
			break;
		default:
			player.setBoots(player.getBoots());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
	}

	public static void switchSword(PlayerIG player, int point) {
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getSword().getType())	{
		case STICK:
			player.setSword(Stuff.sword_wooden);
			inv.setItem(21, StuffMenu.sword_stone);
			break;
		case WOOD_SWORD:
			player.setSword(Stuff.sword_stone);
			inv.setItem(21, StuffMenu.sword_iron);
			break;
		case STONE_SWORD:
			player.setSword(Stuff.sword_iron);
			inv.setItem(21, StuffMenu.sword_diamond);
			break;
		case IRON_SWORD:
			player.setSword(Stuff.sword_diamond);
			inv.setItem(21, StuffMenu.sword_golden);
			break;
		case DIAMOND_SWORD:
			player.setSword(Stuff.sword_golden);
			inv.setItem(21, StuffMenu.noMore);
			break;
		default:
			player.setSword(player.getSword());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
		
	}

	public static void switchAxe(PlayerIG player, int point) {
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getAxe().getType())	{
		case STAINED_GLASS:
			player.setAxe(Stuff.axe_wooden);
			inv.setItem(30, StuffMenu.axe_stone);
			break;
		case WOOD_AXE:
			player.setAxe(Stuff.axe_stone);
			inv.setItem(30, StuffMenu.axe_iron);
			break;
		case STONE_AXE:
			player.setAxe(Stuff.axe_iron);
			inv.setItem(30, StuffMenu.axe_diamond);
			break;
		case IRON_AXE:
			player.setAxe(Stuff.axe_diamond);
			inv.setItem(30, StuffMenu.axe_golden);
			break;
		case DIAMOND_AXE:
			player.setAxe(Stuff.axe_golden);
			inv.setItem(30, StuffMenu.noMore);
			break;
		default:
			player.setAxe(player.getAxe());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
		
	}

	public static void switchShield(PlayerIG player, int point) {
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getShield().getType())	{
		case STAINED_GLASS:
			player.setShield(Stuff.shield_1);
			inv.setItem(39, StuffMenu.shield_2);
			break;
		case SHIELD:
			if (player.getShield() == Stuff.shield_1)	{
				player.setShield(Stuff.shield_2);
				inv.setItem(39, StuffMenu.shield_3);
			} else if (player.getShield() == Stuff.shield_2)	{
				player.setShield(Stuff.shield_3);
				inv.setItem(39, StuffMenu.noMore);
			}
			break;
		default:
			player.setShield(player.getShield());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
		
	}

	public static void switchEnderpearl(PlayerIG player, int point) {
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getEnderpearl().getType())	{
		case STAINED_GLASS:
			player.setEnderpearl(Stuff.enderpearl_1);
			inv.setItem(14, StuffMenu.enderpearl_2);
			break;
		case ENDER_PEARL:
			if (player.getEnderpearl() == Stuff.enderpearl_1)	{
				player.setEnderpearl(Stuff.enderpearl_2);
				inv.setItem(14, StuffMenu.noMore);
			}
			break;
		default:
			player.setEnderpearl(player.getEnderpearl());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
		
	}

	public static void switchBow(PlayerIG player, int point) {
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getBow().getType())	{
		case STAINED_GLASS:
			player.setBow(Stuff.bow_power1);
			player.setArrow(Stuff.arrow);
			inv.setItem(23, StuffMenu.bow_power2);
			inv.setItem(32, StuffMenu.arrow_5);
			break;
		case BOW:
			if (player.getBow() == Stuff.bow_power1)	{
				player.setBow(Stuff.bow_power2);
				inv.setItem(23, StuffMenu.bow_p3_punch1);
			} else if (player.getBow() == Stuff.bow_power2)	{
				player.setBow(Stuff.bow_p3_punch1);
				inv.setItem(23, StuffMenu.bow_p4_punch1);
			} else if (player.getBow() == Stuff.bow_p3_punch1)	{
				player.setBow(Stuff.bow_p4_punch1);
				inv.setItem(23, StuffMenu.bow_p5_punch2);
			} else if (player.getBow() == Stuff.bow_p4_punch1)	{
				player.setBow(Stuff.bow_p5_punch2);
				inv.setItem(23, StuffMenu.noMore);
			}
			break;
		default:
			player.setBow(player.getBow());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
		
	}

	public static void switchArrow(PlayerIG player, int point) {
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getArrow().getType())	{
		case ARROW:
			if (player.getArrow() == Stuff.arrow)	{
				player.setArrow(Stuff.arrow_5);
				inv.setItem(32, StuffMenu.arrow_10);
			} else if (player.getArrow() == Stuff.arrow_5)	{
				player.setArrow(Stuff.arrow_10);
				inv.setItem(32, StuffMenu.arrow_20);
			} else if (player.getArrow() == Stuff.arrow_10)	{
				player.setArrow(Stuff.arrow_20);
				inv.setItem(32, StuffMenu.arrow_30);
			} else if (player.getArrow() == Stuff.arrow_20)	{
				player.setArrow(Stuff.arrow_30);
				inv.setItem(32, StuffMenu.noMore);
			}
			break;
		default:
			player.setArrow(player.getArrow());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
		
	}

	public static void switchSmoke(PlayerIG player, int point) {
		
		Inventory inv = player.getStuffInventory();
		
		switch (player.getSmoke().getType())	{
		case STAINED_GLASS:
			player.setSmoke(Stuff.smoke_1);
			inv.setItem(41, StuffMenu.smoke_2);
			break;
		case SNOW_BALL:
			if (player.getSmoke() == Stuff.smoke_1)	{
				player.setSmoke(Stuff.smoke_2);
				inv.setItem(41, StuffMenu.smoke_3);
			} else if (player.getSmoke() == Stuff.smoke_2)	{
				player.setSmoke(Stuff.smoke_3);
				inv.setItem(41, StuffMenu.smoke_4);
			} else if (player.getSmoke() == Stuff.smoke_3)	{
				player.setSmoke(Stuff.smoke_4);
				inv.setItem(41, StuffMenu.noMore);
			}
			break;
		default:
			player.setSmoke(player.getSmoke());
			break;
		}
		player.setPoint(player.getPoint()-point);
		player.setPointItemMeta(player.getPoint());
		inv.setItem(28, player.getPointItem());
		
	}
}
