public class MathOperations {

	static int common = 0;
	static int flag = 0;

	public int lcm(int a, int b) {

		if (flag == 0) {
			flag = 1;
			if (a < b)
				common = b;
			else
				common = a;
		}

		if (common % a == 0 && common % b == 0) {
			return common;
		}
		common++;
		lcm(a, b);
		flag = 0;
		return common;
	}


	public int hcf(int a, int b) {
		if (a > b) {
			if (b != 0) {
				return hcf(b, a % b);
			} else {
				return a;
			}
		} else {
			if (a != 0) {
				return hcf(a, b % a);
			} else {
				return b;
			}
		}
	}
}
