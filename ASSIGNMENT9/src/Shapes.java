import java.sql.Timestamp;

/* This is a component class. This is an abstract class and implements interface Shape.
 * It class overrides some method from Shape interface.
 * @author Vinod
 */
public abstract class Shapes implements Shape {

	// Instance Variables.
	static int counter = 1;
	final int shapeId;
	Point origin;
	double area;
	double perimeter;
	double distanceFromScreenOrigin;
	Timestamp timeStamp;
	String shapeType;
	
	/* Parameterised constructor.
	 * @param start coordinate.
	 */
	public Shapes(Point start) {
		if(start == null)
			throw new AssertionError("No start point found!!");
		shapeId = counter++;
		origin = start;
		timeStamp = new Timestamp(System.currentTimeMillis()); 
		this.distanceFromScreenOrigin = distanceFromScreenOrigin();
	}
	
	/* This method calculates the distance between Screen and Shape origin.
	 * @return distance 
	 */
	public double distanceFromScreenOrigin() {
		distanceFromScreenOrigin = Math.pow( (Math.pow(origin.x - Screen.screenOrigin.x, 2) + Math.pow(origin.y - Screen.screenOrigin.y, 2)), 0.5);
		distanceFromScreenOrigin = Math.round( distanceFromScreenOrigin * 100 ) / 100;
		return distanceFromScreenOrigin;
	}
}
