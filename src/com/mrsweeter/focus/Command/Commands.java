package com.mrsweeter.focus.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.PluginManager;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.GameState;

public class Commands implements CommandExecutor, TabCompleter {
	
	private PluginManager pm;
	private Focus pl;
	
	public Commands(PluginManager PluginM, Focus main)	{
		this.pm = PluginM;
		this.pl = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		if (args.length == 0)	{
			switch (commandLabel)	{
			case "focusreload":
				if (sender.hasPermission("focus.reload"))	{
					CommandExecute.reload(pm, pl);
				} else {
					sender.sendMessage("§cYou aren't allowed to do this");
				}
				return true;
			case "focushelp":
				if (sender.hasPermission("focus.help"))	{
					CommandExecute.help(sender, pl);
				} else {
					sender.sendMessage("§cYou aren't allowed to do this");
				}
				return true;
			case "focus":
				if (sender.hasPermission("focus.configuration"))	{
					CommandExecute.focusSetting(sender, pl);
				} else {
					sender.sendMessage("§cYou aren't allowed to do this");
				}
				return true;
			case "focusinfo":
				pl.getFg().tellSettings(sender);
				return true;
			case "focusreset":
				CommandExecute.focusreset(sender, pl);
				return true;
			case "focusstart":
				if (sender.hasPermission("focus.start"))	{
					if (pl.getFg().isGameState(GameState.LOBBY))	{
						if (!pl.getFg().isInConfig())	{
							if (pl.getFg().getPlayersInGame().size() >= 2)	{
								pl.getFg().setInConfig(false);
								sender.sendMessage("§aConfiguration save");
								pl.getFg().tellSettings(sender);
								sender.sendMessage("§cVerify your configuration above");
								pl.getFg().launchGame();
							} else	{
								sender.sendMessage("§cNot enough player");
							}
						} else	{
							sender.sendMessage("§cConfiguration in progress, wait");
						}
					} else	{
						sender.sendMessage("§cGame already launch");
					}
				} else {
					sender.sendMessage("§cYou aren't allowed to do this");
				}
				return true;
			}
		}
		if (args.length == 1 )	{
			switch (commandLabel)	{
			case "focusinventory":
				if (sender.hasPermission("focus.seeinventory"))	{
					CommandExecute.focusInventory(sender, pl, args[0]);
				} else {
					sender.sendMessage("§cYou aren't allowed to do this");
				}
				return true;
			case "focuspoint":
				if (sender.hasPermission("focus.addpoint") && pl.getFg().isGameState(GameState.WAITING))	{
					CommandExecute.focusPoint(sender, pl, args[0]);
				} else {
					sender.sendMessage("§cYou aren't allowed to do this");
				}
				return true;
			case "focusready":
				if (sender.hasPermission("focus.setready") && pl.getFg().isGameState(GameState.WAITING))	{
					CommandExecute.focusReady(sender, pl, args[0]);
				} else {
					sender.sendMessage("§cYou aren't allowed to do this");
				}
				return true;
			}
		}
		if (args.length == 3)	{
			if (sender.hasPermission("focus.changegame" ) && pl.getFg().isGameState(GameState.LOBBY))	{
				return CommandExecute.focusChange(sender, pl, args);
			} else {
				sender.sendMessage("§cYou aren't allowed to do this");
			}
			return true;
		}
		return false;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		if (commandLabel.equals("focuschange"))	{
			List<String> arg1 = Arrays.asList("deathmatch", "roundup");
			List<String> arg2 = Arrays.asList("kills", "rounds");
			String arg2Bis = "victories";
			List<String> arg3 = Arrays.asList("true", "false");
			List <String> fList = new ArrayList<String>();
			
			if (args.length == 1)	{
				for (String str : arg1)	{
					if (str.startsWith(args[0]))	{
						fList.add(str);
						return	fList;
					}
				}
			}
			if (args.length == 2)	{
				if (args[0].trim().toLowerCase().equals("deathmatch"))	{
					for (String str : arg2)	{
						if (str.startsWith(args[1]))	{
							fList.add(str);
							return	fList;
						}
					}
				} else if (args[0].trim().toLowerCase().equals("roundup"))	{
					if (arg2Bis.startsWith(args[1]))	{
						fList.add(arg2Bis);
						return fList;
					}
				}
			}
			if (args.length == 3)	{
				for (String str : arg3)	{
					if (str.startsWith(args[2]))	{
						fList.add(str);
						return	fList;
					}
				}
			}
		}
		return null;
	}
}
