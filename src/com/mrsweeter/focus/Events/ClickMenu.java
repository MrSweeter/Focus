package com.mrsweeter.focus.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.GameState;

public class ClickMenu implements Listener {

	private Focus pl;
	
	public ClickMenu(Focus main) {
		this.pl = main;
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {

		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getName().equals("§1§lChoose your color") && event.getCurrentItem() != null) {
			if (event.getCurrentItem().getType() != Material.AIR) {
				if (event.getCurrentItem().getType() != Material.INK_SACK && event.getCurrentItem().getType() != Material.TOTEM && event.getCurrentItem().getType() != Material.COMPASS && pl.getFg().isGameState(GameState.LOBBY))	{
					ClickColor.color(player, event, pl.getFg());
				} else	{
					event.setCancelled(true);
				}
			}
		} else if (event.getInventory().getName().equals("§1§lChoose your stuff") && event.getCurrentItem() != null) {
			if (!(event.getCurrentItem().getType() == Material.AIR)) {
				if (event.getCurrentItem().getType() != Material.INK_SACK && event.getCurrentItem().getType() != Material.TOTEM && event.getCurrentItem().getType() != Material.COMPASS)	{
					ClickStuff.stuff(event, pl);
				} else {
					event.setCancelled(true);
				}
			}
		} else if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR)	{
			switch (event.getInventory().getName())	{
			case "§9§lConfiguration":
				ClickSettings.settingGame(event, pl);
				break;
			case "§9§lGamemode configuration":
				ClickSettings.settingGamemode(event, pl);
				break;
			case "§9§lOptions configuration":
				ClickSettings.settingOptions(event, pl);
				break;
			case "§9§lMaps configuration":
				ClickSettings.settingMaps(event, pl);
				break;
			case "§9§lPoints configuration":
				ClickSettings.settingPoints(event, pl);
				break;
			case "§9§lStuff configuration":
				ClickSettings.settingStuffs(event, pl);
				break;
			}
		}
		if (event.getAction() == InventoryAction.HOTBAR_SWAP)	{
			event.setCancelled(true);
		}
	}
}
