package de.deda.lobby.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.deda.lobby.commands.BroadcastCommand;
import de.deda.lobby.commands.ChatClearCommand;
import de.deda.lobby.commands.ChatLogCommand;
import de.deda.lobby.commands.CoinsCommand;
import de.deda.lobby.commands.FlyCommand;
import de.deda.lobby.commands.GameModeCommand;
import de.deda.lobby.commands.ItemCommand;
import de.deda.lobby.commands.LobbyCommand;
import de.deda.lobby.commands.SetSpawnCommand;
import de.deda.lobby.commands.SpawnCommand;
import de.deda.lobby.commands.VanishCommand;
import de.deda.lobby.listener.EntityDamageByEntityListener;
import de.deda.lobby.listener.EntityDamageListener;
import de.deda.lobby.listener.EntityExplodeListener;
import de.deda.lobby.listener.InventoryClickListener;
import de.deda.lobby.listener.InventoryCloseListener;
import de.deda.lobby.listener.ProjectileLaunchHitListener;
import de.deda.lobby.listener.ServerListPingListener;
import de.deda.lobby.listener.WeatherChangeListener;
import de.deda.lobby.listener.player.PlayerBreakBlockListener;
import de.deda.lobby.listener.player.PlayerChatListener;
import de.deda.lobby.listener.player.PlayerDropItemListener;
import de.deda.lobby.listener.player.PlayerExpChangeListener;
import de.deda.lobby.listener.player.PlayerFishListener;
import de.deda.lobby.listener.player.PlayerFoodChangeListener;
import de.deda.lobby.listener.player.PlayerInteractListener;
import de.deda.lobby.listener.player.PlayerItemHeldListener;
import de.deda.lobby.listener.player.PlayerJoinListener;
import de.deda.lobby.listener.player.PlayerMoveListener;
import de.deda.lobby.listener.player.PlayerPickupItemListener;
import de.deda.lobby.listener.player.PlayerPlaceBlockListener;
import de.deda.lobby.listener.player.PlayerSneakListener;
import de.deda.lobby.listener.player.PlayerToggleFlightListener;
import de.deda.lobby.program.AutoMessages;
import de.deda.lobby.program.CreateFiles;
import de.deda.lobby.utils.mysql.MySQL;

public class Lobby extends JavaPlugin{

	private static Lobby plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		//Config
		saveDefaultConfig();
		new CreateFiles();
		
		//Database
		MySQL.connect();
		try {
			PreparedStatement coins = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS CoinsSystem (UUID VARCHAR(36),Coins INT(20))");
			coins.executeUpdate();
			PreparedStatement playerHider = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PlayerHider (UUID VARCHAR(36),ShowPlayer INT(1))");
			playerHider.executeUpdate();
			PreparedStatement settings = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Settings (UUID VARCHAR(36),Movement INT(1),SpawnPosition INT(1))");
			settings.executeUpdate();
			PreparedStatement shopHats = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ShopHats (UUID VARCHAR(36),Number1 INT(1),Number2 INT(1),Number3 INT(1),Number4 INT(1),Number5 INT(1),Number6 INT(1),Number7 INT(1),Number8 INT(1),Number9 INT(1),Number10 INT(1))");
			shopHats.executeUpdate();
			PreparedStatement shopHeads = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ShopHeads (UUID VARCHAR(36),Number1 INT(1),Number2 INT(1),Number3 INT(1),Number4 INT(1),Number5 INT(1),Number6 INT(1),Number7 INT(1),Number8 INT(1),Number9 INT(1),Number10 INT(1))");
			shopHeads.executeUpdate();
			PreparedStatement shopBoots = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ShopBoots (UUID VARCHAR(36),Number1 INT(1),Number2 INT(1),Number3 INT(1),Number4 INT(1),Number5 INT(1),Number6 INT(1),Number7 INT(1),Number8 INT(1),Number9 INT(1),Number10 INT(1))");
			shopBoots.executeUpdate();
			PreparedStatement shopExtras = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ShopExtras (UUID VARCHAR(36),Number1 INT(1),Number2 INT(1),Number3 INT(1),Number4 INT(1),Number5 INT(1),Number6 INT(1),Number7 INT(1),Number8 INT(1),Number9 INT(1),Number10 INT(1))");
			shopExtras.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Register Listeners
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerPlaceBlockListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerBreakBlockListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerPickupItemListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDropItemListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerExpChangeListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerFoodChangeListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerSneakListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerToggleFlightListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerFishListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerItemHeldListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDamageListener(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryCloseListener(), this);
		Bukkit.getPluginManager().registerEvents(new WeatherChangeListener(), this);
		Bukkit.getPluginManager().registerEvents(new ServerListPingListener(), this);
		Bukkit.getPluginManager().registerEvents(new ProjectileLaunchHitListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityExplodeListener(), this);
		
		//Register Commands
		getCommand("gm").setExecutor(new GameModeCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("chatclear").setExecutor(new ChatClearCommand());
		getCommand("chatlog").setExecutor(new ChatLogCommand());
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("coins").setExecutor(new CoinsCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("item").setExecutor(new ItemCommand());
		getCommand("ultimatelobby").setExecutor(new LobbyCommand());
		
		//Switch server
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		//Automessage
		AutoMessages autoMessage = new AutoMessages();
		autoMessage.sendAutoMessage();
	}
	
	@Override
	public void onDisable() {
		MySQL.disconnect();
	}

	public static Lobby getPlugin() {
		return plugin;
	}
}
