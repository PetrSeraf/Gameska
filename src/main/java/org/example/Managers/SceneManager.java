package org.example.Managers;

import org.example.NPCs.Monster;
import org.example.NPCs.Player;
import org.example.items.*;
import org.example.scene.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SceneManager {
    private List<IScene> sceneArray;
    private int index;
    private int difficultyLevel;
    private List<Monster> monsters;
    private Player player;

    public SceneManager(Player player) {
        this.player = player;
        sceneArray = new ArrayList<>();
        index = 0;

        sceneArray.add(new MainScene());
        sceneArray.add(new GameMapScene());
        sceneArray.add(new CreditsScene());
        sceneArray.add(new EncounterScene(this));
        sceneArray.add(new DifficultySettings());
        sceneArray.add(new InventoryScene(player));
        sceneArray.add(new GameOverScene());

        difficultyLevel = 2;
        monsters = new ArrayList<>();
        initializeMonsters();


        for (IScene scene : sceneArray) {
            scene.init(this);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public IScene getCurrentScene() {
        return sceneArray.get(index);
    }

    public void setCurrentScene(int newIndex) {
        if (newIndex >= sceneArray.size())
            return;
        index = newIndex;
    }

    public void loop() {
        String line = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            getCurrentScene().render();
            line = scanner.nextLine();
            getCurrentScene().update(line);
        }
    }

    private void initializeMonsters() {
        List<IItem> zombieLoot = new ArrayList<>();
        zombieLoot.add(new Apple(player));
        List<IItem> skeletonLoot = new ArrayList<>();
        skeletonLoot.add(new Sword(player));
        List<IItem> squirrelLoot = new ArrayList<>();
        squirrelLoot.add(new Pear(player));
        List<IItem> wolfLoot = new ArrayList<>();
        wolfLoot.add(new Mace(player));

        monsters.add(new Monster("Zombie", 10, 10, 200, zombieLoot));
        monsters.add(new Monster("Skeleton", 15, 15, 100, skeletonLoot));
        monsters.add(new Monster("Wolf", 20, 15, 70, wolfLoot));
        monsters.add(new Monster("Squirrel", 50, 1, 10, squirrelLoot));

        updateMonsterStats();
    }

    public void setDifficultyLevel(int level) {
        difficultyLevel = level;
        updateMonsterStats();
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    private void updateMonsterStats() {
        for (Monster monster : monsters) {
            switch (difficultyLevel) {
                case 1: // Easy
                    monster.setAttack(monster.getBaseAttack() - 5);
                    monster.setDefense(monster.getBaseDefense() - 5);
                    break;
                case 2: // Medium
                    monster.setAttack(monster.getBaseAttack());
                    monster.setDefense(monster.getBaseDefense());
                    break;
                case 3: // Hard
                    monster.setAttack(monster.getBaseAttack() + 5);
                    monster.setDefense(monster.getBaseDefense() + 5);
                    break;
            }
            monster.resetHealth();
        }
    }
}