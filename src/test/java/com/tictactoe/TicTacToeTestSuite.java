package com.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTestSuite {
    @Nested
    class PlayerWinTests {

        @Test
        @DisplayName("Player wins horizontally")
        void testPLayerWinsHorizontally() {
            //Given
            Board board = new Board();

            //When
            board.getPlayerFigure(0, 0);
            board.getPlayerFigure(0, 1);
            board.getPlayerFigure(0, 2);

            //Then
            assertTrue(board.gameFinished());
        }

        @Test
        @DisplayName("Player wins vertically")
        void testPLayerWinsVertically() {
            //Given
            Board board = new Board();

            //When
            board.getPlayerFigure(0, 0);
            board.getPlayerFigure(1, 0);
            board.getPlayerFigure(2, 0);

            //Then
            assertTrue(board.gameFinished());
        }

        @Test
        @DisplayName("Player wins diagonally")
        void testPLayerWinsDiagonally() {
            //Given
            Board board = new Board();

            //When
            board.getPlayerFigure(0, 0);
            board.getPlayerFigure(1, 1);
            board.getPlayerFigure(2, 2);

            //Then
            assertTrue(board.gameFinished());
        }

        @Test
        @DisplayName("Player wins diagonally reversed")
        void testPLayerWinsDiagonallyReversed() {
            //Given
            Board board = new Board();

            //When
            board.getPlayerFigure(2, 0);
            board.getPlayerFigure(1, 1);
            board.getPlayerFigure(0, 2);

            //Then
            assertTrue(board.gameFinished());
        }
    }

    @Nested
    class ComWinTests {

        @Test
        @DisplayName("Com wins horizontally")
        void testComputerWinningHorizontally() {
            // Given
            Random mockRandom = Mockito.mock(Random.class);
            Board board = new Board(mockRandom);

            //When

            //Then
            assertTrue(board.gameFinished());
        }

        @Test
        @DisplayName("Com wins vertically")
        void testComputerWinningVertically() {
            // Given
            Board board = new Board();

        }

        @Test
        @DisplayName("Com wins diagonally")
        void testComputerWinningDiagonally() {
            // Given
            Board board = new Board();

        }

        @Test
        @DisplayName("Com wins diagonally reversed")
        void testComputerWinningDiagonallyReversed() {
            // Given
            Board board = new Board();

        }
    }

    @Nested
    class TestTie {

        @Test
        @DisplayName("TIE")
        void testTie() {
            // Given
            Random mockRandom = Mockito.mock(Random.class);
            Board board = new Board(mockRandom);

            //When

            //Then
            assertTrue(board.gameFinished());
        }
    }
}
