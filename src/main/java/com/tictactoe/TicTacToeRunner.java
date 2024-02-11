package com.tictactoe;

import java.util.Scanner;

public class TicTacToeRunner {

    private final Scanner s = new Scanner(System.in);

    public void play() {
        Board b = new Board();
        b.displayBoard();
        int row;
        int col;
        while (!b.gameFinished()) {

            System.out.println("Enter row (1-3)");
            row = validateValue(s);

            System.out.println("Enter col 1-3");
            col = validateValue(s);

            b.getPlayerFigure(row, col);
            if (b.gameFinished()) {
                b.displayBoard();
                break;
            }

            System.out.println("Player made a move");
            b.getComFigure();
            System.out.println("Com made a move");
            b.displayBoard();
        }
    }

    private int validateValue(Scanner s) {
        int value;
        while (true) {
            if (s.hasNextInt()) {
                value = s.nextInt() - 1;
                if (value < 0 || value >= 3) {
                    System.out.println("Enter proper number (1-3)");
                } else {
                    break;
                }
            } else {
                System.out.println("Type a number (1-3)");
                s.next();
            }
        }
        return value;
    }
}
