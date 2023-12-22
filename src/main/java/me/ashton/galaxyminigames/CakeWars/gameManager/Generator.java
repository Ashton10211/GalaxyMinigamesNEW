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
    private TeamInfo teamInfo;
    int Level;

    public Generator(CakeConstructor cakeConstructor, TeamInfo teamInfo) {
        this.cakeConstructor = cakeConstructor;
        this.teamInfo = teamInfo;

    }




    public void onGenerate() {

        for (Player player : Bukkit.getOnlinePlayers()) {

            int playerLevel = teamInfo.getTeamLevel(player.getUniqueId());
            if(playerLevel == 1) {
                player.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
                player.sendMessage("You are level 1 by the way so I gave you an iron Ingot "); // Base support for testing

            }

        }
    }


}

