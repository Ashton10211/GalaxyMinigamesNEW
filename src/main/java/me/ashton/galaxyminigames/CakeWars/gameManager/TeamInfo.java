package me.ashton.galaxyminigames.CakeWars.gameManager;

import me.ashton.galaxyminigames.CakeWars.CakeConstructor;

import java.util.Map;
import java.util.UUID;

public class TeamInfo {

    private CakeConstructor cakeConstructor;
    private final String teamName;
    private final Map<UUID, Integer> teamLevels;

    public TeamInfo(CakeConstructor cakeConstructor, String teamName, Map<UUID, Integer> teamLevels) {
        this.cakeConstructor = cakeConstructor;
        this.teamName = teamName;
        this.teamLevels = teamLevels;
    }

    public void setTeamLevel(UUID playerId, int level) {
        teamLevels.put(playerId, level);
    }

    public int getTeamLevel(UUID playerId) {
        return teamLevels.getOrDefault(playerId, 1);
    }

    public String getTeamName() {
        return teamName;
    }
}
