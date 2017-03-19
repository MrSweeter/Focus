package com.mrsweeter.focus.Events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Score;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.Game.BlockSpawn;
import com.mrsweeter.focus.Game.Game;
import com.mrsweeter.focus.PlayerIG.Teams;

public class Death implements Listener	{
	
	private static Focus pl;
	private static FocusGame fg;
	private static Score score;
	
	public Death(Focus main) {
		pl = main;
		fg = pl.getFg();
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event)	{
		
		Player victim = event.getEntity();
		Entity murder = victim.getKiller();
		Location loc = pl.getSpawn();
		
		if (fg.isGameState(GameState.INGAME))	{
			if (victim.getGameMode() == GameMode.ADVENTURE)	{
				fg.setKilled(fg.getKilled()+1);
			}
			victim.setGameMode(GameMode.SPECTATOR);
			loc = victim.getLocation();
			loc.setY(loc.getY()+3);
			if (loc.getY() < -50)	{loc.setY(loc.getY()*-1 - 50);}
			else if (loc.getY() < 0)	{loc.setY(loc.getY()*-1);}
			victim.setBedSpawnLocation(loc, true);
			victim.setHealth(20);
			victim.teleport(loc, TeleportCause.PLUGIN);
		} else	{
			victim.teleport(loc, TeleportCause.PLUGIN);
			victim.setBedSpawnLocation(loc, true);
		}
		if (fg.isGameState(GameState.INGAME) && murder != null && !murder.isDead())	{			
			
			fg.getPlayersInGame().get(murder.getName()).addKill(1);
			fg.getPlayersInGame().get(murder.getName()).addPoint(fg.getKillPoint());
			
			if (fg.getVictories().equals("Kills") || fg.getVictories().equals("Rounds"))	{fg.getPlayersInGame().get(murder.getName()).addVictories(1);}
			
			((Player) murder).setLevel(((Player) murder).getLevel()+1);
			if(!fg.getVictories().equals("Victories"))	{
				score = Teams.kill.getScore(murder.getName());
				score.setScore(fg.getPlayersInGame().get(murder.getName()).getKill());
			}
			
		}
		if (fg.isGameState(GameState.INGAME))	{
			if (murder == null || murder.isDead())	{
				endRound(null);
				endFocusGame(null);
			} else	{
				endRound((Player) murder);
				endFocusGame((Player) murder);
			}
		}
	}
	
	public static void endRound(Player p)	{
		if (fg.getKilled() >= fg.getPlayersInGame().size()-1)	{
			if (p != null)	{
				Bukkit.getServer().broadcastMessage("§l" + p.getName() + "§6 win this round");
				if (fg.getVictories().equals("Victories"))	{
					fg.getPlayersInGame().get(p.getName()).addVictories(1);
					score = Teams.kill.getScore(p.getName());
					score.setScore(fg.getPlayersInGame().get(p.getName()).getVictories());
				}
				fg.getPlayersInGame().get(p.getName()).addPoint(fg.getRoundPoint());
			} else	{
				Player mur = null;
				for (String name : fg.getPlayersInGame().keySet())	{
					if (!fg.getPlayersInGame().get(name).getPlayerMC().isDead() && 
							fg.getPlayersInGame().get(name).getPlayerMC().getGameMode() != GameMode.SPECTATOR)	{
						mur = fg.getPlayersInGame().get(name).getPlayerMC();
						break;
					}
				}
				if (fg.isGameState(GameState.INGAME) && mur != null)	{
					Bukkit.getServer().broadcastMessage("§l" + mur.getName() + "§6 win this round");
					if (fg.getVictories().equals("Victories"))	{
						fg.getPlayersInGame().get(mur.getName()).addVictories(1);
						score = Teams.kill.getScore(mur.getName());
						score.setScore(fg.getPlayersInGame().get(mur.getName()).getVictories());
					}
					fg.getPlayersInGame().get(mur.getName()).addPoint(fg.getRoundPoint());
				}
			}
			if (fg.getVictories().equals("Rounds"))	{fg.setNbreRound(fg.getNbreRound()+1);}
			Bukkit.getScheduler().cancelAllTasks();
			fg.setGame(new Game(pl));
			fg.getGame().run();
		}
	}
	public static void endFocusGame(Player p)	{
		if (fg.getPlayersInGame().size() > 1)	{
			if (fg.getVictories().equals("Rounds") || p == null)	{p = findWinner();}
			if ((fg.getNbreRound() == fg.getLimitVictories()) || (
					!fg.getVictories().equals("Rounds") && (fg.getPlayersInGame().get(p.getName()).getVictories() == fg.getLimitVictories())))	{
				
				Bukkit.getScheduler().cancelAllTasks();
				
				for (Player player : Bukkit.getServer().getOnlinePlayers())	{
					player.setFireTicks(0);
					player.teleport(pl.getSpawn());
					player.setBedSpawnLocation(pl.getSpawn(), true);
					player.setGameMode(GameMode.ADVENTURE);
					player.getInventory().clear();
					player.setLevel(player.getLevel()+1);
					player.setHealth(20);
					player.getInventory().addItem(pl.getFg().getColor());
					if (p != null)	{
						player.sendTitle("§l" + p.getName() + "§6 win this game", "§9/focusreset to force reset", 20, 120, 20);
					}
					BukkitRunnable block = new BlockSpawn(pl, fg.getPlayersInGame().get(p.getName()).getTeamColor());
					block.runTaskTimer(pl, 0, 10);
					clearAttribute(player);
				}
				pl.focusGameReload();
			}
		} else	{
			p = findWinner();
			for (Player player : Bukkit.getServer().getOnlinePlayers())	{
				player.setFireTicks(0);
				player.teleport(pl.getSpawn());
				player.setBedSpawnLocation(pl.getSpawn(), true);
				player.setGameMode(GameMode.ADVENTURE);
				player.getInventory().clear();
				player.setLevel(player.getLevel()+1);
				player.setHealth(20);
				player.getInventory().addItem(pl.getFg().getColor());
				if (p != null)	{
					player.sendTitle("§l" + p.getName() + "§6 win this game", "§9/focusreset", 20, 60, 20);
				}
				BukkitRunnable block = new BlockSpawn(pl, fg.getPlayersInGame().get(p.getName()).getTeamColor());
				block.runTaskTimer(pl, 0, 5);
				clearAttribute(player);
			}
			pl.focusGameReload();
		}
	}
	
	public static void clearAttribute(Player p)	{
		for (Attribute a : Attribute.values())	{
			AttributeInstance ai = p.getAttribute(a);
			if (ai != null)	{
				for (AttributeModifier am : ai.getModifiers())	{ai.removeModifier(am);}
			}
		}
	}

	private static Player findWinner() {
		List<Player> players = new ArrayList<Player>();
		List<Integer> scoreKill = new ArrayList<Integer>();
		
		for (String name : fg.getPlayersInGame().keySet())	{
			players.add(fg.getPlayersInGame().get(name).getPlayerMC());
			scoreKill.add(fg.getPlayersInGame().get(name).getKill());
		}
		Player p = null;
		int kill = 0;
		for (int i = 0; i < players.size(); i++)	{
			if (scoreKill.get(i) >= kill)	{
				kill = scoreKill.get(i);
				p = players.get(i);
			}
		}
		
		return p;
	}
}

