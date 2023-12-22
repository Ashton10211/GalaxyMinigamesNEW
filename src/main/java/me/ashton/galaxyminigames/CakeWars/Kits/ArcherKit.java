package me.ashton.galaxyminigames.CakeWars.Kits;

import org.bukkit.entity.Player;

public class ArcherKit implements Kit{


    private KitManager kitManager;

    public ArcherKit(KitManager kitManager) {
        this.kitManager = kitManager;
    }

    public void applyArcher(Player player ) {
      if( kitManager.hasKit(player, this)) {
          player.sendMessage("This is testing purposes only you are kit");
      }
    }

    @Override
    public void applyKit(Player player) {

    }
}
