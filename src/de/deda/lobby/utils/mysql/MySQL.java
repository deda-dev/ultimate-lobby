package de.deda.lobby.utils.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class MySQL {
	private static ConfigManager config = new ConfigManager();
	
	public static String host = config.getSimpleString("MySQL.Host", Variable.mysqlConfig);
	public static String port = config.getSimpleString("MySQL.Port", Variable.mysqlConfig);
	public static String database = config.getSimpleString("MySQL.Database", Variable.mysqlConfig);
	public static String username = config.getSimpleString("MySQL.Username", Variable.mysqlConfig);
	public static String password = config.getSimpleString("MySQL.Password", Variable.mysqlConfig);
	public static Connection con;
	
	public static void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/"+ database + "?autoReconnect=true", username, password);
			System.out.println("[UltimateLobby] MySQL connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println("[UltimateLobby] MySQL disconnected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected() {
		return (con == null ? false : true);
	}
	
	public static Connection getConnection() {
		return con;
	}
}
