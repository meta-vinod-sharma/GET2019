import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestIsMember {
    /* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 11, true },
                 { 0, true },
                 { 66, false },
                 { 99, false },
                 });
    }

    private int fInput;
    private boolean fExpected;
    int array[] = new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

    public TestIsMember(int input, boolean expected) {
        this.fInput = input;
        this.fExpected = expected;
    }
    
    /* This method is used to run test cases on methods maxMirror().
     */
    @Test
	public void test() {
		assertEquals(fExpected, new InSet(array).isMember(fInput));
	}
}