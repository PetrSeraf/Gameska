package org.example.Managers;

import org.example.NPCs.Monster;
import org.example.scene.ISettings;
import org.example.scene.Settings.DifficultySettings;

import java.util.ArrayList;
import java.util.Scanner;

public class SettingsManager {
    public ArrayList<ISettings> sceneArray;
    private int index;
    private int difficultyLevel; // 1 = Easy, 2 = Medium, 3 = Hard
    private ArrayList<Monster> monsters;

    public SettingsManager() {
        sceneArray = new ArrayList<>();
        index = 0;
        difficultyLevel = 2; // Default to Medium
        sceneArray.add(new DifficultySettings());
        for (ISettings scene : sceneArray) {
            scene.init(this);
        }
        monsters = new ArrayList<>();
        initializeMonsters();
    }

    private void initializeMonsters() {
        monsters.add(new Monster("Zombie", 10, 10, 200));
        monsters.add(new Monster("Skeleton", 15, 15, 100));
        monsters.add(new Monster("Wolf", 20, 25, 70));
        monsters.add(new Monster("Squirrel", 100, 50, 10));
        updateMonsterStats();
    }

    public void setCurrentScene(int newIndex) {
        if (newIndex >= sceneArray.size())
            return;
        index = newIndex;
    }

    public ISettings getCurrentScene() {
        return sceneArray.get(index);
    }

    public void setDifficultyLevel(int level) {
        difficultyLevel = level;
        updateMonsterStats();
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    private void updateMonsterStats() {
        for (Monster monster : monsters) {
            switch (difficultyLevel) {
                case 1: // Easy
                    monster.setAttack(monster.getBaseAttack() - 5);
                    monster.setDefense(monster.getBaseDefense() - 5);
                    monster.setHealth(monster.getBaseHealth() - 50);
                    break;
                case 2: // Medium
                    monster.setAttack(monster.getBaseAttack());
                    monster.setDefense(monster.getBaseDefense());
                    monster.setHealth(monster.getBaseHealth());
                    break;
                case 3: // Hard
                    monster.setAttack(monster.getBaseAttack() + 5);
                    monster.setDefense(monster.getBaseDefense() + 5);
                    monster.setHealth(monster.getBaseHealth() + 50);
                    break;
            }
        }
    }

    public void loop() {
        String line = "";
        while (true) {
            getCurrentScene().update(line);
            getCurrentScene().render();
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine();
        }
    }
}