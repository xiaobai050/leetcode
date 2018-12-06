package me.bai.LeetCode.pid53;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * @author 白
 *
 */
public class Solution {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0)
			return 0;

		int lastMax = 0;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			lastMax = Math.max(lastMax + num, num);
			max = Math.max(max, lastMax);
		}
		return max;
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(maxSubArray(new int[] { 0 }));
	}
}
