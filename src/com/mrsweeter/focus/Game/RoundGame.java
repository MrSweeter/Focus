package com.mrsweeter.focus.Game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.ConfigLoader.LobbySpawn;
import com.mrsweeter.focus.PlayerIG.PlayerIG;
import com.mrsweeter.focus.PlayerIG.Stuff;

public class RoundGame extends BukkitRunnable	{
	
	private List<Location> mapLocs = new ArrayList<Location>();
	private FocusGame fg;
	private Focus pl;
	private String mapName;
	private List<Player> players = new ArrayList<Player>();
	private BukkitRunnable creeper;
	
	public RoundGame(Focus main, List<Player> p)	{
		players = p;
		pl = main;
		fg = main.getFg();
		creeper = new Creepers(players, fg);
		mapName = loadMapLocs();
		fg.setGameState(GameState.INGAME);
	}

	@Override
	public void run() {
		// Default time: 10min + 30sec par joueur
		creeper.runTaskTimer(pl, 12000+600*fg.getPlayersInGame().size(), 600);
		int random = (int) (Math.random() * mapLocs.size()-1);
		
		for (Player p : Bukkit.getOnlinePlayers())	{
			p.teleport(mapLocs.get(random), TeleportCause.PLUGIN);
			p.setGameMode(GameMode.SPECTATOR);
		}
		if (mapName.equals("vulcano"))	{
			BukkitRunnable geyser = new loadGeyser(pl);
			geyser.runTaskTimer(pl, 200, 200);
		}
		for (Player player : players)	{
			player.teleport(mapLocs.get(random), TeleportCause.PLUGIN);
			player.setGameMode(GameMode.ADVENTURE);
			player.setHealth(20);
			player.setFireTicks(0);
			player.setBedSpawnLocation(mapLocs.get(random), true);
			for (PotionEffect potion : player.getActivePotionEffects())	{
				player.removePotionEffect(potion.getType());
			}
			loadEffect(player);
			mapLocs.remove(random);
			random = (int) (Math.random() * mapLocs.size()-1);
			player.getInventory().clear();
			player.setItemOnCursor(new ItemStack(Material.AIR));
			Stuff.loadStuffAllowed(fg, player);
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 3, 10, false, false));
			player.sendMessage(pl.getConfig().getString("messages_map." + mapName));
			if (fg.getVictories().equals("Rounds"))	{
				player.sendMessage("§6Round: §a" + (fg.getNbreRound()+1));
			}
		}
		actuPlayerLoc();
		
	}
	
	private void loadEffect(Player player) {
		PlayerIG p = fg.getPlayersInGame().get(player.getName());
		ItemStack shield = p.getShield();
		Material boots = p.getBoots().getType();
		
		if (shield == Stuff.shield_1)	{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 36000, 2, true, false), false);
		} else if (shield == Stuff.shield_2)	{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 36000, 1, true, false), false);
		} else if (shield == Stuff.shield_3)	{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 36000, 0, true, false), false);
		}
		
		if (boots == Stuff.boots_golden.getType() || boots == Stuff.boots_chain.getType())	{
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 36000, 0, true, false), false);
		} else if (boots == Stuff.boots_iron.getType() || boots == Stuff.boots_diamond.getType())	{
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 36000, 1, true, false), false);
		}
		
	}

	private String loadMapLocs()	{
		if (fg.getMapsInGame().isEmpty())	{
			mapLocs = LobbySpawn.loadMapSpawn(pl.getConfig(), "secret");
			return "secret";
		} else if (fg.getMapsInGame().size() == 1)	{
			mapLocs = LobbySpawn.loadMapSpawn(pl.getConfig(), fg.getMapsInGame());
			return fg.getMapsInGame().get(0);
		} else	{
			
			if (fg.getMapIGNotUsed().size() == 0)	{
				reloadMap();
			}
			
			int random = (int) (Math.random() * fg.getMapIGNotUsed().size());
			mapLocs = LobbySpawn.loadMapSpawn(pl.getConfig(), fg.getMapIGNotUsed().get(random));
			String map =  fg.getMapIGNotUsed().get(random);
			fg.removeMapUsed(map);
			return map;
		}
	}
	private void actuPlayerLoc()	{
		for (Player p : players)	{
			p.teleport(p.getLocation());
		}
	}
	private void reloadMap()	{
		for (String mapName : fg.getMapsInGame())	{
			fg.addMapUsed(mapName);
		}
	}
}
