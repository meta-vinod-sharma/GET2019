import java.util.ArrayList;
import java.util.List;

/* This is a component class. It implements interface Cloneable.
 * This class overrides some methods from its super class.
 * @author Vinod
 */
public class Screen implements Cloneable {
	
	// Instance variables.
	public static final Point screenOrigin = new Point(0,0);
	List<Shapes> shapeList = new ArrayList<Shapes>();

	/* This method adds Shapes to Screen.
	 * return true if shape is added successfully to screen, false otherwise.
	 */
	public boolean addShape(Shapes s) {
		if(s == null)
			return false;
		else {
			shapeList.add(s);
			return true;
		}
	}
	
	/* This method deletes a Shape from Screen.
	 * return true if shape is deleted successfully from screen, false otherwise.
	 */
	public boolean deleteShape(int shapeId) {
		for(Shapes s : shapeList) {
			if(s.shapeId == shapeId) {
				shapeList.remove(s);
				return true;
			}
		}
		System.out.println("Shape not found on screen!");
		return false;		
	}
	
	/* Deletes all the Shapes of given type from Screen.
	 * @param shapeType
	 * @return true if Shapes are deleted successfully, false otherwise.
	 */
	public boolean deleteShapesOfSpecificType(String shapeType) {
		List<Shapes> removeList = new ArrayList<Shapes>();
		if(shapeType == null)
			return false;
		
		for(Shapes s1 : this.shapeList) {
			if(s1.shapeType.equals(shapeType.toUpperCase()))			
				removeList.add(s1);
		}
		if(removeList.size() == 0){
			System.out.println("No Shape of such type found!!");
			return false;
		}
		shapeList.removeAll(removeList);
		return true;
	}
	
	/* Sorts all the Shapes on the screen by Area in ascending order.
	 * @return sorted List.
	 */
	public List<Shapes> sortByArea() {
		System.out.println("YYO");
		this.shapeList.sort(new CompareArea());
		return shapeList;
	}
	
	/* Sorts all the Shapes on the screen by Perimeter in ascending order.
	 * @return sorted List.
	 */
	public List<Shapes> sortByPerimeter() {
		this.shapeList.sort(new ComparePerimeter());
		return shapeList;
	}
	
	/* Sorts all the Shapes on the screen by Distance from Origin in ascending order.
	 * @return sorted List.
	 */
	public List<Shapes> sortByDistanceFromOrigin() {
		this.shapeList.sort(new CompareDistanceFromOrigin());
		return shapeList;
	}
	
	/* Sorts all the Shapes on the screen by Timestamp in ascending order.
	 * @return sorted List.
	 */
	public List<Shapes> sortByTimestamp() {
		this.shapeList.sort(new CompareTimestamp());
		return shapeList;
	}
	
	// This method display Shapes present on Screen.
	public void show() {
		System.out.println("ShapeType\t Area\t Perimeter\t Distance Timestamp");
		for(Shapes sh : shapeList) {
			System.out.println(sh.shapeType+"\t"+sh.area+"\t"+sh.perimeter+"\t"+
		sh.distanceFromScreenOrigin+"\t"+sh.timeStamp);
		}
	}
	
	/* This method checks for Shapes enclosing a given point.
	 * @param p point to check.
	 * @return list of Shapes enclosing given point.
	 */
	public List<Shapes> shapesEnclosingPoint(Point p){
		List<Shapes> enclosing = new ArrayList<Shapes>();
		
		if(p == null)
			throw new AssertionError("Point Not Found");
		
		for(Shapes s : this.shapeList) {
			if(s.isPointEnclosed(p))
				enclosing.add(s);
		}
		return enclosing;
	}
}
