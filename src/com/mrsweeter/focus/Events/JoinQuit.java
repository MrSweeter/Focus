package com.mrsweeter.focus.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.ConfigLoader.Spawn;
import com.mrsweeter.focus.Game.Game;
import com.mrsweeter.focus.Game.RoundGame;
import com.mrsweeter.focus.Menus.StuffMenu;
import com.mrsweeter.focus.PlayerIG.Teams;

public class JoinQuit implements Listener {
	
	private Focus pl;
	Spawn spawn;
	
	public JoinQuit(Focus main, Spawn spawnServer) {
		this.pl = main;
		this.spawn = spawnServer;		
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event)	{
		
		event.setJoinMessage("§a§l" + event.getPlayer().getName() + " §6join Focus");
		
		Player p = event.getPlayer();
		p.sendTitle("§6§l--- Focus §cbeta §6---", "§7- by Tagazok_ -", 20, 60, 20);
		for (PotionEffect potion : p.getActivePotionEffects())	{
			p.removePotionEffect(potion.getType());
		}
		if (pl.getFg().isGameState(GameState.INGAME) || pl.getFg().isGameState(GameState.WAITING))	{
			p.setGameMode(GameMode.SPECTATOR);
		} else	{
			if (p.isOp())	{
				p.setGameMode(GameMode.CREATIVE);
				p.getInventory().clear();
			} else	{
				p.setGameMode(GameMode.ADVENTURE);
				p.getInventory().clear();
			}
			p.setHealth(20);
			p.getInventory().addItem(pl.getFg().getColor());
		}
		p.teleport(spawn.getSpawn());
		p.setScoreboard(Teams.scoreboard);
		p.setScoreboard(Teams.scoreLife);
		for (Player player : Bukkit.getOnlinePlayers())	{
			if (pl.getFg().getDisplayHP())	{player.setScoreboard(Teams.scoreLife);}
		}
		p.setBedSpawnLocation(pl.getSpawn(), true);
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event)	{
		event.setQuitMessage("§a§l" + event.getPlayer().getName() + " §6quit Focus");
		FocusGame fg = pl.getFg();
		if (!fg.getColorInGame().isEmpty() && !fg.getPlayersInGame().isEmpty() && event.getPlayer().getName() != null &&
				fg.getPlayersInGame().containsKey(event.getPlayer().getName())) {
			
			if (fg.getColorInGame().contains(fg.getPlayersInGame().get(event.getPlayer().getName()).getTeamColor()))	{
				fg.getColorInGame().remove(fg.getPlayersInGame().get(event.getPlayer().getName()).getTeamColor());
			}
			
			if (fg.getPlayersInGame().containsKey(event.getPlayer().getName()))	{
				fg.getPlayersInGame().remove(event.getPlayer().getName());
			}
			
		}
		if (!pl.getFg().isGameState(GameState.LOBBY))	{
			if (pl.getFg().isGameState(GameState.WAITING))	{
				if (pl.getFg().getAllReady() >= pl.getFg().getPlayersInGame().size())	{
					pl.getFg().setRound(new RoundGame(pl, Game.loadPlayer(pl.getFg())));
					pl.getFg().getRound().run();
					pl.getFg().setAllReady(0);
					pl.getFg().setGameState(GameState.INGAME);
					for (String str : pl.getFg().getPlayersInGame().keySet())	{
						pl.getFg().getPlayersInGame().get(str).setReady(false);
						pl.getFg().getPlayersInGame().get(str).getStuffInventory().remove(Material.BEACON);
						pl.getFg().getPlayersInGame().get(str).getStuffInventory().setItem(34, StuffMenu.ready);
					}
			}
			} else	{ClickStuff.tellsWaitingPlayer(pl.getFg());}
			if (event.getPlayer().getGameMode() != GameMode.SPECTATOR)	{
				Death.endRound(null);
				Death.endFocusGame(null);
			}
		}
	}
	
	@EventHandler
	public void onLogin(AsyncPlayerPreLoginEvent event)	{
	}
}
