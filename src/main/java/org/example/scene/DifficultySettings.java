package org.example.scene;

import org.example.Managers.SceneManager;

public class DifficultySettings implements IScene {
    SceneManager manager;

    @Override
    public void init(SceneManager manager) {
        this.manager=manager;
    }

    @Override
    public void update(String line) {
        switch(line)
        {
            case "1","2","3":
            {
                manager.setCurrentScene(1);
            }
            default:
        }
        switch(line)
        {
            case "1":{}
        }
    }

    @Override
    public void render() {
        System.out.println("[1] Easy");
        System.out.println("[2] Medium");
        System.out.println("[3] Hard");
    }
}