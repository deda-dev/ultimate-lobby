package de.deda.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import de.deda.lobby.commands.LobbyCommand;

public class EntityDamageListener implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
		
			if(LobbyCommand.buildMode.contains(player.getUniqueId())) {
				return;
			}
			event.setCancelled(true);
		}
	}
}
