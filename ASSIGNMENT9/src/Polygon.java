import java.util.List;

/* This is a component class. It extends abstract class Shapes.
 * This class overrides some methods from its super class.
 * @author Vinod
 */
public class Polygon extends Shapes {

	// Instance Variables.
	Point centre;
	int n;				// Number of sides in polygon.
	int side;
	double area;
	double perimeter;
	
	// Constructor.
	public Polygon(Point startPoint, List<Integer> l) {
		super(startPoint);
		n = l.indexOf(0);
		area = this.getArea();
		perimeter = this.getPerimeter();
		origin = this.getOrigin();
		this.shapeType = Shape.ShapeType.RECTANGLE.toString();
	}
	
	/* This method calculates Area.
	 * return Area.
	 */
	public double getArea() {
		area = (Math.pow(side, 2) * n) / (4 * Math.tan(180 / n)); 
		return area;
	}
	
	/* This method calculates Perimeter.
	 * return Perimeter.
	 */
	public double getPerimeter() {
		perimeter = n * side;
		return perimeter;
	}
	
	/* This method is used to locate Origin.
	 * return Origin.
	 */
	public Point getOrigin() {
		return origin;
	}
	
	/* This method checks for a point is enclosed.
	 * return true if given point is enclosed, false otherwise.
	 */
	public boolean isPointEnclosed(Point p) {
		return false;
	}
}
