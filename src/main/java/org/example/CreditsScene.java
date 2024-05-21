package org.example;

public class CreditsScene implements IScene {
    private SceneManager manager;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(String line) {

    }

    @Override
    public void render() {
        System.out.println("Trun base game War Of Trans created by David and Peter as a project in tietoevry in 2024");
        System.out.println("Move using Words Up Down Left Right ");
        System.out.println("Use E for escape");
    }
}
