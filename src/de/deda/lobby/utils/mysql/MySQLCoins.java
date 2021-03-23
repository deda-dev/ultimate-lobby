package de.deda.lobby.utils.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

public class MySQLCoins {
	
	public static void setPlayerIn(UUID uuid, int amount) {
		if(!isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO CoinsSystem (UUID,Coins) VALUES (?,?)");
				ps.setInt(2, amount);
				ps.setString(1, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isUserExists(UUID uuid) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM CoinsSystem WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			return (rs.next() ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void Update(UUID uuid, int amount, boolean remove) {
		int coins = getCoins(uuid);
		
		if(remove) {
			amount = coins - amount;
		} else
			amount = coins + amount;
		
		if(isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE CoinsSystem SET Coins = ? WHERE UUID = ?");
				ps.setInt(1, amount);
				ps.setString(2, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			setPlayerIn(uuid, amount);
	}
	
	public static void delete(UUID uuid, Player player) {
		if(isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE * FROM CoinsSystem WHERE UUID = ?");
				ps.setString(1, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			player.sendMessage("[MySQL] §cThe player with the UUID: §6"+ uuid.toString() +" §care not in the database!");
	}
	
	public static void setCoins(UUID uuid, int amount) {
		if(isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE CoinsSystem SET Coins = ? WHERE UUID = ?");
				ps.setInt(1, amount);
				ps.setString(2, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			setPlayerIn(uuid, amount);
	}
	
	public static Integer getCoins(UUID uuid) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Coins FROM CoinsSystem WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("Coins");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
