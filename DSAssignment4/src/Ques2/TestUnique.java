package Ques2;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestUnique {
	@Test
	public void testCount1() {
		String input = "IINNNAVddd";
		CountUnique count = new CountUnique();
		int result = count.count(input);
		int expectedData = 1;
		assertEquals(expectedData, result);
	}

	@Test
	public void testCount2() {
		String input = "VINod";
		String input2 = "VINod";
		CountUnique count = new CountUnique();
		count.count(input);
		int result = count.count(input2);
		int expectedData = 5;
		assertEquals(expectedData, result);
	}

}
