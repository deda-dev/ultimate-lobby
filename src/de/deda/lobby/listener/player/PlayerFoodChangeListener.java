package de.deda.lobby.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import de.deda.lobby.commands.LobbyCommand;

public class PlayerFoodChangeListener implements Listener {
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent event) {
		Player player = (Player) event.getEntity();
		
		if(LobbyCommand.buildMode.contains(player.getUniqueId())) {
			return;
		}
		event.setCancelled(true);
		
	}
}
