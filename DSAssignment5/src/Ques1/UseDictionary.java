package Ques1;

import java.util.List;
import java.util.Map;

/* This is a Application class. It is designed for managing dictionary.
 * @author Vinod
 */
public class UseDictionary {
	
	public static void main(String args[]) throws Exception {
		
		// Object of BSTNode.
		BSTNode newNode = new BSTNode();
		
		// Initializing key value.
		newNode.key = 9;
		newNode.value = "Nine";
		
		// Object of Binary Search Tree for maintaining dictionary.
		BinarySearchTree bTree = new BinarySearchTree(newNode);
		
		// GetJSON object for fetching data.
		GetJSON gJson = new GetJSON();
		
		// Fetching data from JSON in ArrayList of BSTNode.
		List<BSTNode> data = gJson.getJSON();
		
		// Inserting data to Binary Search tree.
		for(BSTNode node : data) {
			bTree.add(node);
		}
		
		// Getting corresponding value of key specified.
		System.out.println("\nCorresponding Value : " + bTree.getValue(bTree.root, 4));
		
		// Fetching sorted key-value pairs.
		Map<Integer, String> sorted = bTree.sort(bTree.root);
		
		// Printing sorted key-value pairs.
		System.out.println("\n\nSorted\n");
		for(Map.Entry<Integer, String> entry: sorted.entrySet()) {
			System.out.println("Key : " + entry.getKey() + "\t Value : " + entry.getValue());			
		}
		
		// Fetching sorted key-value pairs between given range k1 & k2.
		Map<Integer, String> sortedInRange = bTree.sortInRange(bTree.root, 3, 8);
		
		// Printing sorted key-value pairs between given key range k1 & k2.
		System.out.println("\n\nSorted In  given Range\n");
		for(Map.Entry<Integer, String> entry: sortedInRange.entrySet()) {
			System.out.println("Key : " + entry.getKey() + "\t Value : " + entry.getValue());			
		}
		
		// Deleting a node with key = 3.
		bTree.delete(bTree.root, 3);
		
		System.out.println("\nAfter deleting 3, printing entries Inorder.");
		bTree.inorder(bTree.root);
	}
}
