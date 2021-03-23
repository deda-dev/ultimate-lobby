package de.deda.lobby.commands;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class VanishCommand implements CommandExecutor {

	public static ArrayList<UUID> vanish = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		UUID uuid = player.getUniqueId();
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.vanish") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length != 0) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/vanish", Variable.config));
			return false;
		}
		
		if(vanish.contains(uuid)) {
			vanish.remove(uuid);
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.showPlayer(player);
			}
			player.sendMessage(config.getString("Vanish.deactivated", Variable.cmdConfig));
			return true;
		}
		
		vanish.add(uuid);
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.hidePlayer(player);
		}
		player.sendMessage(config.getString("Vanish.activated", Variable.cmdConfig));
		return true;
	}
}
