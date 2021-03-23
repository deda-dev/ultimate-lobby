package de.deda.lobby.program.itemInventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.deda.lobby.program.Items;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class TeamServer {

	static ConfigManager config = new ConfigManager();
	static Items items = new Items();
	public static Inventory teamServerInv = Bukkit.createInventory(null, InventoryType.BREWING, config.getSimpleString("TeamServer.title", Variable.teamServerConfig));
	
	public static void openTeamServerInv(Player player) {
		//Not configurable
		List<String> loreList = new ArrayList<String>();
		loreList.add("§7Click on a item");
		ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§dTeam §bServer");
		meta.setLore(loreList);
		item.setItemMeta(meta);
		
		teamServerInv.setItem(3, item);
		teamServerInv.setItem(0, getTeamServerItem("first"));
		teamServerInv.setItem(1, getTeamServerItem("second"));
		teamServerInv.setItem(2, getTeamServerItem("third"));
		
		if(config.getBoolean("TeamServer.sound", Variable.teamServerConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(teamServerInv);
	}
	
	public static ItemStack getTeamServerItem(String type) {
		switch(type) {
		case "first":
			return items.getConfigItem("TeamServer.firstSlot");
			
		case "second":
			return items.getConfigItem("TeamServer.secondSlot");
			
		case "third":
			return items.getConfigItem("TeamServer.thirdSlot");
		}
		return new ItemStack(Material.AIR);
	}
}
