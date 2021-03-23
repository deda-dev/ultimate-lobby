package de.deda.lobby.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.deda.lobby.listener.InventoryClickListener;
import de.deda.lobby.listener.player.PlayerJoinListener;
import de.deda.lobby.program.Items;
import de.deda.lobby.program.itemInventory.Gadgets;
import de.deda.lobby.program.itemInventory.Navigator;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.title.TitleAPI;

public class LobbyCommand implements CommandExecutor {

	public static List<UUID> buildMode = new ArrayList<>();
	public static Map<UUID, ItemStack[]> buildModeItems = new HashMap<UUID, ItemStack[]>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		ConfigManager config = new ConfigManager();
		Items items = new Items();
		
		if(args.length != 1) {
			player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/ul <help, build, navigator>", Variable.config));
			return false;
		}
		
		if(player.hasPermission("lobby.help") || player.hasPermission("lobby.*"))
			if("help".equalsIgnoreCase(args[0])) {
				String prefix = config.getString("Prefix", Variable.config);
				player.sendMessage(prefix+" §e§lConfigs");
				player.sendMessage(prefix+" §7Configurate all you want in the configs");
				player.sendMessage(prefix+" §e§l");
				player.sendMessage(prefix+" §e§lSetup");
				player.sendMessage(prefix+" §7Set the spawn with /setspawn");
				player.sendMessage(prefix+" §e§l");
				player.sendMessage(prefix+" §e§lCommands");
				player.sendMessage(prefix+" §7/broadcast (/bc) <text>");
				player.sendMessage(prefix+" §7/chatclear (/cc)");
				player.sendMessage(prefix+" §7/chatlog (/cl)");
				player.sendMessage(prefix+" §7/coins <player/set/add/remove> <player> <amount>");
				player.sendMessage(prefix+" §7/fly");
				player.sendMessage(prefix+" §7/gm <0/1/2/3>");
				player.sendMessage(prefix+" §7/item <rename/lore> <text>");
				player.sendMessage(prefix+" §7/ultimatelobby (/ul) <help/build/navigator(nav)>");
				player.sendMessage(prefix+" §e§l");
				player.sendMessage(prefix+" §e§lNavigator");
				player.sendMessage(prefix+" §7Type \"/ultimatelobby navigator\" or \"/ul nav\" to open the navigator menu");
				player.sendMessage(prefix+" §7Than set the navigator inventory size, title, and items.");
				player.sendMessage(prefix+" §7Shift & right click on the navigator inventory item to add actions.");
				player.sendMessage(prefix+" §e§l");
				player.sendMessage(prefix+" §4§lRestart the server and have fun!");
				return true;
			}
		
		if(player.hasPermission("lobby.build") || player.hasPermission("lobby.*"))
			if("build".equalsIgnoreCase(args[0])) {
				if(!buildMode.contains(player.getUniqueId())) {
					buildMode.add(player.getUniqueId());
								
					player.sendMessage(config.getString("BuildMode.activated", Variable.cmdConfig));
					player.setGameMode(GameMode.CREATIVE);
					player.getInventory().clear();
					player.getInventory().setHelmet(new ItemStack(Material.AIR));
					player.getInventory().setChestplate(new ItemStack(Material.AIR));
					player.getInventory().setLeggings(new ItemStack(Material.AIR));
					player.getInventory().setBoots(new ItemStack(Material.AIR));
					if(buildModeItems.containsKey(player.getUniqueId()))
						player.getInventory().setContents(buildModeItems.get(player.getUniqueId()));
								
					if(config.getBoolean("BuildMode.title.enabled", Variable.cmdConfig))
						if(config.getString("BuildMode.title.activated.title", Variable.cmdConfig) != null && config.getString("BuildMode.title.activated.subtitle", Variable.cmdConfig) != null)
							TitleAPI.sendTitle(player, 15, 25, 15, config.getString("BuildMode.title.activated.title", Variable.cmdConfig), config.getString("BuildMode.title.activated.subtitle", Variable.cmdConfig));
					return true;
				}
				buildMode.remove(player.getUniqueId());
				buildModeItems.put(player.getUniqueId(), player.getInventory().getContents());
				
				player.sendMessage(config.getString("BuildMode.deactivated", Variable.cmdConfig));
				player.setGameMode(GameMode.SURVIVAL);
				player.getInventory().clear();
				player.getInventory().setHelmet(new ItemStack(Material.AIR));
				player.getInventory().setChestplate(new ItemStack(Material.AIR));
				player.getInventory().setLeggings(new ItemStack(Material.AIR));
				player.getInventory().setBoots(new ItemStack(Material.AIR));
				items.setJoinItems(player);
				if(InventoryClickListener.extrasItem.containsKey(player.getUniqueId()))
					if(InventoryClickListener.extrasItem.containsValue(1)) {
						player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(1, player));
					} else if(InventoryClickListener.extrasItem.containsValue(2)) {
						player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(2, player));
					} else if(InventoryClickListener.extrasItem.containsValue(3)) {
						player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(3, player));
						player.getInventory().setItem(9, new ItemStack(Material.ARROW, 1));
					} else if(InventoryClickListener.extrasItem.containsValue(4)) {
						player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(4, player));
					} else if(InventoryClickListener.extrasItem.containsValue(5))
						player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(5, player));
				
				if(PlayerJoinListener.doubleJump.contains(player.getUniqueId()))
					player.setAllowFlight(true);
				
				if(config.getBoolean("BuildMode.title.enabled", Variable.cmdConfig))
					if(config.getString("BuildMode.title.deactivated.title", Variable.cmdConfig) != null && config.getString("BuildMode.title.deactivated.subtitle", Variable.cmdConfig) != null)
						TitleAPI.sendTitle(player, 15, 25, 15, config.getString("BuildMode.title.deactivated.title", Variable.cmdConfig), config.getString("BuildMode.title.deactivated.subtitle", Variable.cmdConfig));
				return true;
			}
		
		if(player.hasPermission("lobby.navigator") || player.hasPermission("lobby.*"))
			if("navigator".equalsIgnoreCase(args[0]) || "nav".equalsIgnoreCase(args[0])) {
				Navigator.openNavigatorMenu(player);
				return true;
			}
		
		player.sendMessage(config.getWrongCommandString("WrongCommandMessage", "/ul <help, build, navigator>", Variable.config));
		return false;
	}

}
