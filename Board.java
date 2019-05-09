import java.util.*;
/**
 * Board: A n x m game board made of of individualab tiles.
 * 
 * For the game of concentraiton",the board is made up of
 * pairs of matching strings, one string per tile. 
 * 
 * Precondition: the size of the cards array must fit into the rows/columns shape of the board
 */
public abstract class Board {
    public String[] cards = new String[] //cards with animals for the game
    {"dog", "dog", "cat", "cat", "mouse", "mouse","wolf", "wolf", "monkey", "monkey", "bird", "bird"}; 
    private List <String> cardsArrayList = Arrays.asList(cards); //converts the cards array to an ArrayList for randomization later
    // The  shape of the board
    public int rows = 3;
    public int columns = 4;  

    /**
     * Create a 2-dim array to represent a game board and return it
     * Randomizes the converted cards Array List and converts it back into a regular Array
     */
    public Tile[][] makeBoard() {
        Collections.shuffle(cardsArrayList); //shuffles the cards so they're randomly organized
        cards = cardsArrayList.toArray(new String[cardsArrayList.size()]); //converts array back into a regular Array
        return new Tile[rows][columns]; //returns the dimensions of the board
    }

    /**
     * Return the array of cards
     */
    public String[] getCards() {   
        return cards;
    }
}
