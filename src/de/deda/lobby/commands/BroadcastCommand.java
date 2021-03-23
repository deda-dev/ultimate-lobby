package de.deda.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class BroadcastCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		String message = "";
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.broadcast") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length == 0) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/broadcast <message>", Variable.config));
			return false;
		}
		
		for(int i=0; i<args.length; i++)
			message = message+args[i]+" ";
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.sendMessage("");
			all.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
			all.sendMessage("");
		}
		
		return true;
	}
}
