package com.tictactoe;

import java.util.Random;

public class Board {

    private Figures[][] board;
    Random random = new Random();
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

    public void getPlayerFigure(int x, int y) {
        if (isPositionTaken(x, y)) {
            System.out.println("Field taken");
        } else {
            board[x][y] = Figures.X;
        }
    }

    public void getComFigure(int boardSize) {
        int x = random.nextInt(boardSize);
        int y = random.nextInt(boardSize);
        while (isPositionTaken(x,y)) {
            x = random.nextInt(boardSize);
            y = random.nextInt(boardSize);
        }

        board[x][y] = Figures.O;
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
}