package de.deda.lobby.program.itemInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.deda.lobby.program.Items;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.mysql.MySQLShopBoots;
import de.deda.lobby.utils.mysql.MySQLShopExtras;
import de.deda.lobby.utils.mysql.MySQLShopHats;
import de.deda.lobby.utils.mysql.MySQLShopHeads;

public class Gadgets {

	static ConfigManager config = new ConfigManager();
	static Items items = new Items();
	public static Inventory gadgetsHatInv = Bukkit.createInventory(null, 9*6, config.getSimpleString("Gadgets.title", Variable.gadgetsConfig)+" hats");
	public static Inventory gadgetsHeadsInv = Bukkit.createInventory(null, 9*6, config.getSimpleString("Gadgets.title", Variable.gadgetsConfig)+" heads");
	public static Inventory gadgetsBootsInv = Bukkit.createInventory(null, 9*6, config.getSimpleString("Gadgets.title", Variable.gadgetsConfig)+" boots");
	public static Inventory gadgetsExtrasInv = Bukkit.createInventory(null, 9*6, config.getSimpleString("Gadgets.title", Variable.gadgetsConfig)+" extras");
	public static Inventory buyItemInv = Bukkit.createInventory(null, 9, config.getSimpleString("Gadgets.title", Variable.gadgetsConfig)+" buy");
	public static Map<UUID, Integer> extrasCooldown = new HashMap<UUID, Integer>();
	
	public static void openGadgetsHatInv(Player player) {
		setItemsInv(gadgetsHatInv);
		
		//Not configurable
		ItemStack itemGreen = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		ItemMeta metaGreen = itemGreen.getItemMeta();
		metaGreen.setDisplayName(" ");
		itemGreen.setItemMeta(metaGreen);
		
		gadgetsHatInv.setItem(9, getGadgetsItem("hats", player));
		gadgetsHatInv.setItem(18, getGadgetsItem("heads", player));
		gadgetsHatInv.setItem(27, getGadgetsItem("boots", player));
		gadgetsHatInv.setItem(36, getGadgetsItem("extras", player));
		gadgetsHatInv.setItem(10, itemGreen);
		
		gadgetsHatInv.setItem(12, getGadgetsHats(1, player));
		gadgetsHatInv.setItem(13, getGadgetsHats(2, player));
		gadgetsHatInv.setItem(14, getGadgetsHats(3, player));
		gadgetsHatInv.setItem(15, getGadgetsHats(4, player));
		gadgetsHatInv.setItem(16, getGadgetsHats(5, player));
		
		gadgetsHatInv.setItem(30, getGadgetsHats(6, player));
		gadgetsHatInv.setItem(31, getGadgetsHats(7, player));
		gadgetsHatInv.setItem(32, getGadgetsHats(8, player));
		gadgetsHatInv.setItem(33, getGadgetsHats(9, player));
		gadgetsHatInv.setItem(34, getGadgetsHats(10, player));
		
		if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(gadgetsHatInv);
	}
	
	public static void openGadgetsHeadInv(Player player) {
		setItemsInv(gadgetsHeadsInv);
		
		//Not configurable
		ItemStack itemGreen = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		ItemMeta metaGreen = itemGreen.getItemMeta();
		metaGreen.setDisplayName(" ");
		itemGreen.setItemMeta(metaGreen);
		
		gadgetsHeadsInv.setItem(9, getGadgetsItem("hats", player));
		gadgetsHeadsInv.setItem(18, getGadgetsItem("heads", player));
		gadgetsHeadsInv.setItem(27, getGadgetsItem("boots", player));
		gadgetsHeadsInv.setItem(36, getGadgetsItem("extras", player));
		gadgetsHeadsInv.setItem(19, itemGreen);
		
		gadgetsHeadsInv.setItem(12, getGadgetsHeads(1, player));
		gadgetsHeadsInv.setItem(13, getGadgetsHeads(2, player));
		gadgetsHeadsInv.setItem(14, getGadgetsHeads(3, player));
		gadgetsHeadsInv.setItem(15, getGadgetsHeads(4, player));
		gadgetsHeadsInv.setItem(16, getGadgetsHeads(5, player));
		
		gadgetsHeadsInv.setItem(30, getGadgetsHeads(6, player));
		gadgetsHeadsInv.setItem(31, getGadgetsHeads(7, player));
		gadgetsHeadsInv.setItem(32, getGadgetsHeads(8, player));
		gadgetsHeadsInv.setItem(33, getGadgetsHeads(9, player));
		gadgetsHeadsInv.setItem(34, getGadgetsHeads(10, player));
		
		if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(gadgetsHeadsInv);
	}
	
	public static void openGadgetsBootInv(Player player) {
		setItemsInv(gadgetsBootsInv);
		
		//Not configurable
		ItemStack itemGreen = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		ItemMeta metaGreen = itemGreen.getItemMeta();
		metaGreen.setDisplayName(" ");
		itemGreen.setItemMeta(metaGreen);
		
		gadgetsBootsInv.setItem(9, getGadgetsItem("hats", player));
		gadgetsBootsInv.setItem(18, getGadgetsItem("heads", player));
		gadgetsBootsInv.setItem(27, getGadgetsItem("boots", player));
		gadgetsBootsInv.setItem(36, getGadgetsItem("extras", player));
		gadgetsBootsInv.setItem(28, itemGreen);
		
		gadgetsBootsInv.setItem(12, getGadgetsBoots(1, player));
		gadgetsBootsInv.setItem(13, getGadgetsBoots(2, player));
		gadgetsBootsInv.setItem(14, getGadgetsBoots(3, player));
		gadgetsBootsInv.setItem(15, getGadgetsBoots(4, player));
		gadgetsBootsInv.setItem(16, getGadgetsBoots(5, player));
		
		gadgetsBootsInv.setItem(30, getGadgetsBoots(6, player));
		gadgetsBootsInv.setItem(31, getGadgetsBoots(7, player));
		gadgetsBootsInv.setItem(32, getGadgetsBoots(8, player));
		gadgetsBootsInv.setItem(33, getGadgetsBoots(9, player));
		gadgetsBootsInv.setItem(34, getGadgetsBoots(10, player));
		
		if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(gadgetsBootsInv);
	}
	
	public static void openGadgetsExtraInv(Player player) {
		setItemsInv(gadgetsExtrasInv);
		
		//Not configurable
		ItemStack itemGreen = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		ItemMeta metaGreen = itemGreen.getItemMeta();
		metaGreen.setDisplayName(" ");
		itemGreen.setItemMeta(metaGreen);
		
		gadgetsExtrasInv.setItem(9, getGadgetsItem("hats", player));
		gadgetsExtrasInv.setItem(18, getGadgetsItem("heads", player));
		gadgetsExtrasInv.setItem(27, getGadgetsItem("boots", player));
		gadgetsExtrasInv.setItem(36, getGadgetsItem("extras", player));
		gadgetsExtrasInv.setItem(37, itemGreen);
		
		gadgetsExtrasInv.setItem(12, getGadgetsExtras(1, player));
		gadgetsExtrasInv.setItem(13, getGadgetsExtras(2, player));
		gadgetsExtrasInv.setItem(14, getGadgetsExtras(3, player));
		gadgetsExtrasInv.setItem(15, getGadgetsExtras(4, player));
		gadgetsExtrasInv.setItem(16, getGadgetsExtras(5, player));
		
		gadgetsExtrasInv.setItem(30, getGadgetsExtras(6, player));
		gadgetsExtrasInv.setItem(31, getGadgetsExtras(7, player));
		gadgetsExtrasInv.setItem(32, getGadgetsExtras(8, player));
		gadgetsExtrasInv.setItem(33, getGadgetsExtras(9, player));
		gadgetsExtrasInv.setItem(34, getGadgetsExtras(10, player));
		
		if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(gadgetsExtrasInv);
	}
	
	public static void openBuyItemInv(Player player) {
		//Not configurable
		ItemStack itemBlack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta metaBlack = itemBlack.getItemMeta();
		metaBlack.setDisplayName(" ");
		itemBlack.setItemMeta(metaBlack);
		
		//Not configurable
		ItemStack itemGreen = new ItemStack(Material.INK_SACK, 1, (short) 10);
		ItemMeta metaGreen = itemGreen.getItemMeta();
		metaGreen.setDisplayName("§aBuy");
		itemGreen.setItemMeta(metaGreen);
		
		//Not configurable
		ItemStack itemRed = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta metaRed = itemRed.getItemMeta();
		metaRed.setDisplayName("§cCancel");
		itemRed.setItemMeta(metaRed);
		
		for(int i=0; i<buyItemInv.getSize(); i++)
			buyItemInv.setItem(i, itemBlack);
		
		buyItemInv.setItem(2, itemGreen);
		buyItemInv.setItem(6, itemRed);
		
		if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(buyItemInv);
	}
	
	public static ItemStack getGadgetsItem(String type, Player player) {
		switch(type) {
		case "hats":
			return items.getConfigItem("Gadgets.Hats");
		case "heads":
			String friendsMaterial = config.getSimpleString("Gadgets.Heads.material", Variable.gadgetsConfig);
			if("%PLAYERHEAD%".equalsIgnoreCase(friendsMaterial))
				friendsMaterial = "SKULL_ITEM";
			int friendsSubID = config.getInt("Gadgets.Heads.subID", Variable.gadgetsConfig);
			String friendsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Gadgets.Heads.name", Variable.gadgetsConfig));
			String friendsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Gadgets.Heads.lore", Variable.gadgetsConfig));
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
			
		case "boots":
			String walkMaterial = config.getSimpleString("Gadgets.Boots.material", Variable.gadgetsConfig);
			int walkSubID = config.getInt("Gadgets.Boots.subID", Variable.gadgetsConfig);
			String walkDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Gadgets.Boots.name", Variable.gadgetsConfig));
			String walkLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Gadgets.Boots.lore", Variable.gadgetsConfig));
			String[] walkLoreArray = walkLore.split("/n");
			List<String> walkLoreList = new ArrayList<String>();
			for(int i=0; i<walkLoreArray.length; i++)
				walkLoreList.add(walkLoreArray[i]);
			
			ItemStack walkItem = new ItemStack(Material.getMaterial(walkMaterial), 1, (short) walkSubID);
			if("LEATHER_BOOTS".equalsIgnoreCase(walkMaterial))
				if(config.getBoolean("Gadgets.Boots.color.enabled", Variable.gadgetsConfig)) {
					int red = config.getInt("Gadgets.Boots.color.red", Variable.gadgetsConfig);
					int green = config.getInt("Gadgets.Boots.color.green", Variable.gadgetsConfig);
					int blue = config.getInt("Gadgets.Boots.color.blue", Variable.gadgetsConfig);
					
					LeatherArmorMeta leatherMeta = (LeatherArmorMeta) walkItem.getItemMeta();
					leatherMeta.setColor(Color.fromRGB(red, green, blue));
					leatherMeta.setDisplayName(walkDisplayName);
					leatherMeta.setLore(walkLoreList);
					walkItem.setItemMeta(leatherMeta);
					return walkItem;
			}
			ItemMeta walkMeta = walkItem.getItemMeta();
			walkMeta.setDisplayName(walkDisplayName);
			walkMeta.setLore(walkLoreList);
			walkItem.setItemMeta(walkMeta);
			return walkItem;
			
		case "extras":
			return items.getConfigItem("Gadgets.Extras");
		}
		return new ItemStack(Material.AIR);
	}
	
	public static ItemStack getGadgetsHats(int number, Player player) {
		String hatsMaterial = config.getSimpleString("Shop.Hats."+number+".material", Variable.shopConfig);
		int hatsSubID = config.getInt("Shop.Hats."+number+".subID", Variable.shopConfig);
		
		if(player.hasPermission("lobby.*") || MySQLShopHats.getBoughtItem(player.getUniqueId(), number) == 1) {
			String hatsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Hats."+number+".bought.name", Variable.shopConfig));
			String hatsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Hats."+number+".bought.lore", Variable.shopConfig));
			String[] hatsLoreArray = hatsLore.split("/n");
			List<String> hatsLoreList = new ArrayList<String>();
			for(int j=0; j<hatsLoreArray.length; j++)
				hatsLoreList.add(hatsLoreArray[j]);
						
			ItemStack hatsItem = new ItemStack(Material.getMaterial(hatsMaterial), 1, (short) hatsSubID);
			ItemMeta hatsMeta = hatsItem.getItemMeta();
			hatsMeta.setDisplayName(hatsDisplayName);
			hatsMeta.setLore(hatsLoreList);
			hatsItem.setItemMeta(hatsMeta);
			return hatsItem;
		}
		String hatsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Hats."+number+".sale.name", Variable.shopConfig));
		String hatsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Hats."+number+".sale.lore", Variable.shopConfig));
		String[] hatsLoreArray = hatsLore.split("/n");
		List<String> hatsLoreList = new ArrayList<String>();
		for(int j=0; j<hatsLoreArray.length; j++)
			hatsLoreList.add(hatsLoreArray[j]);
		
		ItemStack hatsItem = new ItemStack(Material.getMaterial(hatsMaterial), 1, (short) hatsSubID);
		ItemMeta hatsMeta = hatsItem.getItemMeta();
		hatsMeta.setDisplayName(hatsDisplayName);
		hatsMeta.setLore(hatsLoreList);
		hatsItem.setItemMeta(hatsMeta);
		return hatsItem;
	}
	
	public static ItemStack getGadgetsHeads(int number, Player player) {
		if(player.hasPermission("lobby.*") || MySQLShopHeads.getBoughtItem(player.getUniqueId(), number) == 1) {
			String headsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Heads."+number+".bought.name", Variable.shopConfig));
			String headsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Heads."+number+".bought.lore", Variable.shopConfig));
			String[] headsLoreArray = headsLore.split("/n");
			List<String> headsLoreList = new ArrayList<String>();
			for(int j=0; j<headsLoreArray.length; j++)
				headsLoreList.add(headsLoreArray[j]);
						
			ItemStack headsItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			SkullMeta headsMeta = (SkullMeta) headsItem.getItemMeta();
			headsMeta.setOwner(config.getSimpleString("Shop.Heads."+number+".headOwner", Variable.shopConfig));
			headsMeta.setDisplayName(headsDisplayName);
			headsMeta.setLore(headsLoreList);
			headsItem.setItemMeta(headsMeta);
			return headsItem;
		}
		String headsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Heads."+number+".sale.name", Variable.shopConfig));
		String headsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Heads."+number+".sale.lore", Variable.shopConfig));
		String[] headsLoreArray = headsLore.split("/n");
		List<String> headsLoreList = new ArrayList<String>();
		for(int j=0; j<headsLoreArray.length; j++)
			headsLoreList.add(headsLoreArray[j]);
		
		ItemStack headsItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta headsMeta = (SkullMeta) headsItem.getItemMeta();
		headsMeta.setOwner(config.getSimpleString("Shop.Heads."+number+".headOwner", Variable.shopConfig));
		headsMeta.setDisplayName(headsDisplayName);
		headsMeta.setLore(headsLoreList);
		headsItem.setItemMeta(headsMeta);
		return headsItem;
	}
	
	public static ItemStack getGadgetsBoots(int number, Player player) {
		if(player.hasPermission("lobby.*") || MySQLShopBoots.getBoughtItem(player.getUniqueId(), number) == 1) {
			String bootsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Boots."+number+".bought.name", Variable.shopConfig));
			String bootsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Boots."+number+".bought.lore", Variable.shopConfig));
			String[] bootsLoreArray = bootsLore.split("/n");
			List<String> bootsLoreList = new ArrayList<String>();
			for(int j=0; j<bootsLoreArray.length; j++)
				bootsLoreList.add(bootsLoreArray[j]);
			
			if(number == 9 || number == 10) {
				ItemStack bootsItem = new ItemStack(Material.BARRIER);
				ItemMeta bootsMeta = bootsItem.getItemMeta();
				bootsMeta.setDisplayName(bootsDisplayName);
				bootsMeta.setLore(bootsLoreList);
				bootsItem.setItemMeta(bootsMeta);
				return bootsItem;
			}
			
			if(config.getBoolean("Shop.Boots."+number+".color.enabled", Variable.shopConfig)) {
				int red = config.getInt("Shop.Boots."+number+".color.red", Variable.shopConfig);
				int green = config.getInt("Shop.Boots."+number+".color.green", Variable.shopConfig);
				int blue = config.getInt("Shop.Boots."+number+".color.blue", Variable.shopConfig);
				
				ItemStack bootsItem = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta bootsMeta = (LeatherArmorMeta) bootsItem.getItemMeta();
				bootsMeta.setColor(Color.fromRGB(red, green, blue));
				bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				bootsMeta.spigot().setUnbreakable(true);
				bootsMeta.setDisplayName(bootsDisplayName);
				bootsMeta.setLore(bootsLoreList);
				bootsItem.setItemMeta(bootsMeta);
				return bootsItem;
			}
			
			ItemStack bootsItem = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta bootsMeta = bootsItem.getItemMeta();
			bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			bootsMeta.spigot().setUnbreakable(true);
			bootsMeta.setDisplayName(bootsDisplayName);
			bootsMeta.setLore(bootsLoreList);
			bootsItem.setItemMeta(bootsMeta);
			return bootsItem;
		}
		String bootsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Boots."+number+".sale.name", Variable.shopConfig));
		String bootsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Boots."+number+".sale.lore", Variable.shopConfig));
		String[] bootsLoreArray = bootsLore.split("/n");
		List<String> bootsLoreList = new ArrayList<String>();
		for(int j=0; j<bootsLoreArray.length; j++)
			bootsLoreList.add(bootsLoreArray[j]);
		
		if(number == 9 || number == 10) {
			ItemStack bootsItem = new ItemStack(Material.BARRIER);
			ItemMeta bootsMeta = bootsItem.getItemMeta();
			bootsMeta.setDisplayName(bootsDisplayName);
			bootsMeta.setLore(bootsLoreList);
			bootsItem.setItemMeta(bootsMeta);
			return bootsItem;
		}
		
		if(config.getBoolean("Shop.Boots."+number+".color.enabled", Variable.shopConfig)) {
			int red = config.getInt("Shop.Boots."+number+".color.red", Variable.shopConfig);
			int green = config.getInt("Shop.Boots."+number+".color.green", Variable.shopConfig);
			int blue = config.getInt("Shop.Boots."+number+".color.blue", Variable.shopConfig);
			
			ItemStack bootsItem = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) bootsItem.getItemMeta();
			bootsMeta.setColor(Color.fromRGB(red, green, blue));
			bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			bootsMeta.spigot().setUnbreakable(true);
			bootsMeta.setDisplayName(bootsDisplayName);
			bootsMeta.setLore(bootsLoreList);
			bootsItem.setItemMeta(bootsMeta);
			return bootsItem;
		}
		
		ItemStack bootsItem = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta bootsMeta = bootsItem.getItemMeta();
		bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		bootsMeta.spigot().setUnbreakable(true);
		bootsMeta.setDisplayName(bootsDisplayName);
		bootsMeta.setLore(bootsLoreList);
		bootsItem.setItemMeta(bootsMeta);
		return bootsItem;
	}
	
	public static ItemStack getGadgetsExtras(int number, Player player) {
		if(player.hasPermission("lobby.*") || MySQLShopExtras.getBoughtItem(player.getUniqueId(), number) == 1) {
			String extrasMaterial = config.getSimpleString("Shop.Extras."+number+".material", Variable.shopConfig);
			int extrasSubID = config.getInt("Shop.Extras."+number+".subID", Variable.shopConfig);
			String extrasDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Extras."+number+".bought.name", Variable.shopConfig));
			String extrasLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Extras."+number+".bought.lore", Variable.shopConfig));
			String[] extrasLoreArray = extrasLore.split("/n");
			List<String> extrasLoreList = new ArrayList<String>();
			for(int i=0; i<extrasLoreArray.length; i++)
				extrasLoreList.add(extrasLoreArray[i]);
			
			if(number >= 6) {
				ItemStack extrasItem = new ItemStack(Material.getMaterial(extrasMaterial), 1, (short) extrasSubID);
				ItemMeta extrasMeta = extrasItem.getItemMeta();
				extrasMeta.setDisplayName(extrasDisplayName);
				extrasMeta.setLore(extrasLoreList);
				extrasItem.setItemMeta(extrasMeta);
				return extrasItem;
			}
			
			ItemStack extrasItem = new ItemStack(Material.getMaterial(extrasMaterial), 1, (short) extrasSubID);
			ItemMeta extrasMeta = extrasItem.getItemMeta();
			extrasMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			extrasMeta.spigot().setUnbreakable(true);
			extrasMeta.setDisplayName(extrasDisplayName);
			extrasMeta.setLore(extrasLoreList);
			extrasItem.setItemMeta(extrasMeta);
			return extrasItem;
		}
		String extrasMaterial = config.getSimpleString("Shop.Extras."+number+".material", Variable.shopConfig);
		int extrasSubID = config.getInt("Shop.Extras."+number+".subID", Variable.shopConfig);
		String extrasDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Extras."+number+".sale.name", Variable.shopConfig));
		String extrasLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Shop.Extras."+number+".sale.lore", Variable.shopConfig));
		String[] extrasLoreArray = extrasLore.split("/n");
		List<String> extrasLoreList = new ArrayList<String>();
		for(int i=0; i<extrasLoreArray.length; i++)
			extrasLoreList.add(extrasLoreArray[i]);
		
		if(number >= 6) {
			ItemStack extrasItem = new ItemStack(Material.getMaterial(extrasMaterial), 1, (short) extrasSubID);
			ItemMeta extrasMeta = extrasItem.getItemMeta();
			extrasMeta.setDisplayName(extrasDisplayName);
			extrasMeta.setLore(extrasLoreList);
			extrasItem.setItemMeta(extrasMeta);
			return extrasItem;
		}
		
		ItemStack extrasItem = new ItemStack(Material.getMaterial(extrasMaterial), 1, (short) extrasSubID);
		ItemMeta extrasMeta = extrasItem.getItemMeta();
		extrasMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		extrasMeta.spigot().setUnbreakable(true);
		extrasMeta.setDisplayName(extrasDisplayName);
		extrasMeta.setLore(extrasLoreList);
		extrasItem.setItemMeta(extrasMeta);
		return extrasItem;
	}
	
	private static void setItemsInv(Inventory inv) {
		//Not configurable
		ItemStack itemBlack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta metaBlack = itemBlack.getItemMeta();
		metaBlack.setDisplayName(" ");
		itemBlack.setItemMeta(metaBlack);
				
		//Not configurable
		ItemStack itemGray = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
		ItemMeta metaGray = itemGray.getItemMeta();
		metaGray.setDisplayName(" ");
		itemGray.setItemMeta(metaGray);
		
		//Not configurable
		ItemStack itemRed = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta metaRed = itemRed.getItemMeta();
		metaRed.setDisplayName(" ");
		itemRed.setItemMeta(metaRed);
				
		//Clear all items
		ItemStack itemClear = new ItemStack(Material.BARRIER);
		ItemMeta metaClear = itemClear.getItemMeta();
		metaClear.setDisplayName("§4§lRemove item");
		itemClear.setItemMeta(metaClear);
		
		//Clear all items
		ItemStack itemClearAll = new ItemStack(Material.BARRIER);
		ItemMeta metaClearAll = itemClearAll.getItemMeta();
		metaClearAll.setDisplayName("§4§lRemove all items");
		itemClearAll.setItemMeta(metaClearAll);
				
		for(int i=0; i<inv.getSize(); i++)
			inv.setItem(i, itemGray);
				
		inv.setItem(0, itemBlack);
		inv.setItem(1, itemBlack);
		inv.setItem(10, itemRed);
		inv.setItem(19, itemRed);
		inv.setItem(28, itemRed);
		inv.setItem(37, itemRed);
		inv.setItem(45, itemBlack);
		inv.setItem(46, itemBlack);
		inv.setItem(47, itemBlack);
		inv.setItem(48, itemBlack);
		inv.setItem(49, itemBlack);
		inv.setItem(51, itemBlack);
		inv.setItem(52, itemBlack);
				
		inv.setItem(50, itemClear);
		inv.setItem(53, itemClearAll);
	}
	
}
