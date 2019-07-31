import java.util.Comparator;

/* This is a component class and implements Comparator interface.
 * @author Vinod
 */
public class Compare implements Comparator <Shapes>{

	/* This method is used to compare two Shapes objects.
	 * return -1, 0 or 1 to say if it is less than, equal, or greater to the other.
	 */
	@Override
	public int compare(Shapes o1, Shapes o2) {
	return 0;
	}
}

/* This is a component class and implements Comparator interface.
 * @author Vinod
 */
class CompareArea implements Comparator<Shapes> {

	/* This method is used to compare two Shapes objects.
	 * return -1, 0 or 1 to say if it is less than, equal, or greater to the other.
	 */
	@Override
	public int compare(Shapes s1, Shapes s2) {
		return (int)s1.area - (int)s2.area ;
	}
}

/* This is a component class and implements Comparator interface.
 * @author Vinod
 */
class ComparePerimeter implements Comparator<Shapes> {

	/* This method is used to compare two Shapes objects.
	 * return -1, 0 or 1 to say if it is less than, equal, or greater to the other.
	 */
	@Override
	public int compare(Shapes s1, Shapes s2) {
		return (int)s1.perimeter - (int)s2.perimeter;
	}
}

/* This is a component class and implements Comparator interface.
 * @author Vinod
 */
class CompareDistanceFromOrigin implements Comparator<Shapes> {
	
	/* This method is used to compare two Shapes objects.
	 * return -1, 0 or 1 to say if it is less than, equal, or greater to the other.
	 */
	@Override
	public int compare(Shapes s1, Shapes s2) {
		return (int)s1.distanceFromScreenOrigin - (int)s2.distanceFromScreenOrigin;
	}
}

/* This is a component class and implements Comparator interface.
 * @author Vinod
 */
class CompareTimestamp implements Comparator<Shapes> {

	/* This method is used to compare two Shapes objects.
	 * return -1, 0 or 1 to say if it is less than, equal, or greater to the other.
	 */
	@Override
	public int compare(Shapes s1, Shapes s2) {
		return s1.timeStamp.compareTo(s2.timeStamp);
	}
}
	
	
