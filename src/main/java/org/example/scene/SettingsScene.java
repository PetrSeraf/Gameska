package org.example.scene;

import org.example.Managers.SceneManager;
import org.example.Managers.SettingsManager;

public class SettingsScene implements IScene {
    SceneManager manager;
    SettingsManager settingsManager = new SettingsManager();
    @Override
    public void init(SceneManager manager) {this.manager = manager;}

    @Override
    public void update(String line) {
        if (line.contains("1")) {
            manager.setCurrentScene(1);
            settingsManager.loop();
        }
    }

    @Override
    public void render() {
        System.out.println("[1] Difficulty");
        System.out.println("[2] Audio");
        System.out.println("[3] Video");
    }
}