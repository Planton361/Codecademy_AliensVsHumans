package org.AlienVsHumansGame.model.environment;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TileTest {

    private Tile tile;
    private Biome biome;
    private BiomeManager biomeManager;

    @BeforeEach
    void setUp() {
        // Use the getter from BiomeManager to provide the biome
        biomeManager = new BiomeManager();
        biome = biomeManager.getForestBiome(); // Default biome for setup
        tile = new Tile(1, 1, biome);
    }


    @Test
    public void testConstructor() {
        System.out.println("Testing construtor...");
        assertEquals(1, tile.getPosX(), "Should be x = 1");
        assertEquals(1, tile.getPoxY(), "Should be y = 1");
        assertEquals(biome, tile.getBiome(), "Should be biome Forest");
        System.out.println("Successfull");
        System.out.println();
    }

    @Test
    public void testSettingPosition() {
        System.out.println("Testing setting position");
        tile.setPosX(10);
        tile.setPoxY(15);
        assertEquals(10, tile.getPosX(), "Should be x = 10 after the change");
        assertEquals(15, tile.getPoxY(), "Should be y = 15 after the change");
        System.out.println("Successfull");
        System.out.println();

    }

    @Test
    public void testSettingBiome() {
        System.out.println("Testing setting biome");
        tile.setBiome(biomeManager.getMountainBiome());
        assertEquals(biomeManager.getMountainBiome(), tile.getBiome(), "Should be MOUNTAIN biome");
        System.out.println("Successfull");
        System.out.println();
    }

    @Test
    void testNullBiome() {
        System.out.println("Testing setting biome to null");
        tile.setBiome(null);
        assertNull(tile.getBiome(), "Biome should be null after setting it to null");
        System.out.println("Successfull");
        System.out.println();


    }

    @Test
    void testToString() {
        System.out.println("Testing toString ");
        String expectedOutput = "\033[48;5;34m F \033[0m"; // Based on FOREST biome
        assertEquals(expectedOutput, tile.toString(), "String representation should match the expected format");
        System.out.println("Successfull");
        System.out.println();
    }

    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("All tests are finished. Performing cleanup...");
        // If any cleanup is needed, do it here (e.g., closing resources, resetting static variables).
    }
}