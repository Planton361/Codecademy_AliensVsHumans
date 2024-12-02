package org.AlienVsHumansGame.model.environment;

public class Tile {

    private int posX;
    private int poxY;
    private Biome biome;

    public Tile(int posX, int posY, Biome biome) {
        this.posX = posX;
        this.poxY = posY;
        this.biome = biome;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPoxY() {
        return poxY;
    }

    public void setPoxY(int poxY) {
        this.poxY = poxY;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    @Override
    public String toString() {
        // Customize the string output for the tile
        return biome.getColor() + " " + biome.getName().charAt(0) + " \033[0m";
    }
}
