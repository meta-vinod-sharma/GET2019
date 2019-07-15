/**
 * @author Vinod
 *
 */
public interface Calculator {

	/**
	 * @param s1
	 * @param s2
	 * @return String type
	 */
	String add(String s1, String s2);
	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	String sub(String s1, String s2);
	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	String mul(String s1, String s2);
	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	String div(String s1, String s2);
	/**
	 * @param s1
	 * @param s2
	 * @return Boolean type
	 */
	boolean isEqual(String s1, String s2);
	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	boolean isGreater(String s1, String s2);
	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	boolean isLesser(String s1, String s2);
}
