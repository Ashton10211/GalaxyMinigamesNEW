package me.ashton.galaxyminigames.CakeWars;

import me.ashton.galaxyminigames.CakeWars.CakeConstructor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Generator {



    private CakeConstructor cakeConstructor;
    int Level;
    public Generator(CakeConstructor cakeConstructor) {

        this.Level = 1;

    }

    public void setLevel(int level) {
        Level = level;
    }


    public void globalGenerate() {
        if (cakeConstructor.isStarted()) {
            for (World world : Bukkit.getWorlds()) {
                for (Chunk chunk : world.getLoadedChunks()) {
                    for (BlockState blockState : chunk.getTileEntities()) {
                        if (blockState.getType() == Material.DIAMOND_BLOCK) {
                            Block block = blockState.getBlock();
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_INGOT));
                        }
                        else if(blockState.getType() == Material.IRON_BLOCK) {
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

    public int getLevel() {
        return Level;
    }
}
