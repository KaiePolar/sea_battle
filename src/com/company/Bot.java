package com.company;

public class Bot {

    private String botName;
    private Map map;
    private Game game;

    public Bot(String botName, Map map, Game game) {
        this.botName = botName;
        this.map = map;
        this.game = game;
    }

    public void makeShot() {
        if (!isGameFinished()) {
            System.out.println(botName + " is making shot...");
            map.makeShot((int) (Math.random() * 10), (int) (Math.random() * 10), this);
            System.out.println();
        } else finishGame();
    }

    public boolean isGameFinished() {
        return map.isGameFinished();
    }

    public void finishGame() {
        game.endGame(botName);
    }

}