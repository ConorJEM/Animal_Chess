package animalchess;

import java.util.ArrayList;

/**
 * Class that implements the specific movement rules for the Giraffe piece.
 */
public class Giraffe extends Piece {
    /**
     * Extends the constructor from the Piece class.
     * @param owner Player who owns this piece.
     * @param square Square this piece sits on.
     */
    public Giraffe(Player owner, Square square) {
        super(owner, square);

    }
    /**
     * Extends getLegalMoves from the piece class. Implements the rules for the Giraffe piece.
     * @return moves, an array of Square objects containing all allowed moves
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        Game game = this.getSquare().getGame();
        ArrayList<Square> legalMoves = super.getLegalMoves();
        ArrayList<Square> moves = new ArrayList<Square>();

        int r = this.getSquare().getRow();
        int c = this.getSquare().getCol();

        //up
        if (legalMoves.contains(game.getSquare(r + 1, c))) {
            moves.add(game.getSquare(r + 1, c));
        }
        //down
        if (legalMoves.contains(game.getSquare(r - 1, c))) {
            moves.add(game.getSquare(r - 1, c));
        }
        //right
        if (legalMoves.contains(game.getSquare(r, c + 1))) {
            moves.add(game.getSquare(r, c + 1));
        }
        //left
        if (legalMoves.contains(game.getSquare(r, c - 1))) {
            moves.add(game.getSquare(r, c - 1));
        }

        return moves;

    }
}
