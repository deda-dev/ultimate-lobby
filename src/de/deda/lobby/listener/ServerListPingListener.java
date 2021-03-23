package de.deda.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class ServerListPingListener implements Listener {

	@EventHandler
	public void onLiving(ServerListPingEvent event) {
		ConfigManager config = new ConfigManager();
		event.setMotd(config.getString("Motd.firstline", Variable.config)+"\n"+config.getString("Motd.secondline", Variable.config));
	}
}
