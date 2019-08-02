package ques1;

/**
 * @author Vinod
 *
 *class PostfixEvaluation  contains methods for evaluating posytfix expression
 */
public class PostfixEvaluation {
	
	static Node top;

	static class Node {
		int data;
		Node next;

		Node() {
			this.next = null;
		}
	}

	/**
	 * @param data   data to be inserted into stack
	 */
	public static void stackInsert(int data) {
		Node nptr = new Node();
		nptr.data = data;
		if (top == null)
			top = nptr;
		else {
			nptr.next = top;
			top = nptr;

		}
	}

	/**
	 * @return  return top element and delete from stack
	 */
	public static int pop() {
		if (isEmpty())
			return 0;
		int data = top.data;
		top = top.next;
		return data;
	}

	/**
	 * @return  returns top element from stack
	 */
	public static int peek() {
		if (top == null) {
			return 0;
		} else
			return top.data;
	}

	/**
	 * @return  returns true if stack is empty else false
	 */
	public static boolean isEmpty() {
		return top == null;
	}

	public void display() {
		// check for stack underflow
		if (top == null) {
			System.out.printf("\nStack Underflow");
		} else {
			Node temp = top;
			while (temp != null) {
				System.out.printf("%d->", temp.data);
				temp = temp.next;
			}
		}
	}

	/**
	 * @param exp  takes a postFix expression as input
	 * @return   returns the final evaluated value for expression
	 */
	static int evaluatePostfix(String exp) {

		// Scan all characters one by one
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			// If the scanned character is an operand (number here),
			// push it to the stack.
			if (Character.isDigit(c)) {
				stackInsert(c - '0');
			}

			// If the scanned character is an operator, pop two
			// elements from stack apply the operator
			else {
				int val1 = pop();
				int val2 = pop();

				switch (c) {

				case '+':
					int ans = val2 + val1;
					stackInsert(ans);
					break;

				case '-':
					int ans1 = val2 - val1;
					stackInsert(ans1);
					break;

				case '/':
					int ans3 = val2 / val1;
					stackInsert(ans3);
					break;

				case '*':
					int ans4 = val2 * val1;
					stackInsert(ans4);
					break;
				case '^':
					int ans5 = (int) Math.pow(val2, val1);
					stackInsert(ans5);
					break;
				}
			}
		}
		int last = pop();
		return last;
	}

	public static void main(String[] args) {
		Stack c = new Stack();
		String exp = "1+2*(2^3-4)-9";
		String res = c.infixToPostfix(exp);
		System.out.println("infix " + res);
		System.out.println("postfix evaluation: "
				+ PostfixEvaluation.evaluatePostfix(res));
	}

}
