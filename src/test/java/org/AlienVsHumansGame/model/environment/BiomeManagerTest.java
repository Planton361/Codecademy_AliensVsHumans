package org.AlienVsHumansGame.model.environment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiomeManagerTest {
    private BiomeManager biomeManager;

    @BeforeEach
    void setUp() {
        biomeManager = new BiomeManager();
    }

    @Test
    void testBiomeManagerInitialization() {
        System.out.println("Testing biomeManagerInitialization...");
        // Test that all biomes are initialized correctly
        assertNotNull(biomeManager.getBiomeForTile(-1.0), "Biome for noise value -1.0 should not be null");
        assertNotNull(biomeManager.getBiomeForTile(0.0), "Biome for noise value 0.0 should not be null");

        System.out.println("Successfull");
        System.out.println();
    }


    @Test
    void testGetBiomeForTile() {
        System.out.println("Testing getBiomeForTile...");
        // Test WATER range
        assertEquals(biomeManager.getWaterBiome(), biomeManager.getBiomeForTile(-0.5), "Noise value -0.5 should return WATER");
        assertEquals(biomeManager.getWaterBiome(), biomeManager.getBiomeForTile(-0.4), "Noise value -0.4 should return WATER");

        // Test FOREST range
        assertEquals(biomeManager.getForestBiome(), biomeManager.getBiomeForTile(-0.3), "Noise value -0.3 should return FOREST");
        assertEquals(biomeManager.getForestBiome(), biomeManager.getBiomeForTile(-0.1), "Noise value -0.1 should return FOREST");

        // Test DESERT range
        assertEquals(biomeManager.getDesertBiome(), biomeManager.getBiomeForTile(0.0), "Noise value 0.0 should return DESERT");
        assertEquals(biomeManager.getDesertBiome(), biomeManager.getBiomeForTile(0.1), "Noise value 0.1 should return DESERT");

        // Test MOUNTAIN range
        assertEquals(biomeManager.getMountainBiome(), biomeManager.getBiomeForTile(0.2), "Noise value 0.2 should return MOUNTAIN");
        assertEquals(biomeManager.getMountainBiome(), biomeManager.getBiomeForTile(0.3), "Noise value 0.3 should return MOUNTAIN");

        // Test SNOW range
        assertEquals(biomeManager.getSnowBiome(), biomeManager.getBiomeForTile(0.4), "Noise value 0.4 should return SNOW");
        assertEquals(biomeManager.getSnowBiome(), biomeManager.getBiomeForTile(1.0), "Noise value 1.0 should return SNOW");

        System.out.println("Successfull");
        System.out.println();
    }


    @Test
    void testEdgeCases() {
        System.out.println("Testing boundaries of biomes...");
        // Test values on boundaries
        assertEquals(biomeManager.getWaterBiome(), biomeManager.getBiomeForTile(-0.4), "Boundary value -0.4 should return WATER");
        assertEquals(biomeManager.getForestBiome(), biomeManager.getBiomeForTile(-0.1), "Boundary value -0.1 should return FOREST");
        assertEquals(biomeManager.getDesertBiome(), biomeManager.getBiomeForTile(0.1), "Boundary value 0.1 should return DESERT");
        assertEquals(biomeManager.getMountainBiome(), biomeManager.getBiomeForTile(0.3), "Boundary value 0.3 should return MOUNTAIN");

        System.out.println("Successfull");
        System.out.println();
    }
}
