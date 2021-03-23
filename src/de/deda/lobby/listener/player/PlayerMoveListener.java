package de.deda.lobby.listener.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.deda.lobby.program.Particle;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class PlayerMoveListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		ConfigManager config = new ConfigManager();
		
		if(PlayerToggleFlightListener.doubleJumpCooldown.contains(player.getUniqueId())) {
			if(!player.isOnGround())
				return;
			player.setAllowFlight(true);
			PlayerToggleFlightListener.doubleJumpCooldown.remove(player.getUniqueId());
		}
		if(event.getFrom().getX() != event.getTo().getX() || 
				event.getFrom().getY() != event.getTo().getY() || 
				event.getFrom().getZ() != event.getTo().getZ()) {
			if(config.getBoolean("JumpPad.enabled", Variable.config)) {
				String matPlate = config.getSimpleString("JumpPad.blockTop.material", Variable.config);
				String matBlock = config.getSimpleString("JumpPad.blockBottom.material", Variable.config);
				if(Material.getMaterial(matPlate).equals(player.getLocation().getBlock().getType()))
					if(Material.getMaterial(matBlock).equals(player.getLocation().subtract(0, 1, 0).getBlock().getType()))
						player.setVelocity(player.getLocation().getDirection().multiply(4).setY(1.5));
			}
			if(config.getInt("Height.min", Variable.config) > player.getLocation().getY() || 
					config.getInt("Height.max", Variable.config) < player.getLocation().getY()) {
				if(config.getLocation("Spawn", Variable.locConfig) != null)
					player.teleport(config.getLocation("Spawn", Variable.locConfig));
			}
			if(player.getInventory().getBoots() != null)
				if(config.getString("Shop.Boots.1.bought.name", Variable.shopConfig).equals(player.getInventory().getBoots().getItemMeta().getDisplayName())) {
					Particle.sendBootsEffect(player, 1);
				} else if(config.getString("Shop.Boots.2.bought.name", Variable.shopConfig).equals(player.getInventory().getBoots().getItemMeta().getDisplayName())) {
					Particle.sendBootsEffect(player, 2);
				} else if(config.getString("Shop.Boots.3.bought.name", Variable.shopConfig).equals(player.getInventory().getBoots().getItemMeta().getDisplayName())) {
					Particle.sendBootsEffect(player, 3);
				} else if(config.getString("Shop.Boots.4.bought.name", Variable.shopConfig).equals(player.getInventory().getBoots().getItemMeta().getDisplayName())) {
					Particle.sendBootsEffect(player, 4);
				} else if(config.getString("Shop.Boots.5.bought.name", Variable.shopConfig).equals(player.getInventory().getBoots().getItemMeta().getDisplayName())) {
					Particle.sendBootsEffect(player, 5);
				} else if(config.getString("Shop.Boots.6.bought.name", Variable.shopConfig).equals(player.getInventory().getBoots().getItemMeta().getDisplayName())) {
					Particle.sendBootsEffect(player, 6);
				} else if(config.getString("Shop.Boots.7.bought.name", Variable.shopConfig).equals(player.getInventory().getBoots().getItemMeta().getDisplayName())) {
					Particle.sendBootsEffect(player, 7);
				} else if(config.getString("Shop.Boots.8.bought.name", Variable.shopConfig).equals(player.getInventory().getBoots().getItemMeta().getDisplayName())) {
					Particle.sendBootsEffect(player, 8);
				}
		}
	}
}
