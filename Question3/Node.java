package Question3;

/**
 * It is a class of nodes
 * @author Vinod
 *
 */
public class Node {
    Employee data;
	Node next;

	/**
	 * It is a constructor used to initialize a node.
	 * @param data value of data field of node.
	 */
	Node(Employee data) {
		this.data = data;
		this.next = null;
	}

}