package me.bai.LeetCode.pid410;

/**
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 * 
 * Note: If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000 1 ≤ m ≤ min(50, n) Examples:
 * 
 * Input: nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 *
 */
public class Solution {

	public int splitArray(int[] nums, int m) {
		int n = nums.length;
		int[][] maxSum = new int[n + 1][n + 1];

		for (int offset = 1; offset < n + 1; offset++) {
			maxSum[offset][1] = maxSum[offset - 1][1] + nums[offset - 1];
			for (int parts = 2; parts <= m; parts++) {

				int sum = nums[offset - 1];
				int min = max(sum, maxSum[offset - 1][parts - 1]);

				for (int index = offset - 1; index >= parts; index--) {
					if (sum > maxSum[index][parts - 1]) {
						break;
					}
					sum += nums[index - 1];
					min = min(min, max(sum, maxSum[index - 1][parts - 1]));

				}
				maxSum[offset][parts] = min;
			}
		}
		printMaxSum(maxSum);
		return maxSum[n][m];
	}

	private void printMaxSum(int[][] maxSum) {
		for (int i = 1; i < maxSum.length; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(maxSum[i][j] + "	");
			}
			System.out.println();
		}
	}

	private int max(int i, int j) {
		return i > j ? i : j;
	}

	private int min(int i, int j) {
		return i < j ? i : j;
	}

	public static void main(String[] args) {
		test(new int[] { 7, 2, 5, 10, 8 }, 3);
		// test(new int[] { 1, 2, 3 }, 3);
	}

	private static void test(int[] nums, int m) {
		int rtn = new Solution().splitArray(nums, m);
		System.out.println(rtn);
	}

}