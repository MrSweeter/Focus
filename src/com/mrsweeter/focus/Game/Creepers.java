package com.mrsweeter.focus.Game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;

public class Creepers extends BukkitRunnable	{
	
	private List<Player> players = new ArrayList<Player>();
	private EntityType ent = EntityType.CREEPER;
	private boolean broadcast;
	private FocusGame fg;

	public Creepers(List<Player> p, FocusGame game) {
		players = p;
		broadcast = true;
		fg = game;
	}

	@Override
	public void run() {
		if (fg.isGameState(GameState.INGAME));
			if (broadcast)	{
				for (Player player : players)	{
					player.sendTitle("§c§lDeathmatch", "§ccoming soon", 20, 60, 20);
					player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, 0, true, false), false);
				}
				broadcast = false;
			} else	{
				for (Player player : players)	{
					Creeper creeper = (Creeper) player.getWorld().spawnEntity(player.getLocation(), ent);
					creeper.setPowered(true);
					creeper.setSilent(true);
					creeper.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10000, 5, false, false));
					creeper.setCollidable(false);
				}
			}
	}
}
