package com.tictactoe;

import java.util.Random;

public class Board {

    private final Figures[][] board = new Figures[3][3];
    Random random = new Random();
    private final WinnerChecker winnerChecker = new WinnerChecker();

    public Board () {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Figures.BLANK;
            }
        }
    }

    public Board (Random random) {
        this.random = random;

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

    public void getComFigure() {
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        while (isPositionTaken(x,y)) {
            x = random.nextInt(3);
            y = random.nextInt(3);
        }

        board[x][y] = Figures.O;
    }

    public boolean gameFinished() {

        if (winnerChecker.gameWonHorizontally(board, Figures.X)) {
            System.out.println("Player won");
            return true;
        } else if (winnerChecker.gameWonHorizontally(board, Figures.O)) {
            System.out.println("COM won");
            return true;
        } else if (winnerChecker.gameWonVertically(board, Figures.X)) {
            System.out.println("Player won ");
            return true;
        } else if (winnerChecker.gameWonVertically(board, Figures.O)) {
            System.out.println("COM won");
            return true;
        } else if (winnerChecker.gameWonDiagonally(board, Figures.X)) {
            System.out.println("Player won");
            return true;
        } else if (winnerChecker.gameWonDiagonally(board, Figures.O)) {
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