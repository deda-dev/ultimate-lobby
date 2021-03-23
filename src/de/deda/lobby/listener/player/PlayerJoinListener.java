package de.deda.lobby.listener.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;

import de.deda.lobby.main.Lobby;
import de.deda.lobby.program.Items;
import de.deda.lobby.program.itemInventory.Navigator;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.actionbar.ActionbarManager;
import de.deda.lobby.utils.mysql.MySQLCoins;
import de.deda.lobby.utils.mysql.MySQLPlayerHider;
import de.deda.lobby.utils.mysql.MySQLSettings;
import de.deda.lobby.utils.mysql.MySQLShopBoots;
import de.deda.lobby.utils.mysql.MySQLShopHats;
import de.deda.lobby.utils.mysql.MySQLShopHeads;
import de.deda.lobby.utils.scoreboard.Board;
import de.deda.lobby.utils.title.TitleAPI;

public class PlayerJoinListener implements Listener {
	
	public static List<UUID> doubleJump = new ArrayList<UUID>();
	private int actionbarId;
	private int bukkitIdTask;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		ConfigManager config = new ConfigManager();
		Items items = new Items();
		new Navigator();
		event.setJoinMessage(null);
		
		MySQLCoins.setPlayerIn(player.getUniqueId(), 0);
		MySQLPlayerHider.setPlayerIn(player.getUniqueId(), 0);
		MySQLSettings.setPlayerIn(player.getUniqueId(), 0);
		MySQLShopHats.setPlayerIn(player.getUniqueId(), 0);
		MySQLShopHeads.setPlayerIn(player.getUniqueId(), 0);
		MySQLShopBoots.setPlayerIn(player.getUniqueId(), 0);
		
		if(MySQLSettings.getMovement(player.getUniqueId()) == 1) {
			doubleJump.add(player.getUniqueId());
			player.setAllowFlight(true);
		}
		player.getInventory().clear();
		player.getInventory().setHelmet(new ItemStack(Material.AIR));
		player.getInventory().setChestplate(new ItemStack(Material.AIR));
		player.getInventory().setLeggings(new ItemStack(Material.AIR));
		player.getInventory().setBoots(new ItemStack(Material.AIR));
		player.setMaxHealth(config.getInt("Health", Variable.config));
		player.setHealth(config.getInt("Health", Variable.config));
		player.setFoodLevel(20);
		player.setLevel(config.getInt("ExpLevel", Variable.config));
		player.setExp(0);
		player.setGameMode(GameMode.SURVIVAL);
		items.setJoinItems(player);
		
		if(MySQLSettings.getSpawnPosition(player.getUniqueId()) == 0)
			player.teleport(config.getLocation("Spawn", Variable.locConfig));
		
		if(config.getBoolean("ClearChatAtJoin.enabled", Variable.config))
			for(int i = 0; i<150; i++)
				player.sendMessage("");
		
		int fadeIn = config.getInt("JoinTitle.fadeIn", Variable.config);
		int stay = config.getInt("JoinTitle.stay", Variable.config);
		int fadeOut = config.getInt("JoinTitle.fadeOut", Variable.config);
		
		if(config.getBoolean("JoinTitle.enabled", Variable.config))
			if(config.getString("JoinTitle.title", Variable.config) != null && config.getString("JoinTitle.subtitle", Variable.config) != null) {
				TitleAPI.sendTitle(player, fadeIn, stay, fadeOut, config.getAdvancedString("JoinTitle.title", player, Variable.config), config.getAdvancedString("JoinTitle.subtitle", player, Variable.config));
			} else if(config.getString("JoinTitle.title", Variable.config) != null)
				TitleAPI.sendTitle(player, fadeIn, stay, fadeOut, config.getAdvancedString("JoinTitle.title", player, Variable.config), null);
		
		if(config.getBoolean("TabTitle.Header.enabled", Variable.config) && config.getBoolean("TabTitle.Footer.enabled", Variable.config))
			if(config.getString("TabTitle.Header.header", Variable.config) != null && config.getString("TabTitle.Footer.footer", Variable.config) != null) {
				TitleAPI.sendTabTitle(player, config.getAdvancedString("TabTitle.Header.header", player, Variable.config), config.getAdvancedString("TabTitle.Footer.footer", player, Variable.config));
			} else if(config.getBoolean("TabTitle.Header.enabled", Variable.config)) {
				if(config.getString("TabTitle.Header.header", Variable.config) != null)
					TitleAPI.sendTabTitle(player, config.getAdvancedString("TabTitle.Header.header", player, Variable.config), null);
			} else if(config.getBoolean("TabTitle.Footer.enabled", Variable.config)) {
				if(config.getString("TabTitle.Footer.footer", Variable.config) != null)
					TitleAPI.sendTabTitle(player, null, config.getAdvancedString("TabTitle.Footer.footer", player, Variable.config));
			}
		
		Board.setBoard(player);
		Board.updateRank(player);
		
		if(config.getBoolean("Actionbar.enabled", Variable.config))
			if(config.getString("Actionbar.firstActionbar", Variable.config) != null && 
					config.getString("Actionbar.secondActionbar", Variable.config) != null && 
							config.getString("Actionbar.thirdActionbar", Variable.config) != null) {
				
				Variable.actionbar.put(1, config.getString("Actionbar.firstActionbar", Variable.config));
				Variable.actionbar.put(2, config.getString("Actionbar.secondActionbar", Variable.config));
				Variable.actionbar.put(3, config.getString("Actionbar.thirdActionbar", Variable.config));
				setActionbarId(1);
				
				Bukkit.getScheduler().runTaskTimer(Lobby.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						for(Entry<Integer, String> i : Variable.actionbar.entrySet()) {
							if(i.getKey() == getActionbarId()) {
								String message = i.getValue();
								actionbarId++;
								Bukkit.getScheduler().cancelTask(getBukkitIdTask());
								
								bukkitIdTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.getPlugin(), new Runnable() {
									
									@Override
									public void run() {
										ActionbarManager.sendActionBar(player, message);
									}
								}, 0, 20);
								if(getActionbarId() == Variable.autoMessage.size() + 1)
									setActionbarId(1);
								break;
							}
						}
					}
				}, 0, config.getInt("Actionbar.delay", Variable.config));
				
			} else if(config.getString("Actionbar.firstActionbar", Variable.config) != null && 
				config.getString("Actionbar.secondActionbar", Variable.config) != null) {
				
				Variable.actionbar.put(1, config.getString("Actionbar.firstActionbar", Variable.config));
				Variable.actionbar.put(2, config.getString("Actionbar.secondActionbar", Variable.config));
				setActionbarId(1);
				
				Bukkit.getScheduler().runTaskTimer(Lobby.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						for(Entry<Integer, String> i : Variable.actionbar.entrySet()) {
							if(i.getKey() == getActionbarId()) {
								String message = i.getValue();
								actionbarId++;
								Bukkit.getScheduler().cancelTask(getBukkitIdTask());
								
								bukkitIdTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.getPlugin(), new Runnable() {
									
									@Override
									public void run() {
										ActionbarManager.sendActionBar(player, message);
									}
								}, 0, 20);
								if(getActionbarId() == Variable.autoMessage.size() + 1)
									setActionbarId(1);
								break;
							}
						}
					}
				}, 0, config.getInt("Actionbar.delay", Variable.config));
					
			} else if(config.getString("Actionbar.firstActionbar", Variable.config) != null) {
				
				Bukkit.getScheduler().runTaskTimer(Lobby.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						Bukkit.getScheduler().cancelTask(getBukkitIdTask());
						
						bukkitIdTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.getPlugin(), new Runnable() {
							
							@Override
							public void run() {
								ActionbarManager.sendActionBar(player, config.getAdvancedString("Actionbar.firstActionbar", player, Variable.config));
							}
						}, 0, 20);
					}
				}, 0, config.getInt("Actionbar.delay", Variable.config));
			}
	}

	public int getActionbarId() {
		return actionbarId;
	}

	public void setActionbarId(int actionbarId) {
		this.actionbarId = actionbarId;
	}

	public int getBukkitIdTask() {
		return bukkitIdTask;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage(null);
		
		if(player.getScoreboard().getObjective(DisplaySlot.SIDEBAR) != null)
			player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).unregister();
		
		if(player.getScoreboard().getPlayerTeam(player) != null)
			player.getScoreboard().getPlayerTeam(player).removePlayer(player);
	}
	
}