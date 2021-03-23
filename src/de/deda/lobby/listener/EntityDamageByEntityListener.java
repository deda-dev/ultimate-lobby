package de.deda.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.deda.lobby.commands.LobbyCommand;

public class EntityDamageByEntityListener implements Listener {
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player))
			return;
		Player player = (Player) event.getDamager();
		
		if(LobbyCommand.buildMode.contains(player.getUniqueId()))
			return;
		
		event.setCancelled(true);
		
	}
}
