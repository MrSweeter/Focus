package com.mrsweeter.focus;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.mrsweeter.focus.Command.Commands;
import com.mrsweeter.focus.ConfigLoader.Spawn;
import com.mrsweeter.focus.Events.ArrowEvent;
import com.mrsweeter.focus.Events.ClickMenu;
import com.mrsweeter.focus.Events.Death;
import com.mrsweeter.focus.Events.EntityInteraction;
import com.mrsweeter.focus.Events.JoinQuit;
import com.mrsweeter.focus.Events.OpenMenu;
import com.mrsweeter.focus.Menus.Settings;
import com.mrsweeter.focus.Menus.StuffMenu;
import com.mrsweeter.focus.PlayerIG.Stuff;
import com.mrsweeter.focus.PlayerIG.Teams;

public class Focus extends JavaPlugin{
	
	Logger log = Logger.getLogger("Minecraft");
	private static PluginManager pm = Bukkit.getPluginManager();
	private static FocusGame fg;
	private Spawn spawnServer;
	
	public void onEnable()	{
		
		saveDefaultConfig();
		
		Settings.createDefaultSettings();
		fg = new FocusGame(this);
		
		spawnServer = new Spawn(this);
		Teams.createTeam();
		StuffMenu.createStuff(fg);
		Stuff.createStuff();
		this.getServer().getWorld("world").setGameRuleValue("keepInventory", "true");
		this.getServer().getWorld("world").setGameRuleValue("mobGriefing", "false");
		this.getServer().getWorld("world").setGameRuleValue("naturalRegeneration", "false");
		this.getServer().getWorld("world").setDifficulty(Difficulty.NORMAL);
		
		pm.registerEvents(new JoinQuit(this, spawnServer), this);
		pm.registerEvents(new OpenMenu(this), this);
		pm.registerEvents(new ClickMenu(this), this);
		pm.registerEvents(new Death(this), this);
		pm.registerEvents(new EntityInteraction(this), this);
		pm.registerEvents(new ArrowEvent(), this);
		
		getCommand("focusreload").setExecutor(new Commands(pm, this));
		getCommand("focus").setExecutor(new Commands(pm, this));
		getCommand("focusinfo").setExecutor(new Commands(pm, this));
		getCommand("focusreset").setExecutor(new Commands(pm, this));
		getCommand("focusinventory").setExecutor(new Commands(pm, this));
		getCommand("focuspoint").setExecutor(new Commands(pm, this));
		getCommand("focuschange").setExecutor(new Commands(pm, this));
		getCommand("focusstart").setExecutor(new Commands(pm, this));
		getCommand("focusready").setExecutor(new Commands(pm, this));
		getCommand("focushelp").setExecutor(new Commands(pm, this));
		
		log.info(Color.GREEN + "=============== " + Color.YELLOW + "Focus enable" + Color.GREEN + " ===============" + Color.RESET);
		
	}
	
	public void onDisable()	{
		
		log.info(Color.GREEN + "=============== " + Color.YELLOW + "Focus disable" + Color.GREEN + " ===============" + Color.RESET);
		
	}
	
	public void focusGameReload() {
		
		for (OfflinePlayer p : Bukkit.getOfflinePlayers())	{
			Teams.scoreboard.resetScores(p.getName());
		}
		
		fg.setAlreadyLoad(false);
		fg.setGameState(GameState.LOBBY);
		for (String name : fg.getPlayersInGame().keySet())	{
			fg.getPlayersInGame().get(name).setPoint(0);
		}
		fg.setAllReady(0);
		fg.getPlayersInGame().clear();
		fg.getColorInGame().clear();
		reloadMap();
		fg.setNbreRound(0);
		Bukkit.broadcastMessage("§aReset complete");
	}
	
	private void reloadMap()	{
		fg.setMapIGNotUsed(new ArrayList<String>());
		for (String mapName : fg.getMapsInGame())	{
			fg.addMapUsed(mapName);
		}
	}
	
	public static PluginManager getPm() {
		return pm;
	}

	public FocusGame getFg() {
		return fg;
	}

	public void setFg(FocusGame focusg) {
		fg = focusg;
	}
	public Location getSpawn()	{
		return spawnServer.getSpawn();
	}
	public List<Location> getBlockSpawn()	{
		return spawnServer.getBlocks();
	}
	public List<Location> getBeaconSpawn()	{
		return spawnServer.getBeacon();
	}
}
