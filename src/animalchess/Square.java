package animalchess;
/**
 * A class that creates the squares for the game of animal chess and their specified functionality.
 * @author cm378
 */
public class Square {
    private Game game;
    private int row;
    private int col;
    private Piece piece;
    private Player promotesPlayer;

    /**
     * Square constructor.
     * @param game The current game
     * @param row Integer representing the row this square sits on
     * @param col Integer representing the column this square sits on
     */
    public Square(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
    }
    /**
     * Square constructor for pieces in a promotion zone.
     * @param game The current game
     * @param row Integer representing the row this square sits on
     * @param col Integer representing the column this square sits on
     * @param promotesPlayer Player that will have their eligible pieces promoted if moved to this square.
     */
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.promotesPlayer = promotesPlayer;
    }
    /**
     * Places a given piece on top of this square.
     * Should only work if the square is empty.
     * @param piece The piece that will be placed here.
     */
    public void placePiece(Piece piece) {
        if (this.piece == null) {
            this.piece = piece;
            piece.setSquare(this);

        } else {
            throw new IllegalArgumentException("Fail");
        }

    }
    /**
     * Removes a piece from this square.
     */
    public void removePiece() {
        this.piece = null;
    }
    /**
     * Checks if this square is part of the given players promotion zone.
     * @param player A player that is playing this game.
     * @return Boolean, true if this square is within this players promotion zone
     *
     */
    public boolean isPromotionZone(Player player) {
        return this.promotesPlayer == player;
    }

    /**
     * Getter; Returns the game that this piece belongs to.
     * @return game, the current game
     */
    public Game getGame() {
        return this.game;
    }
    /**
     * Getter; Returns the piece that this is on this square.
     * @return piece a Piece object
     */
    public Piece getPiece() {
        return this.piece;
    }
    /**
     * Getter; Returns the row that this square lies on within the gameBoard.
     * @return row An integer representing the row
     */
    public int getRow() {
        return row;
    }
    /**
     * Getter; Returns the column that this square lies on within the gameBoard.
     * @return piece An integer representing the column
     */
    public int getCol() {
        return col;
    }

}
