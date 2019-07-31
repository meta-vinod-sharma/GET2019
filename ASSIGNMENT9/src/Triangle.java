import java.util.List;

/* This is a component class. It extends abstract class Shapes.
 * This class overrides some methods from its super class.
 * @author Vinod
 */
public class Triangle extends Shapes {

	// Instance variables.
	int side;
	
	// Constructor.
	public Triangle(Point startPoint, List<Integer> l) {
		super(startPoint);
		if(l.get(0) == null)
			throw new AssertionError("Parameters Missing!!");
		this.side = l.get(0);
		this.area = this.getArea();
		this.perimeter = this.getPerimeter();
		this.origin = this.getOrigin();
		shapeType = ShapeType.TRIANGLE.toString();	
	}
	
	/* This method calculates Area.
	 * return Area.
	 */
	public double getArea() {
		area = Math.pow(side, 2) * Math.pow(3, 1/2) / 4;
		return area;
	}
	
	/* This method calculates Perimeter.
	 * return Perimeter.
	 */
	public double getPerimeter() {
		perimeter = 3 * side;
		return perimeter;
	}
	
	/* This method is used to locate Origin.
	 * return Origin.
	 */
	public Point getOrigin() {
		return origin;
	}
	
	/* A function to check whether Point p(x, y) lies inside the triangle formed by 
	 * Points p1(x1, y1), p2(x2, y2) and p3(x3, y3). 
	 * return true if point is enclosed, false otherwise.
     */
	public boolean isPointEnclosed(Point p) {
		Point p1 = new Point(this.origin.x, this.origin.y);
		Point p2 = new Point(p1.x + side, p1.y);
		int median = (int) Math.pow( (Math.pow(side, 2) - Math.pow((side / 2), 2)), 0.5);
		Point p3 = new Point((p1.x + p2.x) / 2, p1.y + median);	
		
		// Calculate area of triangle ABC.
		double a = Triangle.area (p1, p2, p3); 

		// Calculate area of triangle PBC.  
		double a1 = Triangle.area (p, p1, p2); 

		// Calculate area of triangle PAC.  
		double a2 = Triangle.area (p, p2, p3); 

		// Calculate area of triangle PAB.
		double a3 = Triangle.area (p1, p, p3); 

		// Check if sum of A1, A2 and A3 is same as A.
		return (a == a1 + a2 + a3); 
	}
	
	/* A utility function to calculate area of triangle 
	 * formed by Point p1, p2 & p3. 
	 * return double area of triangle.
	 */
	static double area(Point p1, Point p2, Point p3) { 
		int x1 = p1.x, y1 = p1.y; 
		int x2 = p2.x, y2 = p2.y; 
		int x3 = p3.x, y3 = p3.y;
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0); 
	} 	
}
