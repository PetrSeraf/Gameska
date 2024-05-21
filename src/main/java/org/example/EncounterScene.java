package org.example;

import java.util.ArrayList;
import java.util.Random;

public class EncounterScene implements IScene {
    private SceneManager manager;
    private ArrayList<Monster> monsters;
    private Monster currentMonster;
    private boolean combatActive;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
        monsters = new ArrayList<>();
        monsters.add(new Monster("Zombie", 10, 10, 200));
        monsters.add(new Monster("Skeleton", 15, 15, 100));
        monsters.add(new Monster("Wolf", 20, 25, 70));
        monsters.add(new Monster("Squirrel", 100, 50, 10));
        combatActive = false;
    }

    @Override
    public void update(String line) {
        switch (line.toLowerCase()) {
            case "c":
                if (!combatActive) {
                    initiateCombat();
                } else {
                    System.out.println("You are already in combat!");
                }
                break;
            case "a":
                if (combatActive && currentMonster != null) {
                    playerAttack();
                } else {
                    System.out.println("No monster to attack. Use 'c' to initiate combat.");
                }
                break;
            default:
                System.out.println("Invalid command. Use 'c' for combat, 'a' to attack.");
                return;
        }
    }

    @Override
    public void render() {
        if (combatActive && currentMonster != null) {
            System.out.println("Encountered a " + currentMonster.getName() + "!");
            System.out.println("Monster HP: " + currentMonster.getHealth());
        } else {
            System.out.println("No monsters encountered. Use 'c' to initiate combat.");
        }
    }

    private void initiateCombat() {
        Random rand = new Random();
        currentMonster = monsters.get(rand.nextInt(monsters.size()));
        combatActive = true;
        System.out.println("A wild " + currentMonster.getName() + " appears!");
    }

    private void playerAttack() {
        Random rand = new Random();
        int playerAttack = rand.nextInt(50) + 30; // Random player attack strength between 7 and 26
        int damage = playerAttack - currentMonster.getDefense();
        if (damage > 0) {
            currentMonster.takeDamage(damage);
            System.out.println("You hit the " + currentMonster.getName() + " for " + damage + " damage!");
        } else {
            System.out.println("Your attack was too weak to damage the " + currentMonster.getName() + "!");
        }

        if (currentMonster.isAlive()) {
            monsterAttack();
        } else {
            System.out.println("You defeated the " + currentMonster.getName() + "!");
            currentMonster = null;
            combatActive = false;
            manager.setCurrentScene(1); // Return to map after combat
        }
    }

    private void monsterAttack() {
        Random rand = new Random();
        int monsterAttack = currentMonster.getAttack();
        int playerDefense = rand.nextInt(20) + 1; // Random player defense between 1 and 20
        int damage = monsterAttack - playerDefense;
        if (damage > 0) {
            System.out.println("The " + currentMonster.getName() + " hits you for " + damage + " damage!");
        } else {
            System.out.println("You blocked the " + currentMonster.getName() + "'s attack!");
        }
    }
}
