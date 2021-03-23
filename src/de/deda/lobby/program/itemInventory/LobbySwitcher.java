package de.deda.lobby.program.itemInventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.deda.lobby.program.Items;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class LobbySwitcher {

	static ConfigManager config = new ConfigManager();
	static Items items = new Items();
	public static Inventory lobbySwitcherInv = Bukkit.createInventory(null, 9, config.getSimpleString("LobbySwitcher.title", Variable.lobbySwitcherConfig));
	
	public static void openPlayerHiderInv(Player player) {
		//Not configurable
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		
		for(int i=0; i<lobbySwitcherInv.getSize(); i++)
			lobbySwitcherInv.setItem(i, item);
		
		lobbySwitcherInv.setItem(1, getTeamServerItem("lobby1"));
		lobbySwitcherInv.setItem(2, getTeamServerItem("lobby2"));
		lobbySwitcherInv.setItem(3, getTeamServerItem("lobby3"));
		lobbySwitcherInv.setItem(4, getTeamServerItem("lobby4"));
		lobbySwitcherInv.setItem(5, getTeamServerItem("lobby5"));
		lobbySwitcherInv.setItem(7, getTeamServerItem("premlobby"));
		
		if(config.getBoolean("LobbySwitcher.sound", Variable.lobbySwitcherConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(lobbySwitcherInv);
	}
	
	public static ItemStack getTeamServerItem(String type) {
		switch(type) {
		case "lobby1":
			if(config.getSimpleString("LobbySwitcher.lobby.1.server", Variable.lobbySwitcherConfig).equals(Bukkit.getServerName())) {
				ItemStack item = items.getConfigItem("LobbySwitcher.lobby.1");
				ItemMeta meta = items.getConfigItem("LobbySwitcher.lobby.1").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("LobbySwitcher.lobby.1").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("LobbySwitcher.lobby.1");
			
		case "lobby2":
			if(config.getSimpleString("LobbySwitcher.lobby.2.server", Variable.lobbySwitcherConfig).equals(Bukkit.getServerName())) {
				ItemStack item = items.getConfigItem("LobbySwitcher.lobby.2");
				ItemMeta meta = items.getConfigItem("LobbySwitcher.lobby.2").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("LobbySwitcher.lobby.2").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("LobbySwitcher.lobby.2");
			
		case "lobby3":
			if(config.getSimpleString("LobbySwitcher.lobby.3.server", Variable.lobbySwitcherConfig).equals(Bukkit.getServerName())) {
				ItemStack item = items.getConfigItem("LobbySwitcher.lobby.3");
				ItemMeta meta = items.getConfigItem("LobbySwitcher.lobby.3").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("LobbySwitcher.lobby.3").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("LobbySwitcher.lobby.3");
			
		case "lobby4":
			if(config.getSimpleString("LobbySwitcher.lobby.4.server", Variable.lobbySwitcherConfig).equals(Bukkit.getServerName())) {
				ItemStack item = items.getConfigItem("LobbySwitcher.lobby.4");
				ItemMeta meta = items.getConfigItem("LobbySwitcher.lobby.4").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("LobbySwitcher.lobby.4").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("LobbySwitcher.lobby.4");
			
		case "lobby5":
			if(config.getSimpleString("LobbySwitcher.lobby.5.server", Variable.lobbySwitcherConfig).equals(Bukkit.getServerName())) {
				ItemStack item = items.getConfigItem("LobbySwitcher.lobby.5");
				ItemMeta meta = items.getConfigItem("LobbySwitcher.lobby.5").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("LobbySwitcher.lobby.5").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("LobbySwitcher.lobby.5");
			
		case "premlobby":
			if(config.getSimpleString("LobbySwitcher.premLobby.server", Variable.lobbySwitcherConfig).equals(Bukkit.getServerName())) {
				ItemStack item = items.getConfigItem("LobbySwitcher.premLobby");
				ItemMeta meta = items.getConfigItem("LobbySwitcher.premLobby").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("LobbySwitcher.premLobby").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("LobbySwitcher.premLobby");
			
		}
		return new ItemStack(Material.AIR);
	}
	
}
