import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMaxMirror {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {  new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7}, { new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2}, {new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3}, {new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7}, {new int[] { 1, 2, 1, 2, 3, 3, 4, 3, 3, 2, 1 }, 9}});
    }

    ArrOperation arrOperationObj = new ArrOperation();
    private int fInput[];

    private int fExpected;

    public TestMaxMirror(int[] input, int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, arrOperationObj.findMaxMirror(fInput));
    }
}