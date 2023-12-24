package me.ashton.galaxyminigames.CakeWars.gameManager;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChestFills {

    private List<Material> regularChestItems;
    private List<Material> eventChestItems;
    private Random random;

    public ChestFills() {
        this.regularChestItems = new ArrayList<>();
        this.eventChestItems = new ArrayList<>();
        this.random = new Random();
        // Initialize the lists or load items from a configuration file, etc.
    }

    public void addRegularChestItem(Material item) {
        regularChestItems.add(item);
    }

    public void addEventChestItem(Material item) {
        eventChestItems.add(item);
    }

    public List<Material> getRegularChestItems() {
        return regularChestItems;
    }

    private void initializeItems() {

        //Event adds
        eventChestItems.add(Material.DIAMOND);
        eventChestItems.add(Material.EMERALD);

        // Regular adds
        regularChestItems.add(Material.STICK);
        regularChestItems.add(Material.STONE);
    }

    public List<Material> getEventChestItems() {
        return eventChestItems;
    }

    public Material getRandomRegularChestItem() {
        if (!regularChestItems.isEmpty()) {
            int index = random.nextInt(regularChestItems.size());
            return regularChestItems.get(index);
        }
        return null; // Handle the case when the list is empty
    }

    public Material getRandomEventChestItem() {
        if (!eventChestItems.isEmpty()) {
            int index = random.nextInt(eventChestItems.size());
            return eventChestItems.get(index);
        }
        return null; // Handle the case when the list is empty
    }
}
