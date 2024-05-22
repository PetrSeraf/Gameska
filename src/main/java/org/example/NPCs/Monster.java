package org.example.NPCs;

public class Monster {
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int initialHealth;

    public Monster(String name, int attack, int defense, int health) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.initialHealth = health;
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
}