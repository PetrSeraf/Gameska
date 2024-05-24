package org.example.scene;

import org.example.NPCs.Monster;
import org.example.NPCs.Player;
import org.example.Managers.SceneManager;

import java.util.List;
import java.util.Random;

public class EncounterScene implements IScene {
    private SceneManager manager;
    private List<Monster> monsters;
    private Monster currentMonster;
    private Player player;
    private boolean combatActive;

    public EncounterScene(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
        this.monsters = manager.getMonsters();
        player = new Player("Hero", 10, 20, 10);
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
            System.out.println(player.getName() + " HP: " + player.getHP());
        } else {
            System.out.println("No monsters encountered. Use 'c' to initiate combat.");
        }
    }

    private void initiateCombat() {
        Random rand = new Random();
        currentMonster = monsters.get(rand.nextInt(monsters.size()));
        currentMonster.resetHealth();
        combatActive = true;
        System.out.println("A wild " + currentMonster.getName() + " appears!");
    }

    private void playerAttack() {
        Random rand = new Random();
        int playerAttack = rand.nextInt(30) + 7; // Random player attack strength between 7 and 26
        int damage = playerAttack - currentMonster.getDefense();
        if (damage > 0) {
            currentMonster.takeDamage(damage);
            System.out.println("You hit the " + currentMonster.getName() + " for " + damage + " damage!");
        } else {
            System.out.println("Your attack was too weak to damage the " + currentMonster.getName() + "!");
        }

        if (currentMonster.isAlive()) {
            monsterAttack();
            if (!player.isAlive()) {
                System.out.println("You have been defeated by the " + currentMonster.getName() + "!");
                resetPlayer();
                combatActive = false; // Combat ends when player dies
                manager.setCurrentScene(6); // Return to map after player dies
            }
        } else {
            System.out.println("You defeated the " + currentMonster.getName() + "!");
            combatActive = false;
            resetPlayer();
            manager.setCurrentScene(1); // Return to map after combat
        }
    }

    private void monsterAttack() {
        Random rand = new Random();
        int monsterAttack = currentMonster.getAttack();
        int playerDefense = rand.nextInt(20) + 1; // Random player defense between 1 and 20
        int damage = monsterAttack - playerDefense;
        if (damage > 0) {
            player.takeDamage(damage);
            System.out.println("The " + currentMonster.getName() + " hits you for " + damage + " damage!");
        } else {
            System.out.println("You blocked the " + currentMonster.getName() + "'s attack!");
        }
    }

    private void resetPlayer() {
        player.resetHP();
    }
}