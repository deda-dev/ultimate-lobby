package de.deda.lobby.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ConfigManager {

	public void setBoolean(Boolean enable, String path, YamlConfiguration config, File file) {
		config.set(path, enable);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setInt(int number, String path, YamlConfiguration config, File file) {
		config.set(path, number);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setString(String message, String path, YamlConfiguration config, File file) {
		config.set(path, message);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setLocation(Player player, String path, YamlConfiguration config, File file) {
		config.set(path+".World", player.getWorld().getName());
		config.set(path+".X", player.getLocation().getX());
		config.set(path+".Y", player.getLocation().getY());
		config.set(path+".Z", player.getLocation().getZ());
		config.set(path+".Yaw", player.getLocation().getYaw());
		config.set(path+".Pitch", player.getLocation().getPitch());
		
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean getBoolean(String path, YamlConfiguration config) {
		return config.getBoolean(path);
	}
	
	public String getSimpleString(String path, YamlConfiguration config) {
		return config.getString(path);
	}
	
	public String getString(String path, YamlConfiguration config) {
		if(config.getString(path) == null)
			return null;
		
		return config.getString(path)
				.replace("%PREFIX%", Variable.config.getString("Prefix"))
				.replace('&', '§');
	}
	
	public String getAdvancedString(String path, Player player, YamlConfiguration config) {
		if(config.getString(path) == null)
			return null;
		
		return config.getString(path)
				.replace("%PREFIX%", Variable.config.getString("Prefix"))
				.replace("%PLAYER%", player.getDisplayName())
				.replace('&', '§');
	}
	
	public String getCoinString(String path, String coins, Player player, YamlConfiguration config) {
		if(config.getString(path) == null)
			return null;
		
		return config.getString(path)
				.replace("%PREFIX%", Variable.config.getString("Prefix"))
				.replace("%PLAYER%", player.getDisplayName())
				.replace('&', '§')
				.replace("%COINS%", coins);
	}
	
	public String getMySQLString(String path, YamlConfiguration config) {
		if(config.getString(path) == null) {
			System.out.println("[UltimateLobby] MySQL error");
			return null;
		}
		
		return config.getString(path);
	}
	
	public String getNavigatorString(String path, YamlConfiguration config) {
		if(config.getString(path) == null)
			return "Change in the navigator menu";
		
		return config.getString(path);
	}
	
	public String getScoreBoardString(String path, String coins, String rank, Player player, YamlConfiguration config) {
		if(config.getString(path) == null)
			return null;
		
		return config.getString(path)
				.replace("%PREFIX%", Variable.config.getString("Prefix"))
				.replace("%PLAYER%", player.getDisplayName())
				.replace("%COINS%", coins)
				.replace("%RANK%", rank)
				.replace('&', '§');
	}
	
	public String getWrongCommandString(String path, String command, YamlConfiguration config) {
		if(config.getString(path) == null)
			return null;
		
		return config.getString(path)
				.replace("%PREFIX%", Variable.config.getString("Prefix"))
				.replace("%COMMAND%", command)
				.replace('&', '§');
	}
	
	public String getSkullString(String path, String material, Player player, YamlConfiguration config) {
		if(config.getString(path) == null)
			return null;
		
		return config.getString(path)
				.replace("%PREFIX%", Variable.config.getString("Prefix"))
				.replace("%PLAYERHEAD%", material)
				.replace('&', '§');
	}
	
	public String getBuyItemString(String path, String itemName, YamlConfiguration config) {
		if(config.getString(path) == null)
			return null;
		
		return config.getString(path)
				.replace("%PREFIX%", Variable.config.getString("Prefix"))
				.replace("%ITEM%", itemName)
				.replace('&', '§');
	}
	
	public int getInt(String path, YamlConfiguration config) {
		if(path == null)
			return 0;
		return config.getInt(path);
	}
	
	public int getNavigatorInt(String path, YamlConfiguration config) {
		if(path == null)
			return 9;
		return config.getInt(path);
	}
	
	public Location getLocation(String path, YamlConfiguration config) {
		World world = Bukkit.getWorld(config.getString(path+".World"));
		double x = config.getDouble(path+".X");
		double y = config.getDouble(path+".Y");
		double z = config.getDouble(path+".Z");
		float yaw = (float) config.getDouble(path+".Yaw");
		float pitch = (float) config.getDouble(path+".Pitch");
		
		return new Location(world, x, y, z, yaw, pitch);
	}
}