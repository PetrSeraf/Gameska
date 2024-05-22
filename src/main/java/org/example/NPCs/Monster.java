package org.example.NPCs;

public class Monster {
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int initialHealth;
    private int baseAttack;
    private int baseDefense;
    private int baseHealth;

    public Monster(String name, int attack, int defense, int health) {
        this.name = name;
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.baseHealth = health;
        resetStats();
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void resetHealth() {
        this.health = this.initialHealth;
    }

    public void resetStats() {
        this.attack = baseAttack;
        this.defense = baseDefense;
        this.health = baseHealth;
        this.initialHealth = baseHealth;
    }
}