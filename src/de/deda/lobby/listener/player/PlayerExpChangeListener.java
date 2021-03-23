package de.deda.lobby.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

import de.deda.lobby.commands.LobbyCommand;

public class PlayerExpChangeListener implements Listener {
	
	@EventHandler
	public void onExpChange(PlayerExpChangeEvent event) {
		Player player = event.getPlayer();
		
		if(LobbyCommand.buildMode.contains(player.getUniqueId())) {
			return;
		}
		event.setAmount(0);
		
	}
}
