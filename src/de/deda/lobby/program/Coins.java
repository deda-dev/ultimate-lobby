package de.deda.lobby.program;

import java.util.UUID;

import org.bukkit.entity.Player;

import de.deda.lobby.utils.mysql.MySQLCoins;

public class Coins {

	public static String getCoins(Player player) {
		UUID uuid = player.getUniqueId();
		
		if(MySQLCoins.isUserExists(uuid)) {
			MySQLCoins.setPlayerIn(uuid, 0);
			return "0";
		}
		int coins = MySQLCoins.getCoins(uuid);
		
		String coinString = ""+coins;
		char[] coinsArray = coinString.toCharArray();
	
		if(coins >= 100000000) {
			String coinString1 = ""+coinsArray[0]+coinsArray[1]+coinsArray[2];
			String coinString2 = ""+coinsArray[3]+coinsArray[4]+coinsArray[5];
			String coinString3 = ""+coinsArray[6]+coinsArray[7]+coinsArray[8];
			String finishedCoins = coinString1+"."+coinString2+"."+coinString3;
			
			return finishedCoins;
		}
		if(coins >= 10000000) {
			String coinString1 = ""+coinsArray[0]+coinsArray[1];
			String coinString2 = ""+coinsArray[2]+coinsArray[3]+coinsArray[4];
			String coinString3 = ""+coinsArray[5]+coinsArray[6]+coinsArray[7];
			String finishedCoins = coinString1+"."+coinString2+"."+coinString3;
			
			return finishedCoins;
		}
		if(coins >= 1000000) {
			String coinString1 = ""+coinsArray[0];
			String coinString2 = ""+coinsArray[1]+coinsArray[2]+coinsArray[3];
			String coinString3 = ""+coinsArray[4]+coinsArray[5]+coinsArray[6];
			String finishedCoins = coinString1+"."+coinString2+"."+coinString3;
			
			return finishedCoins;
		}
		if(coins >= 100000) {
			String coinString1 = ""+coinsArray[0]+coinsArray[1]+coinsArray[2];
			String coinString2 = ""+coinsArray[3]+coinsArray[4]+coinsArray[5];
			String finishedCoins = coinString1+"."+coinString2;
			
			return finishedCoins;
		}
		if(coins >= 10000) {
			String coinString1 = ""+coinsArray[0]+coinsArray[1];
			String coinString2 = ""+coinsArray[2]+coinsArray[3]+coinsArray[4];
			String finishedCoins = coinString1+"."+coinString2;
			
			return finishedCoins;
		}
		if(coins >= 1000) {
			String coinString1 = ""+coinsArray[0];
			String coinString2 = ""+coinsArray[1]+coinsArray[2]+coinsArray[3];
			String finishedCoins = coinString1+"."+coinString2;
			
			return finishedCoins;
		}
		return ""+coins;
	}
}
