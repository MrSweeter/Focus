package com.mrsweeter.focus.Game;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.PlayerIG.PlayerIG;
import com.mrsweeter.focus.PlayerIG.Stuff;

public class PlayerEffects extends BukkitRunnable	{
	
	private PlayerIG p;
	private Focus pl;
	private Player player;

	public PlayerEffects(Focus main, Player player) {
		pl = main;
		p = pl.getFg().getPlayersInGame().get(player.getName());
		this.player = player;
	}

	@Override
	public void run() {
		Material boots = p.getBoots().getType();
		
		if (boots == Stuff.boots_golden.getType() || boots == Stuff.boots_chain.getType())	{
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 36000, 0, true, false), false);
		} else if (boots == Stuff.boots_iron.getType() || boots == Stuff.boots_diamond.getType())	{
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 36000, 1, true, false), false);
		}
	}

}
