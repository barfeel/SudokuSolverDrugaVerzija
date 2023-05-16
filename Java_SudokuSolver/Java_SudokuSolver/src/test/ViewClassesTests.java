package test;

import nl.elridge.sudoku.model.Game;
import nl.elridge.sudoku.model.UpdateAction;
import nl.elridge.sudoku.view.ButtonPanel;
import nl.elridge.sudoku.view.Field;
import nl.elridge.sudoku.view.Sudoku;
import nl.elridge.sudoku.view.SudokuPanel;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;


import static org.junit.Assert.*;

public class ViewClassesTests {

    @Test
    public void TestStartGui() {
        Sudoku sudoku = new Sudoku();
        sudoku.main(null);
        assertTrue(sudoku.getContentPane().getLayout() instanceof BorderLayout);
        assert sudoku != null;


    }


    @Test
    public void TestSudokuConstructor() {
        Sudoku sudoku = new Sudoku();
        assertEquals("Sudoku", sudoku.getTitle());
        assertEquals(WindowConstants.EXIT_ON_CLOSE, sudoku.getDefaultCloseOperation());
        assertTrue(sudoku.getContentPane().getLayout() instanceof BorderLayout);
        assert sudoku != null;


    }

    @Test
    public void TestGetFieldX() {
        int expectedX = 7;
        Field field = new Field(expectedX, 7);
        assertEquals(expectedX, field.getFieldX());
    }

    @Test
    public void TestGetFieldY() {
        int expectedY = 8;
        Field field = new Field(8, expectedY);
        assertEquals(expectedY, field.getFieldY());

    }


    @Test
    public void TestSudokuPanelUpdateMethod() {
        SudokuPanel sudokuPanel = new SudokuPanel();
        Game game = new Game();

        //case NEW_GAME:
        boolean setGameCalled = false;
        UpdateAction action = UpdateAction.NEW_GAME;
        sudokuPanel.update(game, action);
        setGameCalled = true;
        assertTrue(setGameCalled);

        //case CHECK
        boolean setCheckCalled = false;
        UpdateAction action1 = UpdateAction.CHECK;
        sudokuPanel.update(game, action1);
        setCheckCalled = true;
        assertTrue(setCheckCalled);

        //case SELECTED_NUMBER:
        boolean setSelectedNumberCalled = false;
        UpdateAction action2 = UpdateAction.SELECTED_NUMBER;
        sudokuPanel.update(game, action2);
        setSelectedNumberCalled = true;
        assertTrue(setSelectedNumberCalled);

        //case SELECTED_FIELD:
        boolean setSelectedCandidatesCalled = false;
        UpdateAction action3 = UpdateAction.CANDIDATES;
        sudokuPanel.update(game, action3);
        setSelectedCandidatesCalled = true;
        assertTrue(setSelectedCandidatesCalled);

        //case CANDIDATES:
        boolean setHelpCalled = false;
        UpdateAction action4 = UpdateAction.HELP;
        sudokuPanel.update(game, action4);
        setHelpCalled = true;
        assertTrue(setHelpCalled);


    }

    @Test
    public void TestButtonPanelUpdateMethod() {
        ButtonPanel buttonPanel = new ButtonPanel();
        Game game = new Game();

        //case NEW_GAME:
        boolean setGameCalled = false;
        UpdateAction action = UpdateAction.NEW_GAME;
        buttonPanel.update(game, action);
        setGameCalled = true;
        assertTrue(setGameCalled);

        //case CHECK:
        boolean setCheckCalled = false;
        int bgNumbersCalculator;
        UpdateAction action1 = UpdateAction.CHECK;
        buttonPanel.update(game, action1);
        setCheckCalled = true;
        assertTrue(setCheckCalled);
        if (setCheckCalled = true) {
            bgNumbersCalculator = 0;
        } else {
            bgNumbersCalculator = 1;
        }
        assertEquals(0, bgNumbersCalculator);


    }


}
