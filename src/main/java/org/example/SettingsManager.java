package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class SettingsManager {
    public ArrayList<ISettings> sceneArray;
    private int index;

    public ISettings getCurrentScene() {
        return sceneArray.get(index);
    }

    public void setCurrentScene(int newIndex) {
        if (newIndex >= sceneArray.size())
            return;

        index = newIndex;
    }

    public SettingsManager() {
        sceneArray = new ArrayList<ISettings>();
        index = 0;


        // Adding scenes to array
        sceneArray.add((ISettings) new DifficultySettings());

        // Initializing all scenes
        for (ISettings scene : sceneArray) {
            scene.init(this);
        }
    }

    public void loop() {
        String line = "";
        while (true) {
            getCurrentScene().update(line);
            getCurrentScene().render();
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine();
        }
    }
}