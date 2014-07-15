package com.hackbulgaria.java;

public class Main {

    public static void main(String[] args) {
        System.out.println("Constructor");
        GameController controller = new GameController();
        System.out.println("Move Left 1");
        controller.moveLeft();
        System.out.println("Move Left 2");
        controller.moveLeft();
        System.out.println("Undo");
        controller.undoMove();
        controller.redoMove();
        controller.redoMove();

    }

}
