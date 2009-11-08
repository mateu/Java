import java.util.*;

/* Must use index to determine lenght of space strings.
 * 
 */

public class Two {
	static Scanner sc = new Scanner(System.in);
	static final int NUMBER_OUT_OF_RANGE_CODE = -101;
	static final int STOP_CODE = -1;

	public static void main(String[] args) {
		System.out.println("Welcome to the Scalable Z's program!");
		System.out.print("What size Z do you want? ");
		int z;
		z = GetZ();
		float half_z = (float) z / 2;
		int mid_length = (int) Math.ceil(half_z);
		if ( mid_length % 2 == 0 ) {
			mid_length++;
		}
		int i;
		for (i = 1; i <= z; i++) {
			System.out.print(i);
			if (i == z || i == 1) {
				String a = getAsterix(z);
				System.out.println(a);
			}
			else if ( i == Math.ceil(half_z) ) {
				int number_of_spaces_on_left = (z - mid_length);
				int number_of_spaces_on_right = (z - mid_length);
				String left_spaces = getSpaces(number_of_spaces_on_left);
				String a = getAsterix(mid_length);
				String right_spaces = getSpaces(number_of_spaces_on_right);
				System.out.print(left_spaces);
				System.out.print(a);
				System.out.println(right_spaces);
			}
			else {
				int number_of_spaces_on_left = 2*(z - i);
				int number_of_spaces_on_right = 2*(i - 1);
				String left_spaces = getSpaces(number_of_spaces_on_left);
				String right_spaces = getSpaces(number_of_spaces_on_right);
				System.out.print(left_spaces);
				System.out.print("* ");
				System.out.println(right_spaces);
			}
		}
	}

	public static int GetZ() {
		while (true) {
			try {
				int z = sc.nextInt();
				if (z < 1) {
					System.out
							.println("Program only defined for positive integers.");
				} else {
					return z;
				}
			} catch (InputMismatchException e) {
				System.out
						.println("Program only defined for positive integers.");
			}
		}
	}

	public static String getSpaces(int n) {
		String s = "";
		int i;
		for (i = 0; i < n; i++) {
			s += " ";
		}
		return s;
	}

	public static String getAsterix(int n) {
		String a = "";
		int i;
		for (i = 0; i < n; i++) {
			a += "* ";
		}
		return a;
	}
}
