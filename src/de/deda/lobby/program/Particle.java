package de.deda.lobby.program;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.deda.lobby.main.Lobby;

public class Particle {
	
	@SuppressWarnings("deprecation")
	public static void sendBootsEffect(Player player, int type) {
		switch(type) {
			case 1:
				player.playEffect(player.getLocation().add(0, 2, 0), Effect.HEART, 1);
				break;
			case 2:
				player.playEffect(player.getLocation().add(0, 2, 0), Effect.VILLAGER_THUNDERCLOUD, 1);
				break;
			case 3:
				player.playEffect(player.getLocation().add(0, 2, 0), Effect.NOTE, 1);
				break;
			case 4:
				player.playEffect(player.getLocation(), Effect.LAVA_POP, 1);
				break;
			case 5:
				dropItem(player, 5, Material.REDSTONE, (short) 0);
				dropItem(player, 5, Material.REDSTONE_ORE, (short) 0);
				dropItem(player, 5, Material.REDSTONE_BLOCK, (short) 0);
				break;
			case 6:
				dropItem(player, 6, Material.DIAMOND, (short) 0);
				dropItem(player, 6, Material.DIAMOND_ORE, (short) 0);
				dropItem(player, 6, Material.DIAMOND_BLOCK, (short) 0);
				break;
			case 7:
				dropItem(player, 7, Material.EMERALD, (short) 0);
				dropItem(player, 7, Material.EMERALD_ORE, (short) 0);
				dropItem(player, 7, Material.EMERALD_BLOCK, (short) 0);
				break;
			case 8:
				player.getWorld().playEffect(player.getLocation(), Effect.COLOURED_DUST, 1);
				dropItem(player, 8, Material.INK_SACK, (short) 1);
				dropItem(player, 8, Material.INK_SACK, (short) 14);
				dropItem(player, 8, Material.INK_SACK, (short) 11);
				dropItem(player, 8, Material.INK_SACK, (short) 10);
				dropItem(player, 8, Material.INK_SACK, (short) 6);
				dropItem(player, 8, Material.INK_SACK, (short) 5);
				break;
			default:
				break;
		}
	}	
	
	private static void dropItem(Player player, int number, Material material, short damage) {
		ItemStack item = new Items().createItem(material, 1, damage, "dontpickup");
		Item dropItem = player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
		
		Bukkit.getScheduler().runTaskLater(Lobby.getPlugin(), new Runnable() {
	
			@Override
			public void run() {
				dropItem.remove();
			}
		}, 20);
	}
}
