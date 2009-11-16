import java.util.*;
import java.text.*;

public class Three {
	static Scanner sc = new Scanner(System.in);
	static final int EVEN_NUMBER_CODE = -2;
	static final int NEGATIVE_NUMBER_CODE = -1;

	public static void main(String[] args) {
		int n = GetInt();
		MagicSquare mySquare = new MagicSquare(n);
		while ( mySquare.setNextValue() ) {
		}
		int i, j;
		for (i=0; i < n; i++) {
			for (j=0; j < n; j++) {
				int value = mySquare.magic_square[i][j];
				String formatted_number = padNumber(n,value);
				System.out.print(formatted_number);
			}
			System.out.println();
		}

	}

	public static int GetInt() {
		while (true) {
			try {
				System.out.print("Enter a positive odd number: ");
				int n = sc.nextInt();
				if (n % 2 == 0) {
					System.out.println("Number is even.");
					// return EVEN_NUMBER_CODE;
				} else if (n < 3) {
					System.out.println("Magic squares only interesting for 3 or greater");
					// return NEGATIVE_NUMBER_CODE;
				} else {
					return n;
				}
			} catch (InputMismatchException e) {
				System.out
						.println("Please enter a postive odd integer to make a magic square.");
			}
		}
	}
	public static String padNumber(int n, int x) {
		int i;
		int n_squared_length = Integer.toString(n*n).length();
		int x_length = Integer.toString(x).length();
		int number_of_spaces = n_squared_length - x_length;
		
		String spaces = " ";
		for (i=1; i <= number_of_spaces; i++) {
			spaces = spaces + " ";
		}
		String formatted_number = spaces + Integer.toString(x);
		return formatted_number;
	}
}
