package pid179;

import java.util.Arrays;

/**
 * 179. Largest Number Given a list of non negative integers, arrange them such
 * that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[][] testTable = { {3, 30, 34, 5, 9}, };
		for (int[] ito : testTable) {
			test(ito);
		}
	}

	private static void test(int[] ito) {
		System.out.println(Arrays.toString(ito));

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		String rtn = solution.largestNumber(ito);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println(rtn);
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("--------------");
	}
}
