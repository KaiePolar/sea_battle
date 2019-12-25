package com.company;

public class Map {

    private char[][] map;
    private String mapTitle;
    private static final char one = '1';
    private int numberOfParts = 20;

    public Map(String mapTitle) {
        this.mapTitle = mapTitle;
    }

    public void init() {
        MapGenerator mapGenerator = new MapGenerator();
        map = mapGenerator.generateMap();
    }

    public void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map.length; k++) {
                System.out.print(map[i][k]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(mapTitle);
        System.out.println();
    }

    public void makeShot(int x, int y, Bot bot) {
        if (map[x][y] == one) {
            map[x][y] = 'x';
            --numberOfParts;
            System.out.println("Gotcha!");
            showMap();
            bot.makeShot();
        } else {
            System.out.println("...missed.");
        }
    }

    public boolean isGameFinished() {
        return numberOfParts == 0;
    }

}