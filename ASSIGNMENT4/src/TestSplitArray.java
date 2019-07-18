import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSplitArray {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {  new int[] {1, 1, 1, 2, 1}, 3}, { new int[] {2, 1, 1, 2, 1}, -1}, {new int[] {10, 10}, 1}});
    }

    ArrOperation arrOperationObj = new ArrOperation();
    private int fInput[];

    private int fExpected;

    public TestSplitArray(int[] input, int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, arrOperationObj.splitArray(fInput));
    }
}