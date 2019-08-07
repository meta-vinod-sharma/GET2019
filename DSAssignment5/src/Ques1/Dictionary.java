package Ques1;

import java.util.Map;

/* This is a component class. This class consists of Dictionary interface.
 * It consists of some abstract methods.
 * @author Vinod
 */
public interface Dictionary {

	/* This method is used to add new entry to dictionary. The new entry will be added as a BSTNode object
	 * to Binary Search Tree.
	 * @param newNode object.
	 */
	void add(BSTNode newNode);
	
	/* This method is used to delete an existing entry from the dictionary.
	 * @param root of BST
	 * @param key that is to be deleted.
	 * @return deleted node.
	 */
	BSTNode delete(BSTNode root,int key);
	
	/* Sorts the entries based on key values of BST.
	 * @param root
	 * @return Sorted HashMap of key-value pairs.
	 */
	Map<Integer, String> sort(BSTNode root);
	
	/* This method sorts the entries based on key ranging between given keys k1 & k2 both inclusive.
	 * @param root of BST.
	 * @param k1 key
	 * @param k2 key
	 * @return Sorted HashMap key-value pair.
	 */
	Map<Integer, String> sortInRange(BSTNode root, int k1, int k2);
}
