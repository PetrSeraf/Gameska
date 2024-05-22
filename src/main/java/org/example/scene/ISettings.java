package org.example.scene;

import org.example.Managers.SettingsManager;

public interface ISettings {
    public void init(SettingsManager manager);
    public void update(String line);
    public void render();
}