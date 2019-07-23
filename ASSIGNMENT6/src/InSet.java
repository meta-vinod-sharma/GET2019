import java.util.ArrayList;
import java.util.List;

/**
 * class InSet Contains methods which implements Union method, IsMember
 * operation , check a subset and complement of set
 * 
 * @author Vinod
 *
 */
public class InSet {
	private int set[];    // Array which contains elements of set
	static int universal[] = new int[1000];      // Its an array which is used for getting complement
	{
		for (int i = 0; i < universal.length; i++)
			universal[i] = i + 1;
	}

	public int[] getSet(){
		return this.set;
	}
	/**
	 *    this is constructor for initialization of values
	 * @param array   input set of values
	 */
	public InSet(int array[]) {
		InSet.sort(array);
		array = InSet.removeDuplicate(array);
		this.set = array;
	}

	
	/**
	 * @param numberToSearch   number which we want to search in set
	 * @return                   returns true if it presents in set else returns false
	 */
	public boolean isMember(int numberToSearch) {
		int array[] = this.set;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numberToSearch)
				return true;
		}
		return false;
	}

	
	/**
	 * @param subset    it is object of class that contaions subset
	 * @return        returns true if it presents in set else returns false
	 */
	public boolean isSubset(InSet subset) {
		int setSubArray[] = subset.set;
		int array[] = this.set;
		int i = 0;
		while (i < array.length) {
			int k = i;
			int count = 0;
			int j = 0;
			while (j < setSubArray.length) {
				if (array[i] == setSubArray[j]) {
					count++;
					j++;
					i++;
				} else {
					break;
				}

			}
			if (count == setSubArray.length) {
				return true;
			}
			i = k + 1;
		}
		return false;
	}

	public int size() {
		return set.length;
	}

	
	/**
	 * @return    returns complemented set Object of InSet class type
	 */
	public InSet getComplement() {
 
		int setArrayA[] = this.set;
		int countA = 0, countU = 0;
		int n = setArrayA.length + universal.length;

		List<Integer> complementList = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (countA == setArrayA.length && countU == universal.length)
				break;
			if (countA == setArrayA.length && countU < universal.length) {
				complementList.add(universal[countU++]);
				continue;
			}
			if (countU == universal.length && countA < setArrayA.length) {
				complementList.add(setArrayA[countA++]);
				continue;
			}
			if (setArrayA[countA] < universal[countU]) {
				complementList.add(setArrayA[countA++]);
				continue;
			}
			if (setArrayA[countA] > universal[countU]) {
				complementList.add(universal[countU++]);
				continue;
			}
			if (setArrayA[countA] == universal[countU]) {
				countA++;
				countU++;
			}
		}
		return new InSet(InSet.listToArray(complementList));
	}

	/**
	 * @param setA   takes input as setA
	 * @param setB    takes input as SetB
	 * @return        returns union set Object of InSet class type
	 */
	public static InSet union(InSet setA, InSet setB) {
		int setArrayA[] = setA.set;
		int setArrayB[] = setB.set;
		int countA = 0, countB = 0;
		int n = setArrayA.length + setArrayB.length;

		List<Integer> unionList = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (countA == setArrayA.length && countB == setArrayB.length)
				break;
			if (countA == setArrayA.length && countB < setArrayB.length) {
				unionList.add(setArrayB[countB++]);
				continue;
			}
			if (countB == setArrayB.length && countA < setArrayA.length) {
				unionList.add(setArrayA[countA++]);
				continue;
			}
			if (setArrayA[countA] < setArrayB[countB]) {
				unionList.add(setArrayA[countA++]);
				continue;
			}
			if (setArrayA[countA] > setArrayB[countB]) {
				unionList.add(setArrayB[countB++]);
				continue;
			}
			if (setArrayA[countA] == setArrayB[countB]) {
				unionList.add(setArrayA[countA]);
				countA++;
				countB++;
			}
		}
		int union[] = InSet.listToArray(unionList);

		return new InSet(union);
	}

	/**
	 * @param array    Takes input array or set
	 * @return        returns sorted set or array
	 */
	private static int[] sort(int array[]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					array[i] = array[i] + array[j];
					array[j] = array[i] - array[j];
					array[i] = array[i] - array[j];
				}
			}
		}
		return array;
	}

	
	/**
	 * @param list   takes List as input
	 * @return       returns array which is converted from list
	 */
	private static int[] listToArray(List<Integer> list) {
		int array[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			array[i] = (int) list.get(i);
		return array;
	}

	
	/**
	 * @param array   takes array as input  
	 * @return        returns array which contains only unique values 
	 */
	private static int[] removeDuplicate(int array[]) {
		List<Integer> distinctList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			while (j < array.length && array[j] == array[i])
				j++;
			distinctList.add(array[i]);
			i = j - 1;
		}
		return InSet.listToArray(distinctList);
	}

	public static void main(String args[]) {
		int arr1[] = new int[] { 2,4, 3, 3, 3, 5, 5, 5, 5, 7, 6, 8, 9, 9, 9, -1,
				-19 };
		int arr2[] = new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int arr3[] = new int[] { 4, 2,5, 3, 5, 4};
		InSet set1 = new InSet(arr1);
		InSet set2 = new InSet(arr2);
		InSet set3 = new InSet(arr3);

		InSet unionSet = InSet.union(set1, set3);

		System.out.println(set1.isSubset(set3));

		for (int i : set1.set)
			System.out.print(" " + i);
		System.out.println("\n\n");

		for (int i : set2.set)
			System.out.print(" " + i);
		System.out.println("\n\n");

		for (int i : unionSet.set)
			System.out.print(" " + i);
		System.out.println();

		InSet complement = set2.getComplement();
		System.out.println("\n\n--> Compliment:");
		for (int i : complement.set)
			System.out.print(" " + i);

	}

}
