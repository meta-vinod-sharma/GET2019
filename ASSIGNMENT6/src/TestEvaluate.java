import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEvaluate {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { 2, 17 }, { 4, 57 }, { 8, 209 } });
	}

	private float fInput1;
	private float fExpected;

	int array[] = new int[] { 2, 1, 1, 0, 3, 2 };
	Poly polyObj = new Poly(array);

	public TestEvaluate(int number, float expected) {
		this.fInput1 = number;
		this.fExpected = expected;
	}

	@Test
	public void test() {
		assertEquals(fExpected, polyObj.evaluate(fInput1), 0.00002);
	}
}