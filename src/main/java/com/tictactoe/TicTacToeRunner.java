package com.tictactoe;

import java.util.Scanner;

public class TicTacToeRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final Player p1 = new Player();
    private final Player p2 = new Player();

    public void play() {
        System.out.println("Welcome to TicTacToe Game");

        System.out.println("Select board. Size 3 or Size 10?");
        int boardSize = scanner.nextInt();
        Board board = new Board(boardSize);

        System.out.println("Do you want to play against Player or COM? Select 1 for Player or 2 for COM opponent.");
        int opponentSelection = scanner.nextInt();
        scanner.nextLine();

        if (opponentSelection == 1) {
            playAgainstPlayer(board, boardSize);
        } else if (opponentSelection == 2) {
            playAgainstCom(board, boardSize);
        } else {
            System.out.println("Invalid input");
        }

        scanner.close();
    }

    private void playerMove(Player player, Board board, int boardSize) {
        System.out.println(player.getUsername() + " please enter row (1-" + boardSize + ")");
        int row = makeValidUserInput(boardSize);

        System.out.println(player.getUsername() + " please enter col (1-" + boardSize + ")");
        int col = makeValidUserInput(boardSize);

        board.setPlayerFigureInBoard(player, row, col);
        board.displayBoard();
        System.out.println(player.getUsername() + " made a move.");
    }

    private Figure switchStringToFigure(String p1UsernameSelection) {
        return switch (p1UsernameSelection) {
            case "X" -> Figure.X;
            case "O" -> Figure.O;
            default -> null;
        };
    }

    private void playAgainstPlayer(Board board, int boardSize) {
        System.out.println("Set username for p1");
        String p1UsernameSelection = scanner.nextLine();
        p1.setUsername(p1UsernameSelection);

        System.out.println("Set Figure for p1 X or O");
        String p1FigureSelection = scanner.nextLine();
        p1.setPlayerChoiceSelect(switchStringToFigure(p1FigureSelection));

        System.out.println("Set username for p2");
        String p2UsernameSelection = scanner.nextLine();
        p2.setUsername(p2UsernameSelection);

        if (p1.getPlayerChoiceSelect().equals(Figure.X)) {
            p2.setPlayerChoiceSelect(Figure.O);
        } else {
            p2.setPlayerChoiceSelect(Figure.X);
        }

        board.displayBoard();

        while (!board.gameFinished()) {

            playerMove(p1,board,boardSize);

            if (board.gameFinished()) {
                board.displayBoard();
                break;
            }

            playerMove(p2,board,boardSize);
        }
    }

    private void playAgainstCom(Board board, int boardSize) {

        System.out.println("Set username for p1");
        String p1UsernameSelection = scanner.nextLine();
        p1.setUsername(p1UsernameSelection);

        System.out.println("Set Figure for p1 X or O");
        String p1FigureSelection = scanner.nextLine();
        p1.setPlayerChoiceSelect(switchStringToFigure(p1FigureSelection));

        p2.setUsername("COM");

        if (p1.getPlayerChoiceSelect().equals(Figure.X)) {
            p2.setPlayerChoiceSelect(Figure.O);
        } else {
            p2.setPlayerChoiceSelect(Figure.X);
        }

        board.displayBoard();

        while (!board.gameFinished()) {
            playerMove(p1, board, boardSize);

            if (board.gameFinished()) {
                board.displayBoard();
                break;
            }

            board.setComFigureInBoard(boardSize);
            System.out.println("Com made a move");
            board.displayBoard();
        }
    }

    private int makeValidUserInput(int boardSize) {
        int value;
        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    value = scanner.nextInt() - 1;
                    if (value < 0 || value >= boardSize) {
                        throw new IllegalArgumentException("Enter proper number (1-" + boardSize + ")");
                    } else {
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("Type a number");
                }
            } catch (IllegalArgumentException e) {
                scanner.next();
            }
        }
        return value;
    }
}
