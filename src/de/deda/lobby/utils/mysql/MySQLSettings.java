package de.deda.lobby.utils.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

public class MySQLSettings {

	public static void setPlayerIn(UUID uuid, int value) {
		if(!isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO Settings (UUID,Movement,SpawnPosition) VALUES (?,?,?)");
				ps.setInt(3, value);
				ps.setInt(2, value);
				ps.setString(1, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isUserExists(UUID uuid) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM Settings WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			return (rs.next() ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void setMovement(Player player, UUID uuid, int value) {
		if(isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Settings SET Movement = ? WHERE UUID = ?");
				ps.setInt(1, value);
				ps.setString(2, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			setPlayerIn(uuid, value);
	}
	
	public static void setSpawnPosition(Player player, UUID uuid, int value) {
		if(isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Settings SET SpawnPosition = ? WHERE UUID = ?");
				ps.setInt(1, value);
				ps.setString(2, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			setPlayerIn(uuid, value);
	}
	
	public static Integer getMovement(UUID uuid) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Movement FROM Settings WHERE UUID = ?");
				ps.setString(1, uuid.toString());
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					return rs.getInt("Movement");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	
	public static Integer getSpawnPosition(UUID uuid) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT SpawnPosition FROM Settings WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("SpawnPosition");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
