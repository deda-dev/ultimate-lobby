package de.deda.lobby.commands;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.mysql.MySQLSettings;

public class FlyCommand implements CommandExecutor {

	public static ArrayList<UUID> fly = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		UUID uuid = player.getUniqueId();
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.fly") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length != 0) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/fly", Variable.config));
			return false;
		}
		
		if(fly.contains(uuid)) {
			fly.remove(uuid);
			if(MySQLSettings.getMovement(player.getUniqueId()) == 1) {
				player.setAllowFlight(true);
			} else
				player.setAllowFlight(false);
			player.setFlying(false);
			player.sendMessage(config.getString("Fly.deactivated", Variable.cmdConfig));
			return true;
		}
		
		fly.add(uuid);
		player.setAllowFlight(true);
		player.sendMessage(config.getString("Fly.activated", Variable.cmdConfig));
		return false;
	}

}
