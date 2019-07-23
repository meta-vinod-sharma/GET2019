import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestIsSubSet {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { new int[] { 1, 4, 5, 3, 5, 4, 1 }, false }, 
                 {  new int[] { 77, 9, 8, 3, 12 }, false }, 
                 });
    }

    private int fInput[];
    private boolean fExpected;
    int array[] = new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    InSet set2 = new InSet(array);

    public TestIsSubSet(int input[], boolean expected) {
        this.fInput = input;
        this.fExpected = expected;
    }
    
    /* This method is used to run test cases on methods isSubset.
     */
    @Test
	public void test() {
    	assertEquals(fExpected, set2.isSubset(new InSet(fInput)));
	}
}