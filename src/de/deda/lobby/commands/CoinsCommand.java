package de.deda.lobby.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.deda.lobby.program.Coins;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.mysql.MySQLCoins;
import de.deda.lobby.utils.scoreboard.Board;

public class CoinsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		ConfigManager config = new ConfigManager();
		String coinsPlayer = Coins.getCoins(player);
		
		if(args.length == 0) {
			player.sendMessage(config.getCoinString("Coins.your", coinsPlayer, player, Variable.cmdConfig));
			return true;
		}
		
		if(args.length == 1) {
			if("help".equalsIgnoreCase(args[0])) {
				player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/coins <player/set/add/remove> <player> <amount>", Variable.config));
				return false;
			}
			
			if(Bukkit.getPlayer(args[0]) == null) {
				player.sendMessage(config.getString("PlayerNotOnline", Variable.config));
				return false;
			}
			Player target = Bukkit.getPlayer(args[0]);
			String coinsTarget= Coins.getCoins(target);
		
			player.sendMessage(config.getCoinString("Coins.target", coinsTarget, target, Variable.cmdConfig));
			return true;
		}
		
		if(args.length != 3) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/coins <set/add/remove> <player> <amount>", Variable.config));
			return false;
		}
		
		if(!player.hasPermission("lobby.coins") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(Bukkit.getPlayer(args[1]) == null) {
			player.sendMessage(config.getString("PlayerNotOnline", Variable.config));
			return false;
		}
		
		if(!isInteger(args[2])) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/coins <set/add/remove> <player> <amount>", Variable.config));
			return false;
		}
		
		Player target = Bukkit.getPlayer(args[1]);
		UUID targetUUID = target.getUniqueId();
		int amount = Integer.parseInt(args[2]);
		
		switch(args[0]) {
		case "set":
			MySQLCoins.setCoins(targetUUID, amount);
			Board.setBoard(target);
			Board.updateRank(target);
			player.sendMessage(config.getCoinString("Coins.set", args[2], target, Variable.cmdConfig));
			return true;
			
		case "add":
			MySQLCoins.Update(targetUUID, amount, false);
			Board.setBoard(target);
			Board.updateRank(target);
			player.sendMessage(config.getCoinString("Coins.add", args[2], target, Variable.cmdConfig));
			return true;
			
		case "remove":
			MySQLCoins.Update(targetUUID, amount, true);
			Board.setBoard(target);
			Board.updateRank(target);
			player.sendMessage(config.getCoinString("Coins.remove", args[2], target, Variable.cmdConfig));
			return true;
		
		default:
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/coins <set/add/remove> <player> <amount>", Variable.config));
			return false;
		}
	}

	private boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
			Double.parseDouble(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}
