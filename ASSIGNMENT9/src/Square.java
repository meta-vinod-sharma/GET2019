import java.util.List;

/* This is a component class. It extends abstract class Shapes.
 * This class overrides some methods from its super class.
 * @author Vinod
 */
public class Square extends Shapes {

	// Instance variables.
	int width;

	// Constructor.
	public Square(Point startPoint, List<Integer> l) {
		super(startPoint);
		if(l.get(0) == null)
			throw new AssertionError("Parameters Missing!!");
		width = l.get(0);
		//this.start = startPoint;
		area = this.getArea();
		perimeter = this.getPerimeter();
		origin = this.getOrigin();
		this.shapeType = ShapeType.SQUARE.toString();
	}
	
	/* This method calculates Area.
	 * return Area.
	 */
	public double getArea() {
		area = width * width;
		return area;
	}
	
	/* This method calculates Perimeter.
	 * return Perimeter.
	 */
	public double getPerimeter() {
		perimeter = 4 * width;
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
		if(p.x <= (origin.x + width) && p.y <= (origin.y + width))
			return true;
		else
			return false;
	}
}
