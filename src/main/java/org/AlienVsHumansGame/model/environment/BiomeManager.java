package org.AlienVsHumansGame.model.environment;

import java.util.HashMap;
import java.util.Map;

public class BiomeManager {

    private Map<String, Biome> biomes = new HashMap<>();

    public static final Biome FOREST = new Biome("Forest", "\033[48;5;34m");
    public static final Biome DESERT = new Biome("Desert", "\033[48;5;214m");
    public static final Biome WATER = new Biome("Water", "\033[48;5;33m");
    private static final Biome MOUNTAIN = new Biome("Mountain", "\033[48;5;235m");
    private static final Biome SNOW = new Biome("Mountain", "\033[48;5;200m");

    public BiomeManager() {
        biomes.put("Forest", FOREST);
        biomes.put("Desert", DESERT);
        biomes.put("Water", WATER);
        biomes.put("Mountain", MOUNTAIN);
        biomes.put("Snow", SNOW);
    }

    public Biome getBiomeForTile(double noiseValue) {
        if (noiseValue < -0.4) { // Make water range a bit more restrictive
            return WATER;
        } else if (noiseValue < -0.1) { // Increase the forest range
            return FOREST;
        } else if (noiseValue < 0.1) {  // Decrease the desert range
            return DESERT;
        } else if (noiseValue < 0.3) { // Expand mountain range a little
            return MOUNTAIN;
        }
        return SNOW;
    }

    }



