/**
 * @author Vinod
 *   
 *   class SearchingOperation implements binary searching and linear serching using recursion
 */
public class SearchingOperation {

	static int startIndex;
	static int endIndex;
	static int midIndex;
	static int flag = 0;
	
	
	/**
	 * @param numbersArray
	 * @param numToSearch
	 * @return         returns index of numToSearch in numbersArray and if not founded then returns -1
	 */
	public int binarySearch(int[] numbersArray, int numToSearch) {
		if(flag == 0){
			startIndex = 0;
			endIndex = numbersArray.length - 1;
			midIndex = (startIndex + endIndex) / 2;
			flag = 1;
		}
		midIndex = (startIndex + endIndex) / 2;
		if(startIndex > endIndex) {
			flag = 0;
			return -1;
		}
		if (numbersArray[midIndex] == numToSearch) {
			flag = 0;
			return midIndex;
		}
		if (numbersArray[midIndex] > numToSearch) {
			endIndex = midIndex - 1;
			return binarySearch(numbersArray, numToSearch);

		} else {
			startIndex = midIndex + 1;
			return binarySearch(numbersArray, numToSearch);
		}

	}

	static int index = 0;
	static int position;
	/**
	 * @param numbersArray
	 * @param numToSearch
	 * @return    returns index of numToSearch in numbersArray and if not founded then returns -1
	 */
	public int linearSearch(int[] numbersArray, int numToSearch) {
		position = index;
		if(position >= numbersArray.length){
			index = 0;
			return -1;
		}
		if (numbersArray[position] == numToSearch) {
			index = 0;
			return position;
		} else {
			index++;
			return linearSearch(numbersArray, numToSearch);
		}
	}

}
