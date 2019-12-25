package com.company;

public class Game {

    private Map map1 = new Map("Map 1");
    private Map map2 = new Map("Map 2");

    private Bot bot1 = new Bot("Bot 1", map2, this);
    private Bot bot2 = new Bot("Bot 2", map1, this);

    public void startGame() {
        map1.init();
        map2.init();
        map1.showMap();
        map2.showMap();
        System.out.println("Game started!");
        while (!bot1.isGameFinished() || !bot2.isGameFinished()) {
            bot1.makeShot();
            bot2.makeShot();
        }
    }

    public void endGame(String winner) {
        System.out.print("Winner is ".concat(winner));
        System.out.println();
        System.exit(666);
    }

}