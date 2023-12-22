package me.ashton.galaxyminigames.CakeWars;

import me.ashton.galaxyminigames.CakeWars.Kits.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class CakeConstructor {


    private Boolean isAlive;
    private Block diamondBlock;
    private Boolean started;
    private int maxPlayers;
    private int gameDuration;
    private Boolean spectating;

    private Generator generator;
    private Boolean cakeAlive;
    public CakeConstructor() {

        this.started = false;
        this.maxPlayers = 10;
        this.gameDuration = 10; // 10 minutes of gameplay
        this.spectating = false;
        this.cakeAlive = true;
        //this.diamondBlock = team.getSpawnLocation().getBlock();
        //this.cake1 = false; //team1 cake to be done tomorrow

    }

    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
    ItemStack stick = new ItemStack(Material.STICK);


    public void setSpectating() {

    }


    public void setStarted(Boolean started) {
        this.started = started;
    }

    public void startGame() {
       this.started = true;
        for(Player player  : Bukkit.getOnlinePlayers()) {
            player.teleport(new Location(player.getWorld(), 100,100, 100));
            player.sendMessage("game starting");
            player.getInventory().addItem(sword, stick);
            generator.globalGenerate();
        }
    }

    public void endGame() {
        this.started = false;
        for(Player player  : Bukkit.getOnlinePlayers()) {
            player.sendMessage("force end game is ending testing");
            player.getInventory().clear();
        }
    }

    public boolean isStarted() {
        return this.started;
    }


    public int getMaxPlayers() {
        return this.maxPlayers;
    }


    public void setGameDuration(int duration) {
        this.gameDuration = duration;
    }
    public int getGameDuration() {
        return this.gameDuration;
    }

    public boolean cakeAlive() {

        return cakeAlive;

    }

    public Block getDiamondBlock() {
        return diamondBlock;
    }

    public void setDiamondBlock(Block diamondBlock) {
        this.diamondBlock = diamondBlock;
    }




}
