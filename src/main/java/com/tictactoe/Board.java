package com.tictactoe;

import java.util.Random;

public class Board {

    private final Figures[][] board;
    private Random randomValue = new Random();
    private int positionX;
    private int positionY;

    private final WinnerChecker winnerChecker = new WinnerChecker();

    public Board (int boardSize) {
        this.board = new Figures[boardSize][boardSize];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Figures.BLANK;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

    public void setPlayerFigureInBoard(int x, int y) {
        if (isPositionTaken(x, y)) {
            System.out.println("Field taken");
        } else {
            board[x][y] = Figures.X;
        }
    }

    public void setComFigureInBoard(int boardSize) {
        setPositionX(randomValue.nextInt(boardSize));
        setPositionY(randomValue.nextInt(boardSize));

        do {
            setPositionX(randomValue.nextInt(boardSize));
            setPositionY(randomValue.nextInt(boardSize));
        } while (isPositionTaken(positionX, positionY));

        board[positionX][positionY] = Figures.O;
    }

    public boolean gameFinished() {

        if (winnerChecker.gameWonWithThreeFigures(board, Figures.X)) {
            System.out.println("Player won");
            return true;
        } else if (winnerChecker.gameWonWithThreeFigures(board, Figures.O)) {
            System.out.println("COM won");
            return true;
        } else if (TieChecker.tieCheck(board)) {
            System.out.println("TIE");
            return true;
        }
        return false;
    }

    public boolean isPositionTaken(int x, int y) {
        return board[x][y] != Figures.BLANK;
    }

    public void setRandom(int random) {
        this.randomValue = new Random(random);
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}