package de.deda.lobby.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;

import de.deda.lobby.program.Items;
import de.deda.lobby.program.itemInventory.Gadgets;

public class PlayerFishListener implements Listener {
	
	@EventHandler
	public void onFish(PlayerFishEvent event) {
		Player player = event.getPlayer();
		
		if(Gadgets.getGadgetsExtras(1, player).equals(player.getItemInHand()))
			if(State.FAILED_ATTEMPT.equals(event.getState())) {
				player.setVelocity(event.getHook().getLocation().subtract(player.getLocation()).toVector().multiply(0.3).setY(1.2));
				new Items().setCooldownItem(player);
			}
	}
}
