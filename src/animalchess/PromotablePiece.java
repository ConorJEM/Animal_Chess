package animalchess;
/**
 * An abstract class that extends piece, implementing the functionality specific to only promotable pieces.
 * @author cm378
 */
public abstract class PromotablePiece extends Piece {

    private Square square;
    private Player owner;
    private boolean promoted;

    /**
     * Promotable Piece constructor. Initialises the promoted state to false, ensuring a piece must first MOVE to
     * a square within its promotion zone to promote.
     * @param owner Player who owns this piece.
     * @param square Square this piece sits on.
     */
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
        //ensure a piece created in the promotion zone will NOT promote until first moved into
        //another square within promotion zone.
        promoted = false;
    }

    /**
     * A checker to see if a piece is promoted.
     * @return promoted, a boolean that is true when this piece is promoted
     */
    public boolean getIsPromoted() {
        return promoted;
    }

    /**
     * Promotes this piece, changing its set of rules for legal moves.
     */
    public void promote() {
        promoted = true;
    }

    /**
     * Moves this piece to the passed square. If this piece is moving into the promotion zone of
     * its owner, promote.
     * @param toSquare The square this piece will move to.
     */
    @Override
    public void move(Square toSquare) {
        if (toSquare.isPromotionZone(getOwner())) {
            promote();
        }
        super.move(toSquare);
    }
    /**
     * When a promotable piece is captured, it goes into the capturers hand gets unpromoted.
     * @param capturer The player who captured this piece.
     */
    @Override
    public void beCaptured(Player capturer) {
        promoted = false;
        super.beCaptured(capturer);
    }
}
