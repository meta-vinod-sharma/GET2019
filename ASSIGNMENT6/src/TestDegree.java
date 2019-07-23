import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestDegree {
	/*
	 * This is a method which consists of a set of input and expected output
	 * value set.
	 * 
	 * @return
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 1, 8, 8, 2, 2 }, 8 },
				{ new int[] { 7, 6, 5, 4, 3, 2, 1, 0 }, 6 },
				{ new int[] { 1, 0 }, 0 },
				{ new int[] { 11, 10, 9, 8, 7, 6 }, 10 } });
	}

	private int fInput[];
	private int fExpected;

	public TestDegree(int input[], int expected) {
		this.fInput = input;
		this.fExpected = expected;
	}

	// This method is used to run test cases on methods .
	@Test
	public void test() {
		assertEquals(fExpected, new Poly(fInput).degree());
	}
}