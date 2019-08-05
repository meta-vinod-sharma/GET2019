package Ques2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vinod
 *
 */
public class CountUnique {
	Map<String, Integer> cache = new HashMap<String, Integer>();//for creating cache
	
	/**
	 * @param string
	 * @return number of unique element
	 * This function simply counting the unique element of string and if string is present in cache it will give result using cache
	 */
	public int count(String string) {
		int uniqueCount = 0;
		if (cache.containsKey(string)) {
			System.out.print("Cached :");
			return cache.get(string);
		} else {
			ArrayList<Character> temp = new ArrayList<Character>();
			for (int i = 0; i < string.length(); i++) {
				temp.add(string.charAt(i));
			}
			for (int i = 0; i < temp.size(); i++) {
				int freq = Collections.frequency(temp, temp.get(i));
				if (freq == 1) {
					uniqueCount++;
				}
			}
		}
		cache.put(string, uniqueCount);
		return uniqueCount;
	}
}
