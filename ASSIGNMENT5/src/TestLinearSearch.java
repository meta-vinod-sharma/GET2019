import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLinearSearch {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {new int[] {2,5,8,12,16,23,38, 345, 32, 87, 9}, 870, -1},{new int[] {6, 1, 7, 5, 9, 15, 2}, 1, 1}, {new int[] {34, 23, 2, 45, 0, 24, 67, 1, 20}, 0, 4}, { new int[] {2,5}, 2, 0}});
    }

    SearchingOperation searchingOperationObj = new SearchingOperation();
    private int[] fInput1;
    private int fInput2;
    private int fExpected;

    public TestLinearSearch(int[] input1,int input2,int expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, searchingOperationObj.linearSearch(fInput1, fInput2));
    }
}