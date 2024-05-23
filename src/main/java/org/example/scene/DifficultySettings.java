package org.example.scene;

import org.example.Managers.SceneManager;

public class DifficultySettings implements IScene {
    private SceneManager manager;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        switch(line) {
            case "1":
                manager.setDifficultyLevel(1); // Easy
                break;
            case "2":
                manager.setDifficultyLevel(2); // Medium
                break;
            case "3":
                manager.setDifficultyLevel(3); // Hard
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
                return;
        }
        System.out.println("Difficulty set to " + (line.equals("1") ? "Easy" : line.equals("2") ? "Medium" : "Hard"));
        manager.setCurrentScene(1); // Assuming 0 is the main scene index
    }

    @Override
    public void render() {
        System.out.println("[1] Easy");
        System.out.println("[2] Medium");
        System.out.println("[3] Hard");
    }
}