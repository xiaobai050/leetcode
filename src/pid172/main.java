package pid172;

/**
 * Factorial Trailing Zeroes Given an integer n, return the number of trailing
 * zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[] testTable = { 0, 1, 2, 3, 4, 5, 10, 86, 625 };
		for (int ito : testTable) {
			test(ito);
		}
	}

	private static void test(int ito) {
		System.out.println(ito);

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		int rtn = solution.trailingZeroes(ito);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println(rtn);
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("--------------");
	}
}
