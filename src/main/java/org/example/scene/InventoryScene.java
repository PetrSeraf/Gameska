package org.example.scene;

import org.example.Managers.SceneManager;

import java.util.ArrayList;
import java.util.List;

public class InventoryScene implements IScene {
    private SceneManager manager;
    private List<String> inventory;

    public InventoryScene() {
        inventory = new ArrayList<>();
    }

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        if (line.equalsIgnoreCase("back")) {
            manager.setCurrentScene(1); // Assuming 2 is the GameMapScene
        } else {
            System.out.println("Invalid command. Use 'back' to return to the game.");
        }
    }

    @Override
    public void render() {
        System.out.println("Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (String item : inventory) {
                System.out.println("- " + item);
            }
        }
        System.out.println("Commands: 'back'");
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public void removeItem(String item) {
        inventory.remove(item);
    }
}
