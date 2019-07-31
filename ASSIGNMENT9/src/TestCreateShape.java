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
public class TestCreateShape {
	/* This is a method which consists of a set of input and expected output.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{ Shape.ShapeType.CIRCLE, new Point(1,1), new ArrayList<Integer>() { {add(3);} } , true}, 
        		{ Shape.ShapeType.RECTANGLE, new Point(2,2), new ArrayList<Integer>() { {add(2); add(4); } } , true},
        		{ Shape.ShapeType.SQUARE, new Point(3,3), new ArrayList<Integer>() { {add(3); } } , true},
        		{ Shape.ShapeType.TRIANGLE, new Point(4,4), new ArrayList<Integer>() { {add(3); } } , true},
        		{ Shape.ShapeType.CIRCLE, new Point(5,5), new ArrayList<Integer>() { {add(8);} } , true},
        		{ Shape.ShapeType.RECTANGLE, new Point(6,6), new ArrayList<Integer>() { {add(5); add(5); } } , true},
        		{ Shape.ShapeType.RECTANGLE, new Point(7,7), new ArrayList<Integer>() { {add(9); } } , false},
        		{ Shape.ShapeType.RECTANGLE, null, new ArrayList<Integer>() { {add(9); } } , false},
        		{ Shape.ShapeType.TRIANGLE, null, new ArrayList<Integer>() {  } , false},
                });
    }

    private boolean fExpected;
    private String shapeType;
    private Point p;
    private List<Integer> parameterList;

    public TestCreateShape(Shape.ShapeType shapeType, Point p, List<Integer> param, boolean expected) {
        this.fExpected = expected;
        this.shapeType = shapeType.toString();
        this.p = p;
        this.parameterList = param;
    }
    
    // This method is used to run test cases on method createShape().
    @Test
	public void test() {
		assertEquals(fExpected, Factory.createShape(shapeType, p, parameterList));
	}
}