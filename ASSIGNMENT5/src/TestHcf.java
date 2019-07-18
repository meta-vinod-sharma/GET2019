import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestHcf {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {60, 366, 6}, {852, 1065, 213}, {270, 180, 90}, {9, 3, 3}, {396, 300, 12}});
    }

    MathOperations mathOperationsObj = new MathOperations();
    private int fInput1;
    private int fInput2;
    private int fExpected;

    public TestHcf(int input1,int input2, int expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, mathOperationsObj.hcf(fInput1, fInput2));
    }
}