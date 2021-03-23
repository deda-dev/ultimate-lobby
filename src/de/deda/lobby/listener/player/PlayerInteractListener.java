package de.deda.lobby.listener.player;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.deda.lobby.commands.FlyCommand;
import de.deda.lobby.commands.LobbyCommand;
import de.deda.lobby.program.Items;
import de.deda.lobby.program.itemInventory.Gadgets;
import de.deda.lobby.program.itemInventory.LobbySwitcher;
import de.deda.lobby.program.itemInventory.Navigator;
import de.deda.lobby.program.itemInventory.PlayerHider;
import de.deda.lobby.program.itemInventory.Settings;
import de.deda.lobby.program.itemInventory.TeamServer;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.mysql.MySQLSettings;
import de.deda.lobby.utils.title.TitleAPI;

public class PlayerInteractListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		ConfigManager config = new ConfigManager();
		Items items = new Items();
		
		if(LobbyCommand.buildMode.contains(player.getUniqueId()))
			return;
		
		try {
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				if(items.getSneakItems("buildmode").equals(event.getItem())) {
					LobbyCommand.buildMode.add(player.getUniqueId());
					
					player.sendMessage(config.getString("BuildMode.activated", Variable.cmdConfig));
					player.setGameMode(GameMode.CREATIVE);
					player.getInventory().clear();
					if(LobbyCommand.buildModeItems.containsKey(player.getUniqueId()))
						player.getInventory().setContents(LobbyCommand.buildModeItems.get(player.getUniqueId()));
								
					if(config.getBoolean("BuildMode.title.enabled", Variable.cmdConfig))
						if(config.getString("BuildMode.title.activated.title", Variable.cmdConfig) != null && config.getString("BuildMode.title.activated.subtitle", Variable.cmdConfig) != null)
							TitleAPI.sendTitle(player, 15, 25, 15, config.getString("BuildMode.title.activated.title", Variable.cmdConfig), config.getString("BuildMode.title.activated.subtitle", Variable.cmdConfig));
					event.setCancelled(true);
					return;
				}
				if(items.getSneakItems("flyoff").equals(event.getItem())) {
					FlyCommand.fly.add(player.getUniqueId());
					player.setAllowFlight(true);
					player.sendMessage(config.getString("Fly.activated", Variable.cmdConfig));
					player.getInventory().setItem(config.getInt("SneakItems.Fly.slot", Variable.itemConfig)-1, items.getSneakItems("flyon"));
					if(config.getBoolean("SneakItems.Fly.sound", Variable.itemConfig))
						player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
					event.setCancelled(true);
					return;
					
				} else if(items.getSneakItems("flyon").equals(event.getItem())) {
					FlyCommand.fly.remove(player.getUniqueId());
					if(MySQLSettings.getMovement(player.getUniqueId()) == 1) {
						player.setAllowFlight(true);
					} else
						player.setAllowFlight(false);
					player.sendMessage(config.getString("Fly.deactivated", Variable.cmdConfig));
					player.getInventory().setItem(config.getInt("SneakItems.Fly.slot", Variable.itemConfig)-1, items.getSneakItems("flyoff"));
					if(config.getBoolean("SneakItems.Fly.sound", Variable.itemConfig))
						player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
					player.setFlying(false);
					event.setCancelled(true);
					return;
				}
				if(items.getSneakItems("nick").equals(event.getItem())) {
					player.performCommand(config.getSimpleString("SneakItems.Nick.command", Variable.itemConfig));
					event.setCancelled(true);
					return;
				}
				if(items.getSneakItems("teamserver").equals(event.getItem())) {
					TeamServer.openTeamServerInv(player);
					event.setCancelled(true);
					return;
				}
				if(items.getJoinItems("playerhider").equals(event.getItem())) {
					PlayerHider.openPlayerHiderInv(player);
					event.setCancelled(true);
					return;
				}
				if(items.getJoinItems("lobbyswitcher").equals(event.getItem())) {
					LobbySwitcher.openPlayerHiderInv(player);
					event.setCancelled(true);
					return;
				}
				if(items.getJoinItems("settings").equals(event.getItem())) {
					Settings.openSettingsInv(player);
					event.setCancelled(true);
					return;
				}
				if(items.getJoinItems("gadget").equals(event.getItem())) {
					Gadgets.openGadgetsHatInv(player);
					event.setCancelled(true);
					return;
				}
				if(items.getJoinItems("navigator").equals(event.getItem())) {
					Navigator.openNavigatorInventory(player);
					event.setCancelled(true);
					return;
				}
				if(Gadgets.getGadgetsExtras(1, player).equals(event.getItem())) {
					return;
				}
				if(Gadgets.getGadgetsExtras(2, player).equals(event.getItem())) {
					return;
				}
				if(Gadgets.getGadgetsExtras(3, player).equals(event.getItem())) {
					return;
				}
				if(Gadgets.getGadgetsExtras(4, player).equals(event.getItem())) {
					return;
				}
				if(Gadgets.getGadgetsExtras(5, player).equals(event.getItem())) {
					return;
				}
				
				
				
			}
			
		} catch(Exception e) {
		}
		
		event.setCancelled(true);
		
		if(event.getAction() == Action.PHYSICAL) {
			if(block == null) {
				return; 
			}
			
			if(block.getType() == Material.SOIL) {
				event.setUseInteractedBlock(org.bukkit.event.Event.Result.DENY);
				event.setCancelled(true);
				block.setTypeIdAndData(block.getTypeId(), block.getData(), true);
			}
		}	
	}
}
