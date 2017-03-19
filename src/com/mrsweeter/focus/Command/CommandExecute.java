package com.mrsweeter.focus.Command;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.Events.ClickStuff;
import com.mrsweeter.focus.Game.Game;
import com.mrsweeter.focus.Game.RoundGame;
import com.mrsweeter.focus.Menus.LoadMenuSetting;
import com.mrsweeter.focus.Menus.StuffMenu;
import com.mrsweeter.focus.PlayerIG.PlayerIG;

public class CommandExecute {
	
	private static String pName;
	
	public static void reload(PluginManager pm, Focus pl)	{
		pm.disablePlugin(pl);
		pm.enablePlugin(pl);
	}
	
	public static void focusSetting(CommandSender sender, Focus pl) {
		if (sender instanceof Player && pl.getFg().isGameState(GameState.LOBBY))	{
			Player player = (Player) sender;
			if (pl.getFg().isInConfig())	{
				if (player != null && sender.getName().equals(pName))	{
					pl.getFg().setInConfig(false);
					player = (Player) sender;
					player.getInventory().clear();
					player.getInventory().addItem(pl.getFg().getColor());
					sender.sendMessage("§aConfiguration save");
					pName = null;
				} else {
					sender.sendMessage("§cConfiguration already in progress");
				}
			} else if (!pl.getFg().isInConfig())	{
				pl.getFg().setInConfig(true);
				player = (Player) sender;
				sender.sendMessage("§aRe-execute §6/focus §a to save the configuration");
				player.getInventory().clear();
				player.getInventory().addItem(pl.getFg().getSetting());
				pName = player.getName();
				LoadMenuSetting.loadGamemode(pl.getFg());
				player.openInventory(pl.getFg().getInventorySetting());
			}
		} else {
			if (sender instanceof Player && !pl.getFg().isGameState(GameState.LOBBY))	{
				sender.sendMessage("§cConfiguration is only allowed during preparation");
			} else if (!(sender instanceof Player)) {
				sender.sendMessage("§cOnly player can acces to the configuration menu");
			}
		}
	}

	public static void focusInventory(CommandSender sender, Focus pl, String name) {
		if (sender instanceof Player)	{
			if (name.equals("close"))	{
				pl.getFg().getPlayersInGame().get(sender.getName()).setSeen(false);
			} else if (pl.getFg().getPlayersInGame().get(name) != null)	{
				if (pl.getFg().getPlayersInGame().containsKey(sender.getName()))	{
					pl.getFg().getPlayersInGame().get(sender.getName()).setSeen(true);
					sender.sendMessage("§c/focusinventory close to modify your stuff menu IG");
				}
				((Player) sender).openInventory(pl.getFg().getPlayersInGame().get(name).getStuffInventory());
			} else	{
				sender.sendMessage("§f" + name + "§c is not in game");
			}
		}	
	}

	public static void focusreset(CommandSender sender, Focus pl) {
		
		pl.focusGameReload();
		String byWho = "§cby console";
		
		if (sender instanceof Player)	{
			byWho = "§cby staff";
		}
		
		for (Player player : Bukkit.getServer().getOnlinePlayers())	{
			player.teleport(new Location(player.getWorld(), 1350, 103, -250));
			player.setBedSpawnLocation(pl.getSpawn(), true);
			player.setGameMode(GameMode.ADVENTURE);
			player.getInventory().clear();
			player.getInventory().addItem(pl.getFg().getColor());
			player.sendTitle("§cThe game has been reset", byWho, 20, 60, 20);
			clearAttribute(player);
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
	
	public static void focusPoint(CommandSender sender, Focus pl, String pt) {
		
		if (isInteger(pt))	{
			int point = Integer.parseInt(pt);
			if (point <= 20 && point >= -20)	{
				for (String name : pl.getFg().getPlayersInGame().keySet())	{
					pl.getFg().getPlayersInGame().get(name).addPoint(point);
					pl.getFg().getPlayersInGame().get(name).actuStuff(pl.getFg().getPlayersInGame().get(name));
					pl.getFg().getPlayersInGame().get(name).getPlayerMC().sendMessage("§6 " + sender.getName() + " give you " + point + " points");
				}
				sender.sendMessage("§aGive point complete");
			} else	{
				sender.sendMessage("§cThe number you have send is out of limit ( -20 , 20 )");
			}
		} else	{
			sender.sendMessage("§cThe number you have send is invalid type");
		}
		
	}
	
	private static boolean isInteger(String str)	{
		try { 
	        Integer.parseInt(str);
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
		return true;
	}
	
	public static boolean focusChange(CommandSender sender, Focus pl, String[] args) {
		String gamemode = args[0].trim().toLowerCase();
		String victories = args[1].trim().toLowerCase();
		String hp = args[2].trim().toLowerCase();
		FocusGame fg = pl.getFg();
		
		if (!fg.isInConfig())	{
			if (gamemode.equals("deathmatch"))	{
				fg.setGamemode("Deathmatch");
				if (victories.equals("kills"))	{
					fg.setVictories("Kills");
					fg.setLimitVictories(10);
					fg.setStartingPoint(20);
					sender.sendMessage("§aConfiguration loaded");
					return defineHp(fg, hp);
				} else if (victories.equals("rounds"))	{
					fg.setVictories("Rounds");
					fg.setLimitVictories(5);
					fg.setStartingPoint(20);
					sender.sendMessage("§aConfiguration loaded");
					return defineHp(fg, hp);
				}
			} else if (gamemode.equals("roundup"))	{
				fg.setGamemode("Roundup");
				if (victories.equals("victories"))	{
					fg.setVictories("Victories");
					fg.setLimitVictories(3);
					fg.setStartingPoint(20);
					sender.sendMessage("§aConfiguration loaded");
					return defineHp(fg, hp);
				}
			}
			return false;
		} else {
			sender.sendMessage("§cConfiguration already in progress");
			return true;
		}
	}
	
	private static boolean defineHp(FocusGame fg, String str)	{
		if (str.equals("true"))	{
			fg.setDisplayHP(true);
			return true;
		} else if (str.equals("false"))	{
			fg.setDisplayHP(false);
			return true;
		}
		return false;
	}

	public static void focusReady(CommandSender sender, Focus pl, String name) {
		if (sender instanceof Player)	{
			if (pl.getFg().getPlayersInGame().get(name) != null)	{
				PlayerIG player = pl.getFg().getPlayersInGame().get(name);
				player.setReady(true);
				pl.getFg().addAllReady();
				ItemStack item = player.getStuffInventory().getItem(34);
				item.setType(Material.BEACON);
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
				} else	{ClickStuff.tellsWaitingPlayer(pl.getFg());}
			} else	{
				sender.sendMessage("§f" + name + "§c is not in game");
			}
			
		}		
	}

	public static void help(CommandSender sender, Focus pl) {
		
		sender.sendMessage("§9--------------- §6§lFocus help §9---------------");
		
		if (sender.hasPermission("focus.info"))	{
			sender.sendMessage("§6/focusinfo§a: Show the info of current game");
		}
		if (sender.hasPermission("focus.addpoint"))	{
			sender.sendMessage("§6/focuspoint nb_point§a: Give nb_point for all players in game");
		}
		if (sender.hasPermission("focus.start"))	{
			sender.sendMessage("§6/focusstart§a: Start a game with the current settings (see /focusinfo)");
		}
		if (sender.hasPermission("focus.changegame"))	{
			sender.sendMessage("§6/focuschange§a: Modify the setting of the game");
			sender.sendMessage("§6parameters§a: <deathmatch/roundup> <kills/rounds/victories> <true/false>");
		}
		if (sender.hasPermission("focus.seeinventory"))	{
			sender.sendMessage("§6/focusinventory player§a: Show the stuff menu of a player");
		}
		if (sender.hasPermission("focus.configuration"))	{
			sender.sendMessage("§6/focus§a: Open the configuration menu");
		}
		if (sender.hasPermission("focus.reload"))	{
			sender.sendMessage("§6/focusreload§a: Reload plugin");
		}
		if (sender.hasPermission("focus.reset"))	{
			sender.sendMessage("§6/focusreset§a: Reset the game and teleport everyone to lobby");
		}
		if (sender.hasPermission("focus.setready"))	{
			sender.sendMessage("§6/focusready§a: Setready a player");
		}
		sender.sendMessage("§9-----------------------------------------");
	}
}
