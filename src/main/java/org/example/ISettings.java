package org.example;

public interface ISettings {
    public void init(SettingsManager manager);
    public void update(String line);
    public void render();
}