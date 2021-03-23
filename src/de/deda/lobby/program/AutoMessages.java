package de.deda.lobby.program;

import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.deda.lobby.main.Lobby;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class AutoMessages {
	private int messageId;
	
	public void sendAutoMessage() {
		ConfigManager config = new ConfigManager();
		if(config.getBoolean("Automessage.enabled", Variable.config))
			if(config.getString("Automessage.firstAutomessage", Variable.config) != null && 
				config.getString("Automessage.secondAutomessage", Variable.config) != null && 
				config.getString("Automessage.thirdAutomessage", Variable.config) != null) {
			
			Variable.autoMessage.put(1, config.getString("Automessage.firstAutomessage", Variable.config));
			Variable.autoMessage.put(2, config.getString("Automessage.secondAutomessage", Variable.config));
			Variable.autoMessage.put(3, config.getString("Automessage.thirdAutomessage", Variable.config));
			setMessageId(1);
			
			Bukkit.getScheduler().runTaskTimer(Lobby.getPlugin(), new Runnable() {
				
				@Override
				public void run() {
					for(Entry<Integer, String> i : Variable.autoMessage.entrySet()) {
						if(i.getKey() == getMessageId()) {
							String message = i.getValue();
							messageId++;
							for(Player online : Bukkit.getOnlinePlayers()) {
								online.sendMessage("");
								online.sendMessage(message);
								online.sendMessage("");
							}
							
							if(getMessageId() == Variable.autoMessage.size() + 1)
								setMessageId(1);
							break;
						}
					}
				}
			}, 0, config.getInt("Automessage.delay", Variable.config));
			
		} else if(config.getString("Automessage.firstAutomessage", Variable.config) != null && 
				config.getString("Automessage.secondAutomessage", Variable.config) != null) {
			
			Variable.autoMessage.put(1, config.getString("Automessage.firstAutomessage", Variable.config));
			Variable.autoMessage.put(2, config.getString("Automessage.secondAutomessage", Variable.config));
			setMessageId(1);
			
			Bukkit.getScheduler().runTaskTimer(Lobby.getPlugin(), new Runnable() {
				
				@Override
				public void run() {
					for(Entry<Integer, String> i : Variable.autoMessage.entrySet()) {
						if(i.getKey() == getMessageId()) {
							String message = i.getValue();
							messageId++;
							for(Player online : Bukkit.getOnlinePlayers()) {
								online.sendMessage("");
								online.sendMessage(message);
								online.sendMessage("");
							}
								
							if(getMessageId() == Variable.autoMessage.size() + 1)
								setMessageId(1);
							break;
						}
					}
				}
			}, 0, config.getInt("Automessage.delay", Variable.config));
			
		} else if(config.getString("Automessage.firstAutomessage", Variable.config) != null) {
			Bukkit.getScheduler().runTaskTimer(Lobby.getPlugin(), new Runnable() {
				
				@Override
				public void run() {
					for(Player online : Bukkit.getOnlinePlayers()) {
						online.sendMessage("");
						online.sendMessage(config.getString("Automessage.firstAutomessage", Variable.config));
						online.sendMessage("");
					}
				}
			}, 0, config.getInt("Automessage.delay", Variable.config));
			
		}
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
}
