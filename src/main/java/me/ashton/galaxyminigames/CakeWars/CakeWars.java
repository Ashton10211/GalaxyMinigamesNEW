package me.ashton.galaxyminigames.CakeWars;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import me.ashton.galaxyminigames.CakeWars.CakeConstructor;
public class CakeWars implements Listener {

    private CakeConstructor cakeConstructor;

    public CakeWars(CakeConstructor cakeConstructor) {
        this.cakeConstructor = cakeConstructor;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (Bukkit.getOnlinePlayers().size() == cakeConstructor.getMaxPlayers()) {
            cakeConstructor.startGame();
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
            player.setGameMode(GameMode.SPECTATOR);

        }


    public void startGame() {

    }


    public boolean isStarted() {
        return cakeConstructor.isStarted();
    }

        public int getMaxPlayers() {
            return cakeConstructor.getMaxPlayers();
        }

        public void setGameDuration(int duration) {
             cakeConstructor.setGameDuration(duration);
        }

        public int getGameDuration() {
            return cakeConstructor.getGameDuration();
        }
    }
