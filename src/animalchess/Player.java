package animalchess;

import java.util.ArrayList;
/**
 * A class that creates the players for the game of animal chess and their specified functionality.
 * @author cm378
 */

public class Player {
    private final String name;
    private final int playerNumber;
    private Boolean winner = false;
    private ArrayList<Piece> hand = new ArrayList<Piece>();

    /**
     * Constructs a player to take part in the game.
     * @param name a string of the name of this player
     * @param playerNumber an integer of 0 or 1 that determines what side of the board this player plays from
     */
    public Player(String name, int playerNumber) {
        if (playerNumber == 0 || playerNumber == 1) {
            this.name = name;
            this.playerNumber = playerNumber;
        } else {
            throw new IllegalArgumentException();
        }

    }
    /**
     * Getter; Returns this players name age, as specified at construction.
     * @return name, a string of the players name.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter; Returns this player's player number, which should be 0 or 1.
     * @return playerNumber
     */
    public int getPlayerNumber() {
        return playerNumber;
    }
    /**
     * Returns this player's Hand, the collection of pieces they have captured from their opponent.
     * @return hand, an ArrayList of captured pieces.
     */
    public ArrayList<Piece> getHand() {
        return hand;
    }
    /**
     * Adds the given piece to this players hand, removing it from the board.
     * @param piece The piece that will be added to hand.
     */
    public void addPieceToHand(Piece piece) {
        piece.getSquare().removePiece();
        hand.add(piece);
    }
    /**
     * Takes a piece from the places hand and places it on the board.
     * @param piece The piece that will be dropped on the board.
     * @param square The square that the piece will be dropped on.
     */
    public void dropPiece(Piece piece, Square square) {
        hand.remove(piece);
        square.placePiece(piece);
    }
    /**
     * Changes the boolean 'winner' from false to true when the opponent's lion is captured.
     */
    public void winGame() {
        winner = true;
    }
    /**
     * Checks if a player has won. Returns true after the winGame method has been called
     * by the opponent's lion being captured.
     * @return winner, a boolean that is true if this player has won.
     */
    public boolean hasWon() {
        return winner;
    }

}
