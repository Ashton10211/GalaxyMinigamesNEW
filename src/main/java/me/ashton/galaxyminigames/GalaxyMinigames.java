package me.ashton.galaxyminigames;

import me.ashton.galaxyminigames.CakeWars.CakeCommand;
import me.ashton.galaxyminigames.CakeWars.CakeConstructor;
import me.ashton.galaxyminigames.CakeWars.CakeG;
import me.ashton.galaxyminigames.CakeWars.Kits.KitManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GalaxyMinigames extends JavaPlugin {


    private CakeG  cakegame;
    @Override
    public void onEnable() {

        //Initialize Guess and Bridges games
        CakeConstructor cakeConstructor = new CakeConstructor();
        cakegame = new CakeG(cakeConstructor, new KitManager());

        getCommand("game").setExecutor(new CakeCommand(cakeConstructor));



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
