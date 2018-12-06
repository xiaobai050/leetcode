package pid410;

import java.util.Arrays;

/**
 * Split Array Largest Sum Given an array which consists of non-negative
 * integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among
 * these m subarrays.
 * 
 * Note: Given m satisfies the following constraint: 1 ¡Ü m ¡Ü length(nums) ¡Ü
 * 14,000.
 * 
 * Examples:
 * 
 * Input: nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {

		int[] testTable = {7,2,5,10,8};
		int m=2;
		
			test(testTable,m);
		

	}

	private static void test(int[] ito,int m) {

		
		System.out.print(">> ");
		System.out.print(Arrays.toString(ito)+" m=	" +m);
		System.out.println();

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		Object rtn = solution.splitArray(ito, m);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println("                              << " + rtn);
		System.out.println("--------------------------------------ºÄÊ±£º" + (end - begin) + "ms");

	}
}
