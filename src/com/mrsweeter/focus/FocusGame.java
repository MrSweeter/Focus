package com.mrsweeter.focus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.focus.Game.Game;
import com.mrsweeter.focus.Game.TimeStart;
import com.mrsweeter.focus.Menus.ChooseColor;
import com.mrsweeter.focus.Menus.Settings;
import com.mrsweeter.focus.PlayerIG.PlayerIG;

public class FocusGame {
	
	private HashMap<String, PlayerIG> playersInGame;
	private List<String> colorInGame = new ArrayList<String>();
	private List<String> mapsInGame = new ArrayList<String>();
	private List<String> mapIGNotUsed = new ArrayList<String>();
	private List<String> stuffInGame = new ArrayList<String>();
	private GameState current;
	
	private Inventory configuration;
	private Inventory gamemodeOptions;
	private Inventory pointsOptions;
	private Inventory stuffOptions;
	private Inventory mapOptions;
	private Inventory options;
	
	private Inventory colorMenu;
	private ItemStack colorSelect = new ItemStack(Material.INK_SACK, 1, (short) 6);
	private ItemMeta color = colorSelect.getItemMeta();
	private ItemStack stuffSelect = new ItemStack(Material.TOTEM, 1, (short) 0);
	private ItemMeta stuff = stuffSelect.getItemMeta();
	private ItemStack settingSelect = new ItemStack(Material.COMPASS, 1, (short) 0);
	private ItemMeta setting = stuffSelect.getItemMeta();
	
	private String gamemode;
	private String victories;
	private String maps;
	private int limitVictories;
	private int startingPoint;
	private int killPoint;
	private int roundPoint;
	private boolean displayHP;
	private int playerKilled;
	private boolean alreadyLoad;
	
	private BukkitRunnable game;
	private BukkitRunnable round;
	private BukkitRunnable creeper;
	private int nbreRound;
	private int allReady;
	private boolean inConfig;
	private Focus pl;
	
	public FocusGame(Focus main)	{
		
		pl = main;
		colorMenu = Bukkit.getServer().createInventory(null, InventoryType.CHEST,"§1§lChoose your color");
		colorMenu = ChooseColor.fillColor(colorMenu);
		configuration = Bukkit.getServer().createInventory(null, 54,"§9§lConfiguration");
		gamemodeOptions = Bukkit.getServer().createInventory(null, 54,"§9§lGamemode configuration");
		pointsOptions = Bukkit.getServer().createInventory(null, 54,"§9§lPoints configuration");
		stuffOptions = Bukkit.getServer().createInventory(null, 54,"§9§lStuff configuration");
		mapOptions = Bukkit.getServer().createInventory(null, 54,"§9§lMaps configuration");
		options = Bukkit.getServer().createInventory(null, 54,"§9§lOptions configuration");
		
		playersInGame = new HashMap<String, PlayerIG>();
		fillStuff();
		fillMap();
		colorInGame = new ArrayList<String>();
		current = GameState.LOBBY;
		setStartingPoint(2000);
		configuration = Settings.fillSettings(configuration);
		
		gamemode = "Deathmatch";
		victories = "Kills";
		setMaps("random");
		limitVictories = 10;
		startingPoint = 7;
		killPoint = 2;
		roundPoint = 5;
		displayHP = false;
		nbreRound = 0;
		setAlreadyLoad(false);
		
		setKilled(0);
		inConfig = false;
		
		color.setDisplayName("§6§lChoose your color");
		colorSelect.setItemMeta(color);
		stuff.setDisplayName("§6§lChoose your stuff");
		stuffSelect.setItemMeta(stuff);
		setting.setDisplayName("§9§lConfiguration");
		settingSelect.setItemMeta(setting);
		
	}
	
	public void launchGame() {
		game = new Game(pl);
		
		for (Player p : Bukkit.getOnlinePlayers())	{
			p.sendMessage("§6Check info of game with §a/focusinfo");
		}
		int timeBeforeStart = 15;
		BukkitRunnable timer = new TimeStart(timeBeforeStart, pl);
		timer.runTaskTimer(pl, 0, 20);
		
		game = new Game(pl);
		game.runTaskLater(pl, timeBeforeStart*20);
	}
	
	public void tellSettings(CommandSender p) {
		
		String maps = "";
		for (String map : mapsInGame)	{
			maps += map;
			maps += ", ";
		}
		String players = "";
		for (String player : playersInGame.keySet())	{
			players += player;
			players += ", ";
		}
		String stuffs = "";
		for (String stuff : stuffInGame)	{
			stuffs += stuff;
			stuffs += ", ";
		}
		
		p.sendMessage("§9--------------- §6§lFocusGame settings §9---------------");
		p.sendMessage("§6Gamemode: §a" + gamemode + "§6 - §a" + victories);
		p.sendMessage("§6Limit victories: §a" + limitVictories + " (rounds/kills/victories)");
		p.sendMessage("§6Maps: §a" + maps);
		p.sendMessage("§6Players: §a" + players);
		p.sendMessage("§6Stuff: §a" + stuffs);
		p.sendMessage("§6Display HP: §a" + displayHP);
		p.sendMessage("§6Points at the beginning: §a" + startingPoint);
		p.sendMessage("§6Points per round win: §a" + roundPoint);
		p.sendMessage("§6Points per kill: §a" + killPoint + "\n");		
		p.sendMessage("§6GameState: " + current);
		
	}
	
	public void fillStuff()	{
		stuffInGame.add("helmet");
		stuffInGame.add("chestplate");
		stuffInGame.add("leggings");
		stuffInGame.add("boots");
		stuffInGame.add("sword");
		stuffInGame.add("axe");
		stuffInGame.add("shield");
		stuffInGame.add("enderpearl");
		stuffInGame.add("bow");
		stuffInGame.add("smoke");
	}
	public void fillMap()	{
		mapsInGame.add("tree");
		mapsInGame.add("ruins");
		mapsInGame.add("islet");
		mapsInGame.add("tunnels");
		mapsInGame.add("temple");
		mapsInGame.add("rupture");
		mapsInGame.add("ice");
		mapsInGame.add("vulcano");
		
		mapIGNotUsed.add("tree");
		mapIGNotUsed.add("ruins");
		mapIGNotUsed.add("islet");
		mapIGNotUsed.add("tunnels");
		mapIGNotUsed.add("temple");
		mapIGNotUsed.add("rupture");
		mapIGNotUsed.add("ice");
		mapIGNotUsed.add("vulcano");
	}
	
	public void addPlayersInGame(PlayerIG player)	{
		if (player != null)	{
			this.playersInGame.put(player.getName(), player);
		}
	}
	public void removePlayersInGame(String player)	{
		if (playersInGame.containsKey(player))	{
			this.playersInGame.remove(player);
		}
	}
	
	public void addColorInGame(String color)	{
		this.colorInGame.add(color);
	}
	
	public List<String> getColorInGame()	{
		return colorInGame;
	}
	public GameState getGameState()	{
		return current;
	}
	
	public HashMap<String, PlayerIG> getPlayersInGame()	{
		return playersInGame;
	}
	
	public boolean isGameState(GameState a)	{
		if (a == current)	{
			return true;
		}
		return false;
	}
	public void setGameState(GameState gs)	{
		current = gs;
	}

	public int getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
	}

	public List<String> getMapsInGame() {
		return mapsInGame;
	}

	public void addMapsInGame(String map) {
		if (!mapsInGame.contains(map))	{
			this.mapsInGame.add(map);
		}
		if (!mapIGNotUsed.contains(map))	{
			this.mapIGNotUsed.add(map);
		}
	}
	public void removeMapsInGame(String map) {
		if (mapsInGame.contains(map))	{
			this.mapsInGame.remove(map);
		}
		if (mapIGNotUsed.contains(map))	{
			this.mapIGNotUsed.remove(map);
		}
	}

	public ItemStack getColor() {
		return colorSelect;
	}

	public ItemStack getStuff() {
		return stuffSelect;
	}

	public ItemStack getSetting() {
		return settingSelect;
	}
	public Inventory getInventorySetting()	{
		return configuration;
	}
	public Inventory getGamemodeSetting()	{
		return gamemodeOptions;
	}
	public Inventory getPointsSetting()	{
		return pointsOptions;
	}
	public Inventory getMapsSetting()	{
		return mapOptions;
	}
	public Inventory getOptionsSetting()	{
		return options;
	}
	public Inventory getStuffSetting()	{
		return stuffOptions;
	}

	public Inventory getColorMenu() {
		return colorMenu;
	}

	public void setColorMenu(Inventory colorMenu) {
		this.colorMenu = colorMenu;
	}

	public List<String> getStuffInGame() {
		return stuffInGame;
	}

	public void addStuffInGame(String name) {
		if (!stuffInGame.contains(name))	{
			this.stuffInGame.add(name);
		}
	}
	public void removeStuffInGame(String name) {
		if (stuffInGame.contains(name))	{
			this.stuffInGame.remove(name);
		}
	}

	public String getGamemode() {
		return gamemode;
	}

	public void setGamemode(String gamemode) {
		this.gamemode = gamemode;
	}

	public String getVictories() {
		return victories;
	}

	public void setVictories(String victories) {
		this.victories = victories;
	}

	public int getLimitVictories() {
		return limitVictories;
	}

	public void setLimitVictories(int limitVictories) {
		this.limitVictories = limitVictories;
	}

	public int getKillPoint() {
		return killPoint;
	}

	public void setKillPoint(int killPoint) {
		this.killPoint = killPoint;
	}

	public int getRoundPoint() {
		return roundPoint;
	}

	public void setRoundPoint(int roundPoint) {
		this.roundPoint = roundPoint;
	}

	public boolean getDisplayHP() {
		return displayHP;
	}

	public void setDisplayHP(boolean displayHP) {
		this.displayHP = displayHP;
	}

	public boolean isInConfig() {
		return inConfig;
	}

	public void setInConfig(boolean inConfig) {
		this.inConfig = inConfig;
	}

	public BukkitRunnable getGame() {
		return game;
	}

	public void setGame(BukkitRunnable game) {
		this.game = game;
	}

	public int getAllReady() {
		return allReady;
	}

	public void addAllReady() {
		this.allReady += 1;
	}
	public void removeAllReady() {
		this.allReady -= 1;
	}

	public BukkitRunnable getRound() {
		return round;
	}

	public void setRound(BukkitRunnable round) {
		this.round = round;
	}

	public void setAllReady(int val) {
		allReady = val;
	}

	public int getKilled() {
		return playerKilled;
	}

	public void setKilled(int playerKilled) {
		this.playerKilled = playerKilled;
	}

	public BukkitRunnable getCreeper() {
		return creeper;
	}

	public void setCreeper(BukkitRunnable creeper) {
		this.creeper = creeper;
	}

	public int getNbreRound() {
		return nbreRound;
	}
	public void setNbreRound(int val)	{
		nbreRound = val;
	}

	public String getMaps() {
		return maps;
	}

	public void setMaps(String maps) {
		this.maps = maps;
	}

	public boolean isAlreadyLoad() {
		return alreadyLoad;
	}

	public void setAlreadyLoad(boolean alreadyLoad) {
		this.alreadyLoad = alreadyLoad;
	}

	public List<String> getMapIGNotUsed() {
		return mapIGNotUsed;
	}

	public void setMapIGNotUsed(List<String> mapIGNotUsed) {
		this.mapIGNotUsed = mapIGNotUsed;
	}

	public void removeMapUsed(String str) {
		mapIGNotUsed.remove(str);
	}
	public void addMapUsed(String str) {
		mapIGNotUsed.add(str);
	}
}
