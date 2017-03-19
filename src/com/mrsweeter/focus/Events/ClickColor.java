package com.mrsweeter.focus.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scoreboard.Score;

import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.PlayerIG.PlayerIG;
import com.mrsweeter.focus.PlayerIG.Teams;

public class ClickColor {
	
	private static Score score;
	
	public static void color(Player player, InventoryClickEvent event, FocusGame fg)	{
		PlayerIG p = new PlayerIG(player, fg);
		String color = event.getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName().substring(4);
		switch (color) {
		case "Dark red":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.darkRed.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Red":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.red.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Gold":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.gold.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Yellow":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.yellow.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Dark green":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.darkGreen.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Green":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.green.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Aqua":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.aqua.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Dark aqua":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.darkAqua.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Dark blue":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.darkBlue.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Blue":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.blue.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Light purple":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.lightPurple.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Dark purple":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.darkPurple.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "White":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.white.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Gray":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.gray.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Dark gray":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.darkGray.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		case "Black":
			if (!fg.getColorInGame().contains(color.toLowerCase()) && !fg.getPlayersInGame().containsKey(player.getName()))	{
				p.setTeamColor(color.toLowerCase());
				Teams.black.addEntry(player.getName());
				score = Teams.kill.getScore(player.getName());
				score.setScore(0);
				player.setScoreboard(Teams.scoreboard);
				fg.addColorInGame(color.toLowerCase());
				fg.addPlayersInGame(p);
			} else	{
				player.closeInventory();
				player.sendMessage("§cThis team if full or you are already in a team");
			}
			break;
		}
		event.setCancelled(true);
	}
}
