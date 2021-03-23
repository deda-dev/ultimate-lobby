package de.deda.lobby.utils;

public class FileManager {

	ConfigManager cm = new ConfigManager();
	
	public void setMySQLConfig() {
		if(cm.getSimpleString("MySQL.Host", Variable.mysqlConfig) != null)
			return;
		
		cm.setString("localhost", "MySQL.Host", Variable.mysqlConfig, Variable.mysqlFile);
		cm.setString("3306", "MySQL.Port", Variable.mysqlConfig, Variable.mysqlFile);
		cm.setString("localhost", "MySQL.Database", Variable.mysqlConfig, Variable.mysqlFile);
		cm.setString("localhost", "MySQL.Username", Variable.mysqlConfig, Variable.mysqlFile);
		cm.setString("localhost", "MySQL.Password", Variable.mysqlConfig, Variable.mysqlFile);
	}
	
	public void setItemsConfig() {
		if(cm.getSimpleString("JoinItems", Variable.itemConfig) != null)
			return;
		
		//Player Hider
		cm.setBoolean(true, "JoinItems.PlayerHider.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(1, "JoinItems.PlayerHider.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("BLAZE_POWDER", "JoinItems.PlayerHider.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "JoinItems.PlayerHider.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&6&lPlayer Hider &7(Rightclick)", "JoinItems.PlayerHider.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Open player hider menu/n&7Change current player hide", "JoinItems.PlayerHider.lore", Variable.itemConfig, Variable.itemFile);
		
		//Gadgets
		cm.setBoolean(true, "JoinItems.Gadget.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(2, "JoinItems.Gadget.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("FIREWORK_CHARGE", "JoinItems.Gadget.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "JoinItems.Gadget.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&b&lGadgets &7(Rightclick)", "JoinItems.Gadget.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Open gadgets menu/n&7Select cool items", "JoinItems.Gadget.lore", Variable.itemConfig, Variable.itemFile);
		
		//None selected gadget
		cm.setBoolean(true, "JoinItems.Gadget.noSelected.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(3, "JoinItems.Gadget.noSelected.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("BARRIER", "JoinItems.Gadget.noSelected.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "JoinItems.Gadget.noSelected.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&4&lNone selected gadget", "JoinItems.Gadget.noSelected.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Select a gadget in the gadgets menu", "JoinItems.Gadget.noSelected.lore", Variable.itemConfig, Variable.itemFile);
		
		//Navigator
		cm.setBoolean(true, "JoinItems.Navigator.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(5, "JoinItems.Navigator.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("GOLD_RECORD", "JoinItems.Navigator.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "JoinItems.Navigator.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&e&lNavigator &7(Rightclick)", "JoinItems.Navigator.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Open navigator menu/n&7Warp to game modes", "JoinItems.Navigator.lore", Variable.itemConfig, Variable.itemFile);
		
		//Lobby switcher
		cm.setBoolean(true, "JoinItems.LobbySwitcher.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(8, "JoinItems.LobbySwitcher.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("NETHER_STAR", "JoinItems.LobbySwitcher.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "JoinItems.LobbySwitcher.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&d&lLobby switcher &7(Rightclick)", "JoinItems.LobbySwitcher.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Open lobby switcher menu/n&7Switch the lobby", "JoinItems.LobbySwitcher.lore", Variable.itemConfig, Variable.itemFile);
		
		//Settings
		cm.setBoolean(true, "JoinItems.Settings.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(9, "JoinItems.Settings.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("REDSTONE_COMPARATOR", "JoinItems.Settings.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "JoinItems.Settings.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&c&lSettings &7(Rightclick)", "JoinItems.Settings.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Open settings menu/n&7Manage your own settings/n&7Add friends and have fun", "JoinItems.Settings.lore", Variable.itemConfig, Variable.itemFile);
		
		if(cm.getSimpleString("SneakItems", Variable.itemConfig) != null)
			return;
		
		//Enable/Disable
		cm.setBoolean(true, "SneakItems.enabled", Variable.itemConfig, Variable.itemFile);
		
		//Build-Mode
		cm.setBoolean(true, "SneakItems.BuildMode.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(2, "SneakItems.BuildMode.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("GRASS", "SneakItems.BuildMode.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "SneakItems.BuildMode.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&2&lBuild&8&l-&2&lMode &7(Rightclick)", "SneakItems.BuildMode.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Change to build-mode", "SneakItems.BuildMode.lore", Variable.itemConfig, Variable.itemFile);
		
		//Team-Server
		cm.setBoolean(true, "SneakItems.TeamServer.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(5, "SneakItems.TeamServer.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("DRAGON_EGG", "SneakItems.TeamServer.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "SneakItems.TeamServer.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&d&lTeam Server &7(Rightclick)", "SneakItems.TeamServer.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Open team server menu", "SneakItems.TeamServer.lore", Variable.itemConfig, Variable.itemFile);
		
		//Nick
		cm.setBoolean(true, "SneakItems.Nick.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setInt(6, "SneakItems.Nick.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("NAME_TAG", "SneakItems.Nick.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "SneakItems.Nick.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&6&lNick &7(Rightclick)", "SneakItems.Nick.name", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Show yourself as another player", "SneakItems.Nick.lore", Variable.itemConfig, Variable.itemFile);
		cm.setString("nick", "SneakItems.Nick.command", Variable.itemConfig, Variable.itemFile);
		
		//Fly
		cm.setBoolean(true, "SneakItems.Fly.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setBoolean(true, "SneakItems.Fly.sound", Variable.itemConfig, Variable.itemFile);
		cm.setInt(8, "SneakItems.Fly.slot", Variable.itemConfig, Variable.itemFile);
		cm.setString("FEATHER", "SneakItems.Fly.material", Variable.itemConfig, Variable.itemFile);
		cm.setInt(0, "SneakItems.Fly.subID", Variable.itemConfig, Variable.itemFile);
		cm.setString("&f&lFly &7(&aEnabled&7)", "SneakItems.Fly.name.enabled", Variable.itemConfig, Variable.itemFile);
		cm.setString("&f&lFly &7(&cDisabled&7)", "SneakItems.Fly.name.disabled", Variable.itemConfig, Variable.itemFile);
		cm.setString("&7Change to fly mode", "SneakItems.Fly.lore", Variable.itemConfig, Variable.itemFile);
		
	}
	
	public void setCommandsConfig() {
		if(cm.getSimpleString("BuildMode", Variable.cmdConfig) != null)
			return;
		
		//Build mode
		cm.setString("%PREFIX% &aBuild-Mode enabled.", "BuildMode.activated", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("%PREFIX% &cBuild-Mode disabled.", "BuildMode.deactivated", Variable.cmdConfig, Variable.cmdFile);
		cm.setBoolean(true, "BuildMode.title.enabled", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&bBuild-Mode", "BuildMode.title.activated.title", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&aEnabled", "BuildMode.title.activated.subtitle", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&bBuild-Mode", "BuildMode.title.deactivated.title", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&cDisabled", "BuildMode.title.deactivated.subtitle", Variable.cmdConfig, Variable.cmdFile);
		
		//Coins
		cm.setString("&7You have &6%COINS% &7Coins.", "Coins.your", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7The specified player &6%PLAYER% &7have &6%COINS%&7 Coins.", "Coins.target", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7You set the player &6%PLAYER% %COINS% &7Coins.", "Coins.set", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7You add the player &6%PLAYER% %COINS% &7Coins.", "Coins.add", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7You removed the player &6%PLAYER% %COINS% &7Coins.", "Coins.remove", Variable.cmdConfig, Variable.cmdFile);
		
		//Chat Clear
		cm.setString("&7Chat cleared by", "ChatClear.messages.firstLine", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&d%PLAYER%", "ChatClear.messages.secondLine", Variable.cmdConfig, Variable.cmdFile);
		
		//Chat log
		cm.setBoolean(false, "ChatLog.loged", Variable.cmdConfig, Variable.cmdFile);
		cm.setBoolean(true, "ChatLog.messages.loged.chatclear", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7Chat loged by", "ChatLog.messages.loged.firstLine", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&d%PLAYER%", "ChatLog.messages.loged.secondLine", Variable.cmdConfig, Variable.cmdFile);
		cm.setBoolean(true, "ChatLog.messages.unloged.chatclear", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7Chat unloged by", "ChatLog.messages.unloged.firstLine", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&d%PLAYER%", "ChatLog.messages.unloged.secondLine", Variable.cmdConfig, Variable.cmdFile);
		
		//Fly
		cm.setString("%PREFIX% &aFly-Mode enabled.", "Fly.activated", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("%PREFIX% &cFly-Mode disabled.", "Fly.deactivated", Variable.cmdConfig, Variable.cmdFile);
		
		//Vanish
		cm.setString("%PREFIX% &aVanish enabled.", "Vanish.activated", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("%PREFIX% &cVanish disabled.", "Vanish.deactivated", Variable.cmdConfig, Variable.cmdFile);
		
		//GameMode
		cm.setString("&7You set your gamemode to &6survival.", "GameMode.0", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7You set your gamemode to &6creative.", "GameMode.1", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7You set your gamemode to &6advendture.", "GameMode.2", Variable.cmdConfig, Variable.cmdFile);
		cm.setString("&7You set your gamemode to &6spectator.", "GameMode.3", Variable.cmdConfig, Variable.cmdFile);
		
		//SetSpawn
		cm.setString("%PREFIX% &7You set the &6Spawn.", "SetSpawn", Variable.cmdConfig, Variable.cmdFile);
	}
	
	public void setTeamServerConfig() {
		//Team Server title
		cm.setString("Team Server", "TeamServer.title", Variable.teamServerConfig, Variable.teamServerFile);
		
		//Player Hider sound
		cm.setBoolean(true, "TeamServer.sound", Variable.teamServerConfig, Variable.teamServerFile);
		
		//First slot
		cm.setString("COMMAND", "TeamServer.firstSlot.material", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setInt(0, "TeamServer.firstSlot.subID", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("&9&lDev Server", "TeamServer.firstSlot.name", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("&7Join the dev server", "TeamServer.firstSlot.lore", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("dev-1", "TeamServer.firstSlot.server", Variable.teamServerConfig, Variable.teamServerFile);
		
		//Second slot
		cm.setString("GRASS", "TeamServer.secondSlot.material", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setInt(0, "TeamServer.secondSlot.subID", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("&2&lBuild Server", "TeamServer.secondSlot.name", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("&7Join the build server", "TeamServer.secondSlot.lore", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("build-1", "TeamServer.secondSlot.server", Variable.teamServerConfig, Variable.teamServerFile);
		
		//Third slot
		cm.setString("BARRIER", "TeamServer.thirdSlot.material", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setInt(0, "TeamServer.thirdSlot.subID", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("&4&lNot available", "TeamServer.thirdSlot.name", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("", "TeamServer.thirdSlot.lore", Variable.teamServerConfig, Variable.teamServerFile);
		cm.setString("", "TeamServer.thirdSlot.server", Variable.teamServerConfig, Variable.teamServerFile);
		
	}
	
	public void setPlayerHiderConfig() {
		//Player Hider title
		cm.setString("Player Hider", "PlayerHider.title", Variable.playerHiderConfig, Variable.playerHiderFile);
		
		//Player Hider sound
		cm.setBoolean(true, "PlayerHider.sound", Variable.playerHiderConfig, Variable.playerHiderFile);
		
		//Player Hider effect
		cm.setBoolean(true, "PlayerHider.effect", Variable.playerHiderConfig, Variable.playerHiderFile);
		
		//Show all
		cm.setString("INK_SACK", "PlayerHider.showAll.material", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setInt(10, "PlayerHider.showAll.subID", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setString("&a&lShow all player", "PlayerHider.showAll.name", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setString("&7Shows you all players", "PlayerHider.showAll.lore", Variable.playerHiderConfig, Variable.playerHiderFile);
		
		//Show team members
		cm.setString("INK_SACK", "PlayerHider.showMembers.material", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setInt(5, "PlayerHider.showMembers.subID", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setString("&7&lShow &4&lTeam Member &8&l+ &f&lYou&c&lTuber", "PlayerHider.showMembers.name", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setString("&7Shows you only team members and youtubers", "PlayerHider.showMembers.lore", Variable.playerHiderConfig, Variable.playerHiderFile);
		
		//Hide all
		cm.setString("INK_SACK", "PlayerHider.hideAll.material", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setInt(1, "PlayerHider.hideAll.subID", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setString("&c&lHide all player", "PlayerHider.hideAll.name", Variable.playerHiderConfig, Variable.playerHiderFile);
		cm.setString("&7Hides you all players", "PlayerHider.hideAll.lore", Variable.playerHiderConfig, Variable.playerHiderFile);	
	}
	
	public void setLobbySwitcherConfig() {
		//Lobby Switcher title
		cm.setString("Lobby Switcher", "LobbySwitcher.title", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		
		//Player Hider sound
		cm.setBoolean(true, "LobbySwitcher.sound", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		
		//Lobby-1
		cm.setString("IRON_INGOT", "LobbySwitcher.lobby.1.material", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setInt(0, "LobbySwitcher.lobby.1.subID", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&8&lLobby-1", "LobbySwitcher.lobby.1.name", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&7Switch to other lobby server", "LobbySwitcher.lobby.1.lore", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("lobby-1", "LobbySwitcher.lobby.1.server", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		
		//Lobby-2
		cm.setString("IRON_INGOT", "LobbySwitcher.lobby.2.material", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setInt(0, "LobbySwitcher.lobby.2.subID", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&8&lLobby-2", "LobbySwitcher.lobby.2.name", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&7Switch to other lobby server", "LobbySwitcher.lobby.2.lore", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("lobby-2", "LobbySwitcher.lobby.2.server", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		
		//Lobby-3
		cm.setString("IRON_INGOT", "LobbySwitcher.lobby.3.material", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setInt(0, "LobbySwitcher.lobby.3.subID", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&8&lLobby-3", "LobbySwitcher.lobby.3.name", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&7Switch to other lobby server", "LobbySwitcher.lobby.3.lore", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("lobby-3", "LobbySwitcher.lobby.3.server", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		
		//Lobby-4
		cm.setString("IRON_INGOT", "LobbySwitcher.lobby.4.material", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setInt(0, "LobbySwitcher.lobby.4.subID", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&8&lLobby-4", "LobbySwitcher.lobby.4.name", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&7Switch to other lobby server", "LobbySwitcher.lobby.4.lore", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);	
		cm.setString("lobby-4", "LobbySwitcher.lobby.4.server", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		
		//Lobby-5
		cm.setString("IRON_INGOT", "LobbySwitcher.lobby.5.material", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setInt(0, "LobbySwitcher.lobby.5.subID", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&8&lLobby-5", "LobbySwitcher.lobby.5.name", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&7Switch to other lobby server", "LobbySwitcher.lobby.5.lore", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);	
		cm.setString("lobby-5", "LobbySwitcher.lobby.5.server", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		
		//Premium Lobby-1
		cm.setString("GOLD_INGOT", "LobbySwitcher.premLobby.material", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setInt(0, "LobbySwitcher.premLobby.subID", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&6&lPremium Lobby", "LobbySwitcher.premLobby.name", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("&7Switch to other lobby server", "LobbySwitcher.premLobby.lore", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
		cm.setString("premlobby-1", "LobbySwitcher.premLobby.server", Variable.lobbySwitcherConfig, Variable.lobbySwitcherFile);
	}
	
	public void setSettingsConfig() {
		//Settings title
		cm.setString("Settings", "Settings.title", Variable.settingsConfig, Variable.settingsFile);
		
		//Settings sound
		cm.setBoolean(true, "Settings.sound", Variable.settingsConfig, Variable.settingsFile);
		
		//Settings effect
		cm.setBoolean(true, "Settings.effect", Variable.settingsConfig, Variable.settingsFile);
		
		//Movement
		cm.setString("IRON_BOOTS", "Settings.movement.material", Variable.settingsConfig, Variable.settingsFile);
		cm.setInt(0, "Settings.movement.subID", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&a&lMovement", "Settings.movement.name", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&7Change your movement settings", "Settings.movement.lore", Variable.settingsConfig, Variable.settingsFile);
		
		//Movement / walk
		cm.setBoolean(true, "Settings.movement.walk.color", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("LEATHER_BOOTS", "Settings.movement.walk.material", Variable.settingsConfig, Variable.settingsFile);
		cm.setInt(0, "Settings.movement.walk.subID", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&d&lWalk", "Settings.movement.walk.name", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&7Walk in the lobby", "Settings.movement.walk.lore", Variable.settingsConfig, Variable.settingsFile);
		
		//Movement / doublejump
		cm.setString("FIREWORK", "Settings.movement.doublejump.material", Variable.settingsConfig, Variable.settingsFile);
		cm.setInt(0, "Settings.movement.doublejump.subID", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&b&lDouble Jump", "Settings.movement.doublejump.name", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&7Double Jump in the lobby", "Settings.movement.doublejump.lore", Variable.settingsConfig, Variable.settingsFile);
		
		//Spawn position
		cm.setString("GOLD_INGOT", "Settings.spawnPosition.material", Variable.settingsConfig, Variable.settingsFile);
		cm.setInt(0, "Settings.spawnPosition.subID", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&c&lSpawn Position", "Settings.spawnPosition.name", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&7Appear at last position or at the spawn", "Settings.spawnPosition.lore", Variable.settingsConfig, Variable.settingsFile);
		
		//Appear last position
		cm.setString("ARMOR_STAND", "Settings.spawnPosition.lastPosition.material", Variable.settingsConfig, Variable.settingsFile);
		cm.setInt(0, "Settings.spawnPosition.lastPosition.subID", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&3&lLast Position", "Settings.spawnPosition.lastPosition.name", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&7Appear at last position", "Settings.spawnPosition.lastPosition.lore", Variable.settingsConfig, Variable.settingsFile);
				
		//Appear at spawn
		cm.setString("BEACON", "Settings.spawnPosition.atSpawn.material", Variable.settingsConfig, Variable.settingsFile);
		cm.setInt(0, "Settings.spawnPosition.atSpawn.subID", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&5&lAt Spawn", "Settings.spawnPosition.atSpawn.name", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&7Appear at the spawn", "Settings.spawnPosition.atSpawn.lore", Variable.settingsConfig, Variable.settingsFile);
				
		//Friends
		cm.setString("%PLAYERHEAD%", "Settings.friends.material", Variable.settingsConfig, Variable.settingsFile);
		cm.setInt(3, "Settings.friends.subID", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&e&lFriends", "Settings.friends.name", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("&7Open the friends menu", "Settings.friends.lore", Variable.settingsConfig, Variable.settingsFile);
		cm.setString("friend", "Settings.friends.command", Variable.settingsConfig, Variable.settingsFile);
	}
	
	public void setGadgetsConfig() {
		//Gadgets title
		cm.setString("Gadgets", "Gadgets.title", Variable.gadgetsConfig, Variable.gadgetsFile);
		
		//Gadgets sound
		cm.setBoolean(true, "Gadgets.sound", Variable.gadgetsConfig, Variable.gadgetsFile);
				
		//Gadgets effect
		cm.setBoolean(true, "Gadgets.effect", Variable.gadgetsConfig, Variable.gadgetsFile);
		
		//Hats
		cm.setString("GLASS", "Gadgets.Hats.material", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setInt(0, "Gadgets.Hats.subID", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("&e&lHats", "Gadgets.Hats.name", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("&7Choose a hat to look like better", "Gadgets.Hats.lore", Variable.gadgetsConfig, Variable.gadgetsFile);
		
		//Heads
		cm.setString("%PLAYERHEAD%", "Gadgets.Heads.material", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setInt(3, "Gadgets.Heads.subID", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("&b&lHeads", "Gadgets.Heads.name", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("&7Choose a head to look like better", "Gadgets.Heads.lore", Variable.gadgetsConfig, Variable.gadgetsFile);
		
		//Boots
		cm.setBoolean(true, "Gadgets.Boots.color.enabled", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setInt(96, "Gadgets.Boots.color.red", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setInt(96, "Gadgets.Boots.color.green", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setInt(96, "Gadgets.Boots.color.blue", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("LEATHER_BOOTS", "Gadgets.Boots.material", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setInt(0, "Gadgets.Boots.subID", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("&a&lBoots", "Gadgets.Boots.name", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("&7Choose boots to look like better", "Gadgets.Boots.lore", Variable.gadgetsConfig, Variable.gadgetsFile);
		
		//Extras
		cm.setString("FISHING_ROD", "Gadgets.Extras.material", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setInt(0, "Gadgets.Extras.subID", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("&6&lExtras", "Gadgets.Extras.name", Variable.gadgetsConfig, Variable.gadgetsFile);
		cm.setString("&7Choose a extra item to have fun", "Gadgets.Extras.lore", Variable.gadgetsConfig, Variable.gadgetsFile);
	}
	
	public void setShopConfig() {
		//Buy message
		cm.setString("&7&lYou bought the item &8&l%ITEM%&7&l.", "Shop.messages.buy", Variable.shopConfig, Variable.shopFile);
		
		//Not enough money message
		cm.setString("%PREFIX% &7&lYou have not enough money.", "Shop.messages.notEnoughMoney", Variable.shopConfig, Variable.shopFile);
		
		//Shop Hats
		cm.setString("GLASS", "Shop.Hats.1.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.1.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&f&lGlass &8&l(&cbuy&8&l)", "Shop.Hats.1.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a glass block on your head", "Shop.Hats.1.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&f&lGlass &8&l(&abought&8&l)", "Shop.Hats.1.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a glass block on your head", "Shop.Hats.1.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.1.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("MELON_BLOCK", "Shop.Hats.2.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.2.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&2&lMelon &8&l(&cbuy&8&l)", "Shop.Hats.2.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a melon block on your head", "Shop.Hats.2.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&2&lMelon &8&l(&abought&8&l)", "Shop.Hats.2.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a melon block on your head", "Shop.Hats.2.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.2.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("PUMPKIN", "Shop.Hats.3.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.3.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&6&lPumpkin &8&l(&cbuy&8&l)", "Shop.Hats.3.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a pumpkin block on your head", "Shop.Hats.3.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&6&lPumpkin &8&l(&abought&8&l)", "Shop.Hats.3.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a pumpkin block on your head", "Shop.Hats.3.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.3.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("TNT", "Shop.Hats.4.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.4.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lTNT &8&l(&cbuy&8&l)", "Shop.Hats.4.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a tnt block on your head", "Shop.Hats.4.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lTNT &8&l(&abought&8&l)", "Shop.Hats.4.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a tnt block on your head", "Shop.Hats.4.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.4.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("LOG", "Shop.Hats.5.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.5.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&d&lOak wood &8&l(&cbuy&8&l)", "Shop.Hats.5.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a oak wood block on your head", "Shop.Hats.5.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&d&lOak wood &8&l(&abought&8&l)", "Shop.Hats.5.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a oak wood block on your head", "Shop.Hats.5.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.5.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("BOOKSHELF", "Shop.Hats.6.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.6.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&a&lBookshelf &8&l(&cbuy&8&l)", "Shop.Hats.6.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a bookshelf block on your head", "Shop.Hats.6.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&a&lBookshelf &8&l(&abought&8&l)", "Shop.Hats.6.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a bookshelf block on your head", "Shop.Hats.6.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.6.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("SEA_LANTERN", "Shop.Hats.7.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.7.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&b&lSea lantern &8&l(&cbuy&8&l)", "Shop.Hats.7.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a sea lantern block on your head", "Shop.Hats.7.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&b&lSea lantern &8&l(&abought&8&l)", "Shop.Hats.7.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a sea lantern block on your head", "Shop.Hats.7.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.7.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("DIAMOND_BLOCK", "Shop.Hats.8.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.8.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&3&lDiamond block &8&l(&cbuy&8&l)", "Shop.Hats.8.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a diamond block on your head", "Shop.Hats.8.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&3&lDiamond block &8&l(&abought&8&l)", "Shop.Hats.8.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a diamond block on your head", "Shop.Hats.8.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.8.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("JUKEBOX", "Shop.Hats.9.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.9.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&9&lJukebox &8&l(&cbuy&8&l)", "Shop.Hats.9.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a jukebox on your head", "Shop.Hats.9.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&9&lJukebox &8&l(&abought&8&l)", "Shop.Hats.9.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a jukebox on your head", "Shop.Hats.9.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.9.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("TRAP_DOOR", "Shop.Hats.10.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Hats.10.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&e&lTrap door &8&l(&cbuy&8&l)", "Shop.Hats.10.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a trap door on your head", "Shop.Hats.10.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&e&lTrap door &8&l(&abought&8&l)", "Shop.Hats.10.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set a trap door on your head", "Shop.Hats.10.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(500, "Shop.Hats.10.price", Variable.shopConfig, Variable.shopFile);
		
		//Shop Heads
		cm.setString("DennisGenetics", "Shop.Heads.1.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&e&lLobby &8&lplugin &9&lDeveloper &8&l(&cbuy&8&l)", "Shop.Heads.1.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from the developer on your head", "Shop.Heads.1.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&e&lLobby &8&lplugin &9&lDeveloper &8&l(&abought&8&l)", "Shop.Heads.1.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from the developer on your head", "Shop.Heads.1.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.1.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("Dream", "Shop.Heads.2.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&b&lDream &8&l(&cbuy&8&l)", "Shop.Heads.2.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Dream on your head", "Shop.Heads.2.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&b&lDream &8&l(&abought&8&l)", "Shop.Heads.2.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Dream on your head", "Shop.Heads.2.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.2.price", Variable.shopConfig, Variable.shopFile);

		cm.setString("Technoblade", "Shop.Heads.3.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&d&lTechnoblade &8&l(&cbuy&8&l)", "Shop.Heads.3.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Technoblade on your head", "Shop.Heads.3.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&d&lTechnoblade &8&l(&abought&8&l)", "Shop.Heads.3.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Technoblade on your head", "Shop.Heads.3.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.3.price", Variable.shopConfig, Variable.shopFile);

		cm.setString("Trymacs_Live", "Shop.Heads.4.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&e&lTrymacs &8&l(&cbuy&8&l)", "Shop.Heads.4.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Trymacs on your head", "Shop.Heads.4.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&e&lTrymacs &8&l(&abought&8&l)", "Shop.Heads.4.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Trymacs on your head", "Shop.Heads.4.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.4.price", Variable.shopConfig, Variable.shopFile);

		cm.setString("Gronkh", "Shop.Heads.5.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&f&lGronkh &8&l(&cbuy&8&l)", "Shop.Heads.5.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Gronkh on your head", "Shop.Heads.5.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&f&lGronkh &8&l(&abought&8&l)", "Shop.Heads.5.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Gronkh on your head", "Shop.Heads.5.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.5.price", Variable.shopConfig, Variable.shopFile);

		cm.setString("NebelNiek", "Shop.Heads.6.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&a&lNebelNiek &8&l(&cbuy&8&l)", "Shop.Heads.6.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from NebelNiek on your head", "Shop.Heads.6.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&a&lNebelNiek &8&l(&abought&8&l)", "Shop.Heads.6.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from NebelNiek on your head", "Shop.Heads.6.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.6.price", Variable.shopConfig, Variable.shopFile);

		cm.setString("DoctorBenx", "Shop.Heads.7.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lDoctorBenx &8&l(&cbuy&8&l)", "Shop.Heads.7.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from DoctorBenx on your head", "Shop.Heads.7.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lDoctorBenx &8&l(&abought&8&l)", "Shop.Heads.7.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from DoctorBenx on your head", "Shop.Heads.7.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.7.price", Variable.shopConfig, Variable.shopFile);

		cm.setString("Paluten", "Shop.Heads.8.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&6&lPaluten &8&l(&cbuy&8&l)", "Shop.Heads.8.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Paluten on your head", "Shop.Heads.8.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&6&lPaluten &8&l(&abought&8&l)", "Shop.Heads.8.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Paluten on your head", "Shop.Heads.8.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.8.price", Variable.shopConfig, Variable.shopFile);

		cm.setString("rewinside", "Shop.Heads.9.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&5&lRewinside &8&l(&cbuy&8&l)", "Shop.Heads.9.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Rewinside on your head", "Shop.Heads.9.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&5&lRewinside &8&l(&abought&8&l)", "Shop.Heads.9.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from Rewinside on your head", "Shop.Heads.9.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.9.price", Variable.shopConfig, Variable.shopFile);

		cm.setString("GermanLetsPlay", "Shop.Heads.10.headOwner", Variable.shopConfig, Variable.shopFile);
		cm.setString("&3&lGermanLetsPlay &8&l(&cbuy&8&l)", "Shop.Heads.10.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from GermanLetsPlay on your head", "Shop.Heads.10.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&3&lGermanLetsPlay &8&l(&abought&8&l)", "Shop.Heads.10.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7Set the head from GermanLetsPlay on your head", "Shop.Heads.10.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(1000, "Shop.Heads.10.price", Variable.shopConfig, Variable.shopFile);
		
		//Shop Boots
		cm.setBoolean(true, "Shop.Boots.1.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(180, "Shop.Boots.1.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.1.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.1.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lHeart &e&lBoots &8&l(&cbuy&8&l)", "Shop.Boots.1.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.1.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lHeart &e&lBoots &8&l(&abought&8&l)", "Shop.Boots.1.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.1.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(2000, "Shop.Boots.1.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setBoolean(true, "Shop.Boots.2.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(40, "Shop.Boots.2.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(40, "Shop.Boots.2.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(40, "Shop.Boots.2.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lBroken Heart &e&lBoots &8&l(&cbuy&8&l)", "Shop.Boots.2.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.2.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lBroken Heart &e&lBoots &8&l(&abought&8&l)", "Shop.Boots.2.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.2.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(2000, "Shop.Boots.2.price", Variable.shopConfig, Variable.shopFile);

		cm.setBoolean(true, "Shop.Boots.3.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(160, "Shop.Boots.3.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(160, "Shop.Boots.3.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(160, "Shop.Boots.3.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7&lNote &e&lBoots &8&l(&cbuy&8&l)", "Shop.Boots.3.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.3.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7&lNote &e&lBoots &8&l(&abought&8&l)", "Shop.Boots.3.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.3.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(2000, "Shop.Boots.3.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setBoolean(true, "Shop.Boots.4.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(255, "Shop.Boots.4.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(140, "Shop.Boots.4.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(20, "Shop.Boots.4.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lLava &e&lBoots &8&l(&cbuy&8&l)", "Shop.Boots.4.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.4.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lLava &e&lBoots &8&l(&abought&8&l)", "Shop.Boots.4.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.4.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(2000, "Shop.Boots.4.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setBoolean(true, "Shop.Boots.5.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(255, "Shop.Boots.5.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.5.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.5.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lRedstone &e&lBoots &8&l(&cbuy&8&l)", "Shop.Boots.5.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.5.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lRedstone &e&lBoots &8&l(&abought&8&l)", "Shop.Boots.5.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.5.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(2000, "Shop.Boots.5.price", Variable.shopConfig, Variable.shopFile);

		cm.setBoolean(true, "Shop.Boots.6.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.6.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(220, "Shop.Boots.6.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(220, "Shop.Boots.6.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&b&lDiamond &e&lBoots &8&l(&cbuy&8&l)", "Shop.Boots.6.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.6.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&b&lDiamond &e&lBoots &8&l(&abought&8&l)", "Shop.Boots.6.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.6.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(2000, "Shop.Boots.6.price", Variable.shopConfig, Variable.shopFile);

		cm.setBoolean(true, "Shop.Boots.7.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(60, "Shop.Boots.7.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(255, "Shop.Boots.7.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.7.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&a&lEmerald &e&lBoots &8&l(&cbuy&8&l)", "Shop.Boots.7.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.7.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&a&lEmerald &e&lBoots &8&l(&abought&8&l)", "Shop.Boots.7.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.7.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(2000, "Shop.Boots.7.price", Variable.shopConfig, Variable.shopFile);

		cm.setBoolean(true, "Shop.Boots.8.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(255, "Shop.Boots.8.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(255, "Shop.Boots.8.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(255, "Shop.Boots.8.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lR&6&la&e&li&a&ln&b&lb&9&lo&d&lw &e&lBoots &8&l(&cbuy&8&l)", "Shop.Boots.8.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.8.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lR&6&la&e&li&a&ln&b&lb&9&lo&d&lw &e&lBoots &8&l(&abought&8&l)", "Shop.Boots.8.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.8.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(3000, "Shop.Boots.8.price", Variable.shopConfig, Variable.shopFile);

		cm.setBoolean(false, "Shop.Boots.9.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.9.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.9.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.9.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Boots.9.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.9.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Boots.9.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.9.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.9.price", Variable.shopConfig, Variable.shopFile);

		cm.setBoolean(false, "Shop.Boots.10.color.enabled", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.10.color.red", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.10.color.green", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.10.color.blue", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Boots.10.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.10.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Boots.10.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Boots.10.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Boots.10.price", Variable.shopConfig, Variable.shopFile);
		
		//Shop Gadgets
		//Enterhaken	Reitende Enderperle		Lightning bow	explosions tnt/schneball	(farb bombe)
		cm.setString("FISHING_ROD", "Shop.Extras.1.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.1.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&2&lGrappling Hook &8&l(&cbuy&8&l)", "Shop.Extras.1.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.1.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&2&lGrappling Hook &8&l(&abought&8&l)", "Shop.Extras.1.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.1.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(5000, "Shop.Extras.1.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("ENDER_PEARL", "Shop.Extras.2.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.2.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&5&lEnder pearl &8&l(&cbuy&8&l)", "Shop.Extras.2.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.2.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&5&lEnder pearl &8&l(&abought&8&l)", "Shop.Extras.2.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.2.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(5000, "Shop.Extras.2.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("BOW", "Shop.Extras.3.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.3.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&9&lLightning bow &8&l(&cbuy&8&l)", "Shop.Extras.3.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.3.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&9&lLightning bow &8&l(&abought&8&l)", "Shop.Extras.3.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.3.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(5000, "Shop.Extras.3.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("TNT", "Shop.Extras.4.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.4.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lExplosive TnT &8&l(&cbuy&8&l)", "Shop.Extras.4.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.4.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&c&lExplosive Tnt &8&l(&abought&8&l)", "Shop.Extras.4.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.4.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(5000, "Shop.Extras.4.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("SNOW_BALL", "Shop.Extras.5.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.5.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&f&lColor bomb &8&l(&cbuy&8&l)", "Shop.Extras.5.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.5.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&f&lColor bomb &8&l(&abought&8&l)", "Shop.Extras.5.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.5.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(5000, "Shop.Extras.5.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("BARRIER", "Shop.Extras.6.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.6.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.6.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.6.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.6.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.6.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.6.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("BARRIER", "Shop.Extras.7.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.7.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.7.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.7.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.7.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.7.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.7.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("BARRIER", "Shop.Extras.8.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.8.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.8.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.8.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.8.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.8.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.8.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("BARRIER", "Shop.Extras.9.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.9.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.9.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.9.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.9.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.9.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.9.price", Variable.shopConfig, Variable.shopFile);
		
		cm.setString("BARRIER", "Shop.Extras.10.material", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.10.subID", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.10.sale.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.10.sale.lore", Variable.shopConfig, Variable.shopFile);
		cm.setString("&4&lComing soon", "Shop.Extras.10.bought.name", Variable.shopConfig, Variable.shopFile);
		cm.setString("&7", "Shop.Extras.10.bought.lore", Variable.shopConfig, Variable.shopFile);
		cm.setInt(0, "Shop.Extras.10.price", Variable.shopConfig, Variable.shopFile);
	}
	
	public void setNavigatorConfig() {
		cm.setBoolean(true, "Navigator.sound", Variable.navigatorConfig, Variable.navigatorFile);
		cm.setInt(9, "Navigator.inventorySize", Variable.navigatorConfig, Variable.navigatorFile);
		cm.setString("Change in the navigator menu", "Navigator.inventoryTitle", Variable.navigatorConfig, Variable.navigatorFile);
		
	}
}
