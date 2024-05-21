package org.example;

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
            manager.setCurrentScene(2);
        }

        if (line.contains("4")) {
            //todo
        }
    }

    @Override
    public void render() {
        System.out.println("Main Menu");
        System.out.println("[1] Play");
        System.out.println("[2] Settings");
        System.out.println("[3] Credits");
        System.out.println("[4] Exit");

    }
}