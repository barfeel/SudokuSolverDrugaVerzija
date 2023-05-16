package test;


import nl.elridge.sudoku.controller.ButtonController;
import nl.elridge.sudoku.controller.SudokuController;
import nl.elridge.sudoku.model.Game;
import nl.elridge.sudoku.view.SudokuPanel;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ControllerClassesTests {

    @Test
    public void TestActionPerformed() {
        Game game = new Game();
        ButtonController buttonController = new ButtonController(game);
        // if Action Command = "New"
        ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "New");
        String CommandName = event.getActionCommand();
        buttonController.actionPerformed(event);
        Assert.assertEquals(CommandName, "New");

        // if Action command = "Check"
        ActionEvent event1 = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Check");
        String CommandName1 = event1.getActionCommand();
        buttonController.actionPerformed(event1);
        Assert.assertEquals(CommandName1, "Check");

        // if Action command = "Help on"

        ActionEvent event2 = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Help on");
        String CommandName2 = event2.getActionCommand();
        game.setHelp(true);
        Assert.assertEquals(CommandName2, "Help on");


    }


    @Test
    public void TestMouseClickedWithValidCoordinates() {
        Game game = new Game();
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        MouseEvent event = new MouseEvent(sudokuPanel, MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0,
                50, 50, 1, false);

        sudokuController.mouseClicked(event);

    }

    @Test
    public void TestMouseClickedWithInvalidCoordinates() {
        Game game = new Game();
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        MouseEvent event = new MouseEvent(sudokuPanel, MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0,
                500, 500, 1, false);

        sudokuController.mouseClicked(event);
    }

    @Test
    public void TestMouseEntered() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Game game = new Game();
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        MouseEvent event = new MouseEvent(sudokuPanel, MouseEvent.MOUSE_ENTERED,
                System.currentTimeMillis(), 0,
                10, 10, 0, false);

        Method method = SudokuController.class.getDeclaredMethod("mouseEntered", MouseEvent.class);

        method.invoke(sudokuController, event);

    }

    @Test
    public void TestMouseExited() {
        Game game = new Game();
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        JPanel panel = new JPanel();
        MouseEvent event = new MouseEvent(sudokuPanel, MouseEvent.MOUSE_EXITED,
                System.currentTimeMillis(), 0,
                10, 10, 0, false);
        sudokuController.mouseExited(event);

    }


}
