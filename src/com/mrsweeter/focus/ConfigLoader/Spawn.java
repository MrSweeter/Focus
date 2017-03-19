package com.mrsweeter.focus.ConfigLoader;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import com.mrsweeter.focus.Focus;

public class Spawn {
	
	private String[] coord;
	private Location spawn;
	private List<Location> blocks;
	private List<Location> beacon;
	
	
	public Spawn(Focus main)	{
		coord = main.getConfig().getString("spawn-server").split("/");
		spawn = new Location(Bukkit.getWorld("world"),
				Double.parseDouble(coord[0]),
				Double.parseDouble(coord[1]),
				Double.parseDouble(coord[2]));
		blocks = new ArrayList<Location>();
		loadBlockSpawn(main.getConfig());
		loadBeaconColor(main.getConfig());
	}
	
	public Location getSpawn()	{
		return spawn;
	}
	public List<Location> getBlocks()	{
		return blocks;
	}
	public List<Location> getBeacon()	{
		return beacon;
	}
	
	private void loadBlockSpawn(FileConfiguration config)	{
		
		if (blocks != null)	{blocks.clear();}
		
		String[] coord;
		World w = Bukkit.getServer().getWorld("world");
		
		for (Object str : config.getList("spawn-block"))	{
			if (str != null)	{
				str.toString();
				coord = ((String) str).split("/");
				blocks.add(new Location(w,
						Double.parseDouble(coord[0]),
						Double.parseDouble(coord[1]),
						Double.parseDouble(coord[2])));
			}
		}
	}
	
	private void loadBeaconColor(FileConfiguration config)	{
		
		if (beacon != null)	{beacon.clear();}
		beacon = new ArrayList<Location>();
		String[] coord;
		World w = Bukkit.getServer().getWorld("world");
		
		for (Object str : config.getList("beacon-spawn"))	{
			if (str != null)	{
				str.toString();
				coord = ((String) str).split("/");
				beacon.add(new Location(w,
						Double.parseDouble(coord[0]),
						Double.parseDouble(coord[1]),
						Double.parseDouble(coord[2])));
			}
		}
		
	}
}
