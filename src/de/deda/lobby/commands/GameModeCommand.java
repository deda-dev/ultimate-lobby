package de.deda.lobby.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class GameModeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.gm") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length != 1) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/gm <0/1/2/3>", Variable.config));
			return false;
		}
		
		switch(args[0]) {
		case "0":
			player.sendMessage(config.getString("GameMode.0", Variable.cmdConfig));
			player.setGameMode(GameMode.SURVIVAL);
			return true;
		case "1":
			player.sendMessage(config.getString("GameMode.1", Variable.cmdConfig));
			player.setGameMode(GameMode.CREATIVE);
			return true;
		case "2":
			player.sendMessage(config.getString("GameMode.2", Variable.cmdConfig));
			player.setGameMode(GameMode.ADVENTURE);
			return true;
		case "3":
			player.sendMessage(config.getString("GameMode.3", Variable.cmdConfig));
			player.setGameMode(GameMode.SPECTATOR);
			return true;
		}
		player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/gm <0/1/2/3>", Variable.config));
		return false;
	}
}
