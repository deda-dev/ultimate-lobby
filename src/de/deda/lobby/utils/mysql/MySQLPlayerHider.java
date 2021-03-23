package de.deda.lobby.utils.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

public class MySQLPlayerHider {

	public static void setPlayerIn(UUID uuid, int value) {
		if(!isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO PlayerHider (UUID,ShowPlayer) VALUES (?,?)");
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
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM PlayerHider WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			return (rs.next() ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void setShowPlayer(Player player, UUID uuid, int value) {
		if(isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PlayerHider SET ShowPlayer = ? WHERE UUID = ?");
				ps.setInt(1, value);
				ps.setString(2, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			setPlayerIn(uuid, value);
	}
	
	public static Integer getShowPlayer(UUID uuid) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT ShowPlayer FROM PlayerHider WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("ShowPlayer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
