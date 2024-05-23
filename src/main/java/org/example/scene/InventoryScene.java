package org.example.scene;

import org.example.Managers.SceneManager;

import java.util.ArrayList;
import java.util.List;

public class InventoryScene implements IScene {
    private SceneManager manager;
    private List<String> items;

    public InventoryScene() {
        items = new ArrayList<>();
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
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (String item : items) {
                System.out.println("- " + item);
            }
        }
        System.out.println("Commands: 'back'");
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }
}
