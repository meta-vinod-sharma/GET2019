public class LinkedList {

	Node head;

	public static void main(String argd[]) {
		LinkedList list = new LinkedList();
		LinkedList subList = new LinkedList();
		LinkedList rotatedList = new LinkedList();

		insertNode(list, 1);
		insertNode(list, 2);
		insertNode(list, 3);
		insertNode(list, 4);
		insertNode(list, 5);
		insertNode(list, 6);
		insertNode(list, 7);
		insertNode(list, 8);
		insertNode(list, 9);

		list.printLinkedList(list);

		System.out.println("\n------------");
		subList = createSubList(list, 1, 9);
		System.out.println("SubList of Given List");
		subList.printLinkedList(subList);

		System.out.println("\n------------");

		System.out.println("Rotated List");
		rotatedList = rotateAndAddList(subList, list, 6, 1, 9);
		rotatedList.printLinkedList(rotatedList);
		rotatedList.head.next.next.next.next = rotatedList.head; 
		System.out.println();
		System.out.println(detectLoop(list));
		System.out.println(detectLoop(rotatedList));

	}

	public static LinkedList insertNode(LinkedList list, int data) {

		Node newNode = new Node(data);

		if (list.head == null) {
			list.head = newNode;
		} else {
			Node node = list.head;

			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
		return list;
	}

	public void printLinkedList(LinkedList list) {
		Node node = list.head;

		while (node != null) {
			System.out.print("-->" + node.data);
			node = node.next;
		}
	}

	public static LinkedList createSubList(LinkedList list, int left, int right) {

		LinkedList list1 = new LinkedList();
		Node node = list.head;
		int count = 1;

		while (count != left) {
			node = node.next;
			count++;
		}

		while (count != right + 1) {
			list1 = insertNode(list1, node.data);
			node = node.next;
			count++;
		}
	

		return list1;
	}

	public static LinkedList rotateAndAddList(LinkedList list, LinkedList initialList, int N, int left, int right) {

		LinkedList finalList = new LinkedList();
		int i = 0;
		while (i < N) {

			Node node1 = list.head;
			Node node2 = node1;
			while (node2.next != null) {
				node2 = node2.next;
			}
			node2.next = node1;
			list.head = node1.next;
			node1.next = null;
			i++;

		}
		
		
		Node node = initialList.head;
		int count = 1;

		while (count != left) {
			finalList = insertNode(finalList, node.data);
			node = node.next;
			count++;
		}
		Node node1 = list.head;
		while(node1 != null){
			finalList = insertNode(finalList, node1.data);
			node1 = node1.next;
			node = node.next;

		}
	
		while(node != null){
			finalList = insertNode(finalList, node.data);
			node = node.next;
		}
		
		
		return finalList;
	}
	public static boolean detectLoop(LinkedList list){
		
		Node node = list.head;
		Node node1 = node.next;
		while(node.next != null){
			
			while(node1.next != null){
				
				if(node == node1){
					return true;
				}
				node1 = node1.next;
			}
			node = node.next;
		}
		
		
		return false;
	}

}
