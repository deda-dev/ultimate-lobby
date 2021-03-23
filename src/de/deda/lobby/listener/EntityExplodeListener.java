package de.deda.lobby.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplodeListener implements Listener {

	@EventHandler
	public void onBlockDamagee(EntityExplodeEvent event) {
		if(event.getEntityType() == EntityType.PRIMED_TNT)
			event.setCancelled(true);
	}
}
