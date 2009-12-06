import java.util.Scanner;
import java.util.*;

class CircRect {
	static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		String shape;
		double x, y;
		double radius = 0;
		double width = 0;
		double height = 0;
		String radius_or_size_string;

		System.out.print("Welcome, please define your first object: ");
		shape = scanner.next();
		x = scanner.nextDouble();
		y = scanner.nextDouble();

		radius_or_size_string = scanner.next();
		if (shape.equalsIgnoreCase("Circle")) {
			radius = scanner.nextInt();
			shapes.add(new Circle(x, y, radius));
		} else if (shape.equalsIgnoreCase("Rectangle")) {
			width = scanner.nextDouble();
			height = scanner.nextDouble();
			shapes.add(new Rectangle(x, y, width, height));
		}
		else {
			System.out.println("ERROR: Unknown Shape.");
		}
		do {
			System.out
					.print("Please enter another object or done if finished: ");
			shape = scanner.next();
			if ( shape.equalsIgnoreCase("done") ) { break; }
			x = scanner.nextDouble();
			y = scanner.nextDouble();

			radius_or_size_string = scanner.next();
			if (shape.equalsIgnoreCase("Circle")) {
				radius = scanner.nextInt();
				shapes.add(new Circle(x, y, radius));
			} else if (shape.equalsIgnoreCase("Rectangle")) {
				width = scanner.nextDouble();
				height = scanner.nextDouble();
				shapes.add(new Rectangle(x, y, width, height));
			}
		} while ( true );

		Collections.sort(shapes);
		//System.out.println(shapes.toString());
		Iterator<Shape> itr = shapes.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}

	public static boolean cueUpNextLine() {
		while (true) {
			try {
				String line_remainder = scanner.nextLine();
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}
		}
	}
}

abstract class Shape implements Comparable<Shape> {

	public abstract double area();

	public int compareTo(Shape other) {
		if (this.area() > other.area()) {
			//System.out.println( "this area: " + this.area() + " other area: " + other.area() );
			return 1;
		} else if ( this.area() < other.area() ) {
			//System.out.println( "this area: " + this.area() + " other area: " + other.area() );
			return -1;
		} else {
			return 0;
		}

	}
}

class Circle extends Shape {
	double x, y, radius;

	public Circle(double x, double y, double radius) {
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
	
	public double area() {
			return Math.PI * this.radius * this.radius;
	}

	public String toString() {
		return  "Circle at (" + this.x + ", " + this.y + ") radius: " + this.radius + " and area " + this.area();
	}
}

class Rectangle extends Shape {
	double x, y, width, height;

	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public double area() {
		return this.width * this.height;
	}
	public String toString() {
		return "Rectangle at (" + this.x + ", " + this.y + ") width: " + this.width + ", height: " + this.height + " and area " + this.area();
	}
}
