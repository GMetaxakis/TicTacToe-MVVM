package husaynhakeem.io.mvvm.game;


import org.junit.Before;
import org.junit.Test;

import husaynhakeem.io.mvvm.model.Cell;
import husaynhakeem.io.mvvm.model.Game;
import husaynhakeem.io.mvvm.model.Player;

import static org.junit.Assert.assertEquals;

public class GameVerticalCellsShould {

    private Game game;
    private Player player;
    private Player anotherPlayer;

    @Before
    public void setUp() throws Exception {
        game = new Game("Husayn", "Yasin");
        player = game.getPlayer1();
        anotherPlayer = game.getPlayer2();
    }

    @Test
    public void returnTrueIfHasThreeSameVerticalCellsAtColumn1() throws Exception {
        Cell cell = new Cell(player);
        game.getCells()[0][0] = cell;
        game.getCells()[1][0] = cell;
        game.getCells()[2][0] = cell;
        boolean hasThreeSameVerticalCells = game.hasThreeSameVerticalCells();
        assertEquals(true, hasThreeSameVerticalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameVerticalCellsAtColumn2() throws Exception {
        Cell cell = new Cell(player);
        game.getCells()[0][1] = cell;
        game.getCells()[1][1] = cell;
        game.getCells()[2][1] = cell;
        boolean hasThreeSameVerticalCells = game.hasThreeSameVerticalCells();
        assertEquals(true, hasThreeSameVerticalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameVerticalCellsAtColumn3() throws Exception {
        Cell cell = new Cell(player);
        game.getCells()[0][2] = cell;
        game.getCells()[1][2] = cell;
        game.getCells()[2][2] = cell;
        boolean hasThreeSameVerticalCells = game.hasThreeSameVerticalCells();
        assertEquals(true, hasThreeSameVerticalCells);
    }

    @Test
    public void returnFalseIfDoesNotHaveThreeSameVerticalCells() throws Exception {
        Cell cell = new Cell(player);
        Cell anotherCell = new Cell(anotherPlayer);
        game.getCells()[0][0] = cell;
        game.getCells()[1][0] = cell;
        game.getCells()[2][0] = anotherCell;
        boolean hasThreeSameVerticalCells = game.hasThreeSameVerticalCells();
        assertEquals(false, hasThreeSameVerticalCells);
    }
}
