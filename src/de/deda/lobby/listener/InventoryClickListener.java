package de.deda.lobby.listener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.deda.lobby.commands.FlyCommand;
import de.deda.lobby.commands.LobbyCommand;
import de.deda.lobby.main.Lobby;
import de.deda.lobby.program.Items;
import de.deda.lobby.program.itemInventory.Gadgets;
import de.deda.lobby.program.itemInventory.LobbySwitcher;
import de.deda.lobby.program.itemInventory.Navigator;
import de.deda.lobby.program.itemInventory.PlayerHider;
import de.deda.lobby.program.itemInventory.Settings;
import de.deda.lobby.program.itemInventory.TeamServer;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;
import de.deda.lobby.utils.mysql.MySQLCoins;
import de.deda.lobby.utils.mysql.MySQLPlayerHider;
import de.deda.lobby.utils.mysql.MySQLSettings;
import de.deda.lobby.utils.mysql.MySQLShopBoots;
import de.deda.lobby.utils.mysql.MySQLShopExtras;
import de.deda.lobby.utils.mysql.MySQLShopHats;
import de.deda.lobby.utils.mysql.MySQLShopHeads;
import de.deda.lobby.utils.scoreboard.Board;

public class InventoryClickListener implements Listener {

	public static Map<UUID, String> buyItem = new HashMap<>();
	public static Map<UUID, Integer> extrasItem = new HashMap<>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ConfigManager config = new ConfigManager();
		Items items = new Items();
		
		if(!LobbyCommand.buildMode.contains(player.getUniqueId()))
			event.setCancelled(true);
		
		try {
			//Team Server Inventory
			if(event.getInventory().equals(TeamServer.teamServerInv)) {
				event.setCancelled(true);
				if(event.getCurrentItem().equals(TeamServer.getTeamServerItem("first"))) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					
					try {
						out.writeUTF("Connect");
						out.writeUTF(config.getSimpleString("TeamServer.firstSlot.server", Variable.teamServerConfig));
					} catch(IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("§cConnecting to server...");
					player.sendPluginMessage(Lobby.getPlugin(), "BungeeCord", b.toByteArray());
					return;
					
				}
				if(event.getCurrentItem().equals(TeamServer.getTeamServerItem("second"))) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					
					try {
						out.writeUTF("Connect");
						out.writeUTF(config.getSimpleString("TeamServer.secondSlot.server", Variable.teamServerConfig));
					} catch(IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("§cConnecting to server...");
					player.sendPluginMessage(Lobby.getPlugin(), "BungeeCord", b.toByteArray());
					return;
					
				}
				if(event.getCurrentItem().equals(TeamServer.getTeamServerItem("third"))) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					
					try {
						out.writeUTF("Connect");
						out.writeUTF(config.getSimpleString("TeamServer.thirdSlot.server", Variable.teamServerConfig));
					} catch(IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("§cConnecting to server...");
					player.sendPluginMessage(Lobby.getPlugin(), "teamServerThird", b.toByteArray());
					return;
					
				}
			}
			//Player Hider Inventory
			if(event.getInventory().equals(PlayerHider.playerHiderInv)) {
				event.setCancelled(true);
				PotionEffect blindness = new PotionEffect(PotionEffectType.BLINDNESS, 20, 0, false, false);
				if(event.getCurrentItem().equals(PlayerHider.getTeamServerItem("show", player))) {
					for(Player all : Bukkit.getOnlinePlayers())
						player.showPlayer(all);
					player.closeInventory();
					if(config.getBoolean("PlayerHider.sound", Variable.playerHiderConfig))
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 3);
					if(config.getBoolean("PlayerHider.effect", Variable.playerHiderConfig))
						player.addPotionEffect(blindness);
					MySQLPlayerHider.setShowPlayer(player, player.getUniqueId(), 0);
					return;
					
				}
				if(event.getCurrentItem().equals(PlayerHider.getTeamServerItem("member", player))) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						player.hidePlayer(all);
						if(all.hasPermission("lobby.member") || all.hasPermission("lobby.*"))
							player.showPlayer(all);
					}
					player.closeInventory();
					if(config.getBoolean("PlayerHider.sound", Variable.playerHiderConfig))
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 3);
					if(config.getBoolean("PlayerHider.effect", Variable.playerHiderConfig))
						player.addPotionEffect(blindness);
					MySQLPlayerHider.setShowPlayer(player, player.getUniqueId(), 1);
					return;
					
				}
				if(event.getCurrentItem().equals(PlayerHider.getTeamServerItem("hide", player))) {
					for(Player all : Bukkit.getOnlinePlayers())
						player.hidePlayer(all);
					player.closeInventory();
					if(config.getBoolean("PlayerHider.sound", Variable.playerHiderConfig))
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 3);
					if(config.getBoolean("PlayerHider.effect", Variable.playerHiderConfig))
						player.addPotionEffect(blindness);
					MySQLPlayerHider.setShowPlayer(player, player.getUniqueId(), 2);
					return;
				}
			}
			//Lobby Switcher
			if(event.getInventory().equals(LobbySwitcher.lobbySwitcherInv)) {
				event.setCancelled(true);
				if(event.getCurrentItem().equals(LobbySwitcher.getTeamServerItem("lobby1"))) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					
					try {
						out.writeUTF("Connect");
						out.writeUTF(config.getSimpleString("LobbySwitcher.lobby.1.server", Variable.lobbySwitcherConfig));
					} catch(IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("§cConnecting to server...");
					player.sendPluginMessage(Lobby.getPlugin(), "BungeeCord", b.toByteArray());
					return;
					
				}
				if(event.getCurrentItem().equals(LobbySwitcher.getTeamServerItem("lobby2"))) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					
					try {
						out.writeUTF("Connect");
						out.writeUTF(config.getSimpleString("LobbySwitcher.lobby.2.server", Variable.lobbySwitcherConfig));
					} catch(IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("§cConnecting to server...");
					player.sendPluginMessage(Lobby.getPlugin(), "BungeeCord", b.toByteArray());
					return;
					
				}
				if(event.getCurrentItem().equals(LobbySwitcher.getTeamServerItem("lobby3"))) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					
					try {
						out.writeUTF("Connect");
						out.writeUTF(config.getSimpleString("LobbySwitcher.lobby.3.server", Variable.lobbySwitcherConfig));
					} catch(IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("§cConnecting to server...");
					player.sendPluginMessage(Lobby.getPlugin(), "BungeeCord", b.toByteArray());
					return;
					
				}
				if(event.getCurrentItem().equals(LobbySwitcher.getTeamServerItem("lobby4"))) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					
					try {
						out.writeUTF("Connect");
						out.writeUTF(config.getSimpleString("LobbySwitcher.lobby.4.server", Variable.lobbySwitcherConfig));
					} catch(IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("§cConnecting to server...");
					player.sendPluginMessage(Lobby.getPlugin(), "BungeeCord", b.toByteArray());
					return;
					
				}
				if(event.getCurrentItem().equals(LobbySwitcher.getTeamServerItem("lobby5"))) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					
					try {
						out.writeUTF("Connect");
						out.writeUTF(config.getSimpleString("LobbySwitcher.lobby.5.server", Variable.lobbySwitcherConfig));
					} catch(IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("§cConnecting to server...");
					player.sendPluginMessage(Lobby.getPlugin(), "BungeeCord", b.toByteArray());
					return;
					
				}
				if(event.getCurrentItem().equals(LobbySwitcher.getTeamServerItem("premlobby"))) {
					if(player.hasPermission("lobby.premlobby") || player.hasPermission("lobby.*")) {
						ByteArrayOutputStream b = new ByteArrayOutputStream();
						DataOutputStream out = new DataOutputStream(b);
						
						try {
							out.writeUTF("Connect");
							out.writeUTF(config.getSimpleString("LobbySwitcher.premLobby.server", Variable.lobbySwitcherConfig));
						} catch(IOException e) {
							e.printStackTrace();
						}
						player.sendMessage("§cConnecting to server...");
						player.sendPluginMessage(Lobby.getPlugin(), "BungeeCord", b.toByteArray());
						return;
					}
					player.sendMessage(config.getString("NoPerms", Variable.config));
				}
			}
			//Settings
			if(event.getInventory().equals(Settings.settingsInv)) {
				event.setCancelled(true);
				if(event.getCurrentItem().getType().equals(Settings.getSettingsItem("friends", player).getType())) {
					if(config.getBoolean("Settings.sound", Variable.settingsConfig))
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
					player.performCommand(config.getSimpleString("Settings.friends.command", Variable.settingsConfig));
					player.closeInventory();
				}
				if(event.getCurrentItem().equals(Settings.getSettingsItem("movement", player))) {
					if(config.getBoolean("Settings.sound", Variable.settingsConfig))
						player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
					Settings.openMovementInv(player);
				}
				if(event.getCurrentItem().equals(Settings.getSettingsItem("spawnPosition", player))) {
					if(config.getBoolean("Settings.sound", Variable.settingsConfig))
						player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
					Settings.openSpawnPositionInv(player);
				}
			}
			//Movement
			if(event.getInventory().equals(Settings.movementInv)) {
				event.setCancelled(true);
				if(event.getCurrentItem().equals(Settings.getMovementItem("walk", player))) {
					if(MySQLSettings.getMovement(player.getUniqueId()) == 1) {
						MySQLSettings.setMovement(player, player.getUniqueId(), 0);
						if(config.getBoolean("Settings.sound", Variable.settingsConfig))
							player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
						if(config.getBoolean("Settings.effect", Variable.settingsConfig))
							for(int i=0; i<150;i++)
								player.playEffect(player.getLocation(), Effect.INSTANT_SPELL, 1);
						if(FlyCommand.fly.contains(player.getUniqueId())) {
							player.setAllowFlight(true);
						} else
							player.setAllowFlight(false);
						player.closeInventory();
					}
				}
				if(event.getCurrentItem().equals(Settings.getMovementItem("doublejump", player))) {
					if(MySQLSettings.getMovement(player.getUniqueId()) == 0) {
						MySQLSettings.setMovement(player, player.getUniqueId(), 1);
						LobbyCommand.buildMode.add(player.getUniqueId());
						if(config.getBoolean("Settings.sound", Variable.settingsConfig))
							player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
						if(config.getBoolean("Settings.effect", Variable.settingsConfig))
							for(int i=0; i<150;i++)
								player.playEffect(player.getLocation(), Effect.INSTANT_SPELL, 1);
						player.setAllowFlight(true);
						player.closeInventory();
					}
				}
			}
			//Spawn Position
			if(event.getInventory().equals(Settings.spawnPositionInv)) {
				event.setCancelled(true);
				if(event.getCurrentItem().equals(Settings.getSpawnPositionItem("lastPosition", player))) {
					if(MySQLSettings.getSpawnPosition(player.getUniqueId()) == 0) {
						MySQLSettings.setSpawnPosition(player, player.getUniqueId(), 1);
						if(config.getBoolean("Settings.sound", Variable.settingsConfig))
							player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
						if(config.getBoolean("Settings.effect", Variable.settingsConfig))
							for(int i=0; i<150;i++)
								player.playEffect(player.getLocation(), Effect.INSTANT_SPELL, 1);
						player.closeInventory();
					}
				}
				if(event.getCurrentItem().equals(Settings.getSpawnPositionItem("spawnPosition", player))) {
					if(MySQLSettings.getSpawnPosition(player.getUniqueId()) == 1) {
						MySQLSettings.setSpawnPosition(player, player.getUniqueId(), 0);
						if(config.getBoolean("Settings.sound", Variable.settingsConfig))
							player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
						if(config.getBoolean("Settings.effect", Variable.settingsConfig))
							for(int i=0; i<150;i++)
								player.playEffect(player.getLocation(), Effect.INSTANT_SPELL, 1);
						player.closeInventory();
					}
				}
			}
			//Gadgets
			//Hats inventory
			if(event.getInventory().equals(Gadgets.gadgetsHatInv)) {
				event.setCancelled(true);
				if(event.getSlot() == 18 || event.getSlot() == 19)
					Gadgets.openGadgetsHeadInv(player);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("boots", player)) || event.getSlot() == 28)
					Gadgets.openGadgetsBootInv(player);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("extras", player)) || event.getSlot() == 37)
					Gadgets.openGadgetsExtraInv(player);
				if(event.getCurrentItem().getType() == Material.BARRIER && "§4§lRemove item".equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName()))
					if(player.getInventory().getHelmet().getType() != Material.SKULL_ITEM) {
						player.getInventory().setHelmet(new ItemStack(Material.AIR));
						player.closeInventory();
					}
				if(event.getCurrentItem().getType() == Material.BARRIER && "§4§lRemove all items".equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
					player.getInventory().setHelmet(new ItemStack(Material.AIR));
					player.getInventory().setBoots(new ItemStack(Material.AIR));
					player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, items.getJoinItems("noneselectedgadget"));
					player.closeInventory();
					removeExtrasItemHashMap(player);
				}
					
				for(int i=1;i<11;i++)
					if(event.getCurrentItem().equals(Gadgets.getGadgetsHats(i, player)))
						if(player.hasPermission("lobby.*") || MySQLShopHats.getBoughtItem(player.getUniqueId(), i) == 1) {
							player.getInventory().setHelmet(Gadgets.getGadgetsHats(i, player));
							player.closeInventory();
							if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
								player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
							return;
						} else {
							buyItem.put(player.getUniqueId(), "hats_"+i);
							Gadgets.openBuyItemInv(player);
							return;
						}
				return;
			}
			//Heads inventory
			if(event.getInventory().equals(Gadgets.gadgetsHeadsInv)) {
				event.setCancelled(true);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("hats", player)) || event.getSlot() == 10)
					Gadgets.openGadgetsHatInv(player);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("boots", player)) || event.getSlot() == 28)
					Gadgets.openGadgetsBootInv(player);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("extras", player)) || event.getSlot() == 37)
					Gadgets.openGadgetsExtraInv(player);
				if(event.getCurrentItem().getType() == Material.BARRIER && "§4§lRemove item".equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName()))
					if(player.getInventory().getHelmet().getType() == Material.SKULL_ITEM) {
						player.getInventory().setHelmet(new ItemStack(Material.AIR));
						player.closeInventory();
					}
				if(event.getCurrentItem().getType() == Material.BARRIER && "§4§lRemove all items".equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
					player.getInventory().setHelmet(new ItemStack(Material.AIR));
					player.getInventory().setBoots(new ItemStack(Material.AIR));
					player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, items.getJoinItems("noneselectedgadget"));
					player.closeInventory();
					removeExtrasItemHashMap(player);
				}
				
				for(int i=1;i<11;i++)
					if(Gadgets.getGadgetsHeads(i, player).getItemMeta().getDisplayName().equals(event.getCurrentItem().getItemMeta().getDisplayName()))
						if(player.hasPermission("lobby.*") || MySQLShopHeads.getBoughtItem(player.getUniqueId(), i) == 1) {
							player.getInventory().setHelmet(Gadgets.getGadgetsHeads(i, player));
							player.closeInventory();
							if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
								player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
							return;
						} else {
							buyItem.put(player.getUniqueId(), "heads_"+i);
							Gadgets.openBuyItemInv(player);
							return;
						}
				return;
			}
			//Boots inventory
			if(event.getInventory().equals(Gadgets.gadgetsBootsInv)) {
				event.setCancelled(true);
				if(event.getSlot() == 18 || event.getSlot() == 19)
					Gadgets.openGadgetsHeadInv(player);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("hats", player)) || event.getSlot() == 10)
					Gadgets.openGadgetsHatInv(player);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("extras", player)) || event.getSlot() == 37)
					Gadgets.openGadgetsExtraInv(player);
				if(event.getCurrentItem().getType() == Material.BARRIER && "§4§lRemove item".equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName()))
					if(player.getInventory().getBoots() != null) {
						player.getInventory().setBoots(new ItemStack(Material.AIR));
						player.closeInventory();
					}
				if(event.getCurrentItem().getType() == Material.BARRIER && "§4§lRemove all items".equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
					player.getInventory().setHelmet(new ItemStack(Material.AIR));
					player.getInventory().setBoots(new ItemStack(Material.AIR));
					player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, items.getJoinItems("noneselectedgadget"));
					player.closeInventory();
					removeExtrasItemHashMap(player);
				}
				for(int i=1;i<11;i++)
					if(Gadgets.getGadgetsBoots(i, player).getItemMeta().getDisplayName().equals(event.getCurrentItem().getItemMeta().getDisplayName()))
						if(player.hasPermission("lobby.*") || MySQLShopBoots.getBoughtItem(player.getUniqueId(), i) == 1) {
							player.getInventory().setBoots(Gadgets.getGadgetsBoots(i, player));
							player.closeInventory();
							if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
								player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
							return;
						} else {
							if(Material.BARRIER.equals(event.getCurrentItem().getType()))
								return;
							buyItem.put(player.getUniqueId(), "boots_"+i);
							Gadgets.openBuyItemInv(player);
							return;
						}
				return;
			}
			//Extras inventory
			if(event.getInventory().equals(Gadgets.gadgetsExtrasInv)) {
				event.setCancelled(true);
				if(event.getSlot() == 18 || event.getSlot() == 19)
					Gadgets.openGadgetsHeadInv(player);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("boots", player)) || event.getSlot() == 28)
					Gadgets.openGadgetsBootInv(player);
				if(event.getCurrentItem().equals(Gadgets.getGadgetsItem("hats", player)) || event.getSlot() == 10)
					Gadgets.openGadgetsHatInv(player);
				if(event.getCurrentItem().getType() == Material.BARRIER && "§4§lRemove item".equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName()))
					if(player.getInventory().getItem(2).getType() != Material.BARRIER) {
						player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, items.getJoinItems("noneselectedgadget"));
						player.closeInventory();
						removeExtrasItemHashMap(player);
					}
				if(event.getCurrentItem().getType() == Material.BARRIER && "§4§lRemove all items".equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
					player.getInventory().setHelmet(new ItemStack(Material.AIR));
					player.getInventory().setBoots(new ItemStack(Material.AIR));
					player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, items.getJoinItems("noneselectedgadget"));
					player.closeInventory();
					removeExtrasItemHashMap(player);
				}
				for(int i=1;i<11;i++)
					if(Gadgets.getGadgetsExtras(i, player).getItemMeta().getDisplayName().equals(event.getCurrentItem().getItemMeta().getDisplayName()))
						if(player.hasPermission("lobby.*") || MySQLShopExtras.getBoughtItem(player.getUniqueId(), i) == 1) {
							removeExtrasItemHashMap(player);
							extrasItem.put(player.getUniqueId(), i);
							player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(i, player));
							player.closeInventory();
							if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
								player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
							return;
						} else {
							if(Material.BARRIER.equals(event.getCurrentItem().getType()))
								return;
							buyItem.put(player.getUniqueId(), "extras_"+i);
							Gadgets.openBuyItemInv(player);
							return;
						}
				return;
			}
			if(event.getInventory().equals(Gadgets.buyItemInv)) {
				event.setCancelled(true);
				for(int i=1;i<11;i++)
					//Buy hats
					if(buyItem.containsKey(player.getUniqueId()) && buyItem.containsValue("hats_"+i)) {
						if(event.getSlot() == 2 && event.getCurrentItem().getType() == Material.INK_SACK) {
							if(MySQLCoins.getCoins(player.getUniqueId()) >= config.getInt("Shop.Hats."+i+".price", Variable.shopConfig)) {
								MySQLCoins.Update(player.getUniqueId(), config.getInt("Shop.Hats."+i+".price", Variable.shopConfig), true);
								Board.setBoard(player);
								Board.updateRank(player);
								MySQLShopHats.setBoughtItem(player.getUniqueId(), i, 1);
								buyItem.remove(player.getUniqueId(), "hats_"+i);
								
								player.sendMessage(config.getBuyItemString("Shop.messages.buy", config.getSimpleString("Shop.Hats."+i+".material", Variable.shopConfig), Variable.shopConfig));
								if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
									player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
								player.closeInventory();
								return;
							} else
								player.sendMessage(config.getString("Shop.messages.notEnoughMoney", Variable.shopConfig));
						} else
							if(event.getSlot() == 6 && event.getCurrentItem().getType() == Material.INK_SACK) {
								if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
									player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
								buyItem.remove(player.getUniqueId(), "hats_"+i);
								Gadgets.openGadgetsHatInv(player);
							}
					//Buy Heads
					} else if(buyItem.containsKey(player.getUniqueId()) && buyItem.containsValue("heads_"+i)) {
						if(event.getSlot() == 2 && event.getCurrentItem().getType() == Material.INK_SACK) {
							if(MySQLCoins.getCoins(player.getUniqueId()) >= config.getInt("Shop.Heads."+i+".price", Variable.shopConfig)) {
								MySQLCoins.Update(player.getUniqueId(), config.getInt("Shop.Heads."+i+".price", Variable.shopConfig), true);
								Board.setBoard(player);
								Board.updateRank(player);
								MySQLShopHeads.setBoughtItem(player.getUniqueId(), i, 1);
								buyItem.remove(player.getUniqueId(), "heads_"+i);
											
								player.sendMessage(config.getBuyItemString("Shop.messages.buy", config.getSimpleString("Shop.Heads."+i+".headOwner", Variable.shopConfig), Variable.shopConfig));
								if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
									player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
								player.closeInventory();
								return;
							} else
								player.sendMessage(config.getString("Shop.messages.notEnoughMoney", Variable.shopConfig));
						} else
							if(event.getSlot() == 6 && event.getCurrentItem().getType() == Material.INK_SACK) {
								if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
									player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
								buyItem.remove(player.getUniqueId(), "heads_"+i);
								Gadgets.openGadgetsHeadInv(player);
							}
					//Buy boots
					} else if(buyItem.containsKey(player.getUniqueId()) && buyItem.containsValue("boots_"+i)) {
						if(event.getSlot() == 2 && event.getCurrentItem().getType() == Material.INK_SACK) {
							if(MySQLCoins.getCoins(player.getUniqueId()) >= config.getInt("Shop.Boots."+i+".price", Variable.shopConfig)) {
								MySQLCoins.Update(player.getUniqueId(), config.getInt("Shop.Boots."+i+".price", Variable.shopConfig), true);
								Board.setBoard(player);
								Board.updateRank(player);
								MySQLShopBoots.setBoughtItem(player.getUniqueId(), i, 1);
								buyItem.remove(player.getUniqueId(), "boots_"+i);
											
								player.sendMessage(config.getBuyItemString("Shop.messages.buy", config.getSimpleString("Shop.Boots."+i+".bought.name", Variable.shopConfig), Variable.shopConfig));
								if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
									player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
								player.closeInventory();
								return;
							} else
								player.sendMessage(config.getString("Shop.messages.notEnoughMoney", Variable.shopConfig));
						} else
							if(event.getSlot() == 6 && event.getCurrentItem().getType() == Material.INK_SACK) {
								if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
									player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
								buyItem.remove(player.getUniqueId(), "boots_"+i);
								Gadgets.openGadgetsBootInv(player);
							}
					//Buy extras
					} else if(buyItem.containsKey(player.getUniqueId()) && buyItem.containsValue("extras_"+i)) {
						if(event.getSlot() == 2 && event.getCurrentItem().getType() == Material.INK_SACK) {
							if(MySQLCoins.getCoins(player.getUniqueId()) >= config.getInt("Shop.Extras."+i+".price", Variable.shopConfig)) {
								MySQLCoins.Update(player.getUniqueId(), config.getInt("Shop.Extras."+i+".price", Variable.shopConfig), true);
								Board.setBoard(player);
								Board.updateRank(player);
								MySQLShopExtras.setBoughtItem(player.getUniqueId(), i, 1);
								buyItem.remove(player.getUniqueId(), "extras_"+i);
											
								player.sendMessage(config.getBuyItemString("Shop.messages.buy", config.getSimpleString("Shop.Extras."+i+".bought.name", Variable.shopConfig), Variable.shopConfig));
								if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
									player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
								player.closeInventory();
								return;
							} else
								player.sendMessage(config.getString("Shop.messages.notEnoughMoney", Variable.shopConfig));
						} else
							if(event.getSlot() == 6 && event.getCurrentItem().getType() == Material.INK_SACK) {
								if(config.getBoolean("Gadgets.sound", Variable.gadgetsConfig))
									player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
								buyItem.remove(player.getUniqueId(), "extras_"+i);
								Gadgets.openGadgetsExtraInv(player);
							}
					}
				return;
			}
			if(event.getInventory().equals(Navigator.navigatorMenu)) {
				event.setCancelled(true);
				if(Material.BOOK == event.getCurrentItem().getType())
					Navigator.openNavigatorInvSize(player);
				if(Material.COMPASS == event.getCurrentItem().getType())
					Navigator.openNavigatorEditMode(player);
				if(Material.PAPER == event.getCurrentItem().getType()) {
					Navigator.setNavigatorTitle.add(player.getUniqueId());
					player.sendMessage("§4§lWrite the navigator title in the chat.");
					player.closeInventory();
				}
				
				return;
			}
			if(event.getInventory().equals(Navigator.navigatorInvSize)) {
				event.setCancelled(true);
				if("§f§l9 Slots" == event.getCurrentItem().getItemMeta().getDisplayName()) {
					config.setInt(9, "Navigator.inventorySize", Variable.navigatorConfig, Variable.navigatorFile);
					player.closeInventory();
					return;
				} else if("§f§l18 Slots" == event.getCurrentItem().getItemMeta().getDisplayName()) {
					config.setInt(18, "Navigator.inventorySize", Variable.navigatorConfig, Variable.navigatorFile);
					player.closeInventory();
					return;
				} else if("§f§l27 Slots" == event.getCurrentItem().getItemMeta().getDisplayName()) {
					config.setInt(27, "Navigator.inventorySize", Variable.navigatorConfig, Variable.navigatorFile);
					player.closeInventory();
					return;
				} else if("§f§l36 Slots" == event.getCurrentItem().getItemMeta().getDisplayName()) {
					config.setInt(36, "Navigator.inventorySize", Variable.navigatorConfig, Variable.navigatorFile);
					player.closeInventory();
					return;
				} else if("§f§l45 Slots" == event.getCurrentItem().getItemMeta().getDisplayName()) {
					config.setInt(45, "Navigator.inventorySize", Variable.navigatorConfig, Variable.navigatorFile);
					player.closeInventory();
					return;
				} else if("§f§l54 Slots" == event.getCurrentItem().getItemMeta().getDisplayName()) {
					config.setInt(54, "Navigator.inventorySize", Variable.navigatorConfig, Variable.navigatorFile);
					player.closeInventory();
					return;
				}
				
				return;
			}
			if(Navigator.navigatorItemClickEditMode.equals(event.getClickedInventory())) {
				if(Material.ENDER_PEARL.equals(event.getCurrentItem().getType())) {
					config.setLocation(player, "Navigator."+Navigator.navigatorItemClickEditMode.getItem(1).getAmount()+".action.teleport", Variable.navigatorConfig, Variable.navigatorFile);
					player.closeInventory();
				}
				if(Material.NOTE_BLOCK.equals(event.getCurrentItem().getType())) {
					Navigator.openNavigatorAddItemSoundInventory(player);
					Navigator.navigatorClickItem.put(player.getUniqueId(), Navigator.navigatorItemClickEditMode.getItem(0));
					Navigator.navigatorClickSlot.put(player.getUniqueId(), Navigator.navigatorItemClickEditMode.getItem(1).getAmount());
				}
				if(Material.BLAZE_POWDER.equals(event.getCurrentItem().getType())) {
					Navigator.openNavigatorAddItemParticleInventory(player);
					Navigator.navigatorClickItem.put(player.getUniqueId(), Navigator.navigatorItemClickEditMode.getItem(0));
					Navigator.navigatorClickSlot.put(player.getUniqueId(), Navigator.navigatorItemClickEditMode.getItem(1).getAmount());
				}
				if("§4§lBack".equals(event.getCurrentItem().getItemMeta().getDisplayName())) {
					Navigator.openNavigatorEditMode(player);
				}
				event.setCancelled(true);
			}
			if(Navigator.navigatorEditModeSize9.equals(event.getInventory())) {
				if(event.isShiftClick() && event.isRightClick())
					for(int i=0;i<event.getInventory().getSize();i++)
						if(Navigator.getNavigatorItems(i).equals(event.getCurrentItem()) ) {
							event.setCancelled(true);
							Navigator.openNavigatorItemClickInv(player, event.getCurrentItem(), event.getSlot());
							return;
						}
				event.setCancelled(false);
			}
			if(Navigator.navigatorEditModeSize18.equals(event.getInventory())) {
				if(event.isShiftClick() && event.isRightClick())
					for(int i=0;i<event.getInventory().getSize();i++)
						if(Navigator.getNavigatorItems(i).equals(event.getCurrentItem()) ) {
							event.setCancelled(true);
							Navigator.openNavigatorItemClickInv(player, event.getCurrentItem(), event.getSlot());
							return;
						}
				event.setCancelled(false);
			}
			if(Navigator.navigatorEditModeSize27.equals(event.getInventory())) {
				if(event.isShiftClick() && event.isRightClick())
					for(int i=0;i<event.getInventory().getSize();i++)
						if(Navigator.getNavigatorItems(i).equals(event.getCurrentItem()) ) {
							event.setCancelled(true);
							Navigator.openNavigatorItemClickInv(player, event.getCurrentItem(), event.getSlot());
							return;
						}
				event.setCancelled(false);
			}
			if(Navigator.navigatorEditModeSize36.equals(event.getInventory())) {
				if(event.isShiftClick() && event.isRightClick())
					for(int i=0;i<event.getInventory().getSize();i++)
						if(Navigator.getNavigatorItems(i).equals(event.getCurrentItem()) ) {
							event.setCancelled(true);
							Navigator.openNavigatorItemClickInv(player, event.getCurrentItem(), event.getSlot());
							return;
						}
				event.setCancelled(false);
			}
			if(Navigator.navigatorEditModeSize45.equals(event.getInventory())) {
				if(event.isShiftClick() && event.isRightClick())
					for(int i=0;i<event.getInventory().getSize();i++)
						if(Navigator.getNavigatorItems(i).equals(event.getCurrentItem()) ) {
							event.setCancelled(true);
							Navigator.openNavigatorItemClickInv(player, event.getCurrentItem(), event.getSlot());
							return;
						}
				event.setCancelled(false);
			}
			if(Navigator.navigatorEditModeSize54.equals(event.getInventory())) {
				if(event.isShiftClick() && event.isRightClick())
					for(int i=0;i<event.getInventory().getSize();i++)
						if(Navigator.getNavigatorItems(i).equals(event.getCurrentItem()) ) {
							event.setCancelled(true);
							Navigator.openNavigatorItemClickInv(player, event.getCurrentItem(), event.getSlot());
							return;
						}
				event.setCancelled(false);
			}
			if(Navigator.navigatorAddItemSound.equals(event.getInventory())) {
				switch(event.getSlot()) {
				case 0:
					if(event.isLeftClick()) {
						config.setString("ENDERMAN_TELEPORT", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.sound", Variable.navigatorConfig, Variable.navigatorFile);
						player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
					break;
				case 1:
					if(event.isLeftClick()) {
						config.setString("ENDERDRAGON_GROWL", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.sound", Variable.navigatorConfig, Variable.navigatorFile);
						player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
					break;
				case 2:
					if(event.isLeftClick()) {
						config.setString("NOTE_BASS", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.sound", Variable.navigatorConfig, Variable.navigatorFile);
						player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
					break;
				case 3:
					if(event.isLeftClick()) {
						config.setString("ORB_PICKUP", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.sound", Variable.navigatorConfig, Variable.navigatorFile);
						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					}
					if(event.isRightClick())
						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					break;
				case 4:
					if(event.isLeftClick()) {
						config.setString("LEVEL_UP", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.sound", Variable.navigatorConfig, Variable.navigatorFile);
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					break;
				case 5:
					if(event.isLeftClick()) {
						config.setString("EXPLODE", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.sound", Variable.navigatorConfig, Variable.navigatorFile);
						player.playSound(player.getLocation(), Sound.EXPLODE, 1, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						player.playSound(player.getLocation(), Sound.EXPLODE, 1, 1);
					
					break;
				case 6:
					if(event.isLeftClick()) {
						config.setString("PORTAL_TRIGGER", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.sound", Variable.navigatorConfig, Variable.navigatorFile);
						player.playSound(player.getLocation(), Sound.PORTAL_TRIGGER, 1, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						player.playSound(player.getLocation(), Sound.PORTAL_TRIGGER, 1, 1);
					break;
				case 7:
					if(event.isLeftClick()) {
						config.setString("WITHER_SPAWN", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.sound", Variable.navigatorConfig, Variable.navigatorFile);
						player.playSound(player.getLocation(), Sound.WITHER_SPAWN, 1, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						player.playSound(player.getLocation(), Sound.WITHER_SPAWN, 1, 1);
					break;
				case 8:
					Navigator.openNavigatorItemClickInv(player, Navigator.navigatorClickItem.get(player.getUniqueId()), Navigator.navigatorClickSlot.get(player.getUniqueId()));
					Navigator.navigatorClickItem.remove(player.getUniqueId(), Navigator.navigatorClickItem.get(player.getUniqueId()));
					Navigator.navigatorClickSlot.remove(player.getUniqueId(), Navigator.navigatorClickSlot.get(player.getUniqueId()));
				default:
					break;
				}
				event.setCancelled(true);
			}
			if(Navigator.navigatorAddItemParticle.equals(event.getInventory())) {
				switch(event.getSlot()) {
				case 0:
					if(event.isLeftClick()) {
						config.setString("ENDER_SIGNAL", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.particle", Variable.navigatorConfig, Variable.navigatorFile);
						player.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						player.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 1);
					player.closeInventory();
					break;
				case 1:
					if(event.isLeftClick()) {
						config.setString("MOBSPAWNER_FLAMES", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.particle", Variable.navigatorConfig, Variable.navigatorFile);
						for(int i=0;i<20;i++)
							player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						for(int i=0;i<20;i++)
							player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, i);
					player.closeInventory();
					break;
				case 2:
					if(event.isLeftClick()) {
						config.setString("PORTAL", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.particle", Variable.navigatorConfig, Variable.navigatorFile);
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation().add(0, 1.5, 0), Effect.PORTAL, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation().add(0, 1.5, 0), Effect.PORTAL, i);
					player.closeInventory();
					break;
				case 3:
					if(event.isLeftClick()) {
						config.setString("SMOKE", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.particle", Variable.navigatorConfig, Variable.navigatorFile);
						for(int i=0;i<30;i++)
							player.playEffect(player.getLocation(), Effect.SMOKE, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						for(int i=0;i<30;i++)
							player.playEffect(player.getLocation(), Effect.SMOKE, i);
					player.closeInventory();
					break;
				case 4:
					if(event.isLeftClick()) {
						config.setString("WITCH_MAGIC", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.particle", Variable.navigatorConfig, Variable.navigatorFile);
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation(), Effect.WITCH_MAGIC, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation(), Effect.WITCH_MAGIC, i);
					player.closeInventory();
					break;
				case 5:
					if(event.isLeftClick()) {
						config.setString("MAGIC_CRIT", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.particle", Variable.navigatorConfig, Variable.navigatorFile);
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation(), Effect.MAGIC_CRIT, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation(), Effect.MAGIC_CRIT, i);
					player.closeInventory();
					break;
				case 6:
					if(event.isLeftClick()) {
						config.setString("INSTANT_SPELL", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.particle", Variable.navigatorConfig, Variable.navigatorFile);
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation(), Effect.INSTANT_SPELL, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation(), Effect.INSTANT_SPELL, i);
					player.closeInventory();
					break;
				case 7:
					if(event.isLeftClick()) {
						config.setString("FLAME", "Navigator."+Navigator.navigatorClickSlot.get(player.getUniqueId())+".action.particle", Variable.navigatorConfig, Variable.navigatorFile);
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation(), Effect.FLAME, 1);
						player.closeInventory();
					}
					if(event.isRightClick())
						for(int i=0;i<80;i++)
							player.playEffect(player.getLocation(), Effect.FLAME, i);
					player.closeInventory();
					break;
				case 8:
					Navigator.openNavigatorItemClickInv(player, Navigator.navigatorClickItem.get(player.getUniqueId()), Navigator.navigatorClickSlot.get(player.getUniqueId()));
					Navigator.navigatorClickItem.remove(player.getUniqueId(), Navigator.navigatorClickItem.get(player.getUniqueId()));
					Navigator.navigatorClickSlot.remove(player.getUniqueId(), Navigator.navigatorClickSlot.get(player.getUniqueId()));
				default:
					break;
				}
				event.setCancelled(true);
			}
			if(Navigator.navigatorInventory.equals(event.getInventory()))
				for(int i=0;i<Navigator.navigatorInventory.getSize();i++)
					if(Navigator.getNavigatorItems(i).equals(event.getCurrentItem())) {
						if(config.getString("Navigator."+i+".action.sound", Variable.navigatorConfig) != null)
							player.playSound(player.getLocation(), Sound.valueOf(config.getString("Navigator."+i+".action.sound", Variable.navigatorConfig)), 1, 1);
						if(config.getLocation("Navigator."+i+".action.teleport", Variable.navigatorConfig) != null)
							player.teleport(config.getLocation("Navigator."+i+".action.teleport", Variable.navigatorConfig));
						if(config.getString("Navigator."+i+".action.particle", Variable.navigatorConfig) != null) {
							Effect effect = Effect.valueOf(config.getString("Navigator."+i+".action.particle", Variable.navigatorConfig));
							if(effect == Effect.MOBSPAWNER_FLAMES) {
								for(int j=0;j<20;j++)
									player.playEffect(player.getLocation(), effect, j);
								
							} else if(effect == Effect.SMOKE) {
								for(int j=0;j<30;j++)
									player.playEffect(player.getLocation(), effect, j);
								
							} else if(effect == Effect.WITCH_MAGIC || 
									effect == Effect.MAGIC_CRIT || 
									effect == Effect.INSTANT_SPELL || 
									effect == Effect.FLAME) {
								for(int j=0;j<80;j++)
									player.playEffect(player.getLocation(), effect, j);
								
							} else if(effect == Effect.PORTAL) {
								for(int j=0;j<80;j++)
									player.playEffect(player.getLocation().add(0, 1.5, 0), effect, j);
							} else
								player.playEffect(player.getLocation(), effect, 1);
						}
				event.setCancelled(true);
			}
			
			
			
		} catch(Exception e) {
		}
	}
	
	private static void removeExtrasItemHashMap(Player player) {
		for(int i=1;i<11;i++)
			if(extrasItem.containsKey(player.getUniqueId()) && extrasItem.containsValue(i))
				extrasItem.remove(player.getUniqueId(), i);
	}
}
