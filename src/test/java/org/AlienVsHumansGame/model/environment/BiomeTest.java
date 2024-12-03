package org.AlienVsHumansGame.model.environment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiomeTest {
    private Biome biome;

    @BeforeEach
    void setUp(){
        biome = new Biome("Forest", "\033[48;5;34m");
    }

    @Test
    public void testBiomeConstructor(){
        System.out.println("Testing Constructor");
        assertEquals("Forest", biome.getName(), "Name should be forest");
        assertEquals("\033[48;5;34m",biome.getColor(), "color should be \033[48;5;34m");
        System.out.println("Successfull");
        System.out.println();
    }

    @Test
    public void testSetName(){
        System.out.println("Testing setting name");
        biome.setName("Mountain");
        assertEquals("Mountain", biome.getName());
        System.out.println("Successfull");
        System.out.println();
    }

    @Test
    public void testSetColor(){
        System.out.println("Test setting color");
        biome.setColor("\033[48;5;214m");
        assertEquals("\033[48;5;214m", biome.getColor(), "Color should be \033[48;5;214m");
        System.out.println("Successfull");
        System.out.println();
    }

    @Test
    public void testSetNameToNull() {
        System.out.println("Testing setting name to null");
        biome.setName(null);
        assertNull(biome.getName(), "Name should be null after setting it to null");
        System.out.println("Successful");
        System.out.println();
    }

    @Test
    public void testSetColorToNull() {
        System.out.println("Testing setting color to null");
        biome.setColor(null);
        assertNull(biome.getColor(), "Color should be null after setting it to null");
        System.out.println("Successful");
        System.out.println();
    }

}