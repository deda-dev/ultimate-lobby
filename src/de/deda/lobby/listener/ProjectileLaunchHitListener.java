package de.deda.lobby.listener;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import de.deda.lobby.program.Items;

public class ProjectileLaunchHitListener implements Listener {

	@EventHandler
	public void onThrow(ProjectileLaunchEvent event) {
		Player player = (Player) event.getEntity().getShooter();
		
		if(InventoryClickListener.extrasItem.containsKey(player.getUniqueId()) && InventoryClickListener.extrasItem.containsValue(2))
			if(event.getEntityType() == EntityType.ENDER_PEARL) {
				event.getEntity().setPassenger(player);
				new Items().setCooldownItem(player);
			}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onThrowr(ProjectileHitEvent event) {
		Player player = (Player) event.getEntity().getShooter();
		
		if(InventoryClickListener.extrasItem.containsKey(player.getUniqueId()) && InventoryClickListener.extrasItem.containsValue(3))
			if(event.getEntityType() == EntityType.ARROW) {
				event.getEntity().getWorld().strikeLightningEffect(event.getEntity().getLocation());
				event.getEntity().remove();
				new Items().setCooldownItem(player);
			}
		if(InventoryClickListener.extrasItem.containsKey(player.getUniqueId()) && InventoryClickListener.extrasItem.containsValue(5))
			if(event.getEntityType() == EntityType.SNOWBALL) {
				int number = new Random().nextInt(5)+1;
				switch(number) {
				case 1:
					player.sendBlockChange(event.getEntity().getLocation(), Material.STAINED_CLAY, (byte) 14);
					break;
				case 2:
					player.sendBlockChange(event.getEntity().getLocation(), Material.STAINED_CLAY, (byte) 13);
					break;
				case 3:
					player.sendBlockChange(event.getEntity().getLocation(), Material.STAINED_CLAY, (byte) 4);
					break;
				case 4:
					player.sendBlockChange(event.getEntity().getLocation(), Material.STAINED_CLAY, (byte) 10);
					break;
				case 5:
					player.sendBlockChange(event.getEntity().getLocation(), Material.STAINED_CLAY, (byte) 11);
					break;
				default:
					break;
				}
				new Items().setCooldownItem(player);
			}
	}
}
