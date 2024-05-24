package org.example.Managers;

import org.example.NPCs.Monster;
import org.example.scene.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SceneManager {
    public ArrayList<IScene> sceneArray;
    private int index;
    private int difficultyLevel;
    private List<Monster> monsters;

    public IScene getCurrentScene() {
        return sceneArray.get(index);
    }

    public void setCurrentScene(int newIndex) {
        if (newIndex >= sceneArray.size())
            return;
        index = newIndex;
    }

    public SceneManager() {
        sceneArray = new ArrayList<>();
        index = 0;

        // Adding scenes to array
        sceneArray.add(new MainScene());
        sceneArray.add(new GameMapScene());
        sceneArray.add(new CreditsScene());
        sceneArray.add(new EncounterScene(this));
        sceneArray.add(new DifficultySettings());
        sceneArray.add(new InventoryScene());
        sceneArray.add(new GameOverScene());

        difficultyLevel = 2; // Default to Medium
        monsters = new ArrayList<>();
        initializeMonsters();

        // Initializing all scenes
        for (IScene scene : sceneArray) {
            scene.init(this);
        }
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
        monsters.add(new Monster("Zombie", 10, 10, 200));
        monsters.add(new Monster("Skeleton", 15, 15, 100));
        monsters.add(new Monster("Wolf", 20, 25, 70));
        monsters.add(new Monster("Squirrel", 100, 50, 10));
        updateMonsterStats();
    }

    public void setDifficultyLevel(int level) {
        difficultyLevel = level;
        updateMonsterStats();
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public List<Monster> getMonsters() {
        return monsters;
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