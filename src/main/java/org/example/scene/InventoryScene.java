package org.example.scene;

import org.example.Managers.SceneManager;
import org.example.NPCs.Player;
import org.example.items.IConsumeable;
import org.example.items.IItem;
import org.example.items.IEquipable;

public class InventoryScene implements IScene {
    private SceneManager manager;
    private Player player;

    public InventoryScene(Player player) {
        this.player = player;
    }

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        try {
            int itemIndex = Integer.parseInt(line);
            if (itemIndex >= 0 && itemIndex < player.inventory.size()) {
                IItem item = player.inventory.get(itemIndex);
                if (item instanceof IConsumeable) {
                    player.consumeItem(item);
                } else if (item instanceof IEquipable) {
                    player.equipItem(item);
                }
            } else {
                System.out.println("Invalid item index.");
            }
        } catch (NumberFormatException e) {
            if (line.equalsIgnoreCase("back")) {
                manager.setCurrentScene(1); // Assuming 1 is the GameMapScene
            } else {
                System.out.println("Invalid command. Use 'back' to return to the game.");
            }
        }
    }

    public void displayInventory() {
        System.out.println("Player Inventory:");
        if (player.inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (int i = 0; i < player.inventory.size(); i++) {
                System.out.println("[" + i + "] " + player.inventory.get(i).getName());
            }
        }
        System.out.println("Commands: 'back'");
    }

    @Override
    public void render() {
        displayInventory();
    }
}