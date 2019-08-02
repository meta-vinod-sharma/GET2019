package ques1;

import java.util.NoSuchElementException;

/**
 * @author Vinod
 *
 */
public class Stack {
	Node top;

	class Node {
		char data;
		Node next;

		Node() {
			this.next = null;
		}
	}

	Stack() {
		this.top = null;
	}

	/**
	 * @param data   data to be inserted into stack
	 */
	public void stackInsert(char data) {
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
	public char pop() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		Node ptr = top;
		top = ptr.next;

		return ptr.data;
	}

	/**
	 * @return  returns top element from stack
	 */
	public char peek() {
		if (top == null) {
			return 'a';
		} else
			return top.data;
	}

	/**
	 * @return  returns true if stack is empty else false
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * @param choice  choice of operation
	 * @return   returns precedence of operator
	 */
	int Prec(char choice) {
		switch (choice) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
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
	 * @param expr  takes String expression as input
	 * @return
	 */
	public String infixToPostfix(String expr) {
		String result = new String("");
		Stack stack = new Stack();
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				result += c;

			} else if (c == '(') {
				stack.stackInsert(c);

			} else if (c == ')') {

				while (!stack.isEmpty() && stack.peek() != '(') {
					result = result + stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression"; // invalid expression
				else
					stack.pop();
			} else {
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
					if (stack.peek() == '(')
						return "Invalid Expression";
					result += stack.pop();
				}
				stack.stackInsert(c);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}

}
