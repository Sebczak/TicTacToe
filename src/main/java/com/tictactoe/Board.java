package com.tictactoe;

import java.util.Random;

public class Board {

    private final Figures[][] board = new Figures[3][3];
    Random random = new Random();
    private final WinnerChecker winnerChecker = new WinnerChecker();

    public Board () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Figures.BLANK;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

    public void getPlayerFigure(int x, int y) {
            board[x][y] = Figures.X;
        }

    public void getComFigure() {
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        while (board[x][y] != Figures.BLANK) {
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
        }
        return false;
    }
}