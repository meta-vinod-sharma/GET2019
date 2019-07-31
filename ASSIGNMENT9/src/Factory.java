import java.util.List;

/* This is a component class. This class is design to create objects of different shapes based on user requirements.
 * @author Vinod
 */
public class Factory {

	// Creating Screen object.
	public static Screen scn = new Screen();
	
	/* This method creates shape object and places that shape on Screen.
	 * @return true if shape is successfully placed on screen, false otherwise;
	 */
	public static boolean createShape(String shapeType,Point startPoint, List<Integer> parameterList) {
		
		if(parameterList.size() == 0)
			throw new AssertionError("No parameters passed!");
				
		switch(shapeType.toUpperCase()){
		
		// Creating object of shape Circle.
		case "CIRCLE" :
			Circle c = new Circle(startPoint , parameterList);
			scn.addShape(c);
			break;
			
		// Creating object of shape Square.
		case "SQUARE":
			Square sq = new Square(startPoint , parameterList);
			scn.addShape(sq);
			break;
			
		// Creating object of shape Triangle.
		case "TRIANGLE":
			Triangle tr = new Triangle(startPoint , parameterList);
			scn.addShape(tr);
			break;
		
		// Creating object of shape Rectangle.
		case "RECTANGLE":
			Rectangle rect = new Rectangle(startPoint , parameterList);
			scn.addShape(rect);
			break;
			
		case "POLYGON":
			break;
			
			default:
				System.out.println("Invalid Shape name.");
		}
		return true;
	}
	
	/* This method is used to sort shapes on screen according to user requirements.
	 * Sorting can be done based on Area, Perimeter, Distance from origin & Timestamp. 
	 */
	public static void sortShapes(String sortType) {
				
		switch(sortType.toUpperCase()) {
		
		// To sort shapes in ascending order of Area.
		case "AREA" :
			Factory.scn.sortByArea();
			break;
		
		// To sort shapes in ascending order of Perimeter.	
		case "PERIMETER" :
			Factory.scn.sortByPerimeter();
			break;
			
		// To sort shapes in ascending order of Distance from origin.	
		case "DISTANCE" :
			Factory.scn.sortByDistanceFromOrigin();
			break;
		
		// To sort shapes in ascending order of Timestamp.
		case "TIMESTAMP":
			Factory.scn.sortByTimestamp();
			break;
		
		// For invalid input.
		default :
				System.out.println("INVALID INPUT:");
		}
		
		// To print shapes in selected order.
		Factory.scn.show();
	}
	
	// Delete shapes of given specific type.
	public static boolean deleteAllShapesOfType(String shapeType) {
		scn.deleteShapesOfSpecificType(shapeType);
		return true;
	}
		
	public static boolean shapesEnclosingPoint(Point p) {
		if(p == null){
			System.out.println("Point not found!!");
			return false;
		}
		List<Shapes> enclosing = scn.shapesEnclosingPoint(p);
		for(Shapes s : enclosing) {
			System.out.println("Enclosed = "+s.shapeType+s.shapeId);
		}
		return true;
	}
}
