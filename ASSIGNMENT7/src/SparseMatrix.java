import java.util.ArrayList;
public final class SparseMatrix {
	private int rows;
	private int columns;
	private ArrayList<Element> sparseMatrix=new ArrayList<Element>(); //list of non zero elements in the sparse matrix
	/*
	 * This is a constructor to set the initialize the initial properties of the object
	 */
	SparseMatrix(ArrayList<Element> sparseMatrix,int rows,int columns)
	{
		this.sparseMatrix = sparseMatrix;
		this.rows=rows;
		this.columns=columns;
	}
	/*
	 * This is a getter method for the element list
	 * @return <ArrayList<Element> returns the private field sparseMatrix
	 */
	public ArrayList<Element> getSparseMatrix()
	{
		ArrayList sparseMatrixList = (ArrayList) this.sparseMatrix.clone();
		return sparseMatrixList;
	}
	
	/*
	 * This method returns the transpose of the input sparse matrix 
	 * 
	 * @param inputMatrix     //inputMatrix is the object of SparseMatrix containing the input sparse matrix 
	 * along with the number of rows and columns whose transpose is to be evaluated
	 * 
	 * @return SparseMatrix    //returns the object of the SparseMatrix class consisting the transpose of the input matrix
	 */
	public static SparseMatrix evaluateTranspose(SparseMatrix inputMatrix) 
	{
		ArrayList<Element> sparseMatrixTranspose=new ArrayList<Element>();
		//interchanging row index and column index
		for(Element numElement:inputMatrix.sparseMatrix)
		{
			Element temp=new Element(numElement.column, numElement.row, numElement.value);
			sparseMatrixTranspose.add(temp);
		}
		SparseMatrix result=new SparseMatrix(sparseMatrixTranspose,inputMatrix.columns,inputMatrix.rows);
		return result;
	}
	
	/*
	 * This method checks if the input Matrix is symmetric or not
	 * 
	 * @param inputMatrix    // inputMatrix is the object of SparseMatrix containing the input sparse matrix 
	 * along with the number of rows and columns which is to be checked
	 * 
	 * @return boolean   //returns true if the input matrix is symmetric otherwise returns false
	 */
	public static boolean checkIfSymmetric(SparseMatrix inputMatrix)
	{
		int k = 0;
		int count = 0;
		SparseMatrix sparseMatrixTranspose = evaluateTranspose(inputMatrix);
		ArrayList<Element> transpose = sparseMatrixTranspose.sparseMatrix;
		for(Element element:inputMatrix.sparseMatrix)
		{
			int row1 = element.row;
			int column1 = element.column;
			int value = element.value;
			k=0;
			//checking if the row index,column index,value of the transpose matrix and the input matrix are same'
			for(int j=k;j<transpose.size();j++)
			{
				k++;
				Element transposeElement = transpose.get(j);
				if(row1 == transposeElement.row && column1 == transposeElement.column && value == transposeElement.value)
				{
					count++;
					transpose.remove(j);
				}
			}
		}
		//if every element of the input matrix found its match in the transpose matrix the value of count will be 
		//equal to the size of the input matrix and hence symmetric
		
		if(count == inputMatrix.sparseMatrix.size())
			return true;
		else
			return false;
	}
	/*
	 
	 * @param row   //row the row index of the element whose value is to be found
	 * @param column  // column is the column index of the element whose value is to be found
	 * @param matrix   //matrixis the input matrix in which the element is to be searched at the specified position
	 * @return int     //returns the value at the specified position.If the element is absent,returns zero.
	 */
	public static int valueAtPosition(int row, int column, ArrayList<Element> matrix)
	{
		int elementValue = 0;
		for(Element element:matrix)
		{
			int rowIndex = element.row;
			int columnIndex = element.column;
			if(rowIndex == row && columnIndex == column)
				elementValue = element.value;
		}
		return elementValue;
	}
	/*
	 *@param matrix   //matrix the sparse matrix in which the position of element is to be searched
	 *@param checkElement   //checkElement  is the element to be searched
	 *@return int      //returns the index of the element in the list if present in the input matrix else returns -1 
	 */
	public static int indexOfElementAtSamePosition(Element checkElement, ArrayList<Element> matrix)
	{
		int row1 = checkElement.row;
		int column1 = checkElement.column;
		int i = 0;
		for(Element element:matrix)
		{
			if(element.row == row1 && element.column == column1)
				return i;
			i++;
		}
		return -1;
	}
	/*
	 * This method evaluates the sum of two input sparse matrix
	 * 
	 * @param inputMatrix1 is the first input sparse matrix
	 * @param inputMatrix2 is the first second sparse matrix
	 * @return SparseMatrix is the object of class Sparse Matrix containing the sum matrix of the two input matrix
	 */
	public static SparseMatrix addMatrix(SparseMatrix inputMatrix1, SparseMatrix inputMatrix2)
	{
		ArrayList<Element> matrix1 = inputMatrix1.sparseMatrix;
		ArrayList<Element> matrix2 = inputMatrix2.sparseMatrix;
		ArrayList<Element> sumMatrix = matrix1;
		if(!((inputMatrix1.rows == inputMatrix2.rows) && (inputMatrix2.columns == inputMatrix2.columns)))
		{
			System.out.println("Unequal number of rows and columns of the two input matrices");
			throw new AssertionError("Unequal number of rows and columns of the two input matrices");
		}
		else if((inputMatrix1.rows == 0)||(inputMatrix1.columns == 0)||(inputMatrix2.rows == 0)||(inputMatrix2.columns == 0))
		{
			System.out.println("Either of the Arrays is empty");
			throw new AssertionError("Either of the Arrays is empty");
		}
		else
		{
			for(Element element:matrix2)
			{
				int index = indexOfElementAtSamePosition(element,sumMatrix);
				//if element is not present then add it to the list as it is
				if(index == -1)
					sumMatrix.add(element);
				else
				{
					//if present then add the elements and then insert it in the list after removing the previous element
					Element matrix1Element = sumMatrix.remove(index);
					matrix1Element.value += element.value;
					sumMatrix.add(index, matrix1Element);
				}
			}
		}
		SparseMatrix result = new SparseMatrix(sumMatrix, inputMatrix1.rows, inputMatrix2.columns);
		return result;
	}
	/*
	 * This method evaluates the product of two input sparse matrix 
	 * 
	 * @param inputMatrix1 is the first input sparse matrix
	 * @param inputMatrix2 is the first second sparse matrix
	 * @return SparseMatrix is the object of class Sparse Matrix containing the product matrix of the two input matrix
	 */
	public static SparseMatrix multiplyMatrix(SparseMatrix inputMatrix1, SparseMatrix inputMatrix2)
	{
		ArrayList<Element> matrix1 = inputMatrix1.sparseMatrix;
		ArrayList<Element> matrix2 = inputMatrix2.sparseMatrix;
		ArrayList<Element> productMatrix = new ArrayList<Element>();
		Element product;
		if(!(inputMatrix1.columns == inputMatrix2.rows))
			throw new AssertionError("Not fit for multiplication");
		else if((inputMatrix1.rows == 0)||(inputMatrix1.columns == 0)||(inputMatrix2.rows == 0)||(inputMatrix2.columns == 0))
		{
			System.out.println("Either of the Arrays is empty");
			throw new AssertionError("Either of the Arrays is empty");
		}
		else
		{
			int row1 = inputMatrix1.rows;
			int row2 = inputMatrix2.rows;
			int column1 = inputMatrix1.columns;
			int column2 = inputMatrix2.columns;
			for(int i = 0; i < row1; i++)
			{
				for(int j = 0; j < column2; j++)
				{
					int sum = 0;
					boolean flag = false;
					for(int k = 0; k < column1; k++)
					{  
						int temp1 = valueAtPosition(i, k, matrix1);
						int temp2 = valueAtPosition(k, j, matrix2);
						//if any one of the element is zero do not calculate the sum
						if(!(temp1 == 0||temp2 == 0))
						{
							flag = true;
							sum += temp1 * temp2;
						}
					}
					
					if(flag)
					{
						product = new Element(i,j,sum);
						productMatrix.add(product);
					}
				}
			}
		}
		SparseMatrix result = new SparseMatrix(productMatrix, inputMatrix1.rows, inputMatrix2.columns);
		return result;
	}
}
class Element
{
	//element of the sparse matrix consists of its row index,column index and value in the sparse matrix
	int row;
	int column;
	int value;
	Element(int row, int column, int value)
	{
		this.row = row;
		this.column = column;
		this.value=value;
	}
}

