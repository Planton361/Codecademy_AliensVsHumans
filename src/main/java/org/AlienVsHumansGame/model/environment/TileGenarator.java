package org.AlienVsHumansGame.model.environment;

import org.AlienVsHumansGame.model.Logic.PerlinNoise;

public class TileGenarator {
    private PerlinNoise perlinNoise;
    private BiomeManager biomeManager;

    // Modify the constructor to accept PerlinNoise and BiomeManager
    public TileGenarator(PerlinNoise perlinNoise, BiomeManager biomeManager) {
        this.perlinNoise = perlinNoise;
        this.biomeManager = biomeManager;
    }

    public Tile generateTile(int x, int y){
        double noiseValue = perlinNoise.noise(x, y);
        Biome biome = biomeManager.getBiomeForTile(noiseValue);
        return new Tile(x, y, biome);
    }
}
