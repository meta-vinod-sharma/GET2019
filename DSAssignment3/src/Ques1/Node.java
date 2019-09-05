package Ques1;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/* This is a component class. This class is implemented to maintain the members and functionality
 * of a file system virtually. Here a node represents a folder or sub-folder in a file system.
 * @author Vinod
 */
public class Node {
	
	// Instance variables.
	Node newNode;
	Node parent;
	String fileName;
	List<Node> subDirectoryList;
	Map<String, Node> subDirectoryMap;
	Timestamp timeStamp;
	
	// Constructor
	public Node() {
		timeStamp = new Timestamp(System.currentTimeMillis());
	}
}
