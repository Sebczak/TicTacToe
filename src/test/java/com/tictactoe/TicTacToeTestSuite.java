package com.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTestSuite {

    private Player p1 = new Player();
    private Player p2 = new Player();
    @Nested
    class PlayerWinTests {

        @Test
        @DisplayName("Player wins horizontally")
        void testPLayerWinsHorizontally() {
            //Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,0, 0);
            board.setPlayerFigureInBoard(p1,0, 1);
            board.setPlayerFigureInBoard(p1,0, 2);

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }

        @Test
        @DisplayName("Player wins vertically")
        void testPLayerWinsVertically() {
            //Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,0, 0);
            board.setPlayerFigureInBoard(p1,1, 0);
            board.setPlayerFigureInBoard(p1,2, 0);

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }

        @Test
        @DisplayName("Player wins diagonally")
        void testPLayerWinsDiagonally() {
            //Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,0, 0);
            board.setPlayerFigureInBoard(p1,1, 1);
            board.setPlayerFigureInBoard(p1,2, 2);

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }

        @Test
        @DisplayName("Player wins diagonally reversed")
        void testPLayerWinsDiagonallyReversed() {
            //Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,2, 0);
            board.setPlayerFigureInBoard(p1,1, 1);
            board.setPlayerFigureInBoard(p1,0, 2);

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }
    }

    @Nested
    class ComWinTests {

        @Test
        @DisplayName("Com wins horizontally")
        void testComputerWinningHorizontally() {
            // Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,1,0);
            board.setPlayerFigureInBoard(p1,1,1);
            board.setPlayerFigureInBoard(p1,2,0);
            board.setPlayerFigureInBoard(p1,2,1);
            board.setRandom(4);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);

            board.displayBoard();

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }

        @Test
        @DisplayName("Com wins vertically")
        void testComputerWinningVertically() {
            // Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,0,1);
            board.setPlayerFigureInBoard(p1,0,2);
            board.setPlayerFigureInBoard(p1,1,1);
            board.setPlayerFigureInBoard(p1,1,2);
            board.setRandom(4);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);

            board.displayBoard();

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }

        @Test
        @DisplayName("Com wins diagonally")
        void testComputerWinningDiagonally() {
            // Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,0,0);
            board.setPlayerFigureInBoard(p1,0,1);
            board.setPlayerFigureInBoard(p1,1,0);
            board.setPlayerFigureInBoard(p1,1,2);
            board.setPlayerFigureInBoard(p1,2,1);
            board.setPlayerFigureInBoard(p1,2,2);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.displayBoard();

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }

        @Test
        @DisplayName("Com wins diagonally reversed")
        void testComputerWinningDiagonallyReversed() {
            // Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,0,1);
            board.setPlayerFigureInBoard(p1,0,2);
            board.setPlayerFigureInBoard(p1,1,0);
            board.setPlayerFigureInBoard(p1,1,2);
            board.setPlayerFigureInBoard(p1,2,0);
            board.setPlayerFigureInBoard(p1,2,1);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.displayBoard();

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }
    }

    @Nested
    class TestTie {

        @Test
        @DisplayName("TIE")
        void testTie() {
            // Given
            Board board = new Board(3);

            //When
            p1.setPlayerChoiceSelect(Figure.X);
            p2.setPlayerChoiceSelect(Figure.O);
            board.setPlayerFigureInBoard(p1,0,0);
            board.setPlayerFigureInBoard(p1,0,2);
            board.setPlayerFigureInBoard(p1,1,1);
            board.setPlayerFigureInBoard(p1,2,1);
            board.setPlayerFigureInBoard(p1,1,0);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2,3);
            board.setComFigureInBoard(p2, 3);
            board.displayBoard();

            //Then
            assertTrue(board.gameFinished(p1, p2));
        }
    }
}
