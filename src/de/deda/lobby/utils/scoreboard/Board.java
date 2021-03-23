package de.deda.lobby.utils.scoreboard;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import de.deda.lobby.program.AddRanks;
import de.deda.lobby.program.Coins;
import de.deda.lobby.utils.ConfigManager;
import de.deda.lobby.utils.Variable;

public class Board {
	
	private static Scoreboard board;
	
	public static void setBoard(Player player) {
		board = Bukkit.getScoreboardManager().getNewScoreboard();
		ConfigManager config = new ConfigManager();
		
		if(board.getObjective("lobby rank") != null) {
			player.setScoreboard(board);
			return;
		}
		Objective obj = board.registerNewObjective("lobby rank", "dummy");
		
		if(!config.getBoolean("Scoreboard.enabled", Variable.config)) {
			player.setScoreboard(board);
			return;
		}
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(config.getString("Scoreboard.title", Variable.config));
			
		ConfigurationSection cs = Variable.config.getConfigurationSection("Scoreboard.Scores");
		Set<String> key = cs.getKeys(false);
		
		if(key == null) {
			player.setScoreboard(board);
			return;
		}
		Object[] keys = key.toArray();
		
		for(int i=0; i<key.size(); i++) {
			String coins = Coins.getCoins(player);
			RankPlayer rank = getRankPlayer((Player) player);
			String rankPrefix = rank.getPrefix();
			
			if(config.getScoreBoardString("Scoreboard.Scores."+keys[i]+".score", coins, rank.getPrefix(), player, Variable.config) != null) {
				String scores = config.getScoreBoardString("Scoreboard.Scores."+keys[i]+".score", coins, rankPrefix, player, Variable.config);
				obj.getScore(scores).setScore(Integer.parseInt((String) keys[i]));
			}
		}
		player.setScoreboard(board);
	}
	
	public static void updateRank(Player player) {
		for(Player all : Bukkit.getOnlinePlayers()) {
			Scoreboard board = player.getScoreboard();
			Scoreboard sb = all.getScoreboard();
			
			RankPlayer rankPlayer = getRankPlayer((Player) player);
			RankPlayer rankAll = getRankPlayer((Player) all);
			String teamAll = rankAll.getTeam();
			String team = rankPlayer.getTeam();
			
			if(sb.getTeam(team) == null)
				sb.registerNewTeam(team);

			if(board.getTeam(teamAll) == null)
				board.registerNewTeam(teamAll);
			
			//Prefix
			board.getTeam(teamAll).setPrefix(rankAll.getPrefix());
			//Add team
			board.getTeam(teamAll).addEntry(all.getName());
			
			//Prefix
			sb.getTeam(team).setPrefix(rankPlayer.getPrefix());
			//Add team
			sb.getTeam(team).addEntry(player.getName());
		}
	}
	
	private static RankPlayer getRankPlayer(final Player player) {
		return AddRanks.getRankPlayer(player);
	}
}
