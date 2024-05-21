package org.example;

public class DifficultySettings implements ISettings{
    SettingsManager manager;

    @Override
    public void init(SettingsManager manager) {

    }

    @Override
    public void update(String line) {

    }

    @Override
    public void render() {
        System.out.println("[1] Easy");
        System.out.println("[2] Medium");
        System.out.println("[3] Hard");
    }
}
