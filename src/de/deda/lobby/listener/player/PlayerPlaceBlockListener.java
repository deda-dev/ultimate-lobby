package de.deda.lobby.listener.player;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.deda.lobby.commands.LobbyCommand;
import de.deda.lobby.listener.InventoryClickListener;
import de.deda.lobby.program.Items;

public class PlayerPlaceBlockListener implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		
		if(LobbyCommand.buildMode.contains(player.getUniqueId()))
			return;
		if(InventoryClickListener.extrasItem.containsKey(player.getUniqueId()) && InventoryClickListener.extrasItem.containsValue(4)) {
			event.getBlock().setType(Material.AIR);
			TNTPrimed tnt = (TNTPrimed) event.getBlock().getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.PRIMED_TNT);
			tnt.setIsIncendiary(false);
			tnt.setFuseTicks(40);
			new Items().setCooldownItem(player);
			return;
		}
		event.setBuild(false);
		event.setCancelled(true);
	}
}
