package org.example.scene;

import org.example.Managers.SceneManager;
import org.example.NPCs.Monster;
import org.example.NPCs.Player;
import org.example.items.*;

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
        player = manager.getPlayer();
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
            case "i":
                manager.setCurrentScene(6);
                break;
            default:
                System.out.println("Invalid command. Use 'c' for combat, 'a' to attack, 'i' to access inventory.");
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
        int playerAttack = rand.nextInt(30) + 7;
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
                manager.setCurrentScene(6);
            }
        } else {
            System.out.println("You defeated the " + currentMonster.getName() + "!");
            handleLoot(currentMonster.getLoot());
            combatActive = false;
            resetPlayer();
            manager.setCurrentScene(1);
        }
    }

    private void handleLoot(List<IItem> loot) {
        System.out.println("You have obtained the following items:");
        for (IItem item : loot) {
            if (item instanceof Pear || item instanceof Mace || item instanceof Sword || item instanceof Apple) {
                Random rand = new Random();
                int dropChance = rand.nextInt(100);
                if (dropChance <30) {
                    player.inventory.add(item);
                    System.out.println("- " + item.getName());
                }
                else System.out.println("You are unlucky nothing dropped");
            } else {
                player.inventory.add(item);
                System.out.println("- " + item.getName());
            }
        }
    }

    private void monsterAttack() {
        Random rand = new Random();
        int monsterAttack = currentMonster.getAttack();
        int playerDefense = rand.nextInt(20) + 5;
        int damage = monsterAttack - playerDefense;
        if (damage > 0) {
            player.takeDamage(damage);
            System.out.println("The " + currentMonster.getName() + " hits you for " + damage + " damage!");
        } else {
            System.out.println("You blocked the " + currentMonster.getName() + "!");
        }
    }

    private void resetPlayer() {
        player.resetHP();
    }
}