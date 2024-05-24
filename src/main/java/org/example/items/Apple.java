package org.example.items;

import org.example.NPCs.Player;

public class Apple implements IItem, IConsumeable {
    private Player player;
    private final int healthRestoration = 10;
    public Apple(Player player) {
        this.player = player;
    }

    private int restHP=10;
    @Override
    public boolean canBeConsumed() {
        return true;

    }

    @Override
    public void onConsume() {
        System.out.println("You had your pause hope you enjoyed it :)");
    }

    @Override
    public String getName() {
        return "Apple";
    }
}