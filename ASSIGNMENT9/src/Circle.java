import java.util.List;

/* This is a component class. It extends abstract class Shapes.
 * This class overrides some methods from its super class.
 * @author Vinod
 */
public class Circle extends Shapes {
	
	// Instance variables.
	int radius;
	
	// Constructor.
	public Circle(Point startPoint, List<Integer> l) {
		super(startPoint);
		if(l.get(0) == null)
			throw new AssertionError("Parameters Missing!!");
		radius = l.get(0);
		area = this.getArea();
		perimeter = this.getPerimeter();
		origin = this.getOrigin();
		this.shapeType = ShapeType.CIRCLE.toString();
	}
	
	/* This method calculates Area.
	 * return Area.
	 */
	public double getArea() {
		perimeter =  2 * (double)Math.PI * radius;
		return 0;
	}
	
	/* This method calculates Perimeter.
	 * return Perimeter.
	 */
	public double getPerimeter() {
		area = (double)Math.PI * radius * radius;
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
		double distance = Math.pow((p.x - origin.x), 2) + Math.pow((p.x - origin.x), 2);
		if(distance < radius)
			return true;
		else
		return false;
	}
}
