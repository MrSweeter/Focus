package com.mrsweeter.focus.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.Game.PlayerEffects;
import com.mrsweeter.focus.Game.SmokeEffect;

public class EntityInteraction implements Listener	{
	
	private Focus pl;

	public EntityInteraction(Focus main) {
		pl = main;
	}
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event)	{
		Player player = event.getPlayer();
		if (event.getAction().equals(Action.PHYSICAL))	{
			if (event.getClickedBlock().getType() == Material.GOLD_PLATE)	{
				player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10, 10, true, false), false);
				if (pl.getFg().getPlayersInGame().containsKey(player.getName()))	{
					BukkitRunnable effect = new PlayerEffects(pl, player);
					effect.runTaskLater(pl, 21);
				}
			}
		}
	}
	
	@EventHandler
	public void onHunger(FoodLevelChangeEvent event)	{
		
		Entity ent = event.getEntity();
		if (ent instanceof Player)	{
			Player p = (Player) event.getEntity();
			if (p.getFoodLevel() < 20)	{
				p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 10, 255, false, false), false);
			}
		}
	}
	
	@EventHandler
	public void onSmokeLaunch(ProjectileHitEvent event)	{
		
		Block block = event.getHitBlock();
		Entity ent = event.getHitEntity();
		Entity snowball = event.getEntity();
		
		if (snowball instanceof Snowball && (block != null || ent != null))	{
			Location loc = event.getEntity().getLocation();
			Player p = (Player) event.getEntity().getShooter();
			if (pl.getFg().getPlayersInGame().containsKey(p.getName()))	{
				BukkitRunnable smoke = new SmokeEffect(pl, loc, p);
				smoke.runTaskTimer(pl, 0, 1);
			}
		}
	}
	
	@EventHandler
	public void onPortalTemple(PlayerPortalEvent event)	{
		World w = Bukkit.getWorld("world");
		if (event.getCause() == TeleportCause.END_PORTAL)	{
			event.getPlayer().teleport(new Location(w, 1400.5, 85, 600.5));
		}
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onDropIG(PlayerDropItemEvent event)	{
		if (pl.getFg().isGameState(GameState.INGAME) || pl.getFg().isGameState(GameState.WAITING))	{
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPickupIG(PlayerPickupItemEvent event)	{
		if (pl.getFg().isGameState(GameState.INGAME) || pl.getFg().isGameState(GameState.WAITING))	{
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event)	{
		if ((pl.getFg().isGameState(GameState.LOBBY) || pl.getFg().isGameState(GameState.WAITING)) && event.getEntity().getLocation().getBlockY() > 10)	{
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamageAxe(EntityDamageByEntityEvent event)	{
		Entity victimDamage = event.getEntity();
		Entity damager = event.getDamager();
		
		if (victimDamage instanceof Player && damager instanceof Player && pl.getFg().isGameState(GameState.INGAME) && event.getCause() != DamageCause.THORNS)	{
			
			Player victim = (Player) event.getEntity();
			Player murder = (Player) event.getDamager();
			
			Material weapon = murder.getInventory().getItemInMainHand().getType();
			if (weapon == Material.STONE_AXE || weapon == Material.IRON_AXE)	{
				victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0, false, false));
			} else if (weapon == Material.DIAMOND_AXE || weapon == Material.GOLD_AXE)	{
				victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 160, 0, false, false));
			}
		}
	}
}
