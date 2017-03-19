package com.mrsweeter.focus.Game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.PlayerIG.PlayerIG;
import com.mrsweeter.focus.PlayerIG.Stuff;

public class SmokeEffect extends BukkitRunnable	{
	
	private Location loc;
	private int time;
	private PlayerIG player;
	private ItemStack smoke;
	
	public SmokeEffect(Focus main, Location locItem, Player p) {
		loc = locItem;
		time = 0;
		player = main.getFg().getPlayersInGame().get(p.getName());
		smoke = player.getSmoke();
	}

	@Override
	public void run() {
		if (time > 60)	{this.cancel();}
		if (smoke == Stuff.smoke_1)	{
			loc.getWorld().spawnParticle(Particle.CLOUD, loc, 50, 3, 3, 3, 0.01);
			for (Entity e : getNearbyEntities(loc, 3))	{
				if (e instanceof Player)	{
					((Player) e).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1, true, false), false);
				}
			}
		} else if (smoke == Stuff.smoke_2)	{
			loc.getWorld().spawnParticle(Particle.CLOUD, loc, 50, 4, 4, 4, 0.01);
			for (Entity e : getNearbyEntities(loc, 4))	{
				if (e instanceof Player)	{
					((Player) e).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1, true, false), false);
				}
			}
		} else if (smoke == Stuff.smoke_3 || smoke == Stuff.smoke_4)	{
			loc.getWorld().spawnParticle(Particle.CLOUD, loc, 50, 4, 4, 4, 0.01);
			for (Entity e : getNearbyEntities(loc, 4))	{
				if (e instanceof Player)	{
					((Player) e).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 90, 1, true, false), false);
				}
			}
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
