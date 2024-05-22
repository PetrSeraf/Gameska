package org.example.scene;

import org.example.Managers.SceneManager;

import java.util.Random;

public class GameMapScene implements IScene {
    SceneManager manager;
    private int playerX;
    private int playerY;
    private boolean[][] blindmap;
    private boolean[][] monsterEncounter;
    private boolean[][] restrictedAreas;
    private final int mapWidth = 100;
    private final int mapHeight = 100;

    @Override
    public void init(SceneManager manager) {
        this.manager = manager;
        this.playerX = mapWidth / 2;
        this.playerY = mapHeight / 2;

        blindmap = new boolean[mapHeight][mapWidth];
        monsterEncounter = new boolean[mapHeight][mapWidth];
        restrictedAreas = new boolean[mapHeight][mapWidth];

        generateMonsterEncounters(200);
        generateBlindSpots(400);
        generateRestrictedAreas();
    }

    private void generateBlindSpots(int numBlindSpots) {
        Random rand = new Random();
        for (int i = 0; i < numBlindSpots; i++) {
            int x, y;
            do {
                x = rand.nextInt(mapWidth);
                y = rand.nextInt(mapHeight);
            } while (blindmap[y][x] || restrictedAreas[y][x]|| monsterEncounter[y][x]);
            blindmap[y][x] = true;
        }
    }
    private void generateMonsterEncounters(int numMonsterEncounters) {
        Random rand = new Random();
        for (int i = 0; i < numMonsterEncounters; i++) {
            int x, y;
            do {
                x = rand.nextInt(mapWidth);
                y = rand.nextInt(mapHeight);
            } while (blindmap[y][x] || restrictedAreas[y][x]||monsterEncounter[y][x]);
            monsterEncounter[y][x] = true;
        }
    }

    private void generateRestrictedAreas() {
        Random rand = new Random();
        int numAreas = rand.nextInt(10) + 1;

        for (int i = 0; i < numAreas; i++) {
            int areaSize = rand.nextInt(20) + 10;
            int x, y;
            do {
                x = rand.nextInt(mapWidth);
                y = rand.nextInt(mapHeight);
            } while (blindmap[y][x] || restrictedAreas[y][x] || monsterEncounter[y][x] || areaSize + x >= mapWidth || areaSize + y >= mapHeight);
            for (int j = 0; j < areaSize; j++) {
                for (int k = 0; k < areaSize; k++) {
                    restrictedAreas[y + j][x + k] = true;
                }
            }
        }
    }

    private boolean isRestrictedArea(int x, int y) {
        return restrictedAreas[y][x];
    }

    @Override
    public void update(String line) {
        int newX = playerX;
        int newY = playerY;

        switch (line.toLowerCase()) {
            case "w":
                if (playerY > 0) newY = playerY - 1;
                break;
            case "s":
                if (playerY < mapHeight - 1) newY = playerY + 1;
                break;
            case "a":
                if (playerX > 0) newX = playerX - 1;
                break;
            case "d":
                if (playerX < mapWidth - 1) newX = playerX + 1;
                break;
            default:
                System.out.println("Invalid command. Use 'w' for up, 's' for down, 'a' for left, or 'd' for right.");
                return;
        }

        if (blindmap[newY][newX]) {
            System.out.println("Can't move there, it's a blind spot!");
            return;
        }

        if (isRestrictedArea(newX, newY)) {
            System.out.println("Can't move there, it's a restricted area!");
            return;
        }
        if (monsterEncounter[newY][newX]) {
            manager.setCurrentScene(3);
            return;
        }

        playerX = newX;
        playerY = newY;
    }

    @Override
    public void render() {
        int halfViewSize = 5;

        int startX = Math.max(0, playerX - halfViewSize);
        int endX = Math.min(mapWidth - 1, playerX + halfViewSize);
        int startY = Math.max(0, playerY - halfViewSize);
        int endY = Math.min(mapHeight - 1, playerY + halfViewSize);

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print("P ");
                } else if (blindmap[y][x]) {
                    System.out.print("X ");
                } else if (restrictedAreas[y][x]) {
                    System.out.print("R ");
                }else if (monsterEncounter[y][x]) {
                    System.out.print("M ");
                }else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}