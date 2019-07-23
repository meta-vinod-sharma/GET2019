import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Vinod
 *
 */
@RunWith(Parameterized.class)
public class TestSize {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                  {new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 } , 12},  {new int[] { 7, 6, 5, 4, 3, 2, 1, 0 } , 8} , {new int[] {  } , 0}, {new int[] { 11, 10, 9, 8, 7, 6 } , 6}});
    }

    private int fInput[];
    private int fExpected;
   

    public TestSize(int input[], int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on methods size.
    @Test
	public void test() {
    	assertEquals(fExpected, new InSet(fInput).size());
	}
}