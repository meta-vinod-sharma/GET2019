/**
 * @author Vinod
 *
 *         class ArrOperation implements operations on array As Find max Mirror
 *         in array,Find no of clumps in array, fit X And Y in array And split
 *         an arrayaccordin to eqaual sum
 */
public class ArrOperation {

	/**
	 * @param numbersArray
	 *            it contains interger values
	 * @return return maximum length of mirror
	 * @throws AssertionError
	 */
	public int findMaxMirror(int[] numbersArray) throws AssertionError {
		int length = numbersArray.length;

		if (length == 0) {
			throw new AssertionError("Array is empty");
		}

		int maxLengthMirror = 0; // contaions max length of mirror
		for (int i = 0; i < length; i++) {
			int mirrorLength = 0; // Contaion mirror length
			for (int j = length - 1; j >= 0 && i + mirrorLength < length; j--) {
				if (numbersArray[i + mirrorLength] == numbersArray[j]) {
					mirrorLength++;
				} else {
					if (maxLengthMirror < mirrorLength) {
						maxLengthMirror = mirrorLength;
					}
					mirrorLength = 0;
				}
			}

			maxLengthMirror = Math.max(maxLengthMirror, mirrorLength);
		}

		return maxLengthMirror;
	}

	/**
	 * @param numbersArray
	 *            it contains interger values
	 * @return it returns number of clumps available in array
	 */
	public int noOfClumps(int numbersArray[]) {
		int clumps = 0; // stores no of clumps
		int count = 0;
		int i = 0;
		while (i < numbersArray.length) {
			int temp = numbersArray[i];

			while (i < numbersArray.length && temp == numbersArray[i]) {
				count++;
				i++;
			}
			if (count > 1) {
				clumps++;
				i--;
			}
			count = 0;

		}
		return clumps;

	}

	/**
	 * @param firstIndex
	 *            contain first index of array
	 * @param secondIndex
	 *            contain second index of array
	 * @param numbersArray
	 *            return an array after swapping values
	 */
	public void swap(int firstIndex, int secondIndex, int numbersArray[]) {
		int temp = numbersArray[firstIndex];
		numbersArray[firstIndex] = numbersArray[secondIndex];
		numbersArray[secondIndex] = temp;
	}

	/**
	 * @param numbersArray
	 *            contains integer values
	 * @param X
	 *            contains an integer which is present in array
	 * @param Y
	 *            contains an integer which is present in array And will be
	 *            placed after X
	 * @return returns an array after fitting X and Y
	 */
	public int[] fixXY(int numbersArray[], int X, int Y) {

		int len = numbersArray.length;
		if (len == 0) {
			throw new AssertionError("The array is empty");
		}
		boolean flag = false;
		for (int i = 0; i < len - 1; i++) {
			if (numbersArray[i] == X && numbersArray[i + 1] == X) {
				flag = true;
				break;
			}
		}
		if (flag) {
			throw new AssertionError("The array has two adjacents X values");
		}
		if (numbersArray[len - 1] == X) {
			throw new AssertionError(" X occurs at the last index of array");
		}
		int countX = 0, countY = 0;
		for (int i = 0; i < len; i++) {
			if (numbersArray[i] == X) {
				countX++;
			}
			if (numbersArray[i] == Y) {
				countY++;
			}
		}
		if (countX != countY) {
			throw new AssertionError(
					"there are unequal numbers of X and Y in input array");
		}

		for (int i = 1; i < numbersArray.length - 1; i++) {
			if (numbersArray[i - 1] == X && numbersArray[i] == Y) {
				i++;
				continue;
			}
			if (numbersArray[i - 1] == Y && numbersArray[i] == X
					&& numbersArray[i + 1] != Y) {
				swap(i - 1, i + 1, numbersArray);
				i += 2;
				continue;

			}
			if (numbersArray[i - 1] == X) {
				for (int j = i; j < numbersArray.length; j++) {
					if (numbersArray[j] == Y) {
						swap(j, i, numbersArray);
						break;
					}

				}
			}

		}
		return numbersArray;
	}

	/**
	 * @param numbersArray
	 *            Contains integer values
	 * @return  return index value at which array can be splited ,both sub
	 *         array's sum is equal .if split not possible then return -1
	 */
	public int splitArray(int numbersArray[]) {

		int length = numbersArray.length;
		int sumFirstSubArray = numbersArray[0];
		int sumSecondSubArray = 0;
		for (int i = 1; i < length; i++) {
			sumSecondSubArray += numbersArray[i];
		}
		int i = 1;
		while (sumFirstSubArray != sumSecondSubArray && i < length - 2) {
			sumFirstSubArray += numbersArray[i];
			sumSecondSubArray -= numbersArray[i];
			i++;
		}
		if (sumFirstSubArray == sumSecondSubArray) {
			return i;
		} else {
			return -1;
		}

	}

}
