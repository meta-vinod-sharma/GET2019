package Ques3;

import java.util.HashMap;
import java.util.Map;

/* This is a component class.
 * The molar masses of elements are stored in this class.
 * @author Vinod
 *
 */
public class MolecularMass {

	// Map for storing molar mass of elements as key value pairs.
	static Map<Character, Integer> massOfElement = new HashMap<Character, Integer>();
	
	// Static block for storing elements along with molar mass as a key-value pair.
	static {
		massOfElement.put('H', 1);
		massOfElement.put('C', 12);
		massOfElement.put('O', 16);
		massOfElement.put('(', 0);
	};
}
