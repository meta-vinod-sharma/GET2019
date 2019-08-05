package Ques3;

import java.util.Stack;

/* This is a component class. This class consist of method to calculate molecular mass of given
 * chemical compound.
 * @author Vinod
 */
public class OrganicChemistry {
	
	// Stack data structure for calculating molecular mass.
	Stack<Integer> stk = new Stack<Integer>();
	
	/* This method calculated the molecular mass of the given chemical compound.
	 * @param formula of chemical compound.
	 * @return mass.
	 */
	public int getMass(String formula) {
		if(formula == null)
			return -1;
		formula = formula.toUpperCase();
		int mass = 0;
		for(int i = 0; i < formula.length(); i++) {
			
			// For Alphabets
			if(this.isAlphabet(formula.charAt(i))){
				stk.push(MolecularMass.massOfElement.get(formula.charAt(i)) );
				continue;
			}
			
			// For Number
			if(this.isNumber(formula.charAt(i))) {
				int j = 0;
				String strBase = "";
				while( (i+j) < formula.length() && this.isNumber(formula.charAt(i + j)) ) {
					strBase =  strBase.concat(formula.charAt(i + j) + "");
					j++;
				}
				int intBase = Integer.parseInt(strBase);
				int temp = stk.pop() * intBase;
				stk.push(temp);
				i = i + j - 1;
				continue;
			}
			
			// For opening parenthesis.
			if(formula.charAt(i) == '(') {
				stk.push(MolecularMass.massOfElement.get(formula.charAt(i)) );
				continue;
			}
			
			// For closing parenthesis.
			if(formula.charAt(i) == ')') {
				int sum = 0;
				while(!stk.isEmpty() && stk.peek() != 0)  {
					sum += stk.pop();
				}
				// Pop out "(" from stack
				stk.pop(); 									
				stk.push(sum);
			}
		}
		// Pop out the calculated masses and add it to the variable mass.
		while(!stk.isEmpty()) 
			mass += stk.pop();
		
		return mass;
	}
	
	/* Checks for the given parameter is a number.
	 * @param s character.
	 * @return true if input is number, false otherwise.
	 */
	public boolean isNumber(char s) {
		return (s >= 49 && s <= 57);
	}
	
	/* Checks for the given parameter is an Alphabet.
	 * @param s character.
	 * @return true if input is alphabet, false otherwise.
	 */
	public boolean isAlphabet(char s){
		return (s >= 65 && s <= 90);
	}
}
