package org.example.NPCs;

import org.example.items.IConsumeable;
import org.example.items.IItem;
import org.example.items.IEquipable;
import java.util.ArrayList;

public class Player {
    private int HP;
    private int DMG;
    private double C_chance;
    private String name;
    public ArrayList<IItem> inventory;

    public Player(String name, int HP, int DMG, double C_chance) {
        this.HP = HP;
        this.DMG = DMG;
        this.C_chance = C_chance;
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public int getHP() {
        return HP;
    }

    public int getDMG() {
        return DMG;
    }

    public void setDMG(int DMG) {
        this.DMG = DMG;
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
        // Optional: You can add a max HP limit if needed
        // this.HP = Math.min(this.HP + amount, maxHP);
    }

    public void consumeItem(IItem item) {
        if (item instanceof IConsumeable) {
            IConsumeable consumable = (IConsumeable) item;
            if (consumable.canBeConsumed()) {
                consumable.onConsume();
                inventory.remove(item); // Remove item from inventory after consumption
            }
        }
    }

    public void equipItem(IItem item) {
        if (item instanceof IEquipable) {
            IEquipable equipable = (IEquipable) item;
            if (equipable.canBeEquiped()) {
                equipable.onEquip();
            }
        }
    }
}