package Question3;

/**
 * This is a class to implement quick sort on linked list
 * 
 * @author Vinod
 *
 */
public class QuickSortLinkedList {
	Node head = null;
	Node rear = null;

	/**
	 * This is a method to add a new data into the linked list
	 * 
	 * @param data is the value of the new node to be added
	 */
	public void add(Employee data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	/**
	 * This method returns the correct position of the pivot element
	 * 
	 * @param front is the first node of the list
	 * @param last  is the last node of the list
	 * @return returns the pivot node that partitions the list
	 */
	public Node partition(Node front, Node last) {
		Node currentNode;
		Employee temp;
		if (this.head == front) {
			currentNode = null;
		} else {
			currentNode = head;
			while (currentNode.next != front) {
				currentNode = currentNode.next;
			}
		}
		Node i = currentNode;
		Employee pivot = last.data;
		Node j = front;
		while (j != last) {
			if (j.data.getSalary() > pivot.getSalary()
					|| ((j.data.getSalary() == pivot.getSalary()) && (j.data.getAge() < pivot.getAge()))) {
				if (i == null) {
					i = front;
				}
				else {
					i = i.next;
				}
				temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
			j = j.next;
		}
		if (i == null) {
			i = front;
		} else {
			i = i.next;
		}
		temp = i.data;
		i.data = last.data;
		last.data = temp;
		return i;
	}

	/**
	 * This method is used to print the linked list
	 * 
	 * @param front is the first node of the list
	 * @param last  is the last node of the list
	 */
	public void showLinkedList(Node front, Node last) {
		Node currentNode = front;
		while (currentNode != last) {
			System.out.print(currentNode.data.getEmpName() + "-->");
			currentNode = currentNode.next;
		}
		System.out.println(currentNode.data.getEmpName());
	}

	/**
	 * This is the recursive method to perform quick sort
	 * 
	 * @param front is the first element of the list
	 * @param last  is the last element of the list
	 */
	public void recursiveQuickSort(Node front, Node last) {
		if (last == front.next) {
			if ((front.data.getSalary() < last.data.getSalary()) || ((front.data.getSalary() == last.data.getSalary())
					&& (front.data.getAge() < last.data.getAge()))) {
				Employee temp = front.data;
				front.data = last.data;
				last.data = temp;
			}
		} else if (front != null && last != front) {
			Node partition = partition(front, last);
			Node currentNode = front;
			while (currentNode.next != partition) {
				currentNode = currentNode.next;
			}
			recursiveQuickSort(front, currentNode);
			recursiveQuickSort(partition.next, last);
		}
	}

	/**
	 * This method is used to call the recursive quicksort method
	 * 
	 * @param front is the first element of the list
	 * @param last  is the last element of the list
	 */
	public void quickSort(Node front, Node last) {
		if (front == null) {
			throw new AssertionError("Empty linked list");
		} else {
			recursiveQuickSort(front, last);
		}
	}

	/**
	 * The main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		QuickSortLinkedList linkedlist = new QuickSortLinkedList();
		Employee employee1 = new Employee("Vinod", 22, 15000);
		Employee employee2 = new Employee("Bhupendra", 22, 32000);
		Employee employee3 = new Employee("Surender", 22, 25000);
		Employee employee4 = new Employee("Vinay", 21, 25000);
		linkedlist.add(employee1);
		linkedlist.add(employee2);
		linkedlist.add(employee3);
		linkedlist.add(employee4);

		linkedlist.showLinkedList(linkedlist.head, linkedlist.rear);
		linkedlist.quickSort(linkedlist.head, linkedlist.rear);
		linkedlist.showLinkedList(linkedlist.head, linkedlist.rear);
	}

}