package org.AlienVsHumansGame.model.environment;

import java.util.HashMap;
import java.util.Map;

public class BiomeManager {


    private Map<String, Biome> biomes = new HashMap<>();

    private static final Biome FOREST = new Biome("Forest", "\033[48;5;34m");
    private static final Biome DESERT = new Biome("Desert", "\033[48;5;214m");
    private static final Biome WATER = new Biome("Water", "\033[48;5;33m");
    private static final Biome MOUNTAIN = new Biome("Mountain", "\033[48;5;235m");
    private static final Biome SNOW = new Biome("Snow", "\033[48;5;200m");

    public BiomeManager() {
        biomes.put("Forest", FOREST);
        biomes.put("Desert", DESERT);
        biomes.put("Water", WATER);
        biomes.put("Mountain", MOUNTAIN);
        biomes.put("Snow", SNOW);
    }

    public Biome getBiomeForTile(double noiseValue) {
        if (noiseValue <= -0.4) { // Make water range a bit more restrictive
            return WATER;
        } else if (noiseValue <= -0.1) { // Increase the forest range
            return FOREST;
        } else if (noiseValue <= 0.1) {  // Decrease the desert range
            return DESERT;
        } else if (noiseValue <= 0.3) { // Expand mountain range a little
            return MOUNTAIN;
        }
        return SNOW;
    }

    // Getters for each Biome
    public Biome getForestBiome() {
        return FOREST;
    }

    public Biome getDesertBiome() {
        return DESERT;
    }

    public Biome getWaterBiome() {
        return WATER;
    }

    public Biome getMountainBiome() {
        return MOUNTAIN;
    }

    public Biome getSnowBiome() {
        return SNOW;
    }
}
