package me.ashton.galaxyminigames.CakeWars.gameManager;

import me.ashton.galaxyminigames.CakeWars.CakeConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TeamManager {

    private final Map<UUID, TeamInfo> teams;
    private CakeConstructor cakeConstructor;
    public TeamManager(CakeConstructor cakeConstructor) {
        this.cakeConstructor = cakeConstructor;
        this.teams = new HashMap<>();
    }


    public void createTeam(UUID teamId, String teamName, CakeConstructor cakeConstructor) {
        Map<UUID, Integer> teamLevels = new HashMap<>();
        TeamInfo teamInfo = new TeamInfo(cakeConstructor, teamName, teamLevels);
        teams.put(teamId, teamInfo);
    }

}
