package me.bai.LeetCode.pid463;

/**
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 * 
 * Example 1: Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 Explanation: Maximum
 * average is (12-5-6+50)/4 = 51/4 = 12.75 Note: 1 <= k <= n <= 30,000. Elements
 * of the given array will be in the range [-10,000, 10,000].
 */
public class Solution {
	public double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
		int s = 0;
		int max = -1000000;
		for (int i = 0; i < k; i++) {
			s += nums[i];
		}

		for (int i = 0; i < n - k + 1; i++) {

			int tmp = s;
			if (tmp > max) {
				max = tmp;
			}
			if (i == n - k)
				break;
			s -= nums[i];
			s += nums[i + k];

		}
		return (double) max / k;

	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		int[] arr = new int[] { 1, 12, -5, -6, 50, 3 };
		double rtn = findMaxAverage(arr, 4);
		System.out.println(rtn);
	}
}
