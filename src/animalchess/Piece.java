package animalchess;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * An abstract class that describes the functionality for any piece in the game of animal chess.
 * @author cm378
 */

public abstract class Piece {
    private Player owner;
    private Square square;

    /**
     * Piece constructor. Assigns the owner and the square for this piece. If the square passed already has a piece
     * on it; throw an error.
     * @param owner Player who owns this piece.
     * @param square Square this piece sits on.
     */
    public Piece(Player owner, Square square) {
        if (square.getPiece() != null) {
            throw new IllegalArgumentException("A Piece is already on this square!");
        } else {
            this.owner = owner;
            this.square = square;

            square.placePiece(this);
        }
    }

    /**
     * This method returns an array of all adjacent squares that don't have a friendly piece on them.
     *
     * This method is overridden in each specific piece class to satisfy the movement rules for that respective piece.
     * @return legalMoves, an array of squares.
     */
    public ArrayList<Square> getLegalMoves() {
        Game game = this.getSquare().getGame();
        ArrayList<Square> legalMoves = new ArrayList<Square>();
        //Add every square around the piece into the array
        int r = this.getSquare().getRow();
        int c = this.getSquare().getCol();

        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {

                if (!(i == r && j == c)) {
                    legalMoves.add(game.getSquare(i, j));
                }
            }
        }

        Iterator<Square> i = legalMoves.iterator();

        while (i.hasNext()) {
            Square s = i.next();
            Player owner = this.getOwner();
            if (s.getPiece() != null) {
                if (s.getPiece().getOwner() == owner) {
                    i.remove();
                }
            }
        }

        return legalMoves;
    }

    /**
     * Moves this piece to the passed square. If the passed square has an opponents piece,
     * it is captured.
     * @param toSquare The square this piece will move to.
     */
    public void move(Square toSquare) {
        if (toSquare.getPiece() == null) {
            this.getSquare().removePiece();
        } else {
            this.getSquare().removePiece();
            toSquare.getPiece().beCaptured(this.owner);
            toSquare.removePiece();
        }
        this.square = toSquare;
        toSquare.placePiece(this);
    }

    /**
     * Provides functionality for when a piece is moved onto an opponents piece. The opponents
     * piece is removed from the board and added to the capturers hand.
     * @param capturer The player who captured this piece.
     */
    public void beCaptured(Player capturer) {
        this.owner = capturer;
        this.square = null;
        capturer.getHand().add(this);

    }
    /**
     * Getter; returns the square this piece sits upon.
     * @return square
     */
    public Square getSquare() {
        return this.square;
    }

    /**
     * Getter; returns the owner of this piece.
     * @return  Player
     */
    public Player getOwner() {
        return this.owner;
    }

    /**
     * Setter; Sets the square value for a given piece.
     * Added so that square can be kept a private variable, but still allow changing a pieces 'square' when moving.
     * @param square The square this piece will be assigned to.
     */
    public void setSquare(Square square) {
        this.square = square;
    }

}
