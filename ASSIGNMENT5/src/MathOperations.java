/**
 * @author Vinod
 *
 *         class MathOperation implements lcm And Hcf for two numbers;
 * 
 *
 */
public class MathOperations {

	static int common = 0; // it stores lcm of two numbers
	static int flag = 0;

	/**
	 * @param firstNumber
	 * @param secondNumber
	 * @return   returns lem of both numbers
	 */
	public int lcm(int firstNumber, int secondNumber) {

		if (flag == 0) {
			flag = 1;
			if (firstNumber < secondNumber)
				common = secondNumber;
			else
				common = firstNumber;
		}

		if (common % firstNumber == 0 && common % secondNumber == 0) {
			return common;
		}
		common++;
		lcm(firstNumber, secondNumber);
		flag = 0;
		return common;
	}

	/**
	 * @param firstNumber
	 * @param secondNumber
	 * @return  returns HCF of both numbers
	 */
	public int hcf(int firstNumber, int secondNumber) {
		if (firstNumber > secondNumber) {
			if (secondNumber != 0) {
				return hcf(secondNumber, firstNumber % secondNumber);
			} else {
				return firstNumber;
			}
		} else {
			if (firstNumber != 0) {
				return hcf(firstNumber, secondNumber % firstNumber);
			} else {
				return secondNumber;
			}
		}
	}
}
