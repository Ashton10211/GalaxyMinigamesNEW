package me.ashton.galaxyminigames.SkyWars.events;

import me.ashton.galaxyminigames.SkyWars.PlayerInfo;
import me.ashton.galaxyminigames.SkyWars.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class playerDead implements Listener {

    private SkyWars skyWars;
    private PlayerInfo playerInfo;
    public playerDead(SkyWars skyWars, PlayerInfo playerInfo) {
        this.skyWars = skyWars;
        this.playerInfo = playerInfo;
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        if(playerInfo.getPlayerStatus(player.getUniqueId()) == PlayerInfo.playerStat.ALIVE) {
            playerInfo.setPlayerStatus(player.getUniqueId(), PlayerInfo.playerStat.SPECTATING);
            player.sendMessage("Set to SPECTATING");
            playerInfo.spectating(player);
        }
    }
}
