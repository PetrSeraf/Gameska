package org.example.scene.Settings;

import org.example.Managers.SettingsManager;
import org.example.scene.ISettings;

public class DifficultySettings implements ISettings {
    SettingsManager manager;

    @Override
    public void init(SettingsManager manager) {

    }

    @Override
    public void update(String line) {
        switch(line)
        {
            case "1","2","3":
            {

            }
            default:
        }
    }

    @Override
    public void render() {
        System.out.println("[1] Easy");
        System.out.println("[2] Medium");
        System.out.println("[3] Hard");
    }
}
