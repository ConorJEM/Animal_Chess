package animalchess;

import java.util.ArrayList;
/**
 * Class that implements the specific movement rules for the Cat piece.
 */
public class Cat extends PromotablePiece {
    /**
     * Extends the constructor from the Piece class.
     * @param owner Player who owns this piece.
     * @param square Square this piece sits on.
     */
    public Cat(Player owner, Square square) {
        super(owner, square);
    }
    /**
     * Extends getLegalMoves from the piece class. Implements the rules for the cat piece.
     * @return moves, an array of Square objects containing all allowed moves
     */
    @Override
    public ArrayList<Square> getLegalMoves() {
        Game game = this.getSquare().getGame();
        ArrayList<Square> legalMoves = super.getLegalMoves();
        ArrayList<Square> moves = new ArrayList<Square>();
        int num = this.getOwner().getPlayerNumber();
        int direction;
        int r = this.getSquare().getRow();
        int c = this.getSquare().getCol();
        if (num == 0) {
            direction = 1;
        } else {
            direction = -1;
        }

        if (this.getIsPromoted() == false) {

            //down right
            if (legalMoves.contains(game.getSquare(r - direction, c + 1))) {
                moves.add(game.getSquare(r - direction, c + 1));
            }
            //down left
            if (legalMoves.contains(game.getSquare(r - direction, c - 1))) {
                moves.add(game.getSquare(r - direction, c - 1));
            }

        } else {
            //down
            if (legalMoves.contains(game.getSquare(r - direction, c))) {
                moves.add(game.getSquare(r - direction, c));
            }
            //right
            if (legalMoves.contains(game.getSquare(r, c + 1))) {
                moves.add(game.getSquare(r, c + 1));
            }
            //left
            if (legalMoves.contains(game.getSquare(r, c - 1))) {
                moves.add(game.getSquare(r, c - 1));
            }

        }
        //up
        if (legalMoves.contains(game.getSquare(r + direction, c))) {
            moves.add(game.getSquare(r + direction, c));
        }
        //up left
        if (legalMoves.contains(game.getSquare(r + direction, c + 1))) {
            moves.add(game.getSquare(r + direction, c + 1));
        }
        //up right
        if (legalMoves.contains(game.getSquare(r + direction, c - 1))) {
            moves.add(game.getSquare(r + direction, c - 1));
        }

        return moves;

    }

}
