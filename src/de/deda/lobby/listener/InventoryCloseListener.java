package de.deda.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import de.deda.lobby.program.itemInventory.Navigator;

public class InventoryCloseListener implements Listener {

	@EventHandler
	public void onCloseInventory(InventoryCloseEvent event) {
		if(Navigator.navigatorEditModeSize9.equals(event.getInventory()))
			Navigator.setNavigatorConfigItems(event.getInventory());
		if(Navigator.navigatorEditModeSize18.equals(event.getInventory()))
			Navigator.setNavigatorConfigItems(event.getInventory());
		if(Navigator.navigatorEditModeSize27.equals(event.getInventory()))
			Navigator.setNavigatorConfigItems(event.getInventory());
		if(Navigator.navigatorEditModeSize36.equals(event.getInventory()))
			Navigator.setNavigatorConfigItems(event.getInventory());
		if(Navigator.navigatorEditModeSize45.equals(event.getInventory()))
			Navigator.setNavigatorConfigItems(event.getInventory());
		if(Navigator.navigatorEditModeSize54.equals(event.getInventory()))
			Navigator.setNavigatorConfigItems(event.getInventory());
		
		
		
	}
}
