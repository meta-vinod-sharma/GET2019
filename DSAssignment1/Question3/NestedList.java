
/* This is a component class. The list of LinkedList objects are implemented using linked list.
 * This class is implemented for storing Multi Variate Variable.
 * This class consists of methods for adding new node to main list.
 * @author Vinod
 */
public class NestedList {
	
	NestedNode nestedHead;
	NestedNode newNestedNode;

	/* This method adds new node to the parent list which stores reference of Linkedlist which is given
	 * as parameter.
	 * @param l reference of list to add.
	 * @return true if node is added successfully to the list.
	 */
	public boolean addNestedNode(LinkedList l){
		newNestedNode = new NestedNode();
		newNestedNode.list = l;
		newNestedNode.next = null;
		
		// When list is empty.
		if(nestedHead == null)
			nestedHead = newNestedNode;
		else{
			NestedNode temp = nestedHead;
			while(temp.next != null)
				temp = temp.next;
			temp.next = newNestedNode;
		}
		return true;
	}
}
