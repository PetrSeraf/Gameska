package org.example;

import org.example.Managers.SceneManager;
import org.example.NPCs.Player;
import org.example.items.Apple;
import org.example.items.Sword;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("John", 100, 10, 0.5);
        SceneManager sceneManager = new SceneManager(player);

        System.out.println("Starting game:");
        sceneManager.loop();
    }
}