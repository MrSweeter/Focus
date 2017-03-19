package com.mrsweeter.focus.Game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Focus;

public class loadGeyser extends BukkitRunnable	{
	
	private Focus pl;
	private List<Location> geyserLocs = new ArrayList<Location>();
	
	public loadGeyser(Focus main) {
		pl = main;
		loadGeyserLoc();
	}

	@Override
	public void run() {
		int random = (int) (Math.random() * geyserLocs.size()-1);
		BukkitRunnable geyser = new Geyser(geyserLocs.get(random));
		geyser.runTaskTimer(pl, 0, 2);
		
	}
	
	private void loadGeyserLoc() {
		
		String[] coord;
		World w = Bukkit.getServer().getWorld("world");
		
		for (Object str : pl.getConfig().getList("geyser"))	{
			if (str != null)	{
				str.toString();
				coord = ((String) str).split("/");
				geyserLocs.add(new Location(w,
						Double.parseDouble(coord[0]),
						Double.parseDouble(coord[1]),
						Double.parseDouble(coord[2])));
			}
		}
	}
}
