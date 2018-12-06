package me.bai.LeetCode.pid343;

/**
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 =
 * 3 + 3 + 4).
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class Solution {
	int[] table = null;

	public int integerBreak(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;

		table = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i < 4) {
				table[i] = i;
			} else {
				int max = 0;
				for (int j = 2; j <= i / 2; j++) {
					int tmp = table[j] * table[i - j];
					if (max < tmp) {
						max = tmp;
					}
				}
				table[i] = max;
			}
		}
		return table[n];
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		System.out.println(integerBreak(2));
		System.out.println(integerBreak(4));
		System.out.println(integerBreak(10));
	}
}
