package com.tictactoe;

import java.util.Scanner;

public class TicTacToeRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final Player p1 = new Player();
    private final Player p2 = new Player();

    public void play() {
        System.out.println("Welcome to TicTacToe Game");

        int boardSize = makeBoardSize();
        Board board = new Board(boardSize);

        int opponentSelection = makeOpponentSelection();

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
        while (true) {
            System.out.println(player.getUsername() + " please enter row (1-" + boardSize + ")");
            int row = makeValidUserInput(boardSize);

            System.out.println(player.getUsername() + " please enter col (1-" + boardSize + ")");
            int col = makeValidUserInput(boardSize);

            if (board.setPlayerFigureInBoard(player, row, col)) {
                System.out.println("Invalid move. Select other field");
            } else {
                board.displayBoard();
                System.out.println(player.getUsername() + " made a move.");
                break;
            }
        }
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

        while (!board.gameFinished(p1, p2)) {
            if (p1.getPlayerChoiceSelect().equals(Figure.X)) {
                playerMove(p1, board, boardSize);

                if (board.gameFinished(p1, p2)) {
                    board.displayBoard();
                    break;
                }

                playerMove(p2, board, boardSize);
            } else {
                playerMove(p2, board, boardSize);

                if (board.gameFinished(p1, p2)) {
                    board.displayBoard();
                    break;
                }

                playerMove(p1, board, boardSize);
            }
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

        while (!board.gameFinished(p1, p2)) {
            if (p1.getPlayerChoiceSelect().equals(Figure.X)) {
                playerMove(p1, board, boardSize);

                if (board.gameFinished(p1, p2)) {
                    board.displayBoard();
                    break;
                }

                board.setComFigureInBoard(p2, boardSize);
                System.out.println("Com made a move");
                board.displayBoard();
            } else {
                board.setComFigureInBoard(p2, boardSize);
                System.out.println("Com made a move");
                board.displayBoard();

                if (board.gameFinished(p1, p2)) {
                    board.displayBoard();
                    break;
                }

                playerMove(p1, board, boardSize);
            }
        }
    }

    private int makeValidUserInput(int boardSize) {
        int value;
        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    value = scanner.nextInt() - 1;
                    if (value >= 0 && value < boardSize) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Enter a proper number (1-" + boardSize + ")");
                    }
                } else {
                    throw new IllegalArgumentException("Type a number");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        return value;
    }

    private int makeBoardSize() {
        int size;
        System.out.println("Select board size: 1 for 3x3 or 2 for 10x10");

        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    size = scanner.nextInt();
                    if (size == 1 || size == 2) {
                        scanner.nextLine();
                        break;
                    } else {
                        throw new IllegalArgumentException("Invalid board size selection. Choose 1 or 2.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }
        return size == 1 ? 3 : 10;
    }

    private int makeOpponentSelection() {
        int selection;
        System.out.println("Do you want to play against Player or COM? Select 1 for Player or 2 for COM opponent.");
        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    selection = scanner.nextInt();
                    if (selection == 1 || selection == 2) {
                        scanner.nextLine();
                        break;
                    } else {
                        throw new IllegalArgumentException("Invalid board size selection. Choose 1 or 2.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }
        return selection;
    }
}
