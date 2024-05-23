package org.example.items;

import org.example.NPCs.Player;

public class Apple implements IItem, IConsumable {
    Player player;

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
        player.heal(restHP);

    }

    @Override
    public String getName() {
        return "Apple";
    }
}