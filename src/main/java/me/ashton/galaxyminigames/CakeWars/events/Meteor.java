package me.ashton.galaxyminigames.CakeWars.events;

import me.ashton.galaxyminigames.CakeWars.CakeConstructor;
import me.ashton.galaxyminigames.CakeWars.gameManager.ChestFills;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Meteor {

    private final CakeConstructor cakeConstructor;
    private final ChestFills chestFills;
    private final Random random = new Random();



    public Meteor(CakeConstructor cakeConstructor, ChestFills chestFills) {
        this.cakeConstructor = cakeConstructor;
        this.chestFills = chestFills;
    }

    public void meteorStart() {
        if (cakeConstructor.isStarted()) {
            // make something if it's started for 10 minutes
            meteorDrop();
        }
    }

    public void meteorDrop() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            World world = player.getWorld();
            Location eventLoc = new Location(world, 100, 100, 100);
            eventLoc.getBlock().setType(Material.BEACON);
            // After 2 minutes of it dropping
            eventLoc.getBlock().setType(Material.CHEST);
            chestSpawn(eventLoc);
        }
    }

    public void chestSpawn(Location location) {
        World world = location.getWorld();

        // Create a chest at the specified location
        Block chestBlock = world.getBlockAt(location.add(0, 1, 0));
        chestBlock.setType(Material.CHEST);

        // Add items to the chest
        Chest chest = (Chest) chestBlock.getState();
        List<Material> eventChestItems = chestFills.getEventChestItems();

        for (int i = 0; i < chest.getBlockInventory().getSize(); i++) {
            if (eventChestItems.isEmpty()) {
                break; // Stop if the item list is empty
            }
            // Get a random item from the list
            int randomNumber = 1 + random.nextInt(10);
            Material randomItem = getRandomItem(eventChestItems);
            if (randomItem != null) {
                ItemStack eventItems = new ItemStack(randomItem, randomNumber);
                chest.getBlockInventory().setItem(i, new ItemStack(eventItems));
                Bukkit.broadcastMessage("Added " + randomNumber + "items");
            }
        }

        Bukkit.broadcastMessage("A meteor has dropped, revealing a chest with valuable loot!");
    }

    private Material getRandomItem(List<Material> itemList) {
        int index = (int) (Math.random() * itemList.size());
        return itemList.remove(index);
    }
}
