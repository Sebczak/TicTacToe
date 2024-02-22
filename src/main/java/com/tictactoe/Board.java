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

    public boolean setPlayerFigureInBoard(Player player, int x, int y) {
        if (isPositionTaken(x, y)) {
            return true;
        } else {
            board[x][y] = player.getPlayerChoiceSelect();
            return false;
        }
    }

    public void setComFigureInBoard(Player player, int boardSize) {
        int x;
        int y;

        do {
            x = randomValue.nextInt(boardSize);
            y = randomValue.nextInt(boardSize);
        } while (isPositionTaken(x, y));

        board[x][y] = player.getPlayerChoiceSelect();
    }

    public boolean gameFinished(Player p1, Player p2) {

        if (winnerChecker.gameWonWithThreeFigures(board, p1.getPlayerChoiceSelect())) {
            System.out.println(p1.getUsername() + " won");
            p1.incrementScore();
            return true;
        } else if (winnerChecker.gameWonWithThreeFigures(board,p2.getPlayerChoiceSelect())) {
            System.out.println(p2.getUsername() + " won");
            p2.incrementScore();
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