
/* This is a component class. The list of lists is implemented using linked list.
 * This class is implemented for storing Multi Variate Variable.
 * This class consists of methods for storing and finding degree of polynomial.
 * @author Vinod
 */
public class MultiVarPoly {
	int numberOfVariable;
	NestedList expression = new NestedList();
	LinkedList inList;

	// Constructor
	public MultiVarPoly(int array[], int numberOfVariable){
		this.numberOfVariable = numberOfVariable;
		this.addPoly(array, numberOfVariable);
	}
	
	/* This method is used to add each term of polynomial to linkedList and add its
	 * reference to nested list's node.
	 * @param array polynomial
	 * @param n number of variables in polynomial equation.
	 * @return true if polynomial is added successfully, false otherwise.
	 */
	public boolean addPoly(int array[], int numberOfVariable){
		if(array == null || array.length == 0){
			System.out.println("Input array is null");
			return false;
		}
		for(int i = 0; i < array.length; i = i + numberOfVariable + 1){
			inList = new LinkedList();
			for(int j = i ; j < i + numberOfVariable + 1; j++ ){
				if(j >= array.length)
					continue;
					inList.addNode(array[j]);
			}
			expression.addNestedNode(inList);
		}
		return true;
	}
	
	/* This method finds the degree of given polynomial.
	 * @return degree, -1 otherwise.
	 */
	public int degree(){
		NestedNode tempNN = this.expression.nestedHead;
		int degree = -1;
		while(tempNN != null){
			Node tempNode = tempNN.list.head.next;
			int sum = 0;
			while(tempNode != null){
				sum = sum + tempNode.data;
				tempNode = tempNode.next;
			}
			if(sum > degree)
				degree = sum;
			tempNN = tempNN.next;
		}
		return degree;
	}
	
	// This method prints the given list of lists.
	public void show(){
		NestedNode tempNesNode = this.expression.nestedHead;
		while(tempNesNode != null){
			
			Node tempNode = tempNesNode.list.head;
			while(tempNode != null){
				System.out.print(tempNode.data+" ");
				tempNode = tempNode.next;
			}
			tempNesNode = tempNesNode.next;
			System.out.println();
		}
	}
}