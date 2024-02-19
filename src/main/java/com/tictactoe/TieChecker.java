package com.tictactoe;

public class TieChecker {

    public static boolean tieCheck(Figure[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == Figure.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}
