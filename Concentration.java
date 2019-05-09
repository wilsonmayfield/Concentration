/**
 * The game of Concentration (also called Memory or Match Match)
 * 
 * Create a gameboard of tiles. Each tile contains a card that has exactly
 * one match on the board. Cards are originally show "face down" on the board.
 * 
 * Player chooses two random cards from the board. The chosen cards
 * are temporarily shown face up. If the cards match, they are removed from board.
 * 
 * Play continues, matching two cards at a time, until all cards have been matched.
 */
public class Concentration extends Board
{
    // create the game board
    public Tile[][] gameboard = makeBoard();

    /** 
     * The constructor for the game. Creates the 2-dim gameboard
     * by populating it with tiles.
     */
    public Concentration() { 
        int a = 0; //integer for populating gameboard with cards array
        for(int i = 0; i < gameboard.length; i++){ // makes sure it's less than the row count, which is 3
            for(int j = 0; j < gameboard[0].length; j++){ // makes sure it's less than the column count, which is 4
                gameboard[i][j] = new Tile(cards[a++]);
            }
        }
        a = 0; //reset to 0 in case board is constructed again later
        for(int i = 0; i < gameboard.length; i++){ // makes sure it's less than the row count, which is 3
            for(int j = 0; j < gameboard[0].length; j++){ // makes sure it's less than the column count, which is 4
                if(gameboard[i][j].isFaceUp()){ //prints this if the card is face up, which shows the animal
                    System.out.print(" | " + gameboard[i][j]);
                }
                else{ //prints this if the card is face down, which doesn't show the animal
                    System.out.print(" | " + gameboard[i][j].cardBack);
                }
            }
            System.out.print(" |\n"); //ends board and skips a line
        }
    }

    /**
     * Determine if the board is full of cards that have all been matched,
     * indicating the game is over
     * 
     * Precondition: gameboard is populated with tiles
     * 
     * @return true if all pairs of cards have been matched, false otherwse
     */
    public boolean allTilesMatch() {
        int a = 0; //used to keep track of how many cards are face up
        for(int i = 0; i < gameboard.length; i++){ //increments through all cards in the game board
            for(int j = 0; j< gameboard[0].length; j++){  
                if(gameboard[i][j].isFaceUp()){
                    a++; //face up card counter
                }
            }
        }
        if(a == 12){ //if there are 12 face up cards, return a true since the player won
            return true;
        }
        else{ //if there are less than 12 face up cards, return a false since the player hasn't won yet
            return false;
        }
    }

    /**
     * Check for a match between the cards in the two tile locations.
     * For matched cards, remove from the board. For unmatched cares, them face down again.
     * 
     * Precondition: gameboard is populated with tiles,
     * row values (i values) must be in the range of 0 to gameboard.length,
     * column values (j values) must be in the range of 0 to gameboard[0].length
     * 
     * @param row1 the row value of Tile 1
     * @param column1 the column value of Tile 1
     * @param row2 the row value of Tile 2
     * @param column2 the column vlue of Tile 2
     * @return a message indicating whether or not a match occured
     */
    public String checkForMatch(int row1, int column1, int row2, int column2) {
        //checks if animal of first card equals the animal on the second card
        if(gameboard[row1][column1].getFace().equals(gameboard[row2][column2].getFace())){
            return "A match has been found!";//returns this if the card has been matched
        }
        else{//resets both cards back to being face down, so they are hidden on the next turn
            gameboard[row1][column1].faceUp(false);
            gameboard[row2][column2].faceUp(false);
            return"No match was found."; //returns this if the card hasn't been matched
        }
    }

    /**
     * Set  tile to show its card in the face up state
     * 
     * Precondition: gameboard is populated with tiles,
     * row values (i values) must be in the range of 0 to gameboard.length,
     * column values (j values) must be in the range of 0 to gameboard[0].length
     * 
     * @param row the row value of Tile
     * @param column the column value of Tile
     */
    public void showFaceUp (int row, int column) {
        gameboard[row][column].faceUp(true);//changes the card to be face up instead of face down
        for(int i = 0; i < gameboard.length; i++){ // makes sure it's less than the row count, which is 3
            for(int j = 0; j < gameboard[0].length; j++){ // makes sure it's less than the column count, which is 4
                if(gameboard[i][j].isFaceUp()){
                    System.out.print(" | " + gameboard[i][j].getFace());//prints all cards that are face up
                }
                else{
                    System.out.print(" | " + gameboard[i][j].cardBack);//prints all cards that aren't face up
                }
            }
            System.out.print(" |\n");//ends game board and skips a line
        }
    }

    /**
     * Returns a string representation of the board. A tab is placed between tiles,
     * and a newline is placed at the end of a row
     * 
     * Precondition: gameboard is populated with tiles
     * 
     * @return a string representation of the board
     */
    public String toString() {
        //I tried implementing a .toString() method but I didn't really have enough time to fix it so it would work
        //So, I removed it.
        return "";
    }

}

