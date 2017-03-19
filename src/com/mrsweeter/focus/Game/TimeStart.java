package com.mrsweeter.focus.Game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Focus;
import com.mrsweeter.focus.FocusGame;

public class TimeStart extends BukkitRunnable	{
	
	private int time = 0;
	private FocusGame fg;

	public TimeStart(int timer, Focus main) {
		time = timer;
		fg = main.getFg();
	}

	@Override
	public void run() {
		for (Player p : Bukkit.getOnlinePlayers())	{
			if (fg.getPlayersInGame().keySet().contains(p.getName()))	{
				p.sendTitle("§6The game start", "§6in §c" + time + " secondes", 0, 25, 1);
			}
		}
		time--;
		if (time < 0)	{this.cancel();}
	}
}
