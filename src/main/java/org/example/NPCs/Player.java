package org.example.NPCs;

import org.example.items.IConsumable;
import org.example.items.IItem;

import java.util.List;

public class Player {
    private int HP;
    private int DMG;
    private double C_chance;
    private String name;
    private List<IItem> inventory;

    public Player(String name, int HP, int DMG, double C_chance) {
        this.HP = HP;
        this.DMG = DMG;
        this.C_chance = C_chance;
        this.name = name;

    }

    public int getHP() {
        return HP;
    }

    public int getDMG() {
        return DMG;
    }

    public String getName() {
        return name;
    }

    public double getC_chance() {
        return C_chance;
    }

    public void takeDamage(int damage) {
        this.HP -= damage;
    }

    public boolean isAlive() {
        return this.HP > 0;
    }

    public void resetHP() {
        this.HP = 100;
    }

    public void heal(int amount) {
        this.HP += amount;
    }

    public void onConsume(IItem item) {
        if (item instanceof IConsumable) {
            IConsumable consumable = (IConsumable) item;
            if (consumable.canBeConsumed()) {
                consumable.onConsume();
                inventory.remove(item);
            }
        }
    }
    public List<IItem> getInventory() {
        return inventory;
    }

    public void addItem(IItem item) {
        inventory.add(item);
    }
}