package Ques1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* This is a component class. This class implemented using the functionality of n-ary tree data structure
 * for maintaining file hierarchy of a Virtual Command Prompt.
 * This class consists of methods used for maintaining file hierarchy and traversing through
 * each folder or sub-folder of a directory.
 * @author Vinod
 */
public class Tree {
	
	// Instance variables.
	Node root;
	Node currentDirectory;
	Node node;
	Node newNode;
	String currentPath;
	
	// Constructor.
	public Tree() {
		root = new Node();
		root.fileName = "root";
		currentDirectory = root;
		root.subDirectoryList = new ArrayList<Node>();
		root.subDirectoryMap = new HashMap<String, Node>();
		currentPath = "root";
	}
	
	
	/* This method is used to make directory with the given parameter name.
	 * @param newFileName to create new directory.
	 * @return true if the directory with the given name is created successfully, false 
	 * otherwise.
	 */
	public boolean makeDirectory(String newFileName) {
		if(newFileName == null)
			return false;
		if((currentDirectory != null) && (currentDirectory.subDirectoryMap != null) 
				&& currentDirectory.subDirectoryMap.containsKey(newFileName)) {
			System.out.println("Directory with name \"" + newFileName + "\" already exist.");
			return false;
		}
		newNode = new Node();
		newNode.parent = currentDirectory; 	
		newNode.fileName = newFileName;
		if(currentDirectory.subDirectoryList == null) {
			currentDirectory.subDirectoryList = new ArrayList<Node>();
			currentDirectory.subDirectoryMap = new HashMap<String, Node>();
		}
		currentDirectory.subDirectoryList.add(newNode);
		currentDirectory.subDirectoryMap.put(newFileName, newNode);
		System.out.println("Directory created : " + newFileName + " under parent : " + currentDirectory.fileName );
		return true;		
	}
	
	/* This method uses the functionality of method displayTree() to print the directory 
	 * i.e all its folders and sub-folders in form of a tree.
	 */
	public void tree() {
		this.displayTree(root, 2);
	}
	
	
	/* This method is used to print all the folders and sub-folders present in root directory.
	 * This method recursively prints the directory tree.
	 * @param root directory.
	 * @param levels variable used for printing purpose.
	 */
	private void displayTree(Node root, int levels) {
		System.out.print("\u2514\u2500"); 
		System.out.println(root.fileName);
		if(this.isDirectory(root)) {
			levels = levels + 1;
			for(Map.Entry<String, Node> n : root.subDirectoryMap.entrySet()) {
				System.out.print("\u251c");   //H
				for(int i = 1; i < levels; i++)
					System.out.print(" ");
				displayTree(n.getValue(), levels);
			}
			levels = levels - 1;
		}
	}
	
	
	/* This method is used to change the current directory, ot to traverse to a parentn folder or 
	 * sub-folder of the current directory.
	 * @param directoryName
	 */
	public void changeDirectory(String directoryName) {
		if((!currentDirectory.fileName.equals("root")) 
				&& (!currentDirectory.parent.subDirectoryMap.containsKey(directoryName)) 
				&& currentDirectory.fileName.equals(directoryName)) {
			System.out.println("You are already present in specified directory!!");
			return;
		}
		if((currentDirectory.fileName.equals("root")) && directoryName.equals("cd..")) {
			System.out.println("You are in root Directory!! No pareny diretory is available.");
			return;
		}
		if(directoryName.equals("cd..")) {
			currentDirectory = currentDirectory.parent;
			System.out.println("Directory Changed to: " + currentDirectory.fileName);
			
			int start = currentPath.lastIndexOf("/");
			StringBuilder builder = new StringBuilder();
			currentPath = builder.append(currentPath.substring(0, start)).toString();
			return;
		}
		if(currentDirectory.parent != null && currentDirectory.parent.subDirectoryMap.containsKey(directoryName)) {
			currentDirectory = currentDirectory.parent.subDirectoryMap.get(directoryName);
			System.out.println("Directory Changed to: " + currentDirectory.fileName);
			currentPath = currentPath.concat("/" + currentDirectory.fileName);
			return;
		}
		if( currentDirectory.subDirectoryMap != null && currentDirectory.subDirectoryMap.containsKey(directoryName)) {
			currentDirectory = currentDirectory.subDirectoryMap.get(directoryName);
			System.out.println("Directory Changed to: " + currentDirectory.fileName);
			currentPath = currentPath.concat("/" + currentDirectory.fileName);
			return;
		}
		System.out.println("The system cannot find the path specified.");
	}
	
	
	/* This method checks that the given node is a directory or not.
	 * @param n node.
	 * @return true if the given node is a directory, false otherwise.
	 */
	public boolean isDirectory(Node n) {
		if(n.subDirectoryList == null) 
			return false;
		if(n.subDirectoryMap == null)
			return false;
		return true;
	}
	
	
	/* This method is used to show the current directory.
	 * @return the reference to the current directory.
	 */
	public Node showCurrentDirectory() {
		System.out.print( currentPath + ": >");
		return currentDirectory;
	}
	
	
	/* This method prints the information such as File name, Number of Subfiles and Timestamp of
	 * the given directory.
	 * @param n reference to the directory.
	 */
	public void printList(Node n) {   
		Node currentParent;
		if(n.fileName.equals("root"))
			currentParent = root;
		else
			currentParent = n.parent;
		
		System.out.println("File Name \t No. of Subfiles \t\t TimeStamp");
		
		if(this.isDirectory(n)) {
			int filesInDirectory;
			for(Map.Entry<String, Node> dir : currentParent.subDirectoryMap.entrySet()) {
				if(dir.getValue().subDirectoryMap == null)
					filesInDirectory = 0;
				else
					filesInDirectory = dir.getValue().subDirectoryMap.size();
				System.out.println(dir.getValue().fileName + "\t\t\t" + filesInDirectory + "\t\t" + dir.getValue().timeStamp);
			}
			System.out.print(" ");
		}
		System.out.println();
	}
	
	/* This is a helper method and  is implemented for searching operation. This method recursively finds 
	 * for a fileName given as a parameter in the current directory as well as inside all its sub-directories.
	 * @param fileName to search.
	 * @param tempDirectory directory in which searching is to be done.
	 * @return path of the file found.
	 */
	public String findRecursive(String fileName, Node tempDirectory) {
		String path = "";
		if(this.isDirectory(tempDirectory) && tempDirectory.subDirectoryMap.containsKey(fileName)) {
			path = "//" + fileName + "\n";
			return path;
		}
		if(this.isDirectory(tempDirectory)) {
			Map<String, Node> subFolders = tempDirectory.subDirectoryMap;
			for(Map.Entry<String, Node> directory : subFolders.entrySet()) {
				
				tempDirectory = directory.getValue();	
				String tempPath = findRecursive(fileName, tempDirectory);
				if(!tempPath.equals(""))
					path = path + "//" +  tempDirectory.fileName + tempPath ;
			}
		}
		if(fileName.equals(tempDirectory.fileName))
				return tempDirectory.fileName;
		return path;
	}
	
	
	/* This method makes a class to method findRecursive() to recursively search for a file named with
	 * the given fileName as parameter.
	 * @param fileName
	 * @param currentDirectory
	 * @return path if file is found, otherwise null string.
	 */
	public String find(String fileName,Node currentDirectory) {
		String path = this.findRecursive(fileName, currentDirectory);
		if(path.equals(""))
			return "No such file found in current directory!";
		return path;
	}
}
