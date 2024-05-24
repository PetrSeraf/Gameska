package org.example;

import org.example.Managers.SceneManager;
import org.example.NPCs.Player;
import org.example.items.Apple;
import org.example.items.Sword;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("John", 100, 10, 0.5);
        SceneManager sceneManager = new SceneManager(player);

        // Add items to player's inventory
        player.inventory.add(new Apple(player));
        player.inventory.add(new Sword(player));

        System.out.println("Starting game:");
        sceneManager.loop(); // Start the game loop
    }
}