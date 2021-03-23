package de.deda.lobby.program.itemInventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.deda.lobby.program.Items;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.mysql.MySQLSettings;

public class Settings {

	static ConfigManager config = new ConfigManager();
	static Items items = new Items();
	public static Inventory settingsInv = Bukkit.createInventory(null, 9, config.getSimpleString("Settings.title", Variable.settingsConfig));
	public static Inventory movementInv = Bukkit.createInventory(null, InventoryType.HOPPER, config.getSimpleString("Settings.title", Variable.settingsConfig));
	public static Inventory spawnPositionInv = Bukkit.createInventory(null, InventoryType.HOPPER, config.getSimpleString("Settings.title", Variable.settingsConfig));
	
	public static void openSettingsInv(Player player) {
		//Not configurable
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		
		for(int i=0; i<settingsInv.getSize(); i++)
			settingsInv.setItem(i, item);
		
		settingsInv.setItem(1, getSettingsItem("movement", player));
		settingsInv.setItem(4, getSettingsItem("spawnPosition", player));
		settingsInv.setItem(7, getSettingsItem("friends", player));
		
		if(config.getBoolean("Settings.sound", Variable.settingsConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(settingsInv);
	}
	
	public static void openMovementInv(Player player) {
		//Not configurable
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		
		for(int i=0; i<movementInv.getSize(); i++)
			movementInv.setItem(i, item);
		
		movementInv.setItem(1, getMovementItem("walk", player));
		movementInv.setItem(3, getMovementItem("doublejump", player));
		
		if(config.getBoolean("Settings.sound", Variable.settingsConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(movementInv);
	}
	
	public static void openSpawnPositionInv(Player player) {
		//Not configurable
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		
		for(int i=0; i<spawnPositionInv.getSize(); i++)
			spawnPositionInv.setItem(i, item);
		
		spawnPositionInv.setItem(1, getSpawnPositionItem("spawnPosition", player));
		spawnPositionInv.setItem(3, getSpawnPositionItem("lastPosition", player));
		
		if(config.getBoolean("Settings.sound", Variable.settingsConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(spawnPositionInv);
	}
	
	public static ItemStack getSettingsItem(String type, Player player) {
		switch(type) {
		case "movement":
			return items.getConfigItem("Settings.movement");
			
		case "spawnPosition":
			return items.getConfigItem("Settings.spawnPosition");
			
		case "friends":
			String friendsMaterial = config.getSimpleString("Settings.friends.material", Variable.settingsConfig);
			if("%PLAYERHEAD%".equalsIgnoreCase(friendsMaterial))
				friendsMaterial = "SKULL_ITEM";
			int friendsSubID = config.getInt("Settings.friends.subID", Variable.settingsConfig);
			String friendsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Settings.friends.name", Variable.settingsConfig));
			String friendsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Settings.friends.lore", Variable.settingsConfig));
			String[] friendsLoreArray = friendsLore.split("/n");
			List<String> friendsLoreList = new ArrayList<String>();
			for(int i=0; i<friendsLoreArray.length; i++)
				friendsLoreList.add(friendsLoreArray[i]);
			
			ItemStack friendsItem = new ItemStack(Material.getMaterial(friendsMaterial), 1, (short) friendsSubID);
			if("SKULL_ITEM".equalsIgnoreCase(friendsMaterial)) {
				SkullMeta skullMeta = (SkullMeta) friendsItem.getItemMeta();
				skullMeta.setOwner(player.getName());
				skullMeta.setDisplayName(friendsDisplayName);
				skullMeta.setLore(friendsLoreList);
				friendsItem.setItemMeta(skullMeta);
				return friendsItem;
			}
			ItemMeta friendsMeta = friendsItem.getItemMeta();
			friendsMeta.setDisplayName(friendsDisplayName);
			friendsMeta.setLore(friendsLoreList);
			friendsItem.setItemMeta(friendsMeta);
			return friendsItem;
		}
		return new ItemStack(Material.AIR);
	}
	
	public static ItemStack getMovementItem(String type, Player player) {
		switch(type) {
		case "walk":
			String walkMaterial = config.getSimpleString("Settings.movement.walk.material", Variable.settingsConfig);
			int walkSubID = config.getInt("Settings.movement.walk.subID", Variable.settingsConfig);
			String walkDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Settings.movement.walk.name", Variable.settingsConfig));
			String walkLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Settings.movement.walk.lore", Variable.settingsConfig));
			String[] walkLoreArray = walkLore.split("/n");
			List<String> walkLoreList = new ArrayList<String>();
			for(int i=0; i<walkLoreArray.length; i++)
				walkLoreList.add(walkLoreArray[i]);
			
			ItemStack walkItem = new ItemStack(Material.getMaterial(walkMaterial), 1, (short) walkSubID);
			if("LEATHER_BOOTS".equalsIgnoreCase(walkMaterial))
				if(config.getBoolean("Settings.movement.walk.color", Variable.settingsConfig)) {
					LeatherArmorMeta leatherMeta = (LeatherArmorMeta) walkItem.getItemMeta();
					if(MySQLSettings.getMovement(player.getUniqueId()) == 0) {
						leatherMeta.addEnchant(Enchantment.DURABILITY, 1, false);
						leatherMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					}
					leatherMeta.setColor(Color.WHITE);
					leatherMeta.setDisplayName(walkDisplayName);
					leatherMeta.setLore(walkLoreList);
					walkItem.setItemMeta(leatherMeta);
					return walkItem;
			}
			ItemMeta walkMeta = walkItem.getItemMeta();
			if(MySQLSettings.getMovement(player.getUniqueId()) == 0) {
				walkMeta.addEnchant(Enchantment.DURABILITY, 1, false);
				walkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}
			walkMeta.setDisplayName(walkDisplayName);
			walkMeta.setLore(walkLoreList);
			walkItem.setItemMeta(walkMeta);
			return walkItem;
			
		case "doublejump":
			if(MySQLSettings.getMovement(player.getUniqueId()) == 1) {
				ItemStack item = items.getConfigItem("Settings.movement.doublejump");
				ItemMeta meta = items.getConfigItem("Settings.movement.doublejump").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("Settings.movement.doublejump").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("Settings.movement.doublejump");
		}
		return new ItemStack(Material.AIR);
	}
	
	public static ItemStack getSpawnPositionItem(String type, Player player) {
		switch(type) {
		case "lastPosition":
			if(MySQLSettings.getSpawnPosition(player.getUniqueId()) == 1) {
				ItemStack item = items.getConfigItem("Settings.spawnPosition.lastPosition");
				ItemMeta meta = items.getConfigItem("Settings.spawnPosition.lastPosition").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("Settings.spawnPosition.lastPosition").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("Settings.spawnPosition.lastPosition");
			
		case "spawnPosition":
			if(MySQLSettings.getSpawnPosition(player.getUniqueId()) == 0) {
				ItemStack item = items.getConfigItem("Settings.spawnPosition.atSpawn");
				ItemMeta meta = items.getConfigItem("Settings.spawnPosition.atSpawn").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("Settings.spawnPosition.atSpawn").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("Settings.spawnPosition.atSpawn");
		}
		return new ItemStack(Material.AIR);
	}
}
