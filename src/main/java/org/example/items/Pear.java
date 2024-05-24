package org.example.items;

import org.example.NPCs.Player;

public class Pear implements IItem, IConsumeable {
    private Player player;
    private final int healthRestoration = 10;
    public Pear(Player player) {
        this.player = player;
    }

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
        return "Pear";
    }
}