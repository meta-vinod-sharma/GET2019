import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestBinarySearch {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {new int[] {2,5,8,12,16,23,38}, 16, 4},{new int[] {}, 1, -1},{new int[] {2,5,8,12,16,23,38}, 89, -1},{new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 9, 9}, {new int[] {2,8,9,22,23,38}, 8, 1}, {new int[] {20,25,38,42,49,54,138}, 138, 6}});
    }

    SearchingOperation searchingOperationObj = new SearchingOperation();
    private int[] fInput1;
    private int fInput2;
    private int fExpected;

    public TestBinarySearch(int[] input1,int input2,int expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, searchingOperationObj.binarySearch(fInput1, fInput2));
    }
}