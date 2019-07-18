import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestFitXY {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {  new int[] {5, 4, 9, 4, 9, 5}, 4, 5, new int[] {9, 4, 5, 4, 5, 9}}, { new int[] {1, 4, 1, 5}, 4, 5, new int[] {1, 4, 5, 1}}, {new int[] {1, 4, 1, 5, 5, 4, 1}, 4, 5, new int[] {1, 4, 5, 1, 1, 4, 5}}});
    }

    ArrOperation arrOperationObj = new ArrOperation();
    private int fInput[];
    private int fX;
    private int fY;
    private int fExpected[];

    public TestFitXY(int[] input, int X, int Y, int[] expected) {
        this.fInput = input;
        this.fX = X;
        this.fY = Y;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertArrayEquals(fExpected, arrOperationObj.fixXY(fInput, fX, fY));
    }
}