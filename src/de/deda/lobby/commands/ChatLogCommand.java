package de.deda.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class ChatLogCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.chatlog") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length != 0) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/chatlog", Variable.config));
			return false;
		}
		
		if(config.getBoolean("ChatLog.loged", Variable.cmdConfig)) {
			config.setBoolean(false, "ChatLog.loged", Variable.cmdConfig, Variable.cmdFile);
			if(config.getBoolean("ChatLog.messages.loged.chatclear", Variable.cmdConfig)) {
				for(Player all : Bukkit.getOnlinePlayers())
					for(int i = 0; i<150; i++)
						all.sendMessage("");
			}
			
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(config.getAdvancedString("ChatLog.messages.unloged.firstLine", player, Variable.cmdConfig));
				all.sendMessage(config.getAdvancedString("ChatLog.messages.unloged.secondLine", player, Variable.cmdConfig));
			}
			return true;
		}
		
		config.setBoolean(true, "ChatLog.loged", Variable.cmdConfig, Variable.cmdFile);
		if(config.getBoolean("ChatLog.messages.unloged.chatclear", Variable.cmdConfig)) {
			for(Player all : Bukkit.getOnlinePlayers())
				for(int i = 0; i<150; i++)
					all.sendMessage("");
		}
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.sendMessage(config.getAdvancedString("ChatLog.messages.loged.firstLine", player, Variable.cmdConfig));
			all.sendMessage(config.getAdvancedString("ChatLog.messages.loged.secondLine", player, Variable.cmdConfig));
		}
		return true;
	}
}