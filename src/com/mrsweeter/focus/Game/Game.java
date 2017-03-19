package com.mrsweeter.focus.Game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.ConfigLoader.LobbySpawn;
import com.mrsweeter.focus.Events.Death;

public class Game extends BukkitRunnable	{
	
	private List<Location> lobby = new ArrayList<Location>();
	private List<Player> players = new ArrayList<Player>();
	private FocusGame fg;
	private Focus pl;
	
	public Game(Focus main) {
		pl = main;
		fg = pl.getFg();
		fg.setGameState(GameState.WAITING);
		lobby = LobbySpawn.loadLobby(pl.getConfig());
		loadPlayer();
		fg.setKilled(0);
	}

	@Override
	public void run() {
		specAll();
		fg.setGameState(GameState.WAITING);
		for (int i = 0; i < players.size(); i++)	{
			Player p = players.get(i);
			p.setBedSpawnLocation(lobby.get(i), true);
			p.setHealth(20);
			p.setGameMode(GameMode.ADVENTURE);
			p.setFireTicks(0);
			for (PotionEffect potion : p.getActivePotionEffects())	{
				p.removePotionEffect(potion.getType());
			}
			if (!fg.isAlreadyLoad())	{
				for (Player player : players)	{
					fg.getPlayersInGame().get(p.getName()).setPoint(fg.getStartingPoint());
					fg.getPlayersInGame().get(player.getName()).fillStuff(fg);
					Death.clearAttribute(player);
				}
			} else	{
				fg.getPlayersInGame().get(p.getName()).setPoint(fg.getPlayersInGame().get(p.getName()).getPoint()+10);
				fg.getPlayersInGame().get(p.getName()).actuStuff(fg.getPlayersInGame().get(p.getName()));
			}
			p.teleport(lobby.get(i), TeleportCause.PLUGIN);
			p.openInventory(fg.getPlayersInGame().get(p.getName()).getStuffInventory());
			p.getInventory().addItem(pl.getFg().getStuff());
		}
		fg.setAlreadyLoad(true);
	}
	
	private void specAll()	{
		for (Player p : Bukkit.getOnlinePlayers())	{
			p.setGameMode(GameMode.SPECTATOR);
			p.getInventory().clear();
		}
	}
	
	private void loadPlayer()	{
		for (String pIG : fg.getPlayersInGame().keySet())	{
			players.add(fg.getPlayersInGame().get(pIG).getPlayerMC());
		}
	}
	public static List<Player> loadPlayer(FocusGame fg)	{
		List<Player> p = new ArrayList<Player>();
		for (String pIG : fg.getPlayersInGame().keySet())	{
			p.add(fg.getPlayersInGame().get(pIG).getPlayerMC());
		}
		return p;
	}	
}
