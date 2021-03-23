package de.deda.lobby.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import net.md_5.bungee.api.ChatColor;

public class ItemCommand implements CommandExecutor {

	private String text = "";
	static List<String> lore = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		ConfigManager config = new ConfigManager();
		
		if(!player.hasPermission("lobby.item") || !player.hasPermission("lobby.*")) {
			player.sendMessage(config.getString("NoPerms", Variable.config));
			return false;
		}
		
		if(args.length <= 1) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/item <rename/lore> <text>", Variable.config));
			return false;
		}
		
		if(player.getInventory().getItemInHand().getType() == Material.AIR) {
			player.sendMessage("§cPut a item in your hand!");
			return false;
		}
		
		if("rename".equalsIgnoreCase(args[0])) {
			for(int i=1;i<args.length;i++) {
				String coloredText = ChatColor.translateAlternateColorCodes('&', args[i]);
				text += coloredText+" ";
			}
			
			ItemStack item = player.getInventory().getItemInHand();
			ItemMeta meta = player.getInventory().getItemInHand().getItemMeta();
			meta.setDisplayName(text.trim());
			player.getInventory().getItemInHand().setItemMeta(meta);
			player.getInventory().setItemInHand(item);
			text = "";
			return true;
		}
		
		if("lore".equalsIgnoreCase(args[0])) {
			for(int i=1;i<args.length;i++) {
				String coloredText = ChatColor.translateAlternateColorCodes('&', args[i]);
				text += coloredText+" ";
			}
			String[] textArray = text.trim().split("/n");
			for(int i=0; i<textArray.length; i++)
				lore.add(textArray[i]);
			player.sendMessage("§cUse \"/n\" to go in the next line!");
			
			ItemStack item = player.getInventory().getItemInHand();
			ItemMeta meta = player.getInventory().getItemInHand().getItemMeta();
			meta.setLore(lore);
			player.getInventory().getItemInHand().setItemMeta(meta);
			player.getInventory().setItemInHand(item);
			text = "";
			lore.clear();
			return true;
		}
		
		player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/item <rename/lore> <text>", Variable.config));
		return false;
	}

	public String getText() {
		return text;
	}
}
