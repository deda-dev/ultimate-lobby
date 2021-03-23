package de.deda.lobby.program;

import java.io.IOException;

import de.deda.lobby.utils.FileManager;
import de.deda.lobby.utils.Variable;

public class CreateFiles {

	public CreateFiles() {
		if(!Variable.locFile.exists() || 
				!Variable.mysqlFile.exists() || 
				!Variable.cmdFile.exists() || 
				!Variable.itemFile.exists() || 
				!Variable.teamServerFile.exists() || 
				!Variable.playerHiderFile.exists() || 
				!Variable.lobbySwitcherFile.exists() || 
				!Variable.settingsFile.exists() || 
				!Variable.gadgetsFile.exists() || 
				!Variable.shopFile.exists() || 
				!Variable.navigatorFile.exists()) {
				try {
					Variable.interactItemsFolderFile.mkdir();
					
					Variable.mysqlFile.createNewFile();
					Variable.locFile.createNewFile();
					Variable.cmdFile.createNewFile();
					Variable.itemFile.createNewFile();
					Variable.teamServerFile.createNewFile();
					Variable.playerHiderFile.createNewFile();
					Variable.lobbySwitcherFile.createNewFile();
					Variable.settingsFile.createNewFile();
					Variable.gadgetsFile.createNewFile();
					Variable.shopFile.createNewFile();
					Variable.navigatorFile.createNewFile();
					
					FileManager fm = new FileManager();
					fm.setMySQLConfig();
					fm.setItemsConfig();
					fm.setCommandsConfig();
					fm.setTeamServerConfig();
					fm.setPlayerHiderConfig();
					fm.setLobbySwitcherConfig();
					fm.setSettingsConfig();
					fm.setGadgetsConfig();
					fm.setShopConfig();
					fm.setNavigatorConfig();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}
