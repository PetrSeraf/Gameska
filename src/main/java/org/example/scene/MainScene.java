package org.example.scene;

import org.example.Managers.SceneManager;

public class MainScene implements IScene {
    SceneManager manager;
    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        if (line.contains("1")) {
            manager.setCurrentScene(1);
        }
        if (line.contains("2")) {
            manager.setCurrentScene(4);
        }
        if (line.contains("3")) {
            manager.setCurrentScene(2);
        }
        if (line.contains("4")) {
            System.exit(0);
        }
    }

    @Override
    public void render() {
        System.out.println("Main Menu");
        System.out.println("[1] Play");
        System.out.println("[2] Difficulty");
        System.out.println("[3] Credits");
        System.out.println("[4] Exit");

    }
}