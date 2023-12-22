package me.ashton.galaxyminigames.CakeWars.gameManager;

import me.ashton.galaxyminigames.CakeWars.CakeConstructor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Generator {



    private CakeConstructor cakeConstructor;
    int Level;
    public Generator(CakeConstructor cakeConstructor, Map<UUID, Integer> playerLevels) {
        this.playerLevels = playerLevels;
        this.cakeConstructor = cakeConstructor;


    }


    private final Map<UUID, Integer> playerLevels;




    public void setPlayerLevels(UUID playerId, int level) {
        playerLevels.put(playerId, level);

    }

    public int getPlayerLevel(UUID playerId) {
        return playerLevels.getOrDefault(playerId, 1);

    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {


        setPlayerLevels(event.getPlayer().getUniqueId(), 2); // this is for testing purposes I want it to be set at 2
    }
    public void testGenerate() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (getPlayerLevel(player.getUniqueId()) == 2) {
                player.sendMessage("You are level 2");
            }
            if (getPlayerLevel(player.getUniqueId()) == 3) {
                player.sendMessage("You are level 3 (ISLAND)");
            }

        }
    }
}
   /* public void globalGenerate() {
        if (cakeConstructor.isStarted()) {
            for (World world : Bukkit.getWorlds()) {
                for (Chunk chunk : world.getLoadedChunks()) {
                    for (BlockState blockState : chunk.getTileEntities()) {
                        if (blockState.getType() == Material.DIAMOND_BLOCK) {
                            Block block = blockState.getBlock();
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_INGOT));
                        }
                        else if(blockState.getType() == Material.IRON_BLOCK ) {
                            Block block = blockState.getBlock();
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD));
                        }
                        else if(blockState.getType() == Material.GOLD_BLOCK) {
                            Block block = blockState.getBlock();
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND));
                        }
                    }
                }
            }
        }
    }
        public void onGenerate(Player player, Block block) {
        if (cakeConstructor.isStarted()) {
            Location location = player.getLocation();
            Material level1block = Material.DIAMOND_BLOCK;
            if (block.getType() == level1block) {
                generateItem(player);
            }
        } else {
            player.sendMessage("game not started");

        }
    }


    ItemStack level1item = new ItemStack(Material.IRON_INGOT);
    ItemStack level2item = new ItemStack(Material.DIAMOND);

    public void generateItem(Player pLayer) {
        if(Level == 1) {
            pLayer.getInventory().addItem(new ItemStack(level1item));
        }
        else if(Level == 2) {
            pLayer.getInventory().addItem(new ItemStack(level2item));
        }

    }
      */


