package org.AlienVsHumansGame;

import org.AlienVsHumansGame.model.environment.GameEnvironment;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameEnvironment gameEnvironment= new GameEnvironment(50,50);

        gameEnvironment.printMap();


    }
}