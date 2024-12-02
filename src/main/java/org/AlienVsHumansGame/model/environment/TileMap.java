package org.AlienVsHumansGame.model.environment;

import org.AlienVsHumansGame.model.Logic.PerlinNoise;

public class TileMap {
    private Tile[][] map;
    private int rows;
    private int cols;
    private PerlinNoise perlinNoise;
    private TileGenarator tileGenarator;

    public TileMap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        map = new Tile[rows][cols];
        this.tileGenarator = new TileGenarator();


    }

    public void generateMap() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = tileGenarator.generateTile(x, y);
            }
        }
    }

    public Tile[][] getTiles() {
        return map;
    }

    public void setTiles(Tile[][] tiles) {
        this.map = tiles;
    }

    public Tile getTile(int x, int y) {
        return map[x][y];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}