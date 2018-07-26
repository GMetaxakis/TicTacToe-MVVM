package husaynhakeem.io.mvvm.game;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import husaynhakeem.io.mvvm.model.Cell;
import husaynhakeem.io.mvvm.model.Game;
import husaynhakeem.io.mvvm.model.Player;

public class GameDiagonalCellsShould {

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
    public void returnTrueIfHasThreeSameDiagonalCellsFromLeft() throws Exception {
        Cell cell = new Cell(player);
        game.getCells()[0][0] = cell;
        game.getCells()[1][1] = cell;
        game.getCells()[2][2] = cell;
        boolean hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells();
        Assert.assertEquals(true, hasThreeSameDiagonalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameDiagonalCellsFromRight() throws Exception {
        Cell cell = new Cell(player);
        game.getCells()[0][2] = cell;
        game.getCells()[1][1] = cell;
        game.getCells()[2][0] = cell;
        boolean hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells();
        Assert.assertEquals(true, hasThreeSameDiagonalCells);
    }

    @Test
    public void returnFalseIfDoesNotHaveThreeSameDiagonalCells() throws Exception {
        Cell cell = new Cell(player);
        Cell anotherCell = new Cell(anotherPlayer);
        game.getCells()[0][2] = cell;
        game.getCells()[1][1] = cell;
        game.getCells()[2][0] = anotherCell;
        boolean hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells();
        Assert.assertEquals(false, hasThreeSameDiagonalCells);
    }
}
