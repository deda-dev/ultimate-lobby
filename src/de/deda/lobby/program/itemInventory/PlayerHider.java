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
import de.deda.lobby.utils.mysql.MySQLPlayerHider;

public class PlayerHider {

	static ConfigManager config = new ConfigManager();
	static Items items = new Items();
	public static Inventory playerHiderInv = Bukkit.createInventory(null, 9, config.getSimpleString("PlayerHider.title", Variable.playerHiderConfig));
	
	public static void openPlayerHiderInv(Player player) {
		//Not configurable
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		
		for(int i=0; i<playerHiderInv.getSize(); i++)
			playerHiderInv.setItem(i, item);
		
		playerHiderInv.setItem(1, getTeamServerItem("show", player));
		playerHiderInv.setItem(4, getTeamServerItem("member", player));
		playerHiderInv.setItem(7, getTeamServerItem("hide", player));
		
		if(config.getBoolean("PlayerHider.sound", Variable.playerHiderConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(playerHiderInv);
	}
	
	public static ItemStack getTeamServerItem(String type, Player player) {
		switch(type) {
		case "show":
			if(MySQLPlayerHider.getShowPlayer(player.getUniqueId()) == 0) {
				ItemStack item = items.getConfigItem("PlayerHider.showAll");
				ItemMeta meta = items.getConfigItem("PlayerHider.showAll").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("PlayerHider.showAll").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("PlayerHider.showAll");
			
		case "member":
			if(MySQLPlayerHider.getShowPlayer(player.getUniqueId()) == 1) {
				ItemStack item = items.getConfigItem("PlayerHider.showMembers");
				ItemMeta meta = items.getConfigItem("PlayerHider.showMembers").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("PlayerHider.showMembers").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("PlayerHider.showMembers");
			
		case "hide":
			if(MySQLPlayerHider.getShowPlayer(player.getUniqueId()) == 2) {
				ItemStack item = items.getConfigItem("PlayerHider.hideAll");
				ItemMeta meta = items.getConfigItem("PlayerHider.hideAll").getItemMeta();
				meta.addEnchant(Enchantment.DURABILITY, 1, false);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				items.getConfigItem("PlayerHider.hideAll").setItemMeta(meta);
				return item;
			}
			return items.getConfigItem("PlayerHider.hideAll");
		}
		return new ItemStack(Material.AIR);
	}
}
