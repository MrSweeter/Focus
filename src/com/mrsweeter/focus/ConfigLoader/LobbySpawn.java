package com.mrsweeter.focus.ConfigLoader;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class LobbySpawn {
	
	public static List<Location> loadLobby(FileConfiguration config)	{
		
		List<Location> locs = new ArrayList<Location>();
		
		String[] coord;
		World w = Bukkit.getServer().getWorld("world");
		
		for (Object str : config.getList("lobby"))	{
			if (str != null)	{
				str.toString();
				coord = ((String) str).split("/");
				locs.add(new Location(w,
						Double.parseDouble(coord[0]),
						Double.parseDouble(coord[1]),
						Double.parseDouble(coord[2])));
			}
		}
		return locs;
	}
	
	public static List<Location> loadMapSpawn(FileConfiguration config, List<String> list)	{
		
		String map = "";
		for (String str : list)	{
			map = str;
		}
		return loadMapSpawn(config, map);
	}
	
	public static List<Location> loadMapSpawn(FileConfiguration config, String map)	{
		
		List<Location> locs = new ArrayList<Location>();
		
		String[] coord;
		World w = Bukkit.getServer().getWorld("world");
		
		for (Object str : config.getList(map))	{
			if (str != null)	{
				str.toString();
				coord = ((String) str).split("/");
				locs.add(new Location(w,
						Double.parseDouble(coord[0]),
						Double.parseDouble(coord[1]),
						Double.parseDouble(coord[2])));
			}
		}
		return locs;
	}
}
