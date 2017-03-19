package com.mrsweeter.focus.PlayerIG;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Teams {
	
	public static Scoreboard scoreboard;
	public static Objective kill;
	public static Scoreboard scoreLife;
	public static Objective life;
	public static Team darkRed, red, gold, yellow, darkGreen, green, aqua, darkAqua, darkBlue, blue, lightPurple, darkPurple, white, gray, darkGray, black;
	
	public static void createTeam()	{
		
		scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
		scoreLife = Bukkit.getScoreboardManager().getMainScoreboard();
		if (scoreboard.getObjective("kill") == null)	{
			kill = scoreboard.registerNewObjective("kill", "dummy");
		} else	{
			scoreboard.getObjective("kill").unregister();
			kill = scoreboard.registerNewObjective("kill", "dummy");
		}
		if (scoreLife.getObjective("life") == null)	{
			life = scoreLife.registerNewObjective("life", "health");
		} else	{
			scoreLife.getObjective("life").unregister();
			life = scoreLife.registerNewObjective("life", "health");
		}
		kill.setDisplayName("§6--- Focus ---");
		life.setDisplayName("§4♥");
		kill.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		if (scoreboard.getTeams() != null)	{
			for (Team t : scoreboard.getTeams())	{
				t.unregister();
			}
		}
		
		darkRed = scoreboard.registerNewTeam("darkred");
		darkRed.setPrefix("§4");
		red = scoreboard.registerNewTeam("red");
		red.setPrefix("§c");
		gold = scoreboard.registerNewTeam("gold");
		gold.setPrefix("§6");
		yellow = scoreboard.registerNewTeam("yellow");
		yellow.setPrefix("§e");
		darkGreen = scoreboard.registerNewTeam("darkGreen");
		darkGreen.setPrefix("§2");
		green = scoreboard.registerNewTeam("green");
		green.setPrefix("§a");
		aqua = scoreboard.registerNewTeam("aqua");
		aqua.setPrefix("§b");
		darkAqua = scoreboard.registerNewTeam("darkAqua");
		darkAqua.setPrefix("§3");
		darkBlue = scoreboard.registerNewTeam("darkBlue");
		darkBlue.setPrefix("§1");
		blue = scoreboard.registerNewTeam("blue");
		blue.setPrefix("§9");
		lightPurple = scoreboard.registerNewTeam("lightPurple");
		lightPurple.setPrefix("§d");
		darkPurple = scoreboard.registerNewTeam("darkPurple");
		darkPurple.setPrefix("§5");
		white = scoreboard.registerNewTeam("white");
		white.setPrefix("§f");
		gray = scoreboard.registerNewTeam("gray");
		gray.setPrefix("§7");
		darkGray = scoreboard.registerNewTeam("darkGray");
		darkGray.setPrefix("§8");
		black = scoreboard.registerNewTeam("black");
		black.setPrefix("§0");
	}
}
