package com.hackbulgaria.java;

import jline.Terminal;

public class GamePlay {
    private Terminal terminal;

    private GameController controller;

    public GamePlay() {
        terminal = Terminal.setupTerminal();
        controller = new GameController();
    }

    public void play() {
    }

}
