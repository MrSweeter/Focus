package com.mrsweeter.focus.Game;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Focus;

public class BlockSpawn extends BukkitRunnable	{
	
	private Focus pl;
	private List<Location> blocks;
	private int i;
	private String color;

	public BlockSpawn(Focus main, String winner) {
		pl = main;
		blocks = pl.getBlockSpawn();
		i = 0;
		color = winner;
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		ItemStack mat = selectBlock(); 
		
		if (i < blocks.size())	{
			World w = Bukkit.getWorld("world");
			Block b = w.getBlockAt(blocks.get(i));
			b.setType(mat.getType());
			b.setData(mat.getData().getData());
			i++;
		} else	{
			this.cancel();
			setBeaconColor();
		}
		
		
	}

	@SuppressWarnings("deprecation")
	private void setBeaconColor() {
		
		List<Location> beaconColor = pl.getBeaconSpawn();
		
		World w = Bukkit.getWorld("world");
		Block b1 = w.getBlockAt(beaconColor.get(0));
		Block b2 = w.getBlockAt(beaconColor.get(1));
		ItemStack mat1 = null;
		ItemStack mat2 = null;
		
		switch (color)	{
		case "dark red":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 14);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 14);
			break;
		case "red":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 14);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 0);
			break;
		case "gold":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 1);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 4);
			break;
		case "yellow":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 4);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 4);
			break;
		case "dark green":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 13);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 13);
			break;
		case "green":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 5);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 5);
			break;
		case "aqua":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 9);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 0);
			break;
		case "dark aqua":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 9);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 9);
			break;
		case "dark blue":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 11);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 11);
			break;
		case "blue":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 3);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 3);
			break;
		case "light purple":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 2);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 2);
			break;
		case "dark purple":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 10);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 10);
			break;
		case "white":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 0);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 0);
			break;
		case "gray":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 8);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 8);
			break;
		case "dark gray":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 7);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 7);
			break;
		case "black":
			mat1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 15);
			mat2 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 15);
			break;
		default:
			mat1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 9);
			mat2 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 9);
			break;
		}
		
		b1.setType(mat1.getType());
		b1.setData(mat1.getData().getData());
		b2.setType(mat2.getType());
		b2.setData(mat2.getData().getData());
	}

	private ItemStack selectBlock() {
		
		switch (color)	{
		case "dark red":
			return new ItemStack(Material.REDSTONE_BLOCK);
		case "red":
			return new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		case "gold":
			return new ItemStack(Material.GOLD_BLOCK);
		case "yellow":
			return new ItemStack(Material.WOOL, 1, (byte) 4);
		case "dark green":
			return new ItemStack(Material.WOOL, 1, (byte) 13);
		case "green":
			return new ItemStack(Material.WOOL, 1, (byte) 5);
		case "aqua":
			return new ItemStack(Material.DIAMOND_BLOCK);
		case "dark aqua":
			return new ItemStack(Material.WOOL, 1, (byte) 9);
		case "dark blue":
			return new ItemStack(Material.WOOL, 1, (byte) 3);
		case "blue":
			return new ItemStack(Material.WOOL, 1, (byte) 11);
		case "light purple":
			return new ItemStack(Material.WOOL, 1, (byte) 2);
		case "dark purple":
			return new ItemStack(Material.WOOL, 1, (byte) 10);
		case "white":
			return new ItemStack(Material.IRON_BLOCK);
		case "gray":
			return new ItemStack(Material.WOOL, 1, (byte) 8);
		case "dark gray":
			return new ItemStack(Material.STAINED_CLAY, 1, (byte) 9);
		case "black":
			return new ItemStack(Material.COAL_BLOCK);
		default:
			return new ItemStack(Material.STAINED_GLASS);
		}
	}
}
