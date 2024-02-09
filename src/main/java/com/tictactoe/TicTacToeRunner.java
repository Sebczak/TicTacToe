package com.tictactoe;

import java.util.Scanner;

public class TicTacToeRunner {

    public void play() {
        Board b = new Board();
        b.displayBoard();
        while (!b.gameFinished()) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter row 1-3");
            int row = s.nextInt() - 1;
            s.nextLine();
            System.out.println("Enter col 1-3");
            int col = s.nextInt() - 1;
            s.nextLine();
            b.getPlayerFigure(row, col);
            System.out.println("Player made a move");
            b.getComFigure();
            System.out.println("Com made a move");
            b.displayBoard();
        }
    }
}
