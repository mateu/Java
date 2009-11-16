import java.lang.*;

public class CheckerBoardTest
{
    // constant value for the width and height of the board 
    public static final int  SIZE   = 8;
    
    // character that represents a blank square 
    public static final char PLAIN  = ' ';
    
    // character that represents a shaded square  
    public static final char SHADED = 'S';
    
    // 2-D array of character data for the checkerboard  
    private char[][] board;
    
    // fills in the board with shaded and plain square values  
    public CheckerBoardTest()
    {
	// create an array of 9 values for one row of squares
	// this array will be copied from 0-7 or 1-8 
	final char[] values = { PLAIN, SHADED, PLAIN, SHADED,
				PLAIN, SHADED, PLAIN, SHADED, PLAIN };
	
	// allocate memory for the checkerboard           
	board = new char[SIZE][SIZE];
	
	// copy the array of square values to each row of squares
	// even rows will start at 0; odd rows will start at 1 
	for(int i = 0; i < SIZE; i++)
	    {   
		System.arraycopy(values, i%2, board[i], 0, SIZE);
	    }
    }
    
    // prints the state of the game board to the console  
    public void print()
    {
	for(int i = 0; i < SIZE; i++)
	    {
		for(int j = 0; j < SIZE; j++)
                    {
			System.out.print(board[i][j]);
                    }
		// print blank line between rows 
		System.out.println();
	    }
    }
    
    // creates a CheckerBoard object and print it to the console       
    public static void main(String[] args)
    {
	new CheckerBoardTest().print();
    }
} // CheckerBoardTest
