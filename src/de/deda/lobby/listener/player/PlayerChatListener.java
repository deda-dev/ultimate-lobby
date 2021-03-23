package de.deda.lobby.listener.player;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.deda.lobby.program.itemInventory.Navigator;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class PlayerChatListener implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		ConfigManager config = new ConfigManager();
	
		if(!player.hasPermission("lobby.loged") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			event.setCancelled(true);
			return;
		}
		
		if(Navigator.setNavigatorTitle.contains(player.getUniqueId())) {
			config.setString(event.getMessage(), "Navigator.inventoryTitle", Variable.navigatorConfig, Variable.navigatorFile);
			player.sendMessage("§a§lYou set the navigator title.");
			Navigator.setNavigatorTitle.remove(player.getUniqueId());
			event.setCancelled(true);
			return;
		}
		
		if(!config.getBoolean("ChatLog.loged", Variable.config)) {
			event.setCancelled(true);
			for(Player all : Bukkit.getOnlinePlayers())
				if(player.hasPermission("lobby.colorcode") || !player.hasPermission("lobby.*")) {
					all.sendMessage(getChatPrefix(player) + " " + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
				} else
					all.sendMessage(getChatPrefix(player) + " " + event.getMessage());
			return;
		}
		
		event.setCancelled(true);
		for(Player all : Bukkit.getOnlinePlayers())
			if(player.hasPermission("lobby.colorcode") || !player.hasPermission("lobby.*")) {
				all.sendMessage(getChatPrefix(player) + " " + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			} else
				all.sendMessage(getChatPrefix(player) + " " + event.getMessage());
	}
	
	public String getChatPrefix(Player player) {
		ConfigManager config = new ConfigManager();
		
		ConfigurationSection cs = Variable.config.getConfigurationSection("Chat");
		Set<String> key = cs.getKeys(false);
		
		if(key == null) {
			return null;
		}
		Object[] keys = key.toArray();
		
		for(int i=0; i<key.size(); i++)
			if(config.getString("Chat."+keys[i]+".prefix", Variable.config) != null && config.getString("Chat."+keys[i]+".perm", Variable.config) != null) {
				String perm = config.getString("Chat."+keys[i]+".perm", Variable.config);
				String prefix = config.getAdvancedString("Chat."+keys[i]+".prefix", player, Variable.config);
				
				if(player.hasPermission(perm))
					return prefix;
			}
		String prefix = config.getAdvancedString("Chat."+keys[keys.length-1]+".prefix", player, Variable.config);
		return prefix;
	}
}
