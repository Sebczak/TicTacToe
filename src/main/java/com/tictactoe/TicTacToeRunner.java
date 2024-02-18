package com.tictactoe;

import java.util.Scanner;

public class TicTacToeRunner {

    private final Scanner s = new Scanner(System.in);

    public void play() {
        System.out.println("Welcome to TicTacToe Game");
        System.out.println("Enter boardSize");
        int boardSize = s.nextInt();
        Board b = new Board(boardSize);
        b.displayBoard();
        int row;
        int col;

        while (!b.gameFinished()) {

            System.out.println("Enter row (1-" + boardSize + ")");
            row = validateValue(s, boardSize);

            System.out.println("Enter col (1-" + boardSize + ")");
            col = validateValue(s, boardSize);

            b.setPlayerFigureInBoard(row, col);
            if (b.gameFinished()) {
                b.displayBoard();
                break;
            }

            System.out.println("Player made a move");
            b.setComFigureInBoard(boardSize);
            System.out.println("Com made a move");
            b.displayBoard();
        }

        s.close();
    }

    private int validateValue(Scanner s, int boardSize) {
        int value;
        while (true) {
            try {
                if (s.hasNextInt()) {
                    value = s.nextInt() - 1;
                    if (value < 0 || value >= boardSize) {
                        throw new IllegalArgumentException("Enter proper number (1-" + boardSize + ")");
                    } else {
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("Type a number");
                }
            } catch (IllegalArgumentException e) {
                s.next();
            }
        }
        return value;
    }
}
