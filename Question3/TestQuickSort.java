package Question3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * It is a test case for quickSort() of QuickSortLinkedList
 * @author Vinod
 *
 */
public class TestQuickSort {
	
	@Test
	public void testQuickSort() {
		QuickSortLinkedList linkedlist = new QuickSortLinkedList();
		Employee employee1 = new Employee("Vinod",22,15000);
		Employee employee2 = new Employee("Bhupenra",22,32000);
		Employee employee3 = new Employee("Surender",22,25000);
		Employee employee4 = new Employee("Vinay",21,25000);
		linkedlist.add(employee1);
		linkedlist.add(employee2);
		linkedlist.add(employee3);
		linkedlist.add(employee4);
		linkedlist.quickSort(linkedlist.head, linkedlist.rear);
		QuickSortLinkedList expectedLinkedlist = new QuickSortLinkedList();
		expectedLinkedlist.add(employee2);
		expectedLinkedlist.add(employee4);
		expectedLinkedlist.add(employee3);
		expectedLinkedlist.add(employee1);
		
		Node currentNodeExpected = expectedLinkedlist.head;
		Node currentNodeActual = linkedlist.head;
		while(currentNodeExpected != null)
		{
			assertEquals(currentNodeExpected.data.getEmpName(), currentNodeActual.data.getEmpName());
			currentNodeExpected = currentNodeExpected.next;
			currentNodeActual = currentNodeActual.next;
		}
	}
	@Test(expected=AssertionError.class)
	public void testQuickSortForEmptyList() {
		QuickSortLinkedList linkedlist = new QuickSortLinkedList();
		linkedlist.quickSort(linkedlist.head, linkedlist.rear);
	}

}