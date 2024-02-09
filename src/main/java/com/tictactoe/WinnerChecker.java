package com.tictactoe;

public class WinnerChecker {

    public boolean gameWonHorizontally(Figures[][] board, Figures figure) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == figure && board[i][1] == figure && board[i][2] == figure) {
                return true;
            }
        }
        return false;
    }

    public boolean gameWonVertically(Figures[][] board, Figures figure) {
        for (int j = 0; j < board.length; j++) {
            if (board[0][j] == figure && board[1][j] == figure && board[2][j] == figure) {
                return true;
            }
        }
        return false;
    }

    public boolean gameWonDiagonally(Figures[][] board, Figures figure) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[0][0] == figure && board[1][1] == figure && board[2][2] == figure) {
                    return true;
                } else if (board[0][2] == figure && board[1][1] == figure && board[2][0] == figure) {
                    return true;
                }
            }
        }
        return false;
    }
}
