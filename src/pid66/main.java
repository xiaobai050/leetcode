package pid66;

import java.util.Arrays;

/**
 * Plus One Given a non-negative number represented as an array of digits, plus
 * one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[][] digitsTable = { 
				{},
				{0},
				{ 1 }, 
				{ 9 }, 
				{ 1, 9 }, 
				{ 2, 9 }, 
				{ 3, 9 }, 
				{ 4, 9 }, 
				{ 5, 9 }, 
				{ 9, 5 }, 
				{ 9, 9 }, 
			};
		for (int[] ito : digitsTable) {
			test(ito);
		}
	}

	private static void test(int[] digits) {
		Solution solution = new Solution();
		int[] rtn = new int[digits.length + 1];

		long begin = System.currentTimeMillis();

		rtn = solution.plusOne(digits);

		long end = System.currentTimeMillis();

		System.out.println(Arrays.toString(rtn));
		System.out.println("ºÄÊ±:" + (end - begin) + "ms");
		System.out.println("------");
	}
}
