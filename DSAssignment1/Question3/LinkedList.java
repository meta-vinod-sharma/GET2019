
/* This is a component class. It is an implementation of LinkedList data structure.
 * This class consists of methods for creating, rotating & detecting loop in LinkedList.
 * @author Vinod
 */
public class LinkedList {

	Node head;
	Node newNode;
	
	public boolean addNode(int a){
		newNode = new Node();
		newNode.data = a;
		newNode.next = null;
		
		if(head == null){
			head = newNode;
		}else{
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = newNode;
		}
		return true;		
	}
	
	
	
	
	
}
