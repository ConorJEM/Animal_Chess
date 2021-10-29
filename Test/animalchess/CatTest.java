package animalchess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CatTest {

    private Player p0;
    private Player p1;
    private Game game;

    @Before
    public void setup() {
        p0 = new Player("Michael", 0);
        p1 = new Player("Ozgur", 1);
        game = new Game(p0, p1);
    }

    @Test
    public void testPromote() {
        Cat c = new Cat(p1, game.getSquare(1, 1));
        assertFalse(c.getIsPromoted());
        c.promote();
        assertTrue(c.getIsPromoted());
    }

    @Test
    public void testZeroMoves() {
        PromotablePiece c = new Cat(p0, game.getSquare(1, 2));
        ArrayList<Square> moves = c.getLegalMoves();

        assertEquals(0, moves.size());
    }
    @Test
    public void testMoves() {
        PromotablePiece c = new Cat(p1, game.getSquare(1, 4));
        ArrayList<Square> moves = c.getLegalMoves();
        assertEquals(3, moves.size());
        c.move(game.getSquare(0,3));
    }
    //Tests that creating a player with a playerNumber that isn't 1 or 0 correctly throws an error.
    @Test(expected = IllegalArgumentException.class)
    public void fullGame() {
        p0 = new Player("Michael", 0);
        p1 = new Player("Ozgur", 5);
    }
}