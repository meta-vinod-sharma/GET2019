package Ques1;

import java.util.HashMap;
import java.util.Map;

/* This is a component class. This class uses Binary Search tree for implementing Dictionary.
 * Each entry is stored as key value pair at each node of BST.
 * It consists of some methods for adding and sorting entries.
 * @author Vinod
 */
public class BinarySearchTree implements Dictionary {
	
	public BinarySearchTree(BSTNode newNode) {
		this.add(newNode);
	}

	// Instance variables.
	BSTNode root;
	int flag = 0;
	 
	 // Sorted map of key-value pairs.
	 Map<Integer, String> sortedMap = new HashMap<Integer, String>();
	 
	 // Sorted key value pairs between keys k1 & k2.
	 Map<Integer, String> sortedRangeMap = new HashMap<Integer, String>();

	 // Add key value pair to dictionary.
	@Override
	public void add(BSTNode newNode) {
		if (root == null)
			root = newNode;
		else {
			BSTNode current = root;
			BSTNode prev = root;
			while (current != null) {
				prev = current;
				if (newNode.key > current.key)
					current = current.right;
				else
					current = current.left;
			}
			if (prev.key > newNode.key)
				prev.left = newNode;
			else
				prev.right = newNode;
		}
	}

	
	/* This method return the corresponding value of the key specified.
	 * @param root node of BST.
	 * @param key whose value is to find.
	 * @return String value of the specified key.
	 */
	public String getValue(BSTNode root, int key) {
		if (root.key > key)
			return getValue(root.left, key);
		if (root.key < key)
			return	getValue(root.right, key);
		else
			return root.value;
	}
	
	// Deleting a key value pair from the dictionary. Each node of BST represents entry in dictionary.
	@Override
	public BSTNode delete(BSTNode root, int key) {
		if (root == null)
			return null;
		else if (key < root.key) {
			
			root.left = delete(root.left, key);
		}
		else if (key > root.key) {
			
			root.right = delete(root.right, key);
		}
		else {
			// When deleted node is leaf node.
			if (root.left == null && root.right == null)
				return null;

			// When left child of deleted node doesn't exist.
			else if (root.left == null)
				root = root.right;

			// When left child of deleted node doesn't exist.
			else if (root.right == null)
				root = root.left;

			// When both child of deleted node exist.
			else {
				BSTNode successorOfRoot = findSuccessor(root.right, root);
				root.key = successorOfRoot.key;
				root.value = successorOfRoot.value;
				root.right = delete(root.right, successorOfRoot.key);
			}
		}
		return root;
	}

	/* This method sorts the key value pairs stored at each node of BST, referred as BSTNode.
	 * return sorted HashMap of key value pairs.
	 */
	@Override
	public Map<Integer, String> sort(BSTNode root) {
		if (root.left != null)
			sort(root.left);
		
		// Adding key value to map.
		sortedMap.put(root.key, root.value);
		if (root.right != null)
			sort(root.right);
		return sortedMap;
	}

	/* This method sorts the given entry in ascending order based on the given key range.
	 * k1 lower range
	 * k2 upper range
	 * Both keys k1 and k2 included.
	 * return HashMap of key value pairs.
	 */
	@Override
	public Map<Integer, String> sortInRange(BSTNode root, int k1, int k2) {
		if (root.left != null)
			sortInRange(root.left, k1, k2);
		
		// Adding key value pair to map.
		if(root.key >= k1 && root.key <= k2)
			sortedRangeMap.put(root.key, root.value);
		
		// If the keys get out of range.
		if(root.key > k2)
			return sortedRangeMap;
		if (root.right != null)
			sortInRange(root.right, k1, k2);
		return sortedRangeMap;
	}


	/* Helper function. Used to find immediate successor of specified node or entry in Dictionary.
	 * @param root reference of 
	 * @param prevRoot reference of previous root.
	 * @return immediate successor node or Dictionary entry.
	 */
	public BSTNode findSuccessor(BSTNode root, BSTNode prevRoot) {
			if(root.left != null) 
				root = findSuccessor(root.left, root);
				
		return root;
	}

	// Printing sorted list of key value pair using inorder traversal.
	public void inorder(BSTNode root) {
		if (root.left != null)
			inorder(root.left);
		System.out.print(root.key + "-" + root.value + " ");
		if (root.right != null)
			inorder(root.right);
	}
}
