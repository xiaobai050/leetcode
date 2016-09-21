package pid209;

import java.util.Arrays;

/**
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int num1 = 7;
		int[] ar1 = { 2, 3, 1, 2, 4, 3 };
		test(num1, ar1);

		int num2 = 7;
		int[] ar2 = { 2, 3, 1, 2, 4, 4 };
		test(num2, ar2);

		int num3 = 70;
		int[] ar3 = { 2, 3, 1, 2, 3, 3 };
		test(num3, ar3);
	}

	private static void test(int s, int[] nums) {
		System.out.println(s);
		System.out.println(Arrays.toString(nums));

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		int rtn = solution.minSubArrayLen(s, nums);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println(rtn);
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("--------------");
	}
}
