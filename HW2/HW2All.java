import java.util.HashMap;
import java.util.Iterator;

class Point {
	double x;
	double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// Mkae origin the default point when no arguments are passed to the
	// constructor.
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point a = new Point(3, 0);
		Point b = new Point(0, 4);
		System.out.println(a.distanceTo(b));
		System.out.println((new Point(1, 1)).distanceTo(new Point()));
	}

	public double distanceTo(Point p) {
		double delta_x = this.x - p.x;
		double delta_y = this.y - p.y;
		double delta_x_squared = delta_x * delta_x;
		double delta_y_squared = delta_y * delta_y;
		return Math.sqrt(delta_x_squared + delta_y_squared);
	}

}

class Line {
	Point a;
	Point b;

	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
	}

	public Line() {
		this.a = new Point(0, 0);
		this.b = new Point(0, 0);
	}

	public static void main(String[] args) {
		Line l1 = new Line(new Point(0, 0), new Point(1, 1));
		Line l2 = new Line(new Point(0, 0), new Point(3, 4));
		System.out.println(l1.length());
		System.out.println(l2.length());
	}

	public double length() {
		return this.a.distanceTo(this.b);
	}
}

class Triangle {
	Point p1;
	Point p2;
	Point p3;
	Line l12;
	Line l23;
	Line l31;
	double a, b, c;
	double s;

	public Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.l12 = new Line(p1, p2);
		this.l23 = new Line(p2, p3);
		this.l31 = new Line(p3, p1);
		this.a = l12.length();
		this.b = l23.length();
		this.c = l31.length();
		this.s = (a + b + c) / 2;
	}

	public double area() {
		return Math.sqrt(this.s * (this.s - this.a) * (this.s - this.b)
				* (this.s - this.c));
	}

	public static void main(String[] args) {
		Triangle a = new Triangle(new Point(0, 0), new Point(0, 3), new Point(
				4, 0));
		System.out.println(a.area()); // prints 3 * 4 / 2 (that is: 6 (six))
	}

}

class Clock {
	int hours;
	int minutes;

	public Clock(String tiempo) {
		this.hours = Integer.parseInt(tiempo.substring(0, 2));
		this.minutes = Integer.parseInt(tiempo.substring(2, 4));
	}

	public String report() {
		String hh = this.hours < 10 ? "0" + this.hours : Integer
				.toString(this.hours);
		String mm = this.minutes < 10 ? "0" + this.minutes : Integer
				.toString(this.minutes);
		return hh + ":" + mm;
	}

	public int get_hours() {
		return this.hours;
	}

	public int get_minutes() {
		return this.minutes;
	}

	public void tick() {
		if (this.minutes == 59) {
			if (this.hours == 23) {
				this.hours = 0;
				this.minutes = 0;
			} else {
				this.hours += 1;
				this.minutes = 0;
			}
		} else {
			this.minutes += 1;
		}
	}

	public static void main(String[] args) {
		Clock one = new Clock("2350");
		int i;
		for (i = 1; i < 22; i++) {
			System.out.println(one.report());
			one.tick();
		}
	}

}

class Player {
	String guess;
	static String[] choices = { "rock", "paper", "scissors" };

	public void makeGuess() {
		int index = (int) (Math.random() * 3);
		this.guess = choices[index];
	}

	public String report() {
		return this.guess;
	}

	public boolean strongerThan(Player p) {
		if (this.guess.equalsIgnoreCase("rock")
				&& p.guess.equalsIgnoreCase("scissors")) {
			return true;
		} else if (this.guess.equalsIgnoreCase("paper")
				&& p.guess.equalsIgnoreCase("rock")) {
			return true;
		} else if (this.guess.equalsIgnoreCase("scissors")
				&& p.guess.equalsIgnoreCase("paper")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		Player bonaparte, wellington;

		bonaparte = new Player();
		wellington = new Player();

		System.out.println("Let the game begin!");

		bonaparte.makeGuess();
		wellington.makeGuess();

		System.out.println("The guesses have been made: ");

		System.out.println(" Bonaparte has chosen .... " + bonaparte.report());
		System.out.println(" Wellington has chosen ... " + wellington.report());
		if (bonaparte.strongerThan(wellington)) {
			System.out.println("Bonaparte wins!");
		} else if (wellington.strongerThan(bonaparte)) {
			System.out.println("Wellington wins!");
		} else {
			System.out.println("It's a draw...");
		}
	}
}

class Elevator {
	int currentFloor;

	public Elevator(int start_floor) {
		this.currentFloor = start_floor;
	}

	public int currentFloor() {
		return this.currentFloor;
	}

	public void up(int goto_floor) {
		if (this.currentFloor > goto_floor) {
			System.out.println("Sorry, from floor " + this.currentFloor
					+ " we can't go up to floor " + goto_floor);
		} else {
			int i;
			System.out.println("Elevator going up (" + this.currentFloor
					+ " --> " + goto_floor + ")");
			for (i = this.currentFloor; i <= goto_floor; i++) {
				this.currentFloor = i;
				System.out.println("   The elevator is now on floor " + i);
			}
			System.out.println("Elevator now on floor " + goto_floor);
		}
	}

	public void down(int goto_floor) {
		if (this.currentFloor < goto_floor) {
			System.out.println("Sorry, from floor " + this.currentFloor
					+ " we can't go down to floor " + goto_floor);
		} else {
			int i;
			System.out.println("Elevator going down (" + this.currentFloor
					+ " --> " + goto_floor + ")");
			for (i = this.currentFloor; i >= goto_floor; i--) {
				this.currentFloor = i;
				System.out.println("   The elevator is now on floor " + i);
			}
			System.out.println("Elevator now on floor " + goto_floor);
		}
	}

	public static void main(String[] args) {
		Elevator e = new Elevator(20);
		e.up(26);
		e.down(14);
		e.up(10);
		e.down(30);
		e.up(e.currentFloor() + 3);
	}
}

class Robot {
	final static int TURN_AMOUNT = 90;
	static HashMap<Integer, String> degreeToWord;
	static HashMap<String, Integer> wordToDegree;

	int x, y;
	String name;
	String direction;
	int direction_in_degrees; // 0 -> East, 90 -> North ...

	static HashMap<Integer, String> init_degreeToWord() {
		HashMap<Integer, String> degreeToWord;
		degreeToWord = new HashMap<Integer, String>();
		degreeToWord.put(new Integer(0), "East");
		degreeToWord.put(new Integer(90), "North");
		degreeToWord.put(new Integer(180), "West");
		degreeToWord.put(new Integer(270), "South");
		return degreeToWord;
	}

	static HashMap<String, Integer> init_wordToDegree() {
		HashMap<String, Integer> wordToDegree;
		wordToDegree = new HashMap<String, Integer>();
		Iterator<Integer> it = Robot.degreeToWord.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (int) it.next();
			wordToDegree.put(Robot.degreeToWord.get(key), key);
		}
		return wordToDegree;
	}

	public Robot(String name, int x, int y, String direction) {
		this.name = name;
		this.x = x;
		this.y = y;
		degreeToWord = init_degreeToWord();
		wordToDegree = init_wordToDegree();
		this.direction = direction;
		this.direction_in_degrees = Robot.wordToDegree.get(direction);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public String direction() {
		return this.direction;
	}

	public void report() {
		System.out.println("Robot " + this.name + " located at (" + this.getX()
				+ ", " + this.getY() + ") facing " + this.direction);
	}

	public void turnLeft() {
		System.out.println("Robot " + name + " now turns left.");
		this.direction_in_degrees = (this.direction_in_degrees + TURN_AMOUNT) % 360;
		this.direction = Robot.degreeToWord.get(direction_in_degrees);
	}

	public void moveForward() {
		System.out.println("Robot " + name + " now moves forward.");
		switch (this.direction_in_degrees) {
		case 0:
			this.x += 1;
			break;
		case 90:
			this.y += 1;
			break;
		case 180:
			this.x -= 1;
			break;
		case 270:
			this.y -= 1;
			break;
		default:
			break;
		}
		/*
		 * System.out.println("Robot " + name + " now at (" + this.getX() + ", "
		 * + this.getY() + ") facing " + this.direction);
		 */
	}

	public static void main(String[] args) {

		Robot a = new Robot("Alice", 2, 3, "North");
		a.report();

		Robot q = new Robot("Queen", -4, -1, "West");
		q.report();

		a.turnLeft();
		a.report();

		a.moveForward();
		a.report();

		a.turnLeft();
		a.report();

		a.moveForward();
		a.report();

		a.moveForward();
		a.report();

		a.moveForward();
		a.report();

		q.moveForward();
		q.report();

		q.turnLeft();
		q.report();
	}
}

class Tigger {
	int x, y;

	public Tigger(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void bounce() {
		this.x = this.sum_of_digit_squares(this.x);
		this.y = this.sum_of_digit_squares(this.y);
	}

	private int sum_of_digit_squares(int n) {
		int number_of_digits = Integer.toString(n).length();
		int i;
		int sum_of_squares = 0;
		for (i = 0; i < number_of_digits; i++) {
//			System.out.println(i);
			String digit_string = Integer.toString(n).substring(i, i + 1);
			int digit = Integer.parseInt(digit_string);
//			System.out.println("digit: " + digit);
			sum_of_squares += digit * digit;
		}
		return sum_of_squares;
	}

	public String report() {
		return "Tigger just bounced to (" + this.x + ", " + this.y	+ ")";
	}

	public static void main(String[] args) {
		int a = (int) (Math.random() * 1000), b = (int) (Math.random() * 1000);
		Tigger u = new Tigger(a, b);
		for (int i = 0; i < 30; i++) {
			u.bounce();
			System.out.println(u.report());
		}
	}

}
