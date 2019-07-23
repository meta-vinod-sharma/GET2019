import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAddPoly {
	/*
	 * This is a method which consists of a set of input and expected output
	 * value set.
	 * 
	 * @return
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { new int[] { 2, 1, 1, 0, 3, 2 },
				new int[] { 1, 1, 8, 8, 2, 2, },
				new int[] { 8, 8, 5, 2, 3, 1, 1, 0 } }, });
	}

	private int fInput1[];
	private int fInput2[];
	private int fExpected[];

	public TestAddPoly(int input1[], int input2[], int expected[]) {
		this.fInput1 = input1;
		this.fInput2 = input2;
		this.fExpected = expected;
	}

	// This method is used to run test cases on methods addPoly().
	@Test
	public void test() {
		assertArrayEquals(fExpected,
				Poly.addPoly(new Poly(fInput1), new Poly(fInput2)).getPoly());
	}

}