package me.ashton.galaxyminigames.SkyWars;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;



public class SkyWars extends JavaPlugin {



    public enum GameState {
        PRE_START, STARTED, ENDED, PREPARING,

    }



    private GameState gameState;
    private PlayerInfo playerInfo;
    private int MaxPlayers;
    private int MinPlayers;
    private Boolean started;


    private ArrayList<Location> spawnPoints = new ArrayList<>();





    public SkyWars(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        this.gameState = GameState.PREPARING;
        this.MaxPlayers = 10;
        this.MinPlayers = 7;
        this.started = false;


        // Initialize spawn points
        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            Player firstPlayer = Bukkit.getOnlinePlayers().iterator().next();
            World gameWorld = firstPlayer.getWorld();

            // Spawn Points create
            spawnPoints.add(new Location(gameWorld, 101, 10, 100));
            spawnPoints.add(new Location(gameWorld, 100, 100, 100));
            spawnPoints.add(new Location(gameWorld, 102, 100, 100));
            spawnPoints.add(new Location(gameWorld, 103, 100, 100));
            spawnPoints.add(new Location(gameWorld, 104, 100, 100));
        }
    }

    public void setAlive() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerInfo.setPlayerStatus(player.getUniqueId(), PlayerInfo.playerStat.ALIVE);
        }
    }


    public void spawnPoint() {
        int i = 0;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if(i < spawnPoints.size()) {
                Location spawnPointt = spawnPoints.get(i);
                player.teleport(spawnPointt);
                i++;
            }
        }
    }

    public void preparingGame() {

        if(GameState.PREPARING.equals(gameState)) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                Location spawn = new Location(player.getWorld(), 100, 100, 100);
                player.teleport(spawn);
            }
                if (Bukkit.getOnlinePlayers().size() >= MinPlayers && Bukkit.getOnlinePlayers().size() <= MaxPlayers) {
                    preStart();
                }
        }
    }

    private void startCountdown(int seconds) {
        int[] countdown = { seconds };

        Bukkit.getScheduler().runTaskTimer(this, (Runnable) () -> {
            if (countdown[0] > 0) {
                // Broadcast countdown message
                Bukkit.broadcastMessage("Game starting in " + countdown[0] + " seconds!");
                countdown[0]--;
            } else {
                // Countdown complete, start the game
                gameState = GameState.STARTED;
                gameStart();
                spawnPoint();
                setAlive();
            }
        }, 0L, 20L);  // Run the task every second (20 ticks)
    }


public void basicFill() {

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
        }
}


    public void preStart() {
        if(GameState.PRE_START.equals(gameState)) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                startCountdown(5);
            }

        }
    }

    public void gameStart() {
        if(GameState.STARTED.equals(gameState)) {
            //Put game stuff in here
            Bukkit.broadcastMessage("Game has started");
            basicFill();
        }
    }


    public void clearInventory() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            player.getInventory().clear();
            player.getInventory().setArmorContents(null);
        }
    }
    public void endGame() {

        if(gameState == GameState.ENDED) {
            Bukkit.broadcastMessage("Game has ended");
            gameState = GameState.PREPARING;
            clearInventory();
            preparingGame();

        }
     }




     public GameState getGameStart() {
        return  GameState.STARTED;
     }

    public GameState getGameState() {
        return gameState;
    }

    public int getMaxPlayers() {
        return MaxPlayers;
    }
}
