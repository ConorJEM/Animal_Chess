package animalchess;

/**
 * A class which creates and initialises the game board with the appropriate squares and pieces.
 * Contains some getter methods for checking the state of the game.
 * @author cm378
 */
public class Game {
    private static int HEIGHT = 6;
    private static int WIDTH = 5;

    private Player p0;
    private Player p1;

    private Square[][] gameBoard = new Square[HEIGHT][WIDTH];

    /**
     * Game constructor. The gameBoard is filled with 30 squares. Eligible squares are marked as
     * promotion zones for each player. The board is filled with the pieces in their starting positions for the game.
     * @param p0 The player at the top of the board.
     * @param p1 The player at the bottom of the board.
     */
    public Game(Player p0, Player p1) {

        this.p0 = p0;
        this.p1 = p1;

        //Fill the gameBoard array with squares. The squares within promotion zones are
        //Initialised with the appropriate constructor.
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i < 2) {
                    gameBoard[i][j] = new Square(this, i, j, p1);
                } else if (i > 3) {
                    gameBoard[i][j] = new Square(this, i, j, p0);
                } else
                    gameBoard[i][j] = new Square(this, i, j);

            }

        }
        //Placing the required pieces on the board.
        new Chick(p0, gameBoard[2][1]);
        new Chick(p0, gameBoard[2][2]);
        new Chick(p0, gameBoard[2][3]);

        new Chick(p1, gameBoard[3][1]);
        new Chick(p1, gameBoard[3][2]);
        new Chick(p1, gameBoard[3][3]);

        new Cat(p0, gameBoard[0][0]);
        new Cat(p0, gameBoard[0][4]);

        new Cat(p1, gameBoard[5][0]);
        new Cat(p1, gameBoard[5][4]);

        new Giraffe(p0, gameBoard[0][1]);
        new Giraffe(p0, gameBoard[0][3]);

        new Giraffe(p1, gameBoard[5][1]);
        new Giraffe(p1, gameBoard[5][3]);

        new Lion(p0, gameBoard[0][2]);
        new Lion(p1, gameBoard[5][2]);

    }

    /**
     * Returns the player corresponding to the given playerNumber.
     * @param playerNumber either 0 or 1 depending on requested player.
     * @return player, The requested player.
     */
    public Player getPlayer(int playerNumber) {
        if (playerNumber == p0.getPlayerNumber()) {
            return p0;
        } else if (playerNumber == p1.getPlayerNumber()) {
            return p1;
        }
        throw new IllegalArgumentException();
    }
    /**
     * Returns the winning player, or null if no player has won.
     * @return player or null, the winner of the game.
     */
    public Player getWinner() {
        if (this.getPlayer(1).hasWon()) {
            return this.getPlayer(1);
        } else if (this.getPlayer(0).hasWon()) {
            return this.getPlayer(0);
        } else return null;
    }
    /**
     * Returns the square at the given row and column. Returns a square not in gameBoard
     * if outside the grid of the game.
     * @param col Column number from 0 to 4
     * @param row Row  number from 0 to 5
     * @return Square the square at these coordinates
     */
    public Square getSquare(int row, int col) {
        //I add this square for when Im dealing with a pieces legal moves. If I try to call
        //the getSquare method on a square outside of the game grid, this square notExist ensures there is no error.
        Square notExist = new Square(this, -10, -10);

        if (row > HEIGHT - 1 || col > WIDTH - 1 || row < 0 || col < 0) {
            return notExist;
        } else {
            return gameBoard[row][col];

        }

    }

}
