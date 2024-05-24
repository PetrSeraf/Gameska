package org.example.scene;

import org.example.Managers.SceneManager;

public class GameOverScene implements IScene {
    private SceneManager manager;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {
        switch (line.toLowerCase()) {
            case "q":
                System.exit(0);
                break;
            case "r":
                manager.setCurrentScene(1);
                break;
            default:
                System.out.println("Invalid command. Use 'q' to quit and use 'r' to restart!");
        }
    }

    @Override
    public void render() {
        System.out.println("Game Over!");
        System.out.println("Press 'q' to quit and use 'r' to restart!");
    }
}
