package org.AlienVsHumansGame.model.environment;

import org.AlienVsHumansGame.model.Logic.PerlinNoise;

public class GameEnvironment {
    private TileMap tileMap;



    // Updated constructor to accept PerlinNoise and TileGenarator as parameters
    public GameEnvironment(int rows, int cols, PerlinNoise perlinNoise, TileGenarator tileGenarator) {
        tileMap = new TileMap(rows, cols, perlinNoise, tileGenarator);  // Pass dependencies to TileMap
        tileMap.generateMap();
    }

    public void printMap() {
        for (int x = 0; x < tileMap.getRows(); x++) {
            for (int y = 0; y < tileMap.getCols(); y++) {
                System.out.print(tileMap.getTile(x, y).toString());
            }
            System.out.println();
        }
    }
}
