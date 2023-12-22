package me.ashton.galaxyminigames.CakeWars;

import me.ashton.galaxyminigames.CakeWars.Kits.ArcherKit;
import me.ashton.galaxyminigames.CakeWars.Kits.Kit;
import me.ashton.galaxyminigames.CakeWars.Kits.KitManager;
import me.ashton.galaxyminigames.CakeWars.Kits.WoolKit;
import me.ashton.galaxyminigames.CakeWars.gameManager.Generator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CakeG implements Listener {


    private CakeConstructor cakeConstructor;
    private Generator generator;
    private final KitManager kitManager;


    public CakeG(CakeConstructor cakeConstructor, KitManager kitManager) {
        this.cakeConstructor = cakeConstructor;
        this.kitManager = kitManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if(Bukkit.getOnlinePlayers().size() == 10) {
            cakeConstructor.setStarted(true);
        }
        else if (Bukkit.getOnlinePlayers().size() < 10) {
            Bukkit.broadcastMessage("Server will start when we have 10");
        }

    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        Player player = event.getPlayer();

        if(!cakeConstructor.cakeAlive()) {

        }

    }



    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
    ItemStack stick = new ItemStack(Material.STICK);
    public void startGame() {


        for(Player player  : Bukkit.getOnlinePlayers()) {

            List<Kit> playerKits = kitManager.getKits(player);

            if(!playerKits.isEmpty()) {

                for (Kit kit : playerKits) {
                    if (kit instanceof ArcherKit) {
                        player.sendMessage("You have the Archer Kit!");
                        ((ArcherKit) kit ).applyArcher(player);

                    }
                    if (kit instanceof WoolKit) {
                        player.sendMessage("You have the WoolKit");
                    }
                }
            } else {
                //This is the default kit
                kitManager.giveKit(player, new WoolKit(kitManager));
                player.sendMessage("Given the default kit" + kitManager.getKits(player));
            }


            player.teleport(new Location(player.getWorld(), 100,100, 100));
            player.sendMessage("game starting");
            player.getInventory().addItem(sword, stick);
            generator.globalGenerate();
        }
    }
}
