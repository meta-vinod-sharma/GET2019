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
public class TestDeleteShapeById {
	/* This is a method which consists of a set of input and expected output.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{ 1, true}, 
        		{ 1, false},
        		{ 0,  false},
        		{ 99,  false},
                });
    }

    private boolean fExpected;
    private int shapeId;
    private Screen sc = new Screen();
    private List<Shapes> shapeList = new ArrayList<Shapes>() { {
    		add(new Circle( new Point(1,1), new ArrayList<Integer>() { {add(3); } } ) );
    		add(new Rectangle(new Point(2,2), new ArrayList<Integer>() { {add(2); add(4); } } ) );
    		add(new Square( new Point(3,3), new ArrayList<Integer>() { {add(4); } } ) );
    		add(new Triangle( new Point(4,4), new ArrayList<Integer>() { {add(3); } } ) );
    		add(new Circle( new Point(5,5), new ArrayList<Integer>() { {add(8);} } ) );
    		add(new Rectangle( new Point(6,6), new ArrayList<Integer>() { {add(5); add(5); } } ) );
    		add(new Rectangle( new Point(7,7), new ArrayList<Integer>() { {add(9); add(5);} } ) );
    } };
    
    public TestDeleteShapeById(int shapeId,  boolean expected) {
        this.fExpected = expected;
        this.shapeId = shapeId;
    }
    
    // This method is used to run test cases on method deleteShape().
    @Test
	public void test() {
    	sc.shapeList.addAll(this.shapeList);
    	for(Shapes sh : sc.shapeList) {
			System.out.println(sh.shapeType+"\t"+sh.shapeId);}
		assertEquals(fExpected, sc.deleteShape(shapeId) );
    	System.out.println("\n\n\n");
	}
}