package ques1;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestEvaluate {
	@Test
	public void testPostfix1() {
		Stack c = new Stack();
		PostfixEvaluation p = new PostfixEvaluation();
		String input = "1+2*(2^5-4)-9";
		String res = c.infixToPostfix(input);
		@SuppressWarnings("static-access")
		int output = p.evaluatePostfix(res);
		int expectedData = 48;
		assertEquals(expectedData, output);
	}
	
	@Test
	public void testPostfix2() {
		Stack c = new Stack();
		PostfixEvaluation p = new PostfixEvaluation();
		String input = "1+2*(2^5-4)";
		String res = c.infixToPostfix(input);
		@SuppressWarnings("static-access")
		int output = p.evaluatePostfix(res);
		int expectedData = 57;
		assertEquals(expectedData, output);
	}
}
