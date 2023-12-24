package me.ashton.galaxyminigames.CakeWars.gameManager;

import me.ashton.galaxyminigames.CakeWars.CakeConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChestStart {

    private final ChestFills chestFills;
    private final CakeConstructor cakeConstructor;

    public ChestStart(ChestFills chestFills, CakeConstructor cakeConstructor) {
        this.chestFills = chestFills;
        this.cakeConstructor = cakeConstructor;
    }

    public void gameBegan() {
        if (cakeConstructor.isStarted()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                World world = player.getWorld();
                Location loc1 = new Location(world, 105, 100, 100);
                Block block = loc1.getBlock();

                if (block.getType() == Material.CHEST) {
                    Chest chest = (Chest) block.getState();
                    Inventory chestInventory = chest.getBlockInventory();

                    // Clear existing items in the chest
                    chestInventory.clear();

                    // Add items to the chest
                    for (int i = 0; i < chestInventory.getSize(); i++) {
                        Material randomItem = chestFills.getRandomEventChestItem();
                        if (randomItem != null) {
                            chestInventory.setItem(i, new ItemStack(randomItem));
                        }
                    }
                }
            }
        }
    }
}
