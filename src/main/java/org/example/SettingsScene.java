package org.example;

public class SettingsScene implements IScene{
    SceneManager manager;

    @Override
    public void init(SceneManager manager) {this.manager = manager;}

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
        System.out.println("[1] Difficulty");
        System.out.println("[2] Audio");
        System.out.println("[3] Video");
    }
}
