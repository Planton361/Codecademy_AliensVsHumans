package org.AlienVsHumansGame.model.Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerlinNoiseTest {

    private PerlinNoise perlinNoise;

    @BeforeEach
    void setUp() {
        // Set up a new PerlinNoise instance before each test
        perlinNoise = new PerlinNoise();
    }

    @Test
    void testConstructorWithSeed() {
        double seed = 123.45;
        PerlinNoise perlinNoiseWithSeed = new PerlinNoise(seed);

        // Assert the seed is set correctly
        assertEquals(seed, perlinNoiseWithSeed.getSeed());
    }

    @Test
    void testConstructorWithoutSeed() {
        // Test the default constructor where the seed is randomly generated
        PerlinNoise perlinNoiseWithRandomSeed = new PerlinNoise();

        // Assert the seed is not equal to zero or a known seed (ensuring randomness)
        assertNotEquals(0, perlinNoiseWithRandomSeed.getSeed());
    }

    @Test
    void testSetSeed() {
        double seed = 123.45;
        perlinNoise.setSeed(seed);

        // Assert the seed is set correctly
        assertEquals(seed, perlinNoise.getSeed());
    }

    @Test
    void testNoiseWithThreeParameters() {
        double x = 0.5, y = 1.0, z = 1.5;
        double noiseValue = perlinNoise.noise(x, y, z);

        // Validate that the noise value is a reasonable floating-point number
        assertNotNull(noiseValue);
        assertTrue(noiseValue >= -1 && noiseValue <= 1); // Perlin noise values usually fall within this range
    }

    @Test
    void testNoiseWithTwoParameters() {
        double x = 0.5, y = 1.0;
        double noiseValue = perlinNoise.noise(x, y);

        // Validate that the noise value is a reasonable floating-point number
        assertNotNull(noiseValue);
        assertTrue(noiseValue >= -1 && noiseValue <= 1);
    }

    @Test
    void testNoiseWithOneParameter() {
        double x = 0.5;
        double noiseValue = perlinNoise.noise(x);

        // Validate that the noise value is a reasonable floating-point number
        assertNotNull(noiseValue);
        assertTrue(noiseValue >= -1 && noiseValue <= 1);
    }

    @Test
    void testEdgeCaseNoiseWithZeroInput() {
        double noiseValue = perlinNoise.noise(0, 0, 0);

        // Ensure the noise value is within the expected range for edge cases
        assertNotNull(noiseValue);
        assertTrue(noiseValue >= -1 && noiseValue <= 1);
    }

    @Test
    void testNoiseWithNegativeValues() {
        double noiseValue = perlinNoise.noise(-1.0, -2.0, -3.0);

        // Validate that the noise value is within the expected range
        assertNotNull(noiseValue);
        assertTrue(noiseValue >= -1 && noiseValue <= 1);
    }

    @Test
    void testSmoothNoise() {
        // Testing smoothNoise with different x, y, z values.
        double smoothNoiseValue = perlinNoise.smoothNoise(1.0, 2.0, 3.0);

        // Verify that smoothNoise value is within an expected range
        assertNotNull(smoothNoiseValue);
        assertTrue(smoothNoiseValue >= -1 && smoothNoiseValue <= 1);
    }

    @Test
    void testSeedImpactOnNoise() {
        double seed1 = 123.45;
        double seed2 = 543.21;

        PerlinNoise perlinNoise1 = new PerlinNoise(seed1);
        PerlinNoise perlinNoise2 = new PerlinNoise(seed2);

        double noise1 = perlinNoise1.noise(1.0, 2.0, 3.0);
        double noise2 = perlinNoise2.noise(1.0, 2.0, 3.0);

        // Assert that different seeds generate different noise values
        assertNotEquals(noise1, noise2, "Noise values with different seeds should not be equal");
    }

    @Test
    void testDefaultSize() {
        double x = 0.5, y = 0.5, z = 0.5;
        double noiseValue = perlinNoise.noise(x, y, z);

        // Validate that the noise value generated with default size is reasonable
        assertNotNull(noiseValue);
        assertTrue(noiseValue >= -1 && noiseValue <= 1);
    }

}
