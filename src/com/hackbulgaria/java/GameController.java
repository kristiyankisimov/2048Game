package com.hackbulgaria.java;

import java.io.IOException;
import java.util.Stack;


public class GameController {
    private Game game;
    
    private Stack<int[][]> undo;
    
    private Stack<int[][]> redo;
    
    public GameController() {
        undo = new Stack<int[][]>();
        redo = new Stack<int[][]>();
        game = new Game();
        undo.push(game.getGameMatrix());
        System.out.println(game.toString());
    }

    public void undoMove() {
        System.out.println(undo.size());
        if (undo.isEmpty()) {
            System.out.println("You didn't move yet!");
        }
        else{
            redo.push(undo.pop());
            game.setGameMatrix(undo.peek());
            System.out.println(game.toString());

        }
    }

    public void redoMove(){
        if(redo.isEmpty()){
            System.out.println("You can't undo");
        }
        else{
            undo.push(redo.pop());
            game.setGameMatrix(undo.peek());
            System.out.println(game.toString());
        }
        
    }
    
    public void moveLeft(){
        game.moveLeft();
        game.generateNumber();
        undo.push(game.cloneMatrix());
        System.out.println(game.toString());
    }
    
    public void moveRight(){
        game.moveRight();
        game.generateNumber();
        undo.push(game.cloneMatrix());
        System.out.println(game.toString());
    }
    
    public void moveUp(){
        game.moveUp();
        game.generateNumber();
        undo.push(game.cloneMatrix());
        System.out.println(game.toString());
    }

    public void moveDown() {
        game.moveDown();
        game.generateNumber();
        undo.push(game.cloneMatrix());
        System.out.println(game.toString());
    }

    public void save() {
        //
    }

    public void load() throws IOException {
        //
    }
}
