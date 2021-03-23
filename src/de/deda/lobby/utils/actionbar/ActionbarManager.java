package de.deda.lobby.utils.actionbar;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

public class ActionbarManager {
	
	public static void sendActionBar(Player player, String message) {
		IChatBaseComponent iChat = ChatSerializer.a("{\"text\": \"\"}").a(message);
		PacketPlayOutChat chat = new PacketPlayOutChat(iChat, (byte) 2);
		
		CraftPlayer cp = (CraftPlayer)player;
		cp.getHandle().playerConnection.sendPacket(chat);
	}
}
