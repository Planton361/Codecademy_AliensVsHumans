package org.AlienVsHumansGame.model.environment;

public class GameEnvironment {
    private TileMap tileMap;

    public GameEnvironment(int rows, int cols){
        tileMap = new TileMap(rows,cols);
        tileMap.generateMap();
    }

    public void printMap() {
        for (int x = 0; x <tileMap.getRows(); x++) {
            for (int y = 0; y < tileMap.getCols(); y++) {
                System.out.print(tileMap.getTile(x,y).toString());
            }
            System.out.println();
        }
    }


}
