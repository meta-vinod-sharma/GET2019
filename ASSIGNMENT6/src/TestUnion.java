import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestUnion {
	/*
	 * This is a method which consists of a set of input and expected output
	 * value set.
	 * 
	 * @return
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{
						new int[] { 2, 4, 3, 3, 3, 5, 5, 5, 5, 7, 6, 8, 9, 9, 9, -1, -19 },
						new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 },
						new int[] { -19, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }
				},
				{       new int[] { 2, 4, 3, 3, 3, 5, 5, 5, 5, 7, 6, 8, 9, 9, 9, -1, -19 },
						new int[] { 4, 2, 5, 3, 5, 4 },
						new int[] { -19, -1, 2, 3, 4, 5, 6, 7, 8, 9 } 
				}  
				});
	}

	private int fInput1[];
	private int fInput2[];
	private int fExpected[];

	public TestUnion(int input1[], int input2[], int[] expected) {
		this.fInput1 = input1;
		this.fInput2 = input2;
		this.fExpected = expected;
	}

	// This method is used to run test cases on methods Union.
	@Test
	public void test() {
		assertArrayEquals(fExpected,
				InSet.union(new InSet(fInput1), new InSet(fInput2)).getSet());
	}
}