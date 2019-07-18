import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLcm {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {5, 7, 35}, {32, 60, 480}, {104, 169, 1352}, {30, 33, 330} });
    }

    MathOperations mathOperationsObj = new MathOperations();
    private int fInput1;
    private int fInput2;
    private int fExpected;

    public TestLcm(int input1,int input2, int expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, mathOperationsObj.lcm(fInput1, fInput2));
    }
}