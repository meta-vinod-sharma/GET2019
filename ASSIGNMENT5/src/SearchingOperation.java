public class SearchingOperation {

	public int binarySearch(int[] numbersArray, int numToSearch,
			int startIndex, int endIndex) {
		int mid = (startIndex + endIndex) / 2;
		if (numbersArray[mid] == numToSearch) {
			return mid;
		}
		if (numbersArray[mid] > numToSearch) {
			endIndex = mid - 1;
			return binarySearch(numbersArray, numToSearch, startIndex, endIndex);

		} else {
			startIndex = mid + 1;
			return binarySearch(numbersArray, numToSearch, startIndex, endIndex);
		}

	}

	static int index = 0;
	static int position;
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
