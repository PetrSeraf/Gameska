package org.example.NPCs;

import org.example.items.IItem;

import java.util.List;

public class Monster {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int baseHealth; // New field to store initial health value
    private int baseAttack;
    private int baseDefense;
    private List<IItem> loot;

    public Monster(String name, int attack, int defense, int health, List<IItem> loot) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.baseHealth = health; // Initializing base health
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.loot = loot;
    }

    public void resetHealth() {
        this.health = baseHealth; // Resetting health to its initial value
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public List<IItem> getLoot() {
        return loot;
    }

    public void setLoot(List<IItem> loot) {
        this.loot = loot;
    }
}