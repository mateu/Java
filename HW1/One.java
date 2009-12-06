import java.util.*;

class GradeConverter {
	static Scanner sc = new Scanner(System.in);
	static final float NUMBER_OUT_OF_RANGE_CODE = -101;
	static final float STOP_CODE = -1;

	public static void main(String[] args) {
		System.out.println("Welcome to the grade converter.");
		System.out.print("Enter an number between 0 and 4: ");
		float x;

		x = GetFloat();
		while (x != STOP_CODE) {
			if (x >= 3.85) {
				System.out.println("Grade: A");
			} else if (x >= 3.5) {
				System.out.println("Grade: A-");
			} else if (x >= 3.15) {
				System.out.println("Grade: B+");
			} else if (x >= 2.85) {
				System.out.println("Grade: B");
			} else if (x >= 2.5) {
				System.out.println("Grade: B-");
			} else if (x >= 2.15) {
				System.out.println("Grade: C+");
			} else if (x >= 1.85) {
				System.out.println("Grade: C");
			} else if (x >= 1.5) {
				System.out.println("Grade: C-");
			} else if (x >= 1.15) {
				System.out.println("Grade: D+");
			} else if (x >= 0.85) {
				System.out.println("Grade: D");
			} else if (x >= 0.5) {
				System.out.println("Grade: D-");
			} else if (x >= 0 ) {
				System.out.println("Grade: F");
			}
			System.out.print("Enter an number between 0 and 4: ");
			x = GetFloat();
		}
	}

	public static float GetFloat() {
		while (true) {
			try {
				// System.out.print("Enter an number between 0 and 4: ");
				float x = sc.nextFloat();
				if (x < 0 || x > 4) {
					System.out.println("Number out of range");
					return NUMBER_OUT_OF_RANGE_CODE;
				} else {
					return x;
				}
			} catch (InputMismatchException e) {
				String token = sc.next();
				if (token.equalsIgnoreCase("done")) {
					System.out.println("Thanks for using this program. Bye!");
					return STOP_CODE;
				} else {
					System.out.println("I'm sorry, please enter a number!");
					System.out.print("Enter an number between 0 and 4: ");
				}
			}
		}
	}
}
