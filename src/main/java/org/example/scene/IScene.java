package org.example.scene;

import org.example.Managers.SceneManager;

public interface IScene {
    public void init(SceneManager manager);
    public void update(String line);
    public void render();
}