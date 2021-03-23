package de.deda.lobby.program;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.deda.lobby.commands.FlyCommand;
import de.deda.lobby.listener.InventoryClickListener;
import de.deda.lobby.main.Lobby;
import de.deda.lobby.program.itemInventory.Gadgets;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class Items {

	ConfigManager config = new ConfigManager();
	
	public ItemStack getJoinItems(String type) {
		switch(type) {
		case "playerhider":
			if(!config.getBoolean("JoinItems.PlayerHider.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String hiderMaterial = config.getSimpleString("JoinItems.PlayerHider.material", Variable.itemConfig);
			int hiderSubID = config.getInt("JoinItems.PlayerHider.subID", Variable.itemConfig);
			String hiderDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.PlayerHider.name", Variable.itemConfig));
			String hiderLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.PlayerHider.lore", Variable.itemConfig));
			String[] hiderLoreArray = hiderLore.split("/n");
			List<String> hiderLoreList = new ArrayList<String>();
			for(int i=0; i<hiderLoreArray.length; i++)
				hiderLoreList.add(hiderLoreArray[i]);
			
			ItemStack hiderItem = new ItemStack(Material.getMaterial(hiderMaterial), 1, (short) hiderSubID);
			ItemMeta hiderMeta = hiderItem.getItemMeta();
			hiderMeta.setDisplayName(hiderDisplayName);
			hiderMeta.setLore(hiderLoreList);
			hiderItem.setItemMeta(hiderMeta);
			return hiderItem;
			
		case "gadget":
			if(!config.getBoolean("JoinItems.Gadget.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String gadgetMaterial = config.getSimpleString("JoinItems.Gadget.material", Variable.itemConfig);
			int gadgetSubID = config.getInt("JoinItems.Gadget.subID", Variable.itemConfig);
			String gadgetDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.Gadget.name", Variable.itemConfig));
			String gadgetLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.Gadget.lore", Variable.itemConfig));
			String[] gadgetLoreArray = gadgetLore.split("/n");
			List<String> gadgetLoreList = new ArrayList<String>();
			for(int i=0; i<gadgetLoreArray.length; i++)
				gadgetLoreList.add(gadgetLoreArray[i]);
			
			ItemStack gadgetItem = new ItemStack(Material.getMaterial(gadgetMaterial), 1, (short) gadgetSubID);
			ItemMeta gadgetMeta = gadgetItem.getItemMeta();
			gadgetMeta.setDisplayName(gadgetDisplayName);
			gadgetMeta.setLore(gadgetLoreList);
			gadgetItem.setItemMeta(gadgetMeta);
			return gadgetItem;
			
		case "noneselectedgadget":
			if(!config.getBoolean("JoinItems.Gadget.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String noneSelectedMaterial = config.getSimpleString("JoinItems.Gadget.noSelected.material", Variable.itemConfig);
			int noneSelectedSubID = config.getInt("JoinItems.Gadget.noSelected.subID", Variable.itemConfig);
			String noneSelectedDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.Gadget.noSelected.name", Variable.itemConfig));
			String noneSelectedLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.Gadget.noSelected.lore", Variable.itemConfig));
			String[] noneSelectedLoreArray = noneSelectedLore.split("/n");
			List<String> noneSelectedLoreList = new ArrayList<String>();
			for(int i=0; i<noneSelectedLoreArray.length; i++)
				noneSelectedLoreList.add(noneSelectedLoreArray[i]);
			
			ItemStack noneSelectedItem = new ItemStack(Material.getMaterial(noneSelectedMaterial), 1, (short) noneSelectedSubID);
			ItemMeta noneSelectedMeta = noneSelectedItem.getItemMeta();
			noneSelectedMeta.setDisplayName(noneSelectedDisplayName);
			noneSelectedMeta.setLore(noneSelectedLoreList);
			noneSelectedItem.setItemMeta(noneSelectedMeta);
			return noneSelectedItem;
			
		case "navigator":
			if(!config.getBoolean("JoinItems.Navigator.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String navigatorMaterial = config.getSimpleString("JoinItems.Navigator.material", Variable.itemConfig);
			int navigatorSubID = config.getInt("JoinItems.Navigator.subID", Variable.itemConfig);
			String navigatorDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.Navigator.name", Variable.itemConfig));
			String navigatorLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.Navigator.lore", Variable.itemConfig));
			String[] navigatorLoreArray = navigatorLore.split("/n");
			List<String> navigatorLoreList = new ArrayList<String>();
			for(int i=0; i<navigatorLoreArray.length; i++)
				navigatorLoreList.add(navigatorLoreArray[i]);
			
			ItemStack navigatorItem = new ItemStack(Material.getMaterial(navigatorMaterial), 1, (short) navigatorSubID);
			ItemMeta navigatorMeta = navigatorItem.getItemMeta();
			navigatorMeta.setDisplayName(navigatorDisplayName);
			navigatorMeta.setLore(navigatorLoreList);
			navigatorItem.setItemMeta(navigatorMeta);
			return navigatorItem;
			
		case "lobbyswitcher":
			if(!config.getBoolean("JoinItems.LobbySwitcher.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String lobbyMaterial = config.getSimpleString("JoinItems.LobbySwitcher.material", Variable.itemConfig);
			int lobbySubID = config.getInt("JoinItems.LobbySwitcher.subID", Variable.itemConfig);
			String lobbyDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.LobbySwitcher.name", Variable.itemConfig));
			String lobbyLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.LobbySwitcher.lore", Variable.itemConfig));
			String[] lobbyLoreArray = lobbyLore.split("/n");
			List<String> lobbyLoreList = new ArrayList<String>();
			for(int i=0; i<lobbyLoreArray.length; i++)
				lobbyLoreList.add(lobbyLoreArray[i]);
			
			ItemStack lobbyItem = new ItemStack(Material.getMaterial(lobbyMaterial), 1, (short) lobbySubID);
			ItemMeta lobbyMeta = lobbyItem.getItemMeta();
			lobbyMeta.setDisplayName(lobbyDisplayName);
			lobbyMeta.setLore(lobbyLoreList);
			lobbyItem.setItemMeta(lobbyMeta);
			return lobbyItem;
			
		case "settings":
			if(!config.getBoolean("JoinItems.Settings.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String settingsMaterial = config.getSimpleString("JoinItems.Settings.material", Variable.itemConfig);
			int settingsSubID = config.getInt("JoinItems.Settings.subID", Variable.itemConfig);
			String settingsDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.Settings.name", Variable.itemConfig));
			String settingsLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("JoinItems.Settings.lore", Variable.itemConfig));
			String[] settingsLoreArray = settingsLore.split("/n");
			List<String> settingsLoreList = new ArrayList<String>();
			for(int i=0; i<settingsLoreArray.length; i++)
				settingsLoreList.add(settingsLoreArray[i]);
			
			ItemStack settingsItem = new ItemStack(Material.getMaterial(settingsMaterial), 1, (short) settingsSubID);
			ItemMeta settingsMeta = settingsItem.getItemMeta();
			settingsMeta.setDisplayName(settingsDisplayName);
			settingsMeta.setLore(settingsLoreList);
			settingsItem.setItemMeta(settingsMeta);
			return settingsItem;
		}
		return new ItemStack(Material.AIR);
	}
	
	public ItemStack getSneakItems(String type) {
		switch (type) {
		case "buildmode":
			if(!config.getBoolean("SneakItems.BuildMode.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String buildMaterial = config.getSimpleString("SneakItems.BuildMode.material", Variable.itemConfig);
			int buildSubID = config.getInt("SneakItems.BuildMode.subID", Variable.itemConfig);
			String buildDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.BuildMode.name", Variable.itemConfig));
			String buildLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.BuildMode.lore", Variable.itemConfig));
			String[] buildLoreArray = buildLore.split("/n");
			List<String> buildLoreList = new ArrayList<String>();
			for(int i=0; i<buildLoreArray.length; i++)
				buildLoreList.add(buildLoreArray[i]);
			
			ItemStack buildItem = new ItemStack(Material.getMaterial(buildMaterial), 1, (short) buildSubID);
			ItemMeta buildMeta = buildItem.getItemMeta();
			buildMeta.setDisplayName(buildDisplayName);
			buildMeta.setLore(buildLoreList);
			buildItem.setItemMeta(buildMeta);
			return buildItem;
			
		case "teamserver":
			if(!config.getBoolean("SneakItems.TeamServer.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String teamMaterial = config.getSimpleString("SneakItems.TeamServer.material", Variable.itemConfig);
			int teamSubID = config.getInt("SneakItems.TeamServer.subID", Variable.itemConfig);
			String teamDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.TeamServer.name", Variable.itemConfig));
			String teamLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.TeamServer.lore", Variable.itemConfig));
			String[] teamLoreArray = teamLore.split("/n");
			List<String> teamLoreList = new ArrayList<String>();
			for(int i=0; i<teamLoreArray.length; i++)
				teamLoreList.add(teamLoreArray[i]);
			
			ItemStack teamItem = new ItemStack(Material.getMaterial(teamMaterial), 1, (short) teamSubID);
			ItemMeta teamMeta = teamItem.getItemMeta();
			teamMeta.setDisplayName(teamDisplayName);
			teamMeta.setLore(teamLoreList);
			teamItem.setItemMeta(teamMeta);
			return teamItem;
			
		case "nick":
			if(!config.getBoolean("SneakItems.Nick.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String nickMaterial = config.getSimpleString("SneakItems.Nick.material", Variable.itemConfig);
			int nickSubID = config.getInt("SneakItems.Nick.subID", Variable.itemConfig);
			String nickDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.Nick.name", Variable.itemConfig));
			String nickLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.Nick.lore", Variable.itemConfig));
			String[] nickLoreArray = nickLore.split("/n");
			List<String> nickLoreList = new ArrayList<String>();
			for(int i=0; i<nickLoreArray.length; i++)
				nickLoreList.add(nickLoreArray[i]);
			
			ItemStack nickItem = new ItemStack(Material.getMaterial(nickMaterial), 1, (short) nickSubID);
			ItemMeta nickMeta = nickItem.getItemMeta();
			nickMeta.setDisplayName(nickDisplayName);
			nickMeta.setLore(nickLoreList);
			nickItem.setItemMeta(nickMeta);
			return nickItem;
			
		case "flyoff":
			if(!config.getBoolean("SneakItems.Fly.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String flyMaterial = config.getSimpleString("SneakItems.Fly.material", Variable.itemConfig);
			int flySubID = config.getInt("SneakItems.Fly.subID", Variable.itemConfig);
			String flyDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.Fly.name.disabled", Variable.itemConfig));
			String flyLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.Fly.lore", Variable.itemConfig));
			String[] flyLoreArray = flyLore.split("/n");
			List<String> flyLoreList = new ArrayList<String>();
			for(int i=0; i<flyLoreArray.length; i++)
				flyLoreList.add(flyLoreArray[i]);
			
			ItemStack flyItem = new ItemStack(Material.getMaterial(flyMaterial), 1, (short) flySubID);
			ItemMeta flyMeta = flyItem.getItemMeta();
			flyMeta.setDisplayName(flyDisplayName);
			flyMeta.setLore(flyLoreList);
			flyItem.setItemMeta(flyMeta);
			return flyItem;
			
		case "flyon":
			if(!config.getBoolean("SneakItems.Fly.enabled", Variable.itemConfig))
				return new ItemStack(Material.AIR);
			String flyOnMaterial = config.getSimpleString("SneakItems.Fly.material", Variable.itemConfig);
			int flyOnSubID = config.getInt("SneakItems.Fly.subID", Variable.itemConfig);
			String flyOnDisplayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.Fly.name.enabled", Variable.itemConfig));
			String flyOnLore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("SneakItems.Fly.lore", Variable.itemConfig));
			String[] flyOnLoreArray = flyOnLore.split("/n");
			List<String> flyOnLoreList = new ArrayList<String>();
			for(int i=0; i<flyOnLoreArray.length; i++)
				flyOnLoreList.add(flyOnLoreArray[i]);
			
			ItemStack flyOnItem = new ItemStack(Material.getMaterial(flyOnMaterial), 1, (short) flyOnSubID);
			ItemMeta flyOnMeta = flyOnItem.getItemMeta();
			flyOnMeta.setDisplayName(flyOnDisplayName);
			flyOnMeta.setLore(flyOnLoreList);
			flyOnItem.setItemMeta(flyOnMeta);
			return flyOnItem;
		}
		return new ItemStack(Material.AIR);
	}
	
	public void setJoinItems(Player player) {
		Inventory inv = player.getInventory();
		inv.clear();
		inv.setItem(config.getInt("JoinItems.PlayerHider.slot", Variable.itemConfig)-1, getJoinItems("playerhider"));
		inv.setItem(config.getInt("JoinItems.Gadget.slot", Variable.itemConfig)-1, getJoinItems("gadget"));
		inv.setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, getJoinItems("noneselectedgadget"));
		inv.setItem(config.getInt("JoinItems.Navigator.slot", Variable.itemConfig)-1, getJoinItems("navigator"));
		inv.setItem(config.getInt("JoinItems.LobbySwitcher.slot", Variable.itemConfig)-1, getJoinItems("lobbyswitcher"));
		inv.setItem(config.getInt("JoinItems.Settings.slot", Variable.itemConfig)-1, getJoinItems("settings"));
	}
	
	public void setSneakItems(Player player) {
		Inventory inv = player.getInventory();
		inv.clear();
		inv.setItem(config.getInt("SneakItems.BuildMode.slot", Variable.itemConfig)-1, getSneakItems("buildmode"));
		inv.setItem(config.getInt("SneakItems.TeamServer.slot", Variable.itemConfig)-1, getSneakItems("teamserver"));
		inv.setItem(config.getInt("SneakItems.Nick.slot", Variable.itemConfig)-1, getSneakItems("nick"));
		
		if(FlyCommand.fly.contains(player.getUniqueId())) {
			inv.setItem(config.getInt("SneakItems.Fly.slot", Variable.itemConfig)-1, getSneakItems("flyon"));
		} else
			inv.setItem(config.getInt("SneakItems.Fly.slot", Variable.itemConfig)-1, getSneakItems("flyoff"));
	}
	
	public ItemStack getCooldownItem(String displayname) {
		return createItem(Material.FIREBALL, 1, (short) 0, displayname);
	}
	
	public ItemStack createItem(Material material, int amount, short damage, String displayName) {
		ItemStack item =  new ItemStack(material, amount, damage);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack getConfigItem(String path) {
		String material = config.getSimpleString(path+".material", Variable.gadgetsConfig);
		int subID = config.getInt(path+".subID", Variable.gadgetsConfig);
		String displayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString(path+".name", Variable.gadgetsConfig));
		String lore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString(path+".lore", Variable.gadgetsConfig));
		String[] loreArray = lore.split("/n");
		List<String> loreList = new ArrayList<String>();
		for(int i=0; i<loreArray.length; i++)
			loreList.add(loreArray[i]);
		
		ItemStack item = new ItemStack(Material.getMaterial(material), 1, (short) subID);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(loreList);
		item.setItemMeta(meta);
		return item;
	}
	
	public void setCooldownItem(Player player) {
		player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, getCooldownItem("§8§lCooldown §3§l5"));
		Bukkit.getScheduler().runTaskLater(Lobby.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, getCooldownItem("§8§lCooldown §3§l4"));
				Bukkit.getScheduler().runTaskLater(Lobby.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, getCooldownItem("§8§lCooldown §3§l3"));
						Bukkit.getScheduler().runTaskLater(Lobby.getPlugin(), new Runnable() {
							
							@Override
							public void run() {
								player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, getCooldownItem("§8§lCooldown §3§l2"));
								Bukkit.getScheduler().runTaskLater(Lobby.getPlugin(), new Runnable() {
									
									@Override
									public void run() {
										player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, getCooldownItem("§8§lCooldown §3§l1"));
										Bukkit.getScheduler().runTaskLater(Lobby.getPlugin(), new Runnable() {
											
											@Override
											public void run() {
												if(InventoryClickListener.extrasItem.containsKey(player.getUniqueId())) {
													if(InventoryClickListener.extrasItem.containsValue(1))
														player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(1, player));
													if(InventoryClickListener.extrasItem.containsValue(2))
														player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(2, player));
													if(InventoryClickListener.extrasItem.containsValue(3)) {
														player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(3, player));
														player.getInventory().setItem(9, new ItemStack(Material.ARROW, 1));
													}
													if(InventoryClickListener.extrasItem.containsValue(4))
														player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(4, player));
													if(InventoryClickListener.extrasItem.containsValue(5))
														player.getInventory().setItem(config.getInt("JoinItems.Gadget.noSelected.slot", Variable.itemConfig)-1, Gadgets.getGadgetsExtras(5, player));
												}
											}
										}, 20);
									}
								}, 20);
							}
						}, 20);
					}
				}, 20);
			}
		}, 20);
	}
}
