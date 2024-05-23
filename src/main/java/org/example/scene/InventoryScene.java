package org.example.scene;

import org.example.Managers.SceneManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryScene implements IScene {
    private SceneManager manager;
    private List<String> items;

    public InventoryScene() {
        items = new ArrayList<>();
    }

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
        // Initialize inventory with some items for demonstration
        items.add("Sword");
        items.add("Shield");
        items.add("Potion");
    }

    @Override
    public void update(String line) {
        Scanner scanner = new Scanner(System.in);

        switch (line.toLowerCase()) {
            case "add":
                System.out.println("Enter the name of the item to add:");
                String newItem = scanner.nextLine();
                items.add(newItem);
                System.out.println(newItem + " has been added to your inventory.");
                break;
            case "remove":
                System.out.println("Enter the name of the item to remove:");
                String itemToRemove = scanner.nextLine();
                if (items.remove(itemToRemove)) {
                    System.out.println(itemToRemove + " has been removed from your inventory.");
                } else {
                    System.out.println("Item not found in inventory.");
                }
                break;
            case "back":
                manager.setCurrentScene(2); // Assuming 2 is the GameMapScene
                break;
            default:
                System.out.println("Invalid command. Use 'add' to add an item, 'remove' to remove an item, 'back' to return to the game.");
                break;
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
        System.out.println("Commands: 'add', 'remove', 'back'");
    }
}
