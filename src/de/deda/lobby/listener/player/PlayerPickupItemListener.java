package de.deda.lobby.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import de.deda.lobby.commands.LobbyCommand;

public class PlayerPickupItemListener implements Listener {
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		
		if("dontpickup".equalsIgnoreCase(event.getItem().getItemStack().getItemMeta().getDisplayName()))
			event.setCancelled(true);
		if(LobbyCommand.buildMode.contains(player.getUniqueId()))
			return;
		event.setCancelled(true);
		
	}
}
