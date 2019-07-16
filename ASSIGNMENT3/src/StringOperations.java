import java.util.Scanner;

/**
 * 
 * this class contain methods to manipulate strings we can perform
 * comparison,reverse of string, upper case to lower case etc
 *
 */

public class StringOperations {

	
	/**
	 * @param str1 
	 * @param str2
	 * @return  0 for different string and 1 for same string
	 */
	public int compareString(String str1, String str2) {

		if (str1.length() != str2.length())
			return 0;
		else {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i))
					return 0;
			}
			return 1;
		}
	}

	/**
	 * @param str
	 * @return reversed String
	 */
	public String reverse(String str) {
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		return reverse;
	}

	/**
	 * @param str
	 * @return  String with exchange case of characters(upper to lower case and lower case into upper case)
	 */
	public String changeCaseOfCharacter(String str) {
		String reverseCase = "";
		for (int i = 0; i < string.length(); i++) {
			if (65 <= string.charAt(i) && string.charAt(i) <= 90)
				reverseCase += (char) (string.charAt(i) + 32);

			if (97 <= string.charAt(i) && string.charAt(i) <= 122)
				reverseCase += (char) ((string.charAt(i) - 32));
			if (string.charAt(i) == ' ')
				reverseCase += " ";
		}
		return reverseCase;
	}

	/**
	 * @param str
	 * @return Return the largest word of a string, If two words are of same length then return last word
	 */
	public String largestWord(String str) {

		String str1 = "";
		int count = 0, maxLen = 0;
		int j = 0;
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			j = i;
			while (i< str.length() && str.charAt(i) != (char)32 && str.charAt(i) != '\0') {
				count++;
				i++;
			}
			
			if(count >= maxLen)
			{
				maxLen = count;
				index = j;
			}
			count = 0;

		}
		int i = index;
		while (i < index + maxLen ) {
			str1 += str.charAt(i);
			i++;
		}
		return str1;
	}

	public static void main(String[] args) {
		
		StringOperations so = new StringOperations();
		String str1, str2;
		
		do {
			System.out.println(
					"Enter your choice \n1.Compare two Strings\n2.Reverse String\n3.Change the case of characters in String\n4.Print largest word in String\n5.Exit");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			//Compare two Strings 
			case 1:
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter two Strings");
				str1 = sc.nextLine();
				str2 = sc.nextLine();
				System.out.println(so.compareString(str1, str2));
				break;
			// reverse string
			case 2:
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter a String");
				str1 = sc1.nextLine();
				System.out.println(so.reverse(str1));
				break;
                  // String with Case conversion (upper to lower case and lower case into upper case)
			case 3:
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter a String");
				str1 = sc2.nextLine();
				System.out.println(so.changeCaseOfCharacter(str1));
				break;
			// print largest word in String
			case 4:
				System.out.println("Enter a String");
				Scanner sc3 = new Scanner(System.in);
				str1 = sc3.nextLine();
				System.out.println(so.largestWord(str1));
				break;

			case 5:
				System.exit(0);
			default:
				System.out.print("Wrong input");

			}
			scan.close();
		}
		while (true);
	}

}
