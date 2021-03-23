package de.deda.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class SetSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.setspawn") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length != 0) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/setspawn", Variable.config));
			return false;
		}
		
		config.setLocation(player, "Spawn", Variable.locConfig, Variable.locFile);
		player.sendMessage(config.getString("SetSpawn", Variable.cmdConfig));
		return true;
	}

}
