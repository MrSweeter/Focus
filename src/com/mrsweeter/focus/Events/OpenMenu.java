package com.mrsweeter.focus.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.GameState;
import com.mrsweeter.focus.Menus.LoadMenuSetting;

public class OpenMenu implements Listener {
	
	private FocusGame fg;
	
	public OpenMenu(Focus main)	{
		fg = main.getFg();
	}
	
	@EventHandler
	public void openMenu(PlayerInteractEvent event)	{
		
		Player player = event.getPlayer();
		
		if (player.getInventory().getItemInMainHand().equals(fg.getColor()))	{
			if (!fg.isGameState(GameState.INGAME))	{
				player.openInventory(fg.getColorMenu());
			} else {
				player.sendMessage("Selection of color is not allowed during a game");
			}
			event.setCancelled(true);
		} else if (event.getPlayer().getInventory().getItemInMainHand().equals(fg.getStuff()))	{
			if (fg.getPlayersInGame().containsKey(player.getName()) && (fg.isGameState(GameState.INGAME) || fg.isGameState(GameState.WAITING)))	{
				event.getPlayer().openInventory(fg.getPlayersInGame().get(player.getName()).getStuffInventory());
			} else	{
				player.sendMessage("Configuration is allow only during a game");
			}
			event.setCancelled(true);
		} else if (player.getInventory().getItemInMainHand().equals(fg.getSetting()))	{
			if (!fg.isGameState(GameState.INGAME))	{
				LoadMenuSetting.loadGamemode(fg);
				player.openInventory(fg.getInventorySetting());
			} else {
				player.sendMessage("Configuration is not allow during a game");
			}
			event.setCancelled(true);
		}
	}
}
