package de.deda.lobby.utils.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MySQLShopBoots {

	public static void setPlayerIn(UUID uuid, int value) {
		if(!isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO ShopBoots (UUID,Number1,Number2,Number3,Number4,Number5,Number6,Number7,Number8,Number9,Number10) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
				for(int i=2;i<12;i++)
					ps.setInt(i, value);
				ps.setString(1, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isUserExists(UUID uuid) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM ShopBoots WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			return (rs.next() ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void setBoughtItem(UUID uuid, int number, int value) {
		if(isUserExists(uuid)) {
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE ShopBoots SET Number"+number+" = ? WHERE UUID = ?");
				ps.setInt(1, value);
				ps.setString(2, uuid.toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			setPlayerIn(uuid, 0);
	}
	
	public static Integer getBoughtItem(UUID uuid, int number) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Number"+number+" FROM ShopBoots WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("Number"+number);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
