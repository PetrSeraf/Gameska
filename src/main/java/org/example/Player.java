package org.example;

public class Player {
    private int HP;
    private int DMG;
    private double C_chance;

    public Player(int HP, int DMG, double C_chance) {
        this.HP = HP;
        this.DMG = DMG;
        this.C_chance = C_chance;
    }

    public int getHP() {
        return HP;
    }

    public int getDMG() {
        return DMG;
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
}
