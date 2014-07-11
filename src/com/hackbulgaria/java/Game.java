package com.hackbulgaria.java;


public class Game {
    private int[][] gameMatrix;

    public Game() {
        gameMatrix = new int[][] { { 1024, 1024, 8, 8 }, { 1024, 4, 4, 8 }, { 8, 8, 4, 4 }, { 8, 8, 4, 4 } };
    }

    private int[][] reverseMatrix() {
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = gameMatrix[i][4 - j - 1];
            }
        }
        return temp;
    }

    private int[][] transposeMatrix() {
        int[][] temp = new int[4][4];
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                temp[i][j] = gameMatrix[j][i];
            }
        }
        return temp;
    }
    private void moveRow(int rowIndex) {
        int lastChanged = -1;
        for (int j = 1; j < 4; j++) {
            int current = j;
            for (int k = current - 1; k > lastChanged && gameMatrix[rowIndex][current] != 0; k--) {
                if (gameMatrix[rowIndex][k] == 0) {
                    gameMatrix[rowIndex][k] = gameMatrix[rowIndex][current];
                    gameMatrix[rowIndex][current] = 0;
                    current--;
                }
                if (gameMatrix[rowIndex][k] == gameMatrix[rowIndex][current] && k < current) {
                    gameMatrix[rowIndex][k] *= 2;
                    gameMatrix[rowIndex][current] = 0;
                    current--;
                    lastChanged = k;
                }
            }
        }
    }

    public void moveLeft() {
        for (int i = 0; i < 4; i++)
            moveRow(i);
    }

    public void moveRight() {
        gameMatrix = reverseMatrix();
        moveLeft();
        gameMatrix = reverseMatrix();
    }

    public void moveUp() {
        gameMatrix = transposeMatrix();
        moveLeft();
        gameMatrix = transposeMatrix();
    }

    public void moveDown() {
        gameMatrix = transposeMatrix();
        gameMatrix = reverseMatrix();
        moveLeft();
        gameMatrix = reverseMatrix();
        gameMatrix = transposeMatrix();
    }

    public boolean isFull() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                if (isCellEmpty(i, j))
                    return false;
        }
        return true;
    }

    public boolean isWon() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                if (gameMatrix[i][j] == 2048)
                    return true;
        }
        return false;
    }

    public boolean isCellEmpty(int i, int j) {
        return gameMatrix[i][j] == 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameMatrix[i][j] < 10)
                    string.append("    " + gameMatrix[i][j]);
                else
                    if (gameMatrix[i][j] < 100)
                    string.append("   " + gameMatrix[i][j]);
                    else
                        if (gameMatrix[i][j] < 1000)
                    string.append("  " + gameMatrix[i][j]);
                else if (gameMatrix[i][j] < 10000)
                    string.append(" " + gameMatrix[i][j]);

            }
            string.append("\n");
        }
        return string.toString();
    }
}
