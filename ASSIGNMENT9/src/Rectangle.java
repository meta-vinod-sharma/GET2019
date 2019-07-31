import java.util.List;

/* This is a component class. It extends abstract class Shapes.
 * This class overrides some methods from its super class.
 * @author Vinod
 */
public class Rectangle extends Shapes {

	// Instance variables.
	int length;
	int width;

	// Constructor.
	public Rectangle(Point startPoint, List<Integer> l) {
		super(startPoint);
		if(l.size() < 2)
			throw new AssertionError("Parameters Missing!!");
		length = l.get(0);
		width = l.get(1);
		area = this.getArea();
		perimeter = this.getPerimeter();
		origin = this.getOrigin();
		this.shapeType = Shape.ShapeType.RECTANGLE.toString();
	}
	
	/* This method calculates Area.
	 * return Area.
	 */
	public double getArea() {
		area = length * width;
		return area;
	}
	
	/* This method calculates Perimeter.
	 * return Perimeter.
	 */
	public double getPerimeter() {
		perimeter = 2 * (length + width);
		return perimeter;
	}
	
	/* This method is used to locate Origin.
	 * return Origin.
	 */
	public Point getOrigin() {
		return this.origin;
	}
	
	/* This method checks for a point is enclosed.
	 * return true if given point is enclosed, false otherwise.
	 */
	public boolean isPointEnclosed(Point p) {
		if(p.x <= (origin.x + length) && p.y <= (origin.y + width))
			return true;
		return false;
	}
}
