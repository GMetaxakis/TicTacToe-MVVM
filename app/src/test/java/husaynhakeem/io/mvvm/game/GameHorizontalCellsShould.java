package husaynhakeem.io.mvvm.game;


import org.junit.Before;
import org.junit.Test;

import husaynhakeem.io.mvvm.model.Cell;
import husaynhakeem.io.mvvm.model.Game;
import husaynhakeem.io.mvvm.model.Player;

import static org.junit.Assert.assertEquals;

public class GameHorizontalCellsShould {

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
    public void returnTrueIfHasThreeSameHorizontalCellsAtRow1() throws Exception {
        Cell cell = new Cell(player);
        game.getCells()[0][0] = cell;
        game.getCells()[0][1] = cell;
        game.getCells()[0][2] = cell;
        boolean hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells();
        assertEquals(true, hasThreeSameHorizontalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameHorizontalCellsAtRow2() throws Exception {
        Cell cell = new Cell(player);
        game.getCells()[1][0] = cell;
        game.getCells()[1][1] = cell;
        game.getCells()[1][2] = cell;
        boolean hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells();
        assertEquals(true, hasThreeSameHorizontalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameHorizontalCellsAtRow3() throws Exception {
        Cell cell = new Cell(player);
        game.getCells()[2][0] = cell;
        game.getCells()[2][1] = cell;
        game.getCells()[2][2] = cell;
        boolean hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells();
        assertEquals(true, hasThreeSameHorizontalCells);
    }

    @Test
    public void returnFalseIfDoesNotHaveThreeSameHorizontalCells() throws Exception {
        Cell cell = new Cell(player);
        Cell anotherCell = new Cell(anotherPlayer);
        game.getCells()[0][0] = cell;
        game.getCells()[0][1] = cell;
        game.getCells()[0][2] = anotherCell;
        boolean hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells();
        assertEquals(false, hasThreeSameHorizontalCells);
    }
}
