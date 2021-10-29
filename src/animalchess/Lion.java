package animalchess;

import java.util.ArrayList;
/**
 * Class that implements the specific movement rules for the Lion piece and handles the capturing of a lion.
 */
public class Lion extends Piece {
    /**
     * Extends the constructor from the Piece class.
     * @param owner Player who owns this piece.
     * @param square Square this piece sits on.
     */
    public Lion(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * When a lion is captured, declares the capturer the winner of the game.
     * @param capturer the player who captured this lion
     */
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        capturer.winGame();
    }
    /**
     * Extends getLegalMoves from the piece class. Implements the rules for the lion piece.
     * @return moves, an array of Square objects containing all allowed moves
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        Game game = this.getSquare().getGame();
        ArrayList<Square> legalMoves = super.getLegalMoves();
        ArrayList<Square> moves = new ArrayList<Square>();

        int r = this.getSquare().getRow();
        int c = this.getSquare().getCol();
        //down
        if (legalMoves.contains(game.getSquare(r + 1, c))) {
            moves.add(game.getSquare(r + 1, c));
        }
        //down right
        if (legalMoves.contains(game.getSquare(r + 1, c + 1))) {
            moves.add(game.getSquare(r + 1, c + 1));
        }
        //down left
        if (legalMoves.contains(game.getSquare(r + 1, c - 1))) {
            moves.add(game.getSquare(r + 1, c - 1));
        }
        //right
        if (legalMoves.contains(game.getSquare(r, c + 1))) {
            moves.add(game.getSquare(r, c + 1));
        }
        //left
        if (legalMoves.contains(game.getSquare(r, c - 1))) {
            moves.add(game.getSquare(r, c - 1));
        }
        //up
        if (legalMoves.contains(game.getSquare(r - 1, c))) {
            moves.add(game.getSquare(r - 1, c));
        }
        //up left
        if (legalMoves.contains(game.getSquare(r - 1, c + 1))) {
            moves.add(game.getSquare(r - 1, c + 1));
        }
        //up right
        if (legalMoves.contains(game.getSquare(r - 1, c - 1))) {
            moves.add(game.getSquare(r - 1, c - 1));
        }
        return moves;
    }
}

