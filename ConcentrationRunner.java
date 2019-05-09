/** 
 * Play the game of Concentration
 * 
 * The runner creates a game board and shows the board. It gets a 2-tile selection from the user,
 * checks if the cards at the 2 tile locations match, and then re-displays the board.
 */
import java.util.Scanner;

public class ConcentrationRunner
{
    // create the game 
    public static Concentration game = new Concentration();;

    public static void main(String[] args)
    {
        // input object for the BlueJ console
        Scanner in = new Scanner(System.in);
        System.out.println("\u000C"); //clear output so the board prints after
        
        // instructions
        System.out.println("Welcome to the game of Concentration.");
        System.out.println("Select the tile locations you want to see,");
        System.out.println("or enter any non-integer character to quit.");
        System.out.println("The first number must be no more than 3.");
        System.out.println("The second number must be no more than 4.");
        //displayBoard();//displays board. relies on .toString(), so it doesn't actually do anything.
        //.toString() seems to be really buggy and would take too long to fix, so I removed my code for it.
        System.out.println("Press Enter to continue...");
        in.nextLine();

        // play until all tiles are matched
        while(!game.allTilesMatch()) {  
            // player selects first tile, if not an integer, quit game
            int i1 = -1;
            int j1 = -1;
            System.out.print("First choice: ");
            if (in.hasNextInt()){
                i1 = in.nextInt() - 1; 
            }
            else {
                quitGame();
            }
            if (in.hasNextInt()){
                j1 = in.nextInt() - 1;
            }
            else {
                quitGame();
            }
            in.reset(); // ignore any extra input

            // display board with first tile face up
            game.showFaceUp(i1, j1);
            displayBoard();

            // player selects second tile, if not an integer, quit game
            int i2 = -1;
            int j2 = -1;
            System.out.print("Second choice: ");
            if(in.hasNextInt()){
                i2 = in.nextInt() - 1;
            }
            else{ 
                quitGame();
            }
            if(in.hasNextInt()){
                j2 = in.nextInt() - 1;
            }
            else{
                quitGame();
            }
            in.reset(); // ignore any extra input
            displayBoard();
            // display board with additional second tile face up
            game.showFaceUp(i2, j2);
            displayBoard(); 

            // determine if a match was found
            String matched = game.checkForMatch(i1, j1, i2, j2);
            System.out.println(matched);
        }
        displayBoard();
        System.out.println("Game Over!");
    }

    /**
     * Clear the console and show the game board
     * Tiles can either indicate the card is  face up or face down
     */
    public static void displayBoard() {
        //System.out.print('\u000C'); 
        System.out.println(game);
    }

    //removed wait method since i didn't use it

    /** 
     * User quits game
     */
    private static void quitGame() {
        System.out.println("Game ended!");
        System.exit(0);
    }
}
