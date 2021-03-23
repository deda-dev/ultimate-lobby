package de.deda.lobby.listener.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class PlayerItemHeldListener implements Listener {

	@EventHandler
	public void onHeldItem(PlayerItemHeldEvent event) {
		Player player = event.getPlayer();
		ConfigManager config = new ConfigManager();
		
		if(player.getInventory().getItem(event.getNewSlot()) != null)
			if(config.getString("Shop.Extras.3.bought.name", Variable.shopConfig).equals(player.getInventory().getItem(event.getNewSlot()).getItemMeta().getDisplayName())) {
				player.getInventory().setItem(9, new ItemStack(Material.ARROW, 1));
				return;
			}
		player.getInventory().setItem(9, new ItemStack(Material.AIR));
	}
}
