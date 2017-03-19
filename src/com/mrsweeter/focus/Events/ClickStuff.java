package com.mrsweeter.focus.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.Game.Game;
import com.mrsweeter.focus.Game.RoundGame;
import com.mrsweeter.focus.Menus.StuffMenu;
import com.mrsweeter.focus.PlayerIG.PlayerIG;
import com.mrsweeter.focus.PlayerIG.SwitchStuff;

public class ClickStuff {
	
	public static void stuff(InventoryClickEvent event, Focus pl)	{
		
		PlayerIG player;
		
		if (pl.getFg().getPlayersInGame().containsKey(event.getWhoClicked().getName()))	{
			player = pl.getFg().getPlayersInGame().get(event.getWhoClicked().getName());
		} else	{
			player = null;
		}
		
		if (player != null && !player.isSeen())	{
			String nameItem = event.getCurrentItem().getItemMeta().getDisplayName();
			int point = 0;
			if (event.getSlot() != 28 && event.getSlot() != 34 && !event.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lNo more"))	{
				point = Integer.parseInt(nameItem.substring(nameItem.indexOf("-")+1, nameItem.indexOf("points")-1).trim());
				if (!pl.getFg().getPlayersInGame().isEmpty())	{
					if (pl.getFg().getPlayersInGame().containsKey(player.getName()))	{
						if (player.getPoint() >= point)	{
							switch (event.getSlot())	{
							case 13:
								SwitchStuff.switchHelmet(player, point);
								break;
							case 22:
								SwitchStuff.switchChestPlate(player, point);
								break;
							case 31:
								SwitchStuff.switchLeggings(player, point);
								break;
							case 40:
								SwitchStuff.switchBoots(player, point);
								break;
							case 21:
								SwitchStuff.switchSword(player, point);
								break;
							case 30:
								SwitchStuff.switchAxe(player, point);
								break;
							case 39:
								SwitchStuff.switchShield(player, point);
								break;
							case 14:
								SwitchStuff.switchEnderpearl(player, point);
								break;
							case 23:
								SwitchStuff.switchBow(player, point);
								break;
							case 32:
								SwitchStuff.switchArrow(player, point);
								break;
							case 41:
								SwitchStuff.switchSmoke(player, point);
								break;
							}
						} else	{
							event.getWhoClicked().sendMessage("§cYou haven't got enough points");
						}
					} else	{
						event.getWhoClicked().sendMessage("§cYou are not in the game");
					}
				} else	{
					event.getWhoClicked().sendMessage("§cThere are not player in game");
				}
			} else if (event.getSlot() == 34)	{
				if (player.isReady())	{
					player.setReady(false);
					pl.getFg().removeAllReady();
					ItemStack item = event.getCurrentItem();
					item.setType(Material.BARRIER);
				} else {
					player.setReady(true);
					pl.getFg().addAllReady();
					ItemStack item = event.getCurrentItem();
					item.setType(Material.BEACON);
				}
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
				} else	{tellsWaitingPlayer(pl.getFg());}
			}
		}
		event.setCancelled(true);
	}
	
	public static void tellsWaitingPlayer(FocusGame fg)	{
		
		String waitPlayers = "§7Waiting ";
		
		for (String str : fg.getPlayersInGame().keySet())	{
			if (!fg.getPlayersInGame().get(str).isReady())	{
				waitPlayers += fg.getPlayersInGame().get(str).getName();
				waitPlayers += ", ";
			}
		}
		Bukkit.broadcastMessage(waitPlayers);
	}
}
