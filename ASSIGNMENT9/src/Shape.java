
/* This is an interface. It consists of abstract methods.
 * It also consists of enum Shape.
 * @author Vinod
 */
public interface Shape {
	
	// Enum
	public enum ShapeType{
		SQUARE,
		TRIANGLE,
		RECTANGLE,
		CIRCLE;
	}
	
	// Abstract methods.
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point p);
}
