package com.tictactoe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;

public class TicTacToeRunner {

    private final Scanner scanner = new Scanner(System.in);
    private Player p1;
    private Player p2;

    public void mainMenu() {
        System.out.println("Welcome in TicTacToe Game");
        makeValidInputForReadFile();
        setPlayerUsernameBeforeTheGame();
        do {
            play();
        } while (shouldPlayAnotherRound());
        saveScoreToAFile();
        System.out.println("Thanks for playing");
        scanner.close();
    }

    public void play() {
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
        System.out.println(p1.getUsername() + " 's score is " + p1.getScore());
        System.out.println(p2.getUsername() + " 's score is " + p2.getScore());
    }

    private void saveScoreToAFile() {
        Path path = Paths.get("score.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND))
        {
            writer.write(p1.getUsername() + "|" + p1.getScore() + "|" + p2.getScore() + "|" + p2.getUsername() + "\n");
        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }

    private void makeValidInputForReadFile() {
        String playerInputForReadData;
        System.out.println("Would you like to check the score from earlier games? (Yes or No)");
        while (true) {
            playerInputForReadData = scanner.nextLine();
            if (playerInputForReadData.equalsIgnoreCase("Yes")) {
                readScoreFromAFile();
                break;
            } else if (playerInputForReadData.equalsIgnoreCase("No")) {
                break;
            } else {
                System.out.println("Invalid input. Please type Yes or No.");
            }
        }
    }

    private void readScoreFromAFile() {
        Path file = Paths.get("score.txt");

        try (Stream<String> stream = Files.lines(file)) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }

    private void setPlayerUsernameBeforeTheGame() {
        System.out.println("Set username for p1");
        p1 = new Player(scanner.nextLine());
        System.out.println("Set username for p2");
        p2 = new Player(scanner.nextLine());
    }

    private boolean shouldPlayAnotherRound() {
        scanner.nextLine();
        System.out.println("Do you want to play another round? Type Yes or No");
        String playerChoiceForAnotherRound = scanner.nextLine();

        while (true) {
            if (playerChoiceForAnotherRound.equals("Yes")) {
                return true;
            } else if (playerChoiceForAnotherRound.equals("No")) {
                return false;
            } else {
                System.out.println(playerChoiceForAnotherRound);
                System.out.println("Please type proper text. (Yes or No)");
                playerChoiceForAnotherRound = scanner.nextLine();
            }
        }
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
                System.out.println(player.getUsername() + " made a move.");
                board.displayBoard();
                break;
            }
        }
    }

    private Figure switchStringToFigure(String p1UsernameSelection) {
        return switch (p1UsernameSelection) {
            case "X" -> Figure.X;
            case "O" -> Figure.O;
            default -> null;
        };
    }

    private void playAgainstPlayer(Board board, int boardSize) {

        letPlayerChooseFigure(board);

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

        letPlayerChooseFigure(board);

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

    private void letPlayerChooseFigure(Board board) {
        System.out.println("Set Figure for " + p1.getUsername() + " (X or O)");
        String p1FigureSelection = scanner.nextLine();
        p1.setPlayerChoiceSelect(switchStringToFigure(p1FigureSelection));

        if (p1.getPlayerChoiceSelect().equals(Figure.X)) {
            p2.setPlayerChoiceSelect(Figure.O);
        } else {
            p2.setPlayerChoiceSelect(Figure.X);
        }

        board.displayBoard();
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
        System.out.println("Select board size: 1 for 3x3 or 2 for 10x10");

        int size = makeAndValidateInput();
        return size == 1 ? 3 : 10;
    }

    private int makeAndValidateInput() {
        int size;
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
        return size;
    }

    private int makeOpponentSelection() {
        System.out.println("Do you want to play against Player or COM? Select 1 for Player or 2 for COM opponent.");
        return makeAndValidateInput();
    }
}
