package ques2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCircularQueue {
	@Test
	public void testAddElement() {
		QueueOperations queueObj = new QueueOperations(6);
		int[] data = { 2, 3, 4, 5, 6, 7};
		for(int i = 0; i < 6 ; i++) {
			queueObj.addElementToQueue(data[i]);
		}
		int[] result = queueObj.show();
		int[] expectedData = { 2, 3, 4, 5, 6, 7};
		assertArrayEquals(expectedData, result);
	}
	
	@Test
	public void testDequeue() {
		QueueOperations queueObj1 = new QueueOperations(6);
		int[] data = { 2, 3, 4, 5, 6, 7};
		for(int i = 0; i < 6 ; i++) {
			queueObj1.addElementToQueue(data[i]);
		}
	     queueObj1.deQueue();
	     queueObj1.deQueue();
		int[] result1 = queueObj1.show();
		int[] expectedData = {0, 0, 4, 5, 6, 7};
		assertArrayEquals(expectedData, result1);
	}
	
	@Test
	public void testIsFull() {
		QueueOperations queueObj2 = new QueueOperations(6);
		int[] data = { 2, 3, 4, 5, 6, 7};
		for(int i = 0; i < 6 ; i++) {
			queueObj2.addElementToQueue(data[i]);
		}
		boolean result1 = queueObj2.fullQueue();;
		assertEquals(true, result1);
	}
	
	@Test
	public void testIsEmpty() {
		QueueOperations queueObj2 = new QueueOperations(6);
		boolean result1 = queueObj2.emptyQueue();;
		assertEquals(true, result1);
	}
}
