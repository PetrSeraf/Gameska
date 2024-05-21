

package org.example;

public class Monster {
    private String name;
    private int attack;
    private int defense;
    private int health;

    public Monster(String name, int attack, int defense, int health) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
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
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}