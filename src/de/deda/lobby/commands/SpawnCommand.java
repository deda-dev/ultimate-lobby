package de.deda.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class SpawnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.spawn") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length != 0) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/spawn", Variable.config));
			return false;
		}
		
		player.teleport(config.getLocation("Spawn", Variable.locConfig));
		return true;
	}
}
