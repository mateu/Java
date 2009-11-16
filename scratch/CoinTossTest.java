import java.io.*;

public class CoinTossTest
{
    // String representation of each side of a coin
    static final String[] faces = { "Heads", "Tails" };
    
    public static void main(String[] args) throws IOException
    {
	// create a reader to read user input
	BufferedReader reader = 
	    new BufferedReader(new  
		InputStreamReader(System.in));                
	
	// guarantees that we perform the loop at least once
	do   
	    {
		// generate a 0 or a 1
		int result = (int)Math.round(Math.random());
		
		// print the result
		System.out.print(faces[result] + 
				 " it is! Toss again (Y/N)?  ");
	    }
	// quit when user does not input "y" or "Y"
	while(reader.readLine().toUpperCase().equals("Y"));
	
    } // main
} // CoinTossTest