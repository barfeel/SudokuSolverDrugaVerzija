package test;

import nl.elridge.sudoku.model.Game;
import org.junit.Test;


import static org.junit.Assert.*;

public class GameClassTests {

    @Test
    public void TestNewGame() {
        Game game = new Game();
        assertEquals(game.isHelp(), true);
        boolean[][] check = new boolean[9][9];
        assertEquals(9, check.length);
        assertEquals(9, check[0].length);
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[i].length; j++) {
                assertFalse(check[i][j]);
                //  check[i][j] = false;
            }
        }
    }

    @Test
    public void TestSetHelp() {
        Game game = new Game();
        game.setHelp(false);
        assertEquals(game.isHelp(), false);
    }

    @Test
    public void TestGetHelp() {
        Game game = new Game();
        game.setHelp(true);
        assertEquals(game.isHelp(), true);
    }

    @Test
    public void TestSetSelectedNumber() {
        Game game = new Game();
        game.setSelectedNumber(5);
        assertEquals(game.getSelectedNumber(), 5);
    }

    @Test
    public void TestCheckGame() {
        int[][] game = new int[9][9];
        int[][] solution = new int[9][9];
        boolean[][] check = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                game[i][j] = 0 * 9 + j * 1;
                solution[i][j] = 0 * 9 + j * 1;

            }
        }
        Game g = new Game();
        g.checkGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                check[i][j] = game[i][j] == solution[i][j];
                assertEquals(check[i][j], true);
            }
        }

    }

    @Test
    public void TestSetAndGetNumber() {
        Game game = new Game();
        game.setNumber(5, 5, 7);
        assertEquals(game.getNumber(5, 5), 7);

    }

    @Test
    public void TestIsCheckValid() {
        // False
        Game game = new Game();
        int[][] fields = {
                {8, 2, 7, 1, 5, 4, 3, 9, 6},
                {9, 6, 5, 3, 2, 7, 1, 4, 8},
                {3, 4, 1, 6, 8, 9, 7, 5, 2},
                {5, 9, 3, 4, 6, 8, 2, 7, 1},
                {4, 7, 2, 5, 1, 3, 6, 8, 9},
                {6, 1, 8, 9, 7, 2, 4, 3, 5},
                {7, 8, 6, 2, 3, 5, 9, 1, 4},
                {1, 5, 4, 7, 9, 6, 8, 2, 3},
                {2, 3, 9, 8, 4, 1, 5, 6, 7}
        };

        int x = 0;
        int y = 0;
        assertFalse(game.isCheckValid(x, y));

    }

    @Test
    public void TestIsCheckValid2() {
        // True
        Game game = new Game();
        int[][] fields = {
                {8, 2, 7, 1, 5, 4, 3, 9, 6},
                {8, 6, 5, 3, 2, 7, 1, 4, 8},
                {3, 4, 1, 6, 8, 9, 7, 5, 2},
                {5, 9, 3, 4, 6, 8, 2, 7, 1},
                {4, 7, 2, 5, 1, 3, 6, 8, 9},
                {6, 1, 8, 9, 7, 2, 4, 3, 5},
                {7, 8, 6, 2, 3, 5, 9, 1, 4},
                {1, 5, 4, 7, 9, 6, 8, 2, 3},
                {2, 3, 9, 8, 4, 1, 5, 6, 7}
        };
        int x = 0;
        int y = 0;
        assertTrue(game.isCheckValid(x, y));

    }

    @Test
    public void isSelectedNumberACandidateTrue() {
        Game game = new Game();
        game.setSelectedNumber(5);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (game.isSelectedNumberCandidate(x, y) && game.isCheckValid(x, y)) {
                    game.setNumber(x, y, game.getSelectedNumber());
                    assertTrue(game.isCheckValid(x, y));
                }
            }

        }

    }

    @Test
    public void isSelectedNumberACandidateFalse() {
        Game game = new Game();
        game.setSelectedNumber(15);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (game.isSelectedNumberCandidate(x, y) && game.isCheckValid(x, y)) {
                    game.setNumber(x, y, game.getSelectedNumber());
                    assertFalse(game.isCheckValid(x, y));
                }
            }

        }
    }


}
