import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestDeleteAllShapesOfType {
	/* This is a method which consists of a set of input and expected output.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{ Shape.ShapeType.CIRCLE, true}, 
        		{ Shape.ShapeType.RECTANGLE, true},
        		{ Shape.ShapeType.SQUARE, true},
        		{ Shape.ShapeType.TRIANGLE,  false},
        		{ Shape.ShapeType.CIRCLE,  true},
        		{ Shape.ShapeType.RECTANGLE, true},
                });
    }

    private boolean fExpected;
    private String shapeType;
    private List<Shapes> shapeList = new ArrayList<Shapes>() { {
    		add(new Circle( new Point(1,1), new ArrayList<Integer>() { {add(3); } } ) );
    		add(new Rectangle(new Point(2,2), new ArrayList<Integer>() { {add(2); add(4); } } ) );
    		add(new Square( new Point(3,3), new ArrayList<Integer>() { {add(4); } } ) );
    		add(new Triangle( new Point(4,4), new ArrayList<Integer>() { {add(3); } } ) );
    		add(new Circle( new Point(5,5), new ArrayList<Integer>() { {add(8);} } ) );
    		add(new Rectangle( new Point(6,6), new ArrayList<Integer>() { {add(5); add(5); } } ) );
    		add(new Rectangle( new Point(7,7), new ArrayList<Integer>() { {add(9); add(5);} } ) );
    } };
    
    private Screen sc = new Screen();

    public TestDeleteAllShapesOfType(Shape.ShapeType shapeType,  boolean expected) {
        this.fExpected = expected;
        this.shapeType = shapeType.toString();
    }
    
    // This method is used to run test cases on method deleteShapeOfSpecificType().
    @Test
	public void test() {
    	sc.shapeList = this.shapeList;
    	if(shapeType.equals("TRIANGLE"))									// Deleting shapes of type Triangle from Screen.
    		sc.deleteShapesOfSpecificType(shapeType);
    	
		assertEquals(fExpected, sc.deleteShapesOfSpecificType(shapeType) );
	}
}