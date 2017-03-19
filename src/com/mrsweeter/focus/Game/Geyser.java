package com.mrsweeter.focus.Game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Geyser extends BukkitRunnable {
	
	private Location loc;
	private int time;
	
	public Geyser(Location geyserLoc) {
		loc = geyserLoc;
		time = 0;
	}

	@Override
	public void run() {
		if (time <= 60)	{
			loc.getWorld().spawnParticle(Particle.LAVA, loc, 10, 1, 3, 1);
			for (Entity e : getNearbyEntities(loc, 1))	{
				if (e instanceof Player)	{
					((Player) e).setFireTicks(120);
				}
			}
			
		} else	{
			this.cancel();
		}
		time++;
	}
	
	private List<Entity> getNearbyEntities(Location loc, double radius)	{
		List<Entity> entities = new ArrayList<Entity>();
		for (Entity e : loc.getWorld().getEntities())	{
			if (loc.distance(e.getLocation()) <= radius)	{
				entities.add(e);
			}
		}
		return entities;
	}

}
