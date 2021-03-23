package de.deda.lobby.listener.player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import de.deda.lobby.commands.FlyCommand;

public class PlayerToggleFlightListener implements Listener {

	public static List<UUID> doubleJumpCooldown = new ArrayList<UUID>();
	
	@EventHandler
	public void onFlight(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		
		if(player.getGameMode() != GameMode.SURVIVAL && player.getGameMode() != GameMode.ADVENTURE)
			return;
		if(FlyCommand.fly.contains(player.getUniqueId()))
			return;
		if(!PlayerJoinListener.doubleJump.contains(player.getUniqueId())) {
			player.setAllowFlight(false);
			event.setCancelled(true);
			return;
		}
		if(!event.isFlying())
			return;
		player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 5, 1);
		player.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
		doubleJumpCooldown.add(player.getUniqueId());
		player.setAllowFlight(false);
		event.setCancelled(true);
	}
}
