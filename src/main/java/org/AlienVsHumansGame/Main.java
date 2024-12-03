package org.AlienVsHumansGame;

import org.AlienVsHumansGame.model.environment.GameEnvironment;
import org.AlienVsHumansGame.model.Logic.PerlinNoise;
import org.AlienVsHumansGame.model.environment.BiomeManager;
import org.AlienVsHumansGame.model.environment.TileGenarator;

public class Main {
    public static void main(String[] args) {
        // Create the required dependencies
        PerlinNoise perlinNoise = new PerlinNoise(1);  // Or whatever parameters you need
        BiomeManager biomeManager = new BiomeManager();
        TileGenarator tileGenarator = new TileGenarator(perlinNoise, biomeManager);

        // Create the GameEnvironment with the dependencies injected
        GameEnvironment gameEnvironment = new GameEnvironment(50, 50, perlinNoise, tileGenarator);

        // Print the map
        gameEnvironment.printMap();
    }
}
