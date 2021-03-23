package de.deda.lobby.program;

import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.scoreboard.RankPlayer;

public class AddRanks {

	public static RankPlayer getRankPlayer(final Player player) {
		ConfigManager config = new ConfigManager();
		
		ConfigurationSection cs = Variable.config.getConfigurationSection("TabList");
		Set<String> key = cs.getKeys(false);
		
		if(key == null) {
			return null;
		}
		Object[] keys = key.toArray();
		
		for(int i=0; i<key.size(); i++) {
			
			if(config.getString("TabList."+keys[i]+".prefix", Variable.config) != null && config.getString("TabList."+keys[i]+".perm", Variable.config) != null) {
				String perm = config.getString("TabList."+keys[i]+".perm", Variable.config);
				String prefix = config.getString("TabList."+keys[i]+".prefix", Variable.config);
				
				if(player.hasPermission(perm)) {
					return new RankPlayer(prefix, (String) keys[i]);
				}
			}
		}
		String basicPrefix = config.getString("TabList."+keys[keys.length-1]+".prefix", Variable.config);
		return new RankPlayer(basicPrefix, (String) keys[keys.length-1]);
	}
}
