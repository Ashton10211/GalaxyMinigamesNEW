package me.ashton.galaxyminigames.CakeWars.Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;

public class WoolKit implements Kit {


    private KitManager kitManager;


    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        WoolKit woolKit = new WoolKit();
        kitManager.giveKit(player, woolKit);
        this.applyKit(player);
    }


    @EventHandler
    public void onKill(PlayerDeathEvent event) {

        Player killer = event.getPlayer().getKiller();
        if (kitManager.hasKit(killer, this))
            if (killer != null) {
                killer.sendMessage("You should get speed for 5 seconds");
            }
    }

    @Override
    public void applyKit(Player player) {

        player.sendMessage("APPLIED KIT");

    }
}
