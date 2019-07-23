import java.util.ArrayList;
import java.util.List;

/* This is a component class.
 * This class is implemented to store and evaluate polynomial expressions.
 * @author Vinod
 */
public final class Poly {
	private int expression[];

	public Poly(int array[]) {
		this.expression = Poly.arrangePoly(array);
	}
	
	public int[] getPoly()
	{
		return this.expression;
	}

	/* This method evaluated polynomial.
	 * @param          //value of variable.
	 * @return        //evaluated expression with given value.
	 */
	public float evaluate(float value) {
		Poly polyObj = this;
		int array[] = polyObj.expression;
		double solution = 0;
		for (int i = 0; i < array.length; i = i + 2)
			solution = solution + array[i] * Math.pow(value, array[i + 1]);

		return (float) solution;
	}

	/* This method is used to find degree of a polynomial.
	 * @return        //degree of given polynomial expression.
	 */
	public int degree() {
		int array[] = this.expression;
		int degree = -1;
		for (int i = 1; i < array.length; i = i + 2) {
			if (array[i] > degree)
				degree = array[i];
		}
		return degree;
	}

	/* This method is used to add two polynomial expressions. 
	 * @param poly1    //polynomial expression.
	 * @param poly2    //polynomial expression.
	 * @return       //added  polynomial expression
	 */
	public static Poly addPoly(Poly poly1, Poly poly2) {
		int arrayP1[] = poly1.expression;
		int arrayP2[] = poly2.expression;
		int n = arrayP1.length + arrayP2.length;
		int countP1 = 0, countP2 = 0;

		List<Integer> addedPolyList = new ArrayList<Integer>();

		for (int i = 1; i < n / 2; i++) {
			if (countP1 >= arrayP1.length && countP2 >= arrayP2.length)
				break;
			if (countP1 >= arrayP1.length && countP2 < arrayP2.length) {
				addedPolyList.add(arrayP2[countP2++]);
				addedPolyList.add(arrayP2[countP2++]);
				continue;
			}
			if (countP2 >= arrayP2.length && countP1 < arrayP1.length) {
				addedPolyList.add(arrayP1[countP1++]);
				addedPolyList.add(arrayP1[countP1++]);
				continue;
			}
			if (arrayP1[countP1 + 1] > arrayP2[countP2 + 1]) {
				addedPolyList.add(arrayP1[countP1++]);
				addedPolyList.add(arrayP1[countP1++]);
				continue;
			}
			if (arrayP1[countP1 + 1] < arrayP2[countP2 + 1]) {
				addedPolyList.add(arrayP2[countP2++]);
				addedPolyList.add(arrayP2[countP2++]);
				continue;
			}
			if (arrayP1[countP1 + 1] == arrayP2[countP2 + 1]) {
				addedPolyList.add((arrayP1[countP1++] + arrayP2[countP2++]));
				addedPolyList.add(arrayP1[countP1]);
				countP1++;
				countP2++;
			}
		}
		int addedPoly[] = Poly.listToArray(addedPolyList);
		return new Poly(addedPoly);

	}

	/* This method is used to multiply two polynomial expressions. 
	 * @param poly1     //polynomial expression
	 * @param poly2     // polynomial expression
	 * @return          //multiplied polynomial expression
	 */
	public static Poly multiplyPoly(Poly poly1, Poly poly2) {
		int arrayP1[] = poly1.expression;
		int arrayP2[] = poly2.expression;

		List<Integer> multipliedPolyList = new ArrayList<Integer>();

		for (int i = 0; i < arrayP1.length; i = i + 2) {
			for (int j = 0; j < arrayP2.length; j = j + 2) {
				multipliedPolyList.add(arrayP1[i] * arrayP2[j]);
				multipliedPolyList.add(arrayP1[i + 1] + arrayP2[j]);
			}
		}
		int multipliedPoly[] = Poly.listToArray(multipliedPolyList);
		return new Poly(multipliedPoly);
	}

	
	/* This method is used to convert List to Array of integers.
	 * @param list        // ArrayList.
	 * @return          // integer array.
	 */
	private static int[] listToArray(List<Integer> list) {
		int array[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			array[i] = (int) list.get(i);
		return array;
	}

	private static int[] arrangePoly(int array[]) {
		for (int i = 1; i < array.length; i = i + 2) {
			for (int j = i + 2; j < array.length; j = j + 2) {
				if (array[i] < array[j]) {
					array[i] = array[i] + array[j];
					array[j] = array[i] - array[j];
					array[i] = array[i] - array[j];

					array[i - 1] = array[i - 1] + array[j - 1];
					array[j - 1] = array[i - 1] - array[j - 1];
					array[i - 1] = array[i - 1] - array[j - 1];
				}
			}
		}
		return array;
	}

	// This method displays polynomial expression.
	public void show() {
		Poly p1 = this;

		for (int i = 0; i < p1.expression.length - 1; i = i + 2){
			// : p1.expression)
			System.out.print(p1.expression[i] + " x^" + p1.expression[i + 1]
					+ "  + ");
		}
		System.out.print(p1.expression[p1.expression.length -1] + " x^" + p1.expression[p1.expression.length]);
	}
}
