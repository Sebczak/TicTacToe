package com.tictactoe;

public class WinnerChecker {

    public boolean gameWonWithThreeFigures(Figures[][] board, Figures figure) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == figure && j + 2 < board.length && board[i][j+1] == figure && board[i][j+2] == figure) {
                    return true;
                } else if (board[i][j] == figure && i + 2 < board.length && board[i+1][j] == figure && board[i+2][j] == figure) {
                    return true;
                } else if (board[i][j] == figure && i + 2 < board.length && j + 2 < board.length && board[i+1][j+1] == figure && board[i+2][j+2] == figure) {
                    return true;
                } else if (board[i][j] == figure && i - 2 >= 0 && j + 2 < board.length && board[i-1][j+1] == figure && board[i-2][j+2] == figure) {
                    return true;
                }
            }
        }
        return false;
    }
}
