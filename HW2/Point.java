public class Point {
	double x;
	double y;
	
	//Constructor
	public Point (double x, double y) {
		this.x = x;
		this.y = y
	}

	public double distanceTo(Point p) {
		return Math.sqrt((this.x - p.x)*(this.x - p.x) + (this.y - p.y)*(this.y - p.y));
	}
	
	public static void main(String[] args) {
		Point a = new Point(0,0);
		Point b = new Point(1,1);
		double distance_from_a_to_b = a.distanceTo(b);
	
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY (double y) {
		this.y = y;
	}
	public double getX(){
		return this.x;
	}
	public double getY() {
		return this.y;
	}
}
