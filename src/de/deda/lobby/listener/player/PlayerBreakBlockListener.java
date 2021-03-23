package de.deda.lobby.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import de.deda.lobby.commands.LobbyCommand;

public class PlayerBreakBlockListener implements Listener {
	
	@EventHandler
	public void onBreack(BlockBreakEvent event) {
		Player player = event.getPlayer();
		
		if(LobbyCommand.buildMode.contains(player.getUniqueId())) {
			return;
		}
		event.setCancelled(true);
		
	}
}
