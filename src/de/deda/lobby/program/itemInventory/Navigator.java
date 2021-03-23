package de.deda.lobby.program.itemInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.deda.lobby.program.Items;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class Navigator {

	static ConfigManager config = new ConfigManager();
	static Items items = new Items();
	public static Inventory navigatorMenu = Bukkit.createInventory(null, 9, "Navigator menu");
	public static Inventory navigatorInvSize = Bukkit.createInventory(null, 9, "Navigator inventory size");
	public static Inventory navigatorEditModeSize9 = Bukkit.createInventory(null, 9, "Configurate your navigator");
	public static Inventory navigatorEditModeSize18 = Bukkit.createInventory(null, 18, "Configurate your navigator");
	public static Inventory navigatorEditModeSize27 = Bukkit.createInventory(null, 27, "Configurate your navigator");
	public static Inventory navigatorEditModeSize36 = Bukkit.createInventory(null, 36, "Configurate your navigator");
	public static Inventory navigatorEditModeSize45 = Bukkit.createInventory(null, 45, "Configurate your navigator");
	public static Inventory navigatorEditModeSize54 = Bukkit.createInventory(null, 54, "Configurate your navigator");
	
	public static Inventory navigatorItemClickEditMode = Bukkit.createInventory(null, 9, "Configurate the item");
	public static Inventory navigatorAddItemSound = Bukkit.createInventory(null, 9, "Add sound");
	public static Inventory navigatorAddItemParticle = Bukkit.createInventory(null, 9, "Add particle");
	
	public static Inventory navigatorInventory = Bukkit.createInventory(null, config.getNavigatorInt("Navigator.inventorySize", Variable.navigatorConfig), config.getNavigatorString("Navigator.inventoryTitle", Variable.navigatorConfig));
	public static List<UUID> setNavigatorTitle = new ArrayList<UUID>();
	public static Map<UUID, ItemStack> navigatorClickItem = new HashMap<UUID, ItemStack>();
	public static Map<UUID, Integer> navigatorClickSlot = new HashMap<UUID, Integer>();
	
	public static void openNavigatorInventory(Player player) {
		for(int i=0;i<navigatorInventory.getSize();i++)
			navigatorInventory.setItem(i, getNavigatorItems(i));
		
		if(config.getBoolean("Navigator.sound", Variable.navigatorConfig))
			player.playSound(player.getLocation(), Sound.CLICK, 2, 2);
		player.openInventory(navigatorInventory);
	}
	
	public static void openNavigatorMenu(Player player) {
		for(int i=0;i<navigatorMenu.getSize();i++)
			navigatorMenu.setItem(i, items.createItem(Material.STAINED_GLASS_PANE, 1, (short) 15, " "));
		
		List<String> lore = new ArrayList<String>();
		ItemStack navInvSizeItem = items.createItem(Material.BOOK, 1, (short) 0, "§f§lNavigator inventory size");
		ItemMeta navInvSizeMeta = navInvSizeItem.getItemMeta();
		lore.clear();
		lore.add("§f§lSet navigator inventory size");
		navInvSizeMeta.setLore(lore);
		navInvSizeItem.setItemMeta(navInvSizeMeta);
		
		ItemStack navInvItem = items.createItem(Material.COMPASS, 1, (short) 0, "§f§lNavigator inventory");
		ItemMeta navInvMeta = navInvItem.getItemMeta();
		lore.clear();
		lore.add("§f§lSet navigator inventory items");
		lore.add("§a§l");
		lore.add("§4§lWARNING!");
		lore.add("§8§l- §e§lClose inventory to save");
		lore.add("§8§l- §e§lShift & right-click on a item to add actions");
		navInvMeta.setLore(lore);
		navInvItem.setItemMeta(navInvMeta);
		
		ItemStack navInvTitleItem = items.createItem(Material.PAPER, 1, (short) 0, "§f§lNavigator inventory title");
		ItemMeta navInvTitleMeta = navInvTitleItem.getItemMeta();
		lore.clear();
		lore.add("§f§lSet navigator inventory title");
		lore.add("§a§l");
		lore.add("§4§lWARNING!");
		lore.add("§8§l- §e§lDont use more than 32 character");
		navInvTitleMeta.setLore(lore);
		navInvTitleItem.setItemMeta(navInvTitleMeta);
		
		navigatorMenu.setItem(2, navInvSizeItem);
		navigatorMenu.setItem(4, navInvItem);
		navigatorMenu.setItem(6, navInvTitleItem);
		
		player.openInventory(navigatorMenu);
	}
	
	public static void openNavigatorItemClickInv(Player player, ItemStack item, int slot) {
		//Not configurable
		ItemStack itemBlack = items.createItem(Material.STAINED_GLASS_PANE, 1, (short) 15, " ");
		//Not configurable
		ItemStack itemRed = items.createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4§lBack");
		//Not configurable
		ItemStack itemSlot = items.createItem(Material.BOOK, slot, (short) 0, "§f§lSlot "+slot);
			
		List<String> lore = new ArrayList<String>();
		ItemStack itemTeleport = items.createItem(Material.ENDER_PEARL, 1, (short) 0, "§f§lTeleport");
		ItemMeta metaTeleport = itemTeleport.getItemMeta();
		lore.clear();
		lore.add("§f§lAdd teleportation");
		lore.add("§4");
		lore.add("§4§lWARNING!");
		lore.add("§8§l- §e§lUse your current location");
		metaTeleport.setLore(lore);
		itemTeleport.setItemMeta(metaTeleport);
		
		ItemStack itemSound = items.createItem(Material.NOTE_BLOCK, 1, (short) 0, "§f§lSound");
		ItemMeta metaSound = itemSound.getItemMeta();
		lore.clear();
		lore.add("§f§lAdd sound");
		lore.add("§4");
		lore.add("§4§lWARNING!");
		lore.add("§8§l- §e§lLeft click to add sound");
		lore.add("§8§l- §e§lRight click to test sounds");
		metaSound.setLore(lore);
		itemSound.setItemMeta(metaSound);
		
		ItemStack itemParticle = items.createItem(Material.BLAZE_POWDER, 1, (short) 0, "§f§lParticle");
		ItemMeta metaParticle = itemParticle.getItemMeta();
		lore.clear();
		lore.add("§f§lAdd particle");
		lore.add("§4");
		lore.add("§4§lWARNING!");
		lore.add("§8§l- §e§lLeft click to add particle");
		lore.add("§8§l- §e§lRight click to test particles");
		metaParticle.setLore(lore);
		itemParticle.setItemMeta(metaParticle);
		
		navigatorItemClickEditMode.setItem(0, item);
		navigatorItemClickEditMode.setItem(1, itemSlot);
		navigatorItemClickEditMode.setItem(3, itemTeleport);
		navigatorItemClickEditMode.setItem(4, itemSound);
		navigatorItemClickEditMode.setItem(5, itemParticle);
		navigatorItemClickEditMode.setItem(2, itemBlack);
		navigatorItemClickEditMode.setItem(6, itemBlack);
		navigatorItemClickEditMode.setItem(7, itemBlack);
		navigatorItemClickEditMode.setItem(8, itemRed);
		
		player.openInventory(navigatorItemClickEditMode);
	}
	
	public static void openNavigatorInvSize(Player player) {
		//Not configurable
		ItemStack itemBlack = items.createItem(Material.STAINED_GLASS_PANE, 1, (short) 15, " ");
		
		navigatorInvSize.setItem(1, items.createItem(Material.BOOK, 1, (short) 0, "§f§l9 Slots"));
		navigatorInvSize.setItem(2, items.createItem(Material.BOOK, 2, (short) 0, "§f§l18 Slots"));
		navigatorInvSize.setItem(3, items.createItem(Material.BOOK, 3, (short) 0, "§f§l27 Slots"));
		navigatorInvSize.setItem(5, items.createItem(Material.BOOK, 4, (short) 0, "§f§l36 Slots"));
		navigatorInvSize.setItem(6, items.createItem(Material.BOOK, 5, (short) 0, "§f§l45 Slots"));
		navigatorInvSize.setItem(7, items.createItem(Material.BOOK, 6, (short) 0, "§f§l54 Slots"));
		navigatorInvSize.setItem(0, itemBlack);
		navigatorInvSize.setItem(4, itemBlack);
		navigatorInvSize.setItem(8, itemBlack);
		
		player.openInventory(navigatorInvSize);
	}
	
	public static void openNavigatorEditMode(Player player) {
		switch(config.getInt("Navigator.inventorySize", Variable.navigatorConfig)) {
		case 9:
			for(int i=0;i<navigatorEditModeSize9.getSize();i++)
				navigatorEditModeSize9.setItem(i, getNavigatorItems(i));
			player.openInventory(navigatorEditModeSize9);
			return;
		case 18:
			for(int i=0;i<navigatorEditModeSize18.getSize();i++)
				navigatorEditModeSize18.setItem(i, getNavigatorItems(i));
			player.openInventory(navigatorEditModeSize18);
			return;
		case 27:
			for(int i=0;i<navigatorEditModeSize27.getSize();i++)
				navigatorEditModeSize27.setItem(i, getNavigatorItems(i));
			player.openInventory(navigatorEditModeSize27);
			return;
		case 36:
			for(int i=0;i<navigatorEditModeSize36.getSize();i++)
				navigatorEditModeSize36.setItem(i, getNavigatorItems(i));
			player.openInventory(navigatorEditModeSize36);
			return;
		case 45:
			for(int i=0;i<navigatorEditModeSize45.getSize();i++)
				navigatorEditModeSize45.setItem(i, getNavigatorItems(i));
			player.openInventory(navigatorEditModeSize45);
			return;
		case 54:
			for(int i=0;i<navigatorEditModeSize54.getSize();i++)
				navigatorEditModeSize54.setItem(i, getNavigatorItems(i));
			player.openInventory(navigatorEditModeSize54);
			return;
		default:
			player.sendMessage("§c§lChoose first the inventory size!");
			return;
		}
	}
	
	public static void openNavigatorAddItemSoundInventory(Player player) {
		//Not configurable
		ItemStack itemRed = items.createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4§lBack");
		navigatorAddItemSound.setItem(8, itemRed);
		
		navigatorAddItemSound.setItem(0, items.createItem(Material.ENDER_PEARL, 1, (short) 0, "§f§lEnderman teleport sound"));
		navigatorAddItemSound.setItem(1, items.createItem(Material.DRAGON_EGG, 1, (short) 0, "§f§lEnderdragon growl sound"));
		navigatorAddItemSound.setItem(2, items.createItem(Material.NOTE_BLOCK, 1, (short) 0, "§f§lNote bass sound"));
		navigatorAddItemSound.setItem(3, items.createItem(Material.SPECKLED_MELON, 1, (short) 0, "§f§lOrb pickup sound"));
		navigatorAddItemSound.setItem(4, items.createItem(Material.EXP_BOTTLE, 1, (short) 0, "§f§lLevel up sound"));
		navigatorAddItemSound.setItem(5, items.createItem(Material.TNT, 1, (short) 0, "§f§lExplode sound"));
		navigatorAddItemSound.setItem(6, items.createItem(Material.MAGMA_CREAM, 1, (short) 0, "§f§lPortal trigger sound"));
		navigatorAddItemSound.setItem(7, items.createItem(Material.NETHER_STAR, 1, (short) 0, "§f§lWither spawn sound"));
		
		player.openInventory(navigatorAddItemSound);
	}
	
	public static void openNavigatorAddItemParticleInventory(Player player) {
		//Not configurable
		ItemStack itemRed = items.createItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4§lBack");
		navigatorAddItemParticle.setItem(8, itemRed);
		
		navigatorAddItemParticle.setItem(0, items.createItem(Material.ENDER_PEARL, 1, (short) 0, "§f§lEnder signal particle"));
		navigatorAddItemParticle.setItem(1, items.createItem(Material.MOB_SPAWNER, 1, (short) 0, "§f§lModspawner flames particle"));
		navigatorAddItemParticle.setItem(2, items.createItem(Material.OBSIDIAN, 1, (short) 0, "§f§lNether portal particle"));
		navigatorAddItemParticle.setItem(3, items.createItem(Material.FLINT_AND_STEEL, 1, (short) 0, "§f§lSmoke particle"));
		navigatorAddItemParticle.setItem(4, items.createItem(Material.CAULDRON_ITEM, 1, (short) 0, "§f§lWitch magic particle"));
		navigatorAddItemParticle.setItem(5, items.createItem(Material.INK_SACK, 1, (short) 13, "§f§lMagic crit particle"));
		navigatorAddItemParticle.setItem(6, items.createItem(Material.INK_SACK, 1, (short) 8, "§f§lInstant spell particle"));
		navigatorAddItemParticle.setItem(7, items.createItem(Material.BLAZE_POWDER, 1, (short) 0, "§f§lFlame particle"));
		
		player.openInventory(navigatorAddItemParticle);
	}
	
	public static void setNavigatorConfigItems(Inventory inventory) {
		for(int i=0;i<inventory.getSize();i++) {
			if(inventory.getItem(i) != null) {
				config.setString(inventory.getItem(i).getType().toString(), "Navigator."+i+".material", Variable.navigatorConfig, Variable.navigatorFile);
				config.setInt(inventory.getItem(i).getDurability(), "Navigator."+i+".subID", Variable.navigatorConfig, Variable.navigatorFile);
				config.setInt(inventory.getItem(i).getAmount(), "Navigator."+i+".amount", Variable.navigatorConfig, Variable.navigatorFile);
				config.setString(inventory.getItem(i).getItemMeta().getDisplayName().replace('§', '&'), "Navigator."+i+".name", Variable.navigatorConfig, Variable.navigatorFile);
				
				if(inventory.getItem(i).getItemMeta().getLore() != null) {
					String lore = inventory.getItem(i).getItemMeta().getLore().toString().replace('§', '&').replace('[', ' ').replace(']', ' ').replace(", ", "/n");
					config.setString(lore, "Navigator."+i+".lore", Variable.navigatorConfig, Variable.navigatorFile);
				} else {
					config.setString("", "Navigator."+i+".lore", Variable.navigatorConfig, Variable.navigatorFile);
				}
			} else
				config.setString(null, "Navigator."+i, Variable.navigatorConfig, Variable.navigatorFile);
		}
	}
	
	public static ItemStack getNavigatorItems(int number) {
		if(config.getSimpleString("Navigator."+number+".material", Variable.navigatorConfig) == null)
			return new ItemStack(Material.AIR);
		
		String material = config.getSimpleString("Navigator."+number+".material", Variable.navigatorConfig);
		int subID = config.getInt("Navigator."+number+".subID", Variable.navigatorConfig);
		int amount = config.getInt("Navigator."+number+".amount", Variable.navigatorConfig);
		String displayName = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Navigator."+number+".name", Variable.navigatorConfig));
		if(config.getSimpleString("Navigator."+number+".lore", Variable.navigatorConfig) == null) {
			ItemStack item = new ItemStack(Material.getMaterial(material), amount, (short) subID);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(displayName);
			item.setItemMeta(meta);
			return item;
		}
			
		String lore = ChatColor.translateAlternateColorCodes('&', config.getSimpleString("Navigator."+number+".lore", Variable.navigatorConfig).trim());
		String[] loreArray = lore.split("/n");
		List<String> loreList = new ArrayList<String>();
		for(int j=0; j<loreArray.length; j++)
			loreList.add(loreArray[j]);
		
		ItemStack item = new ItemStack(Material.getMaterial(material), amount, (short) subID);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(loreList);
		item.setItemMeta(meta);
		return item;
	}
	
}
