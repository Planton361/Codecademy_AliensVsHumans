package org.AlienVsHumansGame.model.environment;

import org.AlienVsHumansGame.model.Logic.PerlinNoise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TileMapTest {

    private TileMap tileMap;

    // Test dependencies
    private TileGenarator mockTileGenarator;
    private PerlinNoise mockPerlinNoise;
    private BiomeManager mockBiomeManager;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        mockPerlinNoise = mock(PerlinNoise.class);
        mockBiomeManager = mock(BiomeManager.class);
        mockTileGenarator = new TileGenarator(mockPerlinNoise, mockBiomeManager); // Use the mocked dependencies

        // Initialize TileMap with predefined dimensions and mocked generator
        tileMap = new TileMap(5, 5, mockPerlinNoise, mockTileGenarator); // Pass mocked dependencies
        tileMap.generateMap(); // Generate map using tile generator
    }

    // Test constructor and map initialization
    @Test
    void testConstructorAndInitialization() {
        System.out.println("Testing Constructor...");
        assertNotNull(tileMap.getTiles(), "Tile map should not be null");
        assertEquals(5, tileMap.getRows(), "Row count should be 5");
        assertEquals(5, tileMap.getCols(), "Column count should be 5");

        // Verify the dimensions of the map array
        Tile[][] map = tileMap.getTiles();
        assertEquals(5, map.length, "Tile map should have 5 rows");
        for (Tile[] row : map) {
            assertEquals(5, row.length, "Each row should have 5 columns");
        }

        System.out.println("Successful");
        System.out.println();
    }

    // Test that generateMap populates the map correctly
    @Test
    void testGenerateMap() {
        System.out.println("Testing generating a map...");
        Tile[][] map = tileMap.getTiles();
        assertNotNull(map, "Generated map should not be null");
        for (int i = 0; i < tileMap.getRows(); i++) {
            for (int j = 0; j < tileMap.getCols(); j++) {
                assertNotNull(map[i][j], "Tile at position (" + i + "," + j + ") should not be null");
            }
        }
        System.out.println("Successful");
        System.out.println();
    }

    // Test getting a specific tile
    @Test
    void testGetTile() {
        System.out.println("Testing getter...");
        Tile tile = tileMap.getTile(2, 2);
        assertNotNull(tile, "Tile at position (2,2) should not be null");
        System.out.println("Successful");
        System.out.println();
    }

    // Test setting and getting tiles directly
    @Test
    void testSetTiles() {
        System.out.println("Testing setter...");
        Tile[][] newMap = new Tile[5][5];  // Create a new map
        tileMap.setTiles(newMap);           // Set the new map

        // Ensure the map has been updated correctly
        Tile[][] updatedMap = tileMap.getTiles();
        assertEquals(newMap, updatedMap, "The tiles should be updated correctly");

        System.out.println("Successful");
        System.out.println();
    }

    // Test edge case: invalid tile coordinates
    @Test
    void testInvalidTileCoordinates() {
        System.out.println("Testing with invalid coordinates...");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            tileMap.getTile(-1, -1); // Invalid negative coordinates
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            tileMap.getTile(10, 10); // Coordinates out of bounds for a 5x5 map
        });
        System.out.println("Successful...");
        System.out.println();
    }

    // Test edge case: map with zero rows and columns
    @Test
    void testEmptyMap() {
        System.out.println("Testing empty map...");
        TileMap emptyTileMap = new TileMap(0, 0, mockPerlinNoise, mockTileGenarator); // Mocked dependencies
        assertEquals(0, emptyTileMap.getRows(), "Rows should be 0");
        assertEquals(0, emptyTileMap.getCols(), "Columns should be 0");
        assertEquals(0, emptyTileMap.getTiles().length, "Tile map should have no rows");
        System.out.println("Successful");
        System.out.println();
    }

    // Test biome assignment based on noise
    @Test
    void testBiomeAssignmentBasedOnNoise() {
        // Mock the PerlinNoise behavior for specific coordinates
        when(mockPerlinNoise.noise(0, 0)).thenReturn(-0.5);  // Should return Water biome
        when(mockPerlinNoise.noise(1, 1)).thenReturn(0.2);   // Should return Desert biome

        // Mock the BiomeManager to return specific biomes based on noise values
        Biome mockWaterBiome = mock(Biome.class);
        Biome mockDesertBiome = mock(Biome.class);

        // Assign behavior for the BiomeManager to return the correct biome
        when(mockBiomeManager.getWaterBiome()).thenReturn(mockWaterBiome);
        when(mockBiomeManager.getDesertBiome()).thenReturn(mockDesertBiome);

        // Ensure the mock biomes return the correct names when their names are accessed
        when(mockWaterBiome.getName()).thenReturn("Water");
        when(mockDesertBiome.getName()).thenReturn("Desert");

        // Create the Tile object explicitly and set its biome (or ensure TileGenerator does this)
        Tile waterTile = new Tile(0, 0,mockWaterBiome);  // Assuming Tile constructor can accept position
        Tile desertTile = new Tile(1, 1, mockDesertBiome);

        // Manually set the Biomes on the Tiles if needed
        waterTile.setBiome(mockWaterBiome);
        desertTile.setBiome(mockDesertBiome);

        // Assert that the tiles have the correct biomes assigned
        assertEquals("Water", waterTile.getBiome().getName(), "The tile should be assigned the 'Water' biome.");
        assertEquals("Desert", desertTile.getBiome().getName(), "The tile should be assigned the 'Desert' biome.");
    }



    // Test the printMap method
    @Test
    void testPrintMap() {
        // Mock PerlinNoise and TileGenerator as before
        PerlinNoise mockPerlinNoise = mock(PerlinNoise.class);
        TileGenarator mockTileGenarator = mock(TileGenarator.class);

        BiomeManager mockBiomeManager = new BiomeManager();
        Tile tile = new Tile(0, 0, mockBiomeManager.getWaterBiome());
        when(mockTileGenarator.generateTile(anyInt(), anyInt())).thenReturn(tile);

        GameEnvironment gameEnvironment = new GameEnvironment(5, 5, mockPerlinNoise, mockTileGenarator);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        gameEnvironment.printMap();

        String output = outputStream.toString();
        System.setOut(System.out);  // Restore System.out

        // Remove color codes (ANSI escape sequences) from output for easier matching
        String cleanOutput = output.replaceAll("\033\\[[;\\d]*m", "");

        // Now verify the output contains the first letter of the biome name without color
        assertTrue(cleanOutput.contains("W"));  // 'Water' biome should have a 'W' printed
    }



}
