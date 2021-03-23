package de.deda.lobby.listener.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;

import de.deda.lobby.commands.LobbyCommand;
import de.deda.lobby.listener.InventoryClickListener;
import de.deda.lobby.program.Items;
import de.deda.lobby.program.itemInventory.Gadgets;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class PlayerSneakListener implements Listener {

	@EventHandler
	public void onSneak(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		ConfigManager config = new ConfigManager();
		Items items = new Items();
		
		if(LobbyCommand.buildMode.contains(player.getUniqueId())) {
			return;
		}
		
		if(config.getBoolean("SneakItems.enabled", Variable.itemConfig))
			if(player.hasPermission("lobby.sneak") || player.hasPermission("lobby.*")) {
				items.setSneakItems(player);
				if(!event.isSneaking()) {
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
				}
			}
	}
}
