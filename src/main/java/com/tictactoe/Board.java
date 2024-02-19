package com.tictactoe;

import java.util.Random;

public class Board {

    private final Figure[][] board;
    private Random randomValue = new Random();

    private final WinnerChecker winnerChecker = new WinnerChecker();

    public Board (int boardSize) {
        this.board = new Figure[boardSize][boardSize];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                board[x][y] = Figure.BLANK;
            }
        }
    }

    public void displayBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                System.out.print("|" + board[x][y]);
            }
            System.out.println("|");
        }
    }

    public void setPlayerFigureInBoard(Player player, int x, int y) {
        if (isPositionTaken(x, y)) {
            System.out.println("Field taken");
        } else {
            board[x][y] = player.getPlayerChoiceSelect();
        }
    }

    public void setComFigureInBoard(int boardSize) {
        int x;
        int y;

        do {
            x = randomValue.nextInt(boardSize);
            y = randomValue.nextInt(boardSize);
        } while (isPositionTaken(x, y));

        board[x][y] = Figure.O;
    }

    public boolean gameFinished() {

        if (winnerChecker.gameWonWithThreeFigures(board, Figure.X)) {
            System.out.println("Player won");
            return true;
        } else if (winnerChecker.gameWonWithThreeFigures(board, Figure.O)) {
            System.out.println("COM won");
            return true;
        } else if (TieChecker.tieCheck(board)) {
            System.out.println("TIE");
            return true;
        }
        return false;
    }

    public boolean isPositionTaken(int x, int y) {
        return board[x][y] != Figure.BLANK;
    }

    public void setRandom(int random) {
        this.randomValue = new Random(random);
    }
}