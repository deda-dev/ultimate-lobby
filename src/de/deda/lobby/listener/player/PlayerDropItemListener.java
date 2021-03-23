package de.deda.lobby.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.deda.lobby.commands.LobbyCommand;


public class PlayerDropItemListener implements Listener {
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		
		if(LobbyCommand.buildMode.contains(player.getUniqueId()))
			return;
		event.setCancelled(true);
	}
}
