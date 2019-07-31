import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAddPoly {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { new int[] { 2, 1, 1, 0, 3, 2 }, 1, true }, { new int[] { 2, 1, 1, 0, 3, 2 }, 2, true },
                 { new int[] { 4, 9, 2, 2, 3, 2, 2, 2, 2, 88, 1, 0, 1, 0, 0, 0}, 3, true }, 
                 { new int[] {  }, 0, false },
                 });
    }

    private int fInput1[];
    private int fInput2;
    private boolean fExpected;

    public TestAddPoly(int input1[], int input2, boolean expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on methods addPoly().
    @Test
	public void test() {
    	MultiVarPoly obj = new MultiVarPoly(fInput1, fInput2);
    	assertEquals(fExpected, obj.addPoly(fInput1, fInput2));
	}
}