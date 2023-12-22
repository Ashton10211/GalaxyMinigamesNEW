package me.ashton.galaxyminigames.CakeWars;

import me.ashton.galaxyminigames.CakeWars.CakeConstructor;
import me.ashton.galaxyminigames.CakeWars.Kits.KitManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

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
            player.teleport(new Location(player.getWorld(), 100,100, 100));
            player.sendMessage("game starting");
            player.getInventory().addItem(sword, stick);
            generator.globalGenerate();
        }
    }
}
