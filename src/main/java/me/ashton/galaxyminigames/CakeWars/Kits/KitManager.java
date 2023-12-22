package me.ashton.galaxyminigames.CakeWars.Kits;

import org.bukkit.entity.Player;

import java.util.*;

public class KitManager {

    private final Map<Player, List<Kit>> playerKits;

    public KitManager() {
        this.playerKits = new HashMap<>();
    }

    public void giveKit(Player player, Kit kit) {
        // Add the kit to the player's list of kits
        playerKits.computeIfAbsent(player, key -> new ArrayList<>()).add(kit);
    }

    public List<Kit> getKits(Player player) {
        // Get the list of kits assigned to the player
        return playerKits.getOrDefault(player, Collections.emptyList());
    }

    public boolean hasKit(Player player, Kit kit) {
        // Check if the player has a specific kit
        return getKits(player).contains(kit);
    }

    // You can add more methods as needed
}
