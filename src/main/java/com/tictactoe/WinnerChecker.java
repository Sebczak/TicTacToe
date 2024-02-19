package com.tictactoe;

public class WinnerChecker {

    public boolean gameWonWithThreeFigures(Figure[][] board, Figure figure) {
        if (board.length == 3) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board.length; y++) {
                    if (board[x][y] == figure && y + 2 < board.length && board[x][y + 1] == figure && board[x][y + 2] == figure) {
                        return true;
                    } else if (board[x][y] == figure && x + 2 < board.length && board[x + 1][y] == figure && board[x + 2][y] == figure) {
                        return true;
                    } else if (board[x][y] == figure && x + 2 < board.length && y + 2 < board.length && board[x + 1][y + 1] == figure && board[x + 2][y + 2] == figure) {
                        return true;
                    } else if (board[x][y] == figure && x - 2 >= 0 && y + 2 < board.length && board[x - 1][y + 1] == figure && board[x - 2][y + 2] == figure) {
                        return true;
                    }
                }
            }
        } else {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board.length; y++) {
                    if (board[x][y] == figure && y + 4 < board.length && board[x][y + 1] == figure && board[x][y + 2] == figure && board[x][y + 3] == figure && board[x][y + 4] == figure) {
                        return true;
                    } else if (board[x][y] == figure && x + 4 < board.length && board[x + 1][y] == figure && board[x + 2][y] == figure && board[x + 3][y] == figure && board[x + 4][y] == figure) {
                        return true;
                    } else if (board[x][y] == figure && x + 4 < board.length && y + 2 < board.length && board[x + 1][y + 1] == figure && board[x + 2][y + 2] == figure && board[x + 3][y + 3] == figure && board[x + 4][y + 4] == figure) {
                        return true;
                    } else if (board[x][y] == figure && x - 4 >= 0 && y + 4 < board.length && board[x - 1][y + 1] == figure && board[x - 2][y + 2] == figure && board[x - 3][y + 3] == figure && board[x - 4][y + 4] == figure) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
