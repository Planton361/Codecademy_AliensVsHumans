package org.AlienVsHumansGame.model.environment;

import org.AlienVsHumansGame.model.Logic.PerlinNoise;

public class TileGenarator {
    private PerlinNoise perlinNoise;
    private BiomeManager biomeManager;

    public TileGenarator(){
        this.perlinNoise = new PerlinNoise(1);
        this.biomeManager = new BiomeManager();
    }

    public Tile generateTile(int x, int y){
        double noiseValue = perlinNoise.noise(x, y);
        Biome biome = biomeManager.getBiomeForTile(noiseValue);
        return new Tile(x,y,biome);
    }

}
