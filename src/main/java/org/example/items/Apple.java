package org.example.items;

import org.example.NPCs.Player;

public class Apple implements IItem, IConsumable {
    @Override
    public boolean canBeConsumed() {
        return true;
    }

    @Override
    public void onConsume() {

    }

    @Override
    public String getName() {
        return "Apple";
    }
}