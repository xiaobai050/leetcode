package pid440;

import java.util.Arrays;

/**
 * 440. K-th Smallest in Lexicographical Order Given integers n and k, find the
 * lexicographically k-th smallest integer in the range from 1 to n.
 * 
 * Note: 1 ¡Ü k ¡Ü n ¡Ü 109.
 * 
 * Example:
 * 
 * Input: n: 13 k: 2
 * 
 * Output: 10
 * 
 * Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6,
 * 7, 8, 9], so the second smallest number is 10.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {

		int[][] testTable = { 
			{2,2},
			{100,10},
			{4289384,
				1922239}
		};

		for (int ito[] : testTable) {
			test(ito);
		}

	}

	private static void test(int[] ito) {

		System.out.print(">> ");
		System.out.print(Arrays.toString(ito));
		System.out.println();

		int n = ito[0];
		int k = ito[1];
		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		Object rtn = solution.findKthNumber(n, k);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println("                              << " + rtn);
		System.out.println("--------------------------------------ºÄÊ±£º" + (end - begin) + "ms");

	}
}
