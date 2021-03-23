package de.deda.lobby.utils;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;

import de.deda.lobby.main.Lobby;

public class Variable {
	
	public static File interactItemsFolderFile = new File("plugins//UltimateLobby//ManageItems");
	
	public static File file = Lobby.getPlugin().getDataFolder();
	public static YamlConfiguration config = (YamlConfiguration) Lobby.getPlugin().getConfig();
	
	public static File fileF = new File("plugins//UltimateLobby//config.yml");
	public static YamlConfiguration configC = YamlConfiguration.loadConfiguration(file);
	public static File locFile = new File("plugins//UltimateLobby//locations.yml");
	public static YamlConfiguration locConfig = YamlConfiguration.loadConfiguration(locFile);
	public static File mysqlFile = new File("plugins//UltimateLobby//mysql.yml");
	public static YamlConfiguration mysqlConfig = YamlConfiguration.loadConfiguration(mysqlFile);
	public static File cmdFile = new File("plugins//UltimateLobby//commands.yml");
	public static YamlConfiguration cmdConfig = YamlConfiguration.loadConfiguration(cmdFile);
	public static File itemFile = new File("plugins//UltimateLobby//items.yml");
	public static YamlConfiguration itemConfig = YamlConfiguration.loadConfiguration(itemFile);
	public static File teamServerFile = new File("plugins//UltimateLobby//ManageItems//teamServer.yml");
	public static YamlConfiguration teamServerConfig = YamlConfiguration.loadConfiguration(teamServerFile);
	public static File playerHiderFile = new File("plugins//UltimateLobby//ManageItems//playerHider.yml");
	public static YamlConfiguration playerHiderConfig = YamlConfiguration.loadConfiguration(playerHiderFile);
	public static File lobbySwitcherFile = new File("plugins//UltimateLobby//ManageItems//lobbySwitcher.yml");
	public static YamlConfiguration lobbySwitcherConfig = YamlConfiguration.loadConfiguration(lobbySwitcherFile);
	public static File settingsFile = new File("plugins//UltimateLobby//ManageItems//settings.yml");
	public static YamlConfiguration settingsConfig = YamlConfiguration.loadConfiguration(settingsFile);
	public static File gadgetsFile = new File("plugins//UltimateLobby//ManageItems//gadgets.yml");
	public static YamlConfiguration gadgetsConfig = YamlConfiguration.loadConfiguration(gadgetsFile);
	public static File shopFile = new File("plugins//UltimateLobby//shop.yml");
	public static YamlConfiguration shopConfig = YamlConfiguration.loadConfiguration(shopFile);
	public static File navigatorFile = new File("plugins//UltimateLobby//ManageItems//navigator.yml");
	public static YamlConfiguration navigatorConfig = YamlConfiguration.loadConfiguration(navigatorFile);
	
	public static HashMap<Integer, String> actionbar = new HashMap<Integer, String>();
	public static HashMap<Integer, String> autoMessage = new HashMap<Integer, String>();
}
