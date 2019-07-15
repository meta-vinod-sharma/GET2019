import java.util.*;

public class HexCalc implements Calculator {

	/**
	 * @param s1
	 * @return decimal conversion of string
	 */
	public int HexToDecimal(String s1) {

		String digits = "0123456789ABCDEF";
		s1 = s1.toUpperCase();
		int val = 0;
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d; // 16 is base
		}
		return val;

	}

	/**
	 * @param num
	 * @return decimal equivalent of hexadecimal
	 */
	public String DecimalToHex(int num) {

		int rem;
		String hex = "";
		char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		while (num > 0) {
			rem = num % 16;
			hex = hexchars[rem] + hex;
			num = num / 16;
		}
		return hex;
	}

	/**
	 * @param s1 , s2
	 * @return addition of two hexadecimal numbers
	 */
	@Override
	public String add(String s1, String s2) {

		int sum = HexToDecimal(s1) + HexToDecimal(s2);
		return DecimalToHex(sum);
	}

	/**
	 * @param s1 , s2
	 * @return subtraction of two hexadecimal numbers
	 */
	@Override
	public String sub(String s1, String s2) {

		int sub = HexToDecimal(s1) - HexToDecimal(s2);
		return DecimalToHex(sub);
	}

	/**
	 * @param s1 ,s2
	 * @return multiplication of two hexadecimal numbers
	 */
	@Override
	public String mul(String s1, String s2) {
		int mul = HexToDecimal(s1) * HexToDecimal(s2);
		return DecimalToHex(mul);
	}

	/**
	 * @param s1 ,s2
	 * @return division of two hexadecimal numbers
	 */
	@Override
	public String div(String s1, String s2) {
		int div = HexToDecimal(s1) / HexToDecimal(s2);
		return DecimalToHex(div);
	}

	/**
	 * @param s1 ,s2
	 * @return true if two hexadecimal numbers are equal else false
	 */
	@Override
	public boolean isEqual(String s1, String s2) {
		if (s1.compareTo(s2) == 0) // function call to compareTo function
			return true;
		else
			return false;
	}

	/**
	 * @param s1,s2
	 * @return true if first hexadecimal number is greater than second else false
	 */
	@Override
	public boolean isGreater(String s1, String s2) {
		if (s1.length() > s2.length())
			return true;
		if (s1.length() < s2.length())
			return false;
		else {
			int i = 0;
			while (i < s1.length()) {
				if (s1.charAt(i) > s2.charAt(i))
					return true;
				i++;
			}

		}
		return false;
	}

	/**
	 * @param s1 ,s2
	 * @return true if first hexadecimal number is lesser than second else false
	 */
	@Override
	public boolean isLesser(String s1, String s2) {
		if (s1.length() < s2.length())
			return true;
		if (s1.length() > s2.length())
			return false;
		else {
			int i = 0;
			while (i < s1.length()) {
				if (s1.charAt(i) > s2.charAt(i))
					return false;
				i++;
			}

		}
		return false;

	}

	public static void main(String[] args) {

		HexCalc hc = new HexCalc();
		String hex1, hex2;
		Scanner scan = new Scanner(System.in);
		do {
			System.out
					.println("Enter your choice \n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.To check if first number is Greater\n6.To check if first number is smaller\n7.TO check if both are equal\n8.HexaDecimal to Decimal Conversion\n9.Decimal to HexaDecimal Conversion\n10.Exit");
			int choice = scan.nextInt();
			switch (choice) {
			// Adding  two hex numbers
			case 1:
				System.out.println("Enter two hex numbers");
				hex1 = scan.next();
				hex2 = scan.next();
				System.out.println("Addition = " + hc.add(hex1, hex2));
				break;
			// Subtract two hex numbers	
			case 2:
				System.out.println("Enter two hex numbers");
				hex1 = scan.next();
				hex2 = scan.next();
				System.out.println("Subtraction = " + hc.sub(hex1, hex2));
				break;
			// Multiply two hex number
			case 3:
				System.out.println("Enter two hex numbers");
				hex1 = scan.next();
				hex2 = scan.next();
				System.out.println("Multiply = " + hc.mul(hex1, hex2));
				break;
			// Division of  two hex numbers
			case 4:
				System.out.println("Enter two hex numbers");
				hex1 = scan.next();
				hex2 = scan.next();
				System.out.println("Division = " + hc.div(hex1, hex2));

				break;
			// Checking greater number
			case 5:
				System.out.println("Enter two hex numbers");
				hex1 = scan.next();
				hex2 = scan.next();
				System.out.println(hc.isGreater(hex1, hex2));
				break;
            // Cheacking lesser number
			case 6:
				System.out.println("Enter two hex numbers");
				hex1 = scan.next();
				hex2 = scan.next();
				System.out.println(hc.isLesser(hex1, hex2));
				break;
				// Cheacking equility of two jhex number
			case 7:
				System.out.println("Enter two hex numbers");
				hex1 = scan.next();
				hex2 = scan.next();
				System.out.println(hc.isEqual(hex1, hex2));
				break;
			// Conversion of hex number into decimal number
			case 8:
				System.out.println("Enter a hex numbers");
				hex1 = scan.next();
				System.out.println("Decimal Conversion of Hex No. = "
						+ hc.HexToDecimal(hex1));
				break;
				// Conversion of decimal number into hex number
			case 9:
				System.out.println("Enter a Decimal numbers");

				int num = scan.nextInt();
				System.out.println(" Hex Conversion of Decimal No. = "
						+ hc.DecimalToHex(num));
				break;
			case 10:
				System.exit(0);
			default:
				System.out.print("Wrong input");

			}
		} while (true);
	}

}
