package com.mrsweeter.focus.PlayerIG;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mrsweeter.focus.FocusGame;
import com.mrsweeter.focus.Menus.StuffMenu;

public class PlayerIG {
	
	private String name;
	private java.util.UUID UUID;
	private String teamColor;
	private int point;
	private boolean ready;
	private boolean seen;
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	private ItemStack boots;
	private ItemStack sword;
	private ItemStack axe;
	private ItemStack bow;
	private ItemStack arrow;
	private ItemStack enderpearl;
	private ItemStack shield;
	private ItemStack smoke;
	private ItemStack pointItem;
	private Player playerMC;
	private Inventory stuffInventory = Bukkit.getServer().createInventory(null, 54,"§1§lChoose your stuff");
	private int victories;
	private int kill;
	
	public PlayerIG(Player player, FocusGame fg)	{
		
		name = player.getName();
		UUID = player.getUniqueId();
		setPlayerMC(player);
		teamColor = "noTeam";
		ready = false;
		setSeen(false);
		victories = 0;
		kill = 0;
		point = fg.getStartingPoint();
		helmet = new ItemStack(Material.STAINED_GLASS);
		chestplate = new ItemStack(Material.STAINED_GLASS);
		leggings = new ItemStack(Material.STAINED_GLASS);
		boots = new ItemStack(Material.STAINED_GLASS);
		sword = Stuff.stick;
		axe = new ItemStack(Material.STAINED_GLASS);
		bow = new ItemStack(Material.STAINED_GLASS);
		boots = new ItemStack(Material.STAINED_GLASS);
		arrow = new ItemStack(Material.STAINED_GLASS);
		enderpearl = new ItemStack(Material.STAINED_GLASS);
		shield = new ItemStack(Material.STAINED_GLASS);
		smoke = new ItemStack(Material.STAINED_GLASS);
		pointItem = new ItemStack(Material.GOLD_INGOT);
		fillStuff(fg);
	}
	
	public void fillStuff(FocusGame fg) {
		
		stuffInventory.clear();
		StuffMenu.pointItem_meta.setDisplayName("§a§lYou have " + fg.getStartingPoint() + " points to spend");
		StuffMenu.pointItem.setItemMeta(StuffMenu.pointItem_meta);
		stuffInventory.setItem(28, StuffMenu.pointItem);
		stuffInventory.setItem(34, StuffMenu.ready);
		if (fg.getStuffInGame().contains("helmet"))	{stuffInventory.setItem(13, StuffMenu.helmet_leather);}
		if (fg.getStuffInGame().contains("chestplate"))	{stuffInventory.setItem(22, StuffMenu.chestplate_leather);}
		if (fg.getStuffInGame().contains("leggings"))	{stuffInventory.setItem(31, StuffMenu.leggings_leather);}
		if (fg.getStuffInGame().contains("boots"))	{stuffInventory.setItem(40, StuffMenu.boots_leather);}
		if (fg.getStuffInGame().contains("sword"))	{stuffInventory.setItem(21, StuffMenu.sword_wooden);}
		if (fg.getStuffInGame().contains("axe"))	{stuffInventory.setItem(30, StuffMenu.axe_wooden);}
		if (fg.getStuffInGame().contains("shield"))	{stuffInventory.setItem(39, StuffMenu.shield_1);}
		if (fg.getStuffInGame().contains("enderpearl"))	{stuffInventory.setItem(14, StuffMenu.enderpearl_1);}
		if (fg.getStuffInGame().contains("bow"))	{stuffInventory.setItem(23, StuffMenu.bow_power1);}
		if (fg.getStuffInGame().contains("smoke"))	{stuffInventory.setItem(41, StuffMenu.smoke_1);}
	}
	public void actuStuff(PlayerIG p)	{
		StuffMenu.pointItem_meta.setDisplayName("§a§lYou have " + p.getPoint() + " points to spend");
		StuffMenu.pointItem.setItemMeta(StuffMenu.pointItem_meta);
		stuffInventory.setItem(28, StuffMenu.pointItem);
		stuffInventory.setItem(34, StuffMenu.ready);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.UUID getUUID() {
		return UUID;
	}

	public void setUUID(java.util.UUID uUID) {
		UUID = uUID;
	}

	public String getTeamColor() {
		return teamColor;
	}

	public void setTeamColor(String teamColor) {
		this.teamColor = teamColor;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public ItemStack getHelmet() {
		return helmet;
	}

	public void setHelmet(ItemStack helmet) {
		this.helmet = helmet;
	}

	public ItemStack getChestplate() {
		return chestplate;
	}

	public void setChestplate(ItemStack chestplate) {
		this.chestplate = chestplate;
	}

	public ItemStack getLeggings() {
		return leggings;
	}

	public void setLeggings(ItemStack leggings) {
		this.leggings = leggings;
	}

	public ItemStack getBoots() {
		return boots;
	}

	public void setBoots(ItemStack boots) {
		this.boots = boots;
	}

	public ItemStack getSword() {
		return sword;
	}

	public void setSword(ItemStack sword) {
		this.sword = sword;
	}

	public ItemStack getAxe() {
		return axe;
	}

	public void setAxe(ItemStack axe) {
		this.axe = axe;
	}

	public ItemStack getBow() {
		return bow;
	}

	public void setBow(ItemStack bow) {
		this.bow = bow;
	}

	public ItemStack getArrow() {
		return arrow;
	}

	public void setArrow(ItemStack arrow) {
		this.arrow = arrow;
	}

	public ItemStack getEnderpearl() {
		return enderpearl;
	}

	public void setEnderpearl(ItemStack enderpearl) {
		this.enderpearl = enderpearl;
	}

	public ItemStack getShield() {
		return shield;
	}

	public void setShield(ItemStack shield) {
		this.shield = shield;
	}

	public ItemStack getSmoke() {
		return smoke;
	}

	public void setSmoke(ItemStack smoke) {
		this.smoke = smoke;
	}

	public Player getPlayerMC() {
		return playerMC;
	}

	public void setPlayerMC(Player playerMC) {
		this.playerMC = playerMC;
	}

	public ItemStack getPointItem() {
		return pointItem;
	}

	public void setPointItemMeta(int pointItem) {
		
		ItemMeta point = this.pointItem.getItemMeta();
		point.setDisplayName("§a§lYou have " + this.point + " points to spend");
		point.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		point.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		this.pointItem.setItemMeta(point);
	}

	public Inventory getStuffInventory() {
		return stuffInventory;
	}

	public void setStuffInventory(Inventory stuffInventory) {
		this.stuffInventory = stuffInventory;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public int getVictories() {
		return victories;
	}

	public void addVictories(int val) {
		this.victories += val;
	}

	public int getKill() {
		return kill;
	}

	public void addKill(int val) {
		this.kill += val;
	}

	public void addPoint(int val) {
		this.point += val;
		
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

}
