package Ques3;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMolecularMass {
	/* This is a method which consists of a set of input and expected output value set.
     * @return
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "C(oH)2", 46}, { "CHOC(CH3)3", 86}, { "(CH4OCH3)2", 94}, { "(C22H1)13H2O", 3463},
                 {"H2OCO4(CO2)14", 710}, {"", 0}, {null , -1}
                 });
    }

    private String fx;
    private int fExpected;

    public TestMolecularMass(String str, int expected) {
        this.fx = str;
        this.fExpected = expected;
    }
    
    // This method is used to run test cases on method getMass().
    @Test
	public void test() {
		assertEquals(fExpected, new OrganicChemistry().getMass(fx));
	}
}