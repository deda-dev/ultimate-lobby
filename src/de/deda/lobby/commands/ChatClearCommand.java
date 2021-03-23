package de.deda.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class ChatClearCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.chatclear") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length != 0) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/chatclear", Variable.config));
			return false;
		}
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			for(int i = 0; i<150; i++)
				all.sendMessage("");
			all.sendMessage(config.getAdvancedString("ChatClear.messages.firstLine", player, Variable.cmdConfig));
			all.sendMessage(config.getAdvancedString("ChatClear.messages.secondLine", player, Variable.cmdConfig));
			return true;
		}
		return false;
	}
}