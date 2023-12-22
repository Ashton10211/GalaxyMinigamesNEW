package me.ashton.galaxyminigames.CakeWars;

import me.ashton.galaxyminigames.CakeWars.Kits.KitManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CakeCommand implements CommandExecutor {

    private final CakeG cakeGame;
    private String currentGame;

    public CakeCommand(CakeConstructor cakeConstructor) {
        cakeGame = new CakeG(cakeConstructor, new KitManager());
        currentGame = "";
    }

    @Override
      public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0 ) {
            sender.sendMessage("Args = 0");

        }

        String game = args[0].toLowerCase();

        switch(game) {
            case "cakewars":
                cakeGame.startGame();
                currentGame = "cakewars";

            }
        sender.sendMessage("Switched to " + currentGame + " game.");
        return true;
        }
    }

