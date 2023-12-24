package me.ashton.galaxyminigames.SkyWars;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerInfo {

    private SkyWars skyWars;
    Map<UUID, playerStat> playerStatus = new HashMap<>();

    public enum playerStat {
        ALIVE, DEAD, SPECTATING,
    }

    public PlayerInfo() {
        this.playerStatus = new HashMap<>();
    }


    public PlayerInfo(SkyWars skyWars) {
        this.skyWars = skyWars;
    }


    public void setPlayerStatus(UUID playerId, playerStat status) {
        playerStatus.put(playerId, status);
    }

    public playerStat getPlayerStatus(UUID playerId) {
        return playerStatus.get(playerId);
    }


    public void spectating(Player player) {
        if (getPlayerStatus(player.getUniqueId()) == playerStat.SPECTATING) {
            player.setGameMode(GameMode.SPECTATOR);
        }
    }
}


